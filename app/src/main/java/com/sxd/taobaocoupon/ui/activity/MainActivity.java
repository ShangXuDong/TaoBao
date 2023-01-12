package com.sxd.taobaocoupon.ui.activity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;

import com.sxd.taobaocoupon.R;
import com.sxd.taobaocoupon.ui.fragment.DiscountFragment;
import com.sxd.taobaocoupon.ui.fragment.HomeFragment;
import com.sxd.taobaocoupon.ui.fragment.SearchFragment;
import com.sxd.taobaocoupon.ui.fragment.SelectedFragment;
import com.sxd.taobaocoupon.ui.fragment.VideoFragment;

import java.util.HashMap;

import butterknife.BindView;


public class MainActivity extends BaseActivity {

    // 底部的导航栏，根据导航栏跳转到不同的Fragment
    @BindView(R.id.main_navigation_view)
    public BottomNavigationView mBottomNavigationView;

    // 当前MainActivity中选择的Fragment对应于底部导航栏中的itemId
    private int mNowSelectedItemId;

    // 一个map保存fragment，key就是底部导航栏对应的id
    private HashMap<Integer, Fragment> fragmentHashMap = new HashMap<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    public void initView() {
        // MainActivity首先显示在HomeFragment
        HomeFragment homeFragment = new HomeFragment();
        fragmentHashMap.put(R.id.item_home, homeFragment);
        mNowSelectedItemId = R.id.item_home;

        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.add(R.id.main_fragment_container, homeFragment);
        mFragmentTransaction.commit();
    }

    public void initListeners() {
        // 给导航栏设置点击事件
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // 不是重复点击自己
                if (mNowSelectedItemId != item.getItemId()) {
                    // hide之前的
                    FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
                    mFragmentTransaction.hide(fragmentHashMap.get(mNowSelectedItemId));
                    // 如果是视频Fragment的话 要暂停视频的播放
                    if (mNowSelectedItemId == R.id.item_video)
                        ((VideoFragment) fragmentHashMap.get(mNowSelectedItemId)).stopPlay();
                    // 显示现在的
                    if (fragmentHashMap.containsKey(item.getItemId())) {
                        mFragmentTransaction.show(fragmentHashMap.get(item.getItemId()));
                    }
                    else {
                        Fragment needToAdd = null;
                        switch (item.getItemId()) {
                            // 因为HomeFragment一开始就创建了 所以它一定不会走到这里 下面只判断了3中情况

                            // 因为精选API失效，这里删除对应判断逻辑
//                            case R.id.item_selected:
//                                needToAdd = new SelectedFragment();
//                                break;
                            // 精选对应界面，变成一个短视频界面
                            case R.id.item_video:
                                needToAdd = new VideoFragment();
                                break;
                            case R.id.item_red_packet:
                                needToAdd = new DiscountFragment();
                                break;
                            case R.id.item_search:
                                needToAdd = new SearchFragment();
                                break;
                        }
                        mFragmentTransaction.add(R.id.main_fragment_container, needToAdd);;
                        fragmentHashMap.put(item.getItemId(), needToAdd);
                    }
                    mNowSelectedItemId = item.getItemId();
                    mFragmentTransaction.commit();
                }
                return true;
            }
        });
    }

    // 当点击HomeFragment中的搜索框时需要跳转到searchFragment页面
    // 而这两个Fragment都是被MainActivity管理的，所以这里暴露出一个方法

    // 这里是一种简单的Fragment和Activity的通信方式，但是因为业务本身简单，之后也不会更改 所以没有使用handler等方式进行解耦。
    public void toSearchFragment() {
        FragmentTransaction mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        // 一定是从homeFragment跳转到searchFragment的
        mFragmentTransaction.hide(fragmentHashMap.get(mNowSelectedItemId));

        mNowSelectedItemId = R.id.item_search;

        if (fragmentHashMap.containsKey(mNowSelectedItemId)) {
            mFragmentTransaction.show(fragmentHashMap.get(mNowSelectedItemId));
        } else {
            Fragment fragment = new SearchFragment();
            mFragmentTransaction.add(R.id.main_fragment_container, fragment);;
            fragmentHashMap.put(mNowSelectedItemId, fragment);
        }

        mFragmentTransaction.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mNowSelectedItemId == R.id.item_video)
            ((VideoFragment) fragmentHashMap.get(mNowSelectedItemId)).stopPlay();
    }
}
