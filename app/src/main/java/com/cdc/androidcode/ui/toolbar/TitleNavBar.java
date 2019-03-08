package com.cdc.androidcode.ui.toolbar;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;

public class TitleNavBar extends ViewGroup {
    public TitleNavBar(Context context) {
        super(context);
    }

    public TitleNavBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TitleNavBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TitleNavBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
