package com.laiqian.ui.a;

import android.text.format.Time;
import android.util.Log;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.util.n;
import com.laiqian.util.z;

class ap implements a.a {
  ap(ao paramao) {}
  
  public boolean a(TextView paramTextView, String paramString, long paramLong) {
    Time time = new Time();
    time.set(paramLong);
    paramLong = z.a(time.year, time.month, time.monthDay, 23, 59, 59);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    Log.e("end_onBefore", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(aj.a(this.dAu.dAs));
    stringBuilder.append("");
    Log.e("end_onBefore", stringBuilder.toString());
    if (paramLong < aj.a(this.dAu.dAs)) {
      n.eP(R.string.pos_report_todate_check);
      return true;
    } 
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong - aj.a(this.dAu.dAs));
    stringBuilder.append("");
    Log.e("time", stringBuilder.toString());
    Log.e("time", "1471228928");
    if ((paramLong - aj.a(this.dAu.dAs)) / 1000L > 31536000L) {
      n.eP(R.string.time_span_cannt_be_more_than_one_year);
      return true;
    } 
    return false;
  }
  
  public void b(TextView paramTextView, String paramString, long paramLong) {
    Time time = new Time();
    time.set(paramLong);
    paramLong = z.a(time.year, time.month, time.monthDay, 23, 59, 59);
    aj.b(this.dAu.dAs, paramString, paramLong);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    Log.e("end_onAfter", stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */