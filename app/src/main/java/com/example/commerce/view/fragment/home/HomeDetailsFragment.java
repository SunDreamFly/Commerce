package com.example.commerce.view.fragment.home;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.View;


import com.example.commerce.R;
import com.example.commerce.adapter.home.details.DetailsDataAdapter;
import com.example.commerce.base.BaseFragment;
import com.example.commerce.bean.homebean.HomeSonBean;
import com.example.commerce.contract.MyContract;
import com.example.commerce.presenter.home.HomePresenter;

import java.util.ArrayList;
import java.util.List;


public class HomeDetailsFragment extends BaseFragment<HomePresenter> implements MyContract.HomeIView {


    private int id;
    private RecyclerView detailsDataRlv;
    private ArrayList<HomeSonBean.DataBean.DataBeanX> goodsListBeans;
    private DetailsDataAdapter detailsDataAdapter;

    @Override
    protected void initView(View view) {
        id = getArguments().getInt("id");
        detailsDataRlv = (RecyclerView) view.findViewById(R.id.rv_home_details);
        goodsListBeans = new ArrayList<>();
        detailsDataRlv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        detailsDataRlv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        detailsDataAdapter = new DetailsDataAdapter(getActivity(), goodsListBeans);
        detailsDataRlv.setAdapter(detailsDataAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_details;
    }

    @Override
    protected void initData() {
        presenter.onFrStart(id);
    }

    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    public void onHomeShow(Object object) {
        HomeSonBean detailsDataBean = (HomeSonBean) object;
        List<HomeSonBean.DataBean.DataBeanX> data = detailsDataBean.getData().getData();
        goodsListBeans.addAll(data);
        detailsDataAdapter.notifyDataSetChanged();
    }

    @Override
    public void onHomeHide(String str) {

    }
}