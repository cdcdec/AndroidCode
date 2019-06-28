package com.laiqian.print.usage.tag.a;

import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import com.laiqian.print.printtype.f;
import com.laiqian.print.usage.a;
import com.laiqian.print.usage.b;
import com.laiqian.util.by;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class c implements f, a, b, Serializable {
  public static int cOl;
  
  public static int cOo;
  
  private Map<String, ArrayList<String>> cNf = new HashMap();
  
  private String cOf = RootApplication.zv().getString(R.string.printer_usage_bottom_value);
  
  private boolean cOg = true;
  
  private boolean cOh;
  
  public boolean cOi;
  
  public boolean cOj = true;
  
  public int cOk = 0;
  
  public int cOm = 1;
  
  int cOn = 0;
  
  public int cOp = 1;
  
  private int height = 30;
  
  private int width = 40;
  
  static  {
  
  }
  
  public static boolean bt(int paramInt1, int paramInt2) { return (paramInt1 >= 10 && paramInt1 <= 100 && paramInt2 >= 10 && paramInt2 <= 100); }
  
  public static boolean lT(String paramString) { return !(paramString == null); }
  
  public void M(HashMap<String, ArrayList<String>> paramHashMap) { this.cNf = paramHashMap; }
  
  public void aD(boolean paramBoolean) { this.cOg = paramBoolean; }
  
  public boolean aiT() { return this.cOi; }
  
  public boolean aiU() { return this.cOj; }
  
  public int aiV() { return this.cOk; }
  
  public String aiW() { return this.cOf; }
  
  public boolean aiX() { return this.cOg; }
  
  public boolean aiY() { return this.cOh; }
  
  public Map<String, ArrayList<String>> aiZ() { return this.cNf; }
  
  public int aja() { return this.cOn; }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof c))
      return false; 
    paramObject = (c)paramObject;
    return (this.width != paramObject.width) ? false : ((this.height != paramObject.height) ? false : (!by.bw(this.cOf, paramObject.cOf) ? false : ((this.cOg != paramObject.cOg) ? false : ((this.cOh != paramObject.cOh) ? false : ((this.cOj != paramObject.cOj) ? false : ((this.cOk != paramObject.cOk) ? false : ((this.cOi != paramObject.cOi) ? false : (!(this.cOn != paramObject.cOn)))))))));
  }
  
  public void ge(boolean paramBoolean) { this.cOj = paramBoolean; }
  
  public int getHeight() { return this.height; }
  
  public int getWidth() { return this.width; }
  
  public void gf(boolean paramBoolean) { this.cOi = paramBoolean; }
  
  public void gj(boolean paramBoolean) { this.cOh = paramBoolean; }
  
  public void ja(int paramInt) { this.cOk = paramInt; }
  
  public void jb(int paramInt) { this.cOn = paramInt; }
  
  public ArrayList<String> lX(String paramString) {
    if (this.cNf == null)
      this.cNf = new HashMap(); 
    return (ArrayList)this.cNf.get(paramString);
  }
  
  public void mb(String paramString) { this.cOf = paramString; }
  
  public void setSize(int paramInt1, int paramInt2) {
    this.width = paramInt1;
    this.height = paramInt2;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\tag\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */