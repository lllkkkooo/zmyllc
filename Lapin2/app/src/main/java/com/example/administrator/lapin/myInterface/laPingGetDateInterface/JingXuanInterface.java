package com.example.administrator.lapin.myInterface.laPingGetDateInterface;

import com.example.administrator.lapin.bean.laPingBean.JingXuanBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 鲁春 on 2016/12/6.
 */
public interface JingXuanInterface {
    @GET(value = "api/lapinapp/indexlistsegbyid?count=20")
    public Call<JingXuanBean> getData();
}
