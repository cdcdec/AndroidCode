package com.xujun.drag.widget;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @ explain:这个ScrlloView不拦截水平滑动事件，
 * 是用来解决 ScrollView里面嵌套ViewPager使用的
 * @ author：xujun on 2016/10/25 15:28
 * @ email：gdutxiaoxu@163.com
 */
public class VerticalNestScrollView extends NestedScrollView {

    public VerticalNestScrollView(Context context) {
        super(context);
    }

    public VerticalNestScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalNestScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    private float mDownPosX = 0;
    private float mDownPosY = 0;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final float x = ev.getX();
        final float y = ev.getY();

        final int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mDownPosX = x;
                mDownPosY = y;

                break;
            case MotionEvent.ACTION_MOVE:
                final float deltaX = Math.abs(x - mDownPosX);
                final float deltaY = Math.abs(y - mDownPosY);
                // 这里是够拦截的判断依据是左右滑动，读者可根据自己的逻辑进行是否拦截
                if (deltaX > deltaY) {
                    return false;
                }
        }

        return super.onInterceptTouchEvent(ev);
    }
}
