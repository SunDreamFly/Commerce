package com.example.commerce.presenter;


import com.example.commerce.base.BasePresenter;
import com.example.commerce.bean.HomeBean;
import com.example.commerce.contract.MyContract;
import com.example.commerce.model.MainModel;
import com.example.commerce.utils.home.NetCallBack;
import com.example.commerce.utils.home.URLConstant;

public class MainPresenter extends BasePresenter<MyContract.InView,MyContract.InModel> implements MyContract.InPresenter {
    @Override
    public MyContract.InModel getiModel() {
        return new MainModel();
    }

    @Override
    public void getData() {
        iModel.getLoginData(URLConstant.NEWSLIST, new NetCallBack<HomeBean>() {
            @Override
            public void onSuccess(HomeBean bean) {
                iView.getData(bean);
            }

            @Override
            public void onFail(String string) {
//                iView.getData(string);
            }
        });
    }
}