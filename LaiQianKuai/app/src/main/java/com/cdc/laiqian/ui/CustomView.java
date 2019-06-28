package com.cdc.laiqian.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class CustomView extends RelativeLayout {
    final int dvP = Color.parseColor("#E2E2E2");

    int dvQ;

    public boolean dvR = false;

    boolean dvS = false;

    public CustomView(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }

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
}
