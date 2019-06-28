package com.laiqian.report.ui;

import android.view.View;
import android.widget.AdapterView;
import java.util.HashMap;

class bt implements AdapterView.OnItemClickListener {
  bt(ReportRoot paramReportRoot) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) { ReportRoot.a(this.dgN, (String)((HashMap)ReportRoot.e(this.dgN).get(paramInt)).get("address")); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */