package com.example.administrator.lapin.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by 鲁春 on 2016/12/6.
 */
//解决横向scrollview嵌套listview滑动事件冲突问题
public class MyScrollView extends ScrollView{
    private GestureDetector mGestureDetector;
    View.OnTouchListener mGestureListener;

    public MyScrollView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        mGestureDetector = new GestureDetector(new YScrollDetector());
        setFadingEdgeLength(0);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        return super.onInterceptTouchEvent(ev)
                && mGestureDetector.onTouchEvent(ev);
    }

    class YScrollDetector extends GestureDetector.SimpleOnGestureListener
    {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY)
        {
            if (Math.abs(distanceY) > Math.abs(distanceX))
            {
                return true;
            }
            return false;
        }
    }
}
