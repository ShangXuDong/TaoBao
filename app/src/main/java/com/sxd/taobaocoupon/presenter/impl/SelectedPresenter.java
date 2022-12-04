package com.sxd.taobaocoupon.presenter.impl;


import com.sxd.taobaocoupon.model.ISelectedModel;
import com.sxd.taobaocoupon.model.entity.Categories;
import com.sxd.taobaocoupon.model.entity.SelectedDetail;
import com.sxd.taobaocoupon.model.impl.SelectedModel;
import com.sxd.taobaocoupon.presenter.ISelectedPresenter;
import com.sxd.taobaocoupon.view.ISelectedViewCallback;

public class SelectedPresenter implements ISelectedPresenter, ISelectedModel.CallBack {

    private ISelectedViewCallback mCallback;

    private ISelectedModel mModel;

    public SelectedPresenter(ISelectedViewCallback iSelectedViewCallback) {
        mCallback = iSelectedViewCallback;
        mModel = new SelectedModel(this);
    }

    @Override
    public void registerCallback(ISelectedViewCallback callback) {

    }

    @Override
    public void unRegisterCallback(ISelectedViewCallback callback) {

    }

    @Override
    public void registerModel(ISelectedModel model) {

    }

    @Override
    public void unRegisterModel(ISelectedModel model) {

    }

    @Override
    public void getCategories() {
        mModel.getCategories();
    }

    @Override
    public void getCategoryById(int categoryId) {
        mModel.getCategoriesDetail(categoryId, 1);
    }

    @Override
    public void categoriesLoadSuccess(Categories categories) {
        mCallback.onCategoriesLoaded(categories);
    }

    @Override
    public void categoriesLoadFailed() {
    }

    @Override
    public void onCategoryDetailLoadSuccess(SelectedDetail selectedDetail) {
        mCallback.onSelectedDetailLoaded(selectedDetail);

    }

    @Override
    public void onCategoryDetailLoadFailed() {

    }
}
