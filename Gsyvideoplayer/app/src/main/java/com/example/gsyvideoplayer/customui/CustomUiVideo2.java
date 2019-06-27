package com.example.gsyvideoplayer.customui;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.*;
import com.example.gsyvideoplayer.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.listener.GSYVideoProgressListener;
import com.shuyu.gsyvideoplayer.listener.VideoAllCallBack;
import com.shuyu.gsyvideoplayer.model.VideoOptionModel;
import com.shuyu.gsyvideoplayer.player.IPlayerManager;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

import java.util.*;

public class CustomUiVideo2 extends StandardGSYVideoPlayer{

    //播放按键
    private ImageView startIv;

    private ImageView loadingIv;
    private ProgressBar bottomProgressbar;
    private LinearLayout layoutBottom;
    private ImageView volumeIv;
    private TextView currentTv;
    private SeekBar progressSeekBar;
    private TextView totalTv;

    private RelativeLayout surfaceContainer;
    private RelativeLayout thumbRel;

    //视频回调
    private VideoAllCallBack mVideoAllCallBack;

    /**
     * 设置播放过程中的回调
     *
     * @param mVideoAllCallBack
     */
    public void setVideoAllCallBack(VideoAllCallBack mVideoAllCallBack) {
        this.mVideoAllCallBack = mVideoAllCallBack;
    }


    private Context context;


    public CustomUiVideo2(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }
    public CustomUiVideo2(Context context) {
        super(context);

    }

    public CustomUiVideo2(Context context, AttributeSet attrs) {
        super(context, attrs);


    }

    @Override
    protected void init(Context context) {
        super.init(context);
        this.context = context;
        startIv = findViewById(R.id.startIv);
        loadingIv = findViewById(R.id.loadingIv);
        bottomProgressbar = findViewById(R.id.bottomProgressbar);
        layoutBottom = findViewById(R.id.layoutBottom);
        volumeIv = findViewById(R.id.volumeIv);
        currentTv = findViewById(R.id.currentTv);
        progressSeekBar = findViewById(R.id.progressSeekBar);
        totalTv = findViewById(R.id.totalTv);
        thumbRel = findViewById(R.id.thumbRel);

        if (startIv != null) {
            startIv.setOnClickListener(this);
        }

        if (progressSeekBar != null) {
            progressSeekBar.setOnSeekBarChangeListener(this);
            progressSeekBar.setOnTouchListener(this);
        }
        if (layoutBottom != null) {
            layoutBottom.setOnClickListener(this);
        }

        if (thumbRel != null) {
            thumbRel.setVisibility(GONE);
            thumbRel.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        switch (i) {
            case R.id.startIv:
                Log.e("222","===1===");
                clickImageViewStart(mCurrentState);

                break;
        }
    }

    private void clickImageViewStart(int state) {
        switch (state) {
            case CURRENT_STATE_NORMAL:
                if (mVideoAllCallBack != null){
                    mVideoAllCallBack.onClickStartIcon(mOriginUrl, mTitle, this);
                }
                this.startPlayLogic();


                break;

            case CURRENT_STATE_ERROR:
                if (mVideoAllCallBack != null){
                    mVideoAllCallBack.onClickStartError(mOriginUrl, mTitle, this);
                }


                break;
            case CURRENT_STATE_PREPAREING:
                if (mVideoAllCallBack != null){
                    mVideoAllCallBack.onStartPrepared(mOriginUrl, mTitle, this);
                }


                break;
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.custom_control_video2;
    }
}
