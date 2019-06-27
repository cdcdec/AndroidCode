package com.example.gsyvideoplayer.customui;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.example.gsyvideoplayer.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.listener.GSYVideoProgressListener;
import com.shuyu.gsyvideoplayer.model.VideoOptionModel;
import com.shuyu.gsyvideoplayer.player.IPlayerManager;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CustomUiVideo extends StandardGSYVideoPlayer {

    //底部进度调
    private ProgressBar bottomProgressbar;

    private ImageView imageViewStart;

    private ImageView imageViewVolume;

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

    private Context context;

    @Override
    protected void init(Context context) {
        super.init(context);
        this.context = context;
        imageViewStart = findViewById(R.id.imageViewStart);
        bottomProgressbar = findViewById(R.id.bottomProgressbar);

        imageViewStart.setOnClickListener(this);

        imageViewVolume = findViewById(R.id.imageViewVolume);
        imageViewVolume.setOnClickListener(this);



    }

    long d;

    boolean isMute = true;

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int id = v.getId();
        switch (id) {
            case R.id.imageViewStart:
                Log.e("123", "mCurrentState=" + mCurrentState);
                switch (mCurrentState) {
                    case CURRENT_STATE_NORMAL:
                        this.startPlayLogic();
                        imageViewStart.setImageResource(R.drawable.pause);
                        imageViewVolume.setVisibility(View.VISIBLE);
                        startProgressTimer();
                        break;
                    case CURRENT_STATE_PREPAREING:
                        resetProgressAndTime();
                        break;
                    case CURRENT_STATE_PLAYING:
                        startProgressTimer();
                        this.onVideoPause();
                        d = this.mCurrentPosition;
                        Log.e("123", "pause:" + d);

                        imageViewStart.setImageResource(R.drawable.play);
                        imageViewVolume.setVisibility(View.GONE);
                        break;
                    case CURRENT_STATE_PAUSE:
                        startProgressTimer();
                        if (d > 0) {
                            VideoOptionModel videoOptionModel =
                                    new VideoOptionModel(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "seek-at-start", (int) d);
                            List<VideoOptionModel> list = new ArrayList<>();
                            list.add(videoOptionModel);
                            GSYVideoManager.instance().setOptionModelList(list);
                            Log.e("123", "CURRENT_STATE_PAUSE:" + this.mCurrentPosition + "," + d);
                            this.startPlayLogic();
                        } else {
                            this.startPlayLogic();
                        }
                        imageViewVolume.setVisibility(View.VISIBLE);
                        imageViewStart.setImageResource(R.drawable.play);
                        break;
                    case CURRENT_STATE_ERROR:

                        break;
                    case CURRENT_STATE_AUTO_COMPLETE:
                        if (mBottomProgressBar != null) {
                            mBottomProgressBar.setProgress(100);
                        }
                        d = this.mCurrentPosition;
                        Log.e("123", "COMPLETE:" + d);
                        imageViewStart.setImageResource(R.drawable.play);
                        imageViewVolume.setVisibility(View.GONE);
                        cancelProgressTimer();
                        break;
                    case CURRENT_STATE_PLAYING_BUFFERING_START:

                        break;
              }
                break;

            case R.id.imageViewVolume:
                if (isMute) {
                    silentSwitchOff();
                    isMute = false;
                    imageViewVolume.setImageResource(R.drawable.volume_silent_no);
                } else {
                    silentSwitchOn();
                    isMute = true;
                    imageViewVolume.setImageResource(R.drawable.volume_mute);
                }
                break;
        }

    }

    private class MyProgressTimerTask extends TimerTask {
        @Override
        public void run() {
            if (mCurrentState == CURRENT_STATE_PLAYING || mCurrentState == CURRENT_STATE_PAUSE) {
                new Handler(Looper.getMainLooper()).post(
                        new Runnable() {
                            @Override
                            public void run() {
                                setTextAndProgress(0);
                            }
                        }
                );
            }
        }
    }

    public void setTextAndProgress(int secProgress) {
        int position = getCurrentPositionWhenPlaying();
        int duration = getDuration();
        int progress = position * 100 / (duration == 0 ? 1 : duration);
        Log.e("123","progress="+progress);
        setProgressAndTime(progress, secProgress, position, duration);
    }
    private  GSYVideoProgressListener mGSYVideoProgressListener;
    //定时器任务
    public MyProgressTimerTask mProgressTimerTask;
    public void setProgressAndTime(int progress, int secProgress, int currentTime, int totalTime) {
        if (mGSYVideoProgressListener != null && mCurrentState == CURRENT_STATE_PLAYING) {
            mGSYVideoProgressListener.onProgress(progress, secProgress, currentTime, totalTime);
        }
        if (getGSYVideoManager().getBufferedPercentage() > 0) {
            secProgress = getGSYVideoManager().getBufferedPercentage();
        }
        if (secProgress > 94) secProgress = 100;
        setSecondaryProgress(secProgress);

        if (bottomProgressbar != null) {
            if (progress != 0) bottomProgressbar.setProgress(progress);
            setSecondaryProgress(secProgress);
        }
    }

    public void setSecondaryProgress(int secProgress) {
        if (bottomProgressbar != null) {
            if (secProgress != 0 && !getGSYVideoManager().isCacheFile()) {
                bottomProgressbar.setSecondaryProgress(secProgress);
            }
        }
    }



    public void startProgressTimer() {
        cancelProgressTimer();
        updateProcessTimer = new Timer();
        mProgressTimerTask = new MyProgressTimerTask();
        updateProcessTimer.schedule(mProgressTimerTask, 0, 300);
    }

    public void cancelProgressTimer() {
        if (updateProcessTimer != null) {
            updateProcessTimer.cancel();
            updateProcessTimer = null;
        }
        if (mProgressTimerTask != null) {
            mProgressTimerTask.cancel();
            mProgressTimerTask = null;
        }

    }


    public void resetProgressAndTime() {
        if (mBottomProgressBar != null) {
            mBottomProgressBar.setProgress(0);
            mBottomProgressBar.setSecondaryProgress(0);
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

    private void silentSwitchOn() {

        IPlayerManager iPlayerManager = GSYVideoManager.instance().getCurPlayerManager();
        if(iPlayerManager!=null){
            iPlayerManager.setNeedMute(true);
            Log.e("123", "RINGING 已被静音");
        }



    }

    private void silentSwitchOff() {
        IPlayerManager iPlayerManager = GSYVideoManager.instance().getCurPlayerManager();
        if(iPlayerManager!=null){
            iPlayerManager.setNeedMute(false);
            Log.e("123", "RINGING 取消静音");
        }

    }

    /**
     * 进度回调
     */
    public void setGSYVideoProgressListener(GSYVideoProgressListener videoProgressListener) {
        this.mGSYVideoProgressListener = videoProgressListener;
    }


}
