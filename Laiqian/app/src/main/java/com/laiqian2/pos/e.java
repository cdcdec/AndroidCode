package com.laiqian.pos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.db.multidatabase.a.b;
import com.laiqian.infrastructure.R;
import com.laiqian.sync.a.g;
import com.laiqian.sync.c.a;
import com.laiqian.sync.model.SyncProgessMessage;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.d;
import io.reactivex.g.a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.k;

public class e extends d {
  private static final String TAG = "e";
  
  private View aDI;
  
  private View aJv;
  
  private long bJx = 0L;
  
  private TextView cfa;
  
  private TextView cfb;
  
  private View cfc;
  
  private final int cfd;
  
  private long cfe = 0L;
  
  public int cff = 0;
  
  private b cfg = null;
  
  private a cfh;
  
  private Context mContext;
  
  private bb mWaitingDialog = null;
  
  public int message = 0;
  
  public int nProgress = 0;
  
  private g syncManager;
  
  static  {
  
  }
  
  protected e(Context paramContext, int paramInt1, @LayoutRes int paramInt2) {
    super(paramContext, paramInt2, R.style.pos_dialog);
    this.mContext = paramContext;
    this.cfd = paramInt1;
    this.syncManager = new g(this.mContext);
    this.syncManager.a(new h(this));
    xT();
    xU();
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
    //   75: goto -> 153
    //   78: aload_0
    //   79: getfield nProgress : I
    //   82: getstatic com/laiqian/sync/model/SyncProgessMessage.COMPLETE : I
    //   85: if_icmpne -> 145
    //   88: aload_0
    //   89: invokevirtual Zr : ()V
    //   92: aload_0
    //   93: getfield cff : I
    //   96: iconst_1
    //   97: if_icmpne -> 127
    //   100: aload_0
    //   101: invokevirtual Zs : ()V
    //   104: aload_0
    //   105: getfield cfh : Lcom/laiqian/pos/e$a;
    //   108: ifnull -> 120
    //   111: aload_0
    //   112: getfield cfh : Lcom/laiqian/pos/e$a;
    //   115: invokeinterface onSuccess : ()V
    //   120: aload_0
    //   121: invokevirtual dismiss : ()V
    //   124: goto -> 153
    //   127: aload_0
    //   128: getfield cff : I
    //   131: ifne -> 153
    //   134: aload_0
    //   135: aload_0
    //   136: getfield message : I
    //   139: invokevirtual gI : (I)V
    //   142: goto -> 153
    //   145: aload_0
    //   146: aload_0
    //   147: getfield nProgress : I
    //   150: invokevirtual gH : (I)V
    //   153: aload_0
    //   154: monitorexit
    //   155: return
    //   156: astore_3
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_3
    //   160: athrow
    // Exception table:
    //   from	to	target	type
    //   2	53	156	finally
    //   61	75	156	finally
    //   78	120	156	finally
    //   120	124	156	finally
    //   127	142	156	finally
    //   145	153	156	finally }
  
  private void Zt() {
    IntentFilter intentFilter = new IntentFilter();
    this.cfg = new b(this, null);
    intentFilter.addAction("download_transaction");
    this.mContext.registerReceiver(this.cfg, intentFilter);
  }
  
  private void a(a parama) { dj.ciW.a(new g(parama)); }
  
  private void gG(int paramInt) {
    if (this.mWaitingDialog == null) {
      this.mWaitingDialog = new bb(this.mContext);
      this.mWaitingDialog.setCancelable(false);
      bb bb1 = this.mWaitingDialog;
      this.syncManager.apy();
      bb1.c(true, SyncProgessMessage.START);
    } 
    int i = this.syncManager.apy().getProgress();
    this.syncManager.apy();
    if (i == SyncProgessMessage.COMPLETE) {
      if (this.mWaitingDialog != null)
        this.mWaitingDialog.dismiss(); 
      this.cfc.setVisibility(0);
      return;
    } 
    this.cfc.setVisibility(4);
    this.mWaitingDialog.c(true, paramInt);
    if (this.mWaitingDialog != null)
      this.mWaitingDialog.show(); 
  }
  
  private void n(String paramString, long paramLong) {
    this.bJx = paramLong;
    this.cfa.setText(paramString);
    this.cfa.setTag(Long.valueOf(paramLong));
  }
  
  private void o(String paramString, long paramLong) {
    this.cfe = paramLong;
    this.cfb.setText(paramString);
    this.cfb.setTag(Long.valueOf(paramLong));
  }
  
  private void xT() {
    this.cfc = findViewById(R.id.layTimeFrameId);
    this.cfa = (TextView)this.mView.findViewById(R.id.date_picker);
    this.cfb = (TextView)this.mView.findViewById(R.id.date_end_picker);
    this.aDI = this.mView.findViewById(R.id.sure);
    this.aJv = this.mView.findViewById(R.id.cancel);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.mContext.getString(R.string.pos_pos_SimpleDateFormatDay));
    Calendar calendar2 = Calendar.getInstance();
    calendar2.add(2, -1);
    Calendar calendar1 = Calendar.getInstance();
    Date date2 = calendar2.getTime();
    Date date1 = calendar1.getTime();
    this.cfa.setText(simpleDateFormat.format(date2));
    this.cfa.setTag(Long.valueOf(date2.getTime()));
    this.cfb.setText(simpleDateFormat.format(date1));
    this.cfb.setTag(Long.valueOf(date1.getTime()));
    this.bJx = date2.getTime();
    this.cfe = date1.getTime();
  }
  
  private void xU() {
    this.aJv.setOnClickListener(new l(this));
    this.aDI.setOnClickListener(new m(this));
    this.cfa.setOnClickListener(new n(this));
    this.cfb.setOnClickListener(new p(this));
  }
  
  public void Zo() { a.aKh().r(new f(this)); }
  
  public void Zq() {}
  
  public void Zr() {
    gG(SyncProgessMessage.COMPLETE);
    this.syncManager.apy().gW(false);
  }
  
  public void Zs() { Toast.makeText(this.mContext, this.mContext.getString(R.string.pos_download_transaction_data_success), 1).show(); }
  
  public void b(a parama) { this.cfh = parama; }
  
  public void cl(long paramLong) { this.cfe = paramLong; }
  
  public void cm(long paramLong) { this.bJx = paramLong; }
  
  public void gH(int paramInt) { gG(paramInt); }
  
  public void gI(int paramInt) { Toast.makeText(this.mContext, this.mContext.getString(R.string.pos_download_transaction_data_failure), 1).show(); }
  
  protected void onStart() {
    Zt();
    super.onStart();
  }
  
  public void onStop() {
    if (this.cfg != null)
      this.mContext.unregisterReceiver(this.cfg); 
    super.onStop();
    if (this.syncManager != null) {
      this.syncManager.close();
      this.syncManager = null;
    } 
  }
  
  public static interface a {
    void Zv();
    
    void onSuccess();
  }
  
  private class b extends BroadcastReceiver {
    private b(e this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      if (param1Intent.getAction().equals("download_transaction"))
        e.i(this.cfk); 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */