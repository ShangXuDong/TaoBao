package com.sxd.taobaocoupon.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sxd.taobaocoupon.R;
import com.sxd.taobaocoupon.presenter.IVideoPrenster;
import com.sxd.taobaocoupon.presenter.impl.VideoPrenster;
import com.sxd.taobaocoupon.ui.adapter.VideoPageListAdapter;
import com.sxd.taobaocoupon.ui.custom.ShopJzvstd;
import com.sxd.taobaocoupon.ui.layoutManager.VideoLayoutManager;
import com.sxd.taobaocoupon.view.IVideoViewCallback;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import cn.jzvd.JzvdStd;


public class VideoFragment extends BaseFragment implements IVideoViewCallback {

    @BindView(R.id.recycle_view_videos)
    public RecyclerView videosRecyclerView;

    private VideoPageListAdapter videoPageListAdapter;

    private IVideoPrenster mVideoPrenster;

    private int currentPosition = -1;

    @Override
    int getLayoutId() {
        // 里面就是一个RecycleView
        return R.layout.fragment_video;
    }


    @Override
    protected void initView() {
        // 给RecycelView设置适配器和布局管理器
        videoPageListAdapter = new VideoPageListAdapter();
        videosRecyclerView.setAdapter(videoPageListAdapter);
        VideoLayoutManager videoLayoutManager = new VideoLayoutManager(getContext());

//        // 我们自己定义的接口，在这里使用
        videoLayoutManager.setmVideoListener(new VideoLayoutManager.VideoListener() {

            private void autoPlay() {
//                Log.e("sxd", " videosRecyclerView.getChildCount() " + videosRecyclerView.getChildCount());
                //
                ShopJzvstd shopJzvstdPlayer = videosRecyclerView.getChildAt(0).findViewById(R.id.shop_video_player);
                shopJzvstdPlayer.startVideoAfterPreloading();
            }

            @Override
            public void onInitComplete() {
                autoPlay();
            }

            @Override
            public void onPageRelease(boolean isNext, int position) {
                if (currentPosition == position)
                    ShopJzvstd.releaseAllVideos();
            }

            @Override
            public void onPageSelected(int position, boolean isBottom) {
                // 这里的position就是第几页，会增加也会减少。从1开始的
                if (currentPosition == position)
                    return;
                currentPosition = position;
                autoPlay();
            }
        });
        videosRecyclerView.setLayoutManager(videoLayoutManager);
//        videosRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void initPresenter() {
        mVideoPrenster = new VideoPrenster(this);
    }

    @Override
    protected void loadData() {
        // 因为目前淘口令官网，没给我们什么短视频API
        // 这里的loadData就是读取本地的所有视频
        mVideoPrenster.loadLocalVideos();
    }


    @Override
    public void onLocalVidoesLoaded(List<String> files) {
        // 这里有一个问题，就是我们从model回调，是在子线程运行，所以这里需要切换线程
        // 可以说使用handler，但是这里比较简单，我们直接带哦用runOnUiThread就可以了。
        // 适配器设置数据源
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                videoPageListAdapter.setData(files);
            }
        });
    }

    public void stopPlay() {
        ShopJzvstd.releaseAllVideos();
    }
}
