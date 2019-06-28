package com.laiqian.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import com.google.a.a.a.a.a.a;
import com.laiqian.db.a;
import com.laiqian.db.multidatabase.a.b;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.infrastructure.R;
import com.laiqian.milestone.h;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ai implements Closeable {
  protected static SQLiteDatabase aNE;
  
  protected int aOE;
  
  protected int aOF;
  
  protected a bJS;
  
  private String bKj = "";
  
  protected JSONObject bRX = new JSONObject();
  
  protected final String bRY = "LAIQIAN_ORIGINAL_VALUES";
  
  protected final String bRZ = "LAIQIAN_NEW_VALUES";
  
  protected final String bSa = "LAIQIAN_FIELD_NAMES";
  
  protected final String bSb = "_id";
  
  private long bSc;
  
  protected String bSd = "";
  
  protected int endYear;
  
  protected Context mContext = null;
  
  private long mStartTime;
  
  protected int startYear;
  
  static  {
  
  }
  
  public ai() throws Exception { this(null); }
  
  public ai(Context paramContext) {
    this.mContext = paramContext;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("/data/data/");
    stringBuilder1.append(paramContext.getPackageName());
    stringBuilder1.append("/");
    String str2 = stringBuilder1.toString();
    String str1 = "laiqian.db";
    if (!this.bKj.equals(""))
      str1 = this.bKj; 
    this.bKj = str1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str2);
    stringBuilder2.append(str1);
    cq(stringBuilder2.toString());
    this.bJS = a.Y(paramContext);
    try {
      aNE = Vq();
    } catch (Exception paramContext) {
      a.e(paramContext);
    } 
    try {
      JSONObject jSONObject = new JSONObject();
      this.bRX.put("LAIQIAN_ORIGINAL_VALUES", jSONObject);
      jSONObject = new JSONObject();
      this.bRX.put("LAIQIAN_NEW_VALUES", jSONObject);
      this.bRX.put("LAIQIAN_FIELD_NAMES", "");
      return;
    } catch (JSONException paramContext) {
      h.a(new d(ai.class.getName(), "RootModel", "0", "复制失败"), h.a.dHx, h.b.dHB);
      a.e(paramContext);
      return;
    } 
  }
  
  protected long Ey() { return this.bSc; }
  
  protected abstract boolean QL();
  
  protected abstract boolean UA();
  
  protected abstract boolean UB();
  
  protected abstract boolean UC();
  
  protected abstract boolean UD();
  
  protected abstract boolean UE();
  
  public String Vm() { return "_id"; }
  
  public String Vn() { return this.bSd; }
  
  protected long Vo() {
    long l = System.currentTimeMillis();
    String str = Vm();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(l);
    stringBuilder.append("");
    return am(str, stringBuilder.toString()) ? l : -1L;
  }
  
  protected long Vp() { return System.currentTimeMillis(); }
  
  public SQLiteDatabase Vq() {
    try {
      aNE = m(Calendar.getInstance().get(2) + 1, Calendar.getInstance().get(1), Calendar.getInstance().get(2) + 1, Calendar.getInstance().get(1));
    } catch (Exception exception) {
      a.e(exception);
    } 
    return aNE;
  }
  
  protected void ab(long paramLong) { this.bSc = paramLong; }
  
  public boolean am(String paramString1, String paramString2) {
    try {
      ((JSONObject)this.bRX.get("LAIQIAN_NEW_VALUES")).put(paramString1, paramString2);
      return true;
    } catch (JSONException paramString1) {
      a.e(paramString1);
      return false;
    } 
  }
  
  public ConcurrentHashMap<String, String> c(ConcurrentHashMap<String, String> paramConcurrentHashMap) {
    List list = aNE.getAttachedDbs();
    if (list != null)
      for (Pair pair : list) {
        for (Map.Entry entry : paramConcurrentHashMap.entrySet()) {
          if (((String)pair.second).equals(entry.getKey()))
            paramConcurrentHashMap.remove(entry.getKey()); 
        } 
      }  
    return paramConcurrentHashMap;
  }
  
  public void close() throws Exception {
    if (this.bJS != null)
      this.bJS.close(); 
    SQLiteDatabase.releaseMemory();
    this.bRX.remove("LAIQIAN_ORIGINAL_VALUES");
    this.bRX.remove("LAIQIAN_NEW_VALUES");
    this.bRX.remove("LAIQIAN_FIELD_NAMES");
    this.bRX.remove("_id");
    this.bRX = null;
  }
  
  protected void cq(String paramString) {
    File file = new File(paramString);
    if (!file.exists())
      try {
        InputStream inputStream;
        file.createNewFile();
        if (h.bJR) {
          inputStream = this.mContext.getAssets().open("laiqian.db");
        } else {
          inputStream = this.mContext.getResources().openRawResource(R.raw.laiqian);
        } 
        FileOutputStream fileOutputStream = new FileOutputStream(paramString);
        byte[] arrayOfByte = new byte[8192];
        while (true) {
          int i = inputStream.read(arrayOfByte);
          if (i > 0) {
            fileOutputStream.write(arrayOfByte, 0, i);
            continue;
          } 
          break;
        } 
        fileOutputStream.close();
        inputStream.close();
        return;
      } catch (Exception paramString) {
        a.e(paramString);
      }  
  }
  
  protected abstract boolean delete();
  
  protected long getStartTime() { return this.mStartTime; }
  
  protected void hP(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bSd);
    stringBuilder.append(paramString);
    this.bSd = stringBuilder.toString();
  }
  
  public String hQ(String paramString) {
    try {
      JSONObject jSONObject = (JSONObject)this.bRX.get("LAIQIAN_NEW_VALUES");
      if (jSONObject.has(paramString))
        return jSONObject.getString(paramString); 
    } catch (JSONException paramString) {
      a.e(paramString);
    } 
    return null;
  }
  
  protected void l(String paramString, boolean paramBoolean) {
    if (paramBoolean) {
      hP(paramString);
      return;
    } 
    this.bSd = paramString;
  }
  
  public SQLiteDatabase m(int paramInt1, int paramInt2, int paramInt3, int paramInt4) throws Exception {
    aNE = b.aOw.Dk();
    this.aOE = paramInt1;
    this.startYear = paramInt2;
    this.aOF = paramInt3;
    this.endYear = paramInt4;
    ConcurrentHashMap concurrentHashMap = b.l(paramInt1, paramInt2, paramInt3, paramInt4);
    if (concurrentHashMap != null)
      for (Map.Entry entry : c(concurrentHashMap).entrySet()) {
        String str1 = (String)entry.getKey();
        String str2 = (String)entry.getValue();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("path=");
        stringBuilder1.append(str1);
        stringBuilder1.append("--alia=");
        stringBuilder1.append(str2);
        b.ct(stringBuilder1.toString());
        SQLiteDatabase sQLiteDatabase = aNE;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("ATTACH DATABASE '");
        stringBuilder2.append(str1);
        stringBuilder2.append("' AS '");
        stringBuilder2.append(str2);
        stringBuilder2.append("';");
        sQLiteDatabase.execSQL(stringBuilder2.toString());
      }  
    return aNE;
  }
  
  public SQLiteDatabase r(long paramLong1, long paramLong2) throws Exception { return m(b.S(paramLong1), b.U(paramLong1), b.S(paramLong2), b.U(paramLong2)); }
  
  protected void setStartTime(long paramLong) { this.mStartTime = paramLong; }
  
  protected abstract boolean update();
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\models\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */