package com.example.administrator.lapin.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.administrator.lapin.GoodCategory2Activity;
import com.example.administrator.lapin.R;
import com.example.administrator.lapin.adapter.GoodCategoryAdapter;
import com.example.administrator.lapin.bean.GoodCategoryBean;
import com.example.administrator.lapin.myInterface.GoodCategoryInterface;

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
public class Good_Category_Fragment extends Fragment {
    private GridView mGridView;
    private List<GoodCategoryBean.ContentBean> datas = new ArrayList<>();
    private GoodCategoryAdapter mAdapter;
private GoodCategoryBean goodCategoryBean;
    public Good_Category_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_good__category_, container, false);
        mGridView = (GridView) view.findViewById(R.id.good_category_gridview);
        initData();
        mAdapter = new GoodCategoryAdapter(datas, getActivity());
        mGridView.setAdapter(mAdapter);
        itemClick();
        return view;
    }

    private void itemClick() {
        final Intent intent = new Intent(getActivity(), GoodCategory2Activity.class);
        final Bundle bundle = new Bundle();
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bundle.putSerializable("category",goodCategoryBean);
               bundle.putInt("id", datas.get(position).getId());
                bundle.putString("name",datas.get(position).getName());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.lapin365.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        GoodCategoryInterface goodCategoryInterface = retrofit.create(GoodCategoryInterface.class);
        goodCategoryInterface.setData().enqueue(new Callback<GoodCategoryBean>() {
            @Override
            public void onResponse(Call<GoodCategoryBean> call, Response<GoodCategoryBean> response) {
                 goodCategoryBean = response.body();
                datas.addAll(goodCategoryBean.getContent());

                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GoodCategoryBean> call, Throwable t) {

            }
        });
    }

}
