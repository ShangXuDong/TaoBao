package com.sxd.taobaocoupon.model.impl;

import android.os.Environment;
import android.util.Log;

import com.sxd.taobaocoupon.model.IVideoModel;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class VideoModel implements IVideoModel {

    private IVideoModel.CallBack mPrensterCallback;

    public VideoModel(IVideoModel.CallBack callBack) {
        mPrensterCallback = callBack;
    }

    @Override
    public void loadLocalVideos() {
        // 这里是加载本地的视频，不涉及到网络操作
        // 但是由于遍历所有文件，本身比较耗费时间，所以这里需要开启子线程。
        new ThreadToStart(this).start();
    }


    private static class ThreadToStart extends Thread{

        // 用一个弱引用
        WeakReference<VideoModel> videoModelWeakReference;

        public ThreadToStart(VideoModel videoModel) {
            videoModelWeakReference = new WeakReference<>(videoModel);
        }

        @Override
        public void run() {
            super.run();
            getVideosFileName();
        }

        private void getVideosFileName() {
            // 我们要加载手机相册里面所有的视频文件
            // 这里DCIM文件夹就是相册文件夹
            // /storage/emulated/0/DCIM/Camera
            List<String> videoList = new ArrayList<>();
            String rootDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "//DCIM//Camera";
            File rootDirFile = new File(rootDir);
            File[] rootDirfiles = rootDirFile.listFiles();
//            Log.e("sxd", rootDirfiles.length + "总共文件 + 文件夹个数");
            // 得到所有以mp4 avi mov结尾的文件
            for (File file : rootDirfiles) {
                // 不是文件夹，是文件才继续进行
                if (!file.isDirectory()) {
                    String fileName = file.getAbsolutePath();
                    String tmpName = fileName.trim().toLowerCase();
                    if (tmpName.endsWith(".mp4") || tmpName.endsWith(".avi")
                            || tmpName.endsWith(".mov"))
//                        Log.e("sxd", fileName);
                        videoList.add(fileName);
                }
            }

            VideoModel videoModel = videoModelWeakReference.get();
            if (videoModel != null) {
                videoModel.mPrensterCallback.onLocalVideosPathLoaded(videoList);
            }
        }
    }

}
