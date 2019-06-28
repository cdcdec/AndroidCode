package com.laiqian.ui.a;

import android.view.View;
import android.widget.AdapterView;

class ar implements AdapterView.OnItemClickListener {
  ar(aq paramaq) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    paramInt -= aq.a(this.dAD).getHeaderViewsCount();
    if (paramInt >= 0 && paramInt < this.dAD.dAv.getCount()) {
      Object object = this.dAD.dAv.getItem(paramInt);
      if (this.dAD.aS(object))
        return; 
      this.dAD.kR(paramInt);
      if (aq.b(this.dAD))
        this.dAD.cancel(); 
      if (aq.c(this.dAD) != null)
        aq.c(this.dAD).a(this.dAD, paramInt, object); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */