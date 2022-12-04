package com.sxd.taobaocoupon.ui.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mbind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        // ButterKnife绑定之后，其子类不需要手动再绑定
        mbind = ButterKnife.bind(this);

        initView();
        initListeners();
        initPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mbind != null)
            // unbind方法，把bind自动注入的View的引用设置为null
            mbind.unbind();
    }

    public abstract void initListeners();

    public abstract void initView();

    protected void initPresenter() {};

    public abstract int getLayoutId();
}
