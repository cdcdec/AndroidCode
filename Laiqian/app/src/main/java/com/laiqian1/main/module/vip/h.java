package com.laiqian.main.module.vip;

import android.database.Cursor;
import com.laiqian.entity.aq;
import com.laiqian.models.l;
import com.laiqian.pos.av;
import com.laiqian.pos.bl;
import java.util.HashMap;

class h implements av {
  h(PosActivityVipFragment paramPosActivityVipFragment) {}
  
  public void OV() {
    aq aq = (aq)(PosActivityVipFragment.c(this.bpm)).bdM.getValue();
    if (aq != null) {
      l l = new l(this.bpm.getActivity());
      Cursor cursor = l.bk(aq.aSW);
      if (cursor != null) {
        if (cursor.moveToFirst()) {
          q(bl.a(cursor));
          double d = cursor.getDouble(cursor.getColumnIndex("fAmount"));
          String str = cursor.getString(cursor.getColumnIndex("sNumber"));
          aq.aWo = d;
          aq.aWn = str;
        } 
        PosActivityVipFragment.f(this.bpm);
        cursor.close();
      } 
      l.close();
    } 
  }
  
  public void h(aq paramaq) { (PosActivityVipFragment.c(this.bpm)).bdM.accept(paramaq); }
  
  public void q(HashMap<String, String> paramHashMap) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\vip\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */