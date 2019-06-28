package com.laiqian.pos.hold;

import android.view.View;
import android.widget.AdapterView;

class al implements AdapterView.OnItemClickListener {
  al(ai paramai) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    ai.l(this.cpW).gB(paramInt);
    paramInt = ai.l(this.cpW).aaL();
    ai.a(this.cpW, ai.l(this.cpW).he(paramInt));
    String str = (ai.f(this.cpW)).orderNo;
    ai.a(this.cpW, str);
    ai.a(this.cpW, paramInt);
    ai.c(this.cpW, str);
    ai.v(this.cpW);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */