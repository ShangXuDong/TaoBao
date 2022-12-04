package com.sxd.taobaocoupon.model.impl;

import com.sxd.taobaocoupon.component.DaggerNetworkComponent;
import com.sxd.taobaocoupon.model.IHomeModel;
import com.sxd.taobaocoupon.model.entity.Categories;
import com.sxd.taobaocoupon.model.network.ITaoBaoAPI;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeModel implements IHomeModel {

    @Inject
    public ITaoBaoAPI mTaoBaoAPI;

    private Callback mCallback;

    public HomeModel(Callback callback) {
        mCallback = callback;
        DaggerNetworkComponent.create().inject(this);

    }

    @Override
    public void getCategories() {
        Call<Categories> task = mTaoBaoAPI.getCategories();
        task.enqueue(new retrofit2.Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                Categories categories = response.body();

                // 很奇怪，为啥这个回调方法，自动就在主线程执行
//                Log.e("sxd", this + Thread.currentThread().getName());
                categories.setData(categories.getData().subList(0, 6));
                mCallback.categoriesLoadSuccess(categories);
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                mCallback.categoriesLoadFailed();
            }
        });

    }
}
