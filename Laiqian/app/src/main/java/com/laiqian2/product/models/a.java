package com.laiqian.product.models;

import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.models.ab;
import com.laiqian.util.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends h {
  private String aTz = "";
  
  private JSONArray cUr;
  
  private JSONArray cUs;
  
  private ArrayList<h> cUt;
  
  public a(long paramLong1, String paramString1, String paramString2, double paramDouble1, int paramInt, long paramLong2, double paramDouble2, String paramString3) {
    super(paramLong1, paramString1, paramString2, paramDouble1, 0.0D, paramInt, paramLong2, "", paramDouble2, "", 0.0D);
    if (paramString3 != null && paramString3.length() > 2)
      try {
        this.cUr = new JSONArray(paramString3);
      } catch (Exception paramString1) {
        a.e(paramString1);
      }  
    if (this.cUr == null)
      this.cUr = new JSONArray(); 
    jw(2);
  }
  
  public void a(ab paramab, ArrayList<Long> paramArrayList1, ArrayList<String> paramArrayList2) {
    boolean bool;
    HashMap hashMap = new HashMap();
    if (paramab == null) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool)
      paramab = new ab(RootApplication.zv()); 
    this.cUt = paramab.a(paramArrayList1, paramArrayList2, hashMap);
    aks();
    aq(this.cUt);
    akt();
    if (!hashMap.isEmpty()) {
      n.println("商品名称被修改了,需要重新修改套餐");
      byte b;
      for (b = 0;; b++) {
        try {
          if (b < this.cUr.length()) {
            JSONArray jSONArray = this.cUr.getJSONObject(b).getJSONArray("products");
            byte b1;
            for (b1 = 0; b1 < jSONArray.length(); b1++) {
              JSONObject jSONObject = jSONArray.getJSONObject(b1);
              String str = (String)hashMap.get(Long.valueOf(jSONObject.getLong("nProductID")));
              if (str != null)
                jSONObject.put("sProductName", str); 
            } 
          } else {
            boolean bool1 = paramab.o(this.aSW, this.cUr.toString());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("商品名称被修改了,需要重新修改套餐，修改套餐是否成功：");
            stringBuilder.append(bool1);
            n.println(stringBuilder.toString());
            if (bool)
              paramab.close(); 
          } 
        } catch (Throwable paramArrayList1) {
          a.e(paramArrayList1);
          n.println("商品名称被修改了,需要重新修改套餐，修改套餐失败");
          if (bool)
            paramab.close(); 
        } 
      } 
    } 
    if (bool)
      paramab.close(); 
  }
  
  public boolean a(a parama) {
    try {
      JSONObject jSONObject = new JSONObject();
      JSONArray jSONArray = new JSONArray();
      int i = parama.cPh.length;
      for (byte b = 0; b < i; b++) {
        long l = parama.cPh[b];
        String str = parama.cPi[b];
        JSONObject jSONObject1 = new JSONObject();
        jSONObject1.put("nProductID", l);
        jSONObject1.put("sProductName", str);
        jSONArray.put(jSONObject1);
      } 
      jSONObject.put("products", jSONArray);
      jSONObject.put("nQuantity", i);
      jSONObject.put("nSelectedQuantity", parama.cUu);
      this.cUs.put(jSONObject);
      return true;
    } catch (Exception parama) {
      a.e(parama);
      return false;
    } 
  }
  
  public JSONArray ako() { return this.cUs; }
  
  public String akp() { return this.aTz; }
  
  public ArrayList<h> akq() { return this.cUt; }
  
  public int akr() { return this.cUr.length(); }
  
  public void aks() { this.cUs = new JSONArray(); }
  
  public String akt() { return this.cUs.toString(); }
  
  public void aku() {
    this.cUr = this.cUs;
    this.aTz = "";
  }
  
  public boolean aq(ArrayList<h> paramArrayList) {
    try {
      for (h h1 : paramArrayList) {
        JSONObject jSONObject1 = new JSONObject();
        jSONObject1.put("nProductID", h1.getID());
        jSONObject1.put("sProductName", h1.getName().substring(2, h1.getName().length()));
        jSONObject1.put("quantity", 1);
        jSONObject1.put("index", 1);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject1);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("products", jSONArray);
        jSONObject2.put("nQuantity", 1);
        jSONObject2.put("nSelectedQuantity", 1);
        this.cUs.put(jSONObject2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.aTz);
        stringBuilder.append(jSONObject1.get("sProductName"));
        stringBuilder.append(",");
        this.aTz = stringBuilder.toString();
      } 
      if (this.aTz.length() > 0)
        this.aTz.substring(0, this.aTz.length() - 1); 
      return true;
    } catch (Exception paramArrayList) {
      a.e(paramArrayList);
      return false;
    } 
  }
  
  public ArrayList<a> b(ab paramab) {
    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = new ArrayList();
    ArrayList arrayList3 = new ArrayList();
    byte b2 = 0;
    byte b1;
    for (b1 = 0; b2 < this.cUr.length(); b1 = b) {
      a a1 = jt(b2);
      byte b = b1;
      if (a1 != null) {
        if (a1.cPh.length == 1 && a1.cUu >= 1) {
          b = b1;
          if (b1 == 0) {
            byte b3 = 0;
            while (true) {
              b = b1;
              if (b3 < a1.cUu) {
                arrayList2.add(Long.valueOf(a1.cPh[0]));
                arrayList3.add(a1.cPi[0]);
                b3++;
                continue;
              } 
              break;
            } 
          } 
        } else {
          b = 1;
        } 
        arrayList1.add(a1);
      } 
      b2++;
    } 
    a(paramab, arrayList2, arrayList3);
    if (b1 != 0)
      return arrayList1; 
    if (this.cUt.size() > 0)
      return null; 
    arrayList1.clear();
    return arrayList1;
  }
  
  public a jt(int paramInt) {
    try {
      JSONObject jSONObject = this.cUr.getJSONObject(paramInt);
      JSONArray jSONArray = jSONObject.getJSONArray("products");
      int i = jSONArray.length();
      long[] arrayOfLong = new long[i];
      String[] arrayOfString = new String[i];
      for (paramInt = 0; paramInt < i; paramInt++) {
        JSONObject jSONObject1 = jSONArray.getJSONObject(paramInt);
        arrayOfLong[paramInt] = jSONObject1.getLong("nProductID");
        arrayOfString[paramInt] = jSONObject1.getString("sProductName");
      } 
      return new a(arrayOfLong, arrayOfString, jSONObject.getInt("nSelectedQuantity"));
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return null;
    } 
  }
  
  public static class a implements Serializable {
    public long[] cPh;
    
    public String[] cPi;
    
    public int cUu;
    
    public a(long[] param1ArrayOfLong, String[] param1ArrayOfString, int param1Int) {
      this.cPh = param1ArrayOfLong;
      this.cPi = param1ArrayOfString;
      this.cUu = param1Int;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\models\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */