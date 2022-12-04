package com.sxd.taobaocoupon.presenter;

import com.sxd.taobaocoupon.model.ISearchModel;
import com.sxd.taobaocoupon.view.ISearchViewCallback;

public interface ISearchPresenter extends IBasePresenter<ISearchModel, ISearchViewCallback>{

    void getHistory();

    void deleteHistory();

    void search(String url);

    void loadMore(String url);

    void getRecommend();
}
