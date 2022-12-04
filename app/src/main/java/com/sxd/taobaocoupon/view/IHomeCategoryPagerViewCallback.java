package com.sxd.taobaocoupon.view;

import com.sxd.taobaocoupon.model.entity.CategoryDetail;

import java.util.List;

/***
 * Home首页Fragment里面用了一个TabLayout，TabLayout的每一项的ViewPager，我们设置为一个Fragment。
 * 所以对于这个Fragment，我们依旧使用MVP模式。
 */
public interface IHomeCategoryPagerViewCallback {

    void onContentLoaded(List<CategoryDetail.DataBean> contents);

    void onError();

    void onEmpty();

    void onLoading();

    void onLoadedMoreError();

    void onLoadMoreEmpty();

    void onLoadMoreLoaded(List<CategoryDetail.DataBean> contents);

    void onLooperListLoaded(List<CategoryDetail.DataBean> contents);

    int getCategoryId();
}
