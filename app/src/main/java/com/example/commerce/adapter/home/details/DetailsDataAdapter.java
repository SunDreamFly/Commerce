package com.example.commerce.adapter.home.details;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.commerce.R;
import com.example.commerce.bean.homebean.HomeSonBean;

import java.util.ArrayList;

public class DetailsDataAdapter extends RecyclerView.Adapter<DetailsDataAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HomeSonBean.DataBean.DataBeanX> goodsListBeans;

    public DetailsDataAdapter(Context context, ArrayList<HomeSonBean.DataBean.DataBeanX> goodsListBeans) {
        this.context = context;
        this.goodsListBeans = goodsListBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_details, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeSonBean.DataBean.DataBeanX goodsListBean = goodsListBeans.get(position);
        holder.itemDetailsDataName.setText(goodsListBean.getName());
        holder.itemDetailsDataPrice.setText("￥"+goodsListBean.getRetail_price()+"");
        Glide.with(context).load(goodsListBean.getList_pic_url()).into(holder.itemDetailsDataImg);
    }

    @Override
    public int getItemCount() {
        return goodsListBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemDetailsDataImg;
        private TextView itemDetailsDataName;
        private TextView itemDetailsDataPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemDetailsDataImg = (ImageView) itemView.findViewById(R.id.item_details_data_img);
            itemDetailsDataName = (TextView) itemView.findViewById(R.id.item_details_data_name);
            itemDetailsDataPrice = (TextView) itemView.findViewById(R.id.item_details_data_price);
        }
    }
}
