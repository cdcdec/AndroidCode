package com.laiqian.news;

import android.os.AsyncTask;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.network.i;
import com.laiqian.network.k;
import com.laiqian.opentable.common.b;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;

public class y {
  public static void a(int paramInt, w.b paramb) {
    String str;
    HashMap hashMap = b.Xu();
    if (paramInt == 1)
      hashMap.put("datetime", Long.valueOf(RootApplication.getLaiqianPreferenceManager().atP())); 
    if (paramInt == 0) {
      str = RootUrlParameter.cmj;
    } else {
      str = RootUrlParameter.cmk;
    } 
    a(paramInt, hashMap, str, new z(paramb));
  }
  
  public static void a(int paramInt, HashMap<String, Object> paramHashMap, String paramString, w.a parama) {
    v v = new v(parama);
    try {
      String str = b.z(paramHashMap);
    } catch (JSONException paramHashMap) {
      a.e(paramHashMap);
      paramHashMap = null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    v.execute(new String[] { stringBuilder.toString(), paramHashMap, paramString });
  }
  
  public String a(LinkedHashMap<Integer, Long> paramLinkedHashMap) {
    Iterator iterator = paramLinkedHashMap.entrySet().iterator();
    StringBuffer stringBuffer = new StringBuffer();
    String str = "";
    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry)iterator.next();
      if (!stringBuffer.toString().contains(String.valueOf(entry.getValue()))) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(entry.getValue());
        stringBuilder1.append(",");
        stringBuffer.append(stringBuilder1.toString());
      } 
    } 
    if (stringBuffer.length() > 0)
      str = stringBuffer.substring(0, stringBuffer.length() - 1); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("strDataTimes:");
    stringBuilder.append(str);
    Log.e("ScanOrderModel", stringBuilder.toString());
    return str;
  }
  
  public String j(PendingFullOrderDetail paramPendingFullOrderDetail) {
    LinkedHashMap linkedHashMap = new LinkedHashMap();
    new ArrayList();
    new ArrayList();
    Iterator iterator = paramPendingFullOrderDetail.coy.iterator();
    byte b = 0;
    while (iterator.hasNext()) {
      PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)iterator.next();
      if (d.aTU != 0)
        continue; 
      if (!b)
        linkedHashMap.put(Integer.valueOf(b), Long.valueOf(d.bbX)); 
      if (d.cpx != 4L)
        b++; 
    } 
    new ArrayList();
    label26: for (PendingFullOrderDetail.c null : paramPendingFullOrderDetail.coz) {
      linkedHashMap.put(Integer.valueOf(b), Long.valueOf(null.cpi.getTime()));
      Iterator iterator1 = null.cpg.iterator();
      byte b1 = b;
      while (true) {
        b = b1;
        if (iterator1.hasNext()) {
          PendingFullOrderDetail.d d = (PendingFullOrderDetail.d)iterator1.next();
          if (d.aTU == 0 && d.cpx != 4L)
            b1++; 
          continue;
        } 
        continue label26;
      } 
    } 
    return a(linkedHashMap);
  }
  
  public HashMap<String, Object> k(PendingFullOrderDetail paramPendingFullOrderDetail) {
    HashMap hashMap = new HashMap();
    hashMap.put("action", Integer.valueOf(1));
    hashMap.put("datetimes", j(paramPendingFullOrderDetail));
    hashMap.put("table_id", paramPendingFullOrderDetail.bXb.coJ);
    hashMap.put("releated_id", Long.valueOf(paramPendingFullOrderDetail.bXb.bZP));
    return hashMap;
  }
  
  static class a extends AsyncTask<HashMap<String, Object>, Void, i> {
    HashMap<String, Object> bXl;
    
    a bXm;
    
    boolean bXn;
    
    protected i a(HashMap<String, Object>... param1VarArgs) {
      this.bXl = param1VarArgs[0];
      try {
        return (new k()).c(b.z(param1VarArgs[0]), RootUrlParameter.cml, 1);
      } catch (IOException param1VarArgs) {
        a.e(param1VarArgs);
        return new i(false, false, "");
      } catch (Exception param1VarArgs) {
        a.e(param1VarArgs);
        return new i(false, false, "");
      } 
    }
    
    protected void a(i param1i) {
      super.onPostExecute(param1i);
      if (this.bXm != null)
        this.bXm.a(param1i); 
    }
    
    public void a(a param1a) { this.bXm = param1a; }
    
    protected void onPreExecute() {
      if (this.bXm != null)
        this.bXm.onPreExecute(); 
      super.onPreExecute();
    }
    
    public static interface a {
      void a(i param2i);
      
      void onPreExecute();
    }
  }
  
  public static interface a {
    void a(i param1i);
    
    void onPreExecute();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */