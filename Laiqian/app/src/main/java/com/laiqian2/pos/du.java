package com.laiqian.pos;

import android.content.Intent;
import android.view.View;

class du implements View.OnClickListener {
  du(WeCharPayActivity paramWeCharPayActivity) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.cje, PayTypeSelectSpecific.class);
    intent.putExtra("code", ((Integer)WeCharPayActivity.a(this.cje).getTag()).intValue());
    intent.putExtra("isAlipay", false);
    this.cje.startActivityForResult(intent, 2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */