package com.example.commerce.adapter.bytes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.commerce.R;
import com.example.commerce.bean.ByteBean;


import java.util.ArrayList;

public class DataLinAdapter extends DelegateAdapter.Adapter {
    private LinearLayoutHelper linearLayoutHelper;
    private Context context;
    private ArrayList<ByteBean.DataBeanX.DataBean> list;

    public DataLinAdapter(LinearLayoutHelper linearLayoutHelper, Context context, ArrayList<ByteBean.DataBeanX.DataBean> list) {
        this.linearLayoutHelper = linearLayoutHelper;
        this.context = context;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bytes, parent, false);
        return new DataLinViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DataLinViewHolder viewHolder = (DataLinViewHolder) holder;
        ByteBean.DataBeanX.DataBean dtos = list.get(position);
        Glide.with(context).load(dtos.getScene_pic_url()).into(viewHolder.iv);
        viewHolder.tv_title.setText(dtos.getTitle());
        viewHolder.tv_subtitle.setText(dtos.getSubtitle());
        viewHolder.price_info.setText(dtos.getPrice_info()+"元起");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class DataLinViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv_title;
        private final TextView tv_subtitle;
        private final TextView price_info;

        public DataLinViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.sub_pic_url);
            tv_title = itemView.findViewById(R.id.sub_tv_title);
            tv_subtitle = itemView.findViewById(R.id.sub_tv_subtitle);
            price_info = itemView.findViewById(R.id.sub_price_info);
        }
    }
}
