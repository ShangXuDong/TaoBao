package com.sxd.taobaocoupon.presenter.impl;

import android.util.Log;

import com.sxd.taobaocoupon.model.ICategoryPagerModel;
import com.sxd.taobaocoupon.model.impl.CategoryPagerModel;
import com.sxd.taobaocoupon.model.entity.CategoryDetail;
import com.sxd.taobaocoupon.presenter.ICategoryPagerPresenter;
import com.sxd.taobaocoupon.util.UrlUtils;
import com.sxd.taobaocoupon.view.IHomeCategoryPagerViewCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryPagerPresenterImpl implements ICategoryPagerPresenter, ICategoryPagerModel.Callback {

    // 多个分类页面Fragment对应这一个presenter，者一个presenter对应一个model
    // 所以，这个Presenter里要保存多个view的信息，同时设置为单例模式提供给外界

    // 每一个分类fragment的list，当前加载到的页码
    private Map<Integer, Integer> pageMap = new HashMap<>();

    // 每一个分类fragment的list，对应的viewCallback
    private Map<Integer, IHomeCategoryPagerViewCallback> callbackMap = new HashMap<>();

    public static final int defaultPage = 1;

    private ICategoryPagerModel mCategoryPagerModel;

    private CategoryPagerPresenterImpl() {
    }

    // 所有的CategoryPager保存一个Presenter
    private static CategoryPagerPresenterImpl singleInstance;

    public static CategoryPagerPresenterImpl getInstance(IHomeCategoryPagerViewCallback homeCategoryPagerViewCallback) {
        if (singleInstance == null)
            singleInstance = new CategoryPagerPresenterImpl();
        singleInstance.registerCallback(homeCategoryPagerViewCallback);
        return singleInstance;
    }

    @Override
    public void registerCallback(IHomeCategoryPagerViewCallback callback) {
        // model对于presneter来说，只要注册一次
        if (mCategoryPagerModel == null)
            registerModel(new CategoryPagerModel(this));
        callbackMap.put(callback.getCategoryId(), callback);
        pageMap.put(callback.getCategoryId(), defaultPage);
    }

    @Override
    public void unRegisterCallback(IHomeCategoryPagerViewCallback callback) {

        callbackMap.remove(callback.getCategoryId());

    }

    @Override
    public void registerModel(ICategoryPagerModel model) {

        mCategoryPagerModel = model;

    }

    @Override
    public void unRegisterModel(ICategoryPagerModel model) {

        mCategoryPagerModel = null;

    }

    @Override
    public void getCategoryById(int categoryId) {

        mCategoryPagerModel.getCategoryDetail(categoryId, defaultPage);

    }

    @Override
    public void loadMore(int categoryId) {

        int nextPage = pageMap.get(categoryId) + 1;

        pageMap.put(categoryId, nextPage);

        mCategoryPagerModel.getCategoryDetail(categoryId, nextPage);

    }

    @Override
    public void reload(int categoryId) {

    }

    @Override
    public void onCategoryDetailLoadSuccess(CategoryDetail categoryDetail, int categoryId) {

        // 一开始我定义的接口，只要传递一个CategoryDetail回来就行了。可以从返回的data里拿到categoryId
        //         int categoryId =UrlUtils.getCategoryIdFromClickUrl(data.get(0).getClick_url());
        // 但是，当返回的CategoryDetail为null的时候，就没办法了，所以改了接口定义。

        if (categoryDetail == null) {
            callbackMap.get(categoryId).onLoadMoreEmpty();
            return;
        }

        List<CategoryDetail.DataBean> data = categoryDetail.getData();
        // 这个回调要通过每一个商品里面的url，切割出来它属于的分类，再通知对应的界面。
        if (pageMap.get(categoryId) == 1) {
            callbackMap.get(categoryId).onLooperListLoaded(data.subList(data.size()-5, data.size()));
            callbackMap.get(categoryId).onContentLoaded(data);
        }else {
            callbackMap.get(categoryId).onLoadMoreLoaded(data);
        }

    }

    @Override
    public void onCategoryDetailLoadFailed() {

    }
}
