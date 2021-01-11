package com.example.commerce.presenter;


import com.example.commerce.base.BasePresenter;
import com.example.commerce.bean.ClassifyBean;
import com.example.commerce.contract.MyContract;

import com.example.commerce.model.ClassflytModel;
import com.example.commerce.utils.home.NetCallBack;
import com.example.commerce.utils.home.URLConstant;

public class ClassflyPresenter extends BasePresenter<MyContract.ClassflyView, MyContract.ClassflyModel> implements MyContract.ClassflyPresenter {


    @Override
    public MyContract.ClassflyModel getiModel() {
        return new ClassflytModel();
    }


    @Override
    public void getData() {
        iModel.getLoginData(URLConstant.NEWCLASS, new NetCallBack<ClassifyBean>() {

            @Override
            public void onSuccess(ClassifyBean classifyBean) {
                iView.getData(classifyBean);
            }

            @Override
            public void onFail(String string) {

            }
        });
    }




}

