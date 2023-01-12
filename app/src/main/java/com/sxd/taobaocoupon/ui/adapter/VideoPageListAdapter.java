package com.sxd.taobaocoupon.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sxd.taobaocoupon.R;
import com.sxd.taobaocoupon.ui.custom.ShopJzvstd;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZDataSource;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class VideoPageListAdapter extends RecyclerView.Adapter<VideoPageListAdapter.InnerHolder>{

    private List<String> localVideoPaths = new ArrayList<>();

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 填充view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_recycle_view, parent, false);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        // 绑定viewHolder的时候，设置本地播放源
        JZDataSource jzDataSource = new JZDataSource(localVideoPaths.get(position));
        // 设置为自动循环播放状态
        jzDataSource.looping = true;
        holder.jzPlayer.setUp(jzDataSource, Jzvd.SCREEN_NORMAL);
        // 设置自动播放
        holder.jzPlayer.startVideo();
        // Glide加载预览图
    }

    @Override
    public int getItemCount() {
        return localVideoPaths.size();
    }

    // 老套路，提供给外界一个配置adapter数据源的方法
    public void setData( List<String> paths) {
        localVideoPaths.clear();
        localVideoPaths.addAll(paths);
        notifyDataSetChanged();
    }

    public static class InnerHolder extends RecyclerView.ViewHolder{

        // 播放item里面最重要的就是这个饺子播放器
        @BindView(R.id.shop_video_player)
        ShopJzvstd jzPlayer;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
