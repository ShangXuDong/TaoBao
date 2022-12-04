package com.sxd.taobaocoupon.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sxd.taobaocoupon.R;
import com.sxd.taobaocoupon.model.entity.Categories;
import com.sxd.taobaocoupon.model.entity.SelectedDetail;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectedPageLeftAdapter extends RecyclerView.Adapter<SelectedPageLeftAdapter.InnerHolder> {

    private int currentPosition = 0;

    private final List<Categories.DataBean> data = new ArrayList<>();

    private ItemClickListener itemClickListener;

    public SelectedPageLeftAdapter() {
        super();
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left_category_list,parent,false);
//        int parentHeight= parent.getHeight();
//        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
//        layoutParams.height =  (parentHeight/ data.size());
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        if (position == currentPosition)
            holder.tv_title.setBackgroundColor(holder.tv_title.getResources().getColor(R.color.colorEEEEEE));
        else
            holder.tv_title.setBackgroundColor(holder.tv_title.getResources().getColor(R.color.white));
        holder.tv_title.setText(data.get(position).getTitle());
        holder.tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPosition != position) {
                    currentPosition = position;
                    if (itemClickListener != null)
                        itemClickListener.onClick(data.get(position).getId());

                    notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(Categories categories) {
        data.clear();
        data.addAll(categories.getData());
        notifyDataSetChanged();
    }

    public static class InnerHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_category)
        TextView tv_title;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setItemClickListener(ItemClickListener listener) {
        itemClickListener = listener;
    }

    public interface ItemClickListener {
        void onClick(int id);
    }

}
