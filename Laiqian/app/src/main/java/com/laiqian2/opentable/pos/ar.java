package com.laiqian.opentable.pos;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;

class ar implements AdapterView.OnItemLongClickListener {
  ar(PosActivityTableAdapter paramPosActivityTableAdapter) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    if (PosActivityTableAdapter.a(this.ccg) == null)
      return false; 
    TableEntity tableEntity = (TableEntity)paramAdapterView.getItemAtPosition(paramInt);
    if (tableEntity.Yi() && b.XH()) {
      PosActivityTableAdapter.a(this.ccg, tableEntity);
      return false;
    } 
    if (tableEntity != PosActivityTableAdapter.b(this.ccg)) {
      CharSequence[] arrayOfCharSequence2;
      if (tableEntity == PosActivityTableAdapter.c(this.ccg))
        return false; 
      if (tableEntity.getState() == 0)
        return true; 
      PosActivityTableAdapter.f(this.ccg).kS(1);
      Log.e("PosActivityTableAdaptergetOrderType", String.valueOf(tableEntity.Xy()));
      if (tableEntity.Xy() == 3) {
        if (!b.XD()) {
          arrayOfCharSequence2 = this.ccg.ccc;
          PosActivityTableAdapter.a(this.ccg, this.ccg.a(new CharSequence[][] { { arrayOfCharSequence2 } }));
        } else {
          arrayOfCharSequence2 = this.ccg.ccc;
          CharSequence charSequence = this.ccg.ccd;
          PosActivityTableAdapter.a(this.ccg, this.ccg.a(new CharSequence[][] { { arrayOfCharSequence2, charSequence } }));
        } 
        PosActivityTableAdapter.f(this.ccg).aT(tableEntity);
        return true;
      } 
      PosActivityTableAdapter posActivityTableAdapter = this.ccg;
      if (this.ccg.bBoss && b.XD()) {
        arrayOfCharSequence2 = new CharSequence[4];
        arrayOfCharSequence2[0] = this.ccg.ccf;
        arrayOfCharSequence2[1] = this.ccg.cce;
        arrayOfCharSequence2[2] = this.ccg.ccc;
        arrayOfCharSequence2[3] = this.ccg.ccd;
      } else {
        arrayOfCharSequence2 = new CharSequence[3];
        arrayOfCharSequence2[0] = this.ccg.ccf;
        arrayOfCharSequence2[1] = this.ccg.cce;
        arrayOfCharSequence2[2] = this.ccg.ccc;
      } 
      posActivityTableAdapter.ccb = arrayOfCharSequence2;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.ccg.ccb.length);
      stringBuilder.append("");
      Log.e("PosActivityTableAdapterselectionGroup2", stringBuilder.toString());
      CharSequence[] arrayOfCharSequence1 = this.ccg.ccb;
      PosActivityTableAdapter.a(this.ccg, this.ccg.a(new CharSequence[][] { arrayOfCharSequence1 }));
      PosActivityTableAdapter.f(this.ccg).aT(tableEntity);
      return true;
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\pos\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */