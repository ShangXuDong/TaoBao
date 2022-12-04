package com.sxd.taobaocoupon.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.sxd.taobaocoupon.R;
import com.sxd.taobaocoupon.model.entity.SearchRecommend;
import com.sxd.taobaocoupon.model.entity.SearchResult;
import com.sxd.taobaocoupon.presenter.ISearchPresenter;
import com.sxd.taobaocoupon.presenter.impl.SearchPresenter;
import com.sxd.taobaocoupon.ui.activity.TicketActivity;
import com.sxd.taobaocoupon.ui.adapter.SearchResultAdapter;
import com.sxd.taobaocoupon.ui.custom.TextFlowLayout;
import com.sxd.taobaocoupon.util.ConstantsUtils;
import com.sxd.taobaocoupon.view.ISearchViewCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SearchFragment extends BaseFragment implements ISearchViewCallback {

    @BindView(R.id.cancel_btn)
    TextView cancel_btn;

    @BindView(R.id.search_input_box)
    EditText search_input_box;

    @BindView(R.id.search_history_view)
    TextFlowLayout hostoryTextFlow;

    @BindView(R.id.search_recommend_view)
    TextFlowLayout recommendTextFlow;

    @BindView(R.id.search_result_container)
    SmartRefreshLayout resultRefreshLayout;

    @BindView(R.id.search_result_list)
    RecyclerView searchResultList;

    // 历史记录删除 按钮
    @BindView(R.id.search_history_delete)
    ImageView historyDeleteBtn;

    // 历史记录Layout
    @BindView(R.id.search_history_container)
    LinearLayout historyLayout;

    // 推荐关键字Layout
    @BindView(R.id.search_recommend_container)
    LinearLayout recommnedLayout;

    SearchResultAdapter searchResultAdapter;

    private ISearchPresenter searchPresenter;

    public SearchFragment() {
        searchPresenter = new SearchPresenter(this);
    }

    @Override
    protected View loadRootView(LayoutInflater inflater, @Nullable ViewGroup container) {
        return LayoutInflater.from(getContext()).inflate(R.layout.fragment_search, container, false);
    }

    @Override
    int getLayoutId() {
        return R.layout.fragment_search_container;
    }

    @Override
    protected void initView() {
        searchResultAdapter = new SearchResultAdapter();
        searchResultList.setLayoutManager(new LinearLayoutManager(getContext()));
        searchResultList.setAdapter(searchResultAdapter);
        searchResultList.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.top = 6;
                outRect.bottom = 6;
            }
        });

        // 禁止头部刷新
        resultRefreshLayout.setEnableRefresh(false);
        // 一开始RecycleView里面都没有东西，甚至没有显示，当然不能刷新。
        resultRefreshLayout.setEnableLoadMore(false);
    }

    @Override
    protected void initListener() {
        // 取消按钮事件
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recommnedLayout.getVisibility() == View.GONE) {
                    // 此时界面显示的是搜索结果
                    // 重新拉取历史记录
                    searchPresenter.getHistory();
                    // 重新获取推荐词
                    searchPresenter.getRecommend();
                    // 隐藏结果
                    searchResultList.setVisibility(View.GONE);
                    // 禁止刷新
                    resultRefreshLayout.setEnableLoadMore(false);
                    // 显示热门推荐和历史记录
                    historyLayout.setVisibility(View.VISIBLE);
                    recommnedLayout.setVisibility(View.VISIBLE);
                } else {
                    // 清空
                    search_input_box.setText("");
                    // 收起键盘
                    InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    // 隐藏软键盘
                    imm.hideSoftInputFromWindow(cancel_btn.getWindowToken(),0);
                }
            }
        });

        // 搜索框事件
        search_input_box.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
                    // 搜索
                    // 空的搜索框就不用管了，直接return
                    if (v.getText().toString().length() == 0)
                        return true;
                    searchPresenter.search(v.getText().toString());
                    InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    // 隐藏软键盘
                    imm.hideSoftInputFromWindow(cancel_btn.getWindowToken(),0);
                    return true;
                }
                return false;
            }
        });

        // 历史记录清空事件
        historyDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchPresenter.deleteHistory();
                hostoryTextFlow.setTextList(null);
            }
        });

        // 加载更多事件
        resultRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                // 这里有一个问题，就是有时候用户是通过点击历史记录 发起搜索的
                // 所以在对应地方，我们要
                searchPresenter.loadMore(search_input_box.getText().toString());
            }
        });

        // 给TextFlowLayout中item设置点击事件
        // 进行搜索
        hostoryTextFlow.setItemClickListener(new TextFlowLayout.ItemClickListener() {
            @Override
            public void onClick(String key) {
                search_input_box.setText(key);
                searchPresenter.search(key);
            }
        });

        recommendTextFlow.setItemClickListener(new TextFlowLayout.ItemClickListener() {
            @Override
            public void onClick(String key) {
                search_input_box.setText(key);
                searchPresenter.search(key);
            }
        });


        // 设置搜索结果点击事件 跳转到淘口令界面
        searchResultAdapter.setItemListener(new SearchResultAdapter.ClickedListener() {
            @Override
            public void onItemClicked(String title, String url, String cover) {
                Intent intent = new Intent(getActivity(), TicketActivity.class);
                intent.putExtra(ConstantsUtils.KEY_INTENT_TICKET_TITLE, title);
                intent.putExtra(ConstantsUtils.KEY_INTENT_TICKET_COVER, cover);
                intent.putExtra(ConstantsUtils.KEY_INTENT_TICKET_URL, url);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {
        searchPresenter.getHistory();
        searchPresenter.getRecommend();
        setUpState(State.SUCCESS);
    }


    @Override
    public void onHistoryLoadedSuccess(List<String> history) {
        hostoryTextFlow.setTextList(history);
    }


    @Override
    public void onSearchSuccess(SearchResult result) {
        // 搜索完毕 隐藏历史记录和热门搜索
        historyLayout.setVisibility(View.GONE);
        recommnedLayout.setVisibility(View.GONE);
        searchResultAdapter.setData(result.getData());
        searchResultList.setVisibility(View.VISIBLE);
        // 可以刷新
        resultRefreshLayout.setEnableLoadMore(true);
    }

    @Override
    public void onSearchLoadedMoreSuccess(SearchResult result) {
        // 通知adapter局部刷新
        searchResultAdapter.addData(result.getData());
        // 停止刷新
        resultRefreshLayout.finishLoadMore();
    }


    @Override
    public void onSearchRecommend(SearchRecommend recommend) {
        List<String> recommendKeys = new ArrayList<>();
        for (SearchRecommend.DataBean datum : recommend.getData()) {
            recommendKeys.add(datum.getKeyword());
        }
        recommendTextFlow.setTextList(recommendKeys);
    }
}
