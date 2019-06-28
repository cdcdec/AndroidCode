package com.laiqian.opentable.pos;

import android.view.View;
import android.widget.AdapterView;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;

class aq implements AdapterView.OnItemClickListener {
  aq(PosActivityTableAdapter paramPosActivityTableAdapter) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    if (PosActivityTableAdapter.a(this.ccg) == null)
      return; 
    TableEntity tableEntity = (TableEntity)paramAdapterView.getItemAtPosition(paramInt);
    if (tableEntity == PosActivityTableAdapter.b(this.ccg) || tableEntity == PosActivityTableAdapter.c(this.ccg)) {
      PosActivityTableAdapter.e(this.ccg).a(PosActivityTableAdapter.a(this.ccg), true, PosActivityTableAdapter.d(this.ccg), false);
    } else if (tableEntity.Yi() && b.XH()) {
      PosActivityTableAdapter.a(this.ccg, tableEntity);
    } else {
      PosActivityTableAdapter.a(this.ccg, paramView, tableEntity);
    } 
    this.ccg.gB(paramInt);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\pos\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */