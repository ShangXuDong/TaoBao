package com.sxd.taobaocoupon.presenter.impl;

import android.util.Log;

import com.sxd.taobaocoupon.model.IVideoModel;
import com.sxd.taobaocoupon.model.impl.VideoModel;
import com.sxd.taobaocoupon.presenter.IVideoPrenster;
import com.sxd.taobaocoupon.view.IVideoViewCallback;

import java.util.List;

public class VideoPrenster implements IVideoPrenster, IVideoModel.CallBack {


    private IVideoViewCallback mVideoViewCallback;

    private IVideoModel mVideoModel;

    public VideoPrenster(IVideoViewCallback callback) {
        mVideoViewCallback = callback;
        mVideoModel = new VideoModel(this);
    }

    @Override
    public void loadLocalVideos() {
        mVideoModel.loadLocalVideos();
    }

    @Override
    public void registerCallback(IVideoViewCallback callback) {

    }

    @Override
    public void unRegisterCallback(IVideoViewCallback callback) {

    }

    @Override
    public void registerModel(IVideoModel model) {

    }

    @Override
    public void unRegisterModel(IVideoModel model) {

    }


    @Override
    public void onLocalVideosPathLoaded(List<String> videoFilesPath) {
        // 从model层回来，这里还是在子线程，在要修改UI的时候，记得切换为主线程
//        Log.e("sxd", Thread.currentThread().getName());
        mVideoViewCallback.onLocalVidoesLoaded(videoFilesPath);
    }
}
