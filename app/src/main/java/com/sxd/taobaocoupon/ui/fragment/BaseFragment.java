package com.sxd.taobaocoupon.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mingle.widget.LoadingView;
import com.sxd.taobaocoupon.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private State mCurrentState = State.NONE;

    // NONE表示初始化状态 SUCCESS表示内容加载成功 LOADING表示正在加载
    public enum State{
        NONE, SUCCESS, LOADING, ERROR;
    }

    // Fragment的标题栏就算内容没有加载成功，也要存在。
    // 不同状态下，比如LOADING SUCCESS等，通过这个container，填充不同的view
    private FrameLayout mBaseContainer;

    // 保存每个状态下的view，不在对应状态，则直接设置为不可见。
    private HashMap<State, View> mStateViewMap = new HashMap<>();

    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = loadRootView(inflater, container);
        mBaseContainer = rootView.findViewById(getBaseContainerId());

        loadViews(inflater, container);
        // 加载完所有的view之后，可以绑定控件了。
        bind = ButterKnife.bind(this, rootView);

        initView();
        initListener();
        initPresenter();
        setUpState(State.LOADING);
        loadData();
        setUpState(State.SUCCESS);
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Fragment中自动绑定的控件，解绑
        bind.unbind();
        // BaseFragment的子类，自己的资源释放方法。
        release();
    }


    // BaseFragment里是一个空白的FrameLayout，等待被填充。
    // 子类可以复写
    protected View loadRootView(LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(R.layout.fragment_base, container, false);
    }

    // 加载不同状态下的view，并且把状态设置在NONE
    private void loadViews(LayoutInflater inflater, @Nullable ViewGroup container) {
        View mSuccessView = loadSuccessView(inflater, container);
        mBaseContainer.addView(mSuccessView);
        // 目前还没加载数据，里面一片空白
        mSuccessView.setVisibility(View.GONE);
        mStateViewMap.put(State.SUCCESS, mSuccessView);

        View mLoadingView = loadLoadingView(inflater, container);
        mBaseContainer.addView(mLoadingView);
        mLoadingView.setVisibility(View.GONE);
        mStateViewMap.put(State.LOADING, mLoadingView);

        View mErrorView = loadErrorView(inflater, container);
        mBaseContainer.addView(mErrorView);
        mErrorView.setVisibility(View.GONE);
        mStateViewMap.put(State.ERROR, mErrorView);

        setUpState(State.NONE);
    }

    protected View loadSuccessView(LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    protected View loadLoadingView(LayoutInflater inflater, @Nullable ViewGroup container) {
        View v = inflater.inflate(R.layout.fragment_base_loading, container, false);
        return v;
    }

    protected View loadErrorView(LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(R.layout.fragment_base_error, container, false);
    }

    /***
     * 提供给外界的方法，设置Fragment的状态，加载，成功，错误。。。
     * @param state
     */
    public void setUpState(State state) {

        if (mCurrentState != State.NONE) {
            mStateViewMap.get(mCurrentState).setVisibility(View.GONE);
        }
        mCurrentState = state;
        if (mCurrentState != State.NONE){
            mStateViewMap.get(mCurrentState).setVisibility(View.VISIBLE);
        }
    }

    /***
     * 初始化view，绑定适配器等
     */
    protected void initView() {}

    /***
     * 设置完View之后，可以添加各种监听器。
     */
    protected void initListener() {

    }

    /***
     * 初始化Presenter
     */
    protected void initPresenter() {

    }

    /***
     * 万事俱备，UI发起加载数据请求。
     */
    protected void loadData(){
    }


    /***
     *
     * @return Fragment中要填充的layout的id，对应于Success状态的View
     */
    abstract int getLayoutId();


    /***
     * 默认就是在下面这个id填充
     * 但是像homeFragment 它就不是，所以需要复写
     * @return
     */
    protected int getBaseContainerId() {
        return R.id.base_container;
    }


    /***
     * 网络请求失败 出现网络错误提示 点击图标重试
     */
    @OnClick({R.id.network_error})
    public void retry() {
        onRetryClicked();
    }

    protected void onRetryClicked() {

    }

    protected void release() {}
}
