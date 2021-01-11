package com.example.commerce.model;


import com.example.commerce.contract.MyContract;
import com.example.commerce.utils.bytes.ByteUtils;
import com.example.commerce.utils.home.NetCallBack;

public class ByteModel implements MyContract.ByteModel{

    @Override
    public <T> void getLoginData(String url, NetCallBack<T> callback) {
        ByteUtils.getInstance().get(url,callback);
    }
}
