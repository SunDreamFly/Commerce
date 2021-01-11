package com.example.commerce.adapter.classfly;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.commerce.R;
import com.example.commerce.bean.ClassFlyChildBean;


import java.util.ArrayList;

public class ClassflyOneAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<ClassFlyChildBean.DataBean.CurrentCategoryBean> currentCategoryBeans;
    private ColumnLayoutHelper columnLayoutHelperone1;

    public ClassflyOneAdapter(Context context, ArrayList<ClassFlyChildBean.DataBean.CurrentCategoryBean> currentCategoryBeans, ColumnLayoutHelper columnLayoutHelperone1) {
        this.context = context;
        this.currentCategoryBeans = currentCategoryBeans;
        this.columnLayoutHelperone1 = columnLayoutHelperone1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_class_one, parent, false);
        return new ClassHolderone1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ClassHolderone1 classHolder= (ClassHolderone1) holder;
        ClassFlyChildBean.DataBean.CurrentCategoryBean subCategoryListBean = currentCategoryBeans.get(position);
        Log.e("TAG", "onBindViewHolder:___________________ "+subCategoryListBean);
        classHolder.mNameone1.setText(subCategoryListBean.getFront_name());
        Glide.with(context).load(subCategoryListBean.getBanner_url()).into(classHolder.mImgone1);
    }

    @Override
    public int getItemCount() {
        return currentCategoryBeans.size();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return columnLayoutHelperone1;
    }

    class ClassHolderone1 extends RecyclerView.ViewHolder {
        private ImageView mImgone1;
        private TextView mNameone1;

        public ClassHolderone1(View view) {
            super(view);
            mImgone1 = view.findViewById(R.id.iv_class_one1_img);
            mNameone1 = view.findViewById(R.id.iv_class_one1_name);
        }


    }

}
