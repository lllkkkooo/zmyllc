package com.example.administrator.lapin.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.administrator.lapin.R;
import com.example.administrator.lapin.adapter.GoodHotAdapter;
import com.example.administrator.lapin.bean.GoodHotBean;
import com.example.administrator.lapin.myInterface.GoodHotInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class Good_Hot_Fragment extends Fragment {

    private GridView mGridView;
    private List<GoodHotBean.ContentBean> datas = new ArrayList<>();
    private GoodHotAdapter mAdapter;

    public Good_Hot_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_good__hot_, container, false);
        mGridView = (GridView) view.findViewById(R.id.good_hot_gridview);
        initData();
        mAdapter = new GoodHotAdapter(datas, getActivity());
        mGridView.setAdapter(mAdapter);
        return view;
    }
    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.lapin365.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        GoodHotInterface goodHotInterface = retrofit.create(GoodHotInterface.class);
        goodHotInterface.setData().enqueue(new Callback<GoodHotBean>() {
            @Override
            public void onResponse(Call<GoodHotBean> call, Response<GoodHotBean> response) {
                if (response!=null){
                GoodHotBean goodHotBean = response.body();
                datas.addAll(goodHotBean.getContent());
                mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<GoodHotBean> call, Throwable t) {

            }
        });
    }
}
