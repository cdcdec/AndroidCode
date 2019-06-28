package com.laiqian.opentable.common.entity;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Keep
public class c extends Object implements Serializable, Comparable<c> {
  private long aPs = 0L;
  
  private int bXZ = 0;
  
  private int bZM = 0;
  
  private int bZN = 0;
  
  private String bZO = "0";
  
  private long bZP;
  
  private String orderNo = "0";
  
  private long tableID = 0L;
  
  public c() { this.bZP = 0L; }
  
  public c(int paramInt1, String paramString, long paramLong1, int paramInt2, int paramInt3, long paramLong2) { this.bZP = 0L; }
  
  public c(c paramc) {
    this(paramc.bXZ, paramc.orderNo, paramc.aPs, paramc.bZM, paramc.bZN, paramc.tableID);
    this.bZP = paramc.bZP;
  }
  
  public c(String paramString1, int paramInt1, String paramString2, long paramLong1, int paramInt2, int paramInt3, long paramLong2) { this.bZO = paramString1; }
  
  public static List<c> B(List<c> paramList) {
    if (paramList == null || paramList.size() == 0)
      return new ArrayList(); 
    ArrayList arrayList = new ArrayList(paramList.size());
    Iterator iterator = paramList.iterator();
    while (iterator.hasNext())
      arrayList.add(new c((c)iterator.next())); 
    return arrayList;
  }
  
  private static int compare(int paramInt1, int paramInt2) { return (paramInt1 < paramInt2) ? -1 : ((paramInt1 == paramInt2) ? 0 : 1); }
  
  public long DP() { return this.aPs; }
  
  public long Yj() { return this.bZP; }
  
  public String Yk() { return this.bZO; }
  
  public int Yl() { return this.bXZ; }
  
  public int Ym() { return this.bZM; }
  
  public int Yn() { return this.bZN; }
  
  public long Yo() { return this.tableID; }
  
  public void cf(long paramLong) { this.aPs = paramLong; }
  
  public void cg(long paramLong) { this.bZP = paramLong; }
  
  public void ch(long paramLong) { this.tableID = paramLong; }
  
  public int d(@NonNull c paramc) { return compare(this.bXZ, paramc.bXZ); }
  
  public void da(String paramString) { this.orderNo = paramString; }
  
  public void gx(int paramInt) { this.bXZ = paramInt; }
  
  public void gy(int paramInt) { this.bZM = paramInt; }
  
  public void gz(int paramInt) { this.bZN = paramInt; }
  
  public void jm(String paramString) { this.bZO = paramString; }
  
  public String xq() { return this.orderNo; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\entity\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */