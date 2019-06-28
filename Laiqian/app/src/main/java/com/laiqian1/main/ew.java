package com.laiqian.main;

import com.laiqian.entity.aa;
import com.laiqian.main.module.productcart.am;
import com.laiqian.util.bg;
import java.util.Comparator;

class ew extends Object implements Comparator<am.a> {
  ew(dl.e parame) {}
  
  public int a(am.a parama1, am.a parama2) {
    if (parama1 instanceof am.a.a) {
      if (!(parama2 instanceof am.a.a))
        return -1; 
      aa aa1 = ((am.a.a)parama1).bjo;
      aa aa2 = ((am.a.a)parama2).bjo;
      return (!aa1.akN() && !aa1.akO() && !aa2.akN() && !aa2.akO() && !aa1.GN() && !aa2.GN() && aa1.cUM.equals(aa2.cUM) && aa1.Gz() == aa2.Gz() && bg.equals(aa1.GP(), aa2.GP()) && bg.equals(aa1.GM().toString(), aa2.GM().toString()) && aa1.Gp() == aa2.Gp()) ? 0 : -1;
    } 
    return -1;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\ew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */