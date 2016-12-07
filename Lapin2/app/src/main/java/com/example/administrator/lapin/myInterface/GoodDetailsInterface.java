package com.example.administrator.lapin.myInterface;

import com.example.administrator.lapin.bean.GoodDetailsBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/12/6.
 */
//search?count=20&catid="+id+"&ip=10.0.3.15&platform=android&userid=";
public interface GoodDetailsInterface {
    @GET(value = "search?count=20&ip=10.0.3.15&platform=android&userid=")
    public Call<GoodDetailsBean> setData(
@Query("catid")int catid
    );
}
