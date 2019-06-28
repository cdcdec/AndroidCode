package com.laiqian.print.model;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.Layout;
import java.util.ArrayList;
import java.util.HashMap;

public class PrintContent {
  private int cGA = 1;
  
  private boolean cGB = true;
  
  private boolean cGC = true;
  
  private boolean cGD = true;
  
  private final ArrayList<b> cGy = new ArrayList();
  
  private final HashMap<String, String> cGz = new HashMap();
  
  private int height = 0;
  
  private int width = 0;
  
  public ArrayList<b> Xi() { return this.cGy; }
  
  public void aI(String paramString1, String paramString2) { this.cGz.put(paramString1, paramString2); }
  
  public boolean agb() { return this.cGB; }
  
  public boolean agc() { return this.cGC; }
  
  public boolean agd() { return this.cGD; }
  
  public void b(b paramb) {
    if (paramb == null)
      return; 
    this.cGy.add(paramb);
  }
  
  public void f(Object paramObject, int paramInt1, int paramInt2) {
    paramObject = new b(paramObject, paramInt1, paramInt2);
    this.cGy.add(paramObject);
  }
  
  public void fO(boolean paramBoolean) { this.cGB = paramBoolean; }
  
  public int getCopies() { return this.cGA; }
  
  public int getHeight() { return this.height; }
  
  public int getWidth() { return this.width; }
  
  public String lm(String paramString) { return (String)this.cGz.get(paramString); }
  
  public void p(String paramString, int paramInt) {
    b b = new b(paramString, paramInt, true);
    this.cGy.add(b);
  }
  
  public void r(boolean paramBoolean1, boolean paramBoolean2) {
    this.cGC = paramBoolean1;
    this.cGD = paramBoolean2;
  }
  
  public void setCopies(int paramInt) { this.cGA = paramInt; }
  
  public void setHeight(int paramInt) { this.height = paramInt; }
  
  public void setWidth(int paramInt) { this.width = paramInt; }
  
  class PrintContent {}
  
  class PrintContent {}
  
  public static class a {
    private PrintContent cGE;
    
    private boolean cGF = false;
    
    private boolean cGG = true;
    
    private boolean cGH = false;
    
    private int height;
    
    private int width;
    
    public a() { this(new PrintContent(), true); }
    
    public a(PrintContent param1PrintContent, boolean param1Boolean) {
      this.cGE = param1PrintContent;
      this.cGG = param1Boolean;
      this.cGH = false;
      this.cGF = false;
    }
    
    public a a(Bitmap param1Bitmap, @IntAlign int param1Int) {
      byte b2 = 64;
      byte b1 = b2;
      switch (param1Int) {
        default:
          b1 = b2;
          break;
        case 2:
          b1 = 66;
          break;
        case 1:
          b1 = 65;
          break;
        case 0:
          break;
      } 
      this.cGE.f(param1Bitmap, b1, 2);
      this.cGF = true;
      return this;
    }
    
    public a aJ(String param1String1, String param1String2) {
      this.cGE.aI(param1String1, param1String2);
      return this;
    }
    
    public PrintContent afV() {
      if (this.cGG && this.cGF && !this.cGH)
        agf(); 
      this.cGE.fO(this.cGF);
      this.cGE.setWidth(this.width);
      this.cGE.setHeight(this.height);
      return this.cGE;
    }
    
    public a age() {
      this.cGE.f("", 0, 3);
      return this;
    }
    
    public a agf() {
      this.cGE.f("", 0, 4);
      this.cGH = true;
      return this;
    }
    
    public a agg() {
      this.cGE.f("", 0, 5);
      return this;
    }
    
    public a b(String param1String, boolean param1Boolean1, boolean param1Boolean2, @IntAlign int param1Int, boolean param1Boolean3, boolean param1Boolean4) {
      int k;
      int j;
      int i;
      int m = 0;
      if (param1Boolean1) {
        i = 4;
      } else {
        i = 0;
      } 
      if (param1Boolean2) {
        j = 8;
      } else {
        j = 0;
      } 
      if (param1Boolean3) {
        k = 16;
      } else {
        k = 0;
      } 
      if (param1Boolean4)
        m = 32; 
      this.cGE.p(param1String, param1Int + 0 + i + j + k + m);
      this.cGF = true;
      return this;
    }
    
