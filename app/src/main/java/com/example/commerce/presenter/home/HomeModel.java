package com.example.commerce.presenter.home;

import com.example.commerce.contract.MyContract;
import com.example.commerce.utils.home.NetCallBack;
import com.example.commerce.utils.home.RetrofitUtils;

public class HomeModel implements MyContract.HomeIModel {
    @Override
    public <T> void getHomeModel(String url, NetCallBack<T> callBack) {
        RetrofitUtils.getRetrofitUtils().get(url, callBack);
    }
}
