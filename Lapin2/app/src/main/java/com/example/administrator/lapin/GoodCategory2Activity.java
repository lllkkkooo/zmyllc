package com.example.administrator.lapin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.lapin.adapter.GoodDetailsAdapter;
import com.example.administrator.lapin.bean.GoodCategoryBean;
import com.example.administrator.lapin.bean.GoodDetailsBean;
import com.example.administrator.lapin.myInterface.GoodDetailsInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GoodCategory2Activity extends AppCompatActivity {
   private String name;
    private int  id;
    private ListView mListView;
    private GoodDetailsAdapter mGoodDetailsAdapter;
    private List<GoodDetailsBean.ContentBean> datas=new ArrayList<>();
    private TextView categoryTxt;
private List<String>categorylist=new ArrayList<>();
    private List<String>hotlist=new ArrayList<>();
    private GoodCategoryBean goodCategoryBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_category2);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        id =intent.getExtras().getInt("id") ;
        name=intent.getExtras().getString("name");
        goodCategoryBean = (GoodCategoryBean) intent.getExtras().getSerializable("category");
        initView();
        initData();
        mListView.setAdapter(mGoodDetailsAdapter);
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.good_category2_listview);
        categoryTxt = (TextView) findViewById(R.id.good_category2_category_txt);

    }

    private void initData() {
        categoryTxt.setText(name);
        for (int i = 0; i < goodCategoryBean.getContent().size(); i++) {
            categorylist.add(goodCategoryBean.getContent().get(i).getName());
        }
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://api.lapin365.com/api/lapinapp/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        GoodDetailsInterface goodDetailsInterface=retrofit.create(GoodDetailsInterface.class);
        goodDetailsInterface.setData(id).enqueue(new Callback<GoodDetailsBean>() {
            @Override
            public void onResponse(Call<GoodDetailsBean> call, Response<GoodDetailsBean> response) {
                GoodDetailsBean goodDetailsBean=response.body();
                datas.addAll(goodDetailsBean.getContent());
                mGoodDetailsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GoodDetailsBean> call, Throwable t) {

            }
        });
        mGoodDetailsAdapter=new GoodDetailsAdapter(datas,this);
    }

    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.good_category2_back:
                finish();
                break;
            case R.id.good_category2_sweep:
                Toast.makeText(GoodCategory2Activity.this, "扫描", Toast.LENGTH_SHORT).show();
                break;
            case R.id.good_category2_search:
                Toast.makeText(GoodCategory2Activity.this, "搜索", Toast.LENGTH_SHORT).show();
                InputMethodManager imm= (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (imm!=null){
                    imm.hideSoftInputFromWindow(categoryTxt.getWindowToken(),0);
                }
                break;
        }
    }
}
