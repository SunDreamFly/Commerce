package com.example.commerce.utils.home;


import com.example.commerce.bean.ClassFlyChildBean;
import com.example.commerce.bean.ClassifyBean;
import com.example.commerce.bean.ShopPingBean;
import com.example.commerce.bean.shopbean.AddCarBean;
import com.example.commerce.bean.shopbean.DeleteCarBean;
import com.example.commerce.bean.shopbean.GoodDetailBean;
import com.example.commerce.bean.shopbean.Shop_AddBean;
import com.example.commerce.bean.shopbean.UpdateCarBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface NetApi {
    @GET()
    Observable<ResponseBody> get(@Url String url);

    @POST
    @FormUrlEncoded
    Observable<ResponseBody> posts(@Url String url);

    //分类
    @GET("api/catalog/index")
    Flowable<ClassifyBean> getSort();

    // 分类右边数据
    @GET("api/catalog/current")
    Flowable<ClassFlyChildBean> getSortData(@Query("id") int id);

    //添加到购物车
    @POST("cart/add")       //  goodsId=1035006 number=1   productId=47     // 1116033   1   171
    @FormUrlEncoded
    Flowable<Shop_AddBean> ShopAddCar(@Field("goodsId") int goodsId, @Field("number") String number, @Field("productId") int productId);

    //商品详情购买页
    @GET("api/goods/detail")
    Flowable<GoodDetailBean> getGoodDetail(@Query("id") int id);

    //添加到购物车
    @POST("api/cart/add")
    @FormUrlEncoded
    Flowable<AddCarBean> addCar(@FieldMap Map<String, String> map);

    //购物车列表
    @GET("api/cart/index")
    Flowable<ShopPingBean> getCarList();

    //更新购物车的数据
    @POST("api/cart/update")
    @FormUrlEncoded
    Flowable<UpdateCarBean> updateCar(@FieldMap Map<String, String> map);


    //删除购物车数据
    @POST("api/cart/delete")
    @FormUrlEncoded
    Flowable<DeleteCarBean> deleteCar(@Field("productIds") String productIds);

//    //注册接口
//    @POST("auth/register")
//    @FormUrlEncoded
//    Flowable<MeRegisterBean> getMeRegist(@Field("username") String username, @Field("password") String password);

}
