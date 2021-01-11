package com.example.commerce.contract;


import com.example.commerce.base.BaseModel;
import com.example.commerce.base.BasePresenter;
import com.example.commerce.base.BaseView;
import com.example.commerce.bean.LoginBean;
import com.example.commerce.utils.home.NetCallBack;

public interface ILogin {
    interface View extends BaseView {
        void loginReturn(LoginBean loginBean);
    }

    interface  Presenter  {
        void login(String username,String pw);
    }


    interface Model extends BaseModel {
        void login(String username,String pw, NetCallBack callback);
    }
}
