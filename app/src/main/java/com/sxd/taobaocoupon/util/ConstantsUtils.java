package com.sxd.taobaocoupon.util;

public class ConstantsUtils {

    // 淘口令API的Base地址
    public static final String BASE_URL = "https://api.sunofbeaches.com/shop/";

    // 每一个分类Fragment创建的时候，用setArgument传递分类的title和id，下面这两个是在bundle中放数据和取数据的key
    public static final String KEY_HOME_PAGE_CATEGORY_TITLE = "KEY_HOME_PAGE_CATEGORY_TITLE";
    public static final String KEY_HOME_PAGE_CATEGORY_ID = "KEY_HOME_PAGE_CATEGORY_ID";

    // startTicketActivity需要使用intent传递一些数据，比如优惠券的title，优惠券的图片cover url，优惠券的url
    // 这里保存对应key
    public static final String KEY_INTENT_TICKET_COVER = "KEY_INTENT_TICKET_COVER";
    public static final String KEY_INTENT_TICKET_URL = "KEY_INTENT_TICKET_URL";
    public static final String KEY_INTENT_TICKET_TITLE = "KEY_INTENT_TICKET_TITLE";

    // API相关
    // 发现所有分类
    public static final String API_DISCOVERY_CATEGORIES = "discovery/categories";
    // 获得淘口令
    public static final String API_GET_TICKET = "tpwd";
    // 搜索关键词
    public static final String API_DO_SEARCH= "search";
    // 获取推荐搜索关键词
    public static final String API_GET_SEARCH_RECOMMEND= "search/recommend";

}
