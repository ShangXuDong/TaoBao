package com.sxd.taobaocoupon.model.network;

import com.sxd.taobaocoupon.model.entity.Categories;
import com.sxd.taobaocoupon.model.entity.CategoryDetail;
import com.sxd.taobaocoupon.model.entity.DisCountDetail;
import com.sxd.taobaocoupon.model.entity.SearchRecommend;
import com.sxd.taobaocoupon.model.entity.SearchResult;
import com.sxd.taobaocoupon.model.entity.SelectedDetail;
import com.sxd.taobaocoupon.model.entity.Ticket;
import com.sxd.taobaocoupon.model.entity.TicketParams;
import com.sxd.taobaocoupon.util.ConstantsUtils;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ITaoBaoAPI {

    @GET(ConstantsUtils.API_DISCOVERY_CATEGORIES)
    Call<Categories> getCategories();

    // 请求的url需要动态生成
    @GET
    Call<CategoryDetail> getCategoryDetail(@Url String url);

    // 请求的url需要动态生成
    @GET
    Call<SelectedDetail> getSelectedDetail(@Url String url);

    @GET // 请求的url需要动态生成
    Call<DisCountDetail> getDisCountDetail(@Url String url);

    @POST(ConstantsUtils.API_GET_TICKET)
    Call<Ticket> getTicket(@Body TicketParams params);

    @GET(ConstantsUtils.API_DO_SEARCH)
    Call<SearchResult> doSearch(@Query("page") int page, @Query("keyword") String keyword);

    @GET(ConstantsUtils.API_GET_SEARCH_RECOMMEND)
    Call<SearchRecommend> getRecommendWords();
}
