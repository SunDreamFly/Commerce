package com.example.commerce.presenter;


import com.example.commerce.base.BasePresenter;

import com.example.commerce.bean.ClassFlyChildBean;
import com.example.commerce.contract.MyContract;
import com.example.commerce.model.ClassflyChildModel;
import com.example.commerce.utils.home.NetCallBack;

import static com.example.commerce.utils.home.URLConstant.BASEURL;


public class ClassflyChildPresenter extends BasePresenter<MyContract.ClasschildView, MyContract.ClasschildModel> implements MyContract.ClasschildPresenter {
    @Override
    public MyContract.ClasschildModel getiModel() {
        return new ClassflyChildModel();
    }

    @Override
    public void getData(int id) {
        iModel.getModel(BASEURL+"catalog/current?id="+id+"", new NetCallBack<ClassFlyChildBean>() {
            @Override
            public void onSuccess(ClassFlyChildBean oneBean) {
                iView.onShow(oneBean);
            }

            @Override
            public void onFail(String err) {

            }
        });
    }
}

