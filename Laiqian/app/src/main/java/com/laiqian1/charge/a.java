package com.laiqian.charge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

class a implements View.OnClickListener {
  a(ChargeMethodSelector paramChargeMethodSelector) {}
  
  public void onClick(View paramView) {
    String str1;
    SharedPreferences.Editor editor = this.aKy.getSharedPreferences("settings", 0).edit();
    String str2 = "";
    int i = paramView.getId();
    if (i != 2131297799) {
      if (i != 2131297866) {
        str1 = str2;
      } else {
        str1 = this.aKy.getString(2131624810);
      } 
    } else {
      str1 = this.aKy.getString(2131624811);
    } 
    editor.putString("laiqian_charge_method", str1);
    editor.commit();
    Intent intent = new Intent();
    this.aKy.setResult(-1, intent);
    this.aKy.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\charge\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */