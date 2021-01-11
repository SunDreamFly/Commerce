package com.example.commerce.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {

    public P presenter;
    public BaseFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(getLayoutId(), container, false);
        if (presenter==null){
            presenter=getPresenter();
            presenter.attachView(this);
        }
        initView(view);
        initData();
        return view;
    }

    protected abstract void initView(View view);

    protected abstract int getLayoutId();

    protected abstract void initData();



    protected abstract P getPresenter();
}