package com.sxd.taobaocoupon.model;

import com.sxd.taobaocoupon.model.entity.Ticket;

public interface ITicketModel {

    // 获得优惠券，必须要一个优惠券的url
    void getTicket(String title, String url, String cover);

    interface CallBack{
        void onTicketLoaded(Ticket ticket, String cover, String title);
    }
}
