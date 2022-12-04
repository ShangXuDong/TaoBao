package com.sxd.taobaocoupon.presenter;

// 最基础的就是绑定View，绑定Model，以及解绑View，解绑Model。

public interface IBasePresenter<T, E> {

    void registerCallback(T callback);

    void unRegisterCallback(T callback);

    void registerModel(E model);

    void unRegisterModel(E model);
}
