package com.laiqian.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

class al implements View.OnClickListener {
  al(SetMakeOrderNumRuleActivity paramSetMakeOrderNumRuleActivity) {}
  
  public void onClick(View paramView) {
    String str2;
    String str1;
    boolean bool = SetMakeOrderNumRuleActivity.a(this.dlf).isChecked();
    if (bool) {
      str1 = "Y";
    } else {
      str1 = "N";
    } 
    String str4 = SetMakeOrderNumRuleActivity.b(this.dlf).getText().toString().trim();
    String str3 = SetMakeOrderNumRuleActivity.c(this.dlf).getText().toString().trim();
    if (!"".equals(str3.trim()) && str3 != null) {
      str2 = str3;
      if ((new Integer(str3)).intValue() > 10000) {
        Toast.makeText(this.dlf, 2131630077, 3000).show();
        return;
      } 
    } else {
      str2 = "0";
    } 
    int i = (new Integer(SetMakeOrderNumRuleActivity.d(this.dlf).getText().toString().trim())).intValue();
    if (this.dlf.nK(SetMakeOrderNumRuleActivity.e(this.dlf))) {
      SetMakeOrderNumRuleActivity.f(this.dlf).b(str4, (new Integer(str2)).intValue(), i, SetMakeOrderNumRuleActivity.e(this.dlf), str1);
    } else {
      SetMakeOrderNumRuleActivity.f(this.dlf).a(str4, (new Integer(str2)).intValue(), i, SetMakeOrderNumRuleActivity.e(this.dlf), str1);
    } 
    if (bool) {
      Toast.makeText(this.dlf, 2131625997, 2000).show();
      SetMakeOrderNumRuleActivity setMakeOrderNumRuleActivity = this.dlf;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(SetMakeOrderNumRuleActivity.g(this.dlf).getText().toString().trim());
      stringBuilder.append(SetMakeOrderNumRuleActivity.h(this.dlf).getText().toString().trim());
      stringBuilder.append(SetMakeOrderNumRuleActivity.i(this.dlf).getText().toString().trim());
      stringBuilder.append(SetMakeOrderNumRuleActivity.j(this.dlf).getText().toString().trim());
      SetMakeOrderNumRuleActivity.a(setMakeOrderNumRuleActivity, stringBuilder.toString());
    } else {
      Toast.makeText(this.dlf, 2131624836, 2000).show();
    } 
    Intent intent = new Intent();
    intent.setClass(this.dlf, OrderNoInput.class);
    Bundle bundle = new Bundle();
    bundle.putString("sOrderNo", SetMakeOrderNumRuleActivity.k(this.dlf));
    intent.putExtras(bundle);
    this.dlf.setResult(-1, intent);
    this.dlf.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */