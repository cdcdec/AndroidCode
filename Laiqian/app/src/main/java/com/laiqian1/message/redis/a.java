package com.laiqian.message.redis;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.l;
import com.laiqian.entity.m;
import com.laiqian.i.d;
import com.laiqian.network.i;
import com.laiqian.network.k;
import com.laiqian.pos.industry.a;
import com.laiqian.util.bb;
import com.laiqian.util.k;
import com.laiqian.util.logger.a;
import com.squareup.moshi.ay;
import io.reactivex.h;
import io.reactivex.i;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  public static a bJg;
  
  private a aOV = new a(a.class.getSimpleName());
  
  private String bJh = ".html";
  
  private a bJi;
  
  private int count = 0;
  
  private Context mContext;
  
  static  {
  
  }
  
  public a(Context paramContext, a parama) {
    this.mContext = paramContext;
    this.bJi = parama;
  }
  
  private void TA() { this.count++; }
  
  private void TB() { this.count = 0; }
  
  private boolean TC() { return (this.count > 90); }
  
  private h<Pair<String, List<String>>> TD() { return h.a(e.bet); }
  
  private void X(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("delete message id is: ");
    stringBuilder.append(paramString2);
    stringBuilder.append(",message type is:");
    stringBuilder.append(paramString1);
    bb.rM(stringBuilder.toString());
  }
  
  private i a(k paramk, String paramString1, String paramString2) throws Exception {
    HashMap hashMap = new HashMap();
    hashMap.put("type", paramString1);
    hashMap.put("msg_id", paramString2);
    return paramk.c(i.z(hashMap), a.crr, 0);
  }
  
  private <T> JSONArray a(JSONArray paramJSONArray, List<T> paramList) {
    Iterator iterator = paramList.iterator();
    while (iterator.hasNext())
      paramJSONArray.put(iterator.next()); 
    return paramJSONArray;
  }
  
  private void a(k paramk) { TD().a(new b(this, paramk), c.aEp); }
  
  private String b(k paramk) throws Exception { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   5: invokevirtual awb : ()Z
    //   8: iconst_1
    //   9: if_icmpne -> 17
    //   12: aload_0
    //   13: monitorexit
    //   14: ldc '200'
    //   16: areturn
    //   17: new java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: astore_2
    //   25: aload_2
    //   26: getstatic com/laiqian/pos/hardware/RootUrlParameter.ckU : Ljava/lang/String;
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: ldc '/'
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_2
    //   41: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   44: invokevirtual Tx : ()Ljava/lang/String;
    //   47: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: ldc '/'
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_2
    //   59: invokestatic Tw : ()Ljava/lang/String;
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_2
    //   67: aload_0
    //   68: getfield bJh : Ljava/lang/String;
    //   71: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_1
    //   76: aload_2
    //   77: invokevirtual toString : ()Ljava/lang/String;
    //   80: iconst_1
    //   81: invokevirtual n : (Ljava/lang/String;Z)Ljava/lang/String;
    //   84: astore_1
    //   85: ldc '200'
    //   87: aload_1
    //   88: invokevirtual equals : (Ljava/lang/Object;)Z
    //   91: ifeq -> 102
    //   94: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   97: iconst_1
    //   98: invokevirtual hU : (Z)Z
    //   101: pop
    //   102: new java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial <init> : ()V
    //   109: astore_2
    //   110: aload_2
    //   111: ldc 'Nginx html request result code is '
    //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_2
    //   118: aload_1
    //   119: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_2
    //   124: invokevirtual toString : ()Ljava/lang/String;
    //   127: invokestatic rM : (Ljava/lang/String;)V
    //   130: ldc 'MessageStatusTask'
    //   132: aload_1
    //   133: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   136: pop
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: areturn
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	141	finally
    //   17	102	141	finally
    //   102	137	141	finally }
  
  private List<l> b(List<l> paramList, String paramString) {
    String str = RootApplication.getLaiqianPreferenceManager().avO();
    if (str != null)
      try {
        JSONObject jSONObject = new JSONObject(str);
        if (!jSONObject.isNull(paramString)) {
          List list = Arrays.asList(jSONObject.getJSONArray(paramString).join(",").split(","));
          ArrayList arrayList = new ArrayList();
          k.a(paramList, arrayList, new d(list));
          return arrayList;
        } 
      } catch (JSONException paramString) {
        a.e(paramString);
      }  
    return new ArrayList(paramList);
  }
  
  private void b(String paramString, List<String> paramList) {
    String str = RootApplication.getLaiqianPreferenceManager().avO();
    if (str == null)
      try {
        paramString = (new g(this, paramString, paramList)).toString();
        RootApplication.getLaiqianPreferenceManager().rE(paramString);
        return;
      } catch (JSONException paramString) {
        a.e(paramString);
        return;
      }  
    paramString = (new h(this, str, paramString, paramList)).toString();
    RootApplication.getLaiqianPreferenceManager().rE(paramString);
  }
  
  private i c(k paramk) throws Exception { return paramk.c(i.z(null), a.crp, 0); }
  
  private void fW(int paramInt) {
    RootApplication.getLaiqianPreferenceManager().dD(paramInt);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Get Message Accumulated Quantity:");
    stringBuilder.append(RootApplication.getLaiqianPreferenceManager().awa());
    bb.rM(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("Get Message Accumulated Quantity:");
    stringBuilder.append(RootApplication.getLaiqianPreferenceManager().awa());
    Log.d("message_system", stringBuilder.toString());
  }
  
  private void gH(String paramString) {
    String str = RootApplication.getLaiqianPreferenceManager().avO();
    if (str != null)
      try {
        JSONObject jSONObject = new JSONObject(str);
        if (!jSONObject.isNull(paramString))
          jSONObject.remove(paramString); 
        RootApplication.getLaiqianPreferenceManager().rE(jSONObject.toString());
        return;
      } catch (JSONException paramString) {
        a.e(paramString);
      }  
  }
  
  public void execute() {
    TA();
    Log.d("MessageStatusTask", "execute");
    try {
      k k = new k();
      String str = b(k);
      a(k);
      if (str.equals("200") || TC()) {
        TB();
        i = c(k);
        if (i.bUj == 0 && !TextUtils.isEmpty(i.message)) {
          JSONArray jSONArray = new JSONArray(i.message);
          for (byte b = 0;; b++) {
            if (b < jSONArray.length()) {
              m m = m.c(jSONArray.getJSONObject(b));
              this.bJi.a(m);
              int j = m.getStatus();
              if (j == 1)
                try {
                  null = new HashMap();
                  null.put("type", m.getType());
                  null = new JSONArray((k.c(i.z(null), a.crq, 0)).message);
                  ArrayList arrayList = new ArrayList();
                  for (j = 0; j < null.length(); j++) {
                    fW(1);
                    arrayList.add(l.b(null.getJSONObject(j)));
                  } 
                  StringBuffer stringBuffer = new StringBuffer();
                  List list = b(arrayList, m.getType());
                  for (j = 0;; j++) {
                    if (j < list.size()) {
                      boolean bool;
                      l l = (l)list.get(j);
                      try {
                        bool = this.bJi.W(m.getType(), l.Fh());
                      } catch (Exception exception) {
                        a.e(exception);
                        bool = false;
                      } 
                      if (bool && !"0".equals(l.Fi())) {
                        String str1;
                        if (j == 0) {
                          str1 = l.Fi();
                        } else {
                          StringBuilder stringBuilder = new StringBuilder();
                          stringBuilder.append(",");
                          stringBuilder.append(str1.Fi());
                          str1 = stringBuilder.toString();
                        } 
                        stringBuffer.append(str1);
                      } 
                    } else {
                      if (!stringBuffer.toString().isEmpty()) {
                        X(m.getType(), stringBuffer.toString());
                        if (!(a(k, m.getType(), stringBuffer.toString())).bUi) {
                          List list1 = Arrays.asList(stringBuffer.toString().split(","));
                          b(m.getType(), list1);
                        } 
                      } 
                      break;
                    } 
                  } 
                } catch (Exception i) {
                  a.e(i);
                }  
            } else {
              RootApplication.getLaiqianPreferenceManager().hU(false);
              return;
            } 
          } 
        } 
        this.aOV.c("errorCode: %d\nmessage: %s", new Object[] { Integer.valueOf(i.bUj), i.message });
        return;
      } 
    } catch (Exception exception) {
      RootApplication.getLaiqianPreferenceManager().hU(false);
      a.e(exception);
    } 
  }
  
  public static interface a {
    boolean W(String param1String1, String param1String2);
    
    void a(m param1m);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\redis\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */