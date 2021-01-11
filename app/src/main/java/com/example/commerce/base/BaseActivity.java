package com.example.commerce.base;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//abstract 抽象类 就是执行对象里面共有的一些方法？？
public abstract class BaseActivity <T extends BasePresenter> extends AppCompatActivity implements BaseView {
    protected T presenter;//protected 是保护的意思

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayouID());
        if (presenter==null){
            presenter=getPresenter();
            presenter.attachView(this);
        }
        initView();
        initData();
    }
    protected abstract void initData();
    protected abstract void initView();
    protected abstract int getLayouID();
    public abstract T getPresenter();
    //public 公开的
    //private 私有的

}
