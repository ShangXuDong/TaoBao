package com.sxd.taobaocoupon.model;

import java.util.List;

public interface IVideoModel {
    void loadLocalVideos();

    interface CallBack{
        void onLocalVideosPathLoaded(List<String> videoFilesPath);
    }
}
