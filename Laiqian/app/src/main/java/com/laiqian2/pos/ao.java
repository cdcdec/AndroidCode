package com.laiqian.pos;

import android.content.Intent;
import android.view.View;

class ao implements View.OnClickListener {
  ao(PayTypeSettingActivity paramPayTypeSettingActivity) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.cfN, PayTypeSelectSpecific.class);
    intent.putExtra("code", ((Integer)PayTypeSettingActivity.d(this.cfN).getTag()).intValue());
    intent.putExtra("isAlipay", true);
    this.cfN.startActivityForResult(intent, 1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */