package com.laiqian.setting;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.d.a;
import com.laiqian.models.m;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.ax;
import com.laiqian.ui.a.r;
import com.laiqian.util.bg;
import com.laiqian.util.by;

public class SettingBillNumber extends ActivityRoot {
  TextView dlE;
  
  EditText dlF;
  
  EditText dlG;
  
  ax dlH;
  
  int dlI;
  
  String dlJ;
  
  int dlK;
  
  private int dlL;
  
  private void save() {
    String str2 = this.dlG.getText().toString().trim();
    String str1 = this.dlF.getText().toString().trim();
    if (TextUtils.isEmpty(str1) || bg.equals("0", str1)) {
      Toast.makeText(this, getResources().getString(2131629590), 0).show();
      return;
    } 
    if (!str2.equals(this.dlJ))
      m.hs(str2); 
    if (!by.isNull(str1)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.dlK);
      stringBuilder.append("");
      if (!str1.equals(stringBuilder.toString()))
        m.ge(by.parseInt(str1)); 
    } 
    int i = ((Number)this.dlE.getTag()).intValue();
    if (i != this.dlI) {
      a a = a.AZ();
      boolean bool = true;
      if (i != 1)
        bool = false; 
      a.bX(bool);
      m.UX();
    } 
    finish();
  }
  
  private boolean xB() {
    if (!this.dlG.getText().toString().trim().equals(this.dlJ))
      return true; 
    String str = this.dlF.getText().toString().trim();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.dlK);
    stringBuilder.append("");
    return !str.equals(stringBuilder.toString()) ? true : ((((Number)this.dlE.getTag()).intValue() != this.dlI));
  }
  
  public boolean beforeCloseActivity() {
    if (xB()) {
      r r = new r(this, true, new be(this));
      r.setTitle(getString(2131627735));
      r.s(getString(2131627733));
      r.t(getString(2131627734));
      r.oZ(getString(2131627732));
      r.show();
      return true;
    } 
    return false;
  }
  
  protected void onCreate(Bundle paramBundle) { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n"); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SettingBillNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */