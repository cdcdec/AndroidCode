package com.laiqian.product;

import android.view.View;
import com.laiqian.util.n;
import java.util.HashMap;

class dp implements View.OnClickListener {
  dp(ProductList.b paramb) {}
  
  public void onClick(View paramView) {
    boolean bool = paramView.isActivated();
    HashMap hashMap = (HashMap)paramView.getTag();
    String str = (String)hashMap.get("id");
    if (!str.equals(ProductList.r(this.cSb.cRN))) {
      n.println("编辑的类型，不是选中的类型。理论上这里不会出现");
      int i = this.cSb.jy(str);
      ProductList.a(this.cSb.cRN, i);
    } 
    if (!bool)
      return; 
    ProductList.a(this.cSb.cRN, hashMap);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */