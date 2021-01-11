package com.example.commerce.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.commerce.R;
import com.example.commerce.bean.HomeBean;

import java.util.ArrayList;

public class SpecialAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private SingleLayoutHelper singleLayoutHelper;
    private ArrayList<HomeBean.DataDTO.TopicListDTO> list;

    public SpecialAdapter(Context context, SingleLayoutHelper singleLayoutHelper, ArrayList<HomeBean.DataDTO.TopicListDTO> list) {
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_special, parent, false);
        return new HomeHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeHolder homeHolder= (HomeHolder) holder;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        homeHolder.rv.setLayoutManager(linearLayoutManager);
        SpeciachildAdapter speciaAdapter = new SpeciachildAdapter(list, context);
        homeHolder.rv.setAdapter(speciaAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }



    class HomeHolder extends RecyclerView.ViewHolder {
        private RecyclerView rv;

        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            rv = itemView.findViewById(R.id.rv_sp);
        }
    }

}
