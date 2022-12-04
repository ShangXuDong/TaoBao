package com.sxd.taobaocoupon.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.sxd.taobaocoupon.R;

public class AutoLoopViewPager extends ViewPager {

    public static final int DEFAULT_DURATION = 5000;

    private int mDuration = DEFAULT_DURATION;

    private boolean needAutoLoop = false;

    public AutoLoopViewPager(@NonNull Context context) {
        super(context, null);
    }

    public AutoLoopViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AutoLoopViewPagerStyle);
        mDuration = typedArray.getInteger(R.styleable.AutoLoopViewPagerStyle_duration, DEFAULT_DURATION);
        typedArray.recycle();
    }

    public void startAutoLoop() {
        needAutoLoop = true;
        post(autoLoopTask);
    }

    public void stopAutoLoop() {
        removeCallbacks(autoLoopTask);
        needAutoLoop = false;

    }

    // 除了xml中配置，在这里提供一个方法，让外界能够通过代码设置属性
    public void setDuration(int time) {
        mDuration = time;
    }

    private Runnable autoLoopTask = new Runnable() {
        @Override
        public void run() {
            int currentItem = getCurrentItem();
            // 第二个参数为true 使其平滑过度 不然看着眼疼
            setCurrentItem(++currentItem, true);
            if (needAutoLoop)
                postDelayed(this, mDuration);
        }
    };
}
