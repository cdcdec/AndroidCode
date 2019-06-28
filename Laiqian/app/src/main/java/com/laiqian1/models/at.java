package com.laiqian.models;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.entity.g;
import com.laiqian.product.models.n;
import com.laiqian.util.by;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class at extends as {
  public static final ao.b<String> bNA;
  
  public static final ao.b<String> bNB;
  
  public static final ao.b<String> bNC;
  
  public static final ao.b<String> bND;
  
  public static final ao.b<Long> bNE;
  
  public static final ao.b<Long> bNF;
  
  public static final ao.b<Long> bNG;
  
  public static final ao.b<Long> bNH;
  
  public static final ao.b<Long> bNI;
  
  public static final ao.b<Double> bNJ;
  
  public static final ao.b<Double> bNK;
  
  public static final ao.b<Double> bNL;
  
  public static final ao.b<Double> bNM;
  
  public static final ao.b<Double> bNN = (bNM = (bNL = (bNK = (bNJ = (bNI = (bNH = (bNG = (bNF = (bNE = (bND = (bNC = (bNB = (bNA = (bNz = (bNy = (bNx = (bNw = (bNv = (bTx = (bOe = (bTw = (bNq = (bNj = (bNu = (bNp = (bTv = (bTu = (bTt = (bNi = ao.b.ig("_id")).ig("nFieldType")).ie("sFieldName")).ie("sFieldValue")).ie("sText")).ig("nUpdateFlag")).ig("nShopID")).ig("nUserID")).ig("nStringID")).ie("sIsActive")).ie("sDefaultValue")).ig("nIsUpdated")).ig("nOperationTime")).ie("sPlatform")).ig("nWarehouseID")).ie("sSpareField1")).ie("sSpareField2")).ie("sSpareField3")).ie("sSpareField4")).ie("sSpareField5")).ig("nSpareField1")).ig("nSpareField2")).ig("nSpareField3")).ig("nSpareField4")).ig("nSpareField5")).if("fSpareField1")).if("fSpareField2")).if("fSpareField3")).if("fSpareField4")).if("fSpareField5");
  
  public static final Collection<ao.b> bNO;
  
  public static final ao.b<Long> bNi;
  
  public static final ao.b<Long> bNj;
  
  public static final ao.b<String> bNp;
  
  public static final ao.b<Long> bNq;
  
  public static final ao.b<Long> bNu;
  
  public static final ao.b<Long> bNv;
  
  public static final ao.b<Long> bNw;
  
  public static final ao.b<String> bNx;
  
  public static final ao.b<Long> bNy;
  
  public static final ao.b<String> bNz;
  
  public static final ao.b<String> bOe;
  
  public static final ao.b<Long> bTt;
  
  public static final ao.b<String> bTu;
  
  public static final ao.b<String> bTv;
  
  public static final ao.b<Long> bTw;
  
  public static final ao.b<String> bTx;
  
  static  {
    ArrayList arrayList = new ArrayList();
    arrayList.add(bNi);
    arrayList.add(bTt);
    arrayList.add(bTu);
    arrayList.add(bTv);
    arrayList.add(bNp);
    arrayList.add(bNu);
    arrayList.add(bNj);
    arrayList.add(bNq);
    arrayList.add(bTw);
    arrayList.add(bOe);
    arrayList.add(bTx);
    arrayList.add(bNv);
    arrayList.add(bNw);
    arrayList.add(bNx);
    arrayList.add(bNy);
    arrayList.add(bNz);
    arrayList.add(bNA);
    arrayList.add(bNB);
    arrayList.add(bNC);
    arrayList.add(bND);
    arrayList.add(bNE);
    arrayList.add(bNF);
    arrayList.add(bNG);
    arrayList.add(bNH);
    arrayList.add(bNI);
    arrayList.add(bNJ);
    arrayList.add(bNK);
    arrayList.add(bNL);
    arrayList.add(bNM);
    arrayList.add(bNN);
    bNO = Collections.unmodifiableCollection(arrayList);
  }
  
  public at(Context paramContext) { super(paramContext); }
  
  private void a(double paramDouble, Cursor paramCursor1, List<g> paramList, Cursor paramCursor2) {
    long l = paramCursor2.getLong(paramCursor2.getColumnIndex("_id"));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update T_STRING set fSpareField1 =");
    stringBuilder.append(paramDouble);
    stringBuilder.append(" where nFieldType=");
    stringBuilder.append(26);
    stringBuilder.append(" and nShopID=");
    stringBuilder.append(VC());
    stringBuilder.append(" and _id=");
    stringBuilder.append(l);
    String str = stringBuilder.toString();
    Vq().execSQL(str);
    int i = paramCursor1.getInt(paramCursor1.getColumnIndex("nSpareField1"));
    str = paramCursor1.getString(paramCursor1.getColumnIndex("sFieldName"));
    paramList.add(new g(l, i, paramCursor1.getDouble(paramCursor1.getColumnIndex("fSpareField2")), paramDouble, str, paramCursor1.getDouble(paramCursor1.getColumnIndex("fSpareField3")), paramCursor1.getInt(paramCursor1.getColumnIndex("nSpareField2"))));
  }
  
  private void a(String paramString, double paramDouble1, double paramDouble2, Cursor paramCursor1, List<g> paramList, Cursor paramCursor2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble1);
    stringBuilder.append("");
    am("fSpareField1", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramDouble2);
    stringBuilder.append("");
    am("fSpareField2", stringBuilder.toString());
    long l = paramCursor2.getLong(paramCursor2.getColumnIndex("_id"));
    String str = VC();
    stringBuilder = new StringBuilder();
    stringBuilder.append(l);
    stringBuilder.append("");
    d("nFieldType = ? and nShopID = ? and _id = ? ", new String[] { "26", str, stringBuilder.toString() });
    update();
    paramList.add(new g(l, paramCursor1.getInt(paramCursor1.getColumnIndex("nSpareField1")), paramDouble2, paramDouble1, paramString, paramCursor1.getDouble(paramCursor1.getColumnIndex("fSpareField3")), paramCursor1.getInt(paramCursor1.getColumnIndex("nSpareField2"))));
  }
  
  private void b(double paramDouble, Cursor paramCursor1, List<g> paramList, Cursor paramCursor2) {
    long l = paramCursor2.getLong(paramCursor2.getColumnIndex("_id"));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("update T_STRING set fSpareField2 =");
    stringBuilder.append(paramDouble);
    stringBuilder.append(" where nFieldType=");
    stringBuilder.append(26);
    stringBuilder.append(" and nShopID=");
    stringBuilder.append(VC());
    stringBuilder.append(" and _id=");
    stringBuilder.append(l);
    String str = stringBuilder.toString();
    Vq().execSQL(str);
    int i = paramCursor1.getInt(paramCursor1.getColumnIndex("nSpareField1"));
    str = paramCursor1.getString(paramCursor1.getColumnIndex("sFieldName"));
    paramList.add(new g(l, i, paramDouble, paramCursor1.getDouble(paramCursor1.getColumnIndex("fSpareField1")), str, paramCursor1.getDouble(paramCursor1.getColumnIndex("fSpareField3")), paramCursor1.getInt(paramCursor1.getColumnIndex("nSpareField2"))));
  }
  
  public boolean BN() {
    hY("_id");
    c("nFieldType=76 and sFieldValue='N' and nShopID=?", new String[] { VC() });
    Cursor cursor = VM();
    boolean bool = cursor.moveToFirst();
    cursor.close();
    return bool ^ true;
  }
  
  public long RI() {
    Cursor cursor = Vq().rawQuery("select max(_id) from T_STRING where nFieldType = 26", new String[0]);
    long l = 0L;
    while (cursor != null) {
      try {
        if (cursor.moveToNext()) {
          l = cursor.getLong(0);
          continue;
        } 
        break;
      } finally {
        if (cursor != null)
          cursor.close(); 
      } 
    } 
    if (cursor != null)
      cursor.close(); 
    return l;
  }
  
  public ArrayList<g> RJ() {
    ArrayList arrayList = new ArrayList();
    null = new StringBuilder();
    null.append("select t_string._id,  nSpareField1,  sFieldName,  fSpareField1,  fSpareField2,  fSpareField3,  nSpareField2,  nUpdateFlag \n\nfrom t_string INNER JOIN (SELECT min(_id) _id,nShopID FROM t_string where nFieldType =26 and nShopID = ");
    null.append(VC());
    null.append(" and sIsActive = 'Y' GROUP BY nSpareField1)t\n\nON t.nShopID = t_string.nShopID and t._id = t_string._id\n\n where nFieldType =");
    null.append(26);
    null.append(" and t_string.nShopID = ");
    null.append(VC());
    null.append(" and sIsActive = 'Y'  order by nSpareField1");
    null = null.toString();
    Cursor cursor = Vq().rawQuery(null, new String[0]);
    while (cursor.moveToNext()) {
      int i = cursor.getInt(cursor.getColumnIndex("nSpareField1"));
      long l = cursor.getLong(cursor.getColumnIndex("_id"));
      String str = cursor.getString(cursor.getColumnIndex("sFieldName"));
      double d = cursor.getDouble(cursor.getColumnIndex("fSpareField1"));
      arrayList.add(new g(l, i, cursor.getDouble(cursor.getColumnIndex("fSpareField2")), d, str, cursor.getDouble(cursor.getColumnIndex("fSpareField3")), cursor.getInt(cursor.getColumnIndex("nSpareField2"))));
    } 
    cursor.close();
    return arrayList;
  }
  
  @Deprecated
  public boolean Wf() {
    null = new StringBuilder();
    null.append(" nFieldType = 71  and nShopID = ");
    null.append(VC());
    null.append(" and sIsActive = 'Y'");
    hZ(null.toString());
    Cursor cursor = VM();
    boolean bool2 = cursor.moveToFirst();
    boolean bool = false;
    boolean bool1 = bool;
    if (bool2) {
      String str = cursor.getString(cursor.getColumnIndex("sFieldValue"));
      if ("1".equals(str) || "Y".equals(str)) {
        bool1 = true;
        cursor.close();
        return bool1;
      } 
      bool1 = bool;
      if (!"0".equals(str)) {
        "N".equals(str);
        bool1 = bool;
      } 
    } 
    cursor.close();
    return bool1;
  }
  
  public double Wg() {
    double d;
    null = new StringBuilder();
    null.append(" nFieldType = 72  and nShopID = ");
    null.append(VC());
    null.append(" and sIsActive = 'Y'");
    hZ(null.toString());
    Cursor cursor = VM();
    a.AZ().BA();
    if (cursor.moveToFirst()) {
      d = cursor.getDouble(cursor.getColumnIndex("sFieldValue"));
    } else {
      d = 100.0D;
    } 
    cursor.close();
    return d;
  }
  
  @Deprecated
  public boolean Wh() {
    hY("sFieldValue");
    null = new StringBuilder();
    null.append(" nFieldType = 73  and nShopID = ");
    null.append(VC());
    null.append(" and sIsActive = 'Y'");
    hZ(null.toString());
    Cursor cursor = VM();
    boolean bool2 = cursor.moveToFirst();
    boolean bool1 = false;
    if (bool2)
      bool1 = "Y".equals(cursor.getString(0)); 
    cursor.close();
    return bool1;
  }
  
  public long Wi() {
    long l;
    Cursor cursor = We();
    if (cursor.moveToFirst()) {
      l = cursor.getLong(cursor.getColumnIndex("_id"));
    } else {
      l = 0L;
    } 
    cursor.close();
    return l;
  }
  
  public Cursor Wj() {
    hY("sFieldValue");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("_id=");
    stringBuilder.append(VC());
    stringBuilder.append(" and nFieldType = ");
    stringBuilder.append(69);
    stringBuilder.append("  and nShopID = ");
    stringBuilder.append(VC());
    hZ(stringBuilder.toString());
    return VM();
  }
  
  public Cursor Wk() {
    hY("sFieldValue");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" nFieldType = 130  and nShopID = ");
    stringBuilder.append(VC());
    hZ(stringBuilder.toString());
    return VM();
  }
  
  public Boolean Wl() {
    hY("sFieldValue");
    null = new StringBuilder();
    null.append(" nFieldType = 130  and nShopID = ");
    null.append(VC());
    hZ(null.toString());
    Cursor cursor = VM();
    if (cursor == null || !cursor.moveToNext()) {
      boolean bool1 = true;
      cursor.close();
      return Boolean.valueOf(bool1);
    } 
    boolean bool = false;
    cursor.close();
    return Boolean.valueOf(bool);
  }
  
  public String Wm() {
    Object object = null;
    str1 = null;
    String str2 = object;
    try {
      Cursor cursor = Wj();
      str2 = object;
      if (cursor.moveToFirst()) {
        str2 = object;
        str1 = cursor.getString(0);
      } 
      str2 = str1;
      cursor.close();
      return str1;
    } catch (Exception str1) {
      a.e(str1);
      return str2;
    } 
  }
  
  @Deprecated
  public boolean Wn() {
    hY("sFieldValue");
    c("nFieldType=70 and nShopID=?", new String[] { VC() });
    Cursor cursor = VM();
    boolean bool2 = cursor.moveToFirst();
    boolean bool1 = bool2;
    if (bool2)
      bool1 = "Y".equalsIgnoreCase(cursor.getString(0)); 
    cursor.close();
    return bool1;
  }
  
  public ArrayList<n> Wo() {
    ArrayList arrayList = new ArrayList();
    hY("_id,sFieldName");
    null = new StringBuilder();
    null.append(" nFieldType = 50 and sIsActive = 'Y' and nShopID = ");
    null.append(VC());
    hZ(null.toString());
    Cursor cursor = VM();
    while (cursor.moveToNext())
      arrayList.add(new n(cursor.getLong(0), cursor.getString(1))); 
    cursor.close();
    return arrayList;
  }
  
  public boolean Wp() {
    boolean bool;
    Cursor cursor = Wk();
    if (cursor != null && cursor.moveToFirst()) {
      bool = false;
      if (cursor.getInt(0) == 1)
        bool = true; 
    } else {
      bool = Wq();
    } 
    if (cursor != null)
      cursor.close(); 
    return bool;
  }
  
  public boolean Wq() {
    hY("_id");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(VC());
    stringBuilder.append("77");
    c("_id=? and nFieldType=77 and nShopID=? and sFieldValue='Y' and sIsActive='Y'", new String[] { stringBuilder.toString(), VC() });
    Cursor cursor = VM();
    boolean bool = cursor.moveToFirst();
    cursor.close();
    return bool;
  }
  
  public boolean Wr() {
    hY("sFieldValue");
    null = new StringBuilder();
    null.append(VC());
    null.append("84");
    c("nFieldType = ? and _id=?", new String[] { "84", null.toString() });
    Cursor cursor = VM();
    if (cursor.moveToNext()) {
      String str = cursor.getString(0);
      cursor.close();
      return "1".equals(str);
    } 
    cursor.close();
    return false;
  }
  
  public void Ws() {
    hY("sFieldValue");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(VC());
    stringBuilder.append("84");
    c("nFieldType = ? and _id=?", new String[] { "84", stringBuilder.toString() });
    Cursor cursor = VM();
    if (cursor.moveToNext()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(VC());
      stringBuilder1.append("84");
      String str1 = stringBuilder1.toString();
      String str2 = VC();
      am("sFieldValue", "1");
      d("_id=? and nFieldType=84 and nShopID=?", new String[] { str1, str2 });
      update();
    } else {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(VC());
      stringBuilder1.append("84");
      am("_id", stringBuilder1.toString());
      am("nFieldType", "84");
      am("sFieldValue", "1");
      QL();
    } 
    cursor.close();
  }
  
  public boolean Wt() {
    hY("sFieldValue");
    hZ(" nFieldType=140 ");
    Cursor cursor = VM();
    String str1 = "";
    String str2 = str1;
    if (cursor != null) {
      if (cursor.moveToLast())
        str1 = cursor.getString(0); 
      cursor.close();
      str2 = str1;
    } 
    return (by.parseInt(str2) == 1);
  }
  
  public boolean a(a parama, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    d("nFieldType = ?", new String[] { stringBuilder.toString() });
    return a(parama);
  }
  
  public boolean a(String paramString1, double paramDouble, long paramLong, String paramString2) {
    am("sFieldName", paramString1);
    am("nFieldType", "89");
    am("sFieldValue", String.valueOf(paramDouble));
    am("nShopID", paramString2);
    am("_id", String.valueOf(paramLong));
    return QL();
  }
  
  public boolean a(boolean paramBoolean, long paramLong) { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n"); }
  
  public boolean an(String paramString1, String paramString2) {
    boolean bool;
    if (!by.isNull(paramString1)) {
      if (by.isNull(paramString2))
        return false; 
      try {
        if (by.isNull(iq(paramString1))) {
          bool = ao(paramString1, paramString2);
        } else {
          am("sFieldValue", paramString2);
          d("nFieldType=? and nSpareField1=?", new String[] { "85", paramString1 });
          bool = update();
        } 
      } catch (Exception paramString1) {
        a.e(paramString1);
        return false;
      } 
    } else {
      return false;
    } 
    return bool;
  }
  
  public boolean ao(String paramString1, String paramString2) {
    if (by.isNull(paramString1) || by.isNull(paramString2))
      return false; 
    am("sFieldValue", paramString2);
    am("nFieldType", "85");
    am("nSpareField1", paramString1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(System.currentTimeMillis());
    am("_id", stringBuilder.toString());
    return QL();
  }
  
  public List<g> b(double paramDouble, int paramInt) {
    hY("_id,nSpareField1,sFieldName,fSpareField2,fSpareField3,nSpareField2");
    null = new StringBuilder();
    null.append(" nFieldType = 26 and nShopID = ");
    null.append(VC());
    null.append(" and sIsActive = 'Y' and nSpareField1 =");
    null.append(paramInt);
    hZ(null.toString());
    Cursor cursor1 = VM();
    ArrayList arrayList = new ArrayList();
    if (cursor1 != null)
      while (cursor1.moveToNext())
        a(paramDouble, cursor1, arrayList, cursor1);  
    hY("_id,nSpareField1,sFieldName,fSpareField2,fSpareField3,nSpareField2");
    null = new StringBuilder();
    null.append(" nFieldType = 26 and nShopID = ");
    null.append(VC());
    null.append(" and sIsActive = 'Y' and nSpareField1 >");
    null.append(paramInt);
    null.append(" and fSpareField1 >");
    null.append(paramDouble);
    hZ(null.toString());
    Cursor cursor2 = VM();
    if (cursor2 != null)
      try {
        while (cursor2.moveToNext())
          a(paramDouble, cursor2, arrayList, cursor2); 
      } finally {
        cursor2.close();
        cursor1.close();
      }  
    cursor2.close();
    cursor1.close();
    return arrayList;
  }
  
  public boolean b(String paramString1, double paramDouble, long paramLong, String paramString2) {
    am("sFieldName", paramString1);
    am("sFieldValue", String.valueOf(paramDouble));
    d("nFieldType='89' and _id=?", new String[] { String.valueOf(paramLong) });
    return update();
  }
  
  public boolean bG(long paramLong) {
    am("sIsActive", "N");
    String str = VC();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    d("nFieldType = ? and nShopID = ? and _id = ? ", new String[] { "26", str, stringBuilder.toString() });
    return update();
  }
  
  public g bH(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" nFieldType = 26 and _id like '%");
    stringBuilder.append(paramLong % 100000L);
    stringBuilder.append("%'  and nShopID = ");
    stringBuilder.append(VC());
    stringBuilder.append(" and sIsActive = 'Y'");
    hZ(stringBuilder.toString());
    Cursor cursor = VM();
    if (cursor.moveToFirst()) {
      int i = cursor.getInt(cursor.getColumnIndex("nSpareField1"));
      String str = cursor.getString(cursor.getColumnIndex("sFieldName"));
      double d = cursor.getDouble(cursor.getColumnIndex("fSpareField1"));
      g g = new g(paramLong, i, cursor.getDouble(cursor.getColumnIndex("fSpareField2")), d, str);
    } else {
      stringBuilder = null;
    } 
    cursor.close();
    return stringBuilder;
  }
  
  public g bI(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" nFieldType = 26 and _id =");
    stringBuilder.append(paramLong);
    stringBuilder.append(" and nShopID = ");
    stringBuilder.append(VC());
    stringBuilder.append(" and sIsActive = 'Y' ");
    hZ(stringBuilder.toString());
    Cursor cursor = VM();
    if (cursor.moveToFirst()) {
      int i = cursor.getInt(cursor.getColumnIndex("nSpareField1"));
      String str = cursor.getString(cursor.getColumnIndex("sFieldName"));
      double d = cursor.getDouble(cursor.getColumnIndex("fSpareField1"));
      g g = new g(paramLong, i, cursor.getDouble(cursor.getColumnIndex("fSpareField2")), d, str);
    } else {
      stringBuilder = null;
    } 
    cursor.close();
    return stringBuilder;
  }
  
  public g bJ(long paramLong) {
    if (paramLong < 0L)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" nFieldType = 26 and nSpareField1 = ");
    stringBuilder.append(paramLong);
    stringBuilder.append("  and nShopID = ");
    stringBuilder.append(VC());
    stringBuilder.append(" and sIsActive = 'Y'");
    hZ(stringBuilder.toString());
    Cursor cursor = VM();
    if (cursor.moveToNext()) {
      paramLong = cursor.getLong(cursor.getColumnIndex("_id"));
      int i = cursor.getInt(cursor.getColumnIndex("nSpareField1"));
      String str = cursor.getString(cursor.getColumnIndex("sFieldName"));
      double d = cursor.getDouble(cursor.getColumnIndex("fSpareField1"));
      g g = new g(paramLong, i, cursor.getDouble(cursor.getColumnIndex("fSpareField2")), d, str);
    } else {
      stringBuilder = null;
    } 
    cursor.close();
    return stringBuilder;
  }
  
  public boolean bK(long paramLong) {
    am("sIsActive", "N");
    d("nFieldType='89' and _id=?", new String[] { String.valueOf(paramLong) });
    return update();
  }
  
  public boolean e(g paramg) {
    try {
      Vq().beginTransaction();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(" nFieldType = 26 and nSpareField1 = ");
      stringBuilder1.append(paramg.getNumber());
      stringBuilder1.append(" and nShopID = ");
      stringBuilder1.append(VC());
      stringBuilder1.append(" and sIsActive = 'Y'");
      hZ(stringBuilder1.toString());
      Cursor cursor = VM();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramg.getNumber());
      stringBuilder2.append("");
      am("nSpareField1", stringBuilder2.toString());
      am("sFieldName", paramg.EV());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramg.EU());
      stringBuilder2.append("");
      am("fSpareField1", stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramg.ET());
      stringBuilder2.append("");
      am("fSpareField2", stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramg.ES());
      stringBuilder2.append("");
      am("nSpareField2", stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramg.EP());
      stringBuilder2.append("");
      am("fSpareField3", stringBuilder2.toString());
      if (cursor.moveToFirst()) {
        String str = VC();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramg.getNumber());
        stringBuilder.append("");
        d("nFieldType = ? and nShopID = ? and nSpareField1 = ? ", new String[] { "26", str, stringBuilder.toString() });
        bool = update();
      } else {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(paramg.getId());
        stringBuilder2.append("");
        am("_id", stringBuilder2.toString());
        am("nFieldType", "26");
        am("nShopID", VC());
        bool = QL();
      } 
      cursor.close();
      setTransactionSuccessful();
      return bool;
    } finally {
      Vq().endTransaction();
    } 
  }
  
  public boolean em(boolean paramBoolean) {
    Cursor cursor = We();
    boolean bool = paramBoolean;
    if (cursor.moveToFirst()) {
      String str = cursor.getString(cursor.getColumnIndex("sFieldValue"));
      if ("1".equals(str)) {
        bool = true;
      } else {
        bool = paramBoolean;
        if ("0".equals(str))
          bool = false; 
      } 
    } 
    cursor.close();
    return bool;
  }
  
  public void en(boolean paramBoolean) {
    String str = We();
    boolean bool = str.moveToFirst();
    str.close();
    if (paramBoolean) {
      String str1 = "1";
    } else {
      str = "0";
    } 
    am("sFieldValue", str);
    if (bool) {
      d("nFieldType = ? and nShopID = ?", new String[] { "67", VC() });
      update();
      return;
    } 
    am("nFieldType", "67");
    am("nShopID", VC());
    QL();
  }
  
  public boolean eo(boolean paramBoolean) { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n"); }
  
  public void ep(boolean paramBoolean) {
    hY("sFieldValue");
    String[] arrayOfString = new String[2];
    String str = new StringBuilder();
    str.append(VC());
    str.append("77");
    arrayOfString[0] = str.toString();
    arrayOfString[1] = VC();
    c("_id=? and nFieldType=77 and nShopID=?", arrayOfString);
    if (paramBoolean) {
      String str1 = "Y";
    } else {
      str = "N";
    } 
    Cursor cursor = VM();
    if (cursor.moveToFirst()) {
      if (!str.equals(cursor.getString(0))) {
        am("sFieldValue", str);
        d("_id=? and nFieldType=77 and nShopID=?", arrayOfString);
        update();
      } 
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(VC());
      stringBuilder.append("77");
      am("_id", stringBuilder.toString());
      am("nFieldType", "77");
      am("sFieldValue", str);
      am("sIsActive", "Y");
      QL();
    } 
    RootApplication.getLaiqianPreferenceManager().hN(paramBoolean);
    cursor.close();
  }
  
  public boolean f(g paramg) {
    StringBuilder stringBuilder;
    g g1 = null;
    try {
      stringBuilder = new StringBuilder();
      stringBuilder.append(" nFieldType = 26 and sFieldName='");
      stringBuilder.append(paramg.EV());
      stringBuilder.append("' and nShopID = ");
      stringBuilder.append(VC());
      stringBuilder.append(" and sIsActive = 'Y'");
      hZ(stringBuilder.toString());
      cursor = VM();
    } finally {
      stringBuilder = null;
    } 
    if (paramg != null)
      paramg.close(); 
    throw stringBuilder;
  }
  
  public ArrayList<a> gZ(String paramString) {
    c("_id = ? and nShopID = ?", new String[] { paramString, VC() });
    Cursor cursor = VM();
    if (cursor == null)
      throw new NullPointerException("wrong sql"); 
    ArrayList arrayList = new ArrayList();
    while (cursor.moveToNext()) {
      a a = new a();
      ao.a(cursor, a);
      arrayList.add(a);
    } 
    cursor.close();
    return arrayList;
  }
  
  public ArrayList<a> gl(int paramInt) {
    null = new StringBuilder();
    null.append(paramInt);
    null.append("");
    c("nFieldType = ? and nShopID = ?", new String[] { null.toString(), VC() });
    Cursor cursor = VM();
    if (cursor == null)
      throw new NullPointerException("wrong sql"); 
    ArrayList arrayList = new ArrayList();
    while (cursor.moveToNext()) {
      a a = new a();
      ao.a(cursor, a);
      arrayList.add(a);
    } 
    cursor.close();
    return arrayList;
  }
  
  public List<g> h(g paramg) {
    double d1 = paramg.EU();
    double d2 = paramg.ET();
    int i = paramg.getNumber();
    null = paramg.EV();
    hY("_id,nSpareField1,sFieldName,fSpareField2,fSpareField3,nSpareField2");
    null = new StringBuilder();
    null.append(" nFieldType = 26 and nShopID = ");
    null.append(VC());
    null.append(" and sIsActive = 'Y' and nSpareField1 =");
    null.append(i);
    hZ(null.toString());
    Cursor cursor1 = VM();
    ArrayList arrayList = new ArrayList();
    if (cursor1 != null)
      while (cursor1.moveToNext())
        a(null, d1, d2, cursor1, arrayList, cursor1);  
    hY("_id,nSpareField1,sFieldName,fSpareField2,fSpareField3,nSpareField2");
    null = new StringBuilder();
    null.append(" nFieldType = 26 and nShopID = ");
    null.append(VC());
    null.append(" and sIsActive = 'Y' and nSpareField1 >");
    null.append(i);
    null.append(" and fSpareField1 >");
    null.append(d1);
    hZ(null.toString());
    null = VM();
    if (null != null)
      try {
        while (null.moveToNext())
          a(d1, null, arrayList, null); 
      } finally {
        null.close();
      }  
    null.close();
    hY("_id,nSpareField1,sFieldName,fSpareField1,fSpareField2,fSpareField3,nSpareField2");
    null = new StringBuilder();
    null.append(" nFieldType = 26 and nShopID = ");
    null.append(VC());
    null.append(" and sIsActive = 'Y' and nSpareField1 >");
    null.append(i);
    null.append(" and fSpareField2 <");
    null.append(d2);
    hZ(null.toString());
    Cursor cursor2 = VM();
    if (cursor2 != null)
      try {
        while (cursor2.moveToNext())
          b(d2, cursor2, arrayList, cursor2); 
      } finally {
        cursor2.close();
        cursor1.close();
      }  
    cursor2.close();
    cursor1.close();
    return arrayList;
  }
  
  public void im(String paramString) {
    Log.d("saveVipSmsSwitch", paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("_id=");
    stringBuilder.append(VC());
    stringBuilder.append(String.valueOf(80));
    stringBuilder.append(" and  nFieldType = ");
    stringBuilder.append(80);
    stringBuilder.append("  and nShopID = ");
    stringBuilder.append(VC());
    stringBuilder.append(" and sIsActive = 'Y'");
    hZ(stringBuilder.toString());
    Cursor cursor = VM();
    am("sFieldValue", paramString);
    if (cursor.moveToFirst()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(VC());
      stringBuilder1.append(String.valueOf(80));
      d("_id= ? and nFieldType = ? and nShopID = ?", new String[] { stringBuilder1.toString(), "80", VC() });
      update();
    } else {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(VC());
      stringBuilder1.append(String.valueOf(80));
      am("_id", stringBuilder1.toString());
      am("nFieldType", "80");
      am("nShopID", VC());
      QL();
    } 
    cursor.close();
  }
  
  public boolean in(String paramString) {
    null = new StringBuilder();
    null.append("_id= ");
    null.append(VC());
    null.append(String.valueOf(80));
    null.append(" and  nFieldType = ");
    null.append(80);
    null.append("  and nShopID = ");
    null.append(VC());
    null.append(" and sIsActive = 'Y'");
    hZ(null.toString());
    cursor = VM();
    boolean bool = false;
    try {
      if (cursor.moveToFirst()) {
        null = cursor.getString(cursor.getColumnIndex("sFieldValue"));
        bool1 = TextUtils.isEmpty(null);
        if (bool1)
          return false; 
        JSONObject jSONObject = new JSONObject(null);
        bool1 = bool;
        if (jSONObject.optBoolean(paramString)) {
          boolean bool2 = jSONObject.optBoolean("isOpenSMSNotice");
          bool1 = bool;
          if (bool2)
            bool1 = true; 
        } 
        return bool1;
      } 
      return false;
    } catch (Exception paramString) {
      return false;
    } finally {
      if (cursor != null)
        cursor.close(); 
    } 
  }
  
  public boolean io(String paramString) {
    Cursor cursor;
    byte b1 = 0;
    boolean bool1 = b1;
    try {
      boolean bool3;
      cursor = Wj();
      bool1 = b1;
      boolean bool4 = cursor.moveToFirst();
      bool1 = b1;
      am("sFieldValue", paramString);
      bool1 = b1;
      am("sIsActive", "Y");
      if (bool4) {
        bool1 = b1;
        d("_id=? and nFieldType = ? and nShopID = ?", new String[] { VC(), "69", VC() });
        bool1 = b1;
        bool3 = update();
        boolean bool = bool3;
      } else {
        bool1 = bool3;
        am("_id", VC());
        bool1 = bool3;
        am("nFieldType", "69");
        bool1 = bool3;
        am("nShopID", VC());
        bool1 = bool3;
        bool3 = QL();
        bool1 = bool3;
      } 
    } catch (Exception paramString) {
      a.e(paramString);
      return bool1;
    } 
    boolean bool2 = bool1;
    bool1 = bool2;
    cursor.close();
    return bool2;
  }
  
  public void ip(String paramString) {
    try {
      Vq().execSQL("UPDATE t_string set nIsUpdated = 1,nUpdateFlag=case when (nUpdateFlag is null or nUpdateFlag=0) then 1 else nUpdateFlag end  where _id = ? and nShopID = ?", new Object[] { paramString, VC() });
      return;
    } catch (Exception paramString) {
      a.e(paramString);
      return;
    } 
  }
  
  public String iq(String paramString) {
    if (by.isNull(paramString))
      return ""; 
    hY("sFieldValue");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" nFieldType=85 and nSpareField1=");
    stringBuilder.append(paramString);
    hZ(stringBuilder.toString());
    Cursor cursor = VM();
    paramString = "";
    String str = paramString;
    if (cursor != null) {
      if (cursor.moveToLast())
        paramString = cursor.getString(0); 
      cursor.close();
      str = paramString;
    } 
    return str;
  }
  
  public List<bf> ir(String paramString) {
    new ArrayList();
    try {
      arrayList = new ArrayList();
      null = new StringBuilder();
      null.append("select _id,sFieldName,sFieldValue from T_STRING where nFieldType=89 and nShopID=");
      null.append(paramString);
      null.append(" and sIsActive='Y'");
      paramString = null.toString();
      object = Vq().rawQuery(paramString, null);
    } finally {
      paramString = null;
    } 
    if (object != null)
      object.close(); 
    throw paramString;
  }
  
  public boolean p(int paramInt, boolean paramBoolean) {
    null = new StringBuilder();
    null.append(" nFieldType = ");
    null.append(paramInt);
    null.append("  and nShopID = ");
    null.append(VC());
    null.append(" and sIsActive = 'Y'");
    hZ(null.toString());
    Cursor cursor = VM();
    boolean bool = paramBoolean;
    if (cursor.moveToFirst()) {
      String str = cursor.getString(cursor.getColumnIndex("sFieldValue"));
      if ("Y".equals(str)) {
        bool = true;
      } else {
        bool = paramBoolean;
        if ("N".equals(str))
          bool = false; 
      } 
    } 
    cursor.close();
    return bool;
  }
  
  public void x(List<g> paramList) {
    try {
      Vq().beginTransaction();
      for (byte b1 = 0; b1 < paramList.size(); b1++) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(" nFieldType = 26 and nSpareField1 = ");
        stringBuilder1.append(((g)paramList.get(b1)).getNumber());
        stringBuilder1.append(" and nShopID = ");
        stringBuilder1.append(VC());
        stringBuilder1.append(" and sIsActive = 'Y'");
        hZ(stringBuilder1.toString());
        Cursor cursor = VM();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(((g)paramList.get(b1)).getNumber());
        stringBuilder2.append("");
        am("nSpareField1", stringBuilder2.toString());
        am("sFieldName", ((g)paramList.get(b1)).EV());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(((g)paramList.get(b1)).EU());
        stringBuilder2.append("");
        am("fSpareField1", stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(((g)paramList.get(b1)).ET());
        stringBuilder2.append("");
        am("fSpareField2", stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(((g)paramList.get(b1)).ES());
        stringBuilder2.append("");
        am("nSpareField2", stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(((g)paramList.get(b1)).EP());
        stringBuilder2.append("");
        am("fSpareField3", stringBuilder2.toString());
        if (cursor.moveToFirst()) {
          String str = VC();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(((g)paramList.get(b1)).getNumber());
          stringBuilder.append("");
          d("nFieldType = ? and nShopID = ? and nSpareField1 = ? ", new String[] { "26", str, stringBuilder.toString() });
          update();
        } else {
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(((g)paramList.get(b1)).getId());
          stringBuilder2.append("");
          am("_id", stringBuilder2.toString());
          am("nFieldType", "26");
          am("nShopID", VC());
          QL();
        } 
        cursor.close();
      } 
      setTransactionSuccessful();
      return;
    } finally {
      Vq().endTransaction();
    } 
  }
  
  class at {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\models\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */