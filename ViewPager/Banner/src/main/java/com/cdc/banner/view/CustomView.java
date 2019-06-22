package com.cdc.banner.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.cdc.banner.R;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;


public class CustomView extends FrameLayout {

    private StandardGSYVideoPlayer videoView;
    private ImageView imageView;


    private View viewRoot;
    private FrameLayout root;
    public CustomView(Context context) {
        super(context);
        init(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        viewRoot = LayoutInflater.from(context).inflate(R.layout.custom_view, this, true);
        videoView =(StandardGSYVideoPlayer) findViewById(R.id.vv);
        imageView = findViewById(R.id.iv);
        root = findViewById(R.id.root);
    }


    public StandardGSYVideoPlayer getVideoView() {
        return videoView;
    }

    public ImageView getImageView() {
        return imageView;
    }


}
