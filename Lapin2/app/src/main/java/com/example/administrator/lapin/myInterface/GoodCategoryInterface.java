package com.example.administrator.lapin.myInterface;

import com.example.administrator.lapin.bean.GoodCategoryBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2016/12/5.
 */
public interface GoodCategoryInterface {
    @GET(value = "api/lapinapp/allcategory")
    public Call<GoodCategoryBean>setData();
}
