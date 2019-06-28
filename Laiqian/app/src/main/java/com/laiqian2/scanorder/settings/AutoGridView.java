package com.laiqian.scanorder.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

public class AutoGridView extends GridView {
  public AutoGridView(Context paramContext) { super(paramContext); }
  
  public AutoGridView(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  public AutoGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) { super(paramContext, paramAttributeSet, paramInt); }
  
  protected void onMeasure(int paramInt1, int paramInt2) { super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\AutoGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */