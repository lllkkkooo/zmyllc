package com.example.administrator.lapin.myInterface;

import com.example.administrator.lapin.bean.GoodHotBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2016/12/5.
 */
public interface GoodHotInterface {
    @GET(value = "api/lapinapp/malllist")
    public Call<GoodHotBean>setData();
}
