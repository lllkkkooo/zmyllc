package com.example.administrator.lapin.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.lapin.R;
import com.example.administrator.lapin.adapter.laPingAdapter.LaPingAdapter;
import com.example.administrator.lapin.fragment.laPingFragment.BaiCaiFragment;
import com.example.administrator.lapin.fragment.laPingFragment.FuBaoFragment;
import com.example.administrator.lapin.fragment.laPingFragment.LaBangFragment;
import com.example.administrator.lapin.fragment.laPingFragment.LaPingAllFragment;
import com.example.administrator.lapin.fragment.laPingFragment.YiYuanFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LaPinFragment extends Fragment {


    private Toolbar laPing_toolbar;
    private TabLayout laPing_tabLayout;
    private ViewPager laPing_viewpager;
    private String[] title={"全部","辣榜","1元包邮","白菜价","福包"};
    private List<Fragment> fragmentList;
    private LaPingAdapter laPingAdapter;
    public LaPinFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentList=new ArrayList<>();
        LaPingAllFragment allFragment=new LaPingAllFragment();
        LaBangFragment laBang=new LaBangFragment();
        YiYuanFragment yiYuan=new YiYuanFragment();
        BaiCaiFragment baicai=new BaiCaiFragment();
        FuBaoFragment fubao=new FuBaoFragment();
        fragmentList.add(allFragment);
        fragmentList.add(laBang);
        fragmentList.add(yiYuan);
        fragmentList.add(baicai);
        fragmentList.add(fubao);
        laPingAdapter=new LaPingAdapter(getChildFragmentManager(),fragmentList,title);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_la_pin,container,false);
        laPing_toolbar = ((Toolbar) view.findViewById(R.id.laPing_toobar));
        laPing_tabLayout = ((TabLayout) view.findViewById(R.id.laPing_tablayout));
        laPing_viewpager = ((ViewPager) view.findViewById(R.id.laPing_viewpager));
        setToobar();
        setTabLayout();
        return view;
    }

    private void setTabLayout() {
        laPing_viewpager.setAdapter(laPingAdapter);
        laPing_tabLayout.setupWithViewPager(laPing_viewpager);
    }

    //给toobar设置内容
    private void setToobar() {
        //给toobar加载菜单
        laPing_toolbar.inflateMenu(R.menu.laping_search);
        laPing_toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.laping_search){
                    Toast.makeText(getContext(), "搜索", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }


}
