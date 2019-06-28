package com.laiqian.report.onlinepay;

import android.text.format.Time;
import android.widget.TextView;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.ui.a.a;
import com.laiqian.util.n;

class q implements a.a {
  q(OnlinePayReportActivity.a parama) {}
  
  public boolean a(TextView paramTextView, String paramString, long paramLong) {
    long l2;
    long l1;
    if (paramTextView == OnlinePayReportActivity.m(this.ddr.ddj)) {
      l1 = ((Long)OnlinePayReportActivity.n(this.ddr.ddj).getTag()).longValue();
      l2 = paramLong;
    } else if (paramTextView == OnlinePayReportActivity.n(this.ddr.ddj)) {
      l2 = ((Long)OnlinePayReportActivity.m(this.ddr.ddj).getTag()).longValue();
      l1 = paramLong;
    } else {
      return false;
    } 
    if (l1 < l2) {
      n.w(this.ddr.ddj, 2131627986);
      return true;
    } 
    if (!b.e(b.S(l2), b.U(l2), b.S(l1), b.U(l1), 3)) {
      n.w(this.ddr.ddj, 2131629574);
      return true;
    } 
    return false;
  }
  
  public void b(TextView paramTextView, String paramString, long paramLong) {
    long l;
    String str1;
    String str2 = new Time();
    if (paramTextView == OnlinePayReportActivity.m(this.ddr.ddj)) {
      long l1 = ((Long)OnlinePayReportActivity.n(this.ddr.ddj).getTag()).longValue();
      str2.set(l1);
      str2 = str2.format(this.ddr.ddj.Ze);
      str1 = paramString;
      l = l1;
      paramString = str2;
    } else if (str1 == OnlinePayReportActivity.n(this.ddr.ddj)) {
      long l1 = ((Long)OnlinePayReportActivity.m(this.ddr.ddj).getTag()).longValue();
      str2.set(l1);
      str1 = str2.format(this.ddr.ddj.Ze);
      l = paramLong;
      paramLong = l1;
    } else {
      return;
    } 
    OnlinePayReportActivity.d(this.ddr.ddj, 5);
    OnlinePayReportActivity.a(this.ddr.ddj, OnlinePayReportActivity.o(this.ddr.ddj));
    OnlinePayReportActivity.a(this.ddr.ddj, paramLong, l, str1, paramString);
    OnlinePayReportActivity.p(this.ddr.ddj);
    this.ddr.ddj.Py();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\onlinepay\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */