package com.sxd.taobaocoupon.model.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.sxd.taobaocoupon.component.DaggerNetworkComponent;
import com.sxd.taobaocoupon.model.ISearchModel;
import com.sxd.taobaocoupon.model.entity.SearchRecommend;
import com.sxd.taobaocoupon.model.entity.SearchResult;
import com.sxd.taobaocoupon.model.network.ITaoBaoAPI;
import com.sxd.taobaocoupon.ui.BaseApplication;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class SearchModel implements ISearchModel {

    // 历史记录相关
    // 历史记录的SP的KEY，保存在JSONCacheUtil中的创建的SP里。
    private final String SP_KEY_FILE_NAME = "SP_KEY_FILE_NAME";

    private final String SP_KEY_HISTORY = "SP_KEY_HISTORY_";

    private SharedPreferences sp = BaseApplication.APP_CONTEXT.getSharedPreferences(SP_KEY_FILE_NAME, Context.MODE_PRIVATE);

    private Gson gson = new Gson();

    private int maxHistoryNum = 10;

    @Inject
    public ITaoBaoAPI mTaoBaoAPI;

    private ISearchModel.Callback mCallback;

    public SearchModel(ISearchModel.Callback callback) {
        mCallback = callback;
        DaggerNetworkComponent.create().inject(this);
    }

    @Override
    public void getHistory() {
        String historyString = sp.getString(SP_KEY_HISTORY, "");
        // 存在历史记录
        if (historyString.length() != 0) {
            // Gson转换
            ArrayList historyList = gson.fromJson(historyString, ArrayList.class);
            mCallback.onHistoryLoadedSuccess(historyList);
        }
    }

    @Override
    public void deleteHistory() {
        sp.edit().remove(SP_KEY_HISTORY).apply();
    }

    @Override
    public void search(int pageId, String key) {
        // search的时候，肯定要保存历史记录
        saveHistory(key);
        Call<SearchResult> task = mTaoBaoAPI.doSearch(pageId, key);

        task.enqueue(new retrofit2.Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                mCallback.onSearchSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
            }
        });
    }

    private void saveHistory(String key) {
        // 这里内容简单，所以使用一个SharedReference来保存
        // 这里把所有的历史记录文本，放到一个list里
        String historyListString = sp.getString(SP_KEY_HISTORY, "");
        ArrayList historyList = null;
        // 以前不存在历史记录 添加并结束
        if (historyListString.length() == 0) {
            historyList = new ArrayList();
            historyList.add(key);
        } else {
            historyList = gson.fromJson(historyListString, ArrayList.class);
            if (historyList.contains(key)) {
                historyList.remove(key);
            } else {
                if (historyList.size() == maxHistoryNum) {
                    historyList.remove(maxHistoryNum - 1);
                }
            }
            historyList.add(0, key);
            // 重新生成gson字符串，并保存
        }
        sp.edit().putString(SP_KEY_HISTORY, gson.toJson(historyList)).apply();
    }

    @Override
    public void getRecommend() {
        Call<SearchRecommend> task = mTaoBaoAPI.getRecommendWords();
        task.enqueue(new retrofit2.Callback<SearchRecommend>() {
            @Override
            public void onResponse(Call<SearchRecommend> call, Response<SearchRecommend> response) {

                mCallback.onSearchRecommend(response.body());
            }

            @Override
            public void onFailure(Call<SearchRecommend> call, Throwable t) {

            }
        });
    }
}
