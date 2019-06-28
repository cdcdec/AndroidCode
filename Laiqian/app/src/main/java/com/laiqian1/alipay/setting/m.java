package com.laiqian.alipay.setting;

import android.view.View;
import android.widget.Toast;
import com.laiqian.payment.R;

class m implements View.OnClickListener {
  m(OtherPaySettingActivity paramOtherPaySettingActivity) {}
  
  public void onClick(View paramView) {
    OtherPaySettingActivity.a(this.aCC).save();
    Toast.makeText(this.aCC, this.aCC.getString(R.string.pos_save_success), 1000).show();
    this.aCC.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\alipay\setting\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */