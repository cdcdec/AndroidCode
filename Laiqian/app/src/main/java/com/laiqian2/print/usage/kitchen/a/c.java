package com.laiqian.print.usage.kitchen.a;

import android.support.annotation.NonNull;
import com.laiqian.print.printtype.f;
import com.laiqian.print.usage.a;
import com.laiqian.print.usage.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class c implements f, a, b, Serializable {
  private int cCC = 1;
  
  private int cMD = 4;
  
  private final Map<String, ArrayList<String>> cNf = new HashMap();
  
  private final Map<String, ArrayList<Long>> cNg = new HashMap();
  
  private boolean cNh = false;
  
  private boolean cNi = false;
  
  private int fontSize = 1;
  
  private int order = 2;
  
  private int width = 58;
  
  public static boolean iI(int paramInt) { return (paramInt >= 10 && paramInt <= 100); }
  
  public static boolean iJ(int paramInt) { return (paramInt > 0 && paramInt <= 10); }
  
  public static boolean iK(int paramInt) {
    boolean bool = true;
    if (paramInt != 1) {
      if (paramInt == 2)
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  public static boolean iL(int paramInt) { return (paramInt > 0 && paramInt <= 20); }
  
  public static boolean iV(int paramInt) {
    switch (paramInt) {
      default:
        return false;
      case 1:
      case 2:
        break;
    } 
    return true;
  }
  
  public void K(HashMap<String, ArrayList<String>> paramHashMap) {
    this.cNf.clear();
    this.cNf.putAll(paramHashMap);
  }
  
  public void L(HashMap<String, ArrayList<Long>> paramHashMap) {
    this.cNg.clear();
    this.cNg.putAll(paramHashMap);
  }
  
  public boolean aiD() { return this.cNi; }
  
  public Map<String, ArrayList<String>> aiE() { return this.cNf; }
  
  public Map<String, ArrayList<Long>> aiF() { return this.cNg; }
  
  public int aiG() { return this.fontSize; }
  
  public boolean aiH() { return this.cNh; }
  
  public int air() { return this.cMD; }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof c))
      return false; 
    paramObject = (c)paramObject;
    return (this.width != paramObject.width) ? false : ((this.cCC != paramObject.cCC) ? false : ((this.cMD != paramObject.cMD) ? false : ((this.cNh != paramObject.cNh) ? false : ((this.fontSize != paramObject.fontSize) ? false : (!(this.order != paramObject.order))))));
  }
  
  public void fY(boolean paramBoolean) { this.cNh = paramBoolean; }
  
  public void fZ(boolean paramBoolean) { this.cNi = paramBoolean; }
  
  public int getCopies() { return this.cCC; }
  
  public int getOrder() { return this.order; }
  
  public int getWidth() { return this.width; }
  
  public void iM(int paramInt) { this.cMD = paramInt; }
  
  public void iz(int paramInt) { this.fontSize = paramInt; }
  
  @NonNull
  public ArrayList<String> lX(String paramString) {
    ArrayList arrayList2 = (ArrayList)this.cNf.get(paramString);
    ArrayList arrayList1 = arrayList2;
    if (arrayList2 == null)
      arrayList1 = new ArrayList(); 
    return arrayList1;
  }
  
  public void setCopies(int paramInt) {
    if (!iJ(paramInt)) {
      this.cCC = 1;
      return;
    } 
    this.cCC = paramInt;
  }
  
  public void setOrder(int paramInt) { this.order = paramInt; }
  
  public void setWidth(int paramInt) { this.width = paramInt; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\kitchen\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */