package com.laiqian.ui;

import android.view.View;
import android.widget.LinearLayout;

public class h {
  private final LinearLayout dwc;
  
  private final a dwd;
  
  public h(LinearLayout paramLinearLayout, a parama) {
    if (paramLinearLayout == null)
      throw new NullPointerException("container cannot be null"); 
    this.dwc = paramLinearLayout;
    this.dwd = parama;
  }
  
  private void kC(int paramInt) {
    int i = aqO();
    paramInt = 0;
    if (i == 1) {
      if (this.dwd.dwe != 0) {
        dp(0).setBackgroundResource(this.dwd.dwe);
        return;
      } 
    } else {
      while (paramInt < i) {
        if (paramInt == 0) {
          if (this.dwd.dwf != 0)
            dp(paramInt).setBackgroundResource(this.dwd.dwf); 
        } else if (paramInt == i - 1) {
          if (this.dwd.dwg != 0)
            dp(paramInt).setBackgroundResource(this.dwd.dwg); 
        } else if (this.dwd.background != 0) {
          dp(paramInt).setBackgroundResource(this.dwd.background);
        } 
        paramInt++;
      } 
    } 
  }
  
  public void addView(View paramView) {
    if (this.dwd.dwi != null) {
      this.dwc.addView(paramView, this.dwd.dwi);
    } else {
      this.dwc.addView(paramView);
    } 
    kC(aqO() - 1);
  }
  
  public int aqO() { return this.dwc.getChildCount(); }
  
  public void aqP() { this.dwc.removeAllViews(); }
  
  public View dp(int paramInt) { return this.dwc.getChildAt(paramInt); }
  
  public static class a {
    public final int background;
    
    public final int dwe;
    
    public final int dwf;
    
    public final int dwg;
    
    public final int dwh;
    
    public final LinearLayout.LayoutParams dwi;
    
    private a(a param1a) {
      this.dwe = a.a(param1a);
      this.dwf = a.b(param1a);
      this.dwg = a.c(param1a);
      this.background = a.d(param1a);
      this.dwh = a.e(param1a);
      this.dwi = a.f(param1a);
    }
    
    public static class a {
      private int background;
      
      private int dwe;
      
      private int dwf;
      
      private int dwg;
      
      private int dwh;
      
      private LinearLayout.LayoutParams dwi;
      
      public h.a aqQ() { return new h.a(this, null); }
      
      public a b(LinearLayout.LayoutParams param2LayoutParams) {
        this.dwi = param2LayoutParams;
        return this;
      }
      
      public a kD(int param2Int) {
        this.dwe = param2Int;
        return this;
      }
      
      public a kE(int param2Int) {
        this.dwf = param2Int;
        return this;
      }
      
      public a kF(int param2Int) {
        this.dwg = param2Int;
        return this;
      }
      
      public a kG(int param2Int) {
        this.background = param2Int;
        return this;
      }
      
      public a kH(int param2Int) {
        this.dwh = param2Int;
        return this;
      }
    }
  }
  
  public static class a {
    private int background;
    
    private int dwe;
    
    private int dwf;
    
    private int dwg;
    
    private int dwh;
    
    private LinearLayout.LayoutParams dwi;
    
    public h.a aqQ() { return new h.a(this, null); }
    
    public a b(LinearLayout.LayoutParams param1LayoutParams) {
      this.dwi = param1LayoutParams;
      return this;
    }
    
    public a kD(int param1Int) {
      this.dwe = param1Int;
      return this;
    }
    
    public a kE(int param1Int) {
      this.dwf = param1Int;
      return this;
    }
    
    public a kF(int param1Int) {
      this.dwg = param1Int;
      return this;
    }
    
    public a kG(int param1Int) {
      this.background = param1Int;
      return this;
    }
    
    public a kH(int param1Int) {
      this.dwh = param1Int;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */