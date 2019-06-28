package com.laiqian.pos.model.orders;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.aq;
import com.laiqian.entity.z;
import com.laiqian.infrastructure.R;
import com.laiqian.models.n;
import com.laiqian.pos.dc;
import com.laiqian.product.models.p;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Keep
public class b {
  public static b cyT = new b();
  
  public boolean aTZ;
  
  public boolean aWa = false;
  
  public boolean aWg = false;
  
  @NonNull
  public final ArrayList<HashMap<String, Object>> bJf = new ArrayList();
  
  public long bbP;
  
  @NonNull
  public final ArrayList<z> bbS = new ArrayList();
  
  public int bbZ;
  
  public long bcf;
  
  public String bch;
  
  @Nullable
  public String billNumber;
  
  public Date bkf;
  
  public String ceV;
  
  @Nullable
  public Double ceX = null;
  
  @Nullable
  public dc ciN = null;
  
  public String coJ;
  
  public String coU;
  
  public String coV;
  
  public double cpa = 0.0D;
  
  public Double cyH;
  
  public Double cyI;
  
  public String cyJ;
  
  public double cyK;
  
  public double cyL = 0.0D;
  
  public double cyM = 0.0D;
  
  public final ArrayList<n> cyN = new ArrayList();
  
  public Double cyO;
  
  public Double cyP;
  
  @Nullable
  public Double cyQ = null;
  
  @NonNull
  public final ArrayList<p> cyR = new ArrayList();
  
  @Nullable
  public String cyS = null;
  
  public String cyU;
  
  public boolean cyV = false;
  
  public double cyW;
  
  public String openTableName;
  
  @Nullable
  public String orderNo;
  
  public aq vipEntity;
  
  static  {
    Date date = new Date(System.currentTimeMillis());
    Double double = Double.valueOf(578.38D);
    ArrayList arrayList = new ArrayList();
    HashMap hashMap1 = new HashMap();
    String str = RootApplication.zv().getString(R.string.pos_sample_product);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str);
    stringBuilder1.append("1");
    hashMap1.put("sProductName", stringBuilder1.toString());
    hashMap1.put("nProductQty", "13.263");
    hashMap1.put("fPrice", "150.00");
    hashMap1.put("fMemberPrice", "18.00");
    hashMap1.put("fAmount", "90");
    hashMap1.put("fOriginalPrice", "20");
    hashMap1.put("sProductType", "0");
    hashMap1.put("nProductType", "0");
    HashMap hashMap2 = new HashMap();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str);
    stringBuilder2.append("2");
    hashMap2.put("sProductName", stringBuilder2.toString());
    hashMap2.put("nProductQty", "15.656");
    hashMap2.put("fPrice", "20.00");
    hashMap2.put("fMemberPrice", "18.00");
    hashMap2.put("fAmount", "90");
    hashMap2.put("fOriginalPrice", "20");
    hashMap2.put("sProductType", "0");
    hashMap2.put("nProductType", "0");
    arrayList.add(hashMap1);
    arrayList.add(hashMap2);
    cyT.vipEntity = (new aq.a(1L, "00123", "13988888888")).IW();
    cyT.bkf = date;
    cyT.coJ = "8";
    cyT.cyJ = "10086";
    cyT.cyI = (cyT.cyH = Double.valueOf(578.38D)).valueOf(0.0D);
    cyT.cyP = double;
    cyT.cyO = double;
    cyT.bJf.addAll(arrayList);
    cyT.ceV = "137001";
    cyT.cyW = 31.919D;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SettleOrderDetail{items=");
    stringBuilder.append(this.bJf);
    stringBuilder.append(", time=");
    stringBuilder.append(this.bkf);
    stringBuilder.append(", operator='");
    stringBuilder.append(this.ceV);
    stringBuilder.append('\'');
    stringBuilder.append(", tableNumber='");
    stringBuilder.append(this.coJ);
    stringBuilder.append('\'');
    stringBuilder.append(", amount=");
    stringBuilder.append(this.cyH);
    stringBuilder.append(", discount=");
    stringBuilder.append(this.ceX);
    stringBuilder.append(", discountAmount=");
    stringBuilder.append(this.cyI);
    stringBuilder.append(", ownerName='");
    stringBuilder.append(this.cyJ);
    stringBuilder.append('\'');
    stringBuilder.append(", point=");
    stringBuilder.append(this.cyK);
    stringBuilder.append(", rounding=");
    stringBuilder.append(this.cyL);
    stringBuilder.append(", groupAmount=");
    stringBuilder.append(this.cyM);
    stringBuilder.append(", orderNo='");
    stringBuilder.append(this.orderNo);
    stringBuilder.append('\'');
    stringBuilder.append(", payTypeList=");
    stringBuilder.append(this.bbS);
    stringBuilder.append(", extraDiscounts=");
    stringBuilder.append(this.cyN);
    stringBuilder.append(", pointsChange=");
    stringBuilder.append(this.bbZ);
    stringBuilder.append(", actualReceive=");
    stringBuilder.append(this.cyO);
    stringBuilder.append(", shouldReceive=");
    stringBuilder.append(this.cyP);
    stringBuilder.append(", isReturn=");
    stringBuilder.append(this.aWa);
    stringBuilder.append(", isReprint=");
    stringBuilder.append(this.aWg);
    stringBuilder.append(", vipEntity=");
    stringBuilder.append(this.vipEntity);
    stringBuilder.append(", totalGst=");
    stringBuilder.append(this.cyQ);
    stringBuilder.append(", appliedTaxes=");
    stringBuilder.append(this.cyR);
    stringBuilder.append(", invoiceNo='");
    stringBuilder.append(this.cyS);
    stringBuilder.append('\'');
    stringBuilder.append(", reprintInfo=");
    stringBuilder.append(this.ciN);
    stringBuilder.append(", billNumber='");
    stringBuilder.append(this.billNumber);
    stringBuilder.append('\'');
    stringBuilder.append(", orderSource=");
    stringBuilder.append(this.bcf);
    stringBuilder.append(", actualPerson='");
    stringBuilder.append(this.bch);
    stringBuilder.append('\'');
    stringBuilder.append(", person='");
    stringBuilder.append(this.cyU);
    stringBuilder.append('\'');
    stringBuilder.append(", drawerName='");
    stringBuilder.append(this.coU);
    stringBuilder.append('\'');
    stringBuilder.append(", settlementName='");
    stringBuilder.append(this.coV);
    stringBuilder.append('\'');
    stringBuilder.append(", openTableName='");
    stringBuilder.append(this.openTableName);
    stringBuilder.append('\'');
    stringBuilder.append(", isPack=");
    stringBuilder.append(this.aTZ);
    stringBuilder.append(", serviceCharge=");
    stringBuilder.append(this.cpa);
    stringBuilder.append(", pendingOrderSettle=");
    stringBuilder.append(this.cyV);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\model\orders\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */