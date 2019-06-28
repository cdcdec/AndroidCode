package com.laiqian.print.type.net;

import android.text.TextUtils;
import android.view.View;
import com.laiqian.util.bd;

class e implements View.OnClickListener {
  e(ChangeNetPrinterIpActivity paramChangeNetPrinterIpActivity) {}
  
  public void onClick(View paramView) {
    String str = this.cKX.cKR.cLd.getText().toString();
    if (!TextUtils.isEmpty(str) && bd.rQ(str)) {
      this.cKX.cKS.lN(str);
      return;
    } 
    this.cKX.lJ(this.cKX.getString(2131624760));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\net\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */