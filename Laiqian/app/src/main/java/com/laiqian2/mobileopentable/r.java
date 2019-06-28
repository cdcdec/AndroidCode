package com.laiqian.mobileopentable;

import android.view.View;
import android.widget.AdapterView;
import com.google.a.a.a.a.a.a;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.m;

class r implements AdapterView.OnItemClickListener {
  r(o paramo) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    if (o.b(this.bMR) != null && o.b(this.bMR).size() > 0)
      try {
        TableEntity tableEntity = (TableEntity)o.b(this.bMR).get(paramInt);
        if (tableEntity.Yi() && b.XH()) {
          o.a(this.bMR, tableEntity);
          return;
        } 
        o.c(this.bMR).g((TableEntity)o.b(this.bMR).get(paramInt));
        return;
      } catch (m paramAdapterView) {
        a.e(paramAdapterView);
      }  
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\mobileopentable\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */