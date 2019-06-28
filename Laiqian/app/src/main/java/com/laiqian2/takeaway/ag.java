package com.laiqian.takeaway;

import android.view.View;
import android.widget.AdapterView;
import com.laiqian.ui.k;

class ag implements AdapterView.OnItemClickListener {
  ag(af paramaf, k paramk) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    y.c(this.dsh.dsf).b(this.dsh.val$id, this.dsh.drK, "refuse", this.dsh.drM, y.f(this.dsh.dsf)[paramInt]);
    this.dsg.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */