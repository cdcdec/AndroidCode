package com.laiqian.ordertool;

import android.text.method.ScrollingMovementMethod;
import android.view.View;

class i implements View.OnClickListener {
  i(ServerTest paramServerTest) {}
  
  public void onClick(View paramView) {
    boolean bool;
    String str = this.cdO.cdB.getText().toString().trim();
    if (!str.equals("")) {
      bool = Integer.parseInt(str);
    } else {
      bool = false;
    } 
    str = "";
    switch (bool) {
      case true:
        str = "{\"phone\":\"20160120824\",\"pwd\":\"SNuOOyIAFT4=\",\"method\":\"2007\",\"device\":\"android\",\"brand\":\"roc\nkchip\",\"imei\":\"00000000-1962-6179-0033-c5870033c587\",\"data\":\"{\\\"sUserPhone\\\":\n\\\"20160120824\\\",\\\"sTableID\\\":\\\"49\\\",\\\"sOrderID\\\":\\\"1456376001262\\\",\\\"sGUIID\\\":\n\\\"1456375840583\\\",\\\"data\\\":[{\\\"_id\\\":\\\"1453269947500\\\",\\\"nBuyNumber\\\":-2,\\\"sProductName\\\":\\\"\n的\\\",\\\"fSalePrice\\\":\\\"1.00\\\",\\\"sTaste\\\":\\\"nbct\\\"},{\\\"_id\\\":\\\"1453269939827\\\",\\\"nBuyNumber\\\":3,\\\"sProductName\\\":\\\"啊\\\",\\\"fSalePrice\\\":\\\"1.00\\\",\\\"sTaste\\\":\\\"iii\\\"}]}\"}";
        break;
      case true:
        str = "{\"phone\":\"20160120824\",\"pwd\":\"SNuOOyIAFT4=\",\"method\":\"2002\",\"device\":\"android\",\"brand\":\"rockchip\",\"imei\":\"00000000-1962-6179-0033-c5870033c587\",\"data\":\"{\\\"sUserPhone\\\":\\\"20160120824\\\",\\\"sTableID\\\":\\\"49\\\",\\\"sGUIID\\\":\\\"1456375840583\\\",\\\"data\\\":[{\\\"_id\\\":\\\"1453269947500\\\",\\\"nBuyNumber\\\":2,\\\"sProductName\\\":\\\"的\\\",\\\"fSalePrice\\\":\\\"3.00\\\",\\\"sTaste\\\":\\\"jjj\\\"},{\\\"_id\\\":\\\"1453269939827\\\",\\\"nBuyNumber\\\":3,\\\"sProductName\\\":\\\"啊\\\",\\\"fSalePrice\\\":\\\"1.00\\\",\\\"sTaste\\\":\\\"iii\\\"}]}\"}";
        break;
    } 
    str = (new ServerGet(this.cdO, this.cdO.aPd, str)).getMessage().toString();
    this.cdO.cdH.setText(str);
    this.cdO.cdH.setMovementMethod(ScrollingMovementMethod.getInstance());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */