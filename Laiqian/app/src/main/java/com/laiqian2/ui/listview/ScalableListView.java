package com.laiqian.ui.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class ScalableListView extends ListView {
  public ScalableListView(Context paramContext) { super(paramContext); }
  
  public ScalableListView(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  public ScalableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) { super(paramContext, paramAttributeSet, paramInt); }
  
  protected void onMeasure(int paramInt1, int paramInt2) { super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\ScalableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */