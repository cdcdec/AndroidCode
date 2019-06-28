package com.laiqian.report.ui;

import android.text.format.Time;
import android.widget.TextView;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.ui.a.a;
import com.laiqian.util.n;

class bx implements a.a {
  bx(ReportRoot.f paramf) {}
  
  public boolean a(TextView paramTextView, String paramString, long paramLong) {
    long l2;
    long l1;
    if (paramTextView == ReportRoot.m(this.dgV.dgN)) {
      l1 = ((Long)ReportRoot.n(this.dgV.dgN).getTag()).longValue();
      l2 = paramLong;
    } else if (paramTextView == ReportRoot.n(this.dgV.dgN)) {
      l2 = ((Long)ReportRoot.m(this.dgV.dgN).getTag()).longValue();
      l1 = paramLong;
    } else {
      return false;
    } 
    if (l1 < l2) {
      n.w(this.dgV.dgN, 2131627986);
      return true;
    } 
    if (!b.e(b.S(l2), b.U(l2), b.S(l1), b.U(l1), 3)) {
      n.w(this.dgV.dgN, 2131629574);
      return true;
    } 
    return false;
  }
  
  public void b(TextView paramTextView, String paramString, long paramLong) {
    long l;
    String str1;
    String str2 = new Time();
    if (paramTextView == ReportRoot.m(this.dgV.dgN)) {
      long l1 = ((Long)ReportRoot.n(this.dgV.dgN).getTag()).longValue();
      str2.set(l1);
      str1 = str2.format(this.dgV.dgN.Ze);
      l = l1;
      str2 = str1;
    } else if (str1 == ReportRoot.n(this.dgV.dgN)) {
      long l1 = ((Long)ReportRoot.m(this.dgV.dgN).getTag()).longValue();
      str2.set(l1);
      str1 = str2.format(this.dgV.dgN.Ze);
      l = paramLong + 59999L;
      str2 = paramString;
      paramString = str1;
      paramLong = l1;
    } else {
      return;
    } 
    this.dgV.dgN.bqO = 5;
    ReportRoot.a(this.dgV.dgN, ReportRoot.o(this.dgV.dgN));
    (ReportRoot.p(this.dgV.dgN)).dco = l;
    (ReportRoot.p(this.dgV.dgN)).dcn = paramLong;
    (ReportRoot.p(this.dgV.dgN)).dcq = str2;
    (ReportRoot.p(this.dgV.dgN)).dcp = paramString;
    (ReportRoot.p(this.dgV.dgN)).isShow = true;
    ReportRoot.a(this.dgV.dgN, paramLong, l, paramString, str2);
    this.dgV.dgN.AJ();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */