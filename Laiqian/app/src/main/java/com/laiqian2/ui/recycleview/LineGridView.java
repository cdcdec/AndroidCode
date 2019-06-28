package com.laiqian.ui.recycleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.laiqian.infrastructure.R;
import java.io.PrintStream;

public class LineGridView extends GridView {
  public LineGridView(Context paramContext) { super(paramContext); }
  
  public LineGridView(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  public LineGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) { super(paramContext, paramAttributeSet, paramInt); }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    super.dispatchDraw(paramCanvas);
    int i = 0;
    null = getChildAt(0);
    int j = getWidth() / null.getWidth();
    int k = getChildCount();
    null = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("子view的总数childCount==");
    stringBuilder.append(k);
    null.println(stringBuilder.toString());
    Paint paint = new Paint();
    paint.setStyle(Paint.Style.STROKE);
    paint.setColor(getContext().getResources().getColor(R.color.pos_line_grey));
    while (i < k) {
      View view = getChildAt(i);
      if (i < 3)
        paramCanvas.drawLine(view.getLeft(), view.getTop(), view.getRight(), view.getTop(), paint); 
      if (i % j == 0)
        paramCanvas.drawLine(view.getLeft(), view.getTop(), view.getLeft(), view.getBottom(), paint); 
      if (++i % j == 0) {
        paramCanvas.drawLine(view.getLeft(), view.getBottom(), view.getRight(), view.getBottom(), paint);
        paramCanvas.drawLine(view.getRight(), view.getTop(), view.getRight(), view.getBottom(), paint);
        continue;
      } 
      if (i > k - k % j) {
        paramCanvas.drawLine(view.getRight(), view.getTop(), view.getRight(), view.getBottom(), paint);
        paramCanvas.drawLine(view.getLeft(), view.getBottom(), view.getRight(), view.getBottom(), paint);
        continue;
      } 
      paramCanvas.drawLine(view.getRight(), view.getTop(), view.getRight(), view.getBottom(), paint);
      paramCanvas.drawLine(view.getLeft(), view.getBottom(), view.getRight(), view.getBottom(), paint);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\recycleview\LineGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */