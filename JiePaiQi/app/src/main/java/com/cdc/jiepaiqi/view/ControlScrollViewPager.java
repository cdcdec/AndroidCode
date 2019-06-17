package com.cdc.jiepaiqi.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;


public class ControlScrollViewPager extends ViewPager {
    private boolean a = true;

    public ControlScrollViewPager(Context paramContext) {
        super(paramContext);
    }

    public ControlScrollViewPager(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        return (this.a && super.onInterceptTouchEvent(paramMotionEvent));
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        return (this.a && super.onTouchEvent(paramMotionEvent));
    }

    public void setScanScroll(boolean paramBoolean) {
        this.a = paramBoolean;
    }
}
