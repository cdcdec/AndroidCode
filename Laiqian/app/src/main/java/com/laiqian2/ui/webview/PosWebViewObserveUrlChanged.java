package com.laiqian.ui.webview;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;

public class PosWebViewObserveUrlChanged extends PosWebViewLinearLayout {
  private a dEi;
  
  private ArrayList<String> dEj = new ArrayList();
  
  public PosWebViewObserveUrlChanged(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  private void A(String paramString, boolean paramBoolean) {
    super.pf(paramString);
    if (paramBoolean && !this.dEj.contains(paramString))
      this.dEj.add(paramString); 
    if (this.dEi != null)
      this.dEi.jC(paramString); 
  }
  
  public void a(a parama) { this.dEi = parama; }
  
  public boolean canGoBack() { return (this.dEj.size() > 1); }
  
  public void goBack() {
    this.dEj.remove(this.dEj.size() - 1);
    if (this.dEj.size() > 0)
      A((String)this.dEj.get(this.dEj.size() - 1), false); 
  }
  
  public void pf(String paramString) { A(paramString, true); }
  
  public static interface a {
    void jC(String param1String);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\webview\PosWebViewObserveUrlChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */