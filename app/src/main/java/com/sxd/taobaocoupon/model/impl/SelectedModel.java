package com.sxd.taobaocoupon.model.impl;

import android.util.Log;

import com.sxd.taobaocoupon.component.DaggerNetworkComponent;
import com.sxd.taobaocoupon.model.ISelectedModel;
import com.sxd.taobaocoupon.model.entity.Categories;
import com.sxd.taobaocoupon.model.entity.CategoryDetail;
import com.sxd.taobaocoupon.model.entity.SelectedDetail;
import com.sxd.taobaocoupon.model.network.ITaoBaoAPI;
import com.sxd.taobaocoupon.util.UrlUtils;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class SelectedModel implements ISelectedModel {

    @Inject
    public ITaoBaoAPI mTaoBaoAPI;

    public CallBack mCallBack;

    public SelectedModel(CallBack callBack) {
        mCallBack = callBack;
        DaggerNetworkComponent.create().inject(this);
    }

    // 其实和分类一样，不过分类中，保留的是前6项 精选保留后5项
    @Override
    public void getCategories() {
        Call<Categories> task = mTaoBaoAPI.getCategories();
        task.enqueue(new retrofit2.Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                Categories categories = response.body();
                categories.setData(categories.getData().subList(6, 11));

                mCallBack.categoriesLoadSuccess(categories);
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                mCallBack.categoriesLoadFailed();
            }
        });
    }

    @Override
    public void getCategoriesDetail(int categoryId, int pagerId) {
        Call<SelectedDetail> task = mTaoBaoAPI.getSelectedDetail(UrlUtils.createCategoryDetailUrl(categoryId, pagerId));
        task.enqueue(new retrofit2.Callback<SelectedDetail>() {
            @Override
            public void onResponse(Call<SelectedDetail> call, Response<SelectedDetail> response) {
                SelectedDetail result = response.body();
                mCallBack.onCategoryDetailLoadSuccess(result);
            }

            @Override
            public void onFailure(Call<SelectedDetail> call, Throwable t) {
                mCallBack.onCategoryDetailLoadFailed();
            }
        });
    }
}
