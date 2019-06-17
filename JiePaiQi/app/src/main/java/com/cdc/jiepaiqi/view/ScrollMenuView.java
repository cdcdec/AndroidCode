package com.cdc.jiepaiqi.view;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.cdc.jiepaiqi.R;

public class ScrollMenuView extends RelativeLayout {
    public ImageView backImage;

    public ImageView scrollImage;

    public ImageView redCircle;
    public ImageView scrollImageV;

    public Button scrollMenuBtn;

    public int e = 0;

    public Point f;

    private a g;

    private Point h;

    private Point i;

    private Point j;

   // @SuppressLint({"ClickableViewAccessibility"})
    public ScrollMenuView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        View view=LayoutInflater.from(paramContext).inflate(R.layout.view_scrollmenu, this);
        this.scrollMenuBtn = view.findViewById(R.id.scrollMenuBtn);
        this.backImage = (ImageView)findViewById(R.id.backImage);
        this.scrollImage = (ImageView)findViewById(R.id.scrollImage);
        this.redCircle = (ImageView)findViewById(R.id.redCircle);
        this.scrollImageV = (ImageView)findViewById(R.id.scrollImageV);
        /*this.backImage.setOnTouchListener(new View.OnTouchListener(this) {
            public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
                int i = param1MotionEvent.getAction();
                if (i == 0) {
                    this.a.b.setAnimation(null);*//**//*
                    this.a.b.setVisibility(0);
                    this.a.a(this.a.e, true);
                    ScrollMenuView.a(this.a, new Point((int)param1MotionEvent.getX(), (int)param1MotionEvent.getY()));
                    if (ScrollMenuView.a(this.a) == null) {
                        i = View.MeasureSpec.makeMeasureSpec(0, 0);
                        int j = View.MeasureSpec.makeMeasureSpec(0, 0);
                        this.a.a.measure(i, j);
                        i = this.a.a.getWidth();
                        j = this.a.a.getHeight();
                        ScrollMenuView.b(this.a, new Point(i / 2, j / 2));
                    }
                    this.a.f = new Point((int)param1MotionEvent.getRawX(), (int)param1MotionEvent.getRawY());
                    ScrollMenuView.b(this.a).a();
                    return true;
                }
                if (i == 2) {
                    ScrollMenuView.c(this.a, new Point((int)param1MotionEvent.getX(), (int)param1MotionEvent.getY()));
                    i = h.a(Math.atan2(((ScrollMenuView.c(this.a)).y - (ScrollMenuView.a(this.a)).y), ((ScrollMenuView.c(this.a)).x - (ScrollMenuView.a(this.a)).x)) - Math.atan2(((ScrollMenuView.d(this.a)).y - (ScrollMenuView.a(this.a)).y), ((ScrollMenuView.d(this.a)).x - (ScrollMenuView.a(this.a)).x)));
                    ScrollMenuView.a(this.a, ScrollMenuView.c(this.a));
                    this.a.a(i + this.a.e, true);
                    ScrollMenuView.b(this.a).a(this.a.e);
                    return true;
                }
                if (i == 1) {
                    this.a.b.setAnimation(null);
                    this.a.b.setVisibility(8);
                    ScrollMenuView.b(this.a).b(this.a.e);
                    return true;
                }
                return true;
            }
        });*/
    }

    public int a(int paramInt) {
        if (paramInt < 0)
            return paramInt + 360;
        int k = paramInt;
        return (paramInt > 360) ? (paramInt - 360) : k;
    }

    public void a(int paramInt, boolean paramBoolean) {
       /* Log.d("angle", "" + paramInt);
        paramInt = a(paramInt);
        RotateAnimation rotateAnimation = new RotateAnimation(this.e, paramInt, true, 0.5F, true, 0.5F);
        rotateAnimation.setDuration(0L);
        rotateAnimation.setFillAfter(true);
        if (paramBoolean)
            this.c.startAnimation(rotateAnimation);
        this.b.startAnimation(rotateAnimation);
        this.a.startAnimation(rotateAnimation);
        this.e = paramInt;*/
    }

    public void setScrollAngleCallbacl(a parama) { this.g = parama; }

    public static interface a {
        void a();

        void a(int param1Int);

        void b(int param1Int);
    }
}
