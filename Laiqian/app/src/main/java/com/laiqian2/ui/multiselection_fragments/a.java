package com.laiqian.ui.multiselection_fragments;

import android.view.View;
import android.widget.AdapterView;

class a implements AdapterView.OnItemClickListener {
  a(ScrollableTabFragment paramScrollableTabFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    this.dCW.lk(paramInt);
    if (ScrollableTabFragment.a(this.dCW) != null)
      ScrollableTabFragment.a(this.dCW).onItemClick(paramAdapterView, paramView, paramInt, paramLong); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\multiselection_fragments\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */