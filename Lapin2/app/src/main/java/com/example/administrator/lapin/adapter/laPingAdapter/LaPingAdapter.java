package com.example.administrator.lapin.adapter.laPingAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 鲁春 on 2016/12/6.
 */
public class LaPingAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragmentList;
    private String[] title;
    public LaPingAdapter(FragmentManager fm,List<Fragment> fragmentList,String[] title) {
        super(fm);
        this.fragmentList=fragmentList;
        this.title=title;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList!=null?fragmentList.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
