package com.laiqian.rx.util;

import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.g;
import android.arch.lifecycle.h;
import android.util.Log;
import io.reactivex.a.b;
import io.reactivex.annotations.NonNull;
import io.reactivex.b.a;
import io.reactivex.b.b;
import io.reactivex.c.a;
import io.reactivex.c.g;
import io.reactivex.f.a;
import io.reactivex.internal.a.c;
import io.reactivex.internal.b.a;
import io.reactivex.internal.b.b;
import io.reactivex.l;
import java.util.concurrent.atomic.AtomicReference;

public final class LifecycleAwareObserver<T> extends AtomicReference<b> implements h, b, l<T> {
  final g dic;
  
  final g<? super T> did;
  
  final g<? super Throwable> die;
  
  final a dif;
  
  final g<? super b> dig;
  
  g.a dih = null;
  
  public LifecycleAwareObserver(g paramg, g.a parama, g<? super T> paramg1, g<? super Throwable> paramg2, a parama1, g<? super b> paramg3) {
    this.dic = paramg;
    this.did = paramg1;
    this.die = paramg2;
    this.dif = parama1;
    this.dig = paramg3;
    this.dih = parama;
  }
  
  public static <T> LifecycleAwareObserver<T> a(g paramg, g.a parama, g<? super T> paramg1) { return a(paramg, parama, paramg1, a.etp, a.etm, a.aJv()); }
  
  public static <T> LifecycleAwareObserver<T> a(g paramg, g.a parama, g<? super T> paramg1, g<? super Throwable> paramg2, a parama1, g<? super b> paramg3) {
    b.requireNonNull(paramg1, "onNext is null");
    b.requireNonNull(paramg2, "onError is null");
    b.requireNonNull(parama1, "onComplete is null");
    b.requireNonNull(paramg3, "onSubscribe is null");
    LifecycleAwareObserver lifecycleAwareObserver = new LifecycleAwareObserver(paramg, parama, paramg1, paramg2, parama1, paramg3);
    paramg.a(lifecycleAwareObserver);
    return lifecycleAwareObserver;
  }
  
  private void e(g.a parama) {
    if (parama == this.dih) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(toString());
      stringBuilder.append(" reached lifecycle event ");
      stringBuilder.append(parama);
      stringBuilder.append(", dispose");
      Log.d("LifecycleAwareObserver", stringBuilder.toString());
      wK();
    } 
  }
  
  public void a(@NonNull b paramb) {
    if (c.b(this, paramb))
      try {
        this.dig.accept(this);
        if (this.dic == null)
          throw new IllegalStateException("lifecycle is null"); 
        if (this.dih == null) {
          StringBuilder stringBuilder1;
          switch (d.bE[this.dic.L().ordinal()]) {
            case 4:
              this.dih = g.a.ON_DESTROY;
              break;
            case 3:
              this.dih = g.a.ON_STOP;
              break;
            case 2:
              this.dih = g.a.ON_PAUSE;
              break;
            case 1:
              this.dih = g.a.ON_DESTROY;
              break;
            default:
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append("lifecycle state is ");
              stringBuilder1.append(this.dic.L());
              throw new IllegalStateException(stringBuilder1.toString());
          } 
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("subscribed at ");
        stringBuilder.append(this.dic.L());
        stringBuilder.append(", should dipose at ");
        stringBuilder.append(this.dih);
        Log.d("LifecycleAwareObserver", stringBuilder.toString());
        return;
      } catch (Throwable throwable) {
        b.V(throwable);
        paramb.wK();
        f(throwable);
      }  
  }
  
  public void am(T paramT) {
    if (!wL())
      try {
        this.did.accept(paramT);
        return;
      } catch (Throwable paramT) {
        b.V(paramT);
        ((b)get()).wK();
        f(paramT);
      }  
  }
  
  public void f(Throwable paramThrowable) {
    if (!wL()) {
      lazySet(c.ete);
      try {
        this.die.accept(paramThrowable);
        return;
      } catch (Throwable throwable) {
        b.V(throwable);
        a.f(new a(new Throwable[] { paramThrowable, throwable }));
      } 
    } 
  }
  
  @OnLifecycleEvent(S = g.a.ON_CREATE)
  void onCreate() { e(g.a.ON_CREATE); }
  
  @OnLifecycleEvent(S = g.a.ON_DESTROY)
  void onDestroy() { e(g.a.ON_DESTROY); }
  
  @OnLifecycleEvent(S = g.a.ON_PAUSE)
  void onPause() { e(g.a.ON_PAUSE); }
  
  @OnLifecycleEvent(S = g.a.ON_RESUME)
  void onResume() { e(g.a.ON_RESUME); }
  
  @OnLifecycleEvent(S = g.a.ON_START)
  void onStart() { e(g.a.ON_START); }
  
  @OnLifecycleEvent(S = g.a.ON_STOP)
  void onStop() { e(g.a.ON_STOP); }
  
  public void wK() {
    this.dic.b(this);
    c.a(this);
  }
  
  public boolean wL() { return (get() == c.ete); }
  
  public void xx() {
    if (!wL()) {
      lazySet(c.ete);
      try {
        this.dif.run();
        return;
      } catch (Throwable throwable) {
        b.V(throwable);
        a.f(throwable);
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\r\\util\LifecycleAwareObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */