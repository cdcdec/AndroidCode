package com.laiqian.print.usage.delivery.model;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.models.an;
import com.laiqian.print.model.g;
import com.laiqian.print.model.s;
import com.laiqian.print.usage.b;
import com.laiqian.print.usage.c;
import com.laiqian.print.usage.d;
import java.util.List;

public class b {
  private static b cMK;
  
  private g cDD;
  
  private c cDE;
  
  private Context context;
  
  static  {
  
  }
  
  private b(Context paramContext) {
    this.context = paramContext;
    this.cDD = g.cGS;
    this.cDE = c.bi(paramContext);
  }
  
  public static b bl(Context paramContext) { // Byte code:
    //   0: getstatic com/laiqian/print/usage/delivery/model/b.cMK : Lcom/laiqian/print/usage/delivery/model/b;
    //   3: ifnonnull -> 41
    //   6: ldc com/laiqian/print/usage/delivery/model/b
    //   8: monitorenter
    //   9: getstatic com/laiqian/print/usage/delivery/model/b.cMK : Lcom/laiqian/print/usage/delivery/model/b;
    //   12: ifnonnull -> 29
    //   15: new com/laiqian/print/usage/delivery/model/b
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   23: invokespecial <init> : (Landroid/content/Context;)V
    //   26: putstatic com/laiqian/print/usage/delivery/model/b.cMK : Lcom/laiqian/print/usage/delivery/model/b;
    //   29: ldc com/laiqian/print/usage/delivery/model/b
    //   31: monitorexit
    //   32: goto -> 41
    //   35: astore_0
    //   36: ldc com/laiqian/print/usage/delivery/model/b
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    //   41: getstatic com/laiqian/print/usage/delivery/model/b.cMK : Lcom/laiqian/print/usage/delivery/model/b;
    //   44: areturn
    // Exception table:
    //   from	to	target	type
    //   9	29	35	finally
    //   29	32	35	finally
    //   36	39	35	finally }
  
  public void a(b paramb) {
    if (paramb instanceof DeliveryPrintSettings)
      d.bj(this.context).a((DeliveryPrintSettings)paramb); 
  }
  
  public DeliveryPrintSettings aiz() {
    DeliveryPrintSettings deliveryPrintSettings = d.bj(this.context).aeh();
    if (deliveryPrintSettings.getTitle() == null) {
      an an = null;
      try {
        an an1 = new an(this.context);
        an = an1;
      } catch (Exception exception) {
        a.e(exception);
      } 
      deliveryPrintSettings.setTitle((an.Vu()).aVs);
    } 
    return deliveryPrintSettings;
  }
  
  public List<s> getPrinters() { return this.cDE.ahY(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\delivery\model\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */