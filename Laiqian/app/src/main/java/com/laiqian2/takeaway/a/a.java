package com.laiqian.takeaway.a;

import android.content.Context;
import com.laiqian.basic.RootApplication;
import com.laiqian.print.b.g;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.g;
import com.laiqian.print.model.s;
import com.laiqian.print.usage.c;
import com.laiqian.print.usage.d;
import com.laiqian.print.usage.kitchen.a.c;
import com.laiqian.takeaway.R;
import java.util.ArrayList;
import java.util.List;

public class a {
  private static a dvj;
  
  private g cDD;
  
  private c cDE;
  
  private Context mContext;
  
  static  {
  
  }
  
  private a(Context paramContext) {
    this.mContext = paramContext;
    this.cDD = g.cGS;
    this.cDE = c.bi(this.mContext);
  }
  
  public static a bA(Context paramContext) { // Byte code:
    //   0: getstatic com/laiqian/takeaway/a/a.dvj : Lcom/laiqian/takeaway/a/a;
    //   3: ifnonnull -> 41
    //   6: ldc com/laiqian/takeaway/a/a
    //   8: monitorenter
    //   9: getstatic com/laiqian/takeaway/a/a.dvj : Lcom/laiqian/takeaway/a/a;
    //   12: ifnonnull -> 29
    //   15: new com/laiqian/takeaway/a/a
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   23: invokespecial <init> : (Landroid/content/Context;)V
    //   26: putstatic com/laiqian/takeaway/a/a.dvj : Lcom/laiqian/takeaway/a/a;
    //   29: ldc com/laiqian/takeaway/a/a
    //   31: monitorexit
    //   32: goto -> 41
    //   35: astore_0
    //   36: ldc com/laiqian/takeaway/a/a
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    //   41: getstatic com/laiqian/takeaway/a/a.dvj : Lcom/laiqian/takeaway/a/a;
    //   44: areturn
    // Exception table:
    //   from	to	target	type
    //   9	29	35	finally
    //   29	32	35	finally
    //   36	39	35	finally }
  
  private g gu(int paramInt) {
    g g1 = new g();
    g1.setWidth(paramInt);
    g1.ic(RootApplication.aIQ);
    g1.n(new int[] { 17, 15 });
    return g1;
  }
  
  public c aiC() { return d.bj(this.mContext).aeg(); }
  
  public ArrayList<PrintContent> ba(String paramString1, String paramString2) {
    ArrayList arrayList = new ArrayList();
    g g1 = gu(aiC().getWidth());
    g1.ic(2);
    String str = this.mContext.getString(R.string.print_content__cancel_order_number);
    byte b = 0;
    g1.lk(String.format(str, new Object[] { paramString2 }));
    g1.l('-');
    g1.ll(this.mContext.getString(R.string.print_content_cancel_order));
    g1.l('-');
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.mContext.getString(R.string.print_content_order_no_label));
    stringBuilder.append(":");
    stringBuilder.append(paramString1);
    g1.ll(stringBuilder.toString());
    while (b < aiC().air()) {
      g1.ll("");
      b++;
    } 
    arrayList.add(g1.afV());
    return arrayList;
  }
  
  public List<s> getPrinters() { return this.cDE.ahX(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */