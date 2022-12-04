package com.sxd.taobaocoupon.model;

import com.sxd.taobaocoupon.model.entity.Categories;
import com.sxd.taobaocoupon.presenter.IHomePresenter;

public interface IHomeModel {

    public void getCategories();

    public interface Callback {

        public void categoriesLoadSuccess(Categories categories);

        public void categoriesLoadFailed();
    }
}
