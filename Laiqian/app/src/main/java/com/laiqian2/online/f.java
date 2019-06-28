package com.laiqian.online;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.db.a;
import com.laiqian.dcb.api.b.a.b;
import com.laiqian.f.b;
import com.laiqian.h.a;
import com.laiqian.i.d;
import com.laiqian.message.m;
import com.laiqian.models.ao;
import com.laiqian.network.b;
import com.laiqian.network.g;
import com.laiqian.network.h;
import com.laiqian.network.k;
import com.laiqian.network.n;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.sync.b;
import com.laiqian.util.by;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import com.laiqian.util.n;
import hugo.weaving.DebugLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.u;

public class f {
  @SuppressLint({"StaticFieldLeak"})
  public static final f bXQ = new f();
  
  private final int bXR = 100;
  
  private final LinkedHashMap<String, a> bXS = new LinkedHashMap();
  
  private Context context = RootApplication.zv();
  
  private String a(String paramString, OnlineSyncRequest paramOnlineSyncRequest) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("message_id", paramString);
      jSONObject.put("laiqian_encrypt", b.encode(d.ac(paramOnlineSyncRequest)));
      return jSONObject.toString();
    } catch (Exception paramString) {
      throw new RuntimeException("error building message", paramString);
    } 
  }
  
  private void a(OnlineSyncRequest paramOnlineSyncRequest, int paramInt, boolean paramBoolean) throws Exception {
    hashMap = new HashMap();
    for (OnlineSyncRequest.b b : paramOnlineSyncRequest.Xi()) {
      ao.c c = b.bXU.id("_id");
      if (c != null) {
        ArrayList arrayList;
        long l = ((Long)c.getValue()).longValue();
        String str = b.bXU.Vz();
        if (hashMap.containsKey(str) && hashMap.get(str) != null) {
          arrayList = (ArrayList)hashMap.get(str);
        } else {
          arrayList = new ArrayList();
          hashMap.put(str, arrayList);
        } 
        arrayList.add(Long.valueOf(l));
      } 
    } 
    SQLiteDatabase sQLiteDatabase = a.Y(this.context).getWritableDatabase();
    sQLiteDatabase.beginTransaction();
    try {
      for (Map.Entry null : hashMap.entrySet()) {
        String str1 = (String)null.getKey();
        String str2 = by.a(",", (Collection)null.getValue());
        if (paramInt == 1) {
          b.a(sQLiteDatabase, 0, str1, str2, paramBoolean);
          continue;
        } 
        if (paramInt == 2) {
          b.a(sQLiteDatabase, 0, str1, str2);
          continue;
        } 
        if (paramInt == 0)
          b.b(sQLiteDatabase, 0, str1, str2, paramBoolean); 
      } 
      sQLiteDatabase.setTransactionSuccessful();
      sQLiteDatabase.endTransaction();
      a.Y(this.context).close();
      return;
    } catch (SQLiteException hashMap) {
      h.a(new d(getClass().getName(), "setUpdated()", "exception", hashMap.getCause().toString()), h.a.dHw, h.b.dHD);
      throw new Exception("error updating flags", hashMap);
    } finally {}
    sQLiteDatabase.endTransaction();
    throw hashMap;
  }
  
  @DebugLog
  private void a(String paramString, @NonNull h paramh) throws Exception {
    if (this.bXS.containsKey(paramString)) {
      a a = (a)this.bXS.get(paramString);
      if (b.bXI.debug) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("online sync message takes ");
        stringBuilder.append(System.currentTimeMillis() - a.getTime());
        stringBuilder.append("ms");
        Log.d("OnlineSyncManager", stringBuilder.toString());
      } 
      this.bXS.remove(paramString);
      OnlineSyncRequest onlineSyncRequest = a.Xg();
      if (paramh.bXV) {
        a(onlineSyncRequest, 1, true);
        return;
      } 
      a(onlineSyncRequest, 0, false);
      return;
    } 
    h.a(new d(getClass().getSimpleName(), "processOnlineSyncResponse()", "IllegalStateException", "message not exist or expired"), h.a.dHw, h.b.dHD);
    throw new IllegalStateException("message not exist or expired");
  }
  
  private void b(String paramString, OnlineSyncRequest paramOnlineSyncRequest) {
    if (this.bXS.size() > 100) {
      int i = this.bXS.size() - 100;
      Iterator iterator = this.bXS.entrySet().iterator();
      while (iterator.hasNext() && i > 0) {
        iterator.next();
        iterator.remove();
        i--;
      } 
    } 
    this.bXS.put(paramString, new a(paramOnlineSyncRequest));
  }
  
  @DebugLog
  public h a(@NonNull OnlineSyncRequest paramOnlineSyncRequest, int paramInt) throws JSONException, Exception {
    u u1 = d.ac(paramOnlineSyncRequest);
    null = (b)n.bUo.af(b.class);
    g g = new g(u1);
    String str1 = RootUrlParameter.cla;
    URL uRL = new URL(RootUrlParameter.cla);
    if (!k.iI(str1)) {
      u1 = a.Js().I(uRL.getHost());
    } else {
      u1 = null;
    } 
    String str3 = String.valueOf(System.currentTimeMillis() / 1000L);
    String str4 = b.c(n.parseLong(str3), n.parseInt(RootApplication.getLaiqianPreferenceManager().Tx()));
    u u2 = "";
    if (u1 != null) {
      u2 = uRL.getHost();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Get IP: ");
      stringBuilder1.append(u1);
      stringBuilder1.append(" for host: ");
      stringBuilder1.append(u2);
      stringBuilder1.append(" for url:");
      stringBuilder1.append(str1);
      stringBuilder1.append(" from HTTPDNS successfully!");
      Log.d("OnlineSyncManager", stringBuilder1.toString());
      u1 = str1.replaceFirst(u2, u1);
      h.a(new d(getClass().getName(), g.toString()), h.a.dHx, h.b.dHD);
      u2 = null.a(u1, g, u2, RootApplication.getLaiqianPreferenceManager().Tx(), str3, str4).aYS();
    } else {
      u u = null.a(str1, g, RootApplication.getLaiqianPreferenceManager().Tx(), str3, str4).aYS();
      u1 = u2;
      u2 = u;
    } 
    str3 = getClass().getName();
    String str2 = new StringBuilder();
    str2.append(u2.aGo());
    str2.append("--");
    str2.append(((h)u2.aZd()).oV());
    str4 = str2.toString();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("请求地址：");
    if (!TextUtils.isEmpty(u1)) {
      u u = u1;
    } else {
      str2 = str1;
    } 
    stringBuilder.append(str2);
    stringBuilder.append(" ");
    stringBuilder.append(g.toString());
    h.a(new d(str3, "syncRequestSync", str4, stringBuilder.toString()), h.a.dHx, h.b.dHD);
    if (!u2.aTa()) {
      u u;
      str2 = getClass().getName();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(u2.aGo());
      stringBuilder2.append("");
      String str = stringBuilder2.toString();
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("请求地址：");
      if (!TextUtils.isEmpty(u1))
        u = u1; 
      stringBuilder3.append(u);
      stringBuilder3.append(" ");
      stringBuilder3.append(u2.message());
      h.a(new d(str2, "syncRequestSync", str, stringBuilder3.toString()), h.a.dHv, h.b.dHD);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("request failed: ");
      stringBuilder1.append(u2.aGo());
      stringBuilder1.append(" ");
      stringBuilder1.append(u2.message());
      throw new Exception(stringBuilder1.toString());
    } 
    return (h)d.b(((h)u2.aZd()).oV(), h.class);
  }
  
  @DebugLog
  public void a(@NonNull OnlineSyncRequest paramOnlineSyncRequest) throws JSONException, Exception {
    String str = String.valueOf(System.currentTimeMillis());
    m.gC(a(str, paramOnlineSyncRequest));
    try {
      a(paramOnlineSyncRequest, 2, false);
    } catch (Exception exception) {
      a.e(exception);
    } 
    b(str, paramOnlineSyncRequest);
  }
  
  public h b(@NonNull OnlineSyncRequest paramOnlineSyncRequest) throws JSONException, Exception { return a(paramOnlineSyncRequest, 50000); }
  
  @DebugLog
  public void iL(String paramString) {
    paramString = b.decode(paramString);
    try {
      null = new JSONObject(paramString);
      paramString = null.optString("message_id");
      String str = b.decode(null.optString("laiqian_encrypt"));
      if (b.bXI.debug) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onOnlineSyncResponse: ");
        stringBuilder.append(str);
        Log.d("OnlineSyncManager", stringBuilder.toString());
      } 
      a(paramString, (h)d.b(str, h.class));
      return;
    } catch (Exception paramString) {
      a.e(paramString);
      return;
    } 
  }
  
  private static class a {
    private OnlineSyncRequest bXK;
    
    private long time;
    
    a(OnlineSyncRequest param1OnlineSyncRequest) throws JSONException, Exception {
      this.bXK = param1OnlineSyncRequest;
      this.time = System.currentTimeMillis();
    }
    
    public OnlineSyncRequest Xg() { return this.bXK; }
    
    public long getTime() { return this.time; }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\online\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */