package com.laiqian.auth;

import android.content.Context;
import android.support.annotation.Nullable;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.print.ad;
import com.laiqian.print.b.g;
import com.laiqian.print.h;
import com.laiqian.print.j;
import com.laiqian.print.k;
import com.laiqian.print.p;
import com.laiqian.print.printtype.p;

public class bd implements j.h {
  private Context context;
  
  public bd(Context paramContext) { this.context = paramContext; }
  
  public void a(double[] paramArrayOfDouble, g paramg) {
    if (paramArrayOfDouble != null && paramArrayOfDouble.length == 3) {
      boolean bool3;
      boolean bool2;
      boolean bool1;
      if (paramArrayOfDouble[0] > 0.0D) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (paramArrayOfDouble[1] > 0.0D) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if (paramArrayOfDouble[2] > 0.0D) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      if (bool1 || bool2 || bool3) {
        paramg.l('-');
        paramg.x(new String[] { this.context.getString(2131624851) });
        if (bool1)
          paramg.x(new String[] { null, (new String[2][0] = CrashApplication.zv().getString(2131626217)).valueOf(paramArrayOfDouble[0]) }); 
        if (bool2)
          paramg.x(new String[] { null, (new String[2][0] = CrashApplication.zv().getString(2131629873)).valueOf(paramArrayOfDouble[1]) }); 
        if (bool3)
          paramg.x(new String[] { null, (new String[2][0] = CrashApplication.zv().getString(2131626216)).valueOf(paramArrayOfDouble[2]) }); 
      } 
    } 
  }
  
  public boolean a(Class paramClass, String paramString) { return ("shift".equals(paramString) && paramClass.isAssignableFrom(bc.class)) ? true : (("shift".equals(paramString) && paramClass.isAssignableFrom(bf.class)) ? true : (("shift".equals(paramString) && paramClass.isAssignableFrom(bb.class)))); }
  
  @Nullable
  public j.h.a b(Class paramClass, String paramString) { return p.cJH.contains(paramString) ? k.aer() : null; }
  
  public j.f yA() { return new be(this); }
  
  public j.k yB() { return ad.kU("shift"); }
  
  public j.b yy() { return p.aev(); }
  
  public j.a yz() { return h.aY(this.context); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */