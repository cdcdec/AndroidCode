package com.laiqian.version.view;

import com.laiqian.infrastructure.R;

class o implements Runnable {
  o(MyEvaluationActivity paramMyEvaluationActivity) {}
  
  public void run() {
    this.dKi.sq(this.dKi.getString(R.string.pos_upgrade_server_process_fail));
    this.dKi.mHandler.sendEmptyMessage(1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */