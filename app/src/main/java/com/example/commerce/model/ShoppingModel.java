package com.example.commerce.model;

import com.example.commerce.contract.MyContract;
import com.example.commerce.utils.home.NetCallBack;
import com.example.commerce.utils.home.RetrofitUtils;

import java.util.HashMap;

public class ShoppingModel implements MyContract.IShopCartModel {
    @Override
    public <T> void getShopCartList(String url, NetCallBack<T> callBack) {
        RetrofitUtils.getRetrofitUtils().get(url,callBack);
    }

    @Override
    public void deleteShopCartShoping(String url, HashMap<String, String> hashMap) {

    }
}
