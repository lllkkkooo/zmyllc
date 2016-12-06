package com.example.administrator.lapin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GoodCategory2Activity extends AppCompatActivity {
private String name;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_category2);
        getSupportActionBar().hide();
        Intent intent=getIntent();
        name=intent.getExtras().getString("name");
        id=intent.getExtras().getInt("id");
    }
}
