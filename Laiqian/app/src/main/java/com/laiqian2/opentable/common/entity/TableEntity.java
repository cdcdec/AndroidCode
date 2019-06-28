package com.laiqian.opentable.common.entity;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import com.laiqian.opentable.common.b;
import java.io.Serializable;
import java.util.ArrayList;

@Keep
public class TableEntity implements Serializable {
  public static final TableEntity bZK = new TableEntity(0L, false, false, 0L);
  
  private long aPs;
  
  private final long aSW;
  
  private long bLr;
  
  private String bTe;
  
  private boolean bZA;
  
  private int bZB;
  
  private boolean bZC;
  
  private String bZD;
  
  private String bZE;
  
  private int bZF;
  
  private long bZG;
  
  private c bZH;
  
  private ArrayList<c> bZI = new ArrayList();
  
  private boolean bZJ;
  
  private String bZc;
  
  private int bZz;
  
  private int state;
  
  public TableEntity(long paramLong1, int paramInt1, int paramInt2, long paramLong2) { this(paramLong1, 0L, null, 0, paramInt2, paramLong2, new c(false, "0", paramLong2, paramInt1, paramInt2, paramLong1)); }
  
  public TableEntity(long paramLong1, long paramLong2, String paramString, int paramInt) { this(paramLong1, paramLong2, paramString, paramInt, 0, 0L, new c(false, "0", 0L, false, false, 0L)); }
  
  @Deprecated
  public TableEntity(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2, long paramLong3) { this(paramLong1, paramLong2, paramString, paramInt1, paramInt2, paramLong3, new c(), null); }
  
  public TableEntity(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2, long paramLong3, @NonNull c paramc) {
    this(paramLong1, paramLong2, paramString, paramInt1, paramInt2, paramLong3, paramc, null);
    this.bZI = new b(this);
  }
  
  public TableEntity(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2, long paramLong3, @NonNull c paramc, @NonNull ArrayList<c> paramArrayList) { this(paramLong1, paramLong2, paramString, paramInt1, paramInt2, paramLong3, false, 0, false, null, null, 2, null, 0L, paramc, paramArrayList, false); }
  
  public TableEntity(long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, long paramLong3, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString2, String paramString3, int paramInt4, String paramString4, long paramLong4, c paramc, ArrayList<c> paramArrayList, boolean paramBoolean3) {
    this.aSW = paramLong1;
    this.bLr = paramLong2;
    this.bTe = paramString1;
    this.bZz = paramInt1;
    this.state = paramInt2;
    this.aPs = paramLong3;
    this.bZA = paramBoolean1;
    this.bZB = paramInt3;
    this.bZC = paramBoolean2;
    this.bZD = paramString2;
    this.bZE = paramString3;
    this.bZF = paramInt4;
    this.bZc = paramString4;
    this.bZG = paramLong4;
    this.bZH = paramc;
    this.bZI = paramArrayList;
    this.bZJ = paramBoolean3;
  }
  
  public TableEntity(TableEntity paramTableEntity) {
    this(paramTableEntity.aSW, paramTableEntity.bLr, paramTableEntity.bTe, paramTableEntity.bZz, paramTableEntity.state, paramTableEntity.aPs, paramTableEntity.bZA, paramTableEntity.bZB, paramTableEntity.bZC, paramTableEntity.bZD, paramTableEntity.bZE, paramTableEntity.bZF, paramTableEntity.bZc, paramTableEntity.bZG, null, (ArrayList)c.B(paramTableEntity.bZI), paramTableEntity.bZJ);
    for (c c1 : this.bZI) {
      if (c1.Yl() == paramTableEntity.bZH.Yl()) {
        this.bZH = c1;
        break;
      } 
    } 
  }
  
  public static boolean l(TableEntity paramTableEntity) { return (paramTableEntity.aSW == 0L); }
  
  public long DP() { return this.aPs; }
  
  public String Vz() { return this.bTe; }
  
  public void W(ArrayList<c> paramArrayList) { this.bZI = paramArrayList; }
  
  public String XX() { return this.bZc; }
  
  public long XY() { return this.bLr; }
  
  public int XZ() { return this.bZz; }
  
  public int Xy() { return this.bZF; }
  
  public boolean Ya() { return this.bZA; }
  
  public int Yb() { return b.R(this.bZI); }
  
  public TableEntity Yc() {
    c(new c(false, "0", 0L, false, false, 0L));
    W(null);
    cf(0L);
    setState(0);
    gw(2);
    eG(false);
    return this;
  }
  
  public boolean Yd() { return this.bZC; }
  
  public String Ye() { return this.bZD; }
  
  public String Yf() { return this.bZE; }
  
  public c Yg() {
    if (this.bZH == null)
      this.bZH = new c(); 
    return this.bZH;
  }
  
  public ArrayList<c> Yh() {
    if (this.bZI == null)
      this.bZI = new ArrayList(); 
    return this.bZI;
  }
  
  public boolean Yi() { return this.bZJ; }
  
  public void c(c paramc) { this.bZH = paramc; }
  
  public void cf(long paramLong) { this.aPs = paramLong; }
  
  public void eE(boolean paramBoolean) { this.bZA = paramBoolean; }
  
  public void eF(boolean paramBoolean) { this.bZC = paramBoolean; }
  
  public void eG(boolean paramBoolean) { this.bZJ = paramBoolean; }
  
  public boolean equals(Object paramObject) {
    paramObject = (TableEntity)paramObject;
    return (this.bLr != paramObject.XY()) ? false : ((this.aPs != paramObject.DP()) ? false : ((this.state != paramObject.getState()) ? false : (!(this.bZC != paramObject.Yd()))));
  }
  
  public long getID() { return this.aSW; }
  
  public int getState() { return this.state; }
  
  public void gw(int paramInt) { this.bZF = paramInt; }
  
  public void jj(String paramString) { this.bZD = paramString; }
  
  public void jk(String paramString) { this.bZE = paramString; }
  
  public void jl(String paramString) { this.bZc = paramString; }
  
  public void setState(int paramInt) { this.state = paramInt; }
  
  class TableEntity {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\entity\TableEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */