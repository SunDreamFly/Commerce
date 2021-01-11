package com.example.commerce.contract;


import com.example.commerce.base.BaseModel;
import com.example.commerce.base.BaseView;
import com.example.commerce.bean.ShopPingBean;
import com.example.commerce.bean.shopbean.DeleteCarBean;
import com.example.commerce.bean.shopbean.UpdateCarBean;
import com.example.commerce.utils.home.NetCallBack;

import java.util.Map;

public class ICar {
    interface View extends BaseView {
        void getCarListReturn(ShopPingBean carBean);

        //更新 购物车
        void updateCarReturn(UpdateCarBean result);

        //删除购物车
        void deleteCarReturn(DeleteCarBean result);
    }

     interface ShopPresenter{
        void getCarList();
        //更新购物车的数据
        void  updateCar(Map<String,String> map);

        //删除购物车列表
        void deleteCar(String pIds);
    }

     interface ShopModel extends BaseModel {
        void getCarList(NetCallBack callback);
        void updateCar(Map<String,String> map,NetCallBack callback);

        void deleteCar(String pIds,NetCallBack callback);
    }

}
