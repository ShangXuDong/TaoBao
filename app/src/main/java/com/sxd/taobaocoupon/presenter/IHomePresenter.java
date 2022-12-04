package com.sxd.taobaocoupon.presenter;

import com.sxd.taobaocoupon.model.IHomeModel;
import com.sxd.taobaocoupon.view.IHomeViewCallback;

public interface IHomePresenter extends IBasePresenter<IHomeViewCallback, IHomeModel> {

    void getCategories();

}
