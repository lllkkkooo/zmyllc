package com.example.administrator.lapin.myInterface.laPingGetDateInterface;

import com.example.administrator.lapin.bean.laPingBean.TodayBaoPing;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 鲁春 on 2016/12/6.
 */
public interface TodayBaoInterface {
    @GET(value = "api/lapinapp/todaybest")
    public Call<TodayBaoPing> getData();
}
