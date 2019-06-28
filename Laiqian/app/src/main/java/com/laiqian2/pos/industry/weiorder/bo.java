package com.laiqian.pos.industry.weiorder;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import com.laiqian.pos.dn;
import com.laiqian.takeaway.aq;
import com.laiqian.ui.listview.l;
import java.util.ArrayList;
import java.util.HashMap;

class bo implements AdapterView.OnItemClickListener {
  bo(TddSetting paramTddSetting, ArrayList paramArrayList, l paraml) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    String str = ((HashMap)this.ctV.get(paramInt)).get("shopid").toString();
    boolean bool = this.ctU.getLaiqianPreferenceManager().qN(str);
    ((HashMap)this.ctV.get(paramInt)).put("bChecked", Boolean.valueOf(bool ^ true));
    this.ctU.getLaiqianPreferenceManager().C(str, bool ^ true);
    TddSetting.c(this.ctU).put("sLqkUserTddShops", this.ctV.toString());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("arrTDDInfo:");
    stringBuilder.append(this.ctV.toString());
    Log.e("arrTDDInfo", stringBuilder.toString());
    aq.b(this.ctU, TddSetting.c(this.ctU));
    this.ctW.notifyDataSetChanged();
    (new dn(this.ctU)).start();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */