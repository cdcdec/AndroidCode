package com.example.gsyvideoplayer.customui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gsyvideoplayer.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.player.IPlayerManager;

public class CustomUiActivity extends AppCompatActivity {

    private  CustomUiVideo customUiVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_ui);

        customUiVideo=findViewById(R.id.customVideo);

        customUiVideo.setUp("http://flv3.bn.netease.com/videolib3/1709/20/TItLA5448/SD/TItLA5448-mobile.mp4",true,"");




    }

    @Override
    protected void onPause() {
        super.onPause();
        customUiVideo.onVideoPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        customUiVideo.onVideoResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoManager.releaseAllVideos();
    }
}
