package com.sxd.taobaocoupon.presenter.impl;

import com.sxd.taobaocoupon.model.IHomeModel;
import com.sxd.taobaocoupon.model.impl.HomeModel;
import com.sxd.taobaocoupon.model.entity.Categories;
import com.sxd.taobaocoupon.presenter.IHomePresenter;
import com.sxd.taobaocoupon.view.IHomeViewCallback;

public class HomePresenterImpl implements IHomePresenter, IHomeModel.Callback {

    private IHomeViewCallback mHomeViewCallback;

    private IHomeModel mHomeModel;

    public HomePresenterImpl(IHomeViewCallback iHomeViewCallback){
        registerCallback(iHomeViewCallback);
        registerModel(new HomeModel(this));
    }

    @Override
    public void getCategories() {
        mHomeModel.getCategories();
    }

    @Override
    public void registerCallback(IHomeViewCallback iHomeViewCallback) {
        mHomeViewCallback = iHomeViewCallback;
    }

    @Override
    public void unRegisterCallback(IHomeViewCallback iHomeViewCallback) {
        mHomeViewCallback = null;
    }

    @Override
    public void registerModel(IHomeModel model) {
        mHomeModel = model;
    }

    @Override
    public void unRegisterModel(IHomeModel model) {
        mHomeModel = null;
    }

    @Override
    public void categoriesLoadSuccess(Categories categories) {
//        Log.e("sxd", this + Thread.currentThread().getName());
        mHomeViewCallback.onCategoriesLoaded(categories);
    }

    @Override
    public void categoriesLoadFailed() {
        mHomeViewCallback.onNetworkError();
    }
}
