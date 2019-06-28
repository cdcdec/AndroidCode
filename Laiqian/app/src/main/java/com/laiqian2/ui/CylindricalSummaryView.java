package com.laiqian.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CylindricalSummaryView extends View {
  private double coo;
  
  private int[] dvT;
  
  private double[] dvU;
  
  private int dvV;
  
  public CylindricalSummaryView(Context paramContext) { super(paramContext); }
  
  public CylindricalSummaryView(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  public CylindricalSummaryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) { super(paramContext, paramAttributeSet, paramInt); }
  
  public void a(double[] paramArrayOfDouble, int[] paramArrayOfInt, int paramInt) {
    this.dvU = paramArrayOfDouble;
    this.dvT = paramArrayOfInt;
    this.dvV = paramInt;
    this.coo = 0.0D;
    for (paramInt = 0; paramInt < paramArrayOfDouble.length; paramInt++) {
      if (paramArrayOfDouble[paramInt] < 0.0D)
        paramArrayOfDouble[paramInt] = -paramArrayOfDouble[paramInt]; 
      this.coo += paramArrayOfDouble[paramInt];
    } 
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    if (this.dvT != null) {
      int m = paramCanvas.getWidth();
      int n = paramCanvas.getHeight();
      Path path = new Path();
      int i = n / 2;
      float f1 = i;
      path.addCircle(f1, f1, f1, Path.Direction.CW);
      float f2 = (m - i);
      float f3 = n;
      path.addRect(new RectF(f1, 0.0F, f2, f3), Path.Direction.CW);
      path.addCircle(f2, f1, f1, Path.Direction.CW);
      Paint paint = new Paint();
      RectF rectF = new RectF(0.0F, 0.0F, 0.0F, f3);
      int j = 0;
      int k;
      for (k = 0; j < this.dvU.length; k = i) {
        paint.setColor(this.dvT[j % this.dvT.length]);
        i = (int)(m / this.coo * this.dvU[j]);
        if (j == this.dvU.length - 1) {
          i = m;
        } else {
          i += k;
        } 
        rectF.left = k;
        rectF.right = i;
        paramCanvas.drawRect(rectF, paint);
        j++;
      } 
      Bitmap bitmap = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
      Canvas canvas = new Canvas(bitmap);
      canvas.drawColor(this.dvV);
      paint.setAntiAlias(true);
      paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      canvas.drawPath(path, paint);
      paramCanvas.drawBitmap(bitmap, 0.0F, 0.0F, null);
    } 
    super.onDraw(paramCanvas);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\CylindricalSummaryView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */