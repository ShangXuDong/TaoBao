package com.sxd.taobaocoupon.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

public class ShopNestedScrollView extends NestedScrollView {

    private int mHeaderHeight = 0;

    private int originScroll = 0;

    public ShopNestedScrollView(@NonNull Context context) {
        super(context);
    }

    public ShopNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ShopNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {

        if (originScroll < mHeaderHeight) {
            scrollBy(dx, dy);
            // 传递进来的时候consumed[0] [1] 里面都是0
            // 而我们把滑动距离赋值给consumed
            // 他这里返回的时候发现consumed[0] [1] 中有一个不为0证明事件消费过了。
            consumed[0] = dx;
            consumed[1] = dy;
        }
//        else
//            super.onNestedPreScroll(target, dx, dy, consumed, type);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        originScroll = t;
        super.onScrollChanged(l, t, oldl, oldt);
    }

    public void setHeaderHeight(int h) {mHeaderHeight = h;}


    // 用于检测是否拦截了事件
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        boolean res =super.onInterceptTouchEvent(ev);
//        Log.e("sxd", "是否拦截事件" + res);
//        return res;
//    }

}
