package com.sxd.taobaocoupon.presenter;

import com.sxd.taobaocoupon.model.ISelectedModel;
import com.sxd.taobaocoupon.view.ISelectedViewCallback;

public interface ISelectedPresenter extends IBasePresenter<ISelectedViewCallback, ISelectedModel>{

    void getCategories();

    void getCategoryById(int categoryId);

}
