package com.laiqian.opentable.tablelist;

import android.view.View;
import android.widget.AdapterView;
import com.laiqian.opentable.common.entity.TableEntity;

class k implements AdapterView.OnItemClickListener {
  k(TableList paramTableList) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    TableEntity tableEntity = (TableEntity)paramAdapterView.getItemAtPosition(paramInt);
    if (tableEntity != null) {
      if (!TableList.d(this.cdk)) {
        if (!TableList.e(this.cdk))
          return; 
        TableList.a(this.cdk, tableEntity);
        return;
      } 
      if (tableEntity.getState() == 0)
        TableList.f(this.cdk).v(tableEntity); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\tablelist\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */