package com.example.commerce.utils.home;

import java.util.HashMap;

public interface NetWorkInterface {
    public <B> void get(String url,NetCallBack<B> callBack);
//    public <B> void get(String url,NetCallBack<B> callBack);
//    public <B> void get(String url,NetCallBack<B> callBack);
<T> void post(String url, HashMap<String, String> map, HashMap<String, String> headers, NetCallBack<T> callBack);
}
