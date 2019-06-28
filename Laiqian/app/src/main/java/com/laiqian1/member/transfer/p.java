package com.laiqian.member.transfer;

import a.c.a;
import a.c.b;
import a.c.c;
import a.c.p;
import a.e.d;
import a.e.e;
import a.e.i;
import a.e.j;
import a.e.l;
import a.e.m;
import a.u;
import android.content.Context;
import android.os.Environment;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.models.l;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class p {
  private String bHB;
  
  private Context mContext;
  
  public p(Context paramContext) { this.mContext = paramContext; }
  
  private l a(m paramm, String paramString) throws Exception { return paramm.P(paramString, 0); }
  
  private void a(m paramm) throws Exception {
    paramm.aPy();
    paramm.close();
  }
  
  private i[] a(c paramc) throws Exception {
    i i1 = new i();
    i1.b(a.ePa);
    i1.b(p.eTn);
    i1.a(b.ePg, paramc);
    i i2 = new i();
    i2.b(a.ePc);
    i2.b(p.eTn);
    i2.a(b.ePg, paramc);
    i i3 = new i();
    i3.b(a.ePb);
    i3.b(p.eTn);
    i3.a(b.ePg, paramc);
    j j = new j(j.eXc, 20, j.eXh);
    i i4 = new i(j);
    i4.b(a.ePa);
    i4.b(p.eTn);
    i4.a(b.ePg, paramc);
    i i5 = new i(j);
    i5.b(a.ePc);
    i5.b(p.eTn);
    i5.a(b.ePg, paramc);
    return new i[] { i1, i2, i3, i4, i5 };
  }
  
  private m r(File paramFile) throws Exception { return u.r(paramFile); }
  
  public static boolean x(HashMap<String, String> paramHashMap) { return "true".equals(paramHashMap.get("isGroup")); }
  
  public String I(ArrayList<HashMap<String, String>> paramArrayList) {
    try {
      ArrayList arrayList = new ArrayList();
      Tg();
      String str1 = this.mContext.getString(R.string.export_vip_name);
      String str2 = this.mContext.getString(R.string.export_vip_number);
      String str3 = this.mContext.getString(R.string.export_vip_mobile);
      String str4 = this.mContext.getString(R.string.export_vip_birthday);
      String str5 = this.mContext.getString(R.string.export_vip_amount);
      String str6 = this.mContext.getString(R.string.export_vip_point);
      return a(new q(this.mContext.getString(R.string.pos_member_list), this.mContext.getString(R.string.pos_member_list), arrayList, null, paramArrayList, null, new String[] { str1, str2, str3, str4, str5, str6 }, null));
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
      return paramArrayList.getMessage();
    } 
  }
  
  public String Td() { return I(Te()); }
  
  protected ArrayList<HashMap<String, String>> Te() {
    try {
      exception = new l(RootApplication.zv());
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    ArrayList arrayList = exception.UR();
    exception.close();
    return arrayList;
  }
  
  public String Tf() { return this.bHB; }
  
  public void Tg() {
    File file1;
    File file2 = RootApplication.zv().getExternalCacheDir();
    if (file2 == null) {
      file1 = Environment.getExternalStorageDirectory();
    } else {
      file1 = file2;
      if (!file2.exists()) {
        file1 = file2;
        if (!file2.mkdirs())
          file1 = Environment.getExternalStorageDirectory(); 
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder(file1.getPath());
    stringBuilder.append("/");
    stringBuilder.append(this.mContext.getString(R.string.pos_member_list));
    stringBuilder.append("_");
    Date date = new Date();
    stringBuilder.append((new SimpleDateFormat("yyyyMMdd")).format(date));
    stringBuilder.append(".xls");
    this.bHB = stringBuilder.toString();
  }
  
  protected String a(q paramq) throws Exception {
    m m = r(new File(Tf()));
    l l = a(m, paramq.Th());
    null = a(c.ePn);
    i i2 = null[0];
    i i3 = null[1];
    i i1 = null[2];
    i1 = null[3];
    null = null[4];
    String str = paramq.Ti();
    String[] arrayOfString = paramq.Tj();
    if (str != null) {
      l.a(new d(false, false, str, i2));
      i = 1;
    } else {
      int i;
      i = 0;
    } 
    int j = arrayOfString.length;
    byte b1 = 0;
    byte b = i;
    int i;
    for (i = b1; i < j; i++) {
      String str1 = arrayOfString[i];
      if (n.a(str1, paramq.Tk())) {
        l.a(new d(b, false, str1, i3));
      } else {
        l.a(new d(b, false, str1, i2));
      } 
      b++;
    } 
    ArrayList arrayList = paramq.zJ();
    i = 1;
    b = 0;
    b1 = -1;
    while (b < arrayList.size()) {
      HashMap hashMap = (HashMap)arrayList.get(b);
      if (x(hashMap)) {
        if (str != null) {
          l.a(new d(false, i, (String)hashMap.get(str), i2));
        } else {
          n.println("这里，理论上不会进来");
        } 
        if (b1 != -1)
          l.v(0, b1, 0, i - 1); 
        b1 = i;
      } else {
        if (str != null) {
          j = 1;
        } else {
          j = 0;
        } 
        int k = arrayOfString.length;
        int i4 = 0;
        int n = j;
        j = i;
        for (i = i4; i < k; i++) {
          d d = arrayOfString[i];
          String str1 = (String)hashMap.get(d);
          if (n.a(d, paramq.Tk())) {
            e e = new e(n, j, n.u(str1), i3);
          } else {
            d = new d(n, j, str1, i2);
          } 
          l.a(d);
          n++;
        } 
        i = j + 1;
      } 
      b++;
    } 
    if (b1 != -1)
      l.v(0, b1, 0, i - 1); 
    a(m);
    return null;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\transfer\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */