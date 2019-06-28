package com.laiqian.member.d;

import android.view.View;
import android.widget.AdapterView;
import java.util.HashMap;

class b implements AdapterView.OnItemClickListener {
  b(a parama) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) { a.a(this.bxV, (String)((HashMap)a.a(this.bxV).get(paramInt)).get("address")); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */