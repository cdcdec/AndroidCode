package com.laiqian.opentable.common;

import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.google.gson.k;
import com.laiqian.basic.RootApplication;
import com.laiqian.opentable.b.q;
import com.laiqian.opentable.common.connect.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.util.by;
import io.reactivex.g.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;

public class n {
  static boolean C(HashMap<String, ArrayList<TableEntity>> paramHashMap) {
    RootApplication.zv().getSharedPreferences("areaTable", 0).edit().putString("tableList", (new k()).ac(paramHashMap)).commit();
    return true;
  }
  
  static boolean S(ArrayList<a> paramArrayList) {
    RootApplication.zv().getSharedPreferences("areaTable", 0).edit().putString("areaList", (new k()).ac(paramArrayList)).commit();
    return true;
  }
  
  static HashMap<String, ArrayList<TableEntity>> XK() {
    null = new StringBuilder();
    null.append("开始解析getAreaTableEntities");
    null.append((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(new Date()));
    Log.d("openTable", null.toString());
    String str = RootApplication.zv().getSharedPreferences("areaTable", 0).getString("tableList", null);
    if (!by.isNull(str)) {
      HashMap hashMap = (HashMap)(new k()).a(str, (new q()).wp());
      if (hashMap != null) {
        null = new StringBuilder();
        null.append("结束解析getAreaTableEntities");
        null.append((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(new Date()));
        Log.d("openTable", null.toString());
        Iterator iterator = hashMap.values().iterator();
        while (iterator.hasNext()) {
          for (TableEntity tableEntity : (ArrayList)iterator.next()) {
            ArrayList arrayList = tableEntity.Yh();
            if (arrayList != null && arrayList.size() > 0)
              tableEntity.c((c)arrayList.get(0)); 
          } 
        } 
        return hashMap;
      } 
    } 
    return new HashMap();
  }
  
  public static void XL() { a.aKh().r(o.baQ); }
  
  public static ArrayList<a> Xo() {
    null = new StringBuilder();
    null.append("开始解析getAreaList");
    null.append((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(new Date()));
    Log.d("openTable", null.toString());
    String str = RootApplication.zv().getSharedPreferences("areaTable", 0).getString("areaList", null);
    if (!by.isNull(str)) {
      ArrayList arrayList = (ArrayList)(new k()).a(str, (new p()).wp());
      if (arrayList != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("结束解析getAreaList");
        stringBuilder.append((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(new Date()));
        Log.d("openTable", stringBuilder.toString());
        return arrayList;
      } 
    } 
    return new ArrayList();
  }
  
  public static void a(HashMap<String, Object> paramHashMap, String paramString, t.a parama) {
    a a1 = new a(parama);
    try {
      String str = b.z(paramHashMap);
    } catch (JSONException paramHashMap) {
      a.e(paramHashMap);
      paramHashMap = null;
    } 
    a1.execute(new String[] { paramHashMap, paramString });
  }
  
  public static void a(boolean paramBoolean, t.f paramf) throws m {
    if (b.XB() || b.XD()) {
      a(b.Xu(), RootUrlParameter.clV, new r(paramf, paramBoolean));
      return;
    } 
    b.a(RootApplication.zv(), paramf);
  }
  
  private static boolean a(TableEntity paramTableEntity, a parama) {
    HashMap hashMap = XK();
    Iterator iterator = hashMap.entrySet().iterator();
    while (iterator.hasNext()) {
      ArrayList arrayList = (ArrayList)((Map.Entry)iterator.next()).getValue();
      if (arrayList != null)
        for (byte b = 0; b < arrayList.size(); b++) {
          if (((TableEntity)arrayList.get(b)).getID() == paramTableEntity.getID()) {
            parama.bZi = ((TableEntity)arrayList.get(b)).Yb();
            parama.time = ((TableEntity)arrayList.get(b)).DP();
            if (paramTableEntity.getState() >= 0)
              ((TableEntity)arrayList.get(b)).setState(paramTableEntity.getState()); 
            if (paramTableEntity.DP() >= 0L)
              ((TableEntity)arrayList.get(b)).cf(paramTableEntity.DP()); 
            ((TableEntity)arrayList.get(b)).gw(paramTableEntity.Xy());
            if (b.XH()) {
              boolean bool;
              TableEntity tableEntity = (TableEntity)arrayList.get(b);
              if (b.cc(((TableEntity)arrayList.get(b)).getID()) != null) {
                bool = true;
              } else {
                bool = false;
              } 
              tableEntity.eG(bool);
            } else {
              ((TableEntity)arrayList.get(b)).eG(false);
            } 
            ((TableEntity)arrayList.get(b)).c(paramTableEntity.Yg());
            ((TableEntity)arrayList.get(b)).W(paramTableEntity.Yh());
            if (b.XD()) {
              b.i((TableEntity)arrayList.get(b));
              ((TableEntity)arrayList.get(b)).Yg().da(paramTableEntity.Yg().xq());
            } else {
              ((TableEntity)arrayList.get(b)).Yg().da(paramTableEntity.Yg().xq());
            } 
            if (paramTableEntity.Yh().size() > 0) {
              Collections.sort(paramTableEntity.Yh());
              paramTableEntity.c((c)paramTableEntity.Yh().get(0));
            } 
            C(hashMap);
            return true;
          } 
        }  
    } 
    return false;
  }
  
  public static a cd(long paramLong) {
    ArrayList arrayList = Xo();
    for (byte b = 0; b < arrayList.size(); b++) {
      if (((a)arrayList.get(b)).getId() == paramLong)
        return (a)arrayList.get(b); 
    } 
    return null;
  }
  
  public static TableEntity ce(long paramLong) {
    Iterator iterator = XK().entrySet().iterator();
    while (iterator.hasNext()) {
      ArrayList arrayList = (ArrayList)((Map.Entry)iterator.next()).getValue();
      if (arrayList != null)
        for (byte b = 0; b < arrayList.size(); b++) {
          if (((TableEntity)arrayList.get(b)).getID() == paramLong) {
            ((TableEntity)arrayList.get(b)).jl(cd(((TableEntity)arrayList.get(b)).XY()).XX());
            return (TableEntity)arrayList.get(b);
          } 
        }  
    } 
    return null;
  }
  
  public static ArrayList<TableEntity> jg(String paramString) {
    ArrayList arrayList1;
    ArrayList arrayList2 = new ArrayList();
    if ("-1".equals(paramString)) {
      Iterator iterator = XK().entrySet().iterator();
      while (true) {
        arrayList1 = arrayList2;
        if (iterator.hasNext()) {
          arrayList1 = (ArrayList)((Map.Entry)iterator.next()).getValue();
          if (arrayList1 != null)
            arrayList2.addAll(arrayList1); 
          continue;
        } 
        break;
      } 
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("该区域桌号查找开始");
      stringBuilder.append((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(new Date()));
      Log.d("openTable", stringBuilder.toString());
      arrayList1 = (ArrayList)XK().get(arrayList1);
      stringBuilder = new StringBuilder();
      stringBuilder.append("该区域桌号查找结束");
      stringBuilder.append((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(new Date()));
      Log.d("openTable", stringBuilder.toString());
    } 
    return arrayList1;
  }
  
  public static a k(TableEntity paramTableEntity) {
    a a = new a();
    return a(paramTableEntity, a) ? a : a;
  }
  
  public static class a {
    public long bZi;
    
    public long time;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */