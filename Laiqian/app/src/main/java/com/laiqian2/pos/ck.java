package com.laiqian.pos;

import android.view.View;
import com.laiqian.util.n;
import java.util.HashMap;

class ck implements View.OnClickListener {
  ck(ProductPictureManagementActivity.b paramb) {}
  
  public void onClick(View paramView) {
    boolean bool = paramView.isActivated();
    HashMap hashMap = (HashMap)paramView.getTag();
    String str = (String)hashMap.get("id");
    if (!str.equals(ProductPictureManagementActivity.h(this.chP.chz))) {
      n.println("编辑的类型，不是选中的类型。理论上这里不会出现");
      int i = this.chP.jy(str);
      int j = this.chP.YO();
      ProductPictureManagementActivity.a(this.chP.chz, i + j + 1);
    } 
    if (!bool)
      return; 
    ProductPictureManagementActivity.a(this.chP.chz, hashMap);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */