package com.laiqian.entity;

import android.util.Pair;
import com.google.a.a.a.a.a.a;
import com.laiqian.d.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g implements Serializable, Cloneable {
  private String aRT = "";
  
  private double aRU = 100.0D;
  
  private double aRV = -1.0D;
  
  private Pair<Double, Double> aRW;
  
  private String aRX = "";
  
  private int aRY = 0;
  
  private boolean aRZ;
  
  private double aSa = 1.0D;
  
  private int aSb = 0;
  
  private long id;
  
  private int number;
  
  public g() {}
  
  public g(long paramLong, int paramInt, double paramDouble1, double paramDouble2, String paramString) {
    this.id = paramLong;
    this.number = paramInt;
    this.aRV = paramDouble1;
    this.aRU = paramDouble2;
    this.aRT = paramString;
  }
  
  public g(long paramLong, int paramInt1, double paramDouble1, double paramDouble2, String paramString, double paramDouble3, int paramInt2) {
    this.id = paramLong;
    this.number = paramInt1;
    this.aRV = paramDouble1;
    this.aRU = paramDouble2;
    this.aRT = paramString;
    this.aSa = paramDouble3;
    this.aRY = paramInt2;
  }
  
  public static List<g> a(JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
    ArrayList arrayList = new ArrayList();
    try {
      JSONArray jSONArray = paramJSONObject2.getJSONArray("levels");
      for (byte b = 0; b < jSONArray.length(); b++) {
        JSONObject jSONObject = jSONArray.getJSONObject(b);
        g g1 = new g();
        g1.cu(paramJSONObject1.optBoolean("open_member_auto_upgrade", true));
        g1.es(jSONObject.optInt("level_rank", -1));
        g1.ag(jSONObject.optLong("level_id", -1L));
        g1.cW(jSONObject.optString("level_name", "错误"));
        g1.k(jSONObject.optDouble("level_discount", 100.0D));
        g1.j(jSONObject.optDouble("level_require_amount", 0.0D));
        g1.i(jSONObject.optDouble("level_point_ratio", 1.0D));
        g1.i(jSONObject.optInt("level_upgrade_rule", 0));
        g1.et(jSONObject.optInt("level_status", 0));
        arrayList.add(g1);
      } 
    } catch (JSONException paramJSONObject1) {
      a.e(paramJSONObject1);
    } 
    return arrayList;
  }
  
  private void cu(boolean paramBoolean) { this.aRZ = paramBoolean; }
  
  public g EO() throws CloneNotSupportedException {
    try {
      return (g)super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      System.out.println(cloneNotSupportedException.toString());
      return null;
    } 
  }
  
  public double EP() { return this.aSa; }
  
  public boolean EQ() { return a.AZ().Bs(); }
  
  public Pair<Double, Double> ER() { return (this.aRW == null) ? a.AZ().Ce() : this.aRW; }
  
  public int ES() { return this.aRY; }
  
  public double ET() { return this.aRV; }
  
  public double EU() { return this.aRU; }
  
  public String EV() { return this.aRT; }
  
  public int EW() { return this.aSb; }
  
  public void ag(long paramLong) { this.id = paramLong; }
  
  public void cW(String paramString) { this.aRT = paramString; }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = (g)paramObject;
      return (this.number != paramObject.number) ? false : ((this.id != paramObject.id) ? false : ((Double.compare(paramObject.aRU, this.aRU) != 0) ? false : ((Double.compare(paramObject.aRV, this.aRV) != 0) ? false : ((this.aRY != paramObject.aRY) ? false : ((this.aRZ != paramObject.aRZ) ? false : ((Double.compare(paramObject.aSa, this.aSa) != 0) ? false : this.aRT.equals(paramObject.aRT)))))));
    } 
    return false;
  }
  
  public void er(int paramInt) { this.aRY = paramInt; }
  
  public void es(int paramInt) { this.number = paramInt; }
  
  public void et(int paramInt) { this.aSb = paramInt; }
  
  public long getId() { return this.id; }
  
  public int getNumber() { return this.number; }
  
  public int hashCode() { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n"); }
  
  public void i(double paramDouble) { this.aSa = paramDouble; }
  
  public void j(double paramDouble) { this.aRV = paramDouble; }
  
  public void k(double paramDouble) { this.aRU = paramDouble; }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MemberRankDiscount{number=");
    stringBuilder.append(this.number);
    stringBuilder.append(", id=");
    stringBuilder.append(this.id);
    stringBuilder.append(", rankName='");
    stringBuilder.append(this.aRT);
    stringBuilder.append('\'');
    stringBuilder.append(", rankDiscount=");
    stringBuilder.append(this.aRU);
    stringBuilder.append(", rankAmount=");
    stringBuilder.append(this.aRV);
    stringBuilder.append(", point=");
    stringBuilder.append(this.aRW);
    stringBuilder.append(", upgradeRuleStr='");
    stringBuilder.append(this.aRX);
    stringBuilder.append('\'');
    stringBuilder.append(", upgradeRuleType=");
    stringBuilder.append(this.aRY);
    stringBuilder.append(", autoUpgrade=");
    stringBuilder.append(this.aRZ);
    stringBuilder.append(", pointRatio=");
    stringBuilder.append(this.aSa);
    stringBuilder.append(", rankStatus=");
    stringBuilder.append(this.aSb);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */