package com.laiqian.print.type.net;

import android.text.TextUtils;
import android.view.View;
import com.laiqian.util.bd;

class d implements View.OnClickListener {
  d(ChangeNetPrinterIpActivity paramChangeNetPrinterIpActivity) {}
  
  public void onClick(View paramView) {
    String str1 = this.cKX.cKR.cLd.getText().toString();
    String str2 = this.cKX.cKR.cLg.getText().toString();
    if (TextUtils.isEmpty(str1) || !bd.rQ(str1)) {
      this.cKX.lJ(this.cKX.getString(2131624760));
      return;
    } 
    if (TextUtils.isEmpty(str2) || !bd.rQ(str2)) {
      this.cKX.lJ(this.cKX.getString(2131624760));
      return;
    } 
    if (!bd.bH(this.cKX.getActivity())) {
      this.cKX.ahI();
      return;
    } 
    this.cKX.cKS.aL(str1, str2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\net\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */