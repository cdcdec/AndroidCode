package com.cdc.banner.loader;

import android.content.Context;
import android.widget.ImageView;


public abstract class ImageLoader implements ImageLoaderInterface<ImageView> {

    @Override
    public ImageView createImageView(Context context,int type) {
        ImageView imageView = new ImageView(context);
        return imageView;
    }

}
