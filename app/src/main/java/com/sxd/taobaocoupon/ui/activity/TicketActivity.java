package com.sxd.taobaocoupon.ui.activity;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.sxd.taobaocoupon.R;
import com.sxd.taobaocoupon.model.entity.Ticket;
import com.sxd.taobaocoupon.presenter.ITicketPresenter;
import com.sxd.taobaocoupon.presenter.impl.TicketPresentImpl;
import com.sxd.taobaocoupon.util.ConstantsUtils;
import com.sxd.taobaocoupon.view.ITicketViewCallback;

import butterknife.BindView;

public class TicketActivity extends BaseActivity implements ITicketViewCallback {

    @BindView(R.id.ticket_code)
    TextView ticket_code;

    @BindView(R.id.get_ticket_btn)
    TextView get_ticket_btn;

    @BindView(R.id.ticket_cover)
    ImageView ticket_cover;

    @BindView(R.id.back_icon)
    ImageView backImg;

    private boolean haveTaoBao = false;

    // 保存每个口令
    private String kouling = null;

//    private String[] PERMISSION = {"Manifest.permission.QUERY_ALL_PACKAGES"};

    public ITicketPresenter ticketPresenter;

    private boolean needReload = true;

    // 先构造方法再回调方法
    public TicketActivity() {
        ticketPresenter = new TicketPresentImpl(this);
        Log.e("sxd", "创建");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.e("sxd", "onCreate");
        // 通过intent得到要请求的优惠券的信息
        // 检查是否安装了淘宝
        checkTaoBaoInstalled();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        // 不这么做的话，每次都是创建Actovoty时候的哪个Intent
        setIntent(intent);
        super.onNewIntent(intent);
    }

    @Override
    protected void onResume() {
        // onResume显示在屏幕上
        // 如果从淘宝回来的话，就不需要再请求网络加载数据
        // 否则需要
        if (needReload) {
            Intent intent = getIntent();
            String title = intent.getStringExtra(ConstantsUtils.KEY_INTENT_TICKET_TITLE);
            String url =  intent.getStringExtra(ConstantsUtils.KEY_INTENT_TICKET_URL);
            String cover =  intent.getStringExtra(ConstantsUtils.KEY_INTENT_TICKET_COVER);
            ticketPresenter.getTicket(title, url, cover);
        }
        super.onResume();
    }

    private void checkTaoBaoInstalled() {

        // 动态请求安装列表权限 发现不需要

//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.QUERY_ALL_PACKAGES) != PackageManager.PERMISSION_GRANTED)
//         {
//             ActivityCompat.requestPermissions(this, PERMISSION, 1); // 请求权限
//             Log.e("sxd", "请求权限");
//        }
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.taobao.taobao", PackageManager.MATCH_UNINSTALLED_PACKAGES);
            haveTaoBao = packageInfo != null;
            Log.e("sxd", packageInfo + "");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initListeners() {
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        get_ticket_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 复制口令到剪切板
                String code = kouling;
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData taobao_code = ClipData.newPlainText("taobao_code", code);

                clipboardManager.setPrimaryClip(taobao_code);
                // 根据淘宝安装与否操作
                if (haveTaoBao) {
                    Intent taobaoIntent = new Intent();
                    // 从淘宝回来不用重新加载数据
                    needReload = false;
                    ComponentName componentName = new ComponentName("com.taobao.taobao","com.taobao.tao.TBMainActivity");
                    taobaoIntent.setComponent(componentName);
                    startActivity(taobaoIntent);
                } else {
                    Toast.makeText(TicketActivity.this, "没有淘宝",  Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_ticket;
    }

    @Override
    public void onTicketLoaded(String cover, Ticket ticketResult, String title) {

        if (cover != null && cover.length() != 0)
            if (cover.contains("https"))
                Glide.with(this)
                        .load(cover)
                        .into(ticket_cover);
            else
                Glide.with(this)
                        .load("https:" + cover)
                        .into(ticket_cover);

        else
            // 扫码结果就是这种，没有图片
            ticket_cover.setImageResource(R.mipmap.icon_ticket);

        kouling = ticketResult.getData().getTbk_tpwd_create_response().getData().getModel();
        Log.e("sxd", kouling + "淘口令结果");

        // 扫码界面回来的时候是没有title的。
        if (title.equals(""))
            title = kouling.substring(kouling.lastIndexOf(" "));
        // 分割出来
        kouling = kouling.substring(kouling.indexOf('￥'), kouling.lastIndexOf('￥') + 1);
        ticket_code.setText(title);
    }

    // 重写finish方法 让activity退出到后台 但是不销毁
    @Override
    public void finish() {
        needReload = true;
        moveTaskToBack(true);
    }
}
