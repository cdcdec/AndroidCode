package com.laiqian.models;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.orhanobut.logger.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ao extends ai {
  private static final String TAG = "ao";
  
  protected String aDZ;
  
  protected String aGA;
  
  protected String bKl = "0";
  
  protected String bKm = "0";
  
  protected String bKn = "'android'";
  
  protected String bLz;
  
  protected final String bSA = "LAIQIAN_READING_FILTER_CLAUSE";
  
  protected final String bSB = "LAIQIAN_READING_FILTER_PARAMETERIZED_ARRAY";
  
  protected final String bSC = "LAIQIAN_READING_ORDER_BY";
  
  protected final String bSD = "LAIQIAN_READING_LIMIT";
  
  protected final String bSE = "LAIQIAN_UPDATING_FIELD_NAMES";
  
  protected final String bSF = "LAIQIAN_UPDATING_VALUES_IN_PARAMETERIZED_ARRAY";
  
  protected final String bSG = "LAIQIAN_UPDATING_FILTER_CLAUSE";
  
  protected final String bSH = "LAIQIAN_UPDATING_FILTER_PARAMETERIZED_ARRAY";
  
  protected final String bSI = "LAIQIAN_DELETING_FILTER";
  
  protected final String bSJ = "LAIQIAN_DELETING_FILTER_PARAMETERIZED_ARRAY";
  
  protected String bSK = null;
  
  protected String bSL = null;
  
  protected String bSM = null;
  
  protected String bSN = "nIsUpdated";
  
  protected String bSO = "nOperationTime";
  
  protected String bSP = "sPlatform";
  
  protected String bSQ = "nUpdateFlag";
  
  protected String bSR = "sIsActive";
  
  protected String bSS = "1";
  
  protected String bST = "Y";
  
  protected String bSU = "N";
  
  protected String bSV;
  
  protected boolean bSW = true;
  
  private boolean bSX = true;
  
  private int bSY;
  
  private boolean bSZ = false;
  
  protected final String bSx = "LAIQIAN_TABLE_NAME";
  
  protected String bSy = null;
  
  protected final String bSz = "LAIQIAN_READING_FIELD_NAMES";
  
  StringBuilder bTa;
  
  StringBuilder bTb;
  
  int bTc = 2;
  
  private long bTd = -1L;
  
  static  {
  
  }
  
  public ao(Context paramContext) {
    super(paramContext);
    try {
      init();
      this.bRX.put("LAIQIAN_TABLE_NAME", this.bSy);
    } catch (JSONException paramContext) {
      a.e(paramContext);
    } 
    VA();
  }
  
  private void VA() {
    av av = new av(this.mContext);
    this.aGA = av.Tx();
    this.aDZ = av.atm();
    this.bLz = av.Ea();
    this.bSV = av.att();
    av.close();
  }
  
  private void VG() {
    try {
      if (getStartTime() != 0L && Ey() != 0L) {
        aNE = r(getStartTime(), Ey());
        return;
      } 
      if (Ey() == 0L && getStartTime() != 0L) {
        aNE = r(getStartTime(), getStartTime());
        return;
      } 
      if (getStartTime() == 0L && Ey() != 0L) {
        aNE = r(Ey(), Ey());
        return;
      } 
    } catch (Exception exception) {
      a.e(exception);
    } 
  }
  
  public static void a(@NonNull Cursor paramCursor, @NonNull a parama) {
    Iterator iterator = parama.VX().iterator();
    while (iterator.hasNext())
      a(paramCursor, (c)iterator.next()); 
  }
  
  @TargetApi(9)
  private static void a(@NonNull Cursor paramCursor, @NonNull c paramc) {
    Class clazz = paramc.getType();
    if (Double.class.equals(clazz)) {
      paramc.setValue(Double.valueOf(paramCursor.getDouble(paramCursor.getColumnIndex(paramc.VY().getName()))));
      return;
    } 
    if (Long.class.equals(clazz)) {
      paramc.setValue(Long.valueOf(paramCursor.getLong(paramCursor.getColumnIndex(paramc.VY().getName()))));
      return;
    } 
    if (Integer.class.equals(clazz)) {
      paramc.setValue(Integer.valueOf(paramCursor.getInt(paramCursor.getColumnIndex(paramc.VY().getName()))));
      return;
    } 
    paramc.setValue(paramCursor.getString(paramCursor.getColumnIndex(paramc.VY().getName())));
  }
  
  public boolean M(ArrayList<? extends a> paramArrayList) throws Exception {
    boolean bool2 = Vq().inTransaction();
    bool1 = true;
    if (!bool2) {
      Vq().beginTransaction();
      try {
        Iterator iterator1 = paramArrayList.iterator();
        while (iterator1.hasNext()) {
          if (!b((a)iterator1.next()))
            throw new RuntimeException(); 
        } 
      } catch (Exception paramArrayList) {
      
      } finally {
        Vq().endTransaction();
      } 
      Vq().endTransaction();
      return bool1;
    } 
    Iterator iterator = paramArrayList.iterator();
    while (iterator.hasNext()) {
      if (!b((a)iterator.next()))
        throw new RuntimeException(); 
    } 
    return true;
  }
  
  protected boolean QL() {
    JSONObject jSONObject = null;
    exception1 = null;
    Exception exception2 = jSONObject;
    try {
      String str1;
      long l1 = System.currentTimeMillis();
      exception2 = jSONObject;
      bb.dE(System.currentTimeMillis());
      exception2 = jSONObject;
      VF();
      exception2 = jSONObject;
      bb.j("laiqiankuai_time_consume", "setCreatingDefaultValues spent ");
      exception2 = jSONObject;
      String str2 = Vz();
      exception2 = jSONObject;
      if (str2.equals("")) {
        exception2 = jSONObject;
        exception1 = new Exception("no sSqlModelTableName");
      } 
      exception2 = exception1;
      jSONObject = (JSONObject)this.bRX.get("LAIQIAN_NEW_VALUES");
      exception2 = exception1;
      null = new ArrayList();
      exception2 = exception1;
      if (this.bTa == null) {
        exception2 = exception1;
        this.bTa = new StringBuilder();
      } 
      exception2 = exception1;
      this.bTa.setLength(0);
      exception2 = exception1;
      if (this.bTb == null) {
        exception2 = exception1;
        this.bTb = new StringBuilder();
      } 
      exception2 = exception1;
      this.bTb.setLength(0);
      exception2 = exception1;
      Iterator iterator = jSONObject.keys();
      exception2 = exception1;
      String str3 = this.bRX.get("LAIQIAN_FIELD_NAMES").toString();
      exception2 = exception1;
      StringBuilder stringBuilder3 = new StringBuilder();
      while (true) {
        exception2 = exception1;
        if (iterator.hasNext()) {
          exception2 = exception1;
          String str = (String)iterator.next();
          exception2 = exception1;
          if (!str3.contains(str))
            continue; 
          exception2 = exception1;
          StringBuilder stringBuilder = this.bTa;
          exception2 = exception1;
          stringBuilder.append(str);
          exception2 = exception1;
          stringBuilder.append(",");
          exception2 = exception1;
          this.bTb.append("?,");
          exception2 = exception1;
          null.add(jSONObject.getString(str));
          exception2 = exception1;
          stringBuilder3.append(",");
          exception2 = exception1;
          stringBuilder3.append(jSONObject.getString(str));
          continue;
        } 
        break;
      } 
      exception2 = exception1;
      String[] arrayOfString = (String[])null.toArray(new String[null.size()]);
      exception2 = exception1;
      this.bTa.deleteCharAt(this.bTa.length() - 1);
      exception2 = exception1;
      this.bTb.deleteCharAt(this.bTb.length() - 1);
      exception2 = exception1;
      if (str2.toUpperCase().contains("DOC")) {
        exception2 = exception1;
        StringBuilder stringBuilder = new StringBuilder();
        exception2 = exception1;
        stringBuilder.append("insert into ");
        exception2 = exception1;
        if (getStartTime() == 0L) {
          exception2 = exception1;
          str1 = b.Dm();
        } else {
          String str;
          exception2 = exception1;
          str1 = b.aU(b.S(getStartTime()), b.U(getStartTime()));
        } 
        exception2 = exception1;
        stringBuilder.append(str1);
        exception2 = exception1;
        stringBuilder.append(".");
        exception2 = exception1;
        stringBuilder.append(str2);
        exception2 = exception1;
        stringBuilder.append(" (");
        exception2 = exception1;
        stringBuilder.append(this.bTa.toString());
        exception2 = exception1;
        stringBuilder.append(") values (");
        exception2 = exception1;
        stringBuilder.append(this.bTb.toString());
        exception2 = exception1;
        stringBuilder.append(")");
        exception2 = exception1;
        str1 = stringBuilder.toString();
      } else {
        exception2 = exception1;
        null = new StringBuilder();
        exception2 = exception1;
        null.append("insert into ");
        exception2 = exception1;
        null.append(str2);
        exception2 = exception1;
        null.append(" (");
        exception2 = exception1;
        null.append(this.bTa.toString());
        exception2 = exception1;
        null.append(") values (");
        exception2 = exception1;
        null.append(this.bTb.toString());
        exception2 = exception1;
        null.append(")");
        exception2 = exception1;
        str1 = null.toString();
      } 
      exception2 = exception1;
      int i = arrayOfString.length;
      str2 = " ";
      for (byte b = 0; b < i; b++) {
        String str = arrayOfString[b];
        exception2 = exception1;
        StringBuilder stringBuilder = new StringBuilder();
        exception2 = exception1;
        stringBuilder.append(str2);
        exception2 = exception1;
        stringBuilder.append(str);
        exception2 = exception1;
        stringBuilder.append(",");
        exception2 = exception1;
        str2 = stringBuilder.toString();
      } 
      exception2 = exception1;
      StringBuilder stringBuilder2 = new StringBuilder();
      exception2 = exception1;
      stringBuilder2.append("LQK插入sql--》");
      exception2 = exception1;
      stringBuilder2.append(str1);
      exception2 = exception1;
      stringBuilder2.append("bindargs");
      exception2 = exception1;
      stringBuilder2.append(str2.substring(0, str2.lastIndexOf(",")));
      exception2 = exception1;
      b.ct(stringBuilder2.toString());
      exception2 = exception1;
      VG();
      exception2 = exception1;
      aNE.execSQL(str1, arrayOfString);
      exception2 = exception1;
      long l2 = System.currentTimeMillis();
      exception2 = exception1;
      StringBuilder stringBuilder1 = new StringBuilder();
      exception2 = exception1;
      stringBuilder1.append("creatExec  ");
      exception2 = exception1;
      stringBuilder1.append(l2 - l1);
      exception2 = exception1;
      bb.ao(stringBuilder1.toString());
      return true;
    } catch (JSONException exception1) {
      a.e(exception1);
    } catch (Exception exception1) {
      a.e(exception1);
      if (exception2 != null) {
        a.e(exception2);
        return false;
      } 
    } 
    return false;
  }
  
  protected boolean VB() { return this.bSZ; }
  
  public String VC() { return this.aGA; }
  
  public String VD() { return this.bLz; }
  
  public String VE() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(VC());
    stringBuilder.append("50001");
    return stringBuilder.toString();
  }
  
  protected void VF() {
    if (hQ(Vm()) == null)
      Vo(); 
    if (this.bSX)
      am("sIsActive", this.bST); 
    if (TextUtils.isEmpty(hQ("nUserID")))
      am("nUserID", this.aDZ); 
    am("nShopID", this.aGA);
    am(this.bSN, this.bKl);
    String str = this.bSO;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Vp());
    stringBuilder.append("");
    am(str, stringBuilder.toString());
    am(this.bSP, this.bKn);
  }
  
  protected String VH() {
    String str2 = null;
    str1 = str2;
    try {
      if (this.bRX.has("LAIQIAN_READING_FIELD_NAMES"))
        str1 = this.bRX.getString("LAIQIAN_READING_FIELD_NAMES"); 
    } catch (JSONException str1) {
      a.e(str1);
      str1 = str2;
    } 
    str2 = str1;
    if (str1 == null)
      str2 = "*"; 
    return str2;
  }
  
  protected String VI() {
    try {
      return (String)this.bRX.get("LAIQIAN_READING_FILTER_CLAUSE");
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return null;
    } 
  }
  
  public String[] VJ() { return (this.bRX != null) ? (String[])this.bRX.opt("LAIQIAN_READING_FILTER_PARAMETERIZED_ARRAY") : null; }
  
  public String VK() {
    try {
      if (this.bRX.has("LAIQIAN_READING_ORDER_BY"))
        return (String)this.bRX.get("LAIQIAN_READING_ORDER_BY"); 
    } catch (JSONException jSONException) {
      a.e(jSONException);
    } 
    return null;
  }
  
  public String VL() {
    try {
      if (this.bRX.has("LAIQIAN_READING_LIMIT"))
        return (String)this.bRX.get("LAIQIAN_READING_LIMIT"); 
    } catch (JSONException jSONException) {
      a.e(jSONException);
    } 
    return null;
  }
  
  public Cursor VM() {
    try {
      String str2 = VN();
      String[] arrayOfString = VJ();
      null = new StringBuilder();
      null.append("The read SQL is: ");
      null.append(str2);
      bb.f("_Model", null.toString());
      null = new StringBuilder();
      null.append("The arrFilterFieldValues is: ");
      null.append(arrayOfString);
      bb.f("_Model", null.toString());
      int i = arrayOfString.length;
      byte b2 = 0;
      String str1 = "";
      byte b1;
      for (b1 = 0; b1 < i; b1++) {
        String str = arrayOfString[b1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1);
        stringBuilder.append(str);
        stringBuilder.append(",");
        str1 = stringBuilder.toString();
      } 
      if (getStartTime() != 0L && Ey() != 0L) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SqlModel read()");
        stringBuilder.append(str2);
        b.ct(stringBuilder.toString());
        aNE = r(getStartTime(), Ey());
        String[] arrayOfString1 = (String[])b.c(arrayOfString, b.f(getStartTime(), Ey()).size());
        return aNE.rawQuery(str2, arrayOfString1);
      } 
      if (arrayOfString != null && arrayOfString.length > 0) {
        StringBuffer stringBuffer = new StringBuffer();
        i = arrayOfString.length;
        for (b1 = b2; b1 < i; b1++) {
          String str = arrayOfString[b1];
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(" ");
          stringBuilder1.append(str);
          stringBuffer.append(stringBuilder1.toString());
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The arrFilterFieldValues is: ");
        stringBuilder.append(stringBuffer.toString());
        bb.f("_Model", stringBuilder.toString());
      } 
      return aNE.rawQuery(str2, arrayOfString);
    } catch (Exception exception) {
      a.e(exception);
      return null;
    } 
  }
  
  public String VN() {
    String str4 = Vz();
    if (str4.equals("")) {
      a.e(new Exception("no sSqlModelTableName"));
      return null;
    } 
    String str5 = VH();
    if (str5 == null || str5.equals(null) || str5.length() == 0) {
      a.e(new Exception("no Column Names"));
      return null;
    } 
    StringBuilder stringBuilder1 = VI();
    String str1 = stringBuilder1;
    if (stringBuilder1 == null)
      str1 = ""; 
    stringBuilder1 = str1;
    if (!str1.equals("")) {
      String str;
      null = new StringBuilder();
      null.append(" where ");
      null.append(str1);
      stringBuilder1 = null.toString();
    } 
    String str2 = VK();
    str1 = str2;
    if (str2 == null)
      str1 = ""; 
    str2 = str1;
    if (!str1.equals("")) {
      null = new StringBuilder();
      null.append(" order by ");
      null.append(str1);
      str2 = null.toString();
    } 
    String str3 = VL();
    str1 = str3;
    if (str3 == null)
      str1 = ""; 
    str3 = str1;
    if (!str1.equals("")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" limit ");
      stringBuilder.append(str1);
      String str = stringBuilder.toString();
    } 
    if ("T_BPARTNER_CHARGEDOC".equals(Vz()) && getStartTime() != 0L && Ey() != 0L) {
      ConcurrentHashMap concurrentHashMap = b.f(getStartTime(), Ey());
      if (concurrentHashMap == null)
        return ""; 
      String str = new StringBuilder();
      str.append(getClass().getSimpleName());
      str.append("--startTime=");
      str.append(getStartTime());
      str.append("--endTime=");
      str.append(Ey());
      b.ct(str.toString());
      Set set = concurrentHashMap.entrySet();
      if (Vx() == 1) {
        String str6 = "select _id,nOperationTime,fOldAmount,fNewAmount,fReceived,sBPartnerNumber,sBPartnerName,nChargeType,nSpareField2,nSpareField3,fReceived,fIncrementAmount, points,fChargeAmount,nDateTime from (";
      } else {
        String str6;
        str = "select _id,nWarehouseID,nBPartnerID,nOperationTime,fOldAmount,fNewAmount,fReceived,sBPartnerNumber,sBPartnerName,nChargeType,nSpareField2,nSpareField3,fReceived,fIncrementAmount,points,fChargeAmount,nUserID,sBPartnerMobile,nDateTime,sSpareField5,sText from(";
      } 
      byte b = 0;
      for (Map.Entry null : set) {
        byte b1 = b + true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" select ");
        stringBuilder.append(str5);
        stringBuilder.append(" from ");
        stringBuilder.append((String)null.getValue());
        stringBuilder.append(".");
        stringBuilder.append(str4);
        stringBuilder.append(" ");
        stringBuilder.append(stringBuilder1);
        str3 = stringBuilder.toString();
        str = str3;
        b = b1;
        if (b1 != concurrentHashMap.size()) {
          null = new StringBuilder();
          null.append(str3);
          null.append(" union all ");
          str = null.toString();
          b = b1;
        } 
      } 
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append(")as T ");
      stringBuilder1.append(str2);
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("select ");
    stringBuilder2.append(str5);
    stringBuilder2.append(" from ");
    str1 = str4;
    if (VB()) {
      null = new StringBuilder();
      null.append(b.Dm());
      null.append(".");
      null.append(str4);
      str1 = null.toString();
    } 
    stringBuilder2.append(str1);
    stringBuilder2.append(" ");
    stringBuilder2.append(stringBuilder1);
    stringBuilder2.append(" ");
    stringBuilder2.append(str2);
    stringBuilder2.append(" ");
    stringBuilder2.append(str3);
    return stringBuilder2.toString();
  }
  
  protected void VO() {
    try {
      JSONObject jSONObject = this.bRX.getJSONObject("LAIQIAN_NEW_VALUES");
      Iterator iterator = jSONObject.keys();
      String str = "";
      String[] arrayOfString = new String[jSONObject.length()];
      for (byte b = 0; iterator.hasNext(); b++) {
        String str1 = str;
        if (!str.equals("")) {
          null = new StringBuilder();
          null.append(str);
          null.append(",");
          str1 = null.toString();
        } 
        String str2 = ((String)iterator.next()).toString();
        null = new StringBuilder();
        null.append(str1);
        null.append(str2);
        null.append("=? ");
        str = null.toString();
        arrayOfString[b] = jSONObject.getString(str2);
      } 
      this.bRX.put("LAIQIAN_UPDATING_FIELD_NAMES", str);
      this.bRX.put("LAIQIAN_UPDATING_VALUES_IN_PARAMETERIZED_ARRAY", arrayOfString);
      return;
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return;
    } 
  }
  
  protected void VP() {
    am(this.bSN, this.bKm);
    am(this.bSP, this.bKn);
  }
  
  protected String VQ() {
    String str;
    try {
      str = (String)this.bRX.get("LAIQIAN_UPDATING_FIELD_NAMES");
      try {
        jSONException = new StringBuilder();
        jSONException.append("getUpdatingFieldsWithQuestionMark sReturn=");
        jSONException.append(str);
        d.b(jSONException.toString(), new Object[0]);
        return str;
      } catch (JSONException null) {}
    } catch (JSONException jSONException) {
      str = null;
    } 
    a.e(jSONException);
    return str;
  }
  
  protected String[] VR() {
    try {
      return (String[])this.bRX.get("LAIQIAN_UPDATING_VALUES_IN_PARAMETERIZED_ARRAY");
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return null;
    } 
  }
  
  protected void VS() { gj(10000); }
  
  protected String VT() {
    try {
      return (String)this.bRX.get("LAIQIAN_UPDATING_FILTER_CLAUSE");
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return null;
    } 
  }
  
  protected String[] VU() {
    try {
      return (String[])this.bRX.get("LAIQIAN_UPDATING_FILTER_PARAMETERIZED_ARRAY");
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return null;
    } 
  }
  
  protected Object VV() {
    try {
      return this.bRX.get("LAIQIAN_DELETING_FILTER");
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return null;
    } 
  }
  
  protected String VW() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" nUpdateFlag= case when nUpdateFlag is null then ");
    stringBuilder.append(this.bTc);
    stringBuilder.append(" else nUpdateFlag+");
    stringBuilder.append(this.bTc);
    stringBuilder.append(" end,nIsUpdated=0 ");
    String str = stringBuilder.toString();
    this.bTc = 2;
    return str;
  }
  
  protected long Vp() { return (this.bTd > 0L) ? this.bTd : super.Vp(); }
  
  public int Vx() { return this.bSY; }
  
  public boolean Vy() {
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT * FROM sqlite_master WHERE type='table' AND name='");
    stringBuilder.append(this.bSy.toUpperCase());
    stringBuilder.append("'");
    String str = stringBuilder.toString();
    Cursor cursor = aNE.rawQuery(str, null);
    if (cursor.getCount() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    cursor.close();
    return bool;
  }
  
  public String Vz() { return this.bSy; }
  
  public boolean a(a parama) {
    for (c c : parama.VX()) {
      if (c.hasValue())
        am(c.VY().getName(), c.getValue().toString()); 
    } 
    return update();
  }
  
  protected String[] a(String[] paramArrayOfString1, String[] paramArrayOfString2) {
    if (paramArrayOfString1 != null) {
      int i = paramArrayOfString1.length;
      boolean bool = false;
      if (paramArrayOfString2 != null) {
        int j;
        String[] arrayOfString = new String[i + 0 + paramArrayOfString2.length];
        i = 0;
        while (true) {
          j = bool;
          if (i < paramArrayOfString1.length) {
            arrayOfString[i] = paramArrayOfString1[i];
            i++;
            continue;
          } 
          break;
        } 
        while (j < paramArrayOfString2.length) {
          arrayOfString[paramArrayOfString1.length + j] = paramArrayOfString2[j];
          j++;
        } 
        return arrayOfString;
      } 
      return paramArrayOfString1;
    } 
    return paramArrayOfString2;
  }
  
  public boolean b(a parama) {
    for (c c : parama.VX()) {
      if (c.hasValue())
        am(c.VY().getName(), c.getValue().toString()); 
    } 
    return QL();
  }
  
  public void bD(long paramLong) { this.bTd = paramLong; }
  
  public void beginTransaction() {
    if (!aNE.inTransaction()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getClass().getSimpleName());
      stringBuilder.append("开启事务");
      b.ct(stringBuilder.toString());
      aNE.beginTransaction();
    } 
  }
  
  protected boolean c(String paramString, String[] paramArrayOfString) {
    try {
      JSONObject jSONObject = this.bRX;
      String str = paramString;
      if (TextUtils.isEmpty(paramString))
        str = ""; 
      jSONObject.put("LAIQIAN_READING_FILTER_CLAUSE", str);
      this.bRX.put("LAIQIAN_READING_FILTER_PARAMETERIZED_ARRAY", paramArrayOfString);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setReadingFilter=");
      stringBuilder.append(paramArrayOfString);
      Log.d("setReadingFilter", stringBuilder.toString());
      return true;
    } catch (JSONException paramString) {
      a.e(paramString);
      return false;
    } 
  }
  
  public void close() {
    if (this.bRX != null) {
      this.bRX.remove("LAIQIAN_READING_FIELD_NAMES");
      this.bRX.remove("LAIQIAN_READING_FILTER_CLAUSE");
      this.bRX.remove("LAIQIAN_READING_FILTER_PARAMETERIZED_ARRAY");
      this.bRX.remove("LAIQIAN_READING_ORDER_BY");
      this.bRX.remove("LAIQIAN_READING_LIMIT");
      this.bRX.remove("LAIQIAN_UPDATING_FIELD_NAMES");
      this.bRX.remove("LAIQIAN_UPDATING_VALUES_IN_PARAMETERIZED_ARRAY");
      this.bRX.remove("LAIQIAN_UPDATING_FILTER_CLAUSE");
      this.bRX.remove("LAIQIAN_UPDATING_FILTER_PARAMETERIZED_ARRAY");
      super.close();
    } 
  }
  
  protected boolean d(String paramString, String[] paramArrayOfString) {
    try {
      this.bRX.put("LAIQIAN_UPDATING_FILTER_CLAUSE", paramString);
      this.bRX.put("LAIQIAN_UPDATING_FILTER_PARAMETERIZED_ARRAY", paramArrayOfString);
      return true;
    } catch (JSONException paramString) {
      a.e(paramString);
      return false;
    } 
  }
  
  @Deprecated
  protected boolean delete() {
    Throwable throwable;
    Object object = null;
    try {
      String str = Vz();
      if (str.equals("")) {
        throwable = new Exception("no sSqlModelTableName");
      } else {
        throwable = null;
      } 
      try {
        exception = VV();
        if (exception instanceof JSONObject) {
          JSONObject jSONObject = (JSONObject)exception;
          JSONArray jSONArray = jSONObject.names();
          String[] arrayOfString = new String[jSONArray.length()];
          exception = null;
          for (byte b = 0; b < jSONArray.length(); b++) {
            object = exception;
            if (b) {
              object = new StringBuilder();
              object.append(exception);
              object.append(" and ");
              object = object.toString();
            } 
            exception = new StringBuilder();
            exception.append(object);
            exception.append(jSONArray.getString(b));
            exception.append("=?");
            exception = exception.toString();
            arrayOfString[b] = jSONObject.getString(jSONArray.getString(b));
          } 
        } else {
          exception = (String)exception;
          Object object1 = exception;
        } 
      } catch (Exception null) {}
    } catch (Exception exception) {
      throwable = null;
    } 
    a.e(exception);
    if (throwable != null)
      a.e(throwable); 
    return false;
  }
  
  protected void el(boolean paramBoolean) { this.bSZ = paramBoolean; }
  
  public void endTransaction() {
    if (aNE != null && aNE.inTransaction())
      try {
        aNE.endTransaction();
        return;
      } catch (Throwable throwable) {
        a.e(throwable);
      }  
  }
  
  public String getUserID() { return this.aDZ; }
  
  public void gi(int paramInt) { this.bSY = paramInt; }
  
  protected void gj(int paramInt) { this.bTc = paramInt; }
  
  public void hV(String paramString) { this.bSK = paramString; }
  
  public void hW(String paramString) { this.bSL = paramString; }
  
  public void hX(String paramString) { this.bSy = paramString; }
  
  protected boolean hY(String paramString) {
    try {
      this.bRX.put("LAIQIAN_READING_FIELD_NAMES", paramString);
      return true;
    } catch (JSONException paramString) {
      a.e(paramString);
      return false;
    } 
  }
  
  protected boolean hZ(String paramString) {
    try {
      this.bRX.put("LAIQIAN_READING_FILTER_CLAUSE", paramString);
      this.bRX.put("LAIQIAN_READING_FILTER_PARAMETERIZED_ARRAY", new String[0]);
      return true;
    } catch (JSONException paramString) {
      a.e(paramString);
      return false;
    } 
  }
  
  public boolean ia(String paramString) {
    try {
      this.bRX.put("LAIQIAN_READING_ORDER_BY", paramString);
      return true;
    } catch (JSONException paramString) {
      a.e(paramString);
      return false;
    } 
  }
  
  public boolean ib(String paramString) {
    try {
      this.bRX.put("LAIQIAN_READING_LIMIT", paramString);
      return true;
    } catch (JSONException paramString) {
      a.e(paramString);
      return false;
    } 
  }
  
  @SuppressLint({"NewApi"})
  public ArrayList<HashMap<String, Object>> ic(String paramString) { // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #5
    //   9: new java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore_3
    //   17: aload_3
    //   18: ldc_w 'getsql'
    //   21: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_3
    //   26: aload_1
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: ldc_w '_db'
    //   34: aload_3
    //   35: invokevirtual toString : ()Ljava/lang/String;
    //   38: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   41: getstatic com/laiqian/models/ao.aNE : Landroid/database/sqlite/SQLiteDatabase;
    //   44: ifnull -> 210
    //   47: getstatic com/laiqian/models/ao.aNE : Landroid/database/sqlite/SQLiteDatabase;
    //   50: aload_1
    //   51: aconst_null
    //   52: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore_3
    //   56: aload_3
    //   57: astore #4
    //   59: aload_3
    //   60: astore_1
    //   61: aload_3
    //   62: invokeinterface moveToNext : ()Z
    //   67: ifeq -> 213
    //   70: aload_3
    //   71: astore_1
    //   72: new java/util/HashMap
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: astore #6
    //   81: iconst_0
    //   82: istore_2
    //   83: aload_3
    //   84: astore_1
    //   85: iload_2
    //   86: aload_3
    //   87: invokeinterface getColumnCount : ()I
    //   92: if_icmpge -> 192
    //   95: aload_3
    //   96: astore_1
    //   97: aload_3
    //   98: iload_2
    //   99: invokeinterface getType : (I)I
    //   104: iconst_2
    //   105: if_icmpne -> 157
    //   108: aload_3
    //   109: astore_1
    //   110: new java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial <init> : ()V
    //   117: astore #4
    //   119: aload_3
    //   120: astore_1
    //   121: aload #4
    //   123: aload_3
    //   124: iload_2
    //   125: invokeinterface getDouble : (I)D
    //   130: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_3
    //   135: astore_1
    //   136: aload #4
    //   138: ldc_w ''
    //   141: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_3
    //   146: astore_1
    //   147: aload #4
    //   149: invokevirtual toString : ()Ljava/lang/String;
    //   152: astore #4
    //   154: goto -> 168
    //   157: aload_3
    //   158: astore_1
    //   159: aload_3
    //   160: iload_2
    //   161: invokeinterface getString : (I)Ljava/lang/String;
    //   166: astore #4
    //   168: aload_3
    //   169: astore_1
    //   170: aload #6
    //   172: aload_3
    //   173: iload_2
    //   174: invokeinterface getColumnName : (I)Ljava/lang/String;
    //   179: aload #4
    //   181: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   184: pop
    //   185: iload_2
    //   186: iconst_1
    //   187: iadd
    //   188: istore_2
    //   189: goto -> 83
    //   192: aload_3
    //   193: astore_1
    //   194: aload #5
    //   196: aload #6
    //   198: invokevirtual add : (Ljava/lang/Object;)Z
    //   201: pop
    //   202: goto -> 56
    //   205: astore #4
    //   207: goto -> 246
    //   210: aconst_null
    //   211: astore #4
    //   213: aload #4
    //   215: ifnull -> 263
    //   218: aload #4
    //   220: invokeinterface close : ()V
    //   225: aload #5
    //   227: areturn
    //   228: astore_1
    //   229: aload_1
    //   230: invokestatic e : (Ljava/lang/Throwable;)V
    //   233: aload #5
    //   235: areturn
    //   236: astore_1
    //   237: aconst_null
    //   238: astore_3
    //   239: goto -> 273
    //   242: astore #4
    //   244: aconst_null
    //   245: astore_3
    //   246: aload_3
    //   247: astore_1
    //   248: aload #4
    //   250: invokestatic e : (Ljava/lang/Throwable;)V
    //   253: aload_3
    //   254: ifnull -> 263
    //   257: aload_3
    //   258: invokeinterface close : ()V
    //   263: aload #5
    //   265: areturn
    //   266: astore #4
    //   268: aload_1
    //   269: astore_3
    //   270: aload #4
    //   272: astore_1
    //   273: aload_3
    //   274: ifnull -> 291
    //   277: aload_3
    //   278: invokeinterface close : ()V
    //   283: goto -> 291
    //   286: astore_3
    //   287: aload_3
    //   288: invokestatic e : (Ljava/lang/Throwable;)V
    //   291: aload_1
    //   292: athrow
    // Exception table:
    //   from	to	target	type
    //   41	56	242	java/lang/Exception
    //   41	56	236	finally
    //   61	70	205	java/lang/Exception
    //   61	70	266	finally
    //   72	81	205	java/lang/Exception
    //   72	81	266	finally
    //   85	95	205	java/lang/Exception
    //   85	95	266	finally
    //   97	108	205	java/lang/Exception
    //   97	108	266	finally
    //   110	119	205	java/lang/Exception
    //   110	119	266	finally
    //   121	134	205	java/lang/Exception
    //   121	134	266	finally
    //   136	145	205	java/lang/Exception
    //   136	145	266	finally
    //   147	154	205	java/lang/Exception
    //   147	154	266	finally
    //   159	168	205	java/lang/Exception
    //   159	168	266	finally
    //   170	185	205	java/lang/Exception
    //   170	185	266	finally
    //   194	202	205	java/lang/Exception
    //   194	202	266	finally
    //   218	225	228	java/lang/Exception
    //   248	253	266	finally
    //   257	263	228	java/lang/Exception
    //   277	283	286	java/lang/Exception }
  
  protected abstract void init();
  
  public void setTransactionSuccessful() {
    if (aNE.inTransaction())
      aNE.setTransactionSuccessful(); 
  }
  
  protected boolean update() {
    String str3 = Vz();
    VP();
    VO();
    String str4 = VQ();
    String[] arrayOfString1 = VR();
    String str2 = VT();
    String[] arrayOfString2 = VU();
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    str2 = str1;
    if (!str1.equals("")) {
      null = new StringBuilder();
      null.append(" where ");
      null.append(str1);
      str2 = null.toString();
    } 
    if (LQKVersion.zg()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("update arrUpdatingValues=");
      stringBuilder1.append(Arrays.toString(arrayOfString1));
      stringBuilder1.append(" arrFilter=");
      stringBuilder1.append(Arrays.toString(arrayOfString2));
      d.b(stringBuilder1.toString(), new Object[0]);
    } 
    arrayOfString1 = a(arrayOfString1, arrayOfString2);
    if (str3.toUpperCase().contains("DOC")) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("update  ");
      if (getStartTime() == 0L) {
        str1 = b.Dm();
      } else {
        str1 = b.aU(b.S(getStartTime()), b.U(getStartTime()));
      } 
      stringBuilder1.append(str1);
      stringBuilder1.append(".");
      stringBuilder1.append(str3);
      stringBuilder1.append(" set  nUpdateFlag= case when nUpdateFlag is null then ");
      stringBuilder1.append(this.bTc);
      stringBuilder1.append(" else nUpdateFlag+");
      stringBuilder1.append(this.bTc);
      stringBuilder1.append(" end, ");
      stringBuilder1.append(str4);
      stringBuilder1.append(str2);
      str1 = stringBuilder1.toString();
    } else {
      null = new StringBuilder();
      null.append("update  ");
      null.append(str3);
      null.append(" set  nUpdateFlag= case when nUpdateFlag is null then ");
      null.append(this.bTc);
      null.append(" else nUpdateFlag+");
      null.append(this.bTc);
      null.append(" end, ");
      null.append(str4);
      null.append(str2);
      str1 = null.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("The update SQL is: ");
    stringBuilder.append(str1);
    bb.e("_Model", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("The bindArgs is: ");
    stringBuilder.append(Arrays.toString(arrayOfString1));
    bb.e("_Model", stringBuilder.toString());
    this.bTc = 2;
    stringBuilder = new StringBuilder();
    stringBuilder.append("-----isReadOnly----");
    stringBuilder.append(aNE.isReadOnly());
    b.ct(stringBuilder.toString());
    aNE.execSQL(str1, arrayOfString1);
    return true;
  }
  
  public ArrayList<HashMap<String, Object>> x(String paramString1, String paramString2, String paramString3) {
    String str = paramString3;
    if (paramString3.trim().length() > 0) {
      null = new StringBuilder();
      null.append(" where ");
      null.append(paramString3);
      str = null.toString();
    } 
    paramString3 = paramString2;
    if (paramString2.trim().length() == 0)
      paramString3 = "*"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SELECT ");
    stringBuilder.append(paramString3);
    stringBuilder.append(" FROM ");
    stringBuilder.append(paramString1);
    stringBuilder.append(str);
    return ic(stringBuilder.toString());
  }
  
  public HashMap<String, Object> y(String paramString1, String paramString2, String paramString3) {
    HashMap hashMap = new HashMap();
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString3);
      stringBuilder.append(" limit 0,1");
      return (HashMap)x(paramString1, paramString2, stringBuilder.toString()).get(0);
    } catch (Exception paramString1) {
      a.e(paramString1);
      return hashMap;
    } 
  }
  
  class ao {}
  
  class ao {}
  
  class ao {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\models\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */