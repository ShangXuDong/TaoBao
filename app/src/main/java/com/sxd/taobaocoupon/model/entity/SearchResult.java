package com.sxd.taobaocoupon.model.entity;

import java.util.List;

public class SearchResult {
    /**
     * success : true
     * code : 10000
     * message : 搜索成功.
     * data : {"tbk_dg_material_optional_response":{"result_list":{"map_data":[{"category_id":50002928,"category_name":"其它元器件","commission_rate":"135","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"692686680737","item_url":"https://item.taobao.com/item.htm?id=692686680737","level_one_category_id":50024099,"level_one_category_name":"电子元器件市场","nick":"泉州禾灿贸易有限公司","num_iid":"692686680737","pict_url":"https://img.alicdn.com/bao/uploaded/i4/1979500453/O1CN01v7eVZY1FDWDGwVWFW_!!1979500453.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"浙江 台州","real_post_fee":"0.00","reserve_price":"8250","seller_id":4793168816102206594,"shop_dsr":0,"shop_title":"泉州禾灿贸易有限公司","short_title":"","small_images":null,"superior_brand":"0","title":"议价计数器H5CX-ADSAD-NA H7CX-AWD1-N H7CXLNA/--N H7CX-A4WSD-N","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DKkFK97mlqBUcQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7XkXnlp39%2FNAsjMEy53tpIrfL6sMC8HxRBc58XKo76w%2FnL5rxbQnVg50IYULNg46oBA%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=1OewoyvMQwpocTnKFowW4VknjKTkotYyx9g4ueR5LF7DSDfldAqRDKToXL6AZhGsD0BTgZHTrg9csbWeBXP0DfpOPJcsUXcYe8Iu2iW34BuH&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75e7%4001","user_type":0,"volume":0,"white_image":"","x_id":"1OewoyvMQwpocTnKFowW4VknjKTkotYyx9g4ueR5LF7DSDfldAqRDKToXL6AZhGsD0BTgZHTrg9csbWeBXP0DfpOPJcsUXcYe8Iu2iW34BuH","zk_final_price":"8250"},{"category_id":50006522,"category_name":"电机/马达","commission_rate":"135","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"682949298903","item_url":"https://item.taobao.com/item.htm?id=682949298903","level_one_category_id":50024099,"level_one_category_name":"电子元器件市场","nick":"宏泰电气工控配件批发","num_iid":"682949298903","pict_url":"https://img.alicdn.com/bao/uploaded/i1/110753882/O1CN017fMrbB1eY0IxeYZ7u_!!110753882.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"上海","real_post_fee":"0.00","reserve_price":"5408","seller_id":9218329109665465,"shop_dsr":50000,"shop_title":"宏泰电气工控配件批发","short_title":"安川g / adm / d / vd b原装有伺服","small_images":null,"superior_brand":"0","title":"安伺服/-SGADSGDB10AB1YASKAWA/0ADSAD-川G/ADM/D/VD B原装有包装","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3D%2FtaJcjZjCu4cQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7XnLiUdIwG0p5GwOFoWBFNBxRZ%2FGlYeckMgJIYuQD4B5xzr0319rAhWOxg5p7bh%2BFbQ%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=5nkfC3wE3hP0tfnovMSBnXHa14gz7wdMtzCjG7USmFIuuIpVzJgtjTAeY25aLL5zTiX3kJWMVidG2GXY2kai14VTZb2maK7zobmFx3qcCBiT&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75e8%4001","user_type":0,"volume":0,"white_image":"","x_id":"5nkfC3wE3hP0tfnovMSBnXHa14gz7wdMtzCjG7USmFIuuIpVzJgtjTAeY25aLL5zTiX3kJWMVidG2GXY2kai14VTZb2maK7zobmFx3qcCBiT","zk_final_price":"5408"},{"category_id":50002928,"category_name":"其它元器件","commission_rate":"135","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"691949960790","item_url":"https://item.taobao.com/item.htm?id=691949960790","level_one_category_id":50024099,"level_one_category_name":"电子元器件市场","nick":"进口五金机电设备","num_iid":"691949960790","pict_url":"https://img.alicdn.com/bao/uploaded/i1/47777797/O1CN01MLTKsw27T4umgKgJ0_!!47777797.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"浙江 台州","real_post_fee":"0.00","reserve_price":"825","seller_id":10273853829831296,"shop_dsr":0,"shop_title":"进口五金机电设备","short_title":"","small_images":null,"superior_brand":"0","title":"议价计数器H5CX-ADSAD-NA H7CX-AWD1-N H7CXLNA/--N H7CX-A4WSD-N","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DjZ0viaCChqocQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7XmLceuyVFzHmLR%2BCu%2FxyDNyy%2B5EM3XBtNHjM7YyINweHVINgCELUUjKxiXvDf8DaRs%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=3I3Wh3dWOEjORCyneTU6shwwd8YNfWYkqggGNOfhWg0sv68Q9u9XvEBR0dntRhKomd9HNXbzfbqciBVIGHYkWo0ltdOyKZYSg68rjvo5O8jP&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75e9%4001","user_type":0,"volume":0,"white_image":"","x_id":"3I3Wh3dWOEjORCyneTU6shwwd8YNfWYkqggGNOfhWg0sv68Q9u9XvEBR0dntRhKomd9HNXbzfbqciBVIGHYkWo0ltdOyKZYSg68rjvo5O8jP","zk_final_price":"825"},{"category_id":50002928,"category_name":"其它元器件","commission_rate":"135","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"693771255591","item_url":"https://item.taobao.com/item.htm?id=693771255591","level_one_category_id":50024099,"level_one_category_name":"电子元器件市场","nick":"植物批发零售","num_iid":"693771255591","pict_url":"https://img.alicdn.com/bao/uploaded/i4/769625707/O1CN01cVMGwC1s1r8sRRGTC_!!769625707.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"浙江 台州","real_post_fee":"3.00","reserve_price":"825","seller_id":226518241772795050,"shop_dsr":0,"shop_title":"植物批发零售","short_title":"","small_images":null,"superior_brand":"0","title":"议价 计数器H5CX-ADSAD-NA H7CX-AWD1-N H7CXLNA/--N H7CX-A4WSD-","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DgV4s5CU6zvccQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7XnzvkEGs0dLrGD5q%2BtADfYMUQtoXXjFhC6%2F1ZuaIdu1ETr0319rAhWOxg5p7bh%2BFbQ%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=4h5BzU6qkQej98WeoIlVSeN2Q5At1gqZK2p36xIvUzJcul4yYuPOh6AZ9hIWhY0mcYZGuKm0JuD0yFEi9ncY0lbm7FCZyxHdnO7LlRxjcR6h&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75ea%4001","user_type":0,"volume":0,"white_image":"","x_id":"4h5BzU6qkQej98WeoIlVSeN2Q5At1gqZK2p36xIvUzJcul4yYuPOh6AZ9hIWhY0mcYZGuKm0JuD0yFEi9ncY0lbm7FCZyxHdnO7LlRxjcR6h","zk_final_price":"825"},{"category_id":50002928,"category_name":"其它元器件","commission_rate":"135","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"690828376254","item_url":"https://item.taobao.com/item.htm?id=690828376254","level_one_category_id":50024099,"level_one_category_name":"电子元器件市场","nick":"亿达工控自动化设备","num_iid":"690828376254","pict_url":"https://img.alicdn.com/bao/uploaded/i4/3881847752/O1CN01CFZtX7278T5mNwTxo_!!3881847752.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"江苏 南京","real_post_fee":"0.00","reserve_price":"660","seller_id":4656722025845450274,"shop_dsr":48888,"shop_title":"亿达工控自动化设备","short_title":"","small_images":null,"superior_brand":"0","title":"计数器H5CX-ADSAD-NA H7CX-AWD1-N H7CXLNA/--N H7CX-A4WSD-N","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DQsz9EJqVBuEcQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7Xn%2BkgGiFz2u86G%2BmAzoxOMCz6tlAlt58yHYFKBlGt%2FDNL5rxbQnVg50IYULNg46oBA%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=3zkTqDcS69DBilO2fxP9IDHdXUJyMD8CHugQKfgpvnWawmtDMtJpmexCPwKbOnEtqYdOXUdSw02s5VSgEpszA6kZaMh3GK4h7nlxmRq2ZqkI&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75eb%4001","user_type":0,"volume":0,"white_image":"","x_id":"3zkTqDcS69DBilO2fxP9IDHdXUJyMD8CHugQKfgpvnWawmtDMtJpmexCPwKbOnEtqYdOXUdSw02s5VSgEpszA6kZaMh3GK4h7nlxmRq2ZqkI","zk_final_price":"660"},{"category_id":50018920,"category_name":"USB多功能数码宝","commission_rate":"5400","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"675820561702","item_url":"https://item.taobao.com/item.htm?id=675820561702","level_one_category_id":50008090,"level_one_category_name":"3C数码配件","nick":"崔回来吧的小店","num_iid":"675820561702","pict_url":"https://img.alicdn.com/bao/uploaded/i2/2212357570350/O1CN01Xifmrp1PpCudQLGqO_!!2212818601889-0-picasso.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"江苏 苏州","real_post_fee":"0.00","reserve_price":"14","seller_id":4694123551994757272,"shop_dsr":50000,"shop_title":"崔回来吧的小店","short_title":"22正品森奥频闪报警器sm22mm蜂鸣器","small_images":{"string":["https://img.alicdn.com/i2/2212357570350/O1CN01XECwiJ1PpCujoeLf3_!!2212818601889-0-picasso.jpg","https://img.alicdn.com/i2/2212357570350/O1CN01tECrzP1PpCudZSLIz_!!2212818601889-0-picasso.jpg","https://img.alicdn.com/i2/2212357570350/O1CN01zbphll1PpCuhswZHY_!!2212818601889-0-picasso.jpg"]},"superior_brand":"0","title":"22。正品  森奥 频闪 报警器SM22mm 闪光蜂鸣器 ADSAD1616-/31 -","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DZsYfc2EHY48cQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7Xmg3mDEkQMN0PQlUcKJOVKwwJiy2uHk1r6JihxR%2FF9gB0nQoX91N4l2PuUKMILxyTw%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=7pVFR3A4UaQFuvf3jCz7JrYP96e8px5wsh1Ouj5a7hZa8MxZBtl40BZMKYwGfd6zxmwcuatgOr1IbUu36B86bXCtQ8p16rlrfBzW5eMDHyGp&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75ec%4001","user_type":0,"volume":0,"white_image":"","x_id":"7pVFR3A4UaQFuvf3jCz7JrYP96e8px5wsh1Ouj5a7hZa8MxZBtl40BZMKYwGfd6zxmwcuatgOr1IbUu36B86bXCtQ8p16rlrfBzW5eMDHyGp","zk_final_price":"14"},{"category_id":121412015,"category_name":"档案盒","commission_rate":"45","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"693263683389","item_url":"https://detail.tmall.com/item.htm?id=693263683389","level_one_category_id":50018004,"level_one_category_name":"文具电教/文化用品/商务用品","nick":"丝密尔旗舰店","num_iid":"693263683389","pict_url":"https://img.alicdn.com/bao/uploaded/i4/2206519191556/O1CN01uHyBJT1NMh4XbiDKZ_!!2-item_pic.png","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"安徽 合肥","real_post_fee":"0.00","reserve_price":"10","seller_id":81311644391730832,"shop_dsr":47555,"shop_title":"丝密尔旗舰店","short_title":"","small_images":null,"superior_brand":"0","title":"adsad","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DWMqoT7Odb9kcQipKwQzePOeEDrYVVa64r4ll3HtqqoxyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7XmtmpXWXPecfcstZkCQcaw4NKnYlgoy56ql9ZiCXxuPWEnQoX91N4l2PuUKMILxyTw%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=4VjCA8yUCsxsFl0MnHdDF78nVHk3UdhZspxsUXSltAxGugGf5A9gimYCJdaIytCrX9adqEWfpAnttvyr8KgjBJ4054OWkf97Kn4kz1rfLKsG&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75ed%4001","user_type":1,"volume":0,"white_image":"","x_id":"4VjCA8yUCsxsFl0MnHdDF78nVHk3UdhZspxsUXSltAxGugGf5A9gimYCJdaIytCrX9adqEWfpAnttvyr8KgjBJ4054OWkf97Kn4kz1rfLKsG","zk_final_price":"10"}]},"total_results":7,"request_id":"15sh2i92gocty"}}
     */
    private boolean success;
    private int code;
    private String message;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * tbk_dg_material_optional_response : {"result_list":{"map_data":[{"category_id":50002928,"category_name":"其它元器件","commission_rate":"135","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"692686680737","item_url":"https://item.taobao.com/item.htm?id=692686680737","level_one_category_id":50024099,"level_one_category_name":"电子元器件市场","nick":"泉州禾灿贸易有限公司","num_iid":"692686680737","pict_url":"https://img.alicdn.com/bao/uploaded/i4/1979500453/O1CN01v7eVZY1FDWDGwVWFW_!!1979500453.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"浙江 台州","real_post_fee":"0.00","reserve_price":"8250","seller_id":4793168816102206594,"shop_dsr":0,"shop_title":"泉州禾灿贸易有限公司","short_title":"","small_images":null,"superior_brand":"0","title":"议价计数器H5CX-ADSAD-NA H7CX-AWD1-N H7CXLNA/--N H7CX-A4WSD-N","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DKkFK97mlqBUcQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7XkXnlp39%2FNAsjMEy53tpIrfL6sMC8HxRBc58XKo76w%2FnL5rxbQnVg50IYULNg46oBA%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=1OewoyvMQwpocTnKFowW4VknjKTkotYyx9g4ueR5LF7DSDfldAqRDKToXL6AZhGsD0BTgZHTrg9csbWeBXP0DfpOPJcsUXcYe8Iu2iW34BuH&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75e7%4001","user_type":0,"volume":0,"white_image":"","x_id":"1OewoyvMQwpocTnKFowW4VknjKTkotYyx9g4ueR5LF7DSDfldAqRDKToXL6AZhGsD0BTgZHTrg9csbWeBXP0DfpOPJcsUXcYe8Iu2iW34BuH","zk_final_price":"8250"},{"category_id":50006522,"category_name":"电机/马达","commission_rate":"135","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"682949298903","item_url":"https://item.taobao.com/item.htm?id=682949298903","level_one_category_id":50024099,"level_one_category_name":"电子元器件市场","nick":"宏泰电气工控配件批发","num_iid":"682949298903","pict_url":"https://img.alicdn.com/bao/uploaded/i1/110753882/O1CN017fMrbB1eY0IxeYZ7u_!!110753882.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"上海","real_post_fee":"0.00","reserve_price":"5408","seller_id":9218329109665465,"shop_dsr":50000,"shop_title":"宏泰电气工控配件批发","short_title":"安川g / adm / d / vd b原装有伺服","small_images":null,"superior_brand":"0","title":"安伺服/-SGADSGDB10AB1YASKAWA/0ADSAD-川G/ADM/D/VD B原装有包装","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3D%2FtaJcjZjCu4cQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7XnLiUdIwG0p5GwOFoWBFNBxRZ%2FGlYeckMgJIYuQD4B5xzr0319rAhWOxg5p7bh%2BFbQ%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=5nkfC3wE3hP0tfnovMSBnXHa14gz7wdMtzCjG7USmFIuuIpVzJgtjTAeY25aLL5zTiX3kJWMVidG2GXY2kai14VTZb2maK7zobmFx3qcCBiT&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75e8%4001","user_type":0,"volume":0,"white_image":"","x_id":"5nkfC3wE3hP0tfnovMSBnXHa14gz7wdMtzCjG7USmFIuuIpVzJgtjTAeY25aLL5zTiX3kJWMVidG2GXY2kai14VTZb2maK7zobmFx3qcCBiT","zk_final_price":"5408"},{"category_id":50002928,"category_name":"其它元器件","commission_rate":"135","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"691949960790","item_url":"https://item.taobao.com/item.htm?id=691949960790","level_one_category_id":50024099,"level_one_category_name":"电子元器件市场","nick":"进口五金机电设备","num_iid":"691949960790","pict_url":"https://img.alicdn.com/bao/uploaded/i1/47777797/O1CN01MLTKsw27T4umgKgJ0_!!47777797.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"浙江 台州","real_post_fee":"0.00","reserve_price":"825","seller_id":10273853829831296,"shop_dsr":0,"shop_title":"进口五金机电设备","short_title":"","small_images":null,"superior_brand":"0","title":"议价计数器H5CX-ADSAD-NA H7CX-AWD1-N H7CXLNA/--N H7CX-A4WSD-N","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DjZ0viaCChqocQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7XmLceuyVFzHmLR%2BCu%2FxyDNyy%2B5EM3XBtNHjM7YyINweHVINgCELUUjKxiXvDf8DaRs%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=3I3Wh3dWOEjORCyneTU6shwwd8YNfWYkqggGNOfhWg0sv68Q9u9XvEBR0dntRhKomd9HNXbzfbqciBVIGHYkWo0ltdOyKZYSg68rjvo5O8jP&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75e9%4001","user_type":0,"volume":0,"white_image":"","x_id":"3I3Wh3dWOEjORCyneTU6shwwd8YNfWYkqggGNOfhWg0sv68Q9u9XvEBR0dntRhKomd9HNXbzfbqciBVIGHYkWo0ltdOyKZYSg68rjvo5O8jP","zk_final_price":"825"},{"category_id":50002928,"category_name":"其它元器件","commission_rate":"135","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"693771255591","item_url":"https://item.taobao.com/item.htm?id=693771255591","level_one_category_id":50024099,"level_one_category_name":"电子元器件市场","nick":"植物批发零售","num_iid":"693771255591","pict_url":"https://img.alicdn.com/bao/uploaded/i4/769625707/O1CN01cVMGwC1s1r8sRRGTC_!!769625707.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"浙江 台州","real_post_fee":"3.00","reserve_price":"825","seller_id":226518241772795050,"shop_dsr":0,"shop_title":"植物批发零售","short_title":"","small_images":null,"superior_brand":"0","title":"议价 计数器H5CX-ADSAD-NA H7CX-AWD1-N H7CXLNA/--N H7CX-A4WSD-","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DgV4s5CU6zvccQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7XnzvkEGs0dLrGD5q%2BtADfYMUQtoXXjFhC6%2F1ZuaIdu1ETr0319rAhWOxg5p7bh%2BFbQ%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=4h5BzU6qkQej98WeoIlVSeN2Q5At1gqZK2p36xIvUzJcul4yYuPOh6AZ9hIWhY0mcYZGuKm0JuD0yFEi9ncY0lbm7FCZyxHdnO7LlRxjcR6h&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75ea%4001","user_type":0,"volume":0,"white_image":"","x_id":"4h5BzU6qkQej98WeoIlVSeN2Q5At1gqZK2p36xIvUzJcul4yYuPOh6AZ9hIWhY0mcYZGuKm0JuD0yFEi9ncY0lbm7FCZyxHdnO7LlRxjcR6h","zk_final_price":"825"},{"category_id":50002928,"category_name":"其它元器件","commission_rate":"135","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"690828376254","item_url":"https://item.taobao.com/item.htm?id=690828376254","level_one_category_id":50024099,"level_one_category_name":"电子元器件市场","nick":"亿达工控自动化设备","num_iid":"690828376254","pict_url":"https://img.alicdn.com/bao/uploaded/i4/3881847752/O1CN01CFZtX7278T5mNwTxo_!!3881847752.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"江苏 南京","real_post_fee":"0.00","reserve_price":"660","seller_id":4656722025845450274,"shop_dsr":48888,"shop_title":"亿达工控自动化设备","short_title":"","small_images":null,"superior_brand":"0","title":"计数器H5CX-ADSAD-NA H7CX-AWD1-N H7CXLNA/--N H7CX-A4WSD-N","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DQsz9EJqVBuEcQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7Xn%2BkgGiFz2u86G%2BmAzoxOMCz6tlAlt58yHYFKBlGt%2FDNL5rxbQnVg50IYULNg46oBA%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=3zkTqDcS69DBilO2fxP9IDHdXUJyMD8CHugQKfgpvnWawmtDMtJpmexCPwKbOnEtqYdOXUdSw02s5VSgEpszA6kZaMh3GK4h7nlxmRq2ZqkI&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75eb%4001","user_type":0,"volume":0,"white_image":"","x_id":"3zkTqDcS69DBilO2fxP9IDHdXUJyMD8CHugQKfgpvnWawmtDMtJpmexCPwKbOnEtqYdOXUdSw02s5VSgEpszA6kZaMh3GK4h7nlxmRq2ZqkI","zk_final_price":"660"},{"category_id":50018920,"category_name":"USB多功能数码宝","commission_rate":"5400","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"675820561702","item_url":"https://item.taobao.com/item.htm?id=675820561702","level_one_category_id":50008090,"level_one_category_name":"3C数码配件","nick":"崔回来吧的小店","num_iid":"675820561702","pict_url":"https://img.alicdn.com/bao/uploaded/i2/2212357570350/O1CN01Xifmrp1PpCudQLGqO_!!2212818601889-0-picasso.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"江苏 苏州","real_post_fee":"0.00","reserve_price":"14","seller_id":4694123551994757272,"shop_dsr":50000,"shop_title":"崔回来吧的小店","short_title":"22正品森奥频闪报警器sm22mm蜂鸣器","small_images":{"string":["https://img.alicdn.com/i2/2212357570350/O1CN01XECwiJ1PpCujoeLf3_!!2212818601889-0-picasso.jpg","https://img.alicdn.com/i2/2212357570350/O1CN01tECrzP1PpCudZSLIz_!!2212818601889-0-picasso.jpg","https://img.alicdn.com/i2/2212357570350/O1CN01zbphll1PpCuhswZHY_!!2212818601889-0-picasso.jpg"]},"superior_brand":"0","title":"22。正品  森奥 频闪 报警器SM22mm 闪光蜂鸣器 ADSAD1616-/31 -","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DZsYfc2EHY48cQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7Xmg3mDEkQMN0PQlUcKJOVKwwJiy2uHk1r6JihxR%2FF9gB0nQoX91N4l2PuUKMILxyTw%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=7pVFR3A4UaQFuvf3jCz7JrYP96e8px5wsh1Ouj5a7hZa8MxZBtl40BZMKYwGfd6zxmwcuatgOr1IbUu36B86bXCtQ8p16rlrfBzW5eMDHyGp&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75ec%4001","user_type":0,"volume":0,"white_image":"","x_id":"7pVFR3A4UaQFuvf3jCz7JrYP96e8px5wsh1Ouj5a7hZa8MxZBtl40BZMKYwGfd6zxmwcuatgOr1IbUu36B86bXCtQ8p16rlrfBzW5eMDHyGp","zk_final_price":"14"},{"category_id":121412015,"category_name":"档案盒","commission_rate":"45","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"693263683389","item_url":"https://detail.tmall.com/item.htm?id=693263683389","level_one_category_id":50018004,"level_one_category_name":"文具电教/文化用品/商务用品","nick":"丝密尔旗舰店","num_iid":"693263683389","pict_url":"https://img.alicdn.com/bao/uploaded/i4/2206519191556/O1CN01uHyBJT1NMh4XbiDKZ_!!2-item_pic.png","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"安徽 合肥","real_post_fee":"0.00","reserve_price":"10","seller_id":81311644391730832,"shop_dsr":47555,"shop_title":"丝密尔旗舰店","short_title":"","small_images":null,"superior_brand":"0","title":"adsad","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DWMqoT7Odb9kcQipKwQzePOeEDrYVVa64r4ll3HtqqoxyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7XmtmpXWXPecfcstZkCQcaw4NKnYlgoy56ql9ZiCXxuPWEnQoX91N4l2PuUKMILxyTw%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=4VjCA8yUCsxsFl0MnHdDF78nVHk3UdhZspxsUXSltAxGugGf5A9gimYCJdaIytCrX9adqEWfpAnttvyr8KgjBJ4054OWkf97Kn4kz1rfLKsG&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75ed%4001","user_type":1,"volume":0,"white_image":"","x_id":"4VjCA8yUCsxsFl0MnHdDF78nVHk3UdhZspxsUXSltAxGugGf5A9gimYCJdaIytCrX9adqEWfpAnttvyr8KgjBJ4054OWkf97Kn4kz1rfLKsG","zk_final_price":"10"}]},"total_results":7,"request_id":"15sh2i92gocty"}
         */

        private TbkDgMaterialOptionalResponseBean tbk_dg_material_optional_response;

        public TbkDgMaterialOptionalResponseBean getTbk_dg_material_optional_response() {
            return tbk_dg_material_optional_response;
        }

        public void setTbk_dg_material_optional_response(TbkDgMaterialOptionalResponseBean tbk_dg_material_optional_response) {
            this.tbk_dg_material_optional_response = tbk_dg_material_optional_response;
        }

        public static class TbkDgMaterialOptionalResponseBean {
            /**
             * result_list : {"map_data":[{"category_id":50002928,"category_name":"其它元器件","commission_rate":"135","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"692686680737","item_url":"https://item.taobao.com/item.htm?id=692686680737","level_one_category_id":50024099,"level_one_category_name":"电子元器件市场","nick":"泉州禾灿贸易有限公司","num_iid":"692686680737","pict_url":"https://img.alicdn.com/bao/uploaded/i4/1979500453/O1CN01v7eVZY1FDWDGwVWFW_!!1979500453.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"浙江 台州","real_post_fee":"0.00","reserve_price":"8250","seller_id":4793168816102206594,"shop_dsr":0,"shop_title":"泉州禾灿贸易有限公司","short_title":"","small_images":null,"superior_brand":"0","title":"议价计数器H5CX-ADSAD-NA H7CX-AWD1-N H7CXLNA/--N H7CX-A4WSD-N","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DKkFK97mlqBUcQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7XkXnlp39%2FNAsjMEy53tpIrfL6sMC8HxRBc58XKo76w%2FnL5rxbQnVg50IYULNg46oBA%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=1OewoyvMQwpocTnKFowW4VknjKTkotYyx9g4ueR5LF7DSDfldAqRDKToXL6AZhGsD0BTgZHTrg9csbWeBXP0DfpOPJcsUXcYe8Iu2iW34BuH&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75e7%4001","user_type":0,"volume":0,"white_image":"","x_id":"1OewoyvMQwpocTnKFowW4VknjKTkotYyx9g4ueR5LF7DSDfldAqRDKToXL6AZhGsD0BTgZHTrg9csbWeBXP0DfpOPJcsUXcYe8Iu2iW34BuH","zk_final_price":"8250"},{"category_id":50006522,"category_name":"电机/马达","commission_rate":"135","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"682949298903","item_url":"https://item.taobao.com/item.htm?id=682949298903","level_one_category_id":50024099,"level_one_category_name":"电子元器件市场","nick":"宏泰电气工控配件批发","num_iid":"682949298903","pict_url":"https://img.alicdn.com/bao/uploaded/i1/110753882/O1CN017fMrbB1eY0IxeYZ7u_!!110753882.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"上海","real_post_fee":"0.00","reserve_price":"5408","seller_id":9218329109665465,"shop_dsr":50000,"shop_title":"宏泰电气工控配件批发","short_title":"安川g / adm / d / vd b原装有伺服","small_images":null,"superior_brand":"0","title":"安伺服/-SGADSGDB10AB1YASKAWA/0ADSAD-川G/ADM/D/VD B原装有包装","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3D%2FtaJcjZjCu4cQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7XnLiUdIwG0p5GwOFoWBFNBxRZ%2FGlYeckMgJIYuQD4B5xzr0319rAhWOxg5p7bh%2BFbQ%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=5nkfC3wE3hP0tfnovMSBnXHa14gz7wdMtzCjG7USmFIuuIpVzJgtjTAeY25aLL5zTiX3kJWMVidG2GXY2kai14VTZb2maK7zobmFx3qcCBiT&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75e8%4001","user_type":0,"volume":0,"white_image":"","x_id":"5nkfC3wE3hP0tfnovMSBnXHa14gz7wdMtzCjG7USmFIuuIpVzJgtjTAeY25aLL5zTiX3kJWMVidG2GXY2kai14VTZb2maK7zobmFx3qcCBiT","zk_final_price":"5408"},{"category_id":50002928,"category_name":"其它元器件","commission_rate":"135","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"691949960790","item_url":"https://item.taobao.com/item.htm?id=691949960790","level_one_category_id":50024099,"level_one_category_name":"电子元器件市场","nick":"进口五金机电设备","num_iid":"691949960790","pict_url":"https://img.alicdn.com/bao/uploaded/i1/47777797/O1CN01MLTKsw27T4umgKgJ0_!!47777797.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"浙江 台州","real_post_fee":"0.00","reserve_price":"825","seller_id":10273853829831296,"shop_dsr":0,"shop_title":"进口五金机电设备","short_title":"","small_images":null,"superior_brand":"0","title":"议价计数器H5CX-ADSAD-NA H7CX-AWD1-N H7CXLNA/--N H7CX-A4WSD-N","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DjZ0viaCChqocQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7XmLceuyVFzHmLR%2BCu%2FxyDNyy%2B5EM3XBtNHjM7YyINweHVINgCELUUjKxiXvDf8DaRs%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=3I3Wh3dWOEjORCyneTU6shwwd8YNfWYkqggGNOfhWg0sv68Q9u9XvEBR0dntRhKomd9HNXbzfbqciBVIGHYkWo0ltdOyKZYSg68rjvo5O8jP&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75e9%4001","user_type":0,"volume":0,"white_image":"","x_id":"3I3Wh3dWOEjORCyneTU6shwwd8YNfWYkqggGNOfhWg0sv68Q9u9XvEBR0dntRhKomd9HNXbzfbqciBVIGHYkWo0ltdOyKZYSg68rjvo5O8jP","zk_final_price":"825"},{"category_id":50002928,"category_name":"其它元器件","commission_rate":"135","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"693771255591","item_url":"https://item.taobao.com/item.htm?id=693771255591","level_one_category_id":50024099,"level_one_category_name":"电子元器件市场","nick":"植物批发零售","num_iid":"693771255591","pict_url":"https://img.alicdn.com/bao/uploaded/i4/769625707/O1CN01cVMGwC1s1r8sRRGTC_!!769625707.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"浙江 台州","real_post_fee":"3.00","reserve_price":"825","seller_id":226518241772795050,"shop_dsr":0,"shop_title":"植物批发零售","short_title":"","small_images":null,"superior_brand":"0","title":"议价 计数器H5CX-ADSAD-NA H7CX-AWD1-N H7CXLNA/--N H7CX-A4WSD-","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DgV4s5CU6zvccQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7XnzvkEGs0dLrGD5q%2BtADfYMUQtoXXjFhC6%2F1ZuaIdu1ETr0319rAhWOxg5p7bh%2BFbQ%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=4h5BzU6qkQej98WeoIlVSeN2Q5At1gqZK2p36xIvUzJcul4yYuPOh6AZ9hIWhY0mcYZGuKm0JuD0yFEi9ncY0lbm7FCZyxHdnO7LlRxjcR6h&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75ea%4001","user_type":0,"volume":0,"white_image":"","x_id":"4h5BzU6qkQej98WeoIlVSeN2Q5At1gqZK2p36xIvUzJcul4yYuPOh6AZ9hIWhY0mcYZGuKm0JuD0yFEi9ncY0lbm7FCZyxHdnO7LlRxjcR6h","zk_final_price":"825"},{"category_id":50002928,"category_name":"其它元器件","commission_rate":"135","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"690828376254","item_url":"https://item.taobao.com/item.htm?id=690828376254","level_one_category_id":50024099,"level_one_category_name":"电子元器件市场","nick":"亿达工控自动化设备","num_iid":"690828376254","pict_url":"https://img.alicdn.com/bao/uploaded/i4/3881847752/O1CN01CFZtX7278T5mNwTxo_!!3881847752.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"江苏 南京","real_post_fee":"0.00","reserve_price":"660","seller_id":4656722025845450274,"shop_dsr":48888,"shop_title":"亿达工控自动化设备","short_title":"","small_images":null,"superior_brand":"0","title":"计数器H5CX-ADSAD-NA H7CX-AWD1-N H7CXLNA/--N H7CX-A4WSD-N","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DQsz9EJqVBuEcQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7Xn%2BkgGiFz2u86G%2BmAzoxOMCz6tlAlt58yHYFKBlGt%2FDNL5rxbQnVg50IYULNg46oBA%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=3zkTqDcS69DBilO2fxP9IDHdXUJyMD8CHugQKfgpvnWawmtDMtJpmexCPwKbOnEtqYdOXUdSw02s5VSgEpszA6kZaMh3GK4h7nlxmRq2ZqkI&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75eb%4001","user_type":0,"volume":0,"white_image":"","x_id":"3zkTqDcS69DBilO2fxP9IDHdXUJyMD8CHugQKfgpvnWawmtDMtJpmexCPwKbOnEtqYdOXUdSw02s5VSgEpszA6kZaMh3GK4h7nlxmRq2ZqkI","zk_final_price":"660"},{"category_id":50018920,"category_name":"USB多功能数码宝","commission_rate":"5400","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"675820561702","item_url":"https://item.taobao.com/item.htm?id=675820561702","level_one_category_id":50008090,"level_one_category_name":"3C数码配件","nick":"崔回来吧的小店","num_iid":"675820561702","pict_url":"https://img.alicdn.com/bao/uploaded/i2/2212357570350/O1CN01Xifmrp1PpCudQLGqO_!!2212818601889-0-picasso.jpg","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"江苏 苏州","real_post_fee":"0.00","reserve_price":"14","seller_id":4694123551994757272,"shop_dsr":50000,"shop_title":"崔回来吧的小店","short_title":"22正品森奥频闪报警器sm22mm蜂鸣器","small_images":{"string":["https://img.alicdn.com/i2/2212357570350/O1CN01XECwiJ1PpCujoeLf3_!!2212818601889-0-picasso.jpg","https://img.alicdn.com/i2/2212357570350/O1CN01tECrzP1PpCudZSLIz_!!2212818601889-0-picasso.jpg","https://img.alicdn.com/i2/2212357570350/O1CN01zbphll1PpCuhswZHY_!!2212818601889-0-picasso.jpg"]},"superior_brand":"0","title":"22。正品  森奥 频闪 报警器SM22mm 闪光蜂鸣器 ADSAD1616-/31 -","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DZsYfc2EHY48cQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7Xmg3mDEkQMN0PQlUcKJOVKwwJiy2uHk1r6JihxR%2FF9gB0nQoX91N4l2PuUKMILxyTw%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=7pVFR3A4UaQFuvf3jCz7JrYP96e8px5wsh1Ouj5a7hZa8MxZBtl40BZMKYwGfd6zxmwcuatgOr1IbUu36B86bXCtQ8p16rlrfBzW5eMDHyGp&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75ec%4001","user_type":0,"volume":0,"white_image":"","x_id":"7pVFR3A4UaQFuvf3jCz7JrYP96e8px5wsh1Ouj5a7hZa8MxZBtl40BZMKYwGfd6zxmwcuatgOr1IbUu36B86bXCtQ8p16rlrfBzW5eMDHyGp","zk_final_price":"14"},{"category_id":121412015,"category_name":"档案盒","commission_rate":"45","commission_type":"COMMON","coupon_amount":null,"coupon_end_time":null,"coupon_id":null,"coupon_info":"","coupon_remain_count":0,"coupon_share_url":null,"coupon_start_fee":null,"coupon_start_time":null,"coupon_total_count":0,"include_dxjh":"false","include_mkt":"false","info_dxjh":"{}","item_description":"","item_id":"693263683389","item_url":"https://detail.tmall.com/item.htm?id=693263683389","level_one_category_id":50018004,"level_one_category_name":"文具电教/文化用品/商务用品","nick":"丝密尔旗舰店","num_iid":"693263683389","pict_url":"https://img.alicdn.com/bao/uploaded/i4/2206519191556/O1CN01uHyBJT1NMh4XbiDKZ_!!2-item_pic.png","presale_deposit":"0","presale_end_time":0,"presale_start_time":0,"presale_tail_end_time":0,"presale_tail_start_time":0,"provcity":"安徽 合肥","real_post_fee":"0.00","reserve_price":"10","seller_id":81311644391730832,"shop_dsr":47555,"shop_title":"丝密尔旗舰店","short_title":"","small_images":null,"superior_brand":"0","title":"adsad","tk_total_commi":"0","tk_total_sales":"0","url":"//s.click.taobao.com/t?e=m%3D2%26s%3DWMqoT7Odb9kcQipKwQzePOeEDrYVVa64r4ll3HtqqoxyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7XmtmpXWXPecfcstZkCQcaw4NKnYlgoy56ql9ZiCXxuPWEnQoX91N4l2PuUKMILxyTw%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=4VjCA8yUCsxsFl0MnHdDF78nVHk3UdhZspxsUXSltAxGugGf5A9gimYCJdaIytCrX9adqEWfpAnttvyr8KgjBJ4054OWkf97Kn4kz1rfLKsG&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75ed%4001","user_type":1,"volume":0,"white_image":"","x_id":"4VjCA8yUCsxsFl0MnHdDF78nVHk3UdhZspxsUXSltAxGugGf5A9gimYCJdaIytCrX9adqEWfpAnttvyr8KgjBJ4054OWkf97Kn4kz1rfLKsG","zk_final_price":"10"}]}
             * total_results : 7
             * request_id : 15sh2i92gocty
             */

            private ResultListBean result_list;
            private int total_results;
            private String request_id;

            public ResultListBean getResult_list() {
                return result_list;
            }

            public void setResult_list(ResultListBean result_list) {
                this.result_list = result_list;
            }

            public int getTotal_results() {
                return total_results;
            }

            public void setTotal_results(int total_results) {
                this.total_results = total_results;
            }

            public String getRequest_id() {
                return request_id;
            }

            public void setRequest_id(String request_id) {
                this.request_id = request_id;
            }

            public static class ResultListBean {
                private List<MapDataBean> map_data;

                public List<MapDataBean> getMap_data() {
                    return map_data;
                }

                public void setMap_data(List<MapDataBean> map_data) {
                    this.map_data = map_data;
                }

                public static class MapDataBean {
                    /**
                     * category_id : 50002928
                     * category_name : 其它元器件
                     * commission_rate : 135
                     * commission_type : COMMON
                     * coupon_amount : null
                     * coupon_end_time : null
                     * coupon_id : null
                     * coupon_info :
                     * coupon_remain_count : 0
                     * coupon_share_url : null
                     * coupon_start_fee : null
                     * coupon_start_time : null
                     * coupon_total_count : 0
                     * include_dxjh : false
                     * include_mkt : false
                     * info_dxjh : {}
                     * item_description :
                     * item_id : 692686680737
                     * item_url : https://item.taobao.com/item.htm?id=692686680737
                     * level_one_category_id : 50024099
                     * level_one_category_name : 电子元器件市场
                     * nick : 泉州禾灿贸易有限公司
                     * num_iid : 692686680737
                     * pict_url : https://img.alicdn.com/bao/uploaded/i4/1979500453/O1CN01v7eVZY1FDWDGwVWFW_!!1979500453.jpg
                     * presale_deposit : 0
                     * presale_end_time : 0
                     * presale_start_time : 0
                     * presale_tail_end_time : 0
                     * presale_tail_start_time : 0
                     * provcity : 浙江 台州
                     * real_post_fee : 0.00
                     * reserve_price : 8250
                     * seller_id : 4793168816102206594
                     * shop_dsr : 0
                     * shop_title : 泉州禾灿贸易有限公司
                     * short_title :
                     * small_images : null
                     * superior_brand : 0
                     * title : 议价计数器H5CX-ADSAD-NA H7CX-AWD1-N H7CXLNA/--N H7CX-A4WSD-N
                     * tk_total_commi : 0
                     * tk_total_sales : 0
                     * url : //s.click.taobao.com/t?e=m%3D2%26s%3DKkFK97mlqBUcQipKwQzePOeEDrYVVa64lwnaF1WLQxlyINtkUhsv0DyHhoUxaGvyvT6f8NtHSolm5nS0VR3oT0KAZCke%2BMGJxC%2FP4%2FZfPFbcQmwDRwHnn1oN8CPq4PKMSBaygToy7XkXnlp39%2FNAsjMEy53tpIrfL6sMC8HxRBc58XKo76w%2FnL5rxbQnVg50IYULNg46oBA%3D&scm=null&pvid=1c6206f1-4682-4b7f-a8a7-ee8d46451521&app_pvid=59590_33.3.197.35_891_1669469439929&ptl=floorId:2836;originalFloorId:2836;pvid:1c6206f1-4682-4b7f-a8a7-ee8d46451521;app_pvid:59590_33.3.197.35_891_1669469439929&xId=1OewoyvMQwpocTnKFowW4VknjKTkotYyx9g4ueR5LF7DSDfldAqRDKToXL6AZhGsD0BTgZHTrg9csbWeBXP0DfpOPJcsUXcYe8Iu2iW34BuH&union_lens=lensId%3AMAPI%401669469439%402103c523_0be8_184b42207f9_75e7%4001
                     * user_type : 0
                     * volume : 0
                     * white_image :
                     * x_id : 1OewoyvMQwpocTnKFowW4VknjKTkotYyx9g4ueR5LF7DSDfldAqRDKToXL6AZhGsD0BTgZHTrg9csbWeBXP0DfpOPJcsUXcYe8Iu2iW34BuH
                     * zk_final_price : 8250
                     */

                    private int category_id;
                    private String category_name;
                    private String commission_rate;
                    private String commission_type;
                    private Object coupon_amount;
                    private Object coupon_end_time;
                    private Object coupon_id;
                    private String coupon_info;
                    private int coupon_remain_count;
                    private Object coupon_share_url;
                    private Object coupon_start_fee;
                    private Object coupon_start_time;
                    private int coupon_total_count;
                    private String include_dxjh;
                    private String include_mkt;
                    private String info_dxjh;
                    private String item_description;
                    private String item_id;
                    private String item_url;
                    private int level_one_category_id;
                    private String level_one_category_name;
                    private String nick;
                    private String num_iid;
                    private String pict_url;
                    private String presale_deposit;
                    private int presale_end_time;
                    private int presale_start_time;
                    private int presale_tail_end_time;
                    private int presale_tail_start_time;
                    private String provcity;
                    private String real_post_fee;
                    private String reserve_price;
                    private long seller_id;
                    private int shop_dsr;
                    private String shop_title;
                    private String short_title;
                    private Object small_images;
                    private String superior_brand;
                    private String title;
                    private String tk_total_commi;
                    private String tk_total_sales;
                    private String url;
                    private int user_type;
                    private int volume;
                    private String white_image;
                    private String x_id;
                    private String zk_final_price;

                    public int getCategory_id() {
                        return category_id;
                    }

                    public void setCategory_id(int category_id) {
                        this.category_id = category_id;
                    }

                    public String getCategory_name() {
                        return category_name;
                    }

                    public void setCategory_name(String category_name) {
                        this.category_name = category_name;
                    }

                    public String getCommission_rate() {
                        return commission_rate;
                    }

                    public void setCommission_rate(String commission_rate) {
                        this.commission_rate = commission_rate;
                    }

                    public String getCommission_type() {
                        return commission_type;
                    }

                    public void setCommission_type(String commission_type) {
                        this.commission_type = commission_type;
                    }

                    public Object getCoupon_amount() {
                        return coupon_amount;
                    }

                    public void setCoupon_amount(Object coupon_amount) {
                        this.coupon_amount = coupon_amount;
                    }

                    public Object getCoupon_end_time() {
                        return coupon_end_time;
                    }

                    public void setCoupon_end_time(Object coupon_end_time) {
                        this.coupon_end_time = coupon_end_time;
                    }

                    public Object getCoupon_id() {
                        return coupon_id;
                    }

                    public void setCoupon_id(Object coupon_id) {
                        this.coupon_id = coupon_id;
                    }

                    public String getCoupon_info() {
                        return coupon_info;
                    }

                    public void setCoupon_info(String coupon_info) {
                        this.coupon_info = coupon_info;
                    }

                    public int getCoupon_remain_count() {
                        return coupon_remain_count;
                    }

                    public void setCoupon_remain_count(int coupon_remain_count) {
                        this.coupon_remain_count = coupon_remain_count;
                    }

                    public Object getCoupon_share_url() {
                        return coupon_share_url;
                    }

                    public void setCoupon_share_url(Object coupon_share_url) {
                        this.coupon_share_url = coupon_share_url;
                    }

                    public Object getCoupon_start_fee() {
                        return coupon_start_fee;
                    }

                    public void setCoupon_start_fee(Object coupon_start_fee) {
                        this.coupon_start_fee = coupon_start_fee;
                    }

                    public Object getCoupon_start_time() {
                        return coupon_start_time;
                    }

                    public void setCoupon_start_time(Object coupon_start_time) {
                        this.coupon_start_time = coupon_start_time;
                    }

                    public int getCoupon_total_count() {
                        return coupon_total_count;
                    }

                    public void setCoupon_total_count(int coupon_total_count) {
                        this.coupon_total_count = coupon_total_count;
                    }

                    public String getInclude_dxjh() {
                        return include_dxjh;
                    }

                    public void setInclude_dxjh(String include_dxjh) {
                        this.include_dxjh = include_dxjh;
                    }

                    public String getInclude_mkt() {
                        return include_mkt;
                    }

                    public void setInclude_mkt(String include_mkt) {
                        this.include_mkt = include_mkt;
                    }

                    public String getInfo_dxjh() {
                        return info_dxjh;
                    }

                    public void setInfo_dxjh(String info_dxjh) {
                        this.info_dxjh = info_dxjh;
                    }

                    public String getItem_description() {
                        return item_description;
                    }

                    public void setItem_description(String item_description) {
                        this.item_description = item_description;
                    }

                    public String getItem_id() {
                        return item_id;
                    }

                    public void setItem_id(String item_id) {
                        this.item_id = item_id;
                    }

                    public String getItem_url() {
                        return item_url;
                    }

                    public void setItem_url(String item_url) {
                        this.item_url = item_url;
                    }

                    public int getLevel_one_category_id() {
                        return level_one_category_id;
                    }

                    public void setLevel_one_category_id(int level_one_category_id) {
                        this.level_one_category_id = level_one_category_id;
                    }

                    public String getLevel_one_category_name() {
                        return level_one_category_name;
                    }

                    public void setLevel_one_category_name(String level_one_category_name) {
                        this.level_one_category_name = level_one_category_name;
                    }

                    public String getNick() {
                        return nick;
                    }

                    public void setNick(String nick) {
                        this.nick = nick;
                    }

                    public String getNum_iid() {
                        return num_iid;
                    }

                    public void setNum_iid(String num_iid) {
                        this.num_iid = num_iid;
                    }

                    public String getPict_url() {
                        return pict_url;
                    }

                    public void setPict_url(String pict_url) {
                        this.pict_url = pict_url;
                    }

                    public String getPresale_deposit() {
                        return presale_deposit;
                    }

                    public void setPresale_deposit(String presale_deposit) {
                        this.presale_deposit = presale_deposit;
                    }

                    public int getPresale_end_time() {
                        return presale_end_time;
                    }

                    public void setPresale_end_time(int presale_end_time) {
                        this.presale_end_time = presale_end_time;
                    }

                    public int getPresale_start_time() {
                        return presale_start_time;
                    }

                    public void setPresale_start_time(int presale_start_time) {
                        this.presale_start_time = presale_start_time;
                    }

                    public int getPresale_tail_end_time() {
                        return presale_tail_end_time;
                    }

                    public void setPresale_tail_end_time(int presale_tail_end_time) {
                        this.presale_tail_end_time = presale_tail_end_time;
                    }

                    public int getPresale_tail_start_time() {
                        return presale_tail_start_time;
                    }

                    public void setPresale_tail_start_time(int presale_tail_start_time) {
                        this.presale_tail_start_time = presale_tail_start_time;
                    }

                    public String getProvcity() {
                        return provcity;
                    }

                    public void setProvcity(String provcity) {
                        this.provcity = provcity;
                    }

                    public String getReal_post_fee() {
                        return real_post_fee;
                    }

                    public void setReal_post_fee(String real_post_fee) {
                        this.real_post_fee = real_post_fee;
                    }

                    public String getReserve_price() {
                        return reserve_price;
                    }

                    public void setReserve_price(String reserve_price) {
                        this.reserve_price = reserve_price;
                    }

                    public long getSeller_id() {
                        return seller_id;
                    }

                    public void setSeller_id(long seller_id) {
                        this.seller_id = seller_id;
                    }

                    public int getShop_dsr() {
                        return shop_dsr;
                    }

                    public void setShop_dsr(int shop_dsr) {
                        this.shop_dsr = shop_dsr;
                    }

                    public String getShop_title() {
                        return shop_title;
                    }

                    public void setShop_title(String shop_title) {
                        this.shop_title = shop_title;
                    }

                    public String getShort_title() {
                        return short_title;
                    }

                    public void setShort_title(String short_title) {
                        this.short_title = short_title;
                    }

                    public Object getSmall_images() {
                        return small_images;
                    }

                    public void setSmall_images(Object small_images) {
                        this.small_images = small_images;
                    }

                    public String getSuperior_brand() {
                        return superior_brand;
                    }

                    public void setSuperior_brand(String superior_brand) {
                        this.superior_brand = superior_brand;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getTk_total_commi() {
                        return tk_total_commi;
                    }

                    public void setTk_total_commi(String tk_total_commi) {
                        this.tk_total_commi = tk_total_commi;
                    }

                    public String getTk_total_sales() {
                        return tk_total_sales;
                    }

                    public void setTk_total_sales(String tk_total_sales) {
                        this.tk_total_sales = tk_total_sales;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public int getUser_type() {
                        return user_type;
                    }

                    public void setUser_type(int user_type) {
                        this.user_type = user_type;
                    }

                    public int getVolume() {
                        return volume;
                    }

                    public void setVolume(int volume) {
                        this.volume = volume;
                    }

                    public String getWhite_image() {
                        return white_image;
                    }

                    public void setWhite_image(String white_image) {
                        this.white_image = white_image;
                    }

                    public String getX_id() {
                        return x_id;
                    }

                    public void setX_id(String x_id) {
                        this.x_id = x_id;
                    }

                    public String getZk_final_price() {
                        return zk_final_price;
                    }

                    public void setZk_final_price(String zk_final_price) {
                        this.zk_final_price = zk_final_price;
                    }
                }
            }
        }
    }
}
