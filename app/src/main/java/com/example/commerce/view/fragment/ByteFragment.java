package com.example.commerce.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.commerce.R;
import com.example.commerce.adapter.bytes.ByteTextAdapter;
import com.example.commerce.adapter.bytes.DataLinAdapter;
import com.example.commerce.base.BaseFragment;
import com.example.commerce.bean.ByteBean;
import com.example.commerce.contract.MyContract;
import com.example.commerce.presenter.BytePresenter;

import java.util.ArrayList;
import java.util.List;

public class ByteFragment extends BaseFragment<BytePresenter> implements MyContract.ByteView {


    private RecyclerView rv;
    private FragmentActivity activity;
    private VirtualLayoutManager virtualLayoutManager;
    private DelegateAdapter adapter;
    private SingleLayoutHelper singleLayoutHelper;
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<ByteBean.DataBeanX.DataBean> list;
    private DataLinAdapter dataLinAdapter;
    private ByteTextAdapter byteTextAdapter;
    private ByteTextAdapter textAdapter;
    private ColumnLayoutHelper columnLayoutHelper;
    private int page=1;

    @Override
    protected void initView(View view) {
        rv = view.findViewById(R.id.rv_byte);
        activity = getActivity();
        virtualLayoutManager = new VirtualLayoutManager(activity);
        // 创建VirtualLayoutManager对象
        // 同时内部会创建一个LayoutHelperFinder对象，用来后续的LayoutHelper查找

        // 将VirtualLayoutManager绑定到recyclerView
        //设置回收复用池大小
        // 设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        rv.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        rv.setLayoutManager(virtualLayoutManager);


        getDataLin();
        getText1();
        adapter = new DelegateAdapter(virtualLayoutManager);
        adapter.addAdapter(dataLinAdapter);
        adapter.addAdapter(byteTextAdapter);
        rv.setAdapter(adapter);





    }

    private void getText1() {
        columnLayoutHelper = new ColumnLayoutHelper();
        columnLayoutHelper.setItemCount(1);
        byteTextAdapter = new ByteTextAdapter(getActivity(), columnLayoutHelper, list);
        byteTextAdapter.setOnClick(new ByteTextAdapter.OnClick() {
            @Override
            public void itemOnClick(int poistion) {
                if(poistion==1){
                    if(!(page<=1)){
                        page--;
                        presenter.getData(page);
                    }
                }else {
                    if(!(page>1)){
                        page++;
                        presenter.getData(page);
                    }
                }
            }
        });
    }

    private void getDataLin() {
        linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        list = new ArrayList<>();
        dataLinAdapter = new DataLinAdapter(linearLayoutHelper, activity, list);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_byte;
    }

    @Override
    protected void initData() {
        presenter.getData(page);
    }

    @Override
    protected BytePresenter getPresenter() {
        return new BytePresenter();
    }

    @Override
    public void getData(ByteBean byteBean) {
        if(list!=null&&list.size()>0){
            list.clear();
        }
        List<ByteBean.DataBeanX.DataBean> data = byteBean.getData().getData();
        list.addAll(data);
        dataLinAdapter.notifyDataSetChanged();
        byteTextAdapter.notifyDataSetChanged();
    }
}