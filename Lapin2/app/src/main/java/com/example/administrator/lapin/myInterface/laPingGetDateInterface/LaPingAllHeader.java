package com.example.administrator.lapin.myInterface.laPingGetDateInterface;

import com.example.administrator.lapin.bean.laPingBean.LaPingHeaderViewBean;
import com.example.administrator.lapin.utils.Url;

import retrofit2.Call;
import retrofit2.http.GET;

/**
* Created by 鲁春 on 2016/12/6.
 **/
public interface LaPingAllHeader {
    String wei=Url.getLaPinHeader(1);
    @GET(value ="api/lapinapp/focus")
    public Call<LaPingHeaderViewBean> getData();
}
