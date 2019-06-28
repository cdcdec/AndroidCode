package com.laiqian.pos;

import android.content.Intent;
import android.view.View;

class ap implements View.OnClickListener {
  ap(PayTypeSettingActivity paramPayTypeSettingActivity) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.cfN, PayTypeSelectSpecific.class);
    intent.putExtra("code", ((Integer)PayTypeSettingActivity.e(this.cfN).getTag()).intValue());
    intent.putExtra("isAlipay", false);
    this.cfN.startActivityForResult(intent, 2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */