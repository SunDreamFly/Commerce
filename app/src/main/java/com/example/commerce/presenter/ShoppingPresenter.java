package com.example.commerce.presenter;

import com.example.commerce.base.BasePresenter;
import com.example.commerce.bean.ShopPingBean;
import com.example.commerce.contract.MyContract;
import com.example.commerce.model.ShoppingModel;
import com.example.commerce.utils.home.NetCallBack;

public class ShoppingPresenter extends BasePresenter<MyContract.IShopCartView,MyContract.IShopCartModel> implements MyContract.IShopCartPresenter {



    @Override
    public void getShopCartList() {
        iModel.getShopCartList("cart/index", new NetCallBack<ShopPingBean>() {
            @Override
            public void onSuccess(ShopPingBean shopCartBean) {
                iView.setShopCartList(shopCartBean);
            }

            @Override
            public void onFail(String err) {
            }
        });
    }

    @Override
    public void deleteShopCartShoping(String shopID) {

    }

    @Override
    public MyContract.IShopCartModel getiModel() {
        return new ShoppingModel();
    }
}
