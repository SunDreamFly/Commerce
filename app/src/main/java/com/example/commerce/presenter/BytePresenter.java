package com.example.commerce.presenter;


import com.example.commerce.base.BasePresenter;
import com.example.commerce.bean.ByteBean;
import com.example.commerce.contract.MyContract;
import com.example.commerce.model.ByteModel;
import com.example.commerce.utils.home.NetCallBack;
import com.example.commerce.utils.home.URLConstant;

public class BytePresenter extends BasePresenter<MyContract.ByteView, MyContract.ByteModel> implements MyContract.BytePresenter {


    @Override
    public MyContract.ByteModel getiModel() {
        return new ByteModel();
    }

    @Override
    public void getData(int page) {
        iModel.getLoginData(URLConstant.BASEURLS+"topic/list?page="+page+"&size=10", new NetCallBack<ByteBean>() {

            @Override
            public void onSuccess(ByteBean byteBean) {
                iView.getData(byteBean);
            }

            @Override
            public void onFail(String string) {

            }
        });
    }
}
