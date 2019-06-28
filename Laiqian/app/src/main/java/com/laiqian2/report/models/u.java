package com.laiqian.report.models;

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
import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.text.format.Time;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.u;
import com.laiqian.infrastructure.R;
import com.laiqian.models.ao;
import com.laiqian.util.n;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class u extends ao {
  private String daB = RootApplication.zv().getString(R.string.pos_report_transaction_export_product);
  
  protected double[] daq;
  
  private String dbA;
  
  private String dbB;
  
  private String dbC;
  
  private String dbD;
  
  private String dbE;
  
  private String dbF;
  
  private String dbG;
  
  private String dbH;
  
  private String dbI;
  
  private String dbJ;
  
  private String dbK;
  
  private boolean dbL;
  
  private boolean dbM;
  
  protected final String dbN = RootApplication.zA();
  
  private String[] dbO;
  
  private boolean dbP;
  
  private String dbQ = "";
  
  protected int dby;
  
  protected String dbz;
  
  public u(Context paramContext) {
    super(paramContext);
    String str = B(Time.class);
    Time time = new Time();
    time.setToNow();
    this.dbA = time.format(str);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(time.year);
    stringBuilder.append("");
    this.dbz = stringBuilder.toString();
    time.monthDay--;
    time.normalize(false);
    this.dbC = time.format(str);
    this.dbB = paramContext.getString(R.string.pos_report_today);
    this.dbD = paramContext.getString(R.string.pos_report_yesterday);
    this.dbE = paramContext.getString(R.string.pos_report_monday);
    this.dbF = paramContext.getString(R.string.pos_report_tuesday);
    this.dbG = paramContext.getString(R.string.pos_report_wednesday);
    this.dbH = paramContext.getString(R.string.pos_report_thursday);
    this.dbI = paramContext.getString(R.string.pos_report_friday);
    this.dbJ = paramContext.getString(R.string.pos_report_saturday);
    this.dbK = paramContext.getString(R.string.pos_report_sunday);
  }
  
  public static void W(HashMap<String, String> paramHashMap) { paramHashMap.put("isGroup", "true"); }
  
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
  
  public static String ann() { return RootApplication.zv().getString(R.string.pos_pos_SimpleDF); }
  
  private ArrayList<HashMap<String, String>> anp() {
    this.dbM = true;
    return zJ();
  }
  
  @NonNull
  private StringBuilder c(long paramLong1, long paramLong2, String paramString) {
    File file1;
    File file2 = this.mContext.getExternalCacheDir();
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
    stringBuilder.append(paramString);
    stringBuilder.append("_");
    stringBuilder.append(LQKVersion.zq());
    Time time = new Time();
    time.set(paramLong1);
    stringBuilder.append("_");
    stringBuilder.append(time.format("%Y%m%d%H%M"));
    time.set(paramLong2);
    stringBuilder.append("_");
    stringBuilder.append(time.format("%Y%m%d%H%M"));
    stringBuilder.append(".xls");
    return stringBuilder;
  }
  
  protected static Application getApplication() { return RootApplication.zv(); }
  
  private m r(File paramFile) throws Exception { return u.r(paramFile); }
  
  public static boolean x(HashMap<String, String> paramHashMap) { return "true".equals(paramHashMap.get("isGroup")); }
  
  protected abstract double[] AW();
  
  public String B(Class<?> paramClass) { return (paramClass == Time.class) ? RootApplication.zv().getResources().getString(R.string.pos_pos_SimpleDFDay) : RootApplication.zv().getResources().getString(R.string.pos_pos_SimpleDateFormatDay); }
  
  @Deprecated
  public String Tf() { return this.dbO[0]; }
  
  protected boolean UA() { return false; }
  
  protected boolean UB() { return false; }
  
  protected boolean UC() { return false; }
  
  protected boolean UD() { return false; }
  
  protected boolean UE() { return false; }
  
  protected String a(s params) throws Exception { return a(params, Tf(), false); }
  
  protected String a(s params, String paramString, boolean paramBoolean) throws Exception {
    m m1 = r(new File(paramString));
    l l = a(m1, params.Th());
    null = a(c.ePn);
    i i2 = null[0];
    i i3 = null[1];
    null = null[2];
    null = null[3];
    i i1 = null[4];
    String str = params.Ti();
    String[] arrayOfString = params.Tj();
    int j = arrayOfString.length;
    int i = j;
    if (str != null)
      i = j + 1; 
    int k = i + 2 - 1;
    l.v(2, 3, k, 3);
    l.a(new d(2, 3, params.getTitle(), null));
    Iterator iterator = params.ana().iterator();
    for (i = 4; iterator.hasNext(); i++) {
      s.a a = (s.a)iterator.next();
      l.a(new d(2, i, a.key, i2));
      l.v(3, i, k, i);
      l.a(new d(3, i, a.value, i3));
    } 
    iterator = params.anb().iterator();
    for (j = i; iterator.hasNext(); j++) {
      s.a a = (s.a)iterator.next();
      l.a(new d(2, j, a.key, null));
      l.v(3, j, k, j);
      l.a(new d(3, j, a.value, i1));
    } 
    if (str != null) {
      l.a(new d(2, j, str, i2));
      i = 3;
    } else {
      i = 2;
    } 
    int n = arrayOfString.length;
    int m = 0;
    k = i;
    for (i = m; i < n; i++) {
      String str1 = arrayOfString[i];
      if (n.a(str1, params.Tk())) {
        l.a(new d(k, j, str1, i3));
      } else {
        l.a(new d(k, j, str1, i2));
      } 
      k++;
    } 
    ArrayList arrayList = params.zJ();
    i = j + 1;
    n = 0;
    j = -1;
    while (n < arrayList.size()) {
      String str2;
      ArrayList arrayList1;
      String[] arrayOfString1;
      HashMap hashMap = (HashMap)arrayList.get(n);
      if (x(hashMap)) {
        String[] arrayOfString3;
        ArrayList arrayList3;
        String str4;
        if (str != null) {
          l.a(new d(2, i, (String)hashMap.get(str), i2));
        } else {
          n.println("这里，理论上不会进来");
        } 
        if (j != -1)
          l.v(2, j, 2, i - 1); 
        j = i;
        String str5 = str;
        arrayOfString1 = arrayOfString;
        arrayList1 = arrayList;
        str2 = str5;
      } else {
        ArrayList arrayList3;
        String[] arrayOfString3;
        String str4;
        if (arrayOfString1 != null) {
          k = 3;
        } else {
          k = 2;
        } 
        if (paramBoolean) {
          if (hashMap.containsKey(this.daB)) {
            ArrayList arrayList4;
            String str5;
            String[] arrayOfString4;
            String[] arrayOfString6 = ((String)hashMap.get(this.daB)).split("/");
            int i5 = arrayOfString6.length;
            int i4 = 0;
            String[] arrayOfString5 = arrayOfString1;
            m = j;
            j = i4;
            while (j < i5) {
              ArrayList arrayList5;
              String str6 = arrayOfString6[j];
              i4 = arrayList1.length;
              int i7 = k;
              int i8 = 0;
              int i6 = i;
              arrayOfString1 = arrayOfString6;
              i = i4;
              i4 = m;
              ArrayList arrayList6 = arrayList1;
              m = j;
              null = hashMap;
              j = i5;
              for (i5 = i8; i5 < i; i5++) {
                d d;
                ArrayList arrayList7 = arrayList6[i5];
                if (this.daB.equals(arrayList7)) {
                  d = str6;
                } else {
                  String str7;
                  d = (String)null.get(arrayList7);
                } 
                if (n.a(arrayList7, params.Tk())) {
                  e e;
                  d = new e(i7, i6, n.u(d), i3);
                } else {
                  d = new d(i7, i6, d, i2);
                } 
                l.a(d);
                i7++;
              } 
              i = i6 + 1;
              m++;
              i5 = j;
              hashMap = null;
              j = m;
              arrayList5 = arrayList6;
              m = i4;
              String[] arrayOfString7 = arrayOfString1;
            } 
            str4 = arrayList5;
            j = m;
            arrayOfString3 = str2;
            arrayList3 = arrayOfString5;
          } else {
            String[] arrayOfString4 = arrayList3;
            String str5 = arrayOfString3;
            arrayList3 = str4;
            arrayOfString3 = arrayOfString4;
            str4 = str5;
          } 
        } else {
          String str5 = str4;
          int i5 = arrayOfString3.length;
          int i4 = k;
          k = 0;
          m = i;
          i = i5;
          null = hashMap;
          while (k < i) {
            d d = arrayOfString3[k];
            String str6 = (String)null.get(d);
            if (n.a(d, params.Tk())) {
              e e = new e(i4, m, n.u(str6), i3);
            } else {
              d = new d(i4, m, str6, i2);
            } 
            l.a(d);
            i4++;
            k++;
          } 
          i = m + 1;
          arrayOfString1 = arrayOfString3;
          arrayList1 = arrayList3;
          str2 = str5;
        } 
      } 
      n++;
      String str3 = str2;
      ArrayList arrayList2 = arrayList1;
      String[] arrayOfString2 = arrayOfString1;
      String str1 = str3;
    } 
    if (j != -1)
      l.v(2, j, 2, i - 1); 
    a(m1);
    return null;
  }
  
  public abstract void a(t paramt);
  
  protected String aQ(Object paramObject) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.dbN);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramObject);
    stringBuilder2.append("");
    stringBuilder1.append(n.a(Double.valueOf(Double.parseDouble(stringBuilder2.toString())), true));
    return stringBuilder1.toString();
  }
  
  public String akB() { return this.dbQ; }
  
  protected List<u> amC() { return null; }
  
  public double[] amw() {
    if (this.daq == null) {
      long l = System.currentTimeMillis();
      this.daq = AW();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("获取总金额的时间：");
      stringBuilder.append(System.currentTimeMillis() - l);
      n.println(stringBuilder.toString());
    } 
    return this.daq;
  }
  
  public String anm() { return B(java.text.SimpleDateFormat.class); }
  
  public boolean ano() { return this.dbL; }
  
  public ArrayList<HashMap<String, String>> anq() { return anp(); }
  
  public ArrayList<HashMap<String, String>> anr() {
    this.dbP = true;
    ArrayList arrayList = anp();
    this.dbP = false;
    return arrayList;
  }
  
  protected boolean ans() { return this.dbP; }
  
  protected String ant() {
    if (this.dbM) {
      this.dbM = false;
      return "";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" limit ");
    int i = this.dby;
    this.dby = i + 1;
    stringBuilder.append(i * getPageSize());
    stringBuilder.append(",");
    stringBuilder.append(getPageSize());
    return stringBuilder.toString();
  }
  
  public boolean anu() { return (this.dby == 1 && !this.dbL); }
  
  public void b(long paramLong1, long paramLong2, String paramString) {
    StringBuilder stringBuilder = c(paramLong1, paramLong2, paramString);
    this.dbO = new String[1];
    this.dbO[0] = stringBuilder.toString();
  }
  
  protected void gC(boolean paramBoolean) { this.dbL = paramBoolean; }
  
  protected int getPageSize() { return 50; }
  
  protected void init() {}
  
  public void jI(int paramInt) {}
  
  protected String jL(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 6:
        return this.dbJ;
      case 5:
        return this.dbI;
      case 4:
        return this.dbH;
      case 3:
        return this.dbG;
      case 2:
        return this.dbF;
      case 1:
        return this.dbE;
      case 0:
        break;
    } 
    return this.dbK;
  }
  
  public void nm(String paramString) { this.dbQ = paramString; }
  
  public String nq(String paramString) { return this.dbA.equals(paramString) ? this.dbB : (this.dbC.equals(paramString) ? this.dbD : (paramString.startsWith(this.dbz) ? paramString.substring(5) : ((paramString.endsWith(this.dbz) && paramString.length() > 5) ? paramString.substring(0, paramString.length() - 5) : paramString))); }
  
  protected String y(long paramLong1, long paramLong2) {
    Time time = new Time();
    time.set(paramLong1);
    String str1 = time.format(ann());
    time.set(paramLong2);
    String str2 = time.format(ann());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append("~");
    stringBuilder.append(str2);
    return stringBuilder.toString();
  }
  
  public abstract ArrayList<HashMap<String, String>> zJ();
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\model\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */