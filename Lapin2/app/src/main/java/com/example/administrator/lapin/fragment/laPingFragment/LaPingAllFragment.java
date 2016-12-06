package com.example.administrator.lapin.fragment.laPingFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.lapin.R;
import com.example.administrator.lapin.adapter.laPingAdapter.JingXuanAdapter;
import com.example.administrator.lapin.adapter.laPingAdapter.LaPingAllHeaderViewAdapter;
import com.example.administrator.lapin.bean.laPingBean.JingXuanBean;
import com.example.administrator.lapin.bean.laPingBean.LaPingHeaderViewBean;
import com.example.administrator.lapin.myInterface.laPingGetDateInterface.JingXuanInterface;
import com.example.administrator.lapin.myInterface.laPingGetDateInterface.LaPingAllHeader;
import com.example.administrator.lapin.utils.Url;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

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
public class LaPingAllFragment extends Fragment {
    private PullToRefreshListView laPinAll_pullTo;
    private ListView listView;
    private List<LaPingHeaderViewBean.ContentBean> contentBeanList=new ArrayList<>();
    private List<LaPingHeaderViewBean.ContentBean> contentBeanList2=new ArrayList<>();
    private  List<JingXuanBean.ContentBean> jingxuanList=new ArrayList<>();
    private ViewPager laping_all_header_viewpager;
    private RadioGroup laping_all_rg;
    private List<View> imgList=new ArrayList<>();
    private LaPingAllHeaderViewAdapter headerViewAdapter;
    private RadioGroup laping_all_header_baoping;
    private FrameLayout container;
    private JingXuanAdapter jingxuanAdapter;
    private TodayBaoPingFragment todayBaoPing;
    private WangQiFragment wangQi;
    public LaPingAllFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        todayBaoPing=new TodayBaoPingFragment();
        wangQi=new WangQiFragment();
        getHeaderDataFromNet();
        getContentDataFromNet();
        headerViewAdapter=new LaPingAllHeaderViewAdapter(imgList);
        jingxuanAdapter=new JingXuanAdapter(jingxuanList,getContext());
    }

    private void getContentDataFromNet() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://api.lapin365.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JingXuanInterface jingxuan=retrofit.create(JingXuanInterface.class);
        jingxuan.getData().enqueue(new Callback<JingXuanBean>() {
            @Override
            public void onResponse(Call<JingXuanBean> call, Response<JingXuanBean> response) {
                jingxuanAdapter.addData(response.body().getContent());
            }

            @Override
            public void onFailure(Call<JingXuanBean> call, Throwable t) {

            }
        });
    }

    private void getHeaderDataFromNet() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://api.lapin365.com/")
                .addConverterFactory(GsonConverterFactory.create())
                 .build();
        LaPingAllHeader laPingBean=retrofit.create(LaPingAllHeader.class);
        laPingBean.getData().enqueue(new Callback<LaPingHeaderViewBean>() {
            @Override
            public void onResponse(Call<LaPingHeaderViewBean> call, Response<LaPingHeaderViewBean> response) {
                List<LaPingHeaderViewBean.ContentBean> list=response.body().getContent();
                contentBeanList.addAll(list);
                int count=contentBeanList.size()+2;
                for (int i = 0; i < count; i++) {
                    if(i==0){
                        contentBeanList2.add(contentBeanList.get(contentBeanList.size()-1));
                    }else if(i==count-1){
                        contentBeanList2.add(contentBeanList.get(0));
                    }else{
                        contentBeanList2.add(contentBeanList.get(i-1));
                    }
                }
                getHeaderViewImg(contentBeanList2.size());
                setRadioButton(contentBeanList.size());
            }

            @Override
            public void onFailure(Call<LaPingHeaderViewBean> call, Throwable t) {

            }
        });
    }

    private void setRadioButton(int size2) {
        for (int i = 0; i < size2; i++) {
            RadioButton rd=new RadioButton(getContext());
            rd.setLayoutParams(new ViewGroup.LayoutParams(15,15));
            rd.setPadding(10,0,10,0);
            rd.setButtonDrawable(R.drawable.radiobutton_bg);
            laping_all_rg.addView(rd);
        }
        ((RadioButton)laping_all_rg.getChildAt(0)).setChecked(true);
    }

    private void getHeaderViewImg(int size) {
        for (int i = 0; i < size; i++) {
            ImageView img=new ImageView(getContext());
            img.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            if(contentBeanList2.size()>0){
                Picasso.with(getContext()).load(Url.getImg()+contentBeanList2.get(i).getPicture())
                        .placeholder(R.mipmap.thumbnail).into(img);
            }
            imgList.add(img);
        }
        headerViewAdapter.addData(imgList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_la_ping_all,container,false);
        laPinAll_pullTo = ((PullToRefreshListView) view.findViewById(R.id.laPinAll_pullTo));
        listView=laPinAll_pullTo.getRefreshableView();
        //对头视图进行设置
        setHeaderView();
        return view;
    }

    private void setHeaderView() {
        View headerView =LayoutInflater.from(getContext()).inflate(R.layout.laping_all_headerview,null);
        laping_all_header_viewpager = ((ViewPager) headerView.findViewById(R.id.laping_all_header_viewpager));
        laping_all_rg = ((RadioGroup) headerView.findViewById(R.id.laping_all_header_rg));
        laping_all_header_baoping = ((RadioGroup) headerView.findViewById(R.id.laping_all_header_baoping));
        container = ((FrameLayout) headerView.findViewById(R.id.container));
        ((RadioButton)laping_all_header_baoping.getChildAt(0)).setChecked(true);
        getChildFragmentManager().beginTransaction().replace(R.id.container,todayBaoPing).commit();
        listView.addHeaderView(headerView);
        laping_all_header_viewpager.setAdapter(headerViewAdapter);
        listView.setAdapter(jingxuanAdapter);

        setListener();
    }

    //设置监听事件
    private void setListener() {
        laping_all_header_baoping.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction fragmentTransaction=getChildFragmentManager().beginTransaction();
                switch (checkedId){
                    case R.id.today_baoping:
                        fragmentTransaction.replace(R.id.container,todayBaoPing).commit();
                        break;
                    case R.id.wangqi:
                        fragmentTransaction.replace(R.id.container,wangQi).commit();
                        break;
                }
            }
        });

        //viewpager的滑动事件
        laping_all_header_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(laping_all_rg.getChildCount()>0&&contentBeanList!=null && contentBeanList2!=null){
                if(positionOffset==0 && contentBeanList.size()>0 && contentBeanList2.size()>0) {
                    if (position == 0) {
                        laping_all_header_viewpager.setCurrentItem(contentBeanList.size(), false);
                        ((RadioButton) laping_all_rg.getChildAt(contentBeanList.size() - 1)).setChecked(true);
                    } else if (position == contentBeanList2.size() - 1) {
                        laping_all_header_viewpager.setCurrentItem(1, false);
                        ((RadioButton) laping_all_rg.getChildAt(0)).setChecked(true);
                    }
                }
                }
            }

            @Override
            public void onPageSelected(int position) {
                if(laping_all_rg.getChildCount()>0&&contentBeanList.size()>0) {
                    if (position > 0 && position < contentBeanList.size() + 1) {
                        ((RadioButton) laping_all_rg.getChildAt(position - 1)).setChecked(true);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        laping_all_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int count=laping_all_rg.getChildCount();
                for (int i = 0; i < count; i++) {
                    RadioButton radio= (RadioButton) laping_all_rg.getChildAt(i);
                    if (radio.isChecked()){
                        laping_all_header_viewpager.setCurrentItem(i+1,false);
                    }
                }
            }
        });

    }

}