    public a c(PrintContent.b param1b) {
      this.cGE.b(param1b);
      return this;
    }
    
    public a c(String param1String, boolean param1Boolean1, boolean param1Boolean2, int param1Int, boolean param1Boolean3, boolean param1Boolean4) {
      int k;
      int j;
      int i;
      int m = 0;
      if (param1Boolean1) {
        i = 4;
      } else {
        i = 0;
      } 
      if (param1Boolean2) {
        j = 8;
      } else {
        j = 0;
      } 
      if (param1Boolean3) {
        k = 16;
      } else {
        k = 0;
      } 
      if (param1Boolean4)
        m = 32; 
      this.cGE.p(param1String, param1Int + 0 + i + j + k + m + 1024);
      this.cGF = true;
      return this;
    }
    
    public a h(String param1String, @IntFontSize int param1Int1, @IntAlign int param1Int2) {
      switch (param1Int1) {
        default:
          return this;
        case 3:
          b(param1String, false, false, param1Int2, true, true);
          return this;
        case 2:
          b(param1String, false, false, param1Int2, true, false);
          return this;
        case 1:
          b(param1String, false, false, param1Int2, false, true);
          return this;
        case 0:
          break;
      } 
      b(param1String, false, false, param1Int2, false, false);
      return this;
    }
    
    public a ih(int param1Int) {
      this.cGE.setCopies(param1Int);
      return this;
    }
    
    public a ln(String param1String) {
      r(param1String, 0);
      return this;
    }
    
    public a lo(String param1String) { return c(param1String, false, false, 0, false, false); }
    
    public a q(String param1String, @IntFontSize int param1Int) {
      switch (param1Int) {
        default:
          return this;
        case 3:
          c(param1String, false, false, 0, true, true);
          return this;
        case 2:
          c(param1String, false, false, 0, true, false);
          return this;
        case 1:
          c(param1String, false, false, 0, false, true);
          return this;
        case 0:
          break;
      } 
      c(param1String, false, false, 0, false, false);
      return this;
    }
    
    public a r(String param1String, @IntFontSize int param1Int) {
      h(param1String, param1Int, 0);
      return this;
    }
    
    public a s(boolean param1Boolean1, boolean param1Boolean2) {
      this.cGE.r(param1Boolean1, param1Boolean2);
      return this;
    }
    
    public void setHeight(int param1Int) { this.height = param1Int; }
    
    public void setWidth(int param1Int) { this.width = param1Int; }
  }
  
  public static class b {
    public Object cGI;
    
    public int cGJ;
    
    public int type;
    
    public b(Object param1Object, int param1Int1, int param1Int2) {
      this.cGI = param1Object;
      this.cGJ = param1Int1;
      this.type = param1Int2;
    }
    
    public boolean agh() { return ((this.cGJ & 0x10) != 0); }
    
    public boolean agi() { return ((this.cGJ & 0x20) != 0); }
    
    public Layout.Alignment agj() {
      switch (this.cGJ & 0x3) {
        default:
          return Layout.Alignment.ALIGN_NORMAL;
        case 2:
          return Layout.Alignment.ALIGN_OPPOSITE;
        case 1:
          return Layout.Alignment.ALIGN_CENTER;
        case 0:
          break;
      } 
      return Layout.Alignment.ALIGN_NORMAL;
    }
    
    public boolean agk() { return (this.type == 3); }
    
    public boolean agl() { return (this.type == 2); }
    
    public boolean agm() { return (this.type == 6); }
    
    public boolean agn() { return (this.type == 4); }
    
    public boolean ago() { return (this.type == 5); }
    
    public boolean agp() { return ((this.cGJ & 0x400) != 0); }
    
    public boolean agq() { return (this.type == 7); }
    
    public int agr() { return this.cGJ; }
    
    @Nullable
    public Bitmap getBitmap() { return (agl() && this.cGI instanceof Bitmap) ? (Bitmap)this.cGI : null; }
    
    public String getString() { return (vS() && this.cGI instanceof String) ? (String)this.cGI : this.cGI.toString(); }
    
    public int getType() { return this.type; }
    
    public boolean isBold() { return ((this.cGJ & 0x4) != 0); }
    
    public boolean vS() { return (this.type == 1); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\PrintContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */