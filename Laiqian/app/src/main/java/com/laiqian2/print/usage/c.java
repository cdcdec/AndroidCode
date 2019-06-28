package com.laiqian.print.usage;

import android.content.Context;
import android.content.Intent;
import android.os.ParcelUuid;
import com.google.a.a.a.a.a.a;
import com.laiqian.print.ac;
import com.laiqian.print.bl;
import com.laiqian.print.bm;
import com.laiqian.print.model.s;
import com.laiqian.print.model.type.a.f;
import com.laiqian.print.model.type.b.a;
import com.laiqian.print.model.type.b.c;
import com.laiqian.print.model.type.c.c;
import com.laiqian.print.model.type.usb.UsbPrintManager;
import com.laiqian.print.model.type.usb.d;
import com.laiqian.print.model.type.usb.g;
import com.laiqian.print.type.a;
import com.laiqian.util.av;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
  private static c cMj;
  
  private ConcurrentHashMap<String, String> cMk = new ConcurrentHashMap();
  
  private Context mContext;
  
  static  {
  
  }
  
  private c(Context paramContext) { this.mContext = paramContext; }
  
  public static c bi(Context paramContext) {
    if (cMj == null)
      cMj = new c(paramContext.getApplicationContext()); 
    return cMj;
  }
  
  private List<s> g(bm parambm) {
    ArrayList arrayList = new ArrayList();
    for (ac ac : afs()) {
      if (ac.aex().contains(parambm))
        arrayList.add(ac.aew()); 
    } 
    return arrayList;
  }
  
  public static JSONObject g(ac paramac) throws JSONException { // Byte code:
    //   0: new org/json/JSONObject
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_3
    //   8: new org/json/JSONArray
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: astore #4
    //   17: aload_0
    //   18: invokevirtual aey : ()Ljava/util/Collection;
    //   21: invokeinterface iterator : ()Ljava/util/Iterator;
    //   26: astore #5
    //   28: aload #5
    //   30: invokeinterface hasNext : ()Z
    //   35: ifeq -> 60
    //   38: aload #4
    //   40: aload #5
    //   42: invokeinterface next : ()Ljava/lang/Object;
    //   47: checkcast com/laiqian/print/usage/e
    //   50: invokevirtual xy : ()Lorg/json/JSONObject;
    //   53: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   56: pop
    //   57: goto -> 28
    //   60: aload_3
    //   61: ldc 'usages'
    //   63: aload #4
    //   65: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   68: pop
    //   69: new org/json/JSONObject
    //   72: dup
    //   73: invokespecial <init> : ()V
    //   76: astore #4
    //   78: aload_0
    //   79: invokevirtual aew : ()Lcom/laiqian/print/model/s;
    //   82: astore #5
    //   84: aload #4
    //   86: ldc 'identifier'
    //   88: aload #5
    //   90: invokevirtual getIdentifier : ()Ljava/lang/String;
    //   93: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   96: pop
    //   97: aload #4
    //   99: ldc 'name'
    //   101: aload #5
    //   103: invokevirtual getName : ()Ljava/lang/String;
    //   106: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   109: pop
    //   110: aload #4
    //   112: ldc 'protocol'
    //   114: aload #5
    //   116: invokevirtual agF : ()I
    //   119: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   122: pop
    //   123: aload #4
    //   125: ldc 'height'
    //   127: aload #5
    //   129: invokevirtual getHeight : ()I
    //   132: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   135: pop
    //   136: aload #4
    //   138: ldc 'width'
    //   140: aload #5
    //   142: invokevirtual getWidth : ()I
    //   145: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   148: pop
    //   149: aload #4
    //   151: ldc 'type'
    //   153: aload #5
    //   155: invokevirtual getType : ()I
    //   158: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   161: pop
    //   162: aload #4
    //   164: ldc 'support_raster'
    //   166: aload #5
    //   168: invokevirtual agH : ()Z
    //   171: invokevirtual put : (Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   174: pop
    //   175: aload #5
    //   177: instanceof com/laiqian/print/model/type/c/c
    //   180: ifeq -> 199
    //   183: aload #4
    //   185: ldc 'use_hardware_flow_control'
    //   187: aload #5
    //   189: checkcast com/laiqian/print/model/type/c/c
    //   192: invokevirtual agT : ()Z
    //   195: invokevirtual put : (Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   198: pop
    //   199: aload #5
    //   201: invokevirtual getType : ()I
    //   204: tableswitch default -> 236, 1 -> 399, 2 -> 363, 3 -> 275, 4 -> 239
    //   236: goto -> 458
    //   239: aload #5
    //   241: checkcast com/laiqian/print/model/type/c/c
    //   244: astore #5
    //   246: aload #4
    //   248: ldc 'path'
    //   250: aload #5
    //   252: invokevirtual getPath : ()Ljava/lang/String;
    //   255: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   258: pop
    //   259: aload #4
    //   261: ldc 'baudrate'
    //   263: aload #5
    //   265: invokevirtual getBaudrate : ()I
    //   268: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   271: pop
    //   272: goto -> 458
    //   275: aload #5
    //   277: checkcast com/laiqian/print/model/type/a/f
    //   280: astore #6
    //   282: aload #4
    //   284: ldc 'mac'
    //   286: aload #6
    //   288: invokevirtual getMacAddress : ()Ljava/lang/String;
    //   291: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   294: pop
    //   295: new org/json/JSONArray
    //   298: dup
    //   299: invokespecial <init> : ()V
    //   302: astore #5
    //   304: aload #6
    //   306: invokevirtual getUuids : ()[Landroid/os/ParcelUuid;
    //   309: ifnull -> 350
    //   312: aload #6
    //   314: invokevirtual getUuids : ()[Landroid/os/ParcelUuid;
    //   317: astore #6
    //   319: aload #6
    //   321: arraylength
    //   322: istore_2
    //   323: iconst_0
    //   324: istore_1
    //   325: iload_1
    //   326: iload_2
    //   327: if_icmpge -> 350
    //   330: aload #5
    //   332: aload #6
    //   334: iload_1
    //   335: aaload
    //   336: invokevirtual toString : ()Ljava/lang/String;
    //   339: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   342: pop
    //   343: iload_1
    //   344: iconst_1
    //   345: iadd
    //   346: istore_1
    //   347: goto -> 325
    //   350: aload #4
    //   352: ldc 'uuids'
    //   354: aload #5
    //   356: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   359: pop
    //   360: goto -> 458
    //   363: aload #5
    //   365: checkcast com/laiqian/print/model/type/b/c
    //   368: astore #5
    //   370: aload #4
    //   372: ldc 'address'
    //   374: aload #5
    //   376: invokevirtual getAddress : ()Ljava/lang/String;
    //   379: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   382: pop
    //   383: aload #4
    //   385: ldc 'port'
    //   387: aload #5
    //   389: invokevirtual getPort : ()I
    //   392: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   395: pop
    //   396: goto -> 458
    //   399: aload #5
    //   401: checkcast com/laiqian/print/model/type/usb/g
    //   404: astore #5
    //   406: aload #4
    //   408: ldc 'path'
    //   410: aload #5
    //   412: invokevirtual getPath : ()Ljava/lang/String;
    //   415: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   418: pop
    //   419: aload #4
    //   421: ldc 'pid'
    //   423: aload #5
    //   425: invokevirtual getProductId : ()I
    //   428: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   431: pop
    //   432: aload #4
    //   434: ldc 'vid'
    //   436: aload #5
    //   438: invokevirtual getVendorId : ()I
    //   441: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   444: pop
    //   445: aload #4
    //   447: ldc 'isRequireVerify'
    //   449: aload #5
    //   451: invokevirtual agW : ()Z
    //   454: invokevirtual put : (Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   457: pop
    //   458: aload_3
    //   459: ldc 'printer'
    //   461: aload #4
    //   463: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   466: pop
    //   467: aload_0
    //   468: invokevirtual aeA : ()Ljava/util/Collection;
    //   471: astore #4
    //   473: new org/json/JSONArray
    //   476: dup
    //   477: invokespecial <init> : ()V
    //   480: astore_0
    //   481: aload #4
    //   483: invokeinterface iterator : ()Ljava/util/Iterator;
    //   488: astore #4
    //   490: aload #4
    //   492: invokeinterface hasNext : ()Z
    //   497: ifeq -> 528
    //   500: aload_0
    //   501: new org/json/JSONObject
    //   504: dup
    //   505: aload #4
    //   507: invokeinterface next : ()Ljava/lang/Object;
    //   512: checkcast com/laiqian/print/printtype/j
    //   515: invokestatic ac : (Ljava/lang/Object;)Ljava/lang/String;
    //   518: invokespecial <init> : (Ljava/lang/String;)V
    //   521: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   524: pop
    //   525: goto -> 490
    //   528: aload_3
    //   529: ldc 'order_selections'
    //   531: aload_0
    //   532: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   535: pop
    //   536: aload_3
    //   537: areturn }
  
  private boolean lO(String paramString) {
    Iterator iterator = this.cMk.entrySet().iterator();
    while (iterator.hasNext()) {
      if (((String)((Map.Entry)iterator.next()).getValue()).equals(paramString))
        return true; 
    } 
    return false;
  }
  
  public static ac p(JSONObject paramJSONObject) throws JSONException {
    f f;
    g g;
    ArrayList arrayList = new ArrayList();
    boolean bool1 = paramJSONObject.has("usage");
    boolean bool = false;
    if (bool1) {
      Object object = paramJSONObject.get("usage");
      if (object instanceof Integer) {
        arrayList.add(g.h(bm.a(bl.hN(paramJSONObject.getInt("usage")))));
      } else {
        arrayList.add(g.h(bm.valueOf(object.toString())));
      } 
    } else if (paramJSONObject.has("usages")) {
      JSONArray jSONArray = paramJSONObject.getJSONArray("usages");
      for (byte b = 0; b < jSONArray.length(); b++)
        arrayList.add(e.q(jSONArray.getJSONObject(b))); 
    } 
    JSONObject jSONObject = paramJSONObject.getJSONObject("printer");
    paramJSONObject = null;
    switch (jSONObject.getInt("type")) {
      case 4:
        null = new c(jSONObject.getString("path"), jSONObject.getInt("baudrate"));
        null = null;
        if (jSONObject.has("use_hardware_flow_control")) {
          null.fQ(jSONObject.getBoolean("use_hardware_flow_control"));
          null = null;
        } 
        break;
      case 3:
        f = new f(jSONObject.getString("mac"));
        null = f;
        if (jSONObject.has("uuids")) {
          JSONArray jSONArray = jSONObject.getJSONArray("uuids");
          ParcelUuid[] arrayOfParcelUuid = new ParcelUuid[jSONArray.length()];
          for (byte b = bool; b < jSONArray.length(); b++)
            arrayOfParcelUuid[b] = ParcelUuid.fromString(jSONArray.getString(b)); 
          f.a(arrayOfParcelUuid);
          f f1 = f;
        } 
        break;
      case 2:
        null = new c(jSONObject.getString("address"), jSONObject.getInt("port"));
        break;
      case 1:
        g = new g(jSONObject.getInt("vid"), jSONObject.getInt("pid"), jSONObject.getString("path"));
        g.fT(jSONObject.getBoolean("isRequireVerify"));
        break;
    } 
    g.setName(jSONObject.getString("name"));
    g.setHeight(jSONObject.getInt("height"));
    g.setWidth(jSONObject.getInt("width"));
    g.ii(jSONObject.getInt("protocol"));
    if (jSONObject.has("support_raster"))
      g.fP(jSONObject.getBoolean("support_raster")); 
    return new ac(g, arrayList);
  }
  
  private String q(s params) {
    a a;
    String str1;
    int i = params.getType();
    String str3 = "打印机";
    switch (i) {
      default:
        str1 = str3;
        break;
      case 4:
        str1 = "串口打印机";
        break;
      case 3:
        str1 = "蓝牙打印机";
        break;
      case 2:
        a = a.cHO;
        str1 = ((c)str1).getAddress();
        break;
      case 1:
        str1 = UsbPrintManager.INSTANCE.generatePrinterName((g)str1);
        break;
    } 
    if (!lO(str1))
      return str1; 
    i = 2;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append("-");
    stringBuilder.append(2);
    String str2 = stringBuilder.toString();
    while (lO(str2)) {
      i++;
      null = new StringBuilder();
      null.append(str1);
      null.append("-");
      null.append(i);
      str2 = null.toString();
    } 
    return str2;
  }
  
  public ArrayList<ac> afs() {
    null = new av(this.mContext);
    null = (String)null.qQ("json-selections");
    null.close();
    if (null == null)
      return new ArrayList(); 
    ArrayList arrayList = new ArrayList();
    try {
      JSONArray jSONArray = new JSONArray(null);
      for (byte b = 0; b < jSONArray.length(); b++)
        arrayList.add(p(jSONArray.getJSONObject(b))); 
    } catch (JSONException null) {
      a.e(null);
    } 
    Iterator iterator = arrayList.iterator();
    while (iterator.hasNext())
      ((ac)iterator.next()).aew().setConnected(false); 
    return arrayList;
  }
  
  public List<s> ahV() { return g(bm.cEf); }
  
  public List<s> ahW() { return g(bm.cEg); }
  
  public List<s> ahX() { return g(bm.cEh); }
  
  public List<s> ahY() { return g(bm.cEi); }
  
  public boolean ak(ArrayList<ac> paramArrayList) {
    null = new av(this.mContext);
    try {
      JSONArray jSONArray = new JSONArray();
      Iterator iterator = paramArrayList.iterator();
      while (iterator.hasNext())
        jSONArray.put(g((ac)iterator.next())); 
      null.h("json-selections", jSONArray.toString());
    } catch (JSONException jSONException) {
      a.e(jSONException);
    } 
    null.close();
    a a = a.bh(this.mContext);
    int i = paramArrayList.size();
    byte b = 0;
    boolean bool = false;
    while (b < i) {
      s s = ((ac)paramArrayList.get(b)).aew();
      d d = new d(s.getIdentifier(), s.getName());
      d.setWidth(s.getWidth());
      d.setHeight(s.getHeight());
      bool = a.b(d);
      b++;
    } 
    if (bool)
      this.mContext.sendBroadcast(new Intent("pos_activity_change_data_printer")); 
    return bool;
  }
  
  @DebugLog
  public boolean f(ac paramac) {
    boolean bool1;
    ArrayList arrayList = afs();
    String str = paramac.aew().getIdentifier();
    boolean bool2 = false;
    byte b = 0;
    while (true) {
      bool1 = bool2;
      if (b < arrayList.size()) {
        if (str.equals(((ac)arrayList.get(b)).aew().getIdentifier())) {
          arrayList.set(b, paramac);
          bool1 = true;
          break;
        } 
        b++;
        continue;
      } 
      break;
    } 
    if (!bool1)
      arrayList.add(paramac); 
    ak(arrayList);
    return true;
  }
  
  public String p(s params) {
    String str2 = params.getIdentifier();
    if (this.cMk.containsKey(str2))
      return (String)this.cMk.get(str2); 
    ArrayList arrayList = afs();
    if (arrayList != null)
      for (ac ac : arrayList)
        this.cMk.put(ac.aew().getIdentifier(), ac.aew().getName());  
    if (this.cMk.containsKey(str2))
      return (String)this.cMk.get(str2); 
    String str1 = q(params);
    this.cMk.put(str2, str1);
    return str1;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */