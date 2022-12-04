package com.sxd.taobaocoupon.presenter.impl;

import com.sxd.taobaocoupon.model.IDiscountModel;
import com.sxd.taobaocoupon.model.entity.DisCountDetail;
import com.sxd.taobaocoupon.model.impl.DiscountModel;
import com.sxd.taobaocoupon.presenter.IDiscountPresenter;
import com.sxd.taobaocoupon.view.IDiscountViewCallback;

public class DiscountPresenter implements IDiscountPresenter, IDiscountModel.Callback {

    private int nowPage = 1;

    private final int FIRST_PAGE = 1;

    private IDiscountViewCallback mCallback;

    private IDiscountModel iDiscountModel;

    public DiscountPresenter(IDiscountViewCallback callback) {
        registerCallback(callback);
        iDiscountModel = new DiscountModel(this);
    }

    @Override
    public void onDisCountLoadedSuccess(DisCountDetail disCountDetail) {
        // 根据当前页码，判断是第一次加载，还是下拉加载更多
        if (nowPage == FIRST_PAGE)
            mCallback.onDiscountLoadedSuccess(disCountDetail);
        else
            mCallback.onDiscountLoadmoreSuccess(disCountDetail);
    }

    @Override
    public void registerCallback(IDiscountViewCallback callback) {
        mCallback = callback;
    }

    @Override
    public void unRegisterCallback(IDiscountViewCallback callback) {
        mCallback = null;
    }

    @Override
    public void registerModel(IDiscountModel model) {

    }

    @Override
    public void unRegisterModel(IDiscountModel model) {

    }

    @Override
    public void getDisCount() {
        iDiscountModel.getDisCount(nowPage);
    }

    public void getMoreDiscount() {
        iDiscountModel.getDisCount(++nowPage);
    }
}
