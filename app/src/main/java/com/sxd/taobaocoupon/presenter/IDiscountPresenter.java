package com.sxd.taobaocoupon.presenter;

import com.sxd.taobaocoupon.model.IDiscountModel;
import com.sxd.taobaocoupon.view.IDiscountViewCallback;

public interface IDiscountPresenter extends IBasePresenter<IDiscountViewCallback, IDiscountModel>{

    void getDisCount();

    void getMoreDiscount();
}
