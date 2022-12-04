package com.sxd.taobaocoupon.ui.fragment;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.sxd.taobaocoupon.R;
import com.sxd.taobaocoupon.model.entity.Categories;
import com.sxd.taobaocoupon.presenter.IHomePresenter;
import com.sxd.taobaocoupon.presenter.impl.HomePresenterImpl;
import com.sxd.taobaocoupon.ui.activity.MainActivity;
import com.sxd.taobaocoupon.ui.activity.ScanQrCodeActivity;
import com.sxd.taobaocoupon.ui.activity.ScannerCodeActivity;
import com.sxd.taobaocoupon.ui.adapter.HomeCategoryViewPagerAdapter;
import com.sxd.taobaocoupon.view.IHomeViewCallback;

import butterknife.BindView;

public class HomeFragment extends BaseFragment implements IHomeViewCallback {

    @BindView(R.id.scan)
    ImageView scanner;

    @BindView(R.id.search_bar)
    EditText searchBar;

    // 最上面分类的tableLayout
    @BindView(R.id.home_indicator)
    TabLayout mTabLayout;

    // 与tableLayout关联的viewPager
    @BindView(R.id.home_pager)
    ViewPager mCategoryViewPager;

    IHomePresenter mHomePresenter;

    HomeCategoryViewPagerAdapter mHomeCategoryViewPagerAdapter;

    @Override
    protected void onRetryClicked() {
        mHomePresenter.getCategories();
    }

    @Override
    public int getLayoutId() {
        // fragment_home 包含工具栏和内容栏fragment_home_container
        return R.layout.fragment_home_container;
    }

    @Override
    protected int getBaseContainerId() {
        return R.id.home_base_container;
    }

    // baseFragment默认返回的是一个空布局
    // 但是首页HomeFragment，上面要有一个搜索栏，不管下面的数据加载出来没有，所以这里复写loadRootView方法。
    @Override
    protected View loadRootView(LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    protected void initPresenter() {
        mHomePresenter = new HomePresenterImpl(this);
    }

    @Override
    protected void loadData() {
        mHomePresenter.getCategories();
    }

    @Override
    public void onCategoriesLoaded(Categories categories) {
//        Log.e("sxd", this + Thread.currentThread().getName());
        setUpState(State.SUCCESS);
//        // present中回调
//        // 默认多加载1个，可以设置全部加载
        mCategoryViewPager.setOffscreenPageLimit((int) (categories.getData().size() / 2));
        mHomeCategoryViewPagerAdapter.setCategories(categories);
    }

    @Override
    public void onNetworkError() {
        setUpState(State.ERROR);
    }

    @Override
    protected void release() {
        if (mHomePresenter != null) {
            mHomePresenter.unRegisterCallback(this);
            mHomePresenter = null;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    protected void initView() {
        // 这一步之后，tabLayout的一切都由关联的ViewPager控制了。
        mTabLayout.setupWithViewPager(mCategoryViewPager);

        mHomeCategoryViewPagerAdapter = new HomeCategoryViewPagerAdapter(getChildFragmentManager());
        // 给ViewPager设置数据源Adapters
        mCategoryViewPager.setAdapter(mHomeCategoryViewPagerAdapter);
    }

    @Override
    protected void initListener() {
        // 扫码界面
        scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ScanQrCodeActivity.class));
            }
        });

        // 搜索界面
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toSearchFragment();
            }
        });
    }
}