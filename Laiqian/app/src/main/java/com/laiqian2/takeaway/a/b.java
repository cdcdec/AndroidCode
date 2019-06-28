package com.laiqian.takeaway.a;

import android.content.Context;
import android.text.TextUtils;
import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import com.laiqian.models.an;
import com.laiqian.print.b.g;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.model.s;
import com.laiqian.print.usage.c;
import com.laiqian.print.usage.d;
import com.laiqian.print.usage.receipt.model.ReceiptPrintSettings;
import com.laiqian.takeaway.R;
import com.laiqian.util.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;

public class b {
  private static b dvk;
  
  private g cDD;
  
  private c cDE;
  
  private int cMB = 0;
  
  private Context mContext;
  
  private b(Context paramContext) {
    this.mContext = paramContext;
    this.cDD = g.cGS;
    this.cDE = c.bi(this.mContext);
  }
  
  private ArrayList<PrintContent> b(PrintContent paramPrintContent, int paramInt) {
    ArrayList arrayList = new ArrayList();
    for (byte b1 = 0; b1 < paramInt; b1++)
      arrayList.add(paramPrintContent); 
    return arrayList;
  }
  
  public static b bB(Context paramContext) {
    if (dvk == null)
      dvk = new b(paramContext.getApplicationContext()); 
    return dvk;
  }
  
  private g br(int paramInt1, int paramInt2) {
    g g1 = new g();
    g1.setWidth(paramInt1);
    if (paramInt1 == 80) {
      g1.n(new int[] { 7, 2, 3 });
    } else {
      g1.n(new int[] { 2, 1, 1 });
    } 
    g1.ic(paramInt2);
    PrintContent.a a = g1.afT();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("");
    a.aJ("width", stringBuilder.toString());
    g1.n(new int[] { 17, 15 });
    return g1;
  }
  
  private g gu(int paramInt) { return br(paramInt, RootApplication.aIQ); }
  
  public e a(s params, PrintContent paramPrintContent, ReceiptPrintSettings paramReceiptPrintSettings) {
    e e = g.cGS.f(params).a(paramPrintContent);
    e.a(new c(this, e));
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
      an.c c1 = (new an(this.mContext)).Vu();
      if (receiptPrintSettings != null && c1 != null && !TextUtils.isEmpty(c1.aVs))
        receiptPrintSettings.setTitle(c1.aVs); 
    } 
    return receiptPrintSettings;
  }
  
  public ArrayList<e> al(ArrayList<PrintContent> paramArrayList) { return a(paramArrayList, aiL()); }
  
  public ArrayList<PrintContent> ba(String paramString1, String paramString2) {
    g g1 = gu(aiL().getWidth());
    g1.ic(2);
    String str = this.mContext.getString(R.string.print_content__cancel_order_number);
    byte b1 = 0;
    g1.lk(String.format(str, new Object[] { paramString2 }));
    g1.l('-');
    g1.ll(this.mContext.getString(R.string.print_content_cancel_order));
    g1.l('-');
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.mContext.getString(R.string.print_content_order_no_label));
    stringBuilder.append(":");
    stringBuilder.append(paramString1);
    g1.ll(stringBuilder.toString());
    while (b1 < aiL().air()) {
      g1.ll("");
      b1++;
    } 
    return b(g1.afV(), aiL().getCopies());
  }
  
  public ArrayList<e> d(PrintContent paramPrintContent) {
    ArrayList arrayList = new ArrayList();
    null = getPrinters();
    ReceiptPrintSettings receiptPrintSettings = aiL();
    Iterator iterator = null.iterator();
    while (iterator.hasNext())
      arrayList.add(a((s)iterator.next(), paramPrintContent, receiptPrintSettings)); 
    return arrayList;
  }
  
  public List<s> getPrinters() { return this.cDE.ahV(); }
  
  public ArrayList<PrintContent> oV(String paramString) throws JSONException {
    JSONArray jSONArray = new JSONArray(paramString);
    g g1 = gu(aiL().getWidth());
    if (jSONArray != null) {
      byte b2;
      g1.afT().aJ("print_orders", paramString);
      g1.ic(2);
      g1.lk(this.mContext.getString(R.string.meituan_phone_number_title));
      paramString = this.mContext.getString(R.string.meituan_print_phone_number_error_time);
      String str = z.pz(RootApplication.zv().getResources().getString(R.string.pos_pos_SimpleDateFormat));
      boolean bool = false;
      g1.ll(String.format(String.format(paramString, new Object[] { str }), new Object[0]));
      g1.ll("");
      byte b1 = 0;
      while (true) {
        b2 = bool;
        if (b1 < jSONArray.length()) {
          str = String.valueOf(jSONArray.get(b1));
          paramString = str.substring(0, str.indexOf("/"));
          str = str.substring(str.indexOf("/") + 1, str.length());
          String str1;
          g1.ll((str1 = this.mContext.getString(R.string.meituan_phone_number_error_orderid)).format(str1, new Object[] { Integer.valueOf(++b1), paramString }));
          g1.ll(String.format(this.mContext.getString(R.string.meituan_phone_number), new Object[] { str }));
          continue;
        } 
        break;
      } 
      while (b2 < aiL().air()) {
        g1.ll("");
        b2++;
      } 
    } 
    return b(g1.afV(), aiL().getCopies());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */