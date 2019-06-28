package com.laiqian.setting.a;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.jakewharton.b.b;
import com.jakewharton.b.c;
import com.laiqian.entity.k;
import com.laiqian.util.bd;
import io.reactivex.a.a;
import io.reactivex.android.b.a;
import io.reactivex.g.a;
import io.reactivex.h;
import io.reactivex.i;

public class a {
  public a cZY = new a();
  
  public b<Boolean> dnM;
  
  public b<Boolean> dnN;
  
  public b<Integer> dnO;
  
  public b<k> dnP;
  
  public b<k> dnQ = (this.dnP = (this.dnO = (this.dnN = (this.dnM = b.ak(Boolean.FALSE)).ak(Boolean.FALSE)).ak(Integer.valueOf(1))).ak(k.aSk)).ak(k.aSk);
  
  public c<a> dnR = c.wO();
  
  private Context mContext;
  
  public a(Context paramContext) {
    this.mContext = paramContext;
    api();
    apj();
  }
  
  private void api() {
    this.cZY.b(h.a(this.dnN, this.dnO, b.bfR).b(this.dnQ));
    this.cZY.b(h.a(this.dnP, this.dnQ, c.bfR).b(this.dnM));
  }
  
  private void apj() {
    this.cZY.b(h.a(d.bet).b(this.dnP));
    this.cZY.b(this.dnP.b(new e(this)));
  }
  
  public boolean apk() {
    try {
      bd.bH(this.mContext);
    } catch (Exception exception) {
      a.e(exception);
    } 
    return false;
  }
  
  public void clear() { this.cZY.clear(); }
  
  public void save() { this.cZY.b(h.a(new f(this)).d(a.aKh()).c(a.aJo()).b(new g(this))); }
  
  public enum a {
    dnT(true),
    dnU(2),
    dnV(3);
    
    private int value;
    
    a(int param1Int1) { this.value = param1Int1; }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */