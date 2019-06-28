package com.laiqian.print.usage;

import android.content.Context;
import com.laiqian.print.br;
import com.laiqian.print.d;
import com.laiqian.print.usage.delivery.model.DeliveryPrintSettings;
import com.laiqian.print.usage.kitchen.a.c;
import com.laiqian.print.usage.receipt.model.ReceiptPrintSettings;
import com.laiqian.print.usage.tag.a.c;

public class d implements d {
  private d cMl;
  
  public d(d paramd) { this.cMl = paramd; }
  
  public static d bj(Context paramContext) { return new d(new br(paramContext)); }
  
  public boolean a(DeliveryPrintSettings paramDeliveryPrintSettings) { return this.cMl.a(paramDeliveryPrintSettings); }
  
  public boolean a(c paramc) { return this.cMl.a(paramc); }
  
  public boolean a(c paramc) { return this.cMl.a(paramc); }
  
  public c aee() { return this.cMl.aee(); }
  
  public ReceiptPrintSettings aef() { return this.cMl.aef(); }
  
  public c aeg() { return this.cMl.aeg(); }
  
  public DeliveryPrintSettings aeh() { return this.cMl.aeh(); }
  
  public boolean b(ReceiptPrintSettings paramReceiptPrintSettings) { return this.cMl.b(paramReceiptPrintSettings); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */