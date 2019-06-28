package com.laiqian.entity;

import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.util.Log;
import com.laiqian.main.bb;
import java.util.ArrayList;

public class TakeOrderEntity extends bb {
  private double aJW;
  
  @PayTypes
  public String aVA = "";
  
  private double aVB;
  
  public double aVC;
  
  public double aVD;
  
  public double aVE;
  
  private double aVF;
  
  private String aVG;
  
  private String aVH;
  
  private String aVI;
  
  private int aVJ;
  
  private String aVK;
  
  private String aVL;
  
  private String aVM;
  
  private long aVN;
  
  private String aVO;
  
  private String aVP;
  
  private int aVQ;
  
  private String aVR;
  
  public long aVS;
  
  public Double aVT;
  
  public long aVU;
  
  public Double aVV;
  
  private long aVW;
  
  @Nullable
  public String aVX;
  
  @Nullable
  public int aVY = -1;
  
  private double aVZ;
  
  private String aVo;
  
  private String aVp;
  
  private String aVq;
  
  private String aVr;
  
  private String aVs;
  
  private String aVt;
  
  private String aVu;
  
  private String aVv;
  
  private String aVw;
  
  private String aVx;
  
  private String aVy;
  
  public double aVz;
  
  public boolean aWa;
  
  public ArrayList<Pair<String, Double>> aWb;
  
  public int aWc = 0;
  
  public String aWd = "";
  
  public int aWe = 0;
  
  public a aWf;
  
  private String address;
  
  public String billNumber;
  
  private double deliverAmount;
  
  public double deliverBaseAmount;
  
  public String deliverTaxName;
  
  private String discountMessage;
  
  private double dishwareAmount;
  
  public double dishwareBaseAmount;
  
  public String dishwareTaxName;
  
  private String id;
  
  private String name;
  
  private String note;
  
  public String number;
  
  public String serviceTaxName;
  
  private long timestamp;
  
  @OrderTypes
  private String type = "weixin";
  
  public TakeOrderEntity(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, ArrayList<aa> paramArrayList, String paramString8, long paramLong1, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, double paramDouble1, String paramString17, double paramDouble2, double paramDouble3, String paramString18, String paramString19, long paramLong2, String paramString20, long paramLong3, double paramDouble4, long paramLong4, double paramDouble5, long paramLong5, aq paramaq, String paramString21) {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramArrayList, paramString8, paramLong1, paramString9, "", paramString10, paramString11, paramString12, paramString13, paramString14, paramString15, paramString16, paramDouble1, paramString17, paramDouble2, paramDouble3, paramString18, "", "", "", 0.0D, 0.0D, 0, "", paramString19, "", paramLong2, paramString20, "", "", paramLong3, paramDouble4, paramLong4, paramDouble5, paramLong5, paramaq, paramString21);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("recevied=");
    stringBuilder.append(paramDouble2);
    Log.d("TakeOrderEntity", stringBuilder.toString());
  }
  
  public TakeOrderEntity(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, ArrayList<aa> paramArrayList, String paramString8, long paramLong1, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, double paramDouble1, String paramString18, double paramDouble2, double paramDouble3, String paramString19, String paramString20, String paramString21, String paramString22, double paramDouble4, double paramDouble5, int paramInt, String paramString23, String paramString24, String paramString25, long paramLong2, String paramString26, String paramString27, String paramString28, long paramLong3, double paramDouble6, long paramLong4, double paramDouble7, long paramLong5, aq paramaq, String paramString29) {
    super(true, paramArrayList, 0.0D, 0.0D);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("recevied=");
    stringBuilder.append(paramDouble2);
    Log.d("TakeOrderEntity", stringBuilder.toString());
    this.type = paramString1;
    this.aVo = paramString2;
    this.id = paramString3;
    this.number = paramString4;
    this.address = paramString5;
    this.name = paramString6;
    this.aVp = paramString7;
    this.aVq = paramString8;
    this.timestamp = paramLong1;
    this.aVr = paramString9;
    this.note = paramString10;
    this.aVs = paramString11;
    this.aVt = paramString12;
    this.aVu = paramString13;
    this.aVv = paramString14;
    this.aVw = paramString15;
    this.aVx = paramString16;
    this.aVy = paramString17;
    this.aJW = paramDouble1;
    this.aVA = paramString18;
    this.aVB = paramDouble2;
    this.aVF = paramDouble3;
    this.aVG = paramString19;
    this.aVH = paramString20;
    this.discountMessage = paramString21;
    this.aVI = paramString22;
    this.dishwareAmount = paramDouble4;
    this.deliverAmount = paramDouble5;
    this.aVJ = paramInt;
    this.aVK = paramString23;
    this.aVL = paramString24;
    this.aVM = paramString25;
    this.aVN = paramLong2;
    this.aVO = paramString26;
    this.billNumber = paramString27;
    this.aVR = paramString28;
    this.aVS = paramLong3;
    this.aVT = Double.valueOf(paramDouble6);
    this.aVU = paramLong4;
    this.aVV = Double.valueOf(paramDouble7);
    this.aVW = paramLong5;
    this.vipEntity = paramaq;
    this.orderNo = paramString29;
  }
  
  public double AO() { return this.aJW; }
  
  public double IA() { return this.dishwareAmount; }
  
  public double IB() { return this.deliverAmount; }
  
  public String IC() { return this.aVK; }
  
  public String ID() { return this.aVL; }
  
  public String IE() { return this.aVM; }
  
  public long IF() { return this.aVN; }
  
  public String IG() { return this.aVO; }
  
  public String IH() { return this.aVP; }
  
  public String II() { return this.billNumber; }
  
  public String IJ() { return this.aVR; }
  
  public long IK() { return this.aVS; }
  
  public double IL() { return this.aVT.doubleValue(); }
  
  public long IM() { return this.aVU; }
  
  public double IN() { return this.aVV.doubleValue(); }
  
  public long IO() { return this.aVW; }
  
  public double IP() { return this.aVZ; }
  
  public a Ik() { return this.aWf; }
  
  public String Il() { return this.aVo; }
  
  public String Im() { return this.aVp; }
  
  public String In() { return this.aVq; }
  
  public String Io() { return this.aVr; }
  
  public String Ip() { return this.aVs; }
  
  public String Iq() { return this.aVt; }
  
  public String Ir() { return this.aVu; }
  
  public String Is() { return this.aVw; }
  
  public String It() { return this.aVx; }
  
  public String Iu() { return this.aVA; }
  
  public double Iv() { return this.aVB; }
  
  public double Iw() { return this.aVF; }
  
  public String Ix() { return this.aVG; }
  
  public String Iy() { return this.aVH; }
  
  public String Iz() { return this.discountMessage; }
  
  public void V(double paramDouble) { this.aVZ = paramDouble; }
  
  public void a(a parama) { this.aWf = parama; }
  
  public String dt(String paramString) {
    this.aVP = paramString;
    return paramString;
  }
  
  public void du(String paramString) { this.aVO = paramString; }
  
  public boolean dv(String paramString) { return ("meituan".equals(paramString) || "eleme".equals(paramString)); }
  
  public boolean dw(String paramString) { return "meituan".equals(paramString); }
  
  public void eF(int paramInt) { this.aVQ = paramInt; }
  
  public String getAddress() { return this.address; }
  
  public String getId() { return this.id; }
  
  public String getName() { return this.name; }
  
  public String getNote() { return this.note; }
  
  public String getNumber() { return this.number; }
  
  public String getSerialNumber() { return this.aVv; }
  
  public long getTimestamp() { return this.timestamp; }
  
  public String getType() { return this.type; }
  
  public aq getVipEntity() { return this.vipEntity; }
  
  public void setVipEntity(aq paramaq) { this.vipEntity = paramaq; }
  
  public String xq() { return this.orderNo; }
  
  public static @interface OrderTypes {}
  
  public static @interface PayTypes {}
  
  public static class a {
    public boolean aWg;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\TakeOrderEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */