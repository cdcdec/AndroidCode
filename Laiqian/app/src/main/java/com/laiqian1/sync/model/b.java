package com.laiqian.sync.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import b.aa;
import b.aj;
import b.ak;
import b.x;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.f.b;
import com.laiqian.network.b;
import com.laiqian.network.j;
import com.laiqian.network.n;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.sync.b;
import com.laiqian.util.ab;
import com.laiqian.util.by;
import io.reactivex.m;
import io.reactivex.n;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import retrofit2.u;
import retrofit2.v;

public class b {
  public static List<String> doR = Arrays.asList(new String[] { "t_accountdoc", "t_bpartner", "t_productdoc", "t_product", "t_string", "t_bpartner_chargedoc" });
  
  public static Integer L(Map<String, Set<String>> paramMap) {
    Iterator iterator = paramMap.values().iterator();
    int i = 0;
    while (iterator.hasNext()) {
      Set set = (Set)iterator.next();
      if (set != null)
        i += set.size(); 
    } 
    return Integer.valueOf(i);
  }
  
  public static void M(Map<String, Set<String>> paramMap) {
    null = b.b(new File(a.aOz), new ArrayList());
    null.add(a.aOB);
    HashMap hashMap = new HashMap();
    for (String str : paramMap.keySet()) {
      Set set = (Set)paramMap.get(str);
      if (set != null && !set.isEmpty())
        hashMap.put(str, by.a(",", set)); 
    } 
    for (String str : null) {
      SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openDatabase(str, null, 0);
      try {
        sQLiteDatabase.beginTransaction();
        for (String str1 : ab.m(sQLiteDatabase)) {
          String str2 = str1.toLowerCase();
          if (!doR.contains(str2))
            continue; 
          String str3 = (String)hashMap.get(str2);
          if (str3 != null && !str3.isEmpty()) {
            b.b(sQLiteDatabase, 1, str2, str3, false);
            if (LQKVersion.zg()) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("updated ");
              stringBuilder.append(str);
              stringBuilder.append(".");
              stringBuilder.append(str1);
              stringBuilder.append(", row count: ");
              stringBuilder.append(ab.k(sQLiteDatabase));
              Log.d("SyncGuarantee2", stringBuilder.toString());
            } 
          } 
        } 
        sQLiteDatabase.setTransactionSuccessful();
      } catch (Exception str) {
        a.e(str);
      } finally {}
      sQLiteDatabase.endTransaction();
      sQLiteDatabase.close();
    } 
  }
  
  public static n<Map<String, Set<String>>> a(String paramString, m paramm) { return n.a(n.e(new d(paramString)).f(paramm), n.e(new e(paramString)).f(paramm), f.bfR); }
  
  public static Map<String, Set<String>> d(Map<String, Set<String>> paramMap1, Map<String, Set<String>> paramMap2) {
    HashMap hashMap = new HashMap();
    for (Map.Entry null : paramMap2.entrySet()) {
      String str = (String)null.getKey();
      Set set2 = (Set)null.getValue();
      Set set1 = (Set)paramMap1.get(str);
      set2 = new HashSet(set2);
      if (set1 != null)
        set2.removeAll(set1); 
      hashMap.put(str, Collections.unmodifiableSet(set2));
    } 
    return hashMap;
  }
  
  public static Map<String, Set<String>> or(String paramString) throws Exception {
    aa aa = j.adg.aSL().a(new c(paramString)).aSM();
    v v = n.bUo.aZg().a(aa).aZh();
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("shop_id", paramString);
    null = (b)v.af(b.class);
    String str = b.cL(jSONObject.toString());
    u u = null.ar(RootUrlParameter.ckH, str).aYS();
    if (u.aTa())
      return ot(((ak)u.aZd()).aTk()); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("request failed: ");
    stringBuilder.append(u.toString());
    throw new Exception(stringBuilder.toString());
  }
  
  public static Map<String, Set<String>> os(String paramString) throws Exception {
    HashMap hashMap = new HashMap();
    list = b.b(new File(a.aOz), new ArrayList());
    list.add(a.aOB);
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      SQLiteDatabase sQLiteDatabase = SQLiteDatabase.openDatabase((String)iterator.next(), null, 0);
      try {
        sQLiteDatabase.beginTransaction();
        Iterator iterator1 = ab.m(sQLiteDatabase).iterator();
        while (iterator1.hasNext()) {
          String str = ((String)iterator1.next()).toLowerCase();
          if (!doR.contains(str))
            continue; 
          null = (Set)hashMap.get(str);
          Set set = null;
          if (null == null)
            set = new HashSet(); 
          null = new StringBuilder();
          null.append("SELECT _id FROM ");
          null.append(str);
          null.append(" WHERE nShopID = ? AND (nIsUpdated = 1 OR nUpdateFlag = 1)");
          Cursor cursor = sQLiteDatabase.rawQuery(null.toString(), new String[] { paramString });
          while (cursor.moveToNext())
            set.add(cursor.getString(0)); 
          cursor.close();
          hashMap.put(str, set);
        } 
        sQLiteDatabase.setTransactionSuccessful();
      } catch (Exception list) {
        a.e(list);
      } finally {}
      sQLiteDatabase.endTransaction();
      sQLiteDatabase.close();
    } 
    return hashMap;
  }
  
  public static Map<String, Set<String>> ot(String paramString) throws Exception {
    HashMap hashMap = new HashMap();
    String[] arrayOfString = paramString.split(";");
    int i = arrayOfString.length;
    for (byte b1 = 0; b1 < i; b1++) {
      String[] arrayOfString1 = arrayOfString[b1].split(":");
      if (arrayOfString1.length == 2)
        hashMap.put(arrayOfString1[0], Collections.unmodifiableSet(new HashSet(Arrays.asList(arrayOfString1[1].split(","))))); 
    } 
    return Collections.unmodifiableMap(hashMap);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\sync\model\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */