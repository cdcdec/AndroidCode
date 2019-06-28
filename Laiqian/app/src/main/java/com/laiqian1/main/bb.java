package com.laiqian.main;

import android.support.annotation.Nullable;
import com.laiqian.d.a;
import com.laiqian.entity.aa;
import com.laiqian.entity.aq;
import com.laiqian.entity.z;
import com.laiqian.product.models.p;
import com.laiqian.util.by;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bb {
  public boolean aTZ;
  
  public double amountRounding;
  
  private double amountServiceCharge;
  
  public long bbP;
  
  @Nullable
  public String bbQ;
  
  @Nullable
  public Long bbR;
  
  public final ArrayList<z> bbS = new ArrayList();
  
  public final ArrayList<aa> bbT;
  
  private HashMap<Long, p> bbU;
  
  public boolean bbV = true;
  
  public double bbW;
  
  private long bbX;
  
  public double bbY;
  
  public int bbZ;
  
  public double bca;
  
  public double bcb;
  
  private long bcd;
  
  public double bce;
  
  public long bcf;
  
  public long bcg;
  
  public String bch;
  
  public String bci;
  
  private boolean bcj;
  
  private double bck;
  
  private String bcl;
  
  public boolean bcm = true;
  
  public boolean bcn = true;
  
  public double bco;
  
  public int bcp;
  
  public String bcq;
  
  public boolean bcr = false;
  
  public boolean bcs = false;
  
  public boolean bct = false;
  
  public String bcu;
  
  @Nullable
  public String billNumber;
  
  public double deliverAmount;
  
  public double deliverBaseAmount;
  
  public String deliverTaxName;
  
  public double discount;
  
  public double discountAmount;
  
  public String discountMessage;
  
  public double dishwareAmount;
  
  public double dishwareBaseAmount;
  
  public String dishwareTaxName;
  
  public String headerText;
  
  public boolean isSaleOrder;
  
  public int numDecimal;
  
  public String openTableName;
  
  public String orderNo;
  
  public String sRefNo;
  
  private HashMap<Long, p> taxOfSettement;
  
  public aq vipEntity;
  
  public bb(boolean paramBoolean, List<aa> paramList, double paramDouble1, double paramDouble2) {
    this.isSaleOrder = paramBoolean;
    this.bbT = new ArrayList(paramList);
    this.bbW = paramDouble1;
    this.discount = paramDouble2;
    this.bbY = 0.0D;
    this.bcf = 0L;
    this.bcj = false;
    this.bcg = 0L;
  }
  
  public String BY() {
    if (this.bcl == null) {
      this.bcl = a.AZ().BY();
      if (by.isNull(this.bcl))
        return ""; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(");
      stringBuilder.append(this.bcl);
      stringBuilder.append(")");
      return stringBuilder.toString();
    } 
    return this.bcl;
  }
  
  public double GK() { return this.amountServiceCharge; }
  
  @Nullable
  public String II() { return this.billNumber; }
  
  @Nullable
  public HashMap<Long, p> LA() { return this.bbU; }
  
  public void LB() {
    this.bcd = System.currentTimeMillis();
    if (!this.bcj)
      this.bbX = this.bcd; 
    this.taxOfSettement = null;
    if (this.vipEntity != null) {
      aq aq1 = this.vipEntity;
      aq1.aWo -= this.bce;
      aq1 = this.vipEntity;
      aq1.aWp -= this.bbZ;
    } 
    this.bbZ = 0;
    this.bce = 0.0D;
  }
  
  public void Lc() {
    this.bcd = System.currentTimeMillis();
    if (!this.bcj)
      this.bbX = this.bcd; 
    this.bce = 0.0D;
    this.taxOfSettement = null;
  }
  
  public long Lx() {
    long l = this.bcd;
    this.bcd = l + 1L;
    return l;
  }
  
  public long Ly() { return this.bbX; }
  
  @Nullable
  public HashMap<Long, p> Lz() { return this.taxOfSettement; }
  
  public void X(double paramDouble) { this.bck = paramDouble; }
  
  public void Y(double paramDouble) { this.amountServiceCharge = paramDouble; }
  
  public void a(long paramLong, String paramString, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
    if (this.taxOfSettement == null)
      this.taxOfSettement = new HashMap(); 
    p p = (p)this.taxOfSettement.get(Long.valueOf(paramLong));
    if (p == null) {
      this.taxOfSettement.put(Long.valueOf(paramLong), new p(paramLong, paramString, paramDouble1, paramDouble2, paramDouble3, paramDouble4));
      return;
    } 
    p.a(paramDouble2, paramDouble3, paramDouble4);
  }
  
  public void az(long paramLong) {
    this.bbX = paramLong;
    this.bcj = true;
  }
  
  public void cb(String paramString) { this.bcl = paramString; }
  
  public double getNeglectSmallChanges() { return this.bck; }
  
  @Nullable
  public void l(HashMap<Long, p> paramHashMap) { this.taxOfSettement = paramHashMap; }
  
  @Nullable
  public void m(HashMap<Long, p> paramHashMap) { this.bbU = paramHashMap; }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("是否是销售单：");
    stringBuilder.append(this.isSaleOrder);
    stringBuilder.append("，商品数据：");
    stringBuilder.append(this.bbT);
    stringBuilder.append("，支付数据：");
    stringBuilder.append(this.bbS);
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */