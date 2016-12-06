package com.example.administrator.lapin.fragment.laPingFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.lapin.R;
import com.example.administrator.lapin.adapter.laPingAdapter.TodayBaoPingRecyclerviewAdapter;
import com.example.administrator.lapin.bean.laPingBean.TodayBaoPing;
import com.example.administrator.lapin.myInterface.laPingGetDateInterface.WangQiInterface;

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
public class WangQiFragment extends Fragment {
    private List<TodayBaoPing.ContentBean> todayList=new ArrayList<>();
    private RecyclerView wangQi_recyclerview;
    private TodayBaoPingRecyclerviewAdapter adapter;
    public WangQiFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter=new TodayBaoPingRecyclerviewAdapter(todayList,getContext());
        getDataFromNet();
    }

    private void getDataFromNet() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://api.lapin365.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final WangQiInterface today=retrofit.create(WangQiInterface.class);
        today.getData().enqueue(new Callback<TodayBaoPing>() {
            @Override
            public void onResponse(Call<TodayBaoPing> call, Response<TodayBaoPing> response) {
                List<TodayBaoPing.ContentBean> list=response.body().getContent();
                adapter.addData(list);
                todayList.addAll(list);
            }

            @Override
            public void onFailure(Call<TodayBaoPing> call, Throwable t) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_wang_qi,container,false);
        wangQi_recyclerview = ((RecyclerView) view.findViewById(R.id.wangQi_recyclerview));
        wangQi_recyclerview.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        wangQi_recyclerview.setLayoutManager(linearLayoutManager);
        setListener();
        return view;
    }

    private void setListener() {
        adapter.setOnClick(new TodayBaoPingRecyclerviewAdapter.recyclerviewCallBack() {
            @Override
            public void setOnClick(View view, int position) {
                Toast.makeText(getContext(),todayList.get(position).getProductName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
