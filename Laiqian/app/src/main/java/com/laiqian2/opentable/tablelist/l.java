package com.laiqian.opentable.tablelist;

import android.view.View;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.util.n;

class l implements View.OnClickListener {
  l(TableList.a parama) {}
  
  public void onClick(View paramView) {
    boolean bool = paramView.isActivated();
    a a1 = (a)paramView.getTag();
    null = new StringBuilder();
    null.append(a1.getId());
    null.append("");
    String str = null.toString();
    if (!str.equals(TableList.g(this.cdn.cdk))) {
      n.println("编辑的区域，不是选中的区域。理论上这里不会出现");
      int i = this.cdn.ju(str);
      TableList.a(this.cdn.cdk, i);
    } 
    if (!bool)
      return; 
    TableList.a(this.cdn.cdk, a1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\tablelist\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */