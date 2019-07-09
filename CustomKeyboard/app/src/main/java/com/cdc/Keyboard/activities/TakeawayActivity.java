package com.cdc.keyboard.activities;

import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.cdc.keyboard.R;
import com.cdc.keyboard.basic.RootActivity;
import me.jessyan.autosize.utils.AutoSizeUtils;

public class TakeawayActivity extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentViewSetCustomTitle(R.layout.activity_takeaway);
        setTitleTextView("外卖");
        setTitleTextViewRight("设置");
        setCenterContent();




    }

    private void setCenterContent(){
        FrameLayout frameLayout=getFragmentCenter();
        RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(frameLayout.getLayoutParams());
        layoutParams.width= AutoSizeUtils.dp2px(this,300.0f);
        layoutParams.height= RelativeLayout.LayoutParams.MATCH_PARENT;
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.addView(LayoutInflater.from(this).inflate(R.layout.takeaway_content,null));

    }
}
