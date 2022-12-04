package com.sxd.taobaocoupon.ui.adapter;

import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sxd.taobaocoupon.R;
import com.sxd.taobaocoupon.model.entity.CategoryDetail;
import com.sxd.taobaocoupon.util.UrlUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeCategoryViewPagerListViewAdapter extends RecyclerView.Adapter<HomeCategoryViewPagerListViewAdapter.InnerHodler> {

    List<CategoryDetail.DataBean> data = new ArrayList<>();

    int i = 0;
    private onListItemClickedListener itemListener;

    @NonNull
    @Override
    public InnerHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_category_pager_content_list, parent, false);
//        Log.e("sxd", "创建新的" + (++i) + this);
        return new InnerHodler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHodler holder, int position) {
        holder.setData(data.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemListener != null) {
                    itemListener.onItemClick(data.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public void setData(List<CategoryDetail.DataBean> contents) {
        data.clear();
        data.addAll(contents);
        notifyDataSetChanged();
    }

    public void addData(List<CategoryDetail.DataBean> contents) {
        Log.e("sxd", "刷新！！！！！！！！！！！！！");
        int size = data.size();
        data.addAll(contents);
        // 添加数据 局部刷新
        notifyItemRangeChanged(size, contents.size());
//        notifyItemRangeInserted(size, contents.size());
//        notifyItemChanged();
    }

    public class InnerHodler extends RecyclerView.ViewHolder{

        // 图片
        @BindView(R.id.goods_cover)
        public ImageView cover;

        // 商品描述
        @BindView(R.id.goods_title)
        public TextView title;

        @BindView(R.id.off_prise)
        public TextView off_price;

        // 优惠券元
        @BindView(R.id.off_amount)
        public TextView off_amount;

        // 原价
        @BindView(R.id.origin_prise)
        public TextView origin_prise;

        // 购买人数
        @BindView(R.id.bought_count)
        public TextView bought_count;


        public InnerHodler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void setData(CategoryDetail.DataBean data) {
            title.setText(data.getTitle());

            String zk_final_price = data.getZk_final_price();
            off_price.setText(String.format("%.2f", (Float.parseFloat(zk_final_price) - data.getCoupon_amount())) + "");

            Glide.with(itemView.getContext()).load(UrlUtils.createCoverUrl(data.getPict_url())).into(cover);

            off_amount.setText("省" + data.getCoupon_amount() + "元");

            origin_prise.setText(data.getZk_final_price());
            origin_prise.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

            bought_count.setText(data.getVolume() + "已购买");
        }
    }

    public void setOnItemClickListener(onListItemClickedListener onListItemClickedListener) {
        itemListener = onListItemClickedListener;
    }

    public interface onListItemClickedListener {
        void onItemClick(CategoryDetail.DataBean item);
    }
}
