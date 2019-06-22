package com.cdc.viewpager.banner1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.cdc.viewpager.DateUtil;
import com.cdc.viewpager.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

public class Banner1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner1);
        Banner banner=findViewById(R.id.banner1);
        banner.setImageLoader(new ImageLoader());
        banner.setImages(DateUtil.getListUri(this));
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.isAutoPlay(false);
        banner.start();
    }
}
