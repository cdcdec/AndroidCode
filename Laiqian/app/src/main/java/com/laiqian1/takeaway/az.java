package com.laiqian.takeaway;

import android.content.Context;
import android.support.annotation.Nullable;
import com.laiqian.print.h;
import com.laiqian.print.j;
import com.laiqian.print.k;
import com.laiqian.print.p;
import com.laiqian.print.printtype.p;

public class az implements j.h {
  private int cMB = 0;
  
  private final Context context;
  
  public az(Context paramContext) { this.context = paramContext; }
  
  public boolean a(Class paramClass, String paramString) {
    if (paramClass.isAssignableFrom(com.laiqian.entity.TakeOrderEntity.class)) {
      byte b = -1;
      switch (paramString.hashCode()) {
        case 2006648068:
          if (paramString.equals("kitchen_total_reprint"))
            b = 5; 
          break;
        case 1676462825:
          if (paramString.equals("kitchen_total"))
            b = 4; 
          break;
        case 1328327225:
          if (paramString.equals("delivery_not_specified"))
            b = 7; 
          break;
        case 937112962:
          if (paramString.equals("takeout_reprint"))
            b = 1; 
          break;
        case 608149564:
          if (paramString.equals("kitchen_port"))
            b = 2; 
          break;
        case -931604649:
          if (paramString.equals("kitchen_port_reprint"))
            b = 3; 
          break;
        case -1544791705:
          if (paramString.equals("takeout"))
            b = 0; 
          break;
        case -1979255969:
          if (paramString.equals("tag_not_specified"))
            b = 6; 
          break;
      } 
      switch (b) {
        default:
          return false;
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
          break;
      } 
      return true;
    } 
    return false;
  }
  
  @Nullable
  public j.h.a b(Class paramClass, String paramString) { return p.cJH.contains(paramString) ? k.aer() : null; }
  
  public j.f yA() { return new ba(this); }
  
  public j.k yB() { return new bb(this); }
  
  public j.b yy() { return p.aev(); }
  
  public j.a yz() { return h.aY(this.context); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\takeaway\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */