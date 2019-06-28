package com.laiqian.ordertool;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import com.google.a.a.a.a.a.a;

class h implements View.OnClickListener {
  h(ServerTest paramServerTest) {}
  
  public void onClick(View paramView) {
    int i;
    try {
      String str1 = this.cdO.cdB.getText().toString().trim();
      i = 0;
      if (!str1.equals(""))
        i = Integer.parseInt(str1); 
    } catch (Exception paramView) {
      a.e(paramView);
      return;
    } finally {}
    String str = "";
    switch (i) {
      default:
        str = (new ServerGet(this.cdO, this.cdO.aPd, str)).getMessage().toString();
        this.cdO.cdH.setText(str);
        this.cdO.cdH.setMovementMethod(ScrollingMovementMethod.getInstance());
        return;
      case 5:
        str = "{\"phone\":\"20160120824\",\"pwd\":\"SNuOOyIAFT4=\",\"method\":\"2007\",\"device\":\"android\",\"brand\":\"roc\nkchip\",\"imei\":\"00000000-1962-6179-0033-c5870033c587\",\"data\":\"{\\\"sUserPhone\\\":\n\\\"20160120824\\\",\\\"sTableID\\\":\\\"49\\\",\\\"sOrderID\\\":\\\"1456376001262\\\",\\\"sGUIID\\\":\n\\\"1456375840583\\\",\\\"data\\\":[{\\\"_id\\\":\\\"1453269947500\\\",\\\"nBuyNumber\\\":-2,\\\"sProductName\\\":\\\"\n的\\\",\\\"fSalePrice\\\":\\\"1.00\\\",\\\"sTaste\\\":\\\"nbct\\\"}]}\"}";
      case 4:
        str = "{\"phone\":\"20160120824\",\"pwd\":\"SNuOOyIAFT4=\",\"method\":\"2007\",\"device\":\"android\",\"brand\":\"roc\nkchip\",\"imei\":\"00000000-1962-6179-0033-c5870033c587\",\"data\":\"{\\\"sUserPhone\\\":\n\\\"20160120824\\\",\\\"sTableID\\\":\\\"49\\\",\\\"sOrderID\\\":\\\"1456376001262\\\",\\\"sGUIID\\\":\n\\\"1456375840583\\\",\\\"data\\\":[{\\\"_id\\\":\\\"1453269947500\\\",\\\"nBuyNumber\\\":5,\\\"sProductName\\\":\\\"\n的\\\",\\\"fSalePrice\\\":\\\"1.00\\\",\\\"sTaste\\\":\\\"nbct\\\"}]}\"}";
      case 3:
        str = "{\"phone\":\"20160120824\",\"pwd\":\"SNuOOyIAFT4=\",\"method\":\"2007\",\"device\":\"android\",\"brand\":\"roc\nkchip\",\"imei\":\"00000000-1962-6179-0033-c5870033c587\",\"data\":\"{\\\"sUserPhone\\\":\n\\\"20160120824\\\",\\\"sTableID\\\":\\\"49\\\",\\\"sOrderID\\\":\\\"1456376001262\\\",\\\"sGUIID\\\":\n\\\"1456375840583\\\",\\\"data\\\":[{\\\"_id\\\":\\\"1453269947500\\\",\\\"nBuyNumber\\\":0,\\\"sProductName\\\":\\\"\n的\\\",\\\"fSalePrice\\\":\\\"1.00\\\",\\\"sTaste\\\":\\\"nbct\\\"}]}\"}";
      case 2:
        str = "{\"phone\":\"20160120824\",\"pwd\":\"SNuOOyIAFT4=\",\"method\":\"2002\",\"device\":\"android\",\"brand\":\"rockchip\",\"imei\":\"00000000-1962-6179-0033-c5870033c587\",\"data\":\"{\\\"sUserPhone\\\":\\\"20160120824\\\",\\\"sTableID\\\":\\\"50\\\",\\\"sGUIID\\\":\\\"1456375840583\\\",\\\"data\\\":[{\\\"_id\\\":\\\"1453269947500\\\",\\\"nBuyNumber\\\":2,\\\"sProductName\\\":\\\"的\\\",\\\"fSalePrice\\\":\\\"3.00\\\",\\\"sTaste\\\":\\\"jjj\\\"}]}\"}";
      case 1:
        break;
    } 
    str = "{\"phone\":\"20160120824\",\"pwd\":\"SNuOOyIAFT4=\",\"method\":\"2002\",\"device\":\"android\",\"brand\":\"rockchip\",\"imei\":\"00000000-1962-6179-0033-c5870033c587\",\"data\":\"{\\\"sUserPhone\\\":\\\"20160120824\\\",\\\"sTableID\\\":\\\"49\\\",\\\"sGUIID\\\":\\\"1456375840583\\\",\\\"data\\\":[{\\\"_id\\\":\\\"1453269947500\\\",\\\"nBuyNumber\\\":2,\\\"sProductName\\\":\\\"的\\\",\\\"fSalePrice\\\":\\\"3.00\\\",\\\"sTaste\\\":\\\"\\\"}]}\"}";
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */