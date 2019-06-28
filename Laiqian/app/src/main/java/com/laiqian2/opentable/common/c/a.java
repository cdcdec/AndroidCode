package com.laiqian.opentable.common.c;

import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.util.by;
import java.util.List;

public class a {
  private static int a(List<PendingFullOrderDetail.d> paramList1, int paramInt1, List<PendingFullOrderDetail.d> paramList2, int paramInt2) {
    int j;
    if (((PendingFullOrderDetail.d)paramList1.get(paramInt1)).cpx != 2L)
      throw new IllegalStateException("Assert source product is mealset."); 
    int i = paramInt1 + 1;
    byte b2 = 0;
    byte b1 = 0;
    while (true) {
      j = b2;
      if (i < paramList1.size()) {
        j = b2;
        if (((PendingFullOrderDetail.d)paramList1.get(i)).cpx == 3L) {
          b1++;
          i++;
          continue;
        } 
      } 
      break;
    } 
    while (j < b1 + 1) {
      paramList2.add(paramInt2 + j, (PendingFullOrderDetail.d)paramList1.get(paramInt1 + j));
      j++;
    } 
    return b1;
  }
  
  private static int b(List<PendingFullOrderDetail.d> paramList1, int paramInt1, List<PendingFullOrderDetail.d> paramList2, int paramInt2) {
    PendingFullOrderDetail.d d1 = (PendingFullOrderDetail.d)paramList1.get(paramInt1);
    PendingFullOrderDetail.d d2 = (PendingFullOrderDetail.d)paramList2.get(paramInt2);
    if (d1.cpx != 2L)
      throw new IllegalStateException("Assert source product is mealset."); 
    if (d2.cpx != 2L)
      throw new IllegalStateException("Assert target product is mealset."); 
    int i = paramInt1 + 1;
    int k = 0;
    byte b = 0;
    while (i < paramList1.size() && ((PendingFullOrderDetail.d)paramList1.get(i)).cpx == 3L) {
      b++;
      i++;
    } 
    int j = paramInt2 + 1;
    i = 0;
    while (j < paramList2.size() && ((PendingFullOrderDetail.d)paramList2.get(j)).cpx == 3L) {
      i++;
      j++;
    } 
    j = k;
    if (b != i)
      throw new IllegalStateException("Assert source and target has same sub products."); 
    while (j < b + 1) {
      paramList2.add(paramInt2 + i + 1 + j, (PendingFullOrderDetail.d)paramList1.get(paramInt1 + j));
      j++;
    } 
    return b;
  }
  
  public static void b(PendingFullOrderDetail.c paramc, PendingFullOrderDetail paramPendingFullOrderDetail) {
    if (paramPendingFullOrderDetail.coy.isEmpty()) {
      paramPendingFullOrderDetail.coy.addAll(paramc.cpg);
      return;
    } 
    for (int i = 0; i < paramc.cpg.size(); i = j + 1) {
      int j;
      PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)paramc.cpg.get(i);
      if (d.cpo >= 0.0D) {
        j = i;
      } else {
        byte b = 0;
        while (true) {
          j = i;
          if (b < paramPendingFullOrderDetail.coy.size()) {
            PendingFullOrderDetail.d d1 = (PendingFullOrderDetail.d)paramPendingFullOrderDetail.coy.get(b);
            if (d.bbX == d1.bbX) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(d.cpl);
              stringBuilder.append("");
              long l = by.parseLong(stringBuilder.toString());
              stringBuilder = new StringBuilder();
              stringBuilder.append(d1.cpl);
              stringBuilder.append("");
              if (l < by.parseLong(stringBuilder.toString())) {
                if (d.cpx == 2L) {
                  j = i + a(paramc.cpg, i, paramPendingFullOrderDetail.coy, b);
                  break;
                } 
                paramPendingFullOrderDetail.coy.add(b, d);
                j = i;
                break;
              } 
              if (d.cpl == d1.cpl) {
                if (d.cpx == 2L) {
                  j = i + b(paramc.cpg, i, paramPendingFullOrderDetail.coy, b);
                  break;
                } 
                paramPendingFullOrderDetail.coy.add(b + 1, d);
                j = i;
                break;
              } 
            } else {
              if (d.bbX < d1.bbX) {
                if (d.cpx == 2L) {
                  j = i + a(paramc.cpg, i, paramPendingFullOrderDetail.coy, b);
                  break;
                } 
                paramPendingFullOrderDetail.coy.add(b, d);
                j = i;
                break;
              } 
              if (d1.bbX == 0L) {
                if (d.cpx == 2L) {
                  j = i + a(paramc.cpg, i, paramPendingFullOrderDetail.coy, 0);
                  break;
                } 
                paramPendingFullOrderDetail.coy.add(0, d);
                j = i;
                break;
              } 
            } 
            if (b == paramPendingFullOrderDetail.coy.size() - 1) {
              if (d.cpx == 2L) {
                j = i + a(paramc.cpg, i, paramPendingFullOrderDetail.coy, paramPendingFullOrderDetail.coy.size());
                break;
              } 
              paramPendingFullOrderDetail.coy.add(paramPendingFullOrderDetail.coy.size(), d);
              j = i;
              break;
            } 
            b++;
            continue;
          } 
          break;
        } 
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */