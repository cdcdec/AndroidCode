package com.laiqian.member.g;

import android.content.Context;
import android.text.TextUtils;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.aq;
import com.laiqian.models.bh;
import com.laiqian.models.j;
import com.laiqian.print.b.c;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.receipt.model.ReceiptPrintSettings;
import com.laiqian.print.usage.receipt.model.c;
import com.laiqian.print.util.e;
import com.laiqian.util.n;
import com.laiqian.util.z;
import com.laiqian.vip.R;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class a {
  public Context mContext;
  
  public a(Context paramContext) { this.mContext = paramContext; }
  
  public PrintContent a(aq paramaq, long paramLong1, long paramLong2) throws Exception {
    j j = new j(this.mContext);
    null = j.b(paramaq.aSW, paramLong1, paramLong2);
    double d = j.bh(paramaq.aSW);
    j.close();
    ReceiptPrintSettings receiptPrintSettings = c.bp(this.mContext).aiL();
    if (receiptPrintSettings.getWidth() == 80) {
      b1 = 48;
    } else {
      b1 = 32;
    } 
    PrintContent.a a1 = new PrintContent.a();
    (new c(a1)).lk(this.mContext.getString(R.string.print_member_details));
    null = new StringBuilder();
    byte b2;
    for (b2 = 0; b2 < b1; b2++)
      null.append("-"); 
    String str1 = null.toString();
    a1.ln(str1);
    int[] arrayOfInt1 = new int[2];
    arrayOfInt1[0] = 0;
    arrayOfInt1[1] = 2;
    arrayOfInt1;
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = 12;
    arrayOfInt2[1] = b1 - 12;
    String str2 = this.mContext.getString(R.string.print_start);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong1);
    stringBuilder.append("");
    e.b(a1, arrayOfInt2, arrayOfInt1, new String[] { str2, z.bh(stringBuilder.toString(), this.mContext.getString(R.string.pos_en_SimpleDateFormatDay)) }0);
    str2 = this.mContext.getString(R.string.print_end);
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong2);
    stringBuilder.append("");
    e.b(a1, arrayOfInt2, arrayOfInt1, new String[] { str2, z.bh(stringBuilder.toString(), this.mContext.getString(R.string.pos_en_SimpleDateFormatDay)) }0);
    bh bh = new bh(this.mContext);
    String str3 = bh.iB(RootApplication.getLaiqianPreferenceManager().atm());
    bh.close();
    e.b(a1, arrayOfInt2, arrayOfInt1, new String[] { this.mContext.getString(R.string.print_user), str3 }, 0);
    a1.ln(str1);
    if (!TextUtils.isEmpty(paramaq.name))
      e.b(a1, arrayOfInt2, arrayOfInt1, new String[] { this.mContext.getString(R.string.print_member_name), paramaq.name }, 0); 
    e.b(a1, arrayOfInt2, arrayOfInt1, new String[] { this.mContext.getString(R.string.print_phone), paramaq.aTp }, 0);
    e.b(a1, arrayOfInt2, arrayOfInt1, new String[] { this.mContext.getString(R.string.print_balance), n.b(this.mContext, Double.valueOf(paramaq.aWo), true, false) }3);
    a1.ln(str1);
    if (d != 0.0D) {
      e.b(a1, arrayOfInt2, arrayOfInt1, new String[] { this.mContext.getString(R.string.print_opening), n.b(this.mContext, Double.valueOf(d), true, false) }0);
      a1.ln(str1);
    } 
    e.b(a1, arrayOfInt2, arrayOfInt1, new String[] { this.mContext.getString(R.string.print_date), this.mContext.getString(R.string.print_consume) }, 0);
    a1.ln(str1);
    Iterator iterator = null.entrySet().iterator();
    Double double;
    for (double = Double.valueOf(0.0D); iterator.hasNext(); double = Double.valueOf(double.doubleValue() + ((Double)entry.getValue()).doubleValue())) {
      Map.Entry entry = (Map.Entry)iterator.next();
      e.b(a1, arrayOfInt2, arrayOfInt1, new String[] { (String)entry.getKey(), n.b(this.mContext, entry.getValue(), true, false) }0);
    } 
    a1.ln(str1);
    str1 = this.mContext.getString(R.string.print_total);
    byte b1 = 0;
    e.b(a1, arrayOfInt2, arrayOfInt1, new String[] { str1, n.b(this.mContext, double, true, false) }0);
    while (b1 < receiptPrintSettings.air()) {
      a1.ln("");
      b1++;
    } 
    return a1.afV();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */