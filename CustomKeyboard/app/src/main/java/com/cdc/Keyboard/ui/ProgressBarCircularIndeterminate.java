package com.cdc.keyboard.ui;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;
import com.cdc.keyboard.R;
import com.cdc.keyboard.util.Utils;

public class ProgressBarCircularIndeterminate extends CustomView{

    private Paint anR;

    int backgroundColor = Color.parseColor("#1E88E5");

    int dwA = 0;

    float dwt = 0.0F;

    float dwu = 0.0F;

    int dwv = 0;

    boolean dww = false;

    int dwx = 1;

    int dwy = 0;

    float dwz = 0.0F;



    /*public ProgressBarCircularIndeterminate(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);

    }
*/
    public ProgressBarCircularIndeterminate(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        qI();
        m(paramAttributeSet);
    }

    private void initData() {
        this.dwt = 0.0F;
        this.dwu = 0.0F;
        this.dwv = 0;
        this.dww = false;
    }

    private void k(Canvas paramCanvas) {
        if (this.dwt < (getWidth() / 2)) {
            float f;
            this.anR.setColor(aqR());
            this.anR.setXfermode(null);
            if (this.dwt >= (getWidth() / 2)) {
                f = getWidth() / 2.0F;
            } else {
                f = this.dwt + 1.0F;
            }
            this.dwt = f;
            paramCanvas.drawCircle((getWidth() / 2), (getHeight() / 2), this.dwt, this.anR);
            return;
        }
        Bitmap bitmap = Bitmap.createBitmap(paramCanvas.getWidth(), paramCanvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        this.anR.setColor(aqR());
        this.anR.setXfermode(null);
        canvas.drawCircle((getWidth() / 2), (getHeight() / 2), (getHeight() / 2), this.anR);
        this.anR.setColor(getResources().getColor(R.color.red_text));//17170445
        this.anR.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        if (this.dwv >= 50) {
            float f;
            if (this.dwu >= (getWidth() / 2)) {
                f = getWidth() / 2.0F;
            } else {
                f = 1.0F + this.dwu;
            }
            this.dwu = f;
        } else {
            float f;
            if (this.dwu >= (getWidth() / 2 - Utils.sizeConversion(3.0F, getResources()))) {
                f = getWidth() / 2.0F - Utils.sizeConversion(3.0F, getResources());
            } else {
                f = 1.0F + this.dwu;
            }
            this.dwu = f;
        }
        canvas.drawCircle((getWidth() / 2), (getHeight() / 2), this.dwu, this.anR);
        paramCanvas.drawBitmap(bitmap, 0.0F, 0.0F, null);
        if (this.dwu >= (getWidth() / 2 - Utils.sizeConversion(3.0F, getResources())))
            this.dwv++;
        if (this.dwu >= (getWidth() / 2))
            this.dww = true;
    }

    private void l(Canvas paramCanvas) {
        if (this.dwy == this.dwA)
            this.dwx += 6;
        if (this.dwx >= 290 || this.dwy > this.dwA) {
            this.dwy += 6;
            this.dwx -= 6;
        }
        if (this.dwy > this.dwA + 290) {
            this.dwA = this.dwy;
            this.dwy = this.dwA;
            this.dwx = 1;
        }
        this.dwz += 4.0F;
        paramCanvas.rotate(this.dwz, (getWidth() / 2), (getHeight() / 2));
        Bitmap bitmap = Bitmap.createBitmap(paramCanvas.getWidth(), paramCanvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        this.anR.setColor(this.backgroundColor);
        this.anR.setXfermode(null);
        canvas.drawArc(new RectF(1.0F, 1.0F, (getWidth() - 1), (getHeight() - 1)), this.dwy, this.dwx, true, this.anR);
        this.anR.setColor(getResources().getColor(R.color.red_text));
        this.anR.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas.drawCircle((getWidth() / 2), (getHeight() / 2), (getWidth() / 2 - Utils.sizeConversion(3.0F, getResources())), this.anR);
        paramCanvas.drawBitmap(bitmap, 0.0F, 0.0F, null);
    }

    private void qI() {
        this.anR = new Paint();
        this.anR.setAntiAlias(true);
        this.anR.setDither(true);
    }

    protected int aqR() { return Color.argb(128, this.backgroundColor >> 16 & 0xFF, this.backgroundColor >> 8 & 0xFF, this.backgroundColor >> 0 & 0xFF); }

    protected void m(AttributeSet paramAttributeSet) {
        int i;
        if (paramAttributeSet != null) {
            i = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", -1);
        } else {
            i = -1;
        }
        if (i != -1) {
            setBackgroundColor(getResources().getColor(i));
            return;
        }
        if (paramAttributeSet != null) {
            i = paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "background", -1);
        } else {
            i = -1;
        }
        if (i != -1) {
            setBackgroundColor(i);
            return;
        }
        setBackgroundColor(Color.parseColor("#1E88E5"));
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        if (!this.dww)
            k(paramCanvas);
        if (this.dwv > 0)
            l(paramCanvas);
        postInvalidate();
    }

    protected void onVisibilityChanged(View paramView, int paramInt) {
        if (paramInt == 8)
            initData();
        super.onVisibilityChanged(paramView, paramInt);
    }

    protected void onWindowVisibilityChanged(int paramInt) {
        if (paramInt == 8)
            initData();
        super.onWindowVisibilityChanged(paramInt);
    }

    public void setBackgroundColor(int paramInt) {
        super.setBackgroundColor(getResources().getColor(R.color.red_text));
        if (isEnabled())
            this.dvQ = this.backgroundColor;
        this.backgroundColor = paramInt;
    }



}
