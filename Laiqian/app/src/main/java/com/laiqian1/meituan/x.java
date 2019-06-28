package com.laiqian.meituan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.Map;

class x implements View.OnClickListener {
  x(w paramw, Map paramMap) {}
  
  public void onClick(View paramView) {
    Bundle bundle = new Bundle();
    bundle.putString("orders", (String)this.bqU.get("sOrderIds"));
    bundle.putString("date", (w.a(this.bqV)).bqW.getText().toString());
    bundle.putString("nQuantity", (String)this.bqU.get("nQuantity"));
    bundle.putString("realPhoneNumbers", (String)this.bqU.get("sRealPhoneNumbers"));
    Intent intent = new Intent(this.bqV.bqT, MeituanPhoneNumberErrorOrdersDetailActivity.class);
    intent.putExtras(bundle);
    this.bqV.bqT.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */