package com.example.administrator.lapin.myInterface.laPingGetDateInterface;

import com.example.administrator.lapin.bean.laPingBean.TodayBaoPing;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 鲁春 on 2016/12/6.
 */
public interface WangQiInterface {
    @GET(value = "api/lapinapp/tag?tag=%E7%88%86%E5%93%81&count=10")
    public Call<TodayBaoPing> getData();
}
