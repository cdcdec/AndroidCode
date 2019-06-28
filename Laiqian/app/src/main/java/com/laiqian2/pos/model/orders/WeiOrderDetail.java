package com.laiqian.pos.model.orders;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.pos.industry.weiorder.eh;
import com.laiqian.product.models.p;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class WeiOrderDetail {
  public static WeiOrderDetail cyX = new WeiOrderDetail();
  
  public static WeiOrderDetail cyY;
  
  @Nullable
  public String aRu = null;
  
  @Nullable
  public String aTq = null;
  
  public long aVS;
  
  public Double aVT;
  
  public long aVU;
  
  public Double aVV;
  
  @Nullable
  public String aVX;
  
  @Nullable
  public int aVY = -1;
  
  public double aVZ = 0.0D;
  
  public boolean aWa = false;
  
  public int aWc = 0;
  
  public String address;
  
  @NonNull
  public final ArrayList<HashMap<String, Object>> bJf = new ArrayList();
  
  @Nullable
  public String ceV = null;
  
  public Double cpc;
  
  public eh cvD = null;
  
  public Double cyH;
  
  public double cyL = 0.0D;
  
  public boolean cyZ = false;
  
  public Date cza;
  
  public Date czb;
  
  public String czc;
  
  public int czd = 0;
  
  @Nullable
  public Double cze;
  
  @Nullable
  public Double czf;
  
  @NonNull
  public LinkedHashMap<String, Double> czg = new LinkedHashMap();
  
  public final ArrayList<p> czh = new ArrayList();
  
  @Nullable
  public String czi = null;
  
  @Nullable
  public String czj = null;
  
  @Nullable
  public long czk = 0L;
  
  @Nullable
  public String czl = null;
  
  public String czm = "";
  
  public double discountAmount = 0.0D;
  
  public String number;
  
  @Nullable
  public String orderNo;
  
  @PayTypes
  public int paytype = 0;
  
  public String text;
  
  @OrderTypes
  public int type = 1;
  
  static  {
    ArrayList arrayList = new ArrayList();
    HashMap hashMap = new HashMap();
    String str = CrashApplication.zv().getString(2131628158);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("1");
    hashMap.put("sProductName", stringBuilder.toString());
    hashMap.put("nProductQty", "5");
    hashMap.put("fPrice", "20.05");
    hashMap.put("fAmount", "100");
    hashMap.put("fOriginalPrice", "20");
    arrayList.add(hashMap);
    hashMap = new HashMap();
    stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("2");
    hashMap.put("sProductName", stringBuilder.toString());
    hashMap.put("nProductQty", "5");
    hashMap.put("fPrice", "20.05");
    hashMap.put("fAmount", "100");
    hashMap.put("fOriginalPrice", "20");
    arrayList.add(hashMap);
    cyX.bJf.addAll(arrayList);
    cyX.cza = new Date();
    cyX.czb = new Date();
    cyX.address = "MY HOME";
    cyX.czc = "123123123";
    cyX.number = "";
    cyX.cyH = Double.valueOf(202.5D);
    cyX.paytype = 3;
    cyX.discountAmount = 5.0D;
    cyY = new WeiOrderDetail();
    arrayList = new ArrayList();
    hashMap = new HashMap();
    str = CrashApplication.zv().getString(2131628158);
    stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("1");
    hashMap.put("sProductName", stringBuilder.toString());
    hashMap.put("nProductQty", "5");
    hashMap.put("fPrice", "20.05");
    hashMap.put("fAmount", "100");
    hashMap.put("fOriginalPrice", "20");
    arrayList.add(hashMap);
    hashMap = new HashMap();
    stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("2");
    hashMap.put("sProductName", stringBuilder.toString());
    hashMap.put("nProductQty", "5");
    hashMap.put("fPrice", "20.05");
    hashMap.put("fAmount", "100");
    hashMap.put("fOriginalPrice", "20");
    arrayList.add(hashMap);
    cyY.bJf.addAll(arrayList);
    cyY.cza = new Date();
    cyY.czb = new Date();
    cyY.address = "MY HOME";
    cyY.czc = "123123123";
    cyY.number = "";
    cyY.cyH = Double.valueOf(202.5D);
    cyY.paytype = 4;
    cyY.type = 4;
    cyY.discountAmount = 5.0D;
    cyY.aVX = "我";
    cyY.address = "那美克星";
    cyY.czg.put("赠送龙珠", Double.valueOf(0.0D));
    cyY.czg.put("优惠", Double.valueOf(-20.0D));
    cyY.cze = (cyY.czf = Double.valueOf(9.0D)).valueOf(1.0D);
  }
  
  class WeiOrderDetail {}
  
  class WeiOrderDetail {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\model\orders\WeiOrderDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */