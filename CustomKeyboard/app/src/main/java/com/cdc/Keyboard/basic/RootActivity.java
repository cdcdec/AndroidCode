package com.cdc.keyboard.basic;

import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.cdc.keyboard.R;

public class RootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_root);


    }

    protected void goToPage(Class<?> cla){
        Intent intent=new Intent();
        intent.setClass(this,cla);
        startActivity(intent);
    }




    public void closeActivity(View view) {
        finish();
    }


    //You cannot combine custom titles with other title features
    protected void setContentViewSetCustomTitle(int id){
        this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(id);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.activity_root);

    }

    protected void setContentViewNoTitle(int id){
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(id);
    }

    protected void setTitleTextView(int id){

    }

    protected void setTitleTextView(String string){
        TextView textView= getTextViewLeft();
        if(textView!=null){
            textView.setText(string);
        }

    }

    protected TextView getTextViewLeft(){
        TextView textView= findViewById(R.id.titleTextRootLeft);
        return textView;
    }


    protected TextView getTextViewRight(){
        TextView textView= findViewById(R.id.titleRightText);
        return textView;
    }

    protected void setTitleTextViewRight(String string){
        TextView textView= getTextViewRight();
        if(textView!=null){
            textView.setText(string);
        }
    }

    protected FrameLayout getFragmentCenter(){
        FrameLayout frameLayout=findViewById(R.id.centerFragment);
        return frameLayout;
    }





}
