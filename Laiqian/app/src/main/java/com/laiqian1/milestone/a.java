package com.laiqian.milestone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

class a implements View.OnClickListener {
  a(BusinessTypeSelector paramBusinessTypeSelector) {}
  
  public void onClick(View paramView) {
    String str1;
    String str2 = "";
    switch (paramView.getId()) {
      default:
        str1 = str2;
        break;
      case 2131296665:
        str1 = this.bJu.getString(2131626098);
        this.bJu.bJs = "100015";
        break;
      case 2131296664:
        str1 = this.bJu.getString(2131626097);
        this.bJu.bJs = "100001";
        break;
    } 
    Intent intent = new Intent();
    Bundle bundle = new Bundle();
    bundle.putString("sProductTransacType", this.bJu.bJs);
    bundle.putString("sProductTransacTypeName", str1);
    intent.putExtras(bundle);
    intent.setClass(this.bJu, orderQuery.class);
    this.bJu.setResult(-1, intent);
    this.bJu.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */