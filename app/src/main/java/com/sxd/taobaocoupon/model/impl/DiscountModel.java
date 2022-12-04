package com.sxd.taobaocoupon.model.impl;

import com.sxd.taobaocoupon.component.DaggerNetworkComponent;
import com.sxd.taobaocoupon.model.IDiscountModel;
import com.sxd.taobaocoupon.model.entity.DisCountDetail;
import com.sxd.taobaocoupon.model.network.ITaoBaoAPI;
import com.sxd.taobaocoupon.util.UrlUtils;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class DiscountModel implements IDiscountModel {

    @Inject
    public ITaoBaoAPI mTaoBaoAPI;

    private IDiscountModel.Callback mCallback;

    public DiscountModel(IDiscountModel.Callback callback) {
        mCallback = callback;
        DaggerNetworkComponent.create().inject(this);
    }

    @Override
    public void getDisCount(int pageId) {
        Call<DisCountDetail> task = mTaoBaoAPI.getDisCountDetail(UrlUtils.createDiscountUrl(pageId));
        task.enqueue(new retrofit2.Callback<DisCountDetail>() {
            @Override
            public void onResponse(Call<DisCountDetail> call, Response<DisCountDetail> response) {
                mCallback.onDisCountLoadedSuccess(response.body());
            }

            @Override
            public void onFailure(Call<DisCountDetail> call, Throwable t) {

            }
        });
    }
}
