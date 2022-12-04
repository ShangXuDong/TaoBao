package com.sxd.taobaocoupon.ui.fragment;

import android.graphics.Rect;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sxd.taobaocoupon.R;
import com.sxd.taobaocoupon.model.entity.Categories;
import com.sxd.taobaocoupon.model.entity.SelectedDetail;
import com.sxd.taobaocoupon.presenter.ISelectedPresenter;
import com.sxd.taobaocoupon.presenter.impl.SelectedPresenter;
import com.sxd.taobaocoupon.ui.adapter.SelectedPageLeftAdapter;
import com.sxd.taobaocoupon.ui.adapter.SelectedPageRightContentAdapter;
import com.sxd.taobaocoupon.view.ISelectedViewCallback;

import butterknife.BindView;

public class SelectedFragment extends BaseFragment implements ISelectedViewCallback {


    @BindView(R.id.left_category_list)
    RecyclerView left_category_list;

    @BindView(R.id.right_content_list)
    RecyclerView right_content_list;

    // 左侧adapter
    SelectedPageLeftAdapter left_category_list_adapter;

    // 右侧Adapter
    SelectedPageRightContentAdapter selectedPageRightContentAdapter;

    ISelectedPresenter mSelectedPresenter;

    @Override
    protected View loadRootView(LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(R.layout.fragment_with_bar_layout, container, false);
    }

    // 要不要修改对应base container id 要看后面，主要是所有的base_container 一个id 感觉不太好
//    @Override
//    protected int getBaseContainerId() {
//        return super.getBaseContainerId();
//    }

    @Override
    int getLayoutId() {
        return R.layout.fragment_selected_container;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onCategoriesLoaded(Categories categories) {
        left_category_list_adapter.setData(categories);
        left_category_list_adapter.notifyDataSetChanged();

        setUpState(State.SUCCESS);

        // 请求右侧第一个数据
        int firstCategoryId = categories.getData().get(0).getId();
        mSelectedPresenter.getCategoryById(firstCategoryId);
    }

    @Override
    public void onSelectedDetailLoaded(SelectedDetail selectedDetail) {
        selectedPageRightContentAdapter.setData(selectedDetail);
        right_content_list.scrollToPosition(0);
    }

    @Override
    protected void initView() {
        left_category_list_adapter = new SelectedPageLeftAdapter();
        left_category_list.setLayoutManager(new LinearLayoutManager(getContext()));
        left_category_list.setAdapter(left_category_list_adapter);

        selectedPageRightContentAdapter = new SelectedPageRightContentAdapter();
        right_content_list.setLayoutManager(new LinearLayoutManager(getContext()));
//        right_content_list.addItemDecoration(new RecyclerView.ItemDecoration() {
//            @Override
//            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//                outRect.top = 6;
//                outRect.bottom = 6;
//            }
//        });
        right_content_list.setAdapter(selectedPageRightContentAdapter);
    }

    @Override
    protected void initListener() {
        left_category_list_adapter.setItemClickListener(new SelectedPageLeftAdapter.ItemClickListener() {
            @Override
            public void onClick(int id) {
                mSelectedPresenter.getCategoryById(id);
            }
        });
    }

    @Override
    protected void initPresenter() {
        mSelectedPresenter = new SelectedPresenter(this);
    }

    @Override
    protected void loadData() {
        mSelectedPresenter.getCategories();
    }
}
