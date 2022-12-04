package com.sxd.taobaocoupon.model;

import com.sxd.taobaocoupon.model.entity.SearchRecommend;
import com.sxd.taobaocoupon.model.entity.SearchResult;

import java.util.List;

public interface ISearchModel {

    void getHistory();

    void deleteHistory();

    void search(int pageId, String url);

    void getRecommend();


    interface Callback{

        void onHistoryLoadedSuccess(List<String> history);

        void onDeleteHistorySuccess();

        void onSearchSuccess(SearchResult result);

        void onSearchRecommend(SearchRecommend recommend);

    }
}
