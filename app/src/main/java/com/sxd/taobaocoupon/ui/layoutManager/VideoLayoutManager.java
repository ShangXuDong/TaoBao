package com.sxd.taobaocoupon.ui.layoutManager;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

// 为了让饺子播放器的切换，达到类似于淘宝中的切换效果，这里我们自定义了一个LayoutManger

public class VideoLayoutManager extends LinearLayoutManager {

    // 布局管理器会保存一个对应的RecyleView的引用。
    // 在onAttachedToWindow的时候赋值
    private RecyclerView mRecyclerView;

    // RecycleView的一个辅助类，实现像ViewPager一样一次滑动一页的效果
    private PagerSnapHelper mPagerSnapHelper = new PagerSnapHelper();

    // 垂直位移 有正有负
    private int mDrift;

    private VideoListener mVideoListener;

    public VideoLayoutManager(Context context) {
        super(context);
    }

    // 只会调用一次
    @Override
    public void onAttachedToWindow(RecyclerView view) {
        mRecyclerView = view;
        mPagerSnapHelper.attachToRecyclerView(view);
        mRecyclerView.addOnChildAttachStateChangeListener(new Listener(this));
        super.onAttachedToWindow(view);
    }

    // 重写方法，监听垂直滑动距离
    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
//        Log.e("sxd", "scrollHorizontallyBy : " + dy);
        mDrift = dy;
        return super.scrollVerticallyBy(dy, recycler, state);
    }

    // 当滑动的状态变化的时候，这个方法会被调用。
    @Override
    public void onScrollStateChanged(int state) {
//        super.onScrollStateChanged(state);
        // 不管是快速滑动完毕，还是慢慢的滑动，值都会从1 -> 2 -> 0
        // 对应于 SCROLL_STATE_DRAGGING SCROLL_STATE_SETTLING SCROLL_STATE_IDLE 也就是手指拖拽屏幕，手指离开屏幕但是RecycleView还在滑动，以及RecycleView停止滑动
        switch (state) {
            // 这里是为了交给ViedoFragment 让他进行一些比如开启自动播放的操作
            case RecyclerView.SCROLL_STATE_IDLE:
                View viewIdle = mPagerSnapHelper.findSnapView(this);
                if (viewIdle != null) {
                    int positionIdle = getPosition(viewIdle);
                    if (mVideoListener != null && getChildCount() == 1) {
                        mVideoListener.onPageSelected(positionIdle, positionIdle == getItemCount() - 1);
                    }
                }
                break;
        }
    }

    private static class Listener implements RecyclerView.OnChildAttachStateChangeListener{

        // 弱引用 + 静态内部类 解决一个非静态内部类导致的内存泄漏问题
        private WeakReference<VideoLayoutManager> mVideoLayoutManagerWR;

        public Listener(VideoLayoutManager videoLayoutManager) {
            mVideoLayoutManagerWR = new WeakReference<>(videoLayoutManager);
        }

        // 当有新的item显示在屏幕内的时候，就会触发下面这个方法
        // 就算只出现了一点点yehuichufav
        @Override
        public void onChildViewAttachedToWindow(@NonNull View view) {

            if (mVideoLayoutManagerWR.get() != null) {
//                Log.e("sxd", " videoLayoutManager.getChildCount() : " +  mVideoLayoutManagerWR.get().getChildCount());
                VideoLayoutManager videoLayoutManager = mVideoLayoutManagerWR.get();
                // 存在监听器，同时
                // LayoutManager的getChildCount 第一次返回1 之后不管上滑还是下拉一直返回2
                // 查看源码发现，走的是RecycleView的getChildCount并且是childHelper的getChildCount
                if (videoLayoutManager.mVideoListener != null && videoLayoutManager.getChildCount() == 1) {
                    videoLayoutManager.mVideoListener.onInitComplete();
                }
            }
        }

        // 当显示在屏幕中的item不可见的时候，触发下面这个方法
        // 比如出现一点点，之后不见了，或者全部显示出来之后滑出去了，都会触发。
        @Override
        public void onChildViewDetachedFromWindow(@NonNull View view) {
            if (mVideoLayoutManagerWR.get() != null) {
                VideoLayoutManager videoLayoutManager = mVideoLayoutManagerWR.get();
                // 存在监听器，同时
                if (videoLayoutManager.mDrift >= 0) {
                    if (videoLayoutManager.mVideoListener != null)
                        videoLayoutManager.mVideoListener.onPageRelease(true, videoLayoutManager.getPosition(view));
                } else {
                    if (videoLayoutManager.mVideoListener != null)
                        videoLayoutManager.mVideoListener.onPageRelease(false, videoLayoutManager.getPosition(view));
                    new Handler();
                }
            }
        }
    }

    // 因为RecycleView中item的measure，layout都是通过LayoutManager布局管理器完成的。
    // 在这里可以检测到许多状态。
    // 我们在这里向外暴露出一个接口，把处理事件的逻辑交给UI层。
    public interface VideoListener{
        //初始化完成
        void onInitComplete();

        //释放的监听
        void onPageRelease(boolean isNext, int position);

        //选中的监听以及判断是否滑动到底部
        void onPageSelected(int position, boolean isBottom);
    }

    public void setmVideoListener(VideoListener listener) {
        mVideoListener = listener;
    }
}
