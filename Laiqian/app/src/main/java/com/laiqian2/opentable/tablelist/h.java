package com.laiqian.opentable.tablelist;

import com.laiqian.opentable.b.r;
import com.laiqian.opentable.common.entity.TableEntity;

class h implements r.a {
  h(TableList paramTableList) {}
  
  public void a(boolean paramBoolean, TableEntity paramTableEntity) {
    if (paramBoolean) {
      TableList.a a1 = TableList.b(this.cdk);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramTableEntity.XY());
      stringBuilder.append("");
      int i = a1.ju(stringBuilder.toString());
      TableList.a(this.cdk, i);
    } 
  }
  
  public void b(boolean paramBoolean, TableEntity paramTableEntity) {
    if (paramBoolean) {
      TableList.a a1 = TableList.b(this.cdk);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramTableEntity.XY());
      stringBuilder.append("");
      int i = a1.ju(stringBuilder.toString());
      TableList.a(this.cdk, i);
    } 
  }
  
  public void c(boolean paramBoolean, TableEntity paramTableEntity) {
    if (paramBoolean)
      this.cdk.YM(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\tablelist\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */