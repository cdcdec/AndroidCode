package com.cdc.viewpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.cdc.viewpager.banner1.Banner1Activity;
import com.cdc.viewpager.banner2.Banner2Activity;
import com.cdc.viewpager.banner3.Banner3Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);


        //toBannerPage();
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent=new Intent();
        switch (id) {
            case R.id.btn1:
                intent.setClass(MainActivity.this, Banner1Activity.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                intent.setClass(MainActivity.this, Banner2Activity.class);
                startActivity(intent);
                break;
            case R.id.btn3:
                intent.setClass(MainActivity.this, Banner3Activity.class);
                startActivity(intent);
                break;
        }
    }

//    private void initView() {
//        viewPager1 = findViewById(R.id.viewPager1);
//
//        pagerAdapter1 = new PageAdapter1(this);
//
//        viewPager1.setAdapter(pagerAdapter1);
//
//        viewPager1.post(new Runnable() {
//            @Override
//            public void run() {
//                View view = viewPager1.findViewWithTag(0);
//                customVideoView = (CustomVideoView) view;
//                videoView = customVideoView.getVideoView();
//            }
//        });
//
//
//
//
//        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                if (positionOffset != 0) {
//                    if (lastValue >= positionOffsetPixels) {
//                        //右滑
//                        isLeft = false;
//                    } else if (lastValue < positionOffsetPixels) {
//                        //左滑
//                        isLeft = true;
//                    }
//                }
//                lastValue = positionOffsetPixels;
//
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                int count = pagerAdapter1.getCount();
//
//                currentPosition = position + 1;
//                View view = viewPager1.findViewWithTag(position);
//
//                CustomView customView = (CustomView) view;
//
//                customView.setTitle(currentPosition + "/" + count);
//                Log.e("123", "position=" + position);
//                if (position == 0) {
//                    if (!videoView.isPlaying()) {
//                        Log.e("123", "!videoView.isPlaying(),currentPlay=" + currentPlay);
//                        if (videoView.canSeekBackward()) {
//                            Log.e("123", "canPause" + currentPlay);
//                        }
//                        videoView.setVideoPath("android.resource://" + videoView.getContext().getPackageName() + "/" + R.raw.video1);
//                        videoView.start();
//                        videoView.seekTo(currentPlay);
//
//                        Log.e("123", "========");
//                    }
//                } else {
//                    Log.e("123", "position!=0");
//                    if (videoView != null) {
//                        Log.e("123", "videoView!=null");
//                        if (videoView.isPlaying()) {
//
//                            videoView.pause();
//                            currentPlay = videoView.getCurrentPosition();
//                            Log.e("123", "videoView.isPlaying()=" + currentPlay);
//                        } else {
//                            Log.e("123", "!videoView.isPlaying()=" + currentPlay);
//                        }
//                    }
//                }
//
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//
//        });
//
//
//    }
//
//    private void toBannerPage(){
//        btn1=findViewById(R.id.btn1);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent();
//                intent.setClass(MainActivity.this, BannerActivity.class);
//                MainActivity.this.startActivity(intent);
//            }
//        });
//    }


}
