package com.laiqian.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

class ac implements View.OnClickListener {
  ac(OrderNumberLauncherActivity paramOrderNumberLauncherActivity) {}
  
  public void onClick(View paramView) {
    String str = OrderNumberLauncherActivity.a(this.dkL).getText().toString();
    if (str == null || "".equals(str)) {
      Toast.makeText(this.dkL, 2131630075, 2000).show();
      return;
    } 
    Intent intent = new Intent(this.dkL, SetMakeOrderNumRuleActivity.class);
    Bundle bundle = new Bundle();
    bundle.putString("BusinessType", str);
    intent.putExtras(bundle);
    intent.setType("button");
    this.dkL.startActivity(intent);
    OrderNumberLauncherActivity.a(this.dkL).setText("");
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */