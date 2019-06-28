package com.laiqian.meituan;

import android.view.View;
import android.widget.AdapterView;
import com.laiqian.meituan.c.c;
import java.util.HashMap;

class f implements AdapterView.OnItemClickListener {
  f(MTSettingActivity paramMTSettingActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    boolean bool = Boolean.valueOf(String.valueOf(((HashMap)this.bpJ.bpH.get(paramInt)).get("checked"))).booleanValue();
    this.bpJ.bpI = this.bpJ.bpH;
    ((HashMap)this.bpJ.bpI.get(paramInt)).put("checked", Boolean.valueOf(bool ^ true));
    this.bpJ.bpE.a(c.f(this.bpJ.bpI).split(","), null, false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */