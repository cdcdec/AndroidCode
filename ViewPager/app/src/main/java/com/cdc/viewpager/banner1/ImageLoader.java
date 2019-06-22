package com.cdc.viewpager.banner1;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.youth.banner.loader.ImageLoaderInterface;

public class ImageLoader implements ImageLoaderInterface<ImageView> {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Uri uri= (Uri) path;

        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageURI(uri);
    }

    @Override
    public ImageView createImageView(Context context) {
        ImageView imageView=new ImageView(context);
        return imageView;
    }
}
