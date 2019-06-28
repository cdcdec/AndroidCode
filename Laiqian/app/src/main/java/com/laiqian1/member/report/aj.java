package com.laiqian.member.report;

import android.text.format.Time;
import android.widget.TextView;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.ui.a.a;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class aj implements a.a {
  aj(VipReportActivity.a parama) {}
  
  public boolean a(TextView paramTextView, String paramString, long paramLong) {
    long l2;
    long l1;
    if (paramTextView == VipReportActivity.w(this.bzL.bzE)) {
      l1 = ((Long)VipReportActivity.x(this.bzL.bzE).getTag()).longValue();
      l2 = paramLong;
    } else if (paramTextView == VipReportActivity.x(this.bzL.bzE)) {
      l2 = ((Long)VipReportActivity.w(this.bzL.bzE).getTag()).longValue();
      l1 = paramLong;
    } else {
      return false;
    } 
    if (l1 < l2) {
      n.w(this.bzL.bzE, R.string.pos_report_time_custom_error);
      return true;
    } 
    if (!b.e(b.S(l2), b.U(l2), b.S(l1), b.U(l1), 3)) {
      n.w(this.bzL.bzE, R.string.select_time_error);
      return true;
    } 
    return false;
  }
  
  public void b(TextView paramTextView, String paramString, long paramLong) {
    long l;
    String str1;
    String str2 = new Time();
    if (paramTextView == VipReportActivity.w(this.bzL.bzE)) {
      long l1 = ((Long)VipReportActivity.x(this.bzL.bzE).getTag()).longValue();
      str2.set(l1);
      str2 = str2.format(this.bzL.bzE.Ze);
      str1 = paramString;
      l = l1;
      paramString = str2;
    } else if (str1 == VipReportActivity.x(this.bzL.bzE)) {
      long l1 = ((Long)VipReportActivity.w(this.bzL.bzE).getTag()).longValue();
      str2.set(l1);
      str1 = str2.format(this.bzL.bzE.Ze);
      l = paramLong;
      paramLong = l1;
    } else {
      return;
    } 
    VipReportActivity.b(this.bzL.bzE, 5);
    VipReportActivity.a(this.bzL.bzE, VipReportActivity.y(this.bzL.bzE));
    VipReportActivity.a(this.bzL.bzE, paramLong, l, str1, paramString);
    VipReportActivity.z(this.bzL.bzE);
    VipReportActivity.e(this.bzL.bzE);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */