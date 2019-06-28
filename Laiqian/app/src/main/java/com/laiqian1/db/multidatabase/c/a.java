package com.laiqian.db.multidatabase.c;

import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import com.laiqian.db.multidatabase.a.b;
import com.laiqian.db.multidatabase.d.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.db.multidatabase.d.c;
import com.laiqian.util.bg;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {
  private SQLiteDatabase aNE;
  
  private int aOE;
  
  private int aOF;
  
  private int endYear;
  
  private int startYear;
  
  public a() {
    this.aNE = b.aOw.Dk();
    aT(Calendar.getInstance().get(2) + 1, Calendar.getInstance().get(1));
    a.Dl().cr(b.Dn());
    SQLiteDatabase sQLiteDatabase = this.aNE;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ATTACH DATABASE '");
    stringBuilder.append(b.Dn());
    stringBuilder.append("' AS '");
    stringBuilder.append(b.Dm());
    stringBuilder.append("';");
    sQLiteDatabase.execSQL(stringBuilder.toString());
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) throws Exception {
    this.aNE = b.aOw.Dk();
    this.aOE = paramInt1;
    this.startYear = paramInt2;
    this.aOF = paramInt3;
    this.endYear = paramInt4;
    ConcurrentHashMap concurrentHashMap = b.l(paramInt1, paramInt2, paramInt3, paramInt4);
    b.Dq();
    if (concurrentHashMap != null) {
      a(concurrentHashMap);
      for (Map.Entry entry : concurrentHashMap.entrySet()) {
        String str1 = (String)entry.getKey();
        String str2 = (String)entry.getValue();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("ATTACH DATABASE path=");
        stringBuilder2.append(str1);
        stringBuilder2.append("--alia=");
        stringBuilder2.append(str2);
        b.ct(stringBuilder2.toString());
        SQLiteDatabase sQLiteDatabase = this.aNE;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("ATTACH DATABASE '");
        stringBuilder3.append(str1);
        stringBuilder3.append("' AS '");
        stringBuilder3.append(str2);
        stringBuilder3.append("';");
        sQLiteDatabase.execSQL(stringBuilder3.toString());
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("ATTACH DATABASE SUCCESS path=");
        stringBuilder1.append(str1);
        stringBuilder1.append("--alia=");
        stringBuilder1.append(str2);
        b.ct(stringBuilder1.toString());
      } 
    } 
  }
  
  public a(long paramLong1, long paramLong2) throws Exception { this(b.S(paramLong1), b.U(paramLong1), b.S(paramLong2), b.U(paramLong2)); }
  
  public a(boolean paramBoolean, String paramString) {
    b.Dq();
    if (paramBoolean) {
      this.aNE = SQLiteDatabase.openDatabase(a.Dl().cr(paramString), null, 16, new c());
      return;
    } 
    this.aNE = b.aOw.Dk();
    null = this.aNE.getAttachedDbs();
    boolean bool2 = false;
    Iterator iterator = null.iterator();
    while (true) {
      bool1 = bool2;
      if (iterator.hasNext()) {
        if (bg.equals(((Pair)iterator.next()).second, paramString)) {
          bool1 = true;
          break;
        } 
        continue;
      } 
      break;
    } 
    if (!bool1) {
      a.Dl().cr(paramString);
      SQLiteDatabase sQLiteDatabase = this.aNE;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ATTACH DATABASE '");
      stringBuilder.append(paramString);
      stringBuilder.append("' AS '");
      stringBuilder.append(b.cu(paramString));
      stringBuilder.append("';");
      sQLiteDatabase.execSQL(stringBuilder.toString());
    } 
  }
  
  public void a(ConcurrentHashMap<String, String> paramConcurrentHashMap) {
    for (Pair pair : this.aNE.getAttachedDbs()) {
      for (Map.Entry entry : paramConcurrentHashMap.entrySet()) {
        if (((String)pair.second).equals(entry.getKey()))
          paramConcurrentHashMap.remove(entry.getKey()); 
      } 
    } 
  }
  
  public void aT(int paramInt1, int paramInt2) {
    Iterator iterator = this.aNE.getAttachedDbs().iterator();
    while (iterator.hasNext()) {
      if (((String)((Pair)iterator.next()).second).equals(b.aV(paramInt1, paramInt2))) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("DETACH DATABASE ");
        stringBuilder1.append(b.aU(paramInt1, paramInt2));
        String str = stringBuilder1.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("detachSQL-->");
        stringBuilder2.append(str);
        b.ct(stringBuilder2.toString());
        this.aNE.execSQL(str);
      } 
    } 
  }
  
  public SQLiteDatabase getDatabase() { return this.aNE; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\db\multidatabase\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */