package com.cdc.viewpager.banner3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.cdc.banner.Banner;
import com.cdc.banner.listener.BannerVideo;
import com.cdc.viewpager.DateUtil;
import com.cdc.viewpager.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.listener.VideoAllCallBack;
import com.shuyu.gsyvideoplayer.model.VideoOptionModel;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

import java.util.ArrayList;
import java.util.List;


public class Banner3Activity extends AppCompatActivity {

    private StandardGSYVideoPlayer player;
    long dur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner3);
        Banner banner=findViewById(R.id.banner3);
        banner.setImageLoader(new ImageLoader3());
        banner.setImages(DateUtil.getListUri(this));
        banner.setBannerVideo(new BannerVideo() {
            @Override
            public void bannerVideo(StandardGSYVideoPlayer player0) {
                player=player0;
                player.getFullscreenButton().setVisibility(View.GONE);
                player.getTitleTextView().setVisibility(View.GONE);
                player.getBackButton().setVisibility(View.GONE);

                player.setVideoAllCallBack(new VideoAllCallBack() {
                    @Override
                    public void onStartPrepared(String url, Object... objects) {

                    }

                    @Override
                    public void onPrepared(String url, Object... objects) {

                    }

                    @Override
                    public void onClickStartIcon(String url, Object... objects) {
                        Log.e("123","onClickStartIcon");
                        if(dur>0){
                            Log.e("123","onClickStartIcon="+dur);

                            //player.seekTo(dur);

                            VideoOptionModel videoOptionModel =
                                    new VideoOptionModel(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "seek-at-start", (int) dur);
                            List<VideoOptionModel> list = new ArrayList<>();
                            list.add(videoOptionModel);
                            GSYVideoManager.instance().setOptionModelList(list);
                            player.startPlayLogic();
                        }else{
                            VideoOptionModel videoOptionModel =
                                    new VideoOptionModel(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "seek-at-start", 0);
                            List<VideoOptionModel> list = new ArrayList<>();
                            list.add(videoOptionModel);
                            GSYVideoManager.instance().setOptionModelList(list);
                        }
                    }

                    @Override
                    public void onClickStartError(String url, Object... objects) {

                    }

                    @Override
                    public void onClickStop(String url, Object... objects) {

                    }

                    @Override
                    public void onClickStopFullscreen(String url, Object... objects) {

                    }

                    @Override
                    public void onClickResume(String url, Object... objects) {

                    }

                    @Override
                    public void onClickResumeFullscreen(String url, Object... objects) {

                    }

                    @Override
                    public void onClickSeekbar(String url, Object... objects) {

                    }

                    @Override
                    public void onClickSeekbarFullscreen(String url, Object... objects) {

                    }

                    @Override
                    public void onAutoComplete(String url, Object... objects) {
                        dur=0;

                    }

                    @Override
                    public void onEnterFullscreen(String url, Object... objects) {

                    }

                    @Override
                    public void onQuitFullscreen(String url, Object... objects) {

                    }

                    @Override
                    public void onQuitSmallWidget(String url, Object... objects) {

                    }

                    @Override
                    public void onEnterSmallWidget(String url, Object... objects) {

                    }

                    @Override
                    public void onTouchScreenSeekVolume(String url, Object... objects) {

                    }

                    @Override
                    public void onTouchScreenSeekPosition(String url, Object... objects) {

                    }

                    @Override
                    public void onTouchScreenSeekLight(String url, Object... objects) {

                    }

                    @Override
                    public void onPlayError(String url, Object... objects) {

                    }

                    @Override
                    public void onClickStartThumb(String url, Object... objects) {

                    }

                    @Override
                    public void onClickBlank(String url, Object... objects) {

                    }

                    @Override
                    public void onClickBlankFullscreen(String url, Object... objects) {

                    }
                });
            }

            @Override
            public void bannerVideoDuration(long duration) {
                dur=duration;
            }
        });




        banner.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        if(player!=null){
            player.onVideoPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(player!=null){
            player.onVideoResume();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoManager.releaseAllVideos();

    }

}
