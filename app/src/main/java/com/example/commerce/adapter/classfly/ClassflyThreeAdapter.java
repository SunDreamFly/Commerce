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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.commerce.R;
import com.example.commerce.bean.ClassFlyChildBean;

import java.util.ArrayList;
import java.util.List;

public class ClassflyThreeAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private GridLayoutHelper gridLayoutHelperone;
    private List<ClassFlyChildBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryListBeans=new ArrayList<>();

    public ClassflyThreeAdapter(Context context, GridLayoutHelper gridLayoutHelperone, List<ClassFlyChildBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryListBeans) {
        this.context = context;
        this.gridLayoutHelperone = gridLayoutHelperone;
        this.subCategoryListBeans = subCategoryListBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_class_three, parent, false);
        return new ClassHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ClassHolder classHolder= (ClassHolder) holder;
        ClassFlyChildBean.DataBean.CurrentCategoryBean.SubCategoryListBean subCategoryListBean = subCategoryListBeans.get(position);
        Log.e("TAG", "onBindViewHolder:___________________ "+subCategoryListBean);
        classHolder.mName.setText(subCategoryListBean.getName());
        Glide.with(context).load(subCategoryListBean.getWap_banner_url()).into(classHolder.mImg);
    }

    @Override
    public int getItemCount() {
        return subCategoryListBeans.size();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelperone;
    }

    class ClassHolder extends RecyclerView.ViewHolder {
        private ImageView mImg;
        private TextView mName;

        public ClassHolder(View view) {
            super(view);
            mImg = view.findViewById(R.id.iv_special_one_img);
            mName = view.findViewById(R.id.iv_special_one_name);
        }


    }

}
