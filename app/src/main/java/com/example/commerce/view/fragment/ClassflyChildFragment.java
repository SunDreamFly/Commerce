package com.example.commerce.view.fragment;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.example.commerce.R;
import com.example.commerce.adapter.classfly.ClassflyOneAdapter;
import com.example.commerce.adapter.classfly.ClassflyThreeAdapter;
import com.example.commerce.adapter.classfly.ClassflyTwoAdapter;
import com.example.commerce.base.BaseFragment;
import com.example.commerce.bean.ClassFlyChildBean;
import com.example.commerce.contract.MyContract;
import com.example.commerce.presenter.ClassflyChildPresenter;

import java.util.ArrayList;
import java.util.List;


public class ClassflyChildFragment extends BaseFragment<ClassflyChildPresenter> implements MyContract.ClasschildView {

    private int id;
    private RecyclerView recyler;
    private ColumnLayoutHelper columnLayoutHelperone;
    private ArrayList<ClassFlyChildBean.DataBean.CurrentCategoryBean> classchildList;
    private GridLayoutHelper gridLayoutHelperone;
    private ColumnLayoutHelper columnLayoutHelp;
    private DelegateAdapter adapter;
    private ArrayList<ClassFlyChildBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryListBeans;
    private ClassflyOneAdapter classflyOneAdapter;
    private ClassflyTwoAdapter classflyTwoAdapter;
    private ClassflyThreeAdapter classflyThreeAdapter;

    @Override
    protected void initView(View view) {
        id = getArguments().getInt("id");
        Log.e("TAG", "initView:_+__+_)+++)++))_ "+id );
        recyler = (RecyclerView) view.findViewById(R.id.recyler_child);
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        pool.setMaxRecycledViews(1,10);
        recyler.setRecycledViewPool(pool);

        columnLayoutHelperone = new ColumnLayoutHelper();
        columnLayoutHelperone.setItemCount(1);


        classchildList = new ArrayList<>();
        classflyOneAdapter = new ClassflyOneAdapter(getActivity(),classchildList,columnLayoutHelperone);

        columnLayoutHelp = new ColumnLayoutHelper();
        columnLayoutHelp.setItemCount(1);
        classflyTwoAdapter = new ClassflyTwoAdapter(getActivity(), classchildList, columnLayoutHelperone);

        gridLayoutHelperone = new GridLayoutHelper(3);
        subCategoryListBeans = new ArrayList<>();
        classflyThreeAdapter = new ClassflyThreeAdapter(getActivity(), gridLayoutHelperone, subCategoryListBeans);

        adapter = new DelegateAdapter(virtualLayoutManager, false);
        adapter.addAdapter(classflyOneAdapter);
        adapter.addAdapter(classflyTwoAdapter);
        adapter.addAdapter(classflyThreeAdapter);
        recyler.setLayoutManager(virtualLayoutManager);
        recyler.setAdapter(adapter);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classfly_child;
    }

    @Override
    protected void initData() {
        presenter.getData(id);
    }

    @Override
    protected ClassflyChildPresenter getPresenter() {
        return new ClassflyChildPresenter();
    }

    @Override
    public void onShow(Object object) {
        if(object instanceof ClassFlyChildBean){
            ClassFlyChildBean oneBean= (ClassFlyChildBean) object;
            ClassFlyChildBean.DataBean.CurrentCategoryBean currentCategory = oneBean.getData().getCurrentCategory();
            classchildList.add(currentCategory);
            classflyOneAdapter.notifyDataSetChanged();
            classflyTwoAdapter.notifyDataSetChanged();
            List<ClassFlyChildBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = oneBean.getData().getCurrentCategory().getSubCategoryList();
            subCategoryListBeans.addAll(subCategoryList);
            classflyThreeAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onHide(String str) {

    }
}