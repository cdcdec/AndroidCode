package com.laiqian.pos.settings;

import android.widget.CompoundButton;
import com.laiqian.models.at;
import java.util.HashMap;

class y implements CompoundButton.OnCheckedChangeListener {
  y(KitchenPrintSetting.a parama, int paramInt) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    at at = new at(this.czW.czU);
    if (paramBoolean) {
      if (KitchenPrintSetting.a(this.czW.czU) != null && KitchenPrintSetting.a(this.czW.czU).contains(((HashMap)KitchenPrintSetting.a.a(this.czW).get(this.qI)).get("_id")))
        KitchenPrintSetting.a(this.czW.czU).remove(((HashMap)KitchenPrintSetting.a.a(this.czW).get(this.qI)).get("_id")); 
      KitchenPrintSetting.a.b(this.czW).put(Integer.valueOf(this.qI), Boolean.valueOf(true));
    } else if (!KitchenPrintSetting.a(this.czW.czU).contains(((HashMap)KitchenPrintSetting.a.a(this.czW).get(this.qI)).get("_id"))) {
      KitchenPrintSetting.a(this.czW.czU).add(((HashMap)KitchenPrintSetting.a.a(this.czW).get(this.qI)).get("_id"));
      KitchenPrintSetting.a.b(this.czW).put(Integer.valueOf(this.qI), Boolean.valueOf(false));
    } 
    at.close();
    if (KitchenPrintSetting.b(this.czW.czU) != null)
      KitchenPrintSetting.b(this.czW.czU).a(KitchenPrintSetting.c(this.czW.czU)); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */