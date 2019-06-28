package com.laiqian.member;

import com.laiqian.basic.RootApplication;

class as implements Runnable {
  as(MemberListActivity paramMemberListActivity, String paramString) {}
  
  public void run() {
    int i = RootApplication.getLaiqianPreferenceManager().avL();
    if (i != 1 && i != 2)
      MemberListActivity.a(this.bvu).setText(this.bvt); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */