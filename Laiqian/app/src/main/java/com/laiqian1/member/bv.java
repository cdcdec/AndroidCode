package com.laiqian.member;

import android.view.View;
import android.widget.AdapterView;
import java.util.HashMap;

class bv implements AdapterView.OnItemClickListener {
  bv(bs parambs) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) { this.bvW.fx((String)((HashMap)bs.e(this.bvW).get(paramInt)).get("address")); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */