package com.example.administrator.lapin.adapter.laPingAdapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 鲁春 on 2016/12/6.
 */
public class LaPingAllHeaderViewAdapter extends PagerAdapter{
    private List<View> viewList;
    public LaPingAllHeaderViewAdapter(List<View> viewList){
        this.viewList=viewList;
    }
    public void addData(List<View> view){
        viewList.addAll(view);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return viewList!=null?viewList.size():0;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View ret=null;
        ret=viewList.get(position);
        container.addView(ret);
        return ret;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if(object instanceof View){
            View view= (View) object;
            container.removeView(view);
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
