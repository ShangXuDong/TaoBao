package com.sxd.taobaocoupon.presenter;

import com.sxd.taobaocoupon.model.ITicketModel;
import com.sxd.taobaocoupon.view.ITicketViewCallback;

public interface ITicketPresenter extends IBasePresenter<ITicketViewCallback, ITicketModel>{

    void getTicket(String title, String url, String cover);
}
