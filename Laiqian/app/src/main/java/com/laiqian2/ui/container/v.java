package com.laiqian.ui.container;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class v implements w.a {
  v(LayoutLeftTextRightTextWithDialog paramLayoutLeftTextRightTextWithDialog, String[] paramArrayOfString, LayoutLeftTextRightTextWithDialog.b paramb) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    for (byte b1 = 0; b1 < this.dxC.length; b1++) {
      if (b1 == paramInt) {
        LayoutLeftTextRightTextWithDialog.a(this.dxE).gn(paramInt);
        LayoutLeftTextRightTextWithDialog.b(this.dxE).setText(this.dxC[paramInt]);
      } 
    } 
    if (this.dxD != null)
      this.dxD.h(paramInt, LayoutLeftTextRightTextWithDialog.b(this.dxE).getText().toString()); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */