package com.laiqian.pos;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import com.laiqian.basic.RootApplication;
import com.laiqian.db.multidatabase.a.b;
import com.laiqian.sync.a.g;
import com.laiqian.sync.c.a;
import com.laiqian.sync.model.SyncProgessMessage;
import com.laiqian.sync.model.b;
import com.laiqian.util.logger.h;
import io.reactivex.g.a;
import java.util.Map;
import kotlin.k;

public class s {
  private Activity aAA;
  
  private long bJx = 0L;
  
  private final int cfd;
  
  private long cfe = 0L;
  
  public int cff = 0;
  
  private b cfn = null;
  
  private a cfo;
  
  public int message = 0;
  
  public int nProgress = 0;
  
  private g syncManager;
  
  public s(Activity paramActivity, int paramInt) {
    this.aAA = paramActivity;
    this.cfd = paramInt;
    this.syncManager = new g(this.aAA);
    this.syncManager.a(t.cfp);
    Zt();
  }
  
  private void Zp() { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield syncManager : Lcom/laiqian/sync/a/g;
    //   7: invokevirtual apy : ()Lcom/laiqian/sync/model/SyncProgessMessage;
    //   10: invokevirtual getProgress : ()I
    //   13: putfield nProgress : I
    //   16: aload_0
    //   17: aload_0
    //   18: getfield syncManager : Lcom/laiqian/sync/a/g;
    //   21: invokevirtual apy : ()Lcom/laiqian/sync/model/SyncProgessMessage;
    //   24: invokevirtual apH : ()I
    //   27: putfield cff : I
    //   30: aload_0
    //   31: aload_0
    //   32: getfield syncManager : Lcom/laiqian/sync/a/g;
    //   35: invokevirtual apy : ()Lcom/laiqian/sync/model/SyncProgessMessage;
    //   38: invokevirtual apI : ()I
    //   41: putfield message : I
    //   44: aload_0
    //   45: getfield nProgress : I
    //   48: istore_1
    //   49: getstatic com/laiqian/sync/model/SyncProgessMessage.COMPLETE : I
    //   52: istore_2
    //   53: iload_1
    //   54: iload_2
    //   55: if_icmple -> 61
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: aload_0
    //   62: getfield nProgress : I
    //   65: getstatic com/laiqian/sync/model/SyncProgessMessage.START : I
    //   68: if_icmpne -> 78
    //   71: aload_0
    //   72: invokevirtual Zq : ()V
    //   75: goto -> 157
    //   78: aload_0
    //   79: getfield nProgress : I
    //   82: getstatic com/laiqian/sync/model/SyncProgessMessage.COMPLETE : I
    //   85: if_icmpne -> 149
    //   88: aload_0
    //   89: invokevirtual Zr : ()V
    //   92: aload_0
    //   93: invokevirtual onStop : ()V
    //   96: aload_0
    //   97: getfield cff : I
    //   100: iconst_1
    //   101: if_icmpne -> 123
    //   104: aload_0
    //   105: getfield cfo : Lcom/laiqian/pos/s$a;
    //   108: ifnull -> 157
    //   111: aload_0
    //   112: getfield cfo : Lcom/laiqian/pos/s$a;
    //   115: invokeinterface onSuccess : ()V
    //   120: goto -> 157
    //   123: aload_0
    //   124: getfield cff : I
    //   127: ifne -> 157
    //   130: aload_0
    //   131: getfield cfo : Lcom/laiqian/pos/s$a;
    //   134: ifnull -> 157
    //   137: aload_0
    //   138: getfield cfo : Lcom/laiqian/pos/s$a;
    //   141: invokeinterface Qo : ()V
    //   146: goto -> 157
    //   149: aload_0
    //   150: aload_0
    //   151: getfield nProgress : I
    //   154: invokevirtual gH : (I)V
    //   157: aload_0
    //   158: monitorexit
    //   159: return
    //   160: astore_3
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_3
    //   164: athrow
    // Exception table:
    //   from	to	target	type
    //   2	53	160	finally
    //   61	75	160	finally
    //   78	120	160	finally
    //   123	146	160	finally
    //   149	157	160	finally }
  
  private void Zt() {
    IntentFilter intentFilter = new IntentFilter();
    this.cfn = new b(this, null);
    intentFilter.addAction("download_transaction");
    this.aAA.registerReceiver(this.cfn, intentFilter);
  }
  
  private void a(a parama) { dj.ciW.a(new v(parama)); }
  
  public void Zo() { a.aKh().r(new u(this)); }
  
  public void Zq() {}
  
  public void Zr() {
    this.cfo.fr(SyncProgessMessage.COMPLETE);
    this.syncManager.apy().gW(false);
  }
  
  public void Zw() {
    if (this.cfe < this.bJx) {
      Toast.makeText(this.aAA, "开始日期不能大于结束日期！", 0).show();
      return;
    } 
    this.syncManager.apy().init();
    this.cfo.fr(SyncProgessMessage.START);
    Zo();
  }
  
  public void b(a parama) { this.cfo = parama; }
  
  public void gH(int paramInt) { this.cfo.fr(paramInt); }
  
  public void onStop() {
    if (this.cfn != null)
      this.aAA.unregisterReceiver(this.cfn); 
    if (this.syncManager != null) {
      this.syncManager.close();
      this.syncManager = null;
    } 
  }
  
  public static interface a {
    void Qo();
    
    void fr(int param1Int);
    
    void onSuccess();
  }
  
  private class b extends BroadcastReceiver {
    private b(s this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      if (param1Intent.getAction().equals("download_transaction"))
        s.a(this.cfs); 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */