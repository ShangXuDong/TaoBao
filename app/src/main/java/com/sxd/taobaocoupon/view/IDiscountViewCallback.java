package com.sxd.taobaocoupon.view;

import com.sxd.taobaocoupon.model.entity.DisCountDetail;

public interface IDiscountViewCallback {

    void onDiscountLoadedSuccess(DisCountDetail disCountDetail);

    void onDiscountLoadmoreSuccess(DisCountDetail disCountDetail);
}
