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

   // protected abstract boolean hasToolBar();

    public void onClick(View view){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 经测试在代码里直接声明透明状态栏更有效
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
        // 这句很关键，注意是调用父类的方法
        super.setContentView(R.layout.activity_base);
        if(hasToolBar){
            initToolbar().setVisibility(View.VISIBLE);
        }
        //setStatusBarColor(this,R.color.colorStatusBar);


    }

    protected void setTitle(String msg) {
        if (title != null) {
            title.setText(msg);
        }
    }

    protected void setTitleRight(String msg) {
        if (tvRight != null) {
            tvRight.setText(msg);
        }
    }



    /**
     * sometime you want to define back event
     */
    protected void setBackBtn() {
        if (back != null) {
            back.setVisibility(View.VISIBLE);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } else {

        }

    }

    protected void setBackClickListener(View.OnClickListener l) {
        if (back != null) {
            back.setVisibility(View.VISIBLE);
            back.setOnClickListener(l);
        } else {

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

//   @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//   protected void setStatusBarColor(Activity activity, int statusColor) {
//        Window window = activity.getWindow();
//        //取消状态栏透明
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        //添加Flag把状态栏设为可绘制模式
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        //设置状态栏颜色
//        window.setStatusBarColor(statusColor);
//        //设置系统状态栏处于可见状态
//        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
//        //让view不根据系统窗口来调整自己的布局
//        ViewGroup mContentView = (ViewGroup) window.findViewById(Window.ID_ANDROID_CONTENT);
//        View mChildView = mContentView.getChildAt(0);
//        if (mChildView != null) {
//            ViewCompat.setFitsSystemWindows(mChildView, false);
//            ViewCompat.requestApplyInsets(mChildView);
//        }
//    }
}
