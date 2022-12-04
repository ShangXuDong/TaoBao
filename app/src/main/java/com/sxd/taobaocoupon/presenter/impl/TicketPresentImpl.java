package com.sxd.taobaocoupon.presenter.impl;

import com.sxd.taobaocoupon.model.ITicketModel;
import com.sxd.taobaocoupon.model.impl.TicketModelmpl;
import com.sxd.taobaocoupon.model.network.ITaoBaoAPI;
import com.sxd.taobaocoupon.model.entity.Ticket;
import com.sxd.taobaocoupon.model.entity.TicketParams;
import com.sxd.taobaocoupon.presenter.ITicketPresenter;
import com.sxd.taobaocoupon.view.ITicketViewCallback;



public class TicketPresentImpl implements ITicketPresenter, ITicketModel.CallBack {

    private ITicketViewCallback ticketViewCallback;

    private ITicketModel ticketModel;


    public TicketPresentImpl(ITicketViewCallback ticketViewCallback) {
        this.ticketViewCallback = ticketViewCallback;
        this.ticketModel = new TicketModelmpl(this);
    }

    @Override
    public void registerCallback(ITicketViewCallback callback) {
        ticketViewCallback = callback;
        // 避免数据已经加载完毕，但是UI还没绑定Presenter
    }

    @Override
    public void unRegisterCallback(ITicketViewCallback callback) {

    }

    @Override
    public void registerModel(ITicketModel model) {

    }

    @Override
    public void unRegisterModel(ITicketModel model) {

    }

    @Override
    public void getTicket(String title, String url, String cover) {
        ticketModel.getTicket(title, url, cover);
    }

    @Override
    public void onTicketLoaded(Ticket ticket, String cover, String title) {
       ticketViewCallback.onTicketLoaded(cover, ticket, title);
    }
}
