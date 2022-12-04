package com.sxd.taobaocoupon.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.sxd.taobaocoupon.model.entity.Categories;
import com.sxd.taobaocoupon.ui.fragment.HomeCategoryPagerFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeCategoryViewPagerAdapter extends FragmentPagerAdapter {

    // 每一个分类下的数据。这个adapter会创建多个。
    private List<Categories.DataBean> mCategoryList = new ArrayList<>();

    public HomeCategoryViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mCategoryList.get(position).getTitle();
    }

    // 返回的是Fragment，每一个分类对应一个Fragment。
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return HomeCategoryPagerFragment.newInstance(mCategoryList.get(position));
    }

    @Override
    public int getCount() {
        return mCategoryList.size();
    }

    /***
     * 暴露给外界
     * @param categories
     */
    public void setCategories(Categories categories) {
        mCategoryList.clear();
        List<Categories.DataBean> categoriesGet = categories.getData();
        mCategoryList.addAll(categoriesGet);
        notifyDataSetChanged();
    }
}
