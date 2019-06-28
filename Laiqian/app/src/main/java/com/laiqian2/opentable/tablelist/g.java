package com.laiqian.opentable.tablelist;

import com.laiqian.opentable.a.b;

class g implements b.a {
  g(TableList paramTableList) {}
  
  public void e(boolean paramBoolean, String paramString1, String paramString2) {
    if (paramBoolean) {
      this.cdk.Nk();
      TableList.a(this.cdk).cancel();
      int i = TableList.b(this.cdk).ju(paramString1);
      TableList.a(this.cdk, i);
    } 
  }
  
  public void f(boolean paramBoolean, String paramString1, String paramString2) {
    if (paramBoolean) {
      this.cdk.Nk();
      TableList.a(this.cdk).cancel();
      TableList.a(this.cdk, paramString2);
      this.cdk.YM();
    } 
  }
  
  public void g(boolean paramBoolean, String paramString1, String paramString2) {
    if (paramBoolean) {
      this.cdk.Nk();
      TableList.a(this.cdk).cancel();
      TableList.a(this.cdk, TableList.b(this.cdk).YO());
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\tablelist\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */