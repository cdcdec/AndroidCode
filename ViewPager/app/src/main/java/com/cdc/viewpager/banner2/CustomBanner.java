package com.cdc.viewpager.banner2;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class CustomBanner extends FrameLayout implements ViewPager.OnPageChangeListener{
    public CustomBanner( Context context) {
        super(context);
    }

    public CustomBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomBanner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
