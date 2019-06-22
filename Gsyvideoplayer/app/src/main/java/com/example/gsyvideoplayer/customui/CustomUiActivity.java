package com.example.gsyvideoplayer.customui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.gsyvideoplayer.R;

public class CustomUiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_ui);

        CustomUiVideo customUiVideo=findViewById(R.id.customVideo);

        customUiVideo.setUp("http://flv3.bn.netease.com/videolib3/1709/20/TItLA5448/SD/TItLA5448-mobile.mp4",true,"");


    }
}
