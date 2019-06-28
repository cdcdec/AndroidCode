package com.laiqian.meituan;

import android.text.format.Time;
import android.widget.TextView;
import com.laiqian.ui.a.a;
import com.laiqian.util.n;

class ag implements a.a {
  ag(MeituanPhoneNumberErrorsDocActivity.a parama) {}
  
  public boolean a(TextView paramTextView, String paramString, long paramLong) {
    long l2;
    long l1;
    if (paramTextView == MeituanPhoneNumberErrorsDocActivity.i(this.bra.bqT)) {
      l1 = ((Long)MeituanPhoneNumberErrorsDocActivity.j(this.bra.bqT).getTag()).longValue();
      l2 = paramLong;
    } else if (paramTextView == MeituanPhoneNumberErrorsDocActivity.j(this.bra.bqT)) {
      l2 = ((Long)MeituanPhoneNumberErrorsDocActivity.i(this.bra.bqT).getTag()).longValue();
      l1 = paramLong;
    } else {
      return false;
    } 
    if (l1 < l2) {
      n.w(this.bra.bqT, R.string.pos_report_time_custom_error);
      return true;
    } 
    return false;
  }
  
  public void b(TextView paramTextView, String paramString, long paramLong) {
    long l;
    String str1;
    String str2 = new Time();
    if (paramTextView == MeituanPhoneNumberErrorsDocActivity.i(this.bra.bqT)) {
      long l1 = ((Long)MeituanPhoneNumberErrorsDocActivity.j(this.bra.bqT).getTag()).longValue();
      str2.set(l1);
      str2 = str2.format(this.bra.bqT.Ze);
      str1 = paramString;
      l = l1;
      paramString = str2;
    } else if (str1 == MeituanPhoneNumberErrorsDocActivity.j(this.bra.bqT)) {
      long l1 = ((Long)MeituanPhoneNumberErrorsDocActivity.i(this.bra.bqT).getTag()).longValue();
      str2.set(l1);
      str1 = str2.format(this.bra.bqT.Ze);
      l = paramLong;
      paramLong = l1;
    } else {
      return;
    } 
    MeituanPhoneNumberErrorsDocActivity.a(this.bra.bqT, 5);
    MeituanPhoneNumberErrorsDocActivity.a(this.bra.bqT, MeituanPhoneNumberErrorsDocActivity.k(this.bra.bqT));
    MeituanPhoneNumberErrorsDocActivity.a(this.bra.bqT, paramLong, l, str1, paramString);
    MeituanPhoneNumberErrorsDocActivity.l(this.bra.bqT);
    MeituanPhoneNumberErrorsDocActivity.a(this.bra.bqT);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */