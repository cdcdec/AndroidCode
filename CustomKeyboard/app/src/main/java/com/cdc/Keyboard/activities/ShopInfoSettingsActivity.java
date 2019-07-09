package com.cdc.keyboard.activities;
import android.os.Bundle;
import com.cdc.keyboard.R;
import com.cdc.keyboard.basic.RootActivity;

public class ShopInfoSettingsActivity extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_shop_info_settings);
        setContentViewSetCustomTitle(R.layout.activity_shop_info_settings);
        setTitleTextView("店铺信息");
        setTitleTextViewRight("保存");

        //title_text  title_right_text  title_center_customize title_right_customize  title_right_refresh_text  title_right_refresh_text_progress

        //title_right_text_progress  title_right_setting_text title_right_setting_text_progress  layout.pos_title  fl_refresh

        //title_right_refresh_text
    }


}
