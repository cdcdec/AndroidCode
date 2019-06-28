package com.laiqian.opentable.tablelist;

import android.view.View;
import android.widget.AdapterView;
import com.laiqian.opentable.common.entity.a;

class j implements AdapterView.OnItemClickListener {
  j(TableList paramTableList) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    a a = (a)paramAdapterView.getItemAtPosition(paramInt);
    int i = 1;
    if (a == null) {
      if (paramInt == TableList.b(this.cdk).YO()) {
        TableList.b(this.cdk, null);
        TableList.a(this.cdk, null);
        paramInt = i;
      } else {
        paramInt = 0;
      } 
    } else {
      TableList tableList = this.cdk;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a.getId());
      stringBuilder.append("");
      TableList.b(tableList, stringBuilder.toString());
      TableList.a(this.cdk, a.XX());
      paramInt = i;
    } 
    if (paramInt != 0)
      this.cdk.YM(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\tablelist\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */