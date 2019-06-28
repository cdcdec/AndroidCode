package com.laiqian.print;

import android.view.View;
import android.widget.AdapterView;

class v implements AdapterView.OnItemClickListener {
  v(s params) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    (s.b(this.cCL)).cCT.setItemChecked(paramInt, true);
    s.a(this.cCL).fw(paramInt);
    s.b(this.cCL, s.a(this.cCL).hA(paramInt));
    s.a(this.cCL, paramInt);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */