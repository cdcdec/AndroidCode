package com.example.gsyvideoplayer.customui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.example.gsyvideoplayer.R;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import moe.codeest.enviews.ENDownloadView;

public class CustomUiVideo extends StandardGSYVideoPlayer {

    //底部进度调
    private ProgressBar bottomProgressbar;

    private ImageView imageViewStart;

    public CustomUiVideo(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }

    public CustomUiVideo(Context context) {
        super(context);
    }

    public CustomUiVideo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void touchSurfaceMoveFullLogic(float absDeltaX, float absDeltaY) {
        super.touchSurfaceMoveFullLogic(absDeltaX, absDeltaY);
        //不给触摸快进，如果需要，屏蔽下方代码即可
        mChangePosition = false;
//
//        //不给触摸音量，如果需要，屏蔽下方代码即可
//        mChangeVolume = false;
//
//        //不给触摸亮度，如果需要，屏蔽下方代码即可
//        mBrightness = false;
    }

    @Override
    protected void init(Context context) {
        super.init(context);
        imageViewStart = findViewById(R.id.imageViewStart);
        bottomProgressbar = findViewById(R.id.bottomProgressbar);
        imageViewStart.setOnClickListener(this);

    }
long d;
    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        switch (id) {
            case R.id.imageViewStart:
                Log.e("123","mCurrentState="+mCurrentState);
                switch (mCurrentState) {
                    case CURRENT_STATE_NORMAL:
                        this.startPlayLogic();
                        imageViewStart.setImageResource(R.drawable.video_pause_pressed);
                        break;
                    case CURRENT_STATE_PREPAREING:

                        break;
                    case CURRENT_STATE_PLAYING:
                        this.onVideoPause();

                        imageViewStart.setImageResource(R.drawable.video_play_pressed);
                        break;
                    case CURRENT_STATE_PAUSE:
                        this.startPlayLogic();
                        this.seekTo(mCurrentPosition);
                        imageViewStart.setImageResource(R.drawable.video_pause_pressed);
                        break;
                    case CURRENT_STATE_ERROR:

                        break;
                    case CURRENT_STATE_AUTO_COMPLETE:

                        break;
                    case CURRENT_STATE_PLAYING_BUFFERING_START:

                        break;
                }
                break;
        }

    }

    @Override
    public int getLayoutId() {
        return R.layout.custom_control_video;
    }


    /**
     * 点击触摸显示和隐藏逻辑
     */
    @Override
    protected void onClickUiToggle() {
        if (mCurrentState == CURRENT_STATE_PREPAREING) {
            Log.e("123", "PREPAREING");

        } else if (mCurrentState == CURRENT_STATE_PLAYING) {
            Log.e("123", "CURRENT_STATE_PLAYING");

        } else if (mCurrentState == CURRENT_STATE_PAUSE) {
            Log.e("123", "CURRENT_STATE_PAUSE");

        } else if (mCurrentState == CURRENT_STATE_AUTO_COMPLETE) {
            Log.e("123", "CURRENT_STATE_AUTO_COMPLETE");

        } else if (mCurrentState == CURRENT_STATE_PLAYING_BUFFERING_START) {
            Log.e("123", "CURRENT_STATE_PLAYING_BUFFERING_START");

        }
    }


}
