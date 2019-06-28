package com.laiqian.member.transfer;

import com.laiqian.backup.ag;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import java.util.HashMap;

class m implements w.a {
  m(d paramd) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    this.bHx.aGK = (String)this.bHx.aGI.get(paramInt);
    d.a(this.bHx, paramInt);
    this.bHx.bHo = ag.a(this.bHx.aGK, d.aNs, true, true);
    String[] arrayOfString = new String[this.bHx.bHo.size()];
    for (paramInt = 0; paramInt < this.bHx.bHo.size(); paramInt++)
      arrayOfString[paramInt] = String.valueOf(((HashMap)this.bHx.bHo.get(paramInt)).get("path")); 
    if (arrayOfString.length > 0) {
      this.bHx.bHp = new w(d.d(this.bHx), arrayOfString, this.bHx.bHt);
      this.bHx.bHp.setWidth(500);
      this.bHx.bHp.gn(d.e(this.bHx));
      this.bHx.bHp.setOnCancelListener(new n(this));
      this.bHx.bHp.show();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\transfer\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */