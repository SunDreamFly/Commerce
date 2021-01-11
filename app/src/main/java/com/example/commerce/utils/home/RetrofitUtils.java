package com.example.commerce.utils.home;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtils implements NetWorkInterface {
    private static volatile RetrofitUtils retrofitUtils;
    private final NetApi api;

    public RetrofitUtils() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConstant.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(NetApi.class);
    }

    public static RetrofitUtils getRetrofitUtils() {
        if (retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){
                    retrofitUtils =new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    @Override
    public <B> void get(String url, NetCallBack<B> callBack) {
        api.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {

                        try {
                            String json = responseBody.string();
                            Type[] interfaces = callBack.getClass().getGenericInterfaces();
                            Type[] types = ((ParameterizedType) interfaces[0]).getActualTypeArguments();
                            Type type=types[0];
                            B b=new Gson().fromJson(json,type);
                            callBack.onSuccess(b);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, HashMap<String, String> headers, NetCallBack<T> callBack) {

    }


}
/*《九宫格》
*  无力  困倦  疲累  想睡。
*  难过  嘶哑  迷茫  躺下。
*  开心  笑脸  微笑  闭眼。
*  start  loser  finish  end.
* */