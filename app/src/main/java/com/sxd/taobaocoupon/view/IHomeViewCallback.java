package com.sxd.taobaocoupon.view;

import com.sxd.taobaocoupon.model.entity.Categories;

public interface IHomeViewCallback {
    void onCategoriesLoaded(Categories categories);

    void onNetworkError();
}
