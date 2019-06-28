package com.laiqian.report.models;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.text.format.Time;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.v;
import com.laiqian.infrastructure.R;
import com.laiqian.print.b.c;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.util.e;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;

public class y extends u implements i, j {
  public static final String dcf = RootApplication.zv().getString(R.string.pos_report_shift_user);
  
  public static final String dcg = RootApplication.zv().getString(R.string.pos_report_shift_print_time_begin);
  
  public static final String dci = RootApplication.zv().getString(R.string.pos_report_shift_print_time_end);
  
  public static final String dcj = RootApplication.zv().getString(R.string.pos_report_shift_print_imprest);
  
  public static final String dck = RootApplication.zv().getString(R.string.pos_report_shift_print_amount);
  
  private String aJZ;
  
  public y(Context paramContext) { super(paramContext); }
  
  private String ns(String paramString) { return paramString.startsWith(this.dbz) ? paramString.substring(5) : paramString; }
  
  protected double[] AW() {
    null = new StringBuilder();
    null.append("select count(*),sum(fTotalAmount-fImprest-fBPartnerChargeReceived) from t_shift where ");
    null.append(this.aJZ);
    str = null.toString();
    try {
      Cursor cursor = Vq().rawQuery(str, null);
    } catch (Exception str) {
      a.e(str);
      str = null;
    } 
    str.moveToFirst();
    double d1 = str.getInt(0);
    double d2 = Double.parseDouble(n.a(Double.valueOf(str.getDouble(1)), true, false, RootApplication.aIS));
    str.close();
    return new double[] { d1, d2 };
  }
  
  public String AX() { return this.mContext.getString(R.string.pos_report_export_mail_title_shift); }
  
  public PrintContent.a a(long paramLong1, long paramLong2, ArrayList<HashMap<String, String>> paramArrayList) {
    int k = n.asB();
    String str1 = n.ls(k);
    null = new Time();
    null.set(paramLong1);
    null = null.format(ann());
    null.set(paramLong2);
    String str3 = null.format(ann());
    int[] arrayOfInt1 = new int[2];
    arrayOfInt1[0] = 14;
    arrayOfInt1[1] = k - 14;
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = 17;
    arrayOfInt2[1] = k - 17;
    int[] arrayOfInt3 = new int[2];
    arrayOfInt3[0] = 0;
    arrayOfInt3[1] = 2;
    arrayOfInt3;
    double[] arrayOfDouble = amw();
    PrintContent.a a = new PrintContent.a();
    (new c(a)).lk(this.mContext.getString(R.string.pos_report_shift));
    a.ln(str1);
    null = new StringBuilder();
    null.append(this.mContext.getString(R.string.pos_print_time_begin));
    null.append(null);
    a.ln(null.toString());
    null = new StringBuilder();
    null.append(this.mContext.getString(R.string.pos_print_time_end));
    null.append(str3);
    a.ln(null.toString());
    a.ln(str1);
    String str2 = this.mContext.getString(R.string.pos_report_shift_user);
    str3 = this.mContext.getString(R.string.pos_report_shift_print_time_begin);
    String str4 = this.mContext.getString(R.string.pos_report_shift_print_time_end);
    String str5 = this.mContext.getString(R.string.total_receipts);
    String str6 = this.mContext.getString(R.string.pos_report_shift_print_imprest);
    this.mContext.getString(R.string.pos_report_shift_print_member_amount);
    for (HashMap hashMap : paramArrayList) {
      e.b(a, arrayOfInt1, arrayOfInt3, new String[] { str2, (String)hashMap.get(dcf) }, 0);
      e.b(a, arrayOfInt1, arrayOfInt3, new String[] { str3, (String)hashMap.get(dcg) }, 0);
      e.b(a, arrayOfInt1, arrayOfInt3, new String[] { str4, (String)hashMap.get(dci) }, 0);
      e.b(a, arrayOfInt1, arrayOfInt3, new String[] { str6, (String)hashMap.get(dcj) }, 0);
      e.b(a, arrayOfInt1, arrayOfInt3, new String[] { str5, (String)hashMap.get(dck) }, 0);
      a.ln(str1);
    } 
    e.b(a, arrayOfInt2, arrayOfInt3, new String[] { this.mContext.getString(R.string.pos_report_shift_count), n.b(this.mContext, Double.valueOf(arrayOfDouble[0]), false, false) }3);
    e.b(a, arrayOfInt2, arrayOfInt3, new String[] { this.mContext.getString(R.string.pos_report_shift_cash_sum), n.b(this.mContext, Double.valueOf(arrayOfDouble[1]), true, false) }3);
    return a;
  }
  
  @Nullable
  public String a(ArrayList<HashMap<String, String>> paramArrayList, long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong, v paramv, String paramString1, String paramString2) {
    try {
      b(paramLong1, paramLong2, this.mContext.getString(R.string.pos_report_export_filename_shift));
      a((new t.a(paramLong1, paramLong2)).dh(paramLong3).k(paramArrayOfLong).d(paramv).anl());
      paramArrayList = anr();
      ArrayList arrayList1 = new ArrayList();
      arrayList1.add(new s.a(this.mContext.getString(R.string.pos_report_export_screen_time), y(paramLong1, paramLong2)));
      arrayList1.add(new s.a(this.mContext.getString(R.string.pos_report_export_screen_user), paramString1));
      ArrayList arrayList2 = new ArrayList();
      arrayList2.add(new s.a(this.mContext.getString(R.string.pos_report_shift_count), n.a(this.mContext, Double.valueOf(amw()[0]), true, true)));
      arrayList2.add(new s.a(this.mContext.getString(R.string.pos_report_shift_cash_sum), n.a(this.mContext, Double.valueOf(amw()[1]), true, true)));
      ArrayList arrayList3 = new ArrayList();
      arrayList3.add(dcf);
      arrayList3.add(dcg);
      arrayList3.add(dci);
      arrayList3.add(dck);
      arrayList3.add(dcj);
      String[] arrayOfString = new String[arrayList3.size()];
      arrayList3.toArray(arrayOfString);
      return a(new s(this.mContext.getString(R.string.pos_report_shift), this.mContext.getString(R.string.pos_report_shift), arrayList1, arrayList2, paramArrayList, null, arrayOfString));
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
      return paramArrayList.getMessage();
    } 
  }
  
  public void a(t paramt) {
    this.daq = null;
    this.dby = 0;
    StringBuilder stringBuilder2 = new StringBuilder();
    if (paramt.ang() > 0L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" t_shift.nUserID=");
      stringBuilder.append(paramt.ang());
      stringBuilder.append(" and ");
      stringBuilder2.append(stringBuilder.toString());
    } 
    if (paramt.ane() > 0L || paramt.anf() > 0L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" t_shift.nShiftEndTime >=");
      stringBuilder.append(paramt.ane());
      stringBuilder.append(" and t_shift.nShiftEndTime<=");
      stringBuilder.append(paramt.anf());
      stringBuilder.append(" and ");
      stringBuilder2.append(stringBuilder.toString());
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(" (t_shift.nDeletionFlag is null or t_shift.nDeletionFlag<>1) and t_shift.nShopID=");
    stringBuilder1.append(VC());
    stringBuilder2.append(stringBuilder1.toString());
    this.aJZ = stringBuilder2.toString();
  }
  
  public ArrayList<HashMap<String, String>> zJ() {
    boolean bool2;
    boolean bool1;
    ArrayList arrayList = new ArrayList();
    Cursor cursor = ant();
    if (cursor.length() == 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    null = new StringBuffer("select t_shift._id,nShiftEndTime,sum(fSpareField2+fSpareField1+fSpareField3+fSpareField4+fSaleCashAmount-fSaleReturnCashAmount+fBPartnerChargeReceived)");
    if (bool2)
      null.append(",t_shift.sUserName,t_user.sUserPhone,t_shift.nShiftBeginTime"); 
    null.append(",sum(fImprest) imprest");
    null.append(" from t_shift ");
    if (bool2)
      null.append("left join t_user on t_user._id=t_shift.nUserID"); 
    null = new StringBuilder();
    null.append(" where ");
    null.append(this.aJZ);
    null.append(null.toString());
    null.append(" group by nShiftEndTime ");
    null = new StringBuilder();
    null.append(" order by nShiftEndTime desc ");
    null.append(cursor);
    null.append(null.toString());
    cursor = null;
    try {
      Cursor cursor1 = Vq().rawQuery(null.toString(), null);
      cursor = cursor1;
    } catch (Exception null) {
      a.e(null);
    } 
    int k = cursor.getCount();
    if (!bool2) {
      boolean bool;
      if (k >= getPageSize()) {
        bool = true;
      } else {
        bool = false;
      } 
      gC(bool);
    } 
    if (bool2 || anu()) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    double d = 0.0D;
    Time time = new Time();
    String str = RootApplication.zv().getResources().getString(R.string.pos_pos_SimpleDF);
    while (cursor.moveToNext()) {
      HashMap hashMap = new HashMap();
      hashMap.put("id", cursor.getString(0));
      hashMap.put("shiftEndTime", cursor.getString(1));
      double d2 = cursor.getDouble(2);
      double d1 = d;
      if (bool1)
        d1 = d + d2; 
      time.set(cursor.getLong(1));
      String str1 = time.format(str);
      if (bool2) {
        String str2 = cursor.getString(3);
        if (str2 == null || str2.length() == 0) {
          hashMap.put(dcf, cursor.getString(4));
        } else {
          hashMap.put(dcf, str2);
        } 
        hashMap.put(dci, str1);
        time.set(cursor.getLong(5));
        hashMap.put(dcg, time.format(str));
        hashMap.put(dck, n.b(this.mContext, Double.valueOf(d2), true, false));
        hashMap.put(dcj, n.b(this.mContext, Double.valueOf(cursor.getDouble(6)), true, false));
      } else {
        hashMap.put(dci, ns(str1));
        hashMap.put(dcj, String.format(this.mContext.getString(R.string.pos_shift_report_imprest), new Object[] { this.dbN, n.b(this.mContext, Double.valueOf(cursor.getDouble(cursor.getColumnIndex("imprest"))), true) }));
        str1 = dck;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.dbN);
        stringBuilder.append(n.b(this.mContext, Double.valueOf(d2), true));
        hashMap.put(str1, stringBuilder.toString());
      } 
      arrayList.add(hashMap);
      d = d1;
    } 
    cursor.close();
    if (bool1) {
      this.daq = new double[2];
      this.daq[0] = k;
      this.daq[1] = d;
    } 
    return arrayList;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */