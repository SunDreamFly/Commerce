package com.example.commerce.presenter.home;

import com.example.commerce.base.BasePresenter;
import com.example.commerce.bean.homebean.HomeSonBean;
import com.example.commerce.bean.homebean.HomeparentBean;
import com.example.commerce.contract.MyContract;
import com.example.commerce.utils.home.NetCallBack;

import static com.example.commerce.utils.home.URLConstant.BASEURL;

public class HomePresenter extends BasePresenter<MyContract.HomeIView, MyContract.HomeIModel> implements MyContract.HomeIPresenter {
    @Override
    public MyContract.HomeIModel getiModel() {
        return new HomeModel();
    }

    @Override
    public void onHomeStart() {
        iModel.getHomeModel(BASEURL+"goods/list?categoryId=1005007&page=1&size=100",
                new NetCallBack<HomeparentBean>() {
                    @Override
                    public void onSuccess(HomeparentBean homeparentBean) {
                        iView.onHomeShow(homeparentBean);
                    }

                    @Override
                    public void onFail(String err) {
                        iView.onHomeHide(err);
                    }
                });
    }

    @Override
    public void onFrStart(int id) {
        iModel.getHomeModel(BASEURL+"goods/list?categoryId="+id+"",
                new NetCallBack<HomeSonBean>() {
                    @Override
                    public void onSuccess(HomeSonBean homeSonBean) {
                        iView.onHomeShow(homeSonBean);
                    }

                    @Override
                    public void onFail(String err) {
                        iView.onHomeHide(err);
                    }
                });
    }
}
