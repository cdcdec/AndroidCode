package com.laiqian.ui.recycleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.laiqian.infrastructure.R;

public class LineGridViewPadding extends GridView {
  private int padding = 20;
  
  public LineGridViewPadding(Context paramContext) { super(paramContext); }
  
  public LineGridViewPadding(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  public LineGridViewPadding(Context paramContext, AttributeSet paramAttributeSet, int paramInt) { super(paramContext, paramAttributeSet, paramInt); }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    super.dispatchDraw(paramCanvas);
    int i = getChildCount();
    Paint paint = new Paint();
    new Paint();
    paint.setStyle(Paint.Style.STROKE);
    paint.setColor(getContext().getResources().getColor(R.color.pos_line_grey));
    for (byte b = 0; b < i; b++) {
      View view = getChildAt(b);
      paramCanvas.drawRect((view.getLeft() + this.padding), view.getTop(), (view.getRight() - this.padding), view.getBottom(), paint);
    } 
  }
  
  public void ll(int paramInt) { this.padding = paramInt; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\recycleview\LineGridViewPadding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */