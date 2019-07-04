package com.cdc.keyboard.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class CustomView extends RelativeLayout{

    final int dvP = Color.parseColor("#E2E2E2");

    int dvQ;

    public boolean dvR = false;

    boolean dvS = false;

    protected void onAnimationEnd() {
        super.onAnimationEnd();
        this.dvS = false;
    }

    protected void onAnimationStart() {
        super.onAnimationStart();
        this.dvS = true;
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if (this.dvS)
            invalidate();
    }

    public void setEnabled(boolean paramBoolean) {
        super.setEnabled(paramBoolean);
        if (paramBoolean) {
            setBackgroundColor(this.dvQ);
        } else {
            setBackgroundColor(this.dvP);
        }
        invalidate();
    }

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
