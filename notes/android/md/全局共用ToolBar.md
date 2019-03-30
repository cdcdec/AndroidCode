# 全局共用ToolBar

需求:在一个Android应用里面共用一个ToolBar,除了首页外其它布局都是左侧返回按钮，中间显示一个文字标题，有些页面ToolBar右侧也有文字。

实现方法:在BaseActivity里面写一个布局，在这个布局里面实现这样的ToolBar，同时提供方法供子类调用以实现有无ToolBar,有无右侧文字等需求。

特点:不需要在每个需要ToolBar的页面添加ToolBar控件，但是每个页面布局其实都多嵌套了一层LinearLayout

### BaseActivity.java
```
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

```

### activity_base.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:app="http://schemas.android.com/apk/res-auto"
              android:id="@+id/root_layout"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:fitsSystemWindows="true"
              android:orientation="vertical"
              >
    <androidx.appcompat.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@color/colorPrimary"
            android:minHeight="?attr/actionBarSize"
            android:visibility="gone"
           >

        <androidx.constraintlayout.widget.ConstraintLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent">

            <ImageView
                    android:id="@+id/img_back"
                    android:src="@mipmap/icon_back_left_arrow"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    app:layout_constraintLeft_toLeftOf="parent"
                    app:layout_constraintTop_toTopOf="parent"
                    app:layout_constraintBottom_toBottomOf="parent"
                    android:visibility="gone"

            />
            <TextView
                    android:id="@+id/titleRight"
                    android:layout_width="wrap_content"
                    android:layout_height="match_parent"
                    android:layout_marginRight="5dp"
                    app:layout_constraintRight_toRightOf="parent"
                    android:gravity="center_vertical|center_horizontal"
                    android:text=""
                    app:layout_constraintTop_toTopOf="parent"
                    app:layout_constraintBottom_toBottomOf="parent"
                    android:textColor="#ffffff"
                    android:textSize="16sp"
                    android:visibility="gone"
            />

            <TextView
                    android:id="@+id/title"
                    android:layout_width="wrap_content"
                    android:layout_height="match_parent"
                    android:layout_marginLeft="10dp"
                    app:layout_constraintRight_toLeftOf="@id/titleRight"
                    app:layout_constraintLeft_toRightOf="@id/img_back"
                    android:gravity="center_vertical|center_horizontal"
                    app:layout_constraintTop_toTopOf="parent"
                    app:layout_constraintBottom_toBottomOf="parent"
                    android:text=""
                    android:textColor="#ffffff"
                    android:textSize="16sp"
                    android:visibility="gone"
            />
        </androidx.constraintlayout.widget.ConstraintLayout>
    </androidx.appcompat.widget.Toolbar>
</LinearLayout>

```

### 子类调用

```
//不需要ToolBar时
override fun onCreate(savedInstanceState: Bundle?) {
        super.hasToolBar=false//不需要ToolBar  主要调用位置
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

//
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //左侧返回按钮  中间 右侧文字;   需要时调用  不需要那个就不调用相应的方法
        setBackBtn()
        setTitle("中间")
        setTitleRight("右边")
        setContentView(R.layout.activity_immersionbar_main)
    }


```





