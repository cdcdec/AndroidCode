package com.laiqian.main;

import android.content.DialogInterface;
import com.laiqian.d.a;
import com.laiqian.entity.j;

class ai implements DialogInterface.OnShowListener {
  ai(PosActivity paramPosActivity, j paramj) {}
  
  public void onShow(DialogInterface paramDialogInterface) {
    if (this.baY.EY().intValue() == 0) {
      a a = a.AZ();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.baY.EZ());
      stringBuilder.append("");
      a.bY(stringBuilder.toString());
      return;
    } 
    if (this.baY.EY().intValue() == 1) {
      a a = a.AZ();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.baY.EZ());
      stringBuilder.append("");
      a.bZ(stringBuilder.toString());
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */