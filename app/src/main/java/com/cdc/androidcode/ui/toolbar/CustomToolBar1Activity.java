package com.cdc.androidcode.ui.toolbar;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.cdc.androidcode.R;

public class CustomToolBar1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tool_bar1);

        TitleToolBar titleToolBar=findViewById(R.id.titleToolBar);
        titleToolBar.setOnOptionItemClickListener((view)->{
            switch (view.getId()) {
                case R.id.title_toolbar_back:
                    finish();
                    break;
                case R.id.title_toolbar_close:
                    Toast.makeText(this, "关闭", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.title_toolbar_title:
                    Toast.makeText(this, "主标题", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.title_toolbar_subTitle:
                    Toast.makeText(this, "副标题", Toast.LENGTH_SHORT).show();
                    break;


            }
        });



//        setSupportActionBar(titleToolBar);


    }
}
