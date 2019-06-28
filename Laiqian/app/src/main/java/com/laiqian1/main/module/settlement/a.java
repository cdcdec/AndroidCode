package com.laiqian.main.module.settlement;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.widget.EditText;
import android.widget.TextView;
import com.jakewharton.b.b;
import com.laiqian.main.b.c;
import com.laiqian.util.n;
import io.reactivex.c.g;
import io.reactivex.c.h;
import io.reactivex.c.o;

public class a {
  public static g<String> a(@NonNull Dialog paramDialog, EditText paramEditText, TextView paramTextView) { return new b(paramDialog, paramEditText, paramTextView); }
  
  public static g<Boolean> b(EditText paramEditText) { return new c(paramEditText); }
  
  public static class a extends Object implements o<c> {
    public boolean b(c param1c) throws Exception { return (param1c.view != null); }
  }
  
  public static class b extends Object implements h<Double, String> {
    public String f(Double param1Double) throws Exception { return n.e(Double.valueOf(param1Double.doubleValue())); }
  }
  
  public static class c extends Object implements h<Double, String> {
    b<Double> blN;
    
    public c(b<Double> param1b) { this.blN = param1b; }
    
    public String f(Double param1Double) throws Exception { return n.pi(((Double)this.blN.getValue()).toString()); }
  }
  
  public static class d extends Object implements h<Object, Boolean> {
    private b<Boolean> blN;
    
    public d(b<Boolean> param1b) { this.blN = param1b; }
    
    public Boolean aC(Object param1Object) throws Exception { return Boolean.valueOf(((Boolean)this.blN.getValue()).booleanValue()); }
  }
  
  public static class e extends Object implements h<String, Double> {
    public Double fc(String param1String) throws Exception { return Double.valueOf(Double.parseDouble(param1String)); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */