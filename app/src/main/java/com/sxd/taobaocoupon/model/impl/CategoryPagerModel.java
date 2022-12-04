package com.sxd.taobaocoupon.model.impl;

import com.sxd.taobaocoupon.component.DaggerNetworkComponent;
import com.sxd.taobaocoupon.model.ICategoryPagerModel;
import com.sxd.taobaocoupon.model.entity.CategoryDetail;
import com.sxd.taobaocoupon.model.network.ITaoBaoAPI;
import com.sxd.taobaocoupon.util.UrlUtils;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class CategoryPagerModel implements ICategoryPagerModel {

    @Inject
    public ITaoBaoAPI mTaoBaoAPI;

    private Callback mCallback;

    public CategoryPagerModel(Callback callback) {
        mCallback = callback;
        DaggerNetworkComponent.create().inject(this);
    }

    @Override
    public void getCategoryDetail(int categoryId, int pagerId) {
        // 动态生成url
        Call<CategoryDetail> task = mTaoBaoAPI.getCategoryDetail(UrlUtils.createCategoryDetailUrl(categoryId, pagerId));
        task.enqueue(new retrofit2.Callback<CategoryDetail>() {
            @Override
            public void onResponse(Call<CategoryDetail> call, Response<CategoryDetail> response) {
                CategoryDetail result = response.body();
                mCallback.onCategoryDetailLoadSuccess(result, categoryId);
            }

            @Override
            public void onFailure(Call<CategoryDetail> call, Throwable t) {
                mCallback.onCategoryDetailLoadFailed();
            }
        });
    }
}
