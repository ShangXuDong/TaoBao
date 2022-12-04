package com.sxd.taobaocoupon.view;

import com.sxd.taobaocoupon.model.entity.Categories;
import com.sxd.taobaocoupon.model.entity.SelectedDetail;

public interface ISelectedViewCallback {

    void onCategoriesLoaded(Categories categories);

    void onSelectedDetailLoaded(SelectedDetail selectedDetail);
}
