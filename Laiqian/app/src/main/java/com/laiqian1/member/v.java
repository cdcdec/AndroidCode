package com.laiqian.member;

class v implements Runnable {
  v(MemberInfoActivity paramMemberInfoActivity) {}
  
  public void run() {
    Double[] arrayOfDouble = MemberInfoActivity.a(this.buu).PX();
    this.buu.runOnUiThread(new w(this, arrayOfDouble));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */