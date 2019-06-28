package com.laiqian.pos;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.laiqian.entity.z;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class AliPayPreorderDetail {
  public static final AliPayPreorderDetail ceT = new AliPayPreorderDetail(-1);
  
  public static AliPayPreorderDetail ceU = new AliPayPreorderDetail();
  
  public double aJW;
  
  @NonNull
  public final ArrayList<HashMap<String, Object>> bJf = new ArrayList();
  
  @NonNull
  public final ArrayList<z> bbS = new ArrayList();
  
  public Date bkf;
  
  public String ceV;
  
  public Long ceW;
  
  @Nullable
  public Double ceX;
  
  public Bitmap ceY;
  
  public double ceZ;
  
  @PayType
  public int type;
  
  static  {
    ArrayList arrayList = new ArrayList();
    HashMap hashMap = new HashMap();
    if (Locale.getDefault().equals(Locale.CHINA)) {
      hashMap.put("sProductName", "支付宝测试");
    } else {
      hashMap.put("sProductName", "Alipay test");
    } 
    hashMap.put("nProductQty", "1");
    hashMap.put("fPrice", "0.01");
    hashMap.put("fAmount", "0.01");
    hashMap.put("fOriginalPrice", "0.01");
    arrayList.add(hashMap);
    ceU.bJf.addAll(arrayList);
    ceU.aJW = 0.01D;
    ceU.ceV = "137001";
    ceU.ceW = Long.valueOf(123L);
    ceU.bkf = new Date();
  }
  
  public AliPayPreorderDetail() {}
  
  public AliPayPreorderDetail(int paramInt) { this.type = paramInt; }
  
  public static boolean a(AliPayPreorderDetail paramAliPayPreorderDetail) { return (paramAliPayPreorderDetail.type == 0 || paramAliPayPreorderDetail.type == -1); }
  
  class AliPayPreorderDetail {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\AliPayPreorderDetail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */