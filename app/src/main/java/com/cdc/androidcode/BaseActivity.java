package com.cdc.androidcode;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView title;
    private ImageView back;
    private TextView tvRight;
    private LinearLayout rootLayout;
    protected boolean hasToolBar=true;
    public void onClick(View view){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 这句很关键，注意是调用父类的方法
        super.setContentView(R.layout.activity_base);
        if(hasToolBar){
            initToolbar().setVisibility(View.VISIBLE);
        }
    }
    protected void setTitle(String msg) {
        if (title != null) {
            title.setVisibility(View.VISIBLE);
            title.setText(msg);
        }
    }
    protected void setTitleRight(String msg) {
        if (tvRight != null) {
            tvRight.setVisibility(View.VISIBLE);
            tvRight.setText(msg);
        }
    }
    protected void setBackBtn() {
        if (back != null) {
            back.setVisibility(View.VISIBLE);
            back.setOnClickListener(v -> finish());
        }
    }
    private Toolbar initToolbar() {
        Toolbar toolbar =findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        if (getSupportActionBar() != null) {
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        }
        back =findViewById(R.id.img_back);
        title =findViewById(R.id.title);
        tvRight=findViewById(R.id.titleRight);
        return toolbar;
    }
    @Override
    public void setContentView(int layoutId) {
        setContentView(View.inflate(this, layoutId, null));
    }
    @Override
    public void setContentView(View view) {
        rootLayout =findViewById(com.chad.baserecyclerviewadapterhelper.R.id.root_layout);
        if (rootLayout == null) {
            return;
        }
        rootLayout.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        if(hasToolBar){
            initToolbar().setVisibility(View.VISIBLE);
        }
    }
}
