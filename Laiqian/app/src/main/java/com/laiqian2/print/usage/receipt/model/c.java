package com.laiqian.print.usage.receipt.model;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;
import com.laiqian.models.an;
import com.laiqian.models.bh;
import com.laiqian.print.b.c;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.model.s;
import com.laiqian.print.usage.c;
import com.laiqian.print.usage.d;
import com.laiqian.print.util.e;
import com.laiqian.util.by;
import com.laiqian.util.n;
import hugo.weaving.DebugLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class c {
  private static c cNF;
  
  private g cDD;
  
  private c cDE;
  
  private Context mContext;
  
  private c(Context paramContext) {
    this.mContext = paramContext;
    this.cDD = g.cGS;
    this.cDE = c.bi(this.mContext);
  }
  
  public static c bp(Context paramContext) {
    if (cNF == null)
      cNF = new c(paramContext.getApplicationContext()); 
    return cNF;
  }
  
  @DebugLog
  public PrintContent a(Date paramDate, String paramString1, String paramString2, String paramString3, Double paramDouble1, Double paramDouble2, Double paramDouble3, Bitmap paramBitmap, String paramString4) {
    double d2;
    double d1;
    double d3 = 0.0D;
    if (paramDouble1 == null) {
      d1 = 0.0D;
    } else {
      d1 = paramDouble1.doubleValue();
    } 
    if (paramDouble2 == null) {
      d2 = 0.0D;
    } else {
      d2 = paramDouble2.doubleValue();
    } 
    if (paramDouble3 != null)
      d3 = paramDouble3.doubleValue(); 
    ReceiptPrintSettings receiptPrintSettings = aiL();
    if (receiptPrintSettings.getWidth() == 80) {
      b1 = 48;
    } else {
      b1 = 32;
    } 
    PrintContent.a a = new PrintContent.a();
    bh bh = new c(a);
    null = new StringBuilder();
    byte b2;
    for (b2 = 0; b2 < b1; b2++)
      null.append("-"); 
    str2 = null.toString();
    int[] arrayOfInt1 = new int[2];
    arrayOfInt1[0] = 0;
    arrayOfInt1[1] = 2;
    arrayOfInt1;
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = 18;
    arrayOfInt2[1] = b1 - 18;
    bh.lk(this.mContext.getString(R.string.pos_member_charge_print_title));
    a.ln(str2);
    e.b(a, arrayOfInt2, arrayOfInt1, new String[] { this.mContext.getString(R.string.pos_charge_amount), n.b(this.mContext, Double.valueOf(d2), true, false) }3);
    if (!n.bc(d3))
      e.b(a, arrayOfInt2, arrayOfInt1, new String[] { this.mContext.getString(R.string.pos_member_charge_print_amount_gift), n.b(this.mContext, Double.valueOf(d3), true, false) }3); 
    if (!by.isNull(paramString4)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString4);
      stringBuilder.append("");
      e.b(a, arrayOfInt2, arrayOfInt1, new String[] { stringBuilder.toString(), n.b(this.mContext, Double.valueOf(d2), true, false) }1);
    } 
    a.ln(str2);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.mContext.getString(R.string.pos_pos_SimpleDateFormat));
    bh = null;
    try {
      bh bh1 = new bh(this.mContext);
      bh = bh1;
    } catch (Exception str2) {
      a.e(str2);
    } 
    str2 = bh.WD();
    bh.close();
    String str1 = simpleDateFormat.format(paramDate);
    byte b1 = 0;
    e.b(a, arrayOfInt2, arrayOfInt1, new String[] { str1, str2 }, 0);
    if (paramString1 != null && paramString1.length() > 0)
      e.b(a, arrayOfInt2, arrayOfInt1, new String[] { this.mContext.getString(R.string.pos_add_member_name_title2), paramString1 }, 0); 
    e.b(a, arrayOfInt2, arrayOfInt1, new String[] { this.mContext.getString(R.string.pos_member_charge_print_phone), paramString2 }, 0);
    e.b(a, arrayOfInt2, arrayOfInt1, new String[] { this.mContext.getString(R.string.pos_member_charge_print_card), paramString3 }, 0);
    e.b(a, arrayOfInt2, arrayOfInt1, new String[] { this.mContext.getString(R.string.pos_member_charge_print_amount_before), n.b(this.mContext, Double.valueOf(d1), true, false) }0);
    if (paramBitmap == null) {
      e.b(a, arrayOfInt2, arrayOfInt1, new String[] { this.mContext.getString(R.string.pos_member_charge_print_amount_after), n.b(this.mContext, Double.valueOf(d1 + d2 + d3), true, false) }0);
    } else {
      a.a(paramBitmap, 1);
      a.h(this.mContext.getString(R.string.print_content_alipay_scan_tip), 0, 1);
    } 
    while (b1 < receiptPrintSettings.air()) {
      a.ln("");
      b1++;
    } 
    return a.afV();
  }
  
  public e a(s params, PrintContent paramPrintContent, ReceiptPrintSettings paramReceiptPrintSettings) {
    e e = g.cGS.f(params).a(paramPrintContent);
    e.cx(TimeUnit.SECONDS.toMillis(paramReceiptPrintSettings.aiy()));
    return e;
  }
  
  public ArrayList<e> a(ArrayList<PrintContent> paramArrayList, ReceiptPrintSettings paramReceiptPrintSettings) {
    ArrayList arrayList = new ArrayList();
    if (paramArrayList.size() <= 1) {
      for (s s : getPrinters()) {
        Iterator iterator = paramArrayList.iterator();
        while (iterator.hasNext())
          arrayList.add(a(s, (PrintContent)iterator.next(), paramReceiptPrintSettings)); 
      } 
    } else {
      Iterator iterator = paramArrayList.iterator();
      while (iterator.hasNext())
        arrayList.addAll(d((PrintContent)iterator.next())); 
    } 
    return arrayList;
  }
  
  public ReceiptPrintSettings aiL() {
    ReceiptPrintSettings receiptPrintSettings = d.bj(this.mContext).aef();
    if (receiptPrintSettings.getTitle() == null) {
      an an = null;
      try {
        an an1 = new an(this.mContext);
        an = an1;
      } catch (Exception exception) {
        a.e(exception);
      } 
      receiptPrintSettings.setTitle((an.Vu()).aVs);
    } 
    return receiptPrintSettings;
  }
  
  public ArrayList<e> al(ArrayList<PrintContent> paramArrayList) { return a(paramArrayList, aiL()); }
  
  public ArrayList<e> d(PrintContent paramPrintContent) {
    ArrayList arrayList = new ArrayList();
    null = getPrinters();
    ReceiptPrintSettings receiptPrintSettings = aiL();
    Iterator iterator = null.iterator();
    while (iterator.hasNext())
      arrayList.add(a((s)iterator.next(), paramPrintContent, receiptPrintSettings)); 
    return arrayList;
  }
  
  public void e(PrintContent paramPrintContent) {
    for (s s : this.cDE.ahV()) {
      e e = g.cGS.f(s).a(paramPrintContent);
      this.cDD.print(e);
    } 
  }
  
  public List<s> getPrinters() { return this.cDE.ahV(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\receipt\model\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */