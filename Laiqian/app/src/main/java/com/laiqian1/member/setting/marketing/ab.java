package com.laiqian.member.setting.marketing;

import com.laiqian.member.setting.sms.g;
import java.util.Comparator;

class ab extends Object implements Comparator<g> {
  ab(SMSDetailStaticsActivity.c paramc) {}
  
  public int a(g paramg1, g paramg2) { return (Long.valueOf(paramg1.SO()).longValue() > Long.valueOf(paramg2.SO()).longValue()) ? -1 : ((Long.valueOf(paramg1.SO()).longValue() < Long.valueOf(paramg2.SO()).longValue()) ? 1 : 0); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\marketing\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */