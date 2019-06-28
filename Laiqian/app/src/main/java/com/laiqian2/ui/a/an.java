package com.laiqian.ui.a;

import android.text.format.Time;
import android.util.Log;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.util.n;
import com.laiqian.util.z;

class an implements a.a {
  an(am paramam) {}
  
  public boolean a(TextView paramTextView, String paramString, long paramLong) {
    Time time = new Time();
    time.set(paramLong);
    paramLong = z.a(time.year, time.month, time.monthDay, 0, 0, 0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    Log.e("start_onBefore", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(aj.b(this.dAt.dAs));
    stringBuilder.append("");
    Log.e("start_onBefore", stringBuilder.toString());
    if (paramLong > aj.b(this.dAt.dAs)) {
      n.eP(R.string.pos_report_todate_check);
      return true;
    } 
    if ((aj.b(this.dAt.dAs) - paramLong) / 1000L > 31536000L) {
      n.eP(R.string.time_span_cannt_be_more_than_one_year);
      return true;
    } 
    return false;
  }
  
  public void b(TextView paramTextView, String paramString, long paramLong) {
    Time time = new Time();
    time.set(paramLong);
    paramLong = z.a(time.year, time.month, time.monthDay, 0, 0, 0);
    aj.a(this.dAt.dAs, paramString, paramLong);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    Log.e("start_onAfter", stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */