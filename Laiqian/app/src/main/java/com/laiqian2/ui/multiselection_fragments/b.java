package com.laiqian.ui.multiselection_fragments;

import android.view.View;
import android.view.animation.Animation;
import com.laiqian.ui.listview.i;

class b implements Animation.AnimationListener {
  b(ScrollableTabFragment paramScrollableTabFragment, View paramView, int paramInt1, int paramInt2) {}
  
  public void onAnimationEnd(Animation paramAnimation) {
    ((i)this.dCW.dCT.getAdapter()).li(this.qI);
    this.dCW.dCT.setSelection(this.qI);
    ((i)this.dCW.dCT.getAdapter()).notifyDataSetChanged();
    this.dCW.asc().setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {
    this.dCW.asc().setVisibility(0);
    if (this.dCX == null)
      return; 
    this.dCX.findViewById(this.dCY).setVisibility(4);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\multiselection_fragments\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */