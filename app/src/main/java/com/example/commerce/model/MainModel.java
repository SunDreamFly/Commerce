package com.example.commerce.model;


import com.example.commerce.contract.MyContract;
import com.example.commerce.utils.home.NetCallBack;
import com.example.commerce.utils.home.RetrofitUtils;

public class MainModel implements MyContract.InModel {
    @Override
    public <B> void getLoginData(String url, NetCallBack<B> callback) {
        RetrofitUtils.getRetrofitUtils().get(url, callback);
    }
}