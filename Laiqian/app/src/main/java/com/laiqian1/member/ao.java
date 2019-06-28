package com.laiqian.member;

import android.annotation.TargetApi;
import android.widget.TextView;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.ui.a.a;

class ao implements a.a {
  ao(an paraman) {}
  
  public boolean a(TextView paramTextView, String paramString, long paramLong) {
    MemberInfoActivity.g(this.buJ.buu).setTimeInMillis(paramLong);
    return false;
  }
  
  @TargetApi(3)
  public void b(TextView paramTextView, String paramString, long paramLong) {
    MemberInfoActivity.h(this.buJ.buu).setTag(Long.valueOf(paramLong));
    MemberInfoActivity.g(this.buJ.buu).setTimeInMillis(paramLong);
    long[] arrayOfLong = b.aW(MemberInfoActivity.g(this.buJ.buu).get(1), MemberInfoActivity.g(this.buJ.buu).get(2));
    MemberInfoActivity.a(this.buJ.buu).a(MemberInfoActivity.i(this.buJ.buu), MemberInfoActivity.j(this.buJ.buu), arrayOfLong);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */