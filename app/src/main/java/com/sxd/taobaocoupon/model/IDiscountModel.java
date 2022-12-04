package com.sxd.taobaocoupon.model;

import com.sxd.taobaocoupon.model.entity.DisCountDetail;

public interface IDiscountModel {

    void getDisCount(int pageId);

    interface Callback {
        void onDisCountLoadedSuccess(DisCountDetail disCountDetail);
    }
}
