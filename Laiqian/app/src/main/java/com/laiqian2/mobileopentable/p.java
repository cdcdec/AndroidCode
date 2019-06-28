package com.laiqian.mobileopentable;

import android.view.View;
import android.widget.AdapterView;
import kotlin.jvm.a.b;

class p implements AdapterView.OnItemClickListener {
  p(o paramo, b paramb1, b paramb2) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    if (paramInt == 0) {
      if (this.bMP != null)
        this.bMP.aw(this.bMR.bMM); 
    } else if (this.bMQ != null) {
      this.bMQ.aw(this.bMR.bMM);
    } 
    this.bMR.bML.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\mobileopentable\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */