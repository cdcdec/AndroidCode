package com.laiqian.takeaway.phone.setting;

import android.content.Intent;
import android.os.Bundle;
import com.laiqian.entity.y;
import com.laiqian.takeaway.phone.a;

class h implements a.b {
  h(PhoneChangeActivity paramPhoneChangeActivity) {}
  
  public void aqH() {
    if ("PosSelectTelephone".equals(this.duO.getIntent().getStringExtra("PosSelectTelephone"))) {
      y y = PhoneChangeActivity.g(this.duO);
      Intent intent = new Intent();
      Bundle bundle = new Bundle();
      bundle.putSerializable("TELEPHONE_ENTITY", y);
      intent.putExtras(bundle);
      this.duO.setResult(-1, intent);
    } 
    this.duO.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\phone\setting\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */