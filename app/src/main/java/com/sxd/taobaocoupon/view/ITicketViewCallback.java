package com.sxd.taobaocoupon.view;

import com.sxd.taobaocoupon.model.entity.Ticket;

public interface ITicketViewCallback {

    // 加载淘口令界面，需要商品图片的URL和一个TicketResult（里面有淘口令）
    void onTicketLoaded(String cover, Ticket ticketResult, String title);
}
