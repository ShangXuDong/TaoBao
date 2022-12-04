package com.sxd.taobaocoupon.model.impl;

import android.util.Log;

import com.sxd.taobaocoupon.component.DaggerNetworkComponent;
import com.sxd.taobaocoupon.model.ITicketModel;
import com.sxd.taobaocoupon.model.entity.Ticket;
import com.sxd.taobaocoupon.model.entity.TicketParams;
import com.sxd.taobaocoupon.model.network.ITaoBaoAPI;

import java.net.HttpURLConnection;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketModelmpl implements ITicketModel {

    @Inject
    public ITaoBaoAPI mTaoBaoAPI;

    public ITicketModel.CallBack mCallBack;

    public TicketModelmpl(ITicketModel.CallBack callBack) {
        mCallBack = callBack;
        DaggerNetworkComponent.create().inject(this);
    }

    @Override
    public void getTicket(String title, String url, String cover) {
        Log.e("sxd", "model " + url);
        String targetUrl = "";
        if (url.contains("http"))
            targetUrl = url;
        else
            targetUrl = "https:" + url;
        Call<Ticket> task = mTaoBaoAPI.getTicket(new TicketParams(targetUrl, title));

        task.enqueue(new Callback<Ticket>() {
            @Override
            public void onResponse(Call<Ticket> call, Response<Ticket> response) {
                int code = response.code();
                if (code == HttpURLConnection.HTTP_OK) {
                    mCallBack.onTicketLoaded(response.body(), cover, title);
                }
            }

            @Override
            public void onFailure(Call<Ticket> call, Throwable t) {

            }
        });
    }
}
