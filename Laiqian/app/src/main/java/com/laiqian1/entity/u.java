package com.laiqian.entity;

import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.a.g;
import java.util.ArrayList;
import java.util.Iterator;

public class u implements g.b {
  private final long aST;
  
  private String aSU;
  
  private boolean aSV;
  
  public u(long paramLong, String paramString) { this(paramLong, paramString, true); }
  
  public u(long paramLong, String paramString, boolean paramBoolean) {
    this.aST = paramLong;
    this.aSU = paramString;
    this.aSV = paramBoolean;
  }
  
  public static u FO() { return new u(86002L, RootApplication.zv().getString(R.string.pos_car_order), false); }
  
  public static u FP() { return new u(86003L, RootApplication.zv().getString(R.string.pos_table_order), false); }
  
  public static String al(long paramLong) { return (paramLong == 86001L) ? RootApplication.zv().getString(R.string.pos_telephone_order) : ((paramLong == 86002L) ? RootApplication.zv().getString(R.string.pos_car_order) : ((paramLong == 86003L) ? RootApplication.zv().getString(R.string.pos_table_order) : "")); }
  
  public static long am(long paramLong) { return (paramLong == 86001L) ? 5L : ((paramLong == 86002L) ? 8L : ((paramLong == 86003L) ? 0L : 9L)); }
  
  public static String an(long paramLong) { return (paramLong == 0L) ? null : ((paramLong == 86002L) ? "86002" : ((paramLong == 86003L) ? "86003" : ((paramLong == 86001L) ? "86001" : "86005"))); }
  
  public static ArrayList<String> i(ArrayList<u> paramArrayList) {
    ArrayList arrayList = new ArrayList();
    if (paramArrayList != null) {
      Iterator iterator = paramArrayList.iterator();
      while (iterator.hasNext())
        arrayList.add(((u)iterator.next()).FM()); 
    } 
    return arrayList;
  }
  
  public long AR() { return this.aST; }
  
  public CharSequence AS() { return this.aSU; }
  
  public CharSequence AT() { return this.aSU; }
  
  public long FK() { return this.aST; }
  
  public long FL() { return am(this.aST); }
  
  public String FM() { return this.aSU; }
  
  public boolean FN() { return this.aSV; }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof u))
      return false; 
    paramObject = (u)paramObject;
    return (FK() != paramObject.FK()) ? false : ((FN() != paramObject.FN()) ? false : FM().equals(paramObject.FM()));
  }
  
  public int hashCode() { throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n"); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entit\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */