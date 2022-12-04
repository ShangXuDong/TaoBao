package com.sxd.taobaocoupon.presenter;

import com.sxd.taobaocoupon.model.ICategoryPagerModel;
import com.sxd.taobaocoupon.view.IHomeCategoryPagerViewCallback;

public interface ICategoryPagerPresenter extends IBasePresenter<IHomeCategoryPagerViewCallback, ICategoryPagerModel>{
    void getCategoryById(int categoryId);

    void loadMore(int categoryId);

    void reload(int categoryId);
}
