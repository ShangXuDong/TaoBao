package com.sxd.taobaocoupon.component;

import com.sxd.taobaocoupon.model.impl.CategoryPagerModel;
import com.sxd.taobaocoupon.model.impl.DiscountModel;
import com.sxd.taobaocoupon.model.impl.HomeModel;
import com.sxd.taobaocoupon.model.impl.SearchModel;
import com.sxd.taobaocoupon.model.impl.SelectedModel;
import com.sxd.taobaocoupon.model.impl.TicketModelmpl;
import com.sxd.taobaocoupon.model.network.TaoBaoModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {TaoBaoModule.class,})
@Singleton
public interface NetworkComponent {

    void inject(HomeModel homeModel);

    void inject(CategoryPagerModel categoryPagerModel);

    void inject(SelectedModel selectedModel);

    void inject(DiscountModel disCountModel);

    void inject(SearchModel searchModel);

    void inject(TicketModelmpl ticketModel);
}
