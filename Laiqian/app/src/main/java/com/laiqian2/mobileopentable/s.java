package com.laiqian.mobileopentable;

import android.view.View;
import android.widget.AdapterView;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;

class s implements AdapterView.OnItemLongClickListener {
  s(o paramo) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    TableEntity tableEntity = (TableEntity)o.b(this.bMR).get(paramInt);
    if (tableEntity.Yi() && b.XH()) {
      o.a(this.bMR, tableEntity);
      return true;
    } 
    if (tableEntity.getState() == 0)
      return true; 
    this.bMR.bMM = (TableEntity)o.b(this.bMR).get(paramInt);
    if (this.bMR.bMM.Xy() == 3)
      return true; 
    this.bMR.bML.show();
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\mobileopentable\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */