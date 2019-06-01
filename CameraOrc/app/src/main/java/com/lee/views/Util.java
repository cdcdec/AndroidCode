package com.lee.views;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Util {
    private ImageView imageView;
    private int realImgShowWidth, realImgShowHeight;

    private void getImgDisplaySize() {
        Drawable imgDrawable = imageView.getDrawable();
        if (imgDrawable != null) {
            //获得ImageView中Image的真实宽高，
            int dw = mCurrentImage.getDrawable().getBounds().width();
            int dh = mCurrentImage.getDrawable().getBounds().height();

            //获得ImageView中Image的变换矩阵
            Matrix m = mCurrentImage.getImageMatrix();
            float[] values = new float[10];
            m.getValues(values);

            //Image在绘制过程中的变换矩阵，从中获得x和y方向的缩放系数
            float sx = values[0];
            float sy = values[4];

            //计算Image在屏幕上实际绘制的宽高
            realImgShowWidth = (int) (dw * sx);
            realImgShowHeight = (int) (dh * sy);
        }
    }

}
