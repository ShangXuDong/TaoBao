package com.sxd.taobaocoupon.ui.activity;

import android.content.Intent;
import android.widget.Toast;

import com.google.zxing.Result;
import com.sxd.taobaocoupon.util.ConstantsUtils;
import com.vondear.rxfeature.activity.ActivityScanerCode;
import com.vondear.rxtool.RxBeepTool;

// 继承自RxTools下的扫码界面Activity
// 在这里复写扫码结果处理逻辑
// 失败了，有的东西是私有的，不能直接获取。
public class ScannerCodeActivity extends ActivityScanerCode {

    // 复写扫码结果的decode

    @Override
    public void handleDecode(Result result) {
        //扫描成功之后的振动与声音提示
        RxBeepTool.playBeep(this,true);

        final String resultText = result.getText();
//        Log.e("sxd",result1);
        //处理扫描结果
        // 和淘宝有关系才能跳转
        if(resultText.contains("taobao.com")) {
            // 让TicketPrensent加载数据
            // 不过这里扫码结果只有一个淘口令官网的商品的url
            //跳转到淘口令界面
            Intent intent = new Intent(this, TicketActivity.class);
            intent.putExtra(ConstantsUtils.KEY_INTENT_TICKET_TITLE, "");
            intent.putExtra(ConstantsUtils.KEY_INTENT_TICKET_COVER, "");
            intent.putExtra(ConstantsUtils.KEY_INTENT_TICKET_URL, resultText);
            startActivity(intent);
        } else {
            //非法二维码
//            ToastUtil.showToast("当前二维码非法");
            Toast.makeText(this, "非法二维码!", Toast.LENGTH_LONG).show();
        }
    }


    // 我这里设置成singleInstance模式 所以要复写finish方法
    @Override
    public void finish() {
        moveTaskToBack(true);
    }
}
