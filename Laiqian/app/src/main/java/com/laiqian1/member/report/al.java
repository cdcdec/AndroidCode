package com.laiqian.member.report;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.v;
import com.laiqian.report.models.i;
import com.laiqian.report.models.s;
import com.laiqian.report.models.t;
import com.laiqian.report.models.u;
import com.laiqian.util.by;
import com.laiqian.util.z;
import com.laiqian.vip.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class al extends u implements i {
  public final String bAa = RootApplication.zv().getString(R.string.pos_report_bal);
  
  public final String bAb = RootApplication.zv().getString(R.string.pos_report_variable_points);
  
  public final String bAc = RootApplication.zv().getString(R.string.pos_report_employee);
  
  public String bAd;
  
  public String bAe;
  
  e bAf;
  
  ak buN;
  
  public final String bzT = RootApplication.zv().getString(R.string.pos_report_date);
  
  public final String bzU = RootApplication.zv().getString(R.string.pos_report_phone_number);
  
  public final String bzV = RootApplication.zv().getString(R.string.pos_report_car_no);
  
  public final String bzW = RootApplication.zv().getString(R.string.pos_report_member_name);
  
  public final String bzX = RootApplication.zv().getString(R.string.pos_report_type);
  
  public final String bzY = RootApplication.zv().getString(R.string.pos_report_amount);
  
  public final String bzZ = RootApplication.zv().getString(R.string.pos_report_o_bal);
  
  Context context;
  
  public al(Context paramContext) throws Exception {
    super(paramContext);
    this.context = paramContext;
    this.buN = ak.aF(paramContext);
    this.bAf = new e(paramContext);
  }
  
  private String fS(String paramString) {
    String str2 = "";
    try {
      SQLiteDatabase sQLiteDatabase = Vq();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(paramString);
      Cursor cursor = sQLiteDatabase.rawQuery("select sUserName from t_user where _id=?", new String[] { stringBuilder.toString() });
    } catch (Exception paramString) {
      a.e(paramString);
      paramString = null;
    } 
    String str1 = str2;
    if (paramString != null) {
      str1 = str2;
      if (paramString.moveToNext()) {
        str1 = paramString.getString(0);
        paramString.close();
      } 
    } 
    return str1;
  }
  
  protected double[] AW() { return new double[0]; }
  
  @NonNull
  public String AX() { return this.mContext.getString(R.string.pos_report_export_title); }
  
  @Nullable
  public String a(ArrayList<HashMap<String, String>> paramArrayList, long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOfLong, v paramv, String paramString1, String paramString2) {
    try {
      b(paramLong1, paramLong2, this.mContext.getString(R.string.pos_report_export_filename_member));
      ArrayList arrayList1 = new ArrayList();
      arrayList1.add(new s.a(this.mContext.getString(R.string.pos_report_export_screen_time), y(paramLong1, paramLong2)));
      arrayList1.add(new s.a(this.mContext.getString(R.string.pos_report_export_screen_type), this.bAe));
      arrayList1.add(new s.a(this.mContext.getString(R.string.pos_report_export_screen_user), this.bAd));
      ArrayList arrayList3 = new ArrayList();
      ArrayList arrayList2 = new ArrayList();
      arrayList3.add(this.bzT);
      arrayList3.add(this.bzU);
      arrayList3.add(this.bzV);
      arrayList3.add(this.bzW);
      arrayList3.add(this.bzX);
      arrayList3.add(this.bzY);
      arrayList3.add(this.bzZ);
      arrayList3.add(this.bAa);
      arrayList3.add(this.bAb);
      arrayList3.add(this.bAc);
      arrayList2.add(this.bzY);
      arrayList2.add(this.bzZ);
      arrayList2.add(this.bAa);
      String[] arrayOfString1 = new String[arrayList3.size()];
      arrayList3.toArray(arrayOfString1);
      String[] arrayOfString2 = new String[arrayList2.size()];
      arrayList2.toArray(arrayOfString2);
      return a(new s(this.mContext.getString(R.string.pos_report_export_title_member), this.mContext.getString(R.string.pos_report_export_title_member), arrayList1, null, paramArrayList, null, arrayOfString1, arrayOfString2));
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
      return paramArrayList.getMessage();
    } 
  }
  
  public void a(t paramt) {}
  
  public void a(List<Map<String, String>> paramList, long paramLong1, long paramLong2) {
    ArrayList arrayList = new ArrayList();
    String str = arrayList;
    if (paramList != null) {
      str = arrayList;
      if (paramList.size() > 0) {
        byte b = 0;
        while (true) {
          str = arrayList;
          if (b < paramList.size()) {
            HashMap hashMap = new HashMap();
            Map map = (Map)paramList.get(b);
            String str8 = (String)map.get("nOperationTime");
            String str4 = (String)map.get("sBPartnerMobile");
            String str5 = (String)map.get("sBPartnerNumber");
            String str6 = (String)map.get("sBPartnerName");
            String str1 = (String)map.get("nChargeType");
            String str7 = (String)map.get("nSpareField2");
            str = (String)map.get("fChargeAmount");
            String str2 = (String)map.get("points");
            String str3 = (String)map.get("nUserID");
            String str9 = (String)map.get("fOldAmount");
            String str10 = (String)map.get("fNewAmount");
            str3 = fS(str3);
            str8 = z.pA(str8);
            double d = by.parseDouble(str);
            if (d > 0.0D) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("+");
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append(d);
              stringBuilder2.append("");
              stringBuilder1.append(by.a(stringBuilder2.toString(), 9999, this.context));
              String str11 = stringBuilder1.toString();
            } else {
              null = new StringBuilder();
              null.append(d);
              null.append("");
              str = by.a(null.toString(), 9999, this.context);
            } 
            str10 = by.a(str10, 9999, this.context);
            str9 = by.a(str9, 9999, this.context);
            if (!by.isNull(str7)) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(this.bAf.fL(str1));
              stringBuilder1.append("-");
              stringBuilder1.append(this.bAf.fK(str7));
              str1 = stringBuilder1.toString();
            } else {
              str1 = this.bAf.fL(str1);
            } 
            hashMap.put(this.bzT, str8);
            hashMap.put(this.bzU, str4);
            hashMap.put(this.bzV, str5);
            hashMap.put(this.bzW, str6);
            hashMap.put(this.bzX, str1);
            str1 = this.bzY;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("");
            hashMap.put(str1, stringBuilder.toString());
            hashMap.put(this.bzZ, str9);
            hashMap.put(this.bAa, str10);
            str1 = this.bzY;
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("");
            hashMap.put(str1, stringBuilder.toString());
            hashMap.put(this.bzZ, str9);
            hashMap.put(this.bAb, str2);
            hashMap.put(this.bAc, str3);
            arrayList.add(hashMap);
            b++;
            continue;
          } 
          break;
        } 
      } 
    } 
    a(str, paramLong1, paramLong2, -1L, null, null, null, null);
  }
  
  public ArrayList<HashMap<String, String>> zJ() { return null; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\report\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */