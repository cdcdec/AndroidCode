package com.laiqian.main.module.settlement.pay;

import android.database.Cursor;
import com.laiqian.entity.aq;
import com.laiqian.models.l;
import com.laiqian.pos.av;
import com.laiqian.pos.bl;
import java.util.HashMap;

class i implements av {
  i(PosActivitySettlementDialogPayTypeFragment paramPosActivitySettlementDialogPayTypeFragment) {}
  
  public void OV() {
    aq aq = (aq)this.boK.blQ.bmC.getValue();
    if (aq != null) {
      l l = new l(this.boK.getActivity());
      Cursor cursor = l.bk(aq.aSW);
      if (cursor != null) {
        if (cursor.moveToFirst()) {
          q(bl.a(cursor));
          double d = cursor.getDouble(cursor.getColumnIndex("fAmount"));
          String str = cursor.getString(cursor.getColumnIndex("sNumber"));
          aq.aWo = d;
          aq.aWn = str;
        } else {
          this.boK.blQ.bmC.accept(aq.aWG);
        } 
        cursor.close();
      } 
      l.close();
      this.boK.blQ.bmC.accept(aq);
    } 
  }
  
  public void h(aq paramaq) { this.boK.blQ.bmC.accept(paramaq); }
  
  public void q(HashMap<String, String> paramHashMap) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\pay\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */