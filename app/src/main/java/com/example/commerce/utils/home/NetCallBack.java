package com.example.commerce.utils.home;

public interface NetCallBack<B> {
    void onSuccess(B b);

    void onFail(String error);
}
