package com.sxd.taobaocoupon.ui.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.ScrollBoundaryDecider;
import com.sxd.taobaocoupon.R;
import com.sxd.taobaocoupon.model.entity.Categories;
import com.sxd.taobaocoupon.model.entity.CategoryDetail;
import com.sxd.taobaocoupon.presenter.ICategoryPagerPresenter;
import com.sxd.taobaocoupon.presenter.impl.CategoryPagerPresenterImpl;
import com.sxd.taobaocoupon.ui.activity.TicketActivity;
import com.sxd.taobaocoupon.ui.adapter.HomeCategoryViewPagerListViewAdapter;
import com.sxd.taobaocoupon.ui.adapter.LooperAdapter;
import com.sxd.taobaocoupon.ui.custom.AutoLoopViewPager;
import com.sxd.taobaocoupon.ui.custom.ShopNestedScrollView;
import com.sxd.taobaocoupon.util.ConstantsUtils;
import com.sxd.taobaocoupon.util.SizeUtils;
import com.sxd.taobaocoupon.view.IHomeCategoryPagerViewCallback;

import java.util.List;

import butterknife.BindView;

public class HomeCategoryPagerFragment extends BaseFragment implements IHomeCategoryPagerViewCallback {

    @BindView(R.id.home_pager_list)
    public RecyclerView categoryDetailRecycleList;

    @BindView(R.id.looper_pager)
    public AutoLoopViewPager looperPager;

    @BindView(R.id.tv_home_pager_title)
    public TextView catetoryTitleTextView;

    @BindView(R.id.home_category_pager_refresh_list)
    SmartRefreshLayout categoryRefreshLayout;

    @BindView(R.id.home_pager_title)
    LinearLayout title;

    @BindView(R.id.category_pager_parent)
    LinearLayout pagerParent;

    @BindView(R.id.scrollView)
    ShopNestedScrollView nestedScrollView;

    @BindView(R.id.looper_and_title)
    LinearLayout looperAndTitle;

    ICategoryPagerPresenter mPagerPresenter;

    // 一个分类对应TabLayout的一项，对一个一个ViewPager，通过FragmentPagerAdapter对应一个Fragment。
    int categoryId;

    HomeCategoryViewPagerListViewAdapter mHomeCategotyViewPagerListAdapter;

    LooperAdapter mLooperAdapter;

    boolean dataLoaded = false;

