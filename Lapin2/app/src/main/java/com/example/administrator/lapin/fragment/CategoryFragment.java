package com.example.administrator.lapin.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.lapin.R;
import com.example.administrator.lapin.adapter.CategoryPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private CategoryPagerAdapter mAdapter;
    private ImageView searchIv;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        titles.add("商品分类");
        titles.add("热门商城");
        fragmentList.add(new Good_Category_Fragment());
        fragmentList.add(new Good_Hot_Fragment());
        mAdapter = new CategoryPagerAdapter(getChildFragmentManager(), titles, fragmentList);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(mAdapter);

    }

    private void initView(View view) {
        mTabLayout = (TabLayout) view.findViewById(R.id.fragment_category_tablayout);
        mViewPager = (ViewPager) view.findViewById(R.id.fragment_category_viewpager);
        searchIv = (ImageView) view.findViewById(R.id.fragment_category_search);
    }

}
