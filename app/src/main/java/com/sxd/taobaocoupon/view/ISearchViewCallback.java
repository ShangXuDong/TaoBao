package com.sxd.taobaocoupon.view;

import com.sxd.taobaocoupon.model.entity.SearchRecommend;
import com.sxd.taobaocoupon.model.entity.SearchResult;

import java.util.List;

public interface ISearchViewCallback {

    void onHistoryLoadedSuccess(List<String> history);

    void onSearchSuccess(SearchResult result);

    void onSearchLoadedMoreSuccess(SearchResult result);

    void onSearchRecommend(SearchRecommend recommend);
}
