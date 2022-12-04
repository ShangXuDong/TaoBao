package com.sxd.taobaocoupon.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.sxd.taobaocoupon.model.entity.CategoryDetail;
import com.sxd.taobaocoupon.util.UrlUtils;

import java.util.ArrayList;
import java.util.List;

public class LooperAdapter extends PagerAdapter {

    private List<CategoryDetail.DataBean> looperContents = new ArrayList<>();

    public int getDataSize() {
        return looperContents.size();
    }

    private onLooperClickedListener looperClickedListener;

    @Override
    public int getCount() {
        // 为了让他轮播图循环下去
        return looperContents.size() * 10;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        int realposition = position % looperContents.size();

        ImageView img = new ImageView(container.getContext());
        img.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (looperClickedListener != null)
                    looperClickedListener.onItemClick(looperContents.get(realposition));
            }
        });
        Glide.with(container.getContext())
                .load(UrlUtils.createCoverUrl(looperContents.get(realposition).getPict_url()))
                .into(img);
        container.addView(img);
        return img;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    public void setData(List<CategoryDetail.DataBean> looperContents) {

        this.looperContents.clear();
        this.looperContents.addAll(looperContents);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(onLooperClickedListener onLooperClickedListener) {
        looperClickedListener = onLooperClickedListener;
    }


    public interface onLooperClickedListener{
        void onItemClick(CategoryDetail.DataBean item);
    }
}
