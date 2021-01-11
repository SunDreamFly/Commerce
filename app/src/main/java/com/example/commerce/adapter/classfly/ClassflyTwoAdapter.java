package com.example.commerce.adapter.classfly;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.example.commerce.R;
import com.example.commerce.bean.ClassFlyChildBean;


import java.util.ArrayList;

public class ClassflyTwoAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<ClassFlyChildBean.DataBean.CurrentCategoryBean> currentCategoryBeans;
    private ColumnLayoutHelper columnLayoutHelperone2;

    public ClassflyTwoAdapter(Context context, ArrayList<ClassFlyChildBean.DataBean.CurrentCategoryBean> currentCategoryBeans, ColumnLayoutHelper columnLayoutHelperone1) {
        this.context = context;
        this.currentCategoryBeans = currentCategoryBeans;
        this.columnLayoutHelperone2 = columnLayoutHelperone1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_class_two, parent, false);
        return new ClassHolderone2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ClassHolderone2 classHolder= (ClassHolderone2) holder;
        ClassFlyChildBean.DataBean.CurrentCategoryBean subCategoryListBean = currentCategoryBeans.get(position);
        Log.e("TAG", "onBindViewHolder:___________________ "+subCategoryListBean);
        classHolder.mNameone2.setText(subCategoryListBean.getName()+"分类");
    }

    @Override
    public int getItemCount() {
        return currentCategoryBeans.size();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return columnLayoutHelperone2;
    }

    class ClassHolderone2 extends RecyclerView.ViewHolder {
        private TextView mNameone2;

        public ClassHolderone2(View view) {
            super(view);
            mNameone2 = view.findViewById(R.id.iv_class_one2_name);
        }


    }

}
