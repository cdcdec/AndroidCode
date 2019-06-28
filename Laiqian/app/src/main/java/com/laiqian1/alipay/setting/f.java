package com.laiqian.alipay.setting;

import android.content.Intent;
import android.view.View;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.util.n;

class f implements View.OnClickListener {
  f(OtherPaySettingActivity paramOtherPaySettingActivity) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.aCC, com.laiqian.product.Mall.class);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootUrlParameter.clR);
    stringBuilder.append("&language=");
    stringBuilder.append(n.bM(this.aCC));
    intent.putExtra("url", stringBuilder.toString());
    this.aCC.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\alipay\setting\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */