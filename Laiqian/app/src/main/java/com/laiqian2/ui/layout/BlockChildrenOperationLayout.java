package com.laiqian.ui.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class BlockChildrenOperationLayout extends LinearLayout {
  public BlockChildrenOperationLayout(Context paramContext) { super(paramContext); }
  
  public BlockChildrenOperationLayout(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  public BlockChildrenOperationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) { super(paramContext, paramAttributeSet, paramInt); }
  
  public BlockChildrenOperationLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) { super(paramContext, paramAttributeSet, paramInt1, paramInt2); }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) { return true; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\layout\BlockChildrenOperationLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */