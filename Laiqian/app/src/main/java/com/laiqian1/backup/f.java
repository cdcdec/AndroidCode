package com.laiqian.backup;

import com.laiqian.models.bh;
import com.laiqian.util.n;

class f implements Runnable {
  f(c paramc) {}
  
  public void run() {
    new bh(this.aHr.aHq.getActivity());
    String str1 = this.aHr.aHq.getString(2131626483, new Object[] { this.aHr.aHq.getLaiqianPreferenceManager().Ea(), this.aHr.aHq.getLaiqianPreferenceManager().auN(), this.aHr.aHq.getLaiqianPreferenceManager().Tx() });
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.aHr.aHq.aHg);
    stringBuilder.append("/");
    stringBuilder.append(this.aHr.aHq.aHf);
    String str2 = stringBuilder.toString();
    if (n.a(new String[] { "report@androidcloudpos.cn" }, str1, "", new String[] { str2 })) {
      this.aHr.aHq.aHe.obtainMessage(1).sendToTarget();
      return;
    } 
    this.aHr.aHq.aHe.obtainMessage(1, this.aHr.aHq.getString(2131626484)).sendToTarget();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */