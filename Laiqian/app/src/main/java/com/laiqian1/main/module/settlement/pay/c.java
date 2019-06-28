package com.laiqian.main.module.settlement.pay;

import android.util.Log;
import android.view.View;
import com.laiqian.entity.v;
import com.laiqian.main.b.c;
import io.reactivex.c.j;
import java.util.Iterator;
import java.util.List;

class c extends Object implements j<List<v>, List<v>, List<c>, Boolean, List<c>> {
  c(PosActivitySettlementDialogPayTypeFragment paramPosActivitySettlementDialogPayTypeFragment) {}
  
  public List<c> a(List<v> paramList1, List<v> paramList2, List<c> paramList3, Boolean paramBoolean) throws Exception {
    int i;
    Log.i("@emery payTypeFragment", "normalPayTypeEntities 初始化 pay");
    int k = paramList1.size();
    if (paramList2.size() > 0) {
      i = 1;
    } else {
      i = 0;
    } 
    int m = i + k;
    if (paramBoolean.booleanValue()) {
      if (m <= 4) {
        for (i = 4; i < paramList3.size(); i++)
          ((c)paramList3.get(i)).view.setVisibility(8); 
      } else if (m <= 8) {
        for (i = k; i < paramList3.size(); i++) {
          byte b;
          View view = ((c)paramList3.get(i)).view;
          if (i > m - 1) {
            b = 4;
          } else {
            b = 0;
          } 
          view.setVisibility(b);
        } 
      } 
    } else {
      for (i = 0; i < paramList3.size(); i++) {
        byte b;
        View view = ((c)paramList3.get(i)).view;
        if (i > k - 1) {
          b = 4;
        } else {
          b = 0;
        } 
        view.setVisibility(b);
      } 
      if (k <= 4)
        for (i = 4; i < paramList3.size(); i++)
          ((c)paramList3.get(i)).view.setVisibility(8);  
    } 
    Iterator iterator = paramList3.iterator();
    while (iterator.hasNext()) {
      i = ((c)iterator.next()).view.getVisibility();
      if (i == 4 || i == 8)
        iterator.remove(); 
    } 
    return paramList3;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\pay\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */