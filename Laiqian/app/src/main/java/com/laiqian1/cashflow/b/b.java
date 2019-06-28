package com.laiqian.cashflow.b;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.format.Time;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.entity.v;
import com.laiqian.print.b.g;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.usage.receipt.model.ReceiptPrintSettings;
import com.laiqian.print.usage.receipt.model.c;
import com.laiqian.report.models.i;
import com.laiqian.report.models.j;
import com.laiqian.report.models.s;
import com.laiqian.report.models.t;
import com.laiqian.report.models.u;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;

public class b extends u implements i, j {
  private String aJZ;
  
  private long aKa;
  
  private long aKb;
  
  public b(Context paramContext) { super(paramContext); }
  
  protected double[] AW() {
    null = new StringBuilder();
    null.append("select sum(case when nStcokDirection=300002 then fAmount else 0 end) income,sum(case when nStcokDirection=300001 then -fAmount else 0 end) expense from t_productdoc where ");
    null.append(this.aJZ);
    null = null.toString();
    this.daq = new double[3];
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("查询总数量总金额的SQL语句:");
    stringBuilder.append(null);
    n.println(stringBuilder.toString());
    Cursor cursor = Vq().rawQuery(null, null);
    if (cursor != null && cursor.moveToFirst()) {
      this.daq[0] = cursor.getDouble(0);
      this.daq[1] = Double.parseDouble(n.a(Double.valueOf(cursor.getDouble(1)), true, false, RootApplication.aIS));
      this.daq[2] = Double.parseDouble(n.a(Double.valueOf(this.daq[0] + this.daq[1]), true, false, RootApplication.aIS));
    } 
    cursor.close();
    return this.daq;
  }
  
  @NonNull
  public String AX() { return "EVAKO Cashflow Details"; }
  
  public void M(long paramLong) { this.aKa = paramLong; }
  
  public void N(long paramLong) { this.aKb = paramLong; }
  
  public PrintContent.a a(long paramLong1, long paramLong2, ArrayList<HashMap<String, String>> paramArrayList) {
    PrintContent.a a = new PrintContent.a();
    ReceiptPrintSettings receiptPrintSettings = c.bp(this.mContext).aiL();
    g g = new g(a);
    g.setWidth(receiptPrintSettings.getWidth());
    g.n(new int[] { 15, 17 });
    g.n(new int[] { 5, 15, 12 });
    g.o(new int[] { 0, 0, 2 });
    g.lk("Cashflow");
    g.l('-');
    Time time = new Time();
    String str1 = ann();
    time.set(paramLong1);
    String str2 = this.mContext.getString(2131627434);
    byte b2 = 0;
    g.x(new String[] { str2, time.format(str1) });
    time.set(paramLong2);
    g.x(new String[] { this.mContext.getString(2131627435), time.format(str1) });
    g.x(new String[] { this.mContext.getString(2131628737), CrashApplication.getLaiqianPreferenceManager().Ea() });
    g.l('-');
    g.x(new String[] { "No.", "Subtype", "Amount" });
    byte b1 = 0;
    while (b1 < paramArrayList.size()) {
      HashMap hashMap = (HashMap)paramArrayList.get(b1);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(++b1);
      stringBuilder1.append("");
      g.x(new String[] { stringBuilder1.toString(), (String)hashMap.get("name"), (String)hashMap.get("amount") });
    } 
    g.l('-');
    double[] arrayOfDouble = amw();
    g.setSize(3);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(arrayOfDouble[0]);
    stringBuilder.append("");
    g.x(new String[] { "Income", stringBuilder.toString() });
    stringBuilder = new StringBuilder();
    stringBuilder.append(arrayOfDouble[1]);
    stringBuilder.append("");
    g.x(new String[] { "Expense", stringBuilder.toString() });
    stringBuilder = new StringBuilder();
    stringBuilder.append(arrayOfDouble[2]);
    stringBuilder.append("");
    g.x(new String[] { "Balance", stringBuilder.toString() });
    g.setSize(0);
    for (b1 = b2; b1 < 3; b1++)
      a.ln(""); 
    return a;
  }
  
