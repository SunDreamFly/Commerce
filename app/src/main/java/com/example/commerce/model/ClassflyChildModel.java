package com.example.commerce.model;


import com.example.commerce.contract.MyContract;
import com.example.commerce.utils.home.NetCallBack;
import com.example.commerce.utils.home.RetrofitUtils;

public class ClassflyChildModel implements MyContract.ClasschildModel{

    @Override
    public <T> void getModel(String url, NetCallBack<T> callBack) {
        RetrofitUtils.getRetrofitUtils().get(url,callBack);
    }
}
