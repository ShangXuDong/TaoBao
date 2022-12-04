package com.sxd.taobaocoupon.model;

import com.sxd.taobaocoupon.model.entity.Categories;
import com.sxd.taobaocoupon.model.entity.CategoryDetail;
import com.sxd.taobaocoupon.model.entity.SelectedDetail;

public interface ISelectedModel {

    void getCategories();

    void getCategoriesDetail(int categoryId, int pagerId);

    interface CallBack{
        void categoriesLoadSuccess(Categories categories);

        void categoriesLoadFailed();

        void onCategoryDetailLoadSuccess(SelectedDetail selectedDetail);

        void onCategoryDetailLoadFailed();
    };
}
