package com.sxd.taobaocoupon.model;

import com.sxd.taobaocoupon.model.entity.CategoryDetail;

public interface ICategoryPagerModel {

    public void getCategoryDetail(int categoryId, int pagerId);

    public interface Callback {

        public void onCategoryDetailLoadSuccess(CategoryDetail categoryDetail, int categaryId);

        public void onCategoryDetailLoadFailed();
    }
}
