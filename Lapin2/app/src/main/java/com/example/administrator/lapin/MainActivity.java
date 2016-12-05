package com.example.administrator.lapin;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.lapin.fragment.CategoryFragment;
import com.example.administrator.lapin.fragment.LaPinFragment;
import com.example.administrator.lapin.fragment.MeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> mFList;

    private RadioGroup rg;
    private int mIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }
    private void initData() {
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        mFList=new ArrayList<>();
        LaPinFragment laPinFragment=new LaPinFragment();
        CategoryFragment categoryFragment=new CategoryFragment();
        MeFragment meFragment=new MeFragment();
        mFList.add(laPinFragment);
        mFList.add(categoryFragment);
        mFList.add(meFragment);
        //设置默认选中的fragment
        getSupportFragmentManager().beginTransaction().add(R.id.main_activity_continear,mFList.get(0)).commit();
        ((RadioButton)rg.getChildAt(0)).setChecked(true);


    }



    private void initView() {

        rg = ((RadioGroup) findViewById(R.id.main_activity_rg));
    }

    public void btnClick(View view) {
        //获取btn的id
        int id = view.getId();
        if (id==R.id.main_activity_rb_lapin){
            switchFragment(0);

        }else if(id==R.id.main_activity_rb_category){
            switchFragment(1);

        }else if(id==R.id.main_activity_rb_me){
            switchFragment(2);

        }

    }

    private void switchFragment(int index) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        //获取当前的fragment
        Fragment currentFragment = mFList.get(mIndex);
        //展示的fragment
        Fragment showfragment = mFList.get(index);
        //点击按钮控制fragment的显示和隐藏
        if(!showfragment.isAdded())
        {//如没有添加事务，则添加，并展示，隐藏当前的fragment
            fragmentTransaction.add(R.id.main_activity_continear,showfragment).hide(currentFragment).commit();
        }else{
            if(mIndex!=index) {
                //添加了直接展示，并隐藏当前的fragment
                fragmentTransaction.show(showfragment).hide(currentFragment).commit();
            }
        }
        mIndex=index;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        final AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("是否要退出程序");
        builder.setTitle("退出程序");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();
        return super.onKeyDown(keyCode, event);
    }
}
