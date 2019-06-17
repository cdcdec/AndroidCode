package com.cdc.jiepaiqi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WheelView extends ScrollView {
    private Runnable runnable;

    private Context context;
    private LinearLayout linearLayout;

    public WheelView(Context context) {
        super(context);
        init(context);
    }

    public WheelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WheelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context paramContext) {
        this.context = paramContext;
        setVerticalScrollBarEnabled(false);
        this.linearLayout = new LinearLayout(paramContext);
        this.linearLayout.setOrientation(LinearLayout.VERTICAL);
        addView(this.linearLayout);



    }
}
