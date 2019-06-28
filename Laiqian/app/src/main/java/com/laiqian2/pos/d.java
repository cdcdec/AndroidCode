package com.laiqian.pos;

import android.content.Intent;
import android.view.View;

class d implements View.OnClickListener {
  d(AliPayActivity paramAliPayActivity) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.ceS, PayTypeSelectSpecific.class);
    intent.putExtra("code", ((Integer)AliPayActivity.a(this.ceS).getTag()).intValue());
    intent.putExtra("isAlipay", true);
    this.ceS.startActivityForResult(intent, 1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */