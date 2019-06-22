package com.cdc.viewpager.banner3;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.cdc.banner.loader.ImageLoaderInterface;
import com.cdc.banner.view.CustomView;


public class ImageLoader3 implements ImageLoaderInterface<View> {
    @Override
    public void displayImage(Context context, Object path, View imageView) {
        Uri uri = (Uri) path;

        CustomView customView= (CustomView) imageView;

        if (type == 1) {
            customView.getImageView().setVisibility(View.GONE);
            customView.getVideoView().setVisibility(View.VISIBLE);
            //videoView.start();
        } else if (type == 2) {
            customView.getVideoView().setVisibility(View.GONE);
            ImageView imageView1 = customView.getImageView();
            imageView1.setVisibility(View.VISIBLE);
            imageView1.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView1.setImageURI(uri);
        } else {
            return;
        }

//        ImageView imageView1 = (ImageView) imageView;
//        imageView1.setScaleType(ImageView.ScaleType.FIT_XY);
//        imageView1.setImageURI(uri);

//                if (type == 1) {
//            TextView videoView = (TextView) imageView;
//            videoView.setText(((Uri) path).getPath());
//        } else if (type == 2) {
//            ImageView imageView1 = (ImageView) imageView;
//            imageView1.setScaleType(ImageView.ScaleType.FIT_XY);
//            imageView1.setImageURI(uri);
//        } else {
//            return;
//        }


        //Log.e("123", "======displayImage====type=="+type);
    }

    private int type = 0;

    @Override
    public View createImageView(Context context, int type) {
        this.type = type;
       CustomView customView=new CustomView(context);

        return customView;


    }
}