    public static HomeCategoryPagerFragment newInstance(Categories.DataBean category) {
        HomeCategoryPagerFragment homePagerFragment = new HomeCategoryPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ConstantsUtils.KEY_HOME_PAGE_CATEGORY_TITLE, category.getTitle());
        bundle.putInt(ConstantsUtils.KEY_HOME_PAGE_CATEGORY_ID, category.getId());
        homePagerFragment.setArguments(bundle);
        return homePagerFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Fragment可见，开启Looper的轮播
        looperPager.startAutoLoop();
    }

    @Override
    public void onPause() {
        super.onPause();
        // TabLayout 切换分类页面 会触发onPause
        looperPager.stopAutoLoop();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    int getLayoutId() {
        return R.layout.fragment_home_category_pager;
    }

    @Override
    protected void initView() {

        Bundle arguments = getArguments();

        categoryId = arguments.getInt(ConstantsUtils.KEY_HOME_PAGE_CATEGORY_ID);

        categoryDetailRecycleList.setLayoutManager(new LinearLayoutManager(getContext()));
        categoryDetailRecycleList.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.top = 6;
                outRect.bottom = 6;
            }
        });
        mHomeCategotyViewPagerListAdapter = new HomeCategoryViewPagerListViewAdapter();
        categoryDetailRecycleList.setAdapter(mHomeCategotyViewPagerListAdapter);

        mLooperAdapter = new LooperAdapter();
        looperPager.setAdapter(mLooperAdapter);

        // 设置refreshLayout 不让它能够刷新
        categoryRefreshLayout.setEnableRefresh(false);
        setUpState(State.SUCCESS);
    }

    @Override
    protected void initListener() {

        nestedScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int measuredHeight = nestedScrollView.getMeasuredHeight();
                nestedScrollView.setHeaderHeight(looperAndTitle.getMeasuredHeight());
                // getLayoutParams -1 -2 表示match_parent wrap_content 或者是具体的值
                ViewGroup.LayoutParams layoutParams = categoryDetailRecycleList.getLayoutParams();
                if (layoutParams.height == -1 || layoutParams.height == -2) {
                    layoutParams.height = measuredHeight;
                    categoryDetailRecycleList.setLayoutParams(layoutParams);
                    nestedScrollView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
//                Log.e("sxd", "layout监听事件");
            }
        });

        catetoryTitleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("sxd", categoryDetailRecycleList.getMeasuredHeight() + "");
                Log.e("sxd", categoryDetailRecycleList.getHeight() + "");
            }
        });
        looperPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int size = mLooperAdapter.getDataSize();
                updateLooperIndicator(position % size);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        categoryRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPagerPresenter.loadMore(getCategoryId());
            }
        });

        categoryRefreshLayout.setScrollBoundaryDecider(new ScrollBoundaryDecider() {
            @Override
            public boolean canRefresh(View content) {
                return false;
            }

            @Override
            public boolean canLoadMore(View content) {
                //
//                if mHomeCategotyViewPagerListAdapter.
                ShopNestedScrollView v = (ShopNestedScrollView) content;

                RecyclerView recyclerView = (RecyclerView) ((LinearLayout)v.getChildAt(0)).getChildAt(1);


                int scrollRange = recyclerView.computeVerticalScrollRange(); // 14336
                int scrollOffset = recyclerView.computeVerticalScrollOffset(); // 不断增大
                int height = recyclerView.getHeight(); // 1888
                Log.e("sxd", recyclerView.computeVerticalScrollRange() +"");
                Log.e("sxd", recyclerView.computeVerticalScrollOffset() +"");

                // 到达底部
                if (scrollRange <= (scrollOffset + height))
                    return true;

                return false;
            }
        });


        // 给list设置点击事件，跳转到对应淘口令Activity
        mHomeCategotyViewPagerListAdapter.setOnItemClickListener(new HomeCategoryViewPagerListViewAdapter.onListItemClickedListener() {
            @Override
            public void onItemClick(CategoryDetail.DataBean item) {
                Log.e("sxd", "啊哈");
                handleItemClicked(item);
            }
        });

        // 给Looper设置事件
        mLooperAdapter.setOnItemClickListener(new LooperAdapter.onLooperClickedListener() {
            @Override
            public void onItemClick(CategoryDetail.DataBean item) {

                handleItemClicked(item);
            }
        });

    }

    private void updateLooperIndicator(int targetPosition) {
        for (int i = 0; i < looperPointContainer.getChildCount(); i++) {
            View point = looperPointContainer.getChildAt(i);
            if (i == targetPosition)
                point.setBackgroundResource(R.drawable.shape_indicator_selected_bg);
            else
                point.setBackgroundResource(R.drawable.shape_indicator_normal_bg);
        }
    }

    @Override
    protected void loadData() {
        setUpState(State.LOADING);
        mPagerPresenter.getCategoryById(categoryId);
        catetoryTitleTextView.setText(getArguments().getString(ConstantsUtils.KEY_HOME_PAGE_CATEGORY_TITLE));
        setUpState(State.SUCCESS);
    }

    @Override
    protected void initPresenter() {
        mPagerPresenter = CategoryPagerPresenterImpl.getInstance(this);
        mPagerPresenter.registerCallback(this);
    }


    @Override
    public void onContentLoaded(List<CategoryDetail.DataBean> contents) {
        mHomeCategotyViewPagerListAdapter.setData(contents);
        // 加载完数据，设置Title可见性
        setTitleVisiable();
    }

    private void setTitleVisiable() {
        if (dataLoaded == false) {
            title.setVisibility(View.VISIBLE);
            dataLoaded = true;
        }
    }

    @Override
    public void onError() {

    }

    @Override
    public void onEmpty() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onLoadedMoreError() {

    }

    @Override
    public void onLoadMoreEmpty() {
        // 加载更多为null 那么就停止加载状态并且设置为不可加载更多
        categoryRefreshLayout.finishLoadMore();
        categoryRefreshLayout.setEnableLoadMore(false);
        Toast.makeText(getContext(), "没有更多宝贝!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoadMoreLoaded(List<CategoryDetail.DataBean> contents) {
        // 这里contents有可能为null，就是有的分类，并没有那么多商品可供选择
        Log.e("sxd", contents + "");
        mHomeCategotyViewPagerListAdapter.addData(contents);
        categoryRefreshLayout.finishLoadMore();

    }

    @BindView(R.id.looper_point_container)
    LinearLayout looperPointContainer;

    @Override
    public void onLooperListLoaded(List<CategoryDetail.DataBean> contents) {

        mLooperAdapter.setData(contents);
        looperPager.setCurrentItem((contents.size() * 2));
        int i = 0;
        for (CategoryDetail.DataBean content : contents) {
            View point = new View(getContext());
            int size = SizeUtils.dip2px(getContext(), 8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(size, size);
            layoutParams.leftMargin = SizeUtils.dip2px(getContext(), 5);
            layoutParams.rightMargin = SizeUtils.dip2px(getContext(), 5);
            point.setLayoutParams(layoutParams);

            if (i++ == 0)
                point.setBackgroundResource(R.drawable.shape_indicator_selected_bg);
            else
                point.setBackgroundResource(R.drawable.shape_indicator_normal_bg);

            looperPointContainer.addView(point);
        }
    }


    @Override
    public int getCategoryId() {
        return categoryId;
    }

    private void handleItemClicked(CategoryDetail.DataBean item) {
        String title = item.getTitle();
        String url = item.getCoupon_click_url();
        String cover = item.getPict_url();

        Intent intent = new Intent(getActivity(), TicketActivity.class);
        intent.putExtra(ConstantsUtils.KEY_INTENT_TICKET_TITLE, title);
        intent.putExtra(ConstantsUtils.KEY_INTENT_TICKET_COVER, cover);
        intent.putExtra(ConstantsUtils.KEY_INTENT_TICKET_URL, url);
        startActivity(intent);
    }
}