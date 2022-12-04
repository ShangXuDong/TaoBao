package com.sxd.taobaocoupon.presenter.impl;

import android.util.Log;

import com.sxd.taobaocoupon.model.ISearchModel;
import com.sxd.taobaocoupon.model.entity.SearchRecommend;
import com.sxd.taobaocoupon.model.entity.SearchResult;
import com.sxd.taobaocoupon.model.impl.SearchModel;
import com.sxd.taobaocoupon.presenter.ISearchPresenter;
import com.sxd.taobaocoupon.view.ISearchViewCallback;

import java.util.List;

public class SearchPresenter implements ISearchPresenter, ISearchModel.Callback {

    private  final int DEFAULT_PAGE_ID = 1;

    private int nowPageId = DEFAULT_PAGE_ID;

    private ISearchViewCallback mCallback;

    private ISearchModel searchModel;

    public SearchPresenter(ISearchViewCallback callback) {
        mCallback = callback;
        searchModel = new SearchModel(this);
    }

    @Override
    public void onHistoryLoadedSuccess(List<String> history) {
        mCallback.onHistoryLoadedSuccess(history);
    }

    @Override
    public void onDeleteHistorySuccess() {
    }

    @Override
    public void onSearchSuccess(SearchResult result) {
        // 搜索成功，根据此时的页码，判断，是第一次搜索，还是加载更多
        if (nowPageId == DEFAULT_PAGE_ID) {
            mCallback.onSearchSuccess(result);
        }
        else {
            mCallback.onSearchLoadedMoreSuccess(result);
        }
    }

    @Override
    public void onSearchRecommend(SearchRecommend recommend) {
        mCallback.onSearchRecommend(recommend);
    }

    @Override
    public void registerCallback(ISearchModel callback) {

    }

    @Override
    public void unRegisterCallback(ISearchModel callback) {

    }

    @Override
    public void registerModel(ISearchViewCallback model) {

    }

    @Override
    public void unRegisterModel(ISearchViewCallback model) {

    }

    @Override
    public void getHistory() {
        searchModel.getHistory();
    }

    @Override
    public void deleteHistory() {
        searchModel.deleteHistory();
    }


    @Override
    public void search(String key) {
        // 恢复默认页码
        nowPageId = DEFAULT_PAGE_ID;
        searchModel.search(nowPageId, key);
    }

    @Override
    public void loadMore(String key) {
        ++nowPageId;
        searchModel.search(nowPageId, key);
    }

    @Override
    public void getRecommend() {
        searchModel.getRecommend();
    }
}
