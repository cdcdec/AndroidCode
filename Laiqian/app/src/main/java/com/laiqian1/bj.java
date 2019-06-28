package com.laiqian;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.laiqian.alipay.a;
import com.laiqian.alipay.b.b;
import com.laiqian.entity.n;
import com.laiqian.models.be;
import io.reactivex.a.b;
import io.reactivex.android.b.a;
import io.reactivex.h;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class bj {
  private b aBK;
  
  public AtomicBoolean aBL = new AtomicBoolean(false);
  
  public a aBM = new bk(this);
  
  a aBN = new bl(this);
  
  Handler aBO = new bm(this);
  
  Handler aBP = new bo(this);
  
  a aBQ = new bp(this);
  
  Handler aBR = new bq(this);
  
  Handler aBS = new br(this);
  
  private n azm;
  
  private b azn;
  
  private Context mContext;
  
  protected n onlinePayEntity;
  
  public bj(Context paramContext, n paramn, n paramn1) {
    this.azm = paramn;
    this.mContext = paramContext;
    this.azn = b.xA();
    this.onlinePayEntity = paramn1;
  }
  
  public void E(long paramLong) {
    xw();
    h.f(paramLong, TimeUnit.MILLISECONDS).c(a.aJo()).c(new bn(this));
  }
  
  public void a(Context paramContext, HashMap<String, String> paramHashMap, String paramString) {
    this.azn.b(paramContext, paramHashMap, paramString, this.aBM);
    a(this.onlinePayEntity.xq(), this.azn);
    E(19000L);
  }
  
  public abstract void a(String paramString, b paramb);
  
  public abstract void b(Message paramMessage);
  
  public abstract void bc(String paramString);
  
  public abstract void bd(String paramString);
  
  public abstract void be(String paramString);
  
  public abstract void c(Message paramMessage);
  
  public abstract void d(Message paramMessage);
  
  public abstract void e(Message paramMessage);
  
  protected void g(int paramInt, String paramString) {
    if (this.onlinePayEntity.Fp() != null) {
      long l1 = System.currentTimeMillis();
      be be = new be(this.mContext);
      be.a(this.onlinePayEntity.Fq(), paramInt, paramString);
      be.close();
      long l2 = System.currentTimeMillis();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" ");
      stringBuilder.append(l2 - l1);
      stringBuilder.append(" ");
      Log.d("生成表的时间差", stringBuilder.toString());
    } 
  }
  
  public void stop() { this.azn.stop(); }
  
  public abstract void wQ();
  
  public void xw() {
    if (this.aBK != null && !this.aBK.wL())
      this.aBK.wK(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */