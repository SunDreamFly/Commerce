package com.example.commerce.contract;


import com.example.commerce.base.BaseModel;
import com.example.commerce.base.BasePresenter;
import com.example.commerce.base.BaseView;
import com.example.commerce.bean.ByteBean;
import com.example.commerce.bean.ClassFlyChildBean;
import com.example.commerce.bean.ClassifyBean;
import com.example.commerce.bean.HomeBean;
import com.example.commerce.bean.LoginBean;
import com.example.commerce.bean.ShopPingBean;
import com.example.commerce.bean.shopbean.DeleteCarBean;
import com.example.commerce.bean.shopbean.UpdateCarBean;
import com.example.commerce.utils.home.NetCallBack;

import java.util.HashMap;
import java.util.Map;

public class MyContract {
    //首页
    public interface InModel extends BaseModel {
        <B> void getLoginData(String url, NetCallBack<B> callback);
    }

    public interface InPresenter{
        void getData();
    }
    //首页的点击事件
    public interface InView extends BaseView {
        void getData(HomeBean bean);
    }

    public interface HomeIModel extends BaseModel {
        <T> void getHomeModel(String url, NetCallBack<T> callBack);
    }
    public interface HomeIView extends BaseView {
        void onHomeShow(Object object);
        void onHomeHide(String str);
    }
    public interface HomeIPresenter{
        void onHomeStart();
        void onFrStart(int id);
    }


    //专题
    public interface ByteModel extends BaseModel {
        <T> void getLoginData(String url, NetCallBack<T> callback);
    }
    public interface BytePresenter{
        void getData(int page);
    }
    public interface ByteView extends BaseView {
        void getData(ByteBean byteBean);
    }
    //分类
    public interface ClassflyModel extends BaseModel {
        <T> void getLoginData(String url, NetCallBack<T> callback);
    }
    public interface ClassflyPresenter{
        void getData();
    }
    public interface ClassflyView extends BaseView {
        void getData(ClassifyBean classifyBean);
    }
    //分类右边
    public interface ClasschildModel extends BaseModel {
        <T> void getModel(String url, NetCallBack<T> callBack);
    }
    public interface ClasschildView extends BaseView {
        void onShow(Object object);
        void onHide(String str);
    }
    public interface ClasschildPresenter{
        void getData(int id);
    }

    public interface IShopCartView extends BaseView {
        void setShopCartList(ShopPingBean shopCartBean);
    }
    public interface IShopCartModel extends BaseModel {
        <T> void  getShopCartList(String url, NetCallBack<T> callBack);
        void deleteShopCartShoping(String url, HashMap<String,String> hashMap);
    }
    public interface IShopCartPresenter{

        void  getShopCartList();
        void deleteShopCartShoping(String shopID);

    }
    //登录
    public interface LoginView extends BaseView {
        void loginReturn(LoginBean loginBean);
    }

    public interface  LoginPresenter  {
        void login(String username,String pw);
    }


    public interface LoginModel extends BaseModel {
        void login(String username,String pw, NetCallBack callback);
    }



    /*//购物车
    public interface ShopView extends BaseView {
        void getCarListReturn(ShopPingBean carBean);

        //更新 购物车
        void updateCarReturn(UpdateCarBean result);

        //删除购物车
        void deleteCarReturn(DeleteCarBean result);
    }

    public interface ShopPresenter{
        void getCarList();
        //更新购物车的数据
        void  updateCar(Map<String,String> map);

        //删除购物车列表
        void deleteCar(String pIds);
    }

    public interface ShopModel extends BaseModel {
        void getCarList(NetCallBack callback);
        void updateCar(Map<String,String> map,NetCallBack callback);

        void deleteCar(String pIds,NetCallBack callback);
    }
*/

}
