package com.gyf.immersionbar.simple.myimmerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.gyf.immersionbar.simple.R;

public class MyDemoMainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_demo_main);
    }

    public void picDemo(View view){
        Intent intent=new Intent();
        intent.setClass(this, MyPicDemoActivity.class);
        startActivity(intent);
    }


}
