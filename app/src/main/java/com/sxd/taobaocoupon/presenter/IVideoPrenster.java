package com.sxd.taobaocoupon.presenter;

import com.sxd.taobaocoupon.model.IVideoModel;
import com.sxd.taobaocoupon.view.IVideoViewCallback;

public interface IVideoPrenster extends IBasePresenter<IVideoViewCallback, IVideoModel>{
    void loadLocalVideos();
}
