package com.sxd.taobaocoupon.view;

import java.util.List;

public interface IVideoViewCallback {
    // 本地的mp4等视频文件的所有目录加载完毕
    void onLocalVidoesLoaded(List<String> files);
}
