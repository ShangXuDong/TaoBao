package com.sxd.taobaocoupon.ui.adapter;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sxd.taobaocoupon.R;
import com.sxd.taobaocoupon.model.entity.DisCountDetail;
import com.sxd.taobaocoupon.util.UrlUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DiscountAdapter extends RecyclerView.Adapter<DiscountAdapter.InnerHolder> {

    List<DisCountDetail.DataBean.TbkDgOptimusMaterialResponseBean.ResultListBean.MapDataBean> data = new ArrayList();

    private DiscountItemClickListener itemClickListener = null;

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discount_list, parent, false);

        InnerHolder innerHolder = new InnerHolder(itemView);
        return innerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.setData(data.get(position));
        // 添加点击事件，点击商品卡片 跳转到Ticket淘口令界面
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null)
                    itemClickListener.onDiscountItemClickClicked(data.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<DisCountDetail.DataBean.TbkDgOptimusMaterialResponseBean.ResultListBean.MapDataBean> newData) {
        data.clear();
        data.addAll(newData);
        notifyDataSetChanged();
    }

    // 增加更多数据，局部刷新
    public void addData(List<DisCountDetail.DataBean.TbkDgOptimusMaterialResponseBean.ResultListBean.MapDataBean> newMoreData) {
        int size = data.size();
        data.addAll(newMoreData);
        // 添加数据 局部刷新
        notifyItemRangeChanged(size, newMoreData.size());
    }

    public static class InnerHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.on_sell_cover)
        public ImageView cover;

        @BindView(R.id.on_sell_content_title_tv)
        public TextView titleTv;

        @BindView(R.id.on_sell_origin_prise_tv)
        public TextView originalPriseTv;

        @BindView(R.id.on_sell_off_prise_tv)
        public TextView offPriseTv;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(DisCountDetail.DataBean.TbkDgOptimusMaterialResponseBean.ResultListBean.MapDataBean data) {
            titleTv.setText(data.getTitle());
            String coverPath = UrlUtils.createCoverUrl(data.getPict_url());
            Glide.with(cover.getContext()).load(coverPath).into(cover);
            String originalPrise = data.getZk_final_price();
            originalPriseTv.setText("￥" + originalPrise + " ");
            originalPriseTv.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            int couponAmount = data.getCoupon_amount();
            float originPriseFloat = Float.parseFloat(originalPrise);
            float finalPrise = originPriseFloat - couponAmount;
            offPriseTv.setText("券后价：" + String.format("%.2f",finalPrise));
        }
    }

    public void setItemClickListener(DiscountItemClickListener listener) {
        itemClickListener = listener;
    }

    public interface DiscountItemClickListener{
        void onDiscountItemClickClicked(DisCountDetail.DataBean.TbkDgOptimusMaterialResponseBean.ResultListBean.MapDataBean daicountData);
    }
}
