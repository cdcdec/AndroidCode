package com.laiqian.ui.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import com.laiqian.util.n;
import java.util.WeakHashMap;

public class SimultaneousRollingView extends HorizontalScrollView {
  private WeakHashMap<HorizontalScrollView, Integer> dBT = new WeakHashMap();
  
  public SimultaneousRollingView(Context paramContext) { super(paramContext); }
  
  public SimultaneousRollingView(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  public SimultaneousRollingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) { super(paramContext, paramAttributeSet, paramInt); }
  
  public SimultaneousRollingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) { super(paramContext, paramAttributeSet, paramInt1, paramInt2); }
  
  public void a(HorizontalScrollView paramHorizontalScrollView) {
    this.dBT.put(paramHorizontalScrollView, Integer.valueOf(1));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("列头滚动View里面的子集数量：");
    stringBuilder.append(this.dBT.size());
    n.println(stringBuilder.toString());
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    for (HorizontalScrollView horizontalScrollView : this.dBT.keySet()) {
      if (horizontalScrollView != null) {
        horizontalScrollView.smoothScrollTo(paramInt1, paramInt2);
        continue;
      } 
      n.println("想要一起滚动的View，里面的值是null。这里已经不会进来");
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\layout\SimultaneousRollingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */