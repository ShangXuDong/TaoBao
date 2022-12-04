package com.sxd.taobaocoupon.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sxd.taobaocoupon.R;
import com.sxd.taobaocoupon.model.entity.SelectedDetail;
import com.sxd.taobaocoupon.util.UrlUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectedPageRightContentAdapter extends RecyclerView.Adapter<SelectedPageRightContentAdapter.InnerHolder>{


    public List<SelectedDetail.DataBean> data = new ArrayList<>();

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected_page_content, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
            holder.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(SelectedDetail selectedDetail) {
        data.clear();
        data.addAll(selectedDetail.getData());
        notifyDataSetChanged();
    }

    public static class InnerHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.selected_cover)
        public ImageView cover;

        @BindView(R.id.selected_off_prise)
        public TextView offPriseTv;


        @BindView(R.id.selected_title)
        public TextView title;

        @BindView(R.id.selected_buy_btn)
        public TextView buyBtn;

        @BindView(R.id.selected_original_prise)
        public TextView originalPriseTv;


        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(SelectedDetail.DataBean item) {
            title.setText(item.getTitle());
            Glide.with(itemView.getContext())
                    .load(UrlUtils.createCoverUrl(item.getPict_url()))
                    .into(cover);
        }
    }
}
