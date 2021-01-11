package com.example.commerce.model;


import com.example.commerce.base.BaseModel;
import com.example.commerce.contract.MyContract;
import com.example.commerce.utils.home.NetCallBack;
import com.example.commerce.utils.home.RetrofitUtils;

public class ClassflytModel  implements MyContract.ClassflyModel{

    @Override
    public <T> void getLoginData(String url, NetCallBack<T> callback) {
        RetrofitUtils.getRetrofitUtils().get(url,callback);
    }
}
