package com.sxd.taobaocoupon.util;

public class UrlUtils {

    public static String createCategoryDetailUrl(int materialId, int page) {
        return "discovery/" + materialId + "/" + page;
    }

    public static String createCoverUrl(String pict_url) {
        return "https:" + pict_url;
    }

    /***
     * 根据宝贝返回的东西，从中得到其所属的分类id
     * @return
     */
    public static int getCategoryIdFromClickUrl (String clickUrl) {
        String beginString = "floorId:";
        int beginIndex = clickUrl.indexOf(beginString);
        String endString = ";originalFloorId";
        int endIndex = clickUrl.indexOf(endString);
        return Integer.parseInt(clickUrl.substring(beginIndex + beginString.length(), endIndex));
    }

    public static String createDiscountUrl(int page) {
        return "onSell/" + page;
    }
}
