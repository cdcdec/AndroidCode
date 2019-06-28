package com.laiqian.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

class x implements View.OnClickListener {
  x(OrderNoInput paramOrderNoInput) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent();
    intent.setClass(this.dkD, SetMakeOrderNumRuleActivity.class);
    Bundle bundle = new Bundle();
    bundle.putString("sBusinessType", OrderNoInput.a(this.dkD));
    intent.putExtras(bundle);
    this.dkD.startActivityForResult(intent, 0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */