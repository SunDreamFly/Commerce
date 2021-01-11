package com.example.commerce.view.fragment;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.commerce.R;
import com.example.commerce.adapter.shop.ShopCartAdapter;
import com.example.commerce.base.BaseFragment;
import com.example.commerce.bean.ShopPingBean;
import com.example.commerce.contract.MyContract;
import com.example.commerce.presenter.ShoppingPresenter;

import java.util.ArrayList;


public class ShopPingsFragment extends BaseFragment<ShoppingPresenter> implements MyContract.IShopCartView, View.OnClickListener {


    private NestedScrollView scrollView;
    private RecyclerView recyGood;
    private ConstraintLayout layoutCommon;
    private CheckBox checkboxAll;
    private TextView txtTotalPrice;
    private TextView txtEdit;
    private TextView txtSubmit;
    private ArrayList<ShopPingBean.DataDTO.CartListDTO> cartList;
    private ShopCartAdapter shopCartAdapter;

    @Override
    protected void initView(View view) {
        recyGood = (RecyclerView) view.findViewById(R.id.recy_good);
        layoutCommon = (ConstraintLayout) view.findViewById(R.id.layout_common);
        checkboxAll = (CheckBox) view.findViewById(R.id.checkbox_all);

        scrollView = (NestedScrollView) view.findViewById(R.id.scrollView);
        txtTotalPrice = (TextView) view.findViewById(R.id.txt_totalPrice);
        txtEdit = (TextView) view.findViewById(R.id.txt_edit);
        txtSubmit = (TextView) view.findViewById(R.id.txt_submit);

        checkboxAll.setOnClickListener(this);

        cartList = new ArrayList<>();
        shopCartAdapter = new ShopCartAdapter(cartList);
        recyGood.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyGood.setAdapter(shopCartAdapter);
        shopCartAdapter.setPriceListener(new ShopCartAdapter.PriceCallBackListener() {
            @Override
            public void priceChange() {

            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shop_pings;
    }

    @Override
    protected void initData() {
        presenter.getShopCartList();
    }

    @Override
    protected ShoppingPresenter getPresenter() {
        return new ShoppingPresenter();
    }

    @Override
    public void setShopCartList(ShopPingBean shopCartBean) {

    }

    @Override
    public void onClick(View v) {

    }
}