  @Nullable
  public String a(ArrayList<HashMap<String, String>> paramArrayList, long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong, v paramv, String paramString1, String paramString2) {
    try {
      b(paramLong1, paramLong2, "cashflow_report");
      ArrayList arrayList1 = new ArrayList();
      arrayList1.add(new s.a(this.mContext.getString(2131627862), y(paramLong1, paramLong2)));
      ArrayList arrayList2 = new ArrayList();
      double[] arrayOfDouble = amw();
      arrayList2.add(new s.a("Income", n.a(this.mContext, Double.valueOf(arrayOfDouble[0]), true, true)));
      arrayList2.add(new s.a("Expense", n.a(this.mContext, Double.valueOf(arrayOfDouble[1]), true, true)));
      arrayList2.add(new s.a("Balance", n.a(this.mContext, Double.valueOf(arrayOfDouble[2]), true, true)));
      return a(new s("Cashflow Register", "Cashflow Register", arrayList1, arrayList2, paramArrayList, null, new String[] { "DateTime", "Type", "Subtype", "Amount", "Remark" }, new String[] { "Amount" }));
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
      return paramArrayList.getMessage();
    } 
  }
  
  public void a(t paramt) {
    this.daq = null;
    this.dby = 0;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("t_productdoc.nProductTransacType=100067");
    if (this.aKa > 0L) {
      stringBuilder.append(" and t_productdoc.nStcokDirection=");
      stringBuilder.append(this.aKa);
    } 
    if (this.aKb > 0L) {
      stringBuilder.append(" and t_productdoc.nProductID=");
      stringBuilder.append(this.aKb);
    } 
    stringBuilder.append(" and t_productdoc.nDateTime>=");
    stringBuilder.append(paramt.ane());
    stringBuilder.append(" and t_productdoc.nDateTime<=");
    stringBuilder.append(paramt.anf());
    stringBuilder.append(" and (t_productdoc.nDeletionFlag is null or t_productdoc.nDeletionFlag!=1)");
    stringBuilder.append(" and t_productdoc.nShopID=");
    stringBuilder.append(VC());
    this.aJZ = stringBuilder.toString();
  }
  
  public ArrayList<HashMap<String, String>> zJ() {
    boolean bool;
    ArrayList arrayList = new ArrayList();
    Cursor cursor = new StringBuilder();
    cursor.append("select t_productdoc._id,t_productdoc.fAmount,t_productdoc.nDateTime,t_string.sFieldName,t_productdoc.nStcokDirection, t_productdoc.sText from t_productdoc left join t_string on t_string.nFieldType=52 and t_string._id=t_productdoc.nProductID  where ");
    cursor.append(this.aJZ);
    cursor.append(" order by t_productdoc.nDateTime desc ");
    cursor.append(ant());
    String str = cursor.toString();
    cursor = null;
    try {
      Cursor cursor1 = Vq().rawQuery(str, null);
      cursor = cursor1;
    } catch (Exception exception) {
      a.e(exception);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("查询的SQL：");
    stringBuilder.append(str);
    n.println(stringBuilder.toString());
    int k = cursor.getCount();
    if (k >= getPageSize()) {
      bool = true;
    } else {
      bool = false;
    } 
    gC(bool);
    if (k > 0) {
      bool = anu();
      Time time = new Time();
      str = ann();
      double d2 = 0.0D;
      double d1 = 0.0D;
      while (cursor.moveToNext()) {
        double d;
        HashMap hashMap = new HashMap();
        hashMap.put("id", cursor.getString(0));
        if (cursor.getInt(4) == 300001) {
          d = -cursor.getDouble(1);
          double d3 = d1;
          if (bool)
            d3 = d1 + d; 
          hashMap.put("Type", "Expense");
          d1 = d3;
        } else {
          d = cursor.getDouble(1);
          double d3 = d2;
          if (bool)
            d3 = d2 + d; 
          hashMap.put("Type", "Income");
          d2 = d3;
        } 
        hashMap.put("amount", n.a(Double.valueOf(d), true, true));
        hashMap.put("Amount", hashMap.get("amount"));
        hashMap.put("name", cursor.getString(3));
        hashMap.put("Subtype", cursor.getString(3));
        hashMap.put("Remark", cursor.getString(5));
        time.set(cursor.getLong(2));
        String[] arrayOfString = time.format(str).split(" ");
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(nq(arrayOfString[0]));
        stringBuilder1.append(" ");
        stringBuilder1.append(arrayOfString[1]);
        hashMap.put("dateTime", stringBuilder1.toString());
        hashMap.put("Date", arrayOfString[0]);
        hashMap.put("Time", arrayOfString[1]);
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(arrayOfString[0]);
        stringBuilder1.append(" ");
        stringBuilder1.append(arrayOfString[1]);
        hashMap.put("DateTime", stringBuilder1.toString());
        arrayList.add(hashMap);
      } 
      if (bool) {
        this.daq = new double[3];
        this.daq[0] = d2;
        this.daq[1] = d1;
        this.daq[2] = d2 + d1;
      } 
    } 
    cursor.close();
    return arrayList;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */