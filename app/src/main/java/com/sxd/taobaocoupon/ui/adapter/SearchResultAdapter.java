package com.sxd.taobaocoupon.ui.adapter;

import android.text.Layout;
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
import com.sxd.taobaocoupon.model.entity.SearchResult;
import com.sxd.taobaocoupon.util.UrlUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.InnerHolder>{

    SearchResult.DataBean data;

    private ClickedListener mListener;

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_result, parent, false);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {

        SearchResult.DataBean.TbkDgMaterialOptionalResponseBean.ResultListBean.MapDataBean mapDataBean = data.getTbk_dg_material_optional_response().getResult_list().getMap_data().get(position);

        // 搜索界面设置点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (SearchResultAdapter.this.mListener != null) {
                    mListener.onItemClicked(mapDataBean.getTitle(), (String)mapDataBean.getCoupon_share_url(),  mapDataBean.getPict_url());
                }
            }
        });
        holder.setData(mapDataBean);
    }

    @Override
    public int getItemCount() {
        if (data != null)
            return data.getTbk_dg_material_optional_response().getResult_list().getMap_data().size();
        return 0;
    }

    public void setData(SearchResult.DataBean content) {

        data = null;
        changeContent(content);
        data = content;
        notifyDataSetChanged();
    }

    public void addData(SearchResult.DataBean content) {
        int size = data.getTbk_dg_material_optional_response().getResult_list().getMap_data().size();
        changeContent(content);
        data.getTbk_dg_material_optional_response().getResult_list().getMap_data().addAll(content.getTbk_dg_material_optional_response().getResult_list().getMap_data());
        // 添加数据 局部刷新
        notifyItemRangeChanged(size, data.getTbk_dg_material_optional_response().getResult_list().getMap_data().size() - size);
    }

    // 如果没有优惠券信息 删除对应item
    private void changeContent(SearchResult.DataBean content) {
        List needToRemove = new ArrayList();
        for (int i = 0; i < content.getTbk_dg_material_optional_response().getResult_list().getMap_data().size(); i++) {
            if (content.getTbk_dg_material_optional_response().getResult_list().getMap_data().get(i).getCoupon_share_url() == null)
                // 没有优惠券信息就删除
                needToRemove.add(content.getTbk_dg_material_optional_response().getResult_list().getMap_data().get(i));
        }
        content.getTbk_dg_material_optional_response().getResult_list().getMap_data().removeAll(needToRemove);
    }

    public interface ClickedListener{
        // 通过这个接口，把数据从Adapter交给View层。
        void onItemClicked(String title, String url, String cover);
    }

    public void setItemListener(ClickedListener listener) {
        mListener = listener;
    }

    public static class InnerHolder extends RecyclerView.ViewHolder{

        // 图片
        @BindView(R.id.goods_cover)
        public ImageView cover;

        // 商品描述
        @BindView(R.id.goods_title)
        public TextView title;

        @BindView(R.id.off_prise)
        public TextView off_price;

        // 搜索结果中商品 所属种类
        @BindView(R.id.category)
        public TextView category;

        // 原价
        @BindView(R.id.origin_prise)
        public TextView origin_prise;

        // 商品所在位置
        @BindView(R.id.loaction)
        public TextView loaction;


        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(SearchResult.DataBean.TbkDgMaterialOptionalResponseBean.ResultListBean.MapDataBean  detail) {

            // 搜索界面填充控件的数据

            title.setText(detail.getTitle());

            off_price.setText(detail.getZk_final_price());
            origin_prise.setText(detail.getReserve_price());
            Glide.with(itemView.getContext()).load(detail.getPict_url()).into(cover);
            category.setText(detail.getCategory_name());
            loaction.setText(detail.getProvcity());

        }


    }
}

