package com.sxd.taobaocoupon.ui.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.sxd.taobaocoupon.R;
import com.sxd.taobaocoupon.model.entity.DisCountDetail;
import com.sxd.taobaocoupon.presenter.IDiscountPresenter;
import com.sxd.taobaocoupon.presenter.impl.DiscountPresenter;
import com.sxd.taobaocoupon.presenter.impl.TicketPresentImpl;
import com.sxd.taobaocoupon.ui.activity.TicketActivity;
import com.sxd.taobaocoupon.ui.adapter.DiscountAdapter;
import com.sxd.taobaocoupon.util.ConstantsUtils;
import com.sxd.taobaocoupon.view.IDiscountViewCallback;

import org.w3c.dom.Text;

import butterknife.BindView;

public class DiscountFragment extends BaseFragment implements IDiscountViewCallback {

    @BindView(R.id.discount_refresh_list)
    public SmartRefreshLayout discountRefreshList;

    @BindView(R.id.discount_list)
    public RecyclerView discountList;

    private DiscountAdapter discountAdapter;

    private IDiscountPresenter mDiscountPresenter;

    public DiscountFragment() {
        mDiscountPresenter = new DiscountPresenter(this);
    }

    @Override
    int getLayoutId() {
        return R.layout.fragment_discount_container;
    }

    @Override
    protected View loadRootView(LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_with_bar_layout,container,false);
        ((TextView)view.findViewById(R.id.fragment_bar_title_tv)).setText("特惠");
        return view;
    }

    @Override
    public void onDiscountLoadedSuccess(DisCountDetail disCountDetail) {
        discountAdapter.setData(disCountDetail.getData().getTbk_dg_optimus_material_response().getResult_list().getMap_data());
    }

    // 加载更多，那就需要刷新了。
    @Override
    public void onDiscountLoadmoreSuccess(DisCountDetail disCountDetail) {

        // 给recycle List增加数据
        discountAdapter.addData(disCountDetail.getData().getTbk_dg_optimus_material_response().getResult_list().getMap_data());
        // 加载成功取消加载状态
        discountRefreshList.finishLoadMore();
    }

    @Override
    protected void initView() {

        discountAdapter = new DiscountAdapter();
        discountList.setAdapter(discountAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        discountList.setLayoutManager(gridLayoutManager);

        // 禁止上拉刷新
        discountRefreshList.setEnableRefresh(false);

    }

    @Override
    protected void initListener() {
        // 监听下拉加载更多事件
        discountRefreshList.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mDiscountPresenter.getMoreDiscount();
            }
        });

        // 设置disCount列表的点击事件
        discountAdapter.setItemClickListener(new DiscountAdapter.DiscountItemClickListener() {
            @Override
            public void onDiscountItemClickClicked(DisCountDetail.DataBean.TbkDgOptimusMaterialResponseBean.ResultListBean.MapDataBean daicountData) {
                // 数据在这里回来了
                // 那么就直接跳转到TicketActivity
                String title= daicountData.getTitle();
                String url = daicountData.getCoupon_click_url();
                String cover = daicountData.getPict_url();

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
        // 加载第一个特惠页面的内容
        mDiscountPresenter.getDisCount();
        setUpState(State.SUCCESS);
    }
}
