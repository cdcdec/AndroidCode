package com.laiqian.sync.a;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;
import android.util.Log;
import com.a.a.b;
import com.google.a.a.a.a.a.a;
import com.laiqian.backup.ag;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.f.c;
import com.laiqian.k.a;
import com.laiqian.message.m;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.sync.b.b;
import com.laiqian.sync.c.a;
import com.laiqian.sync.c.b;
import com.laiqian.sync.model.SyncProgessMessage;
import com.laiqian.sync.model.h;
import com.laiqian.sync.model.i;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.bh;
import com.laiqian.util.l;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class g implements Closeable {
  private String TAG = "SyncManager";
  
  private i aZq;
  
  private final List<l> bIT = new ArrayList();
  
  Context context = null;
  
  private boolean doA;
  
  private Queue<a> doB = new ArrayBlockingQueue(2);
  
  Handler doC = new h(this);
  
  private SyncProgessMessage dox;
  
  private h doy;
  
  private e doz;
  
  public g(Context paramContext) {
    this.context = paramContext.getApplicationContext();
    this.doA = false;
    this.aZq = new i();
    this.dox = new SyncProgessMessage();
    this.doy = new h(paramContext);
    this.doz = new e(this.context);
    this.doz.b(this.doy);
    this.doz.a(this.dox);
    this.doz.a(this.aZq);
  }
  
  private void apB() {
    Iterator iterator = this.bIT.iterator();
    while (iterator.hasNext())
      ((l)iterator.next()).onSuccess(); 
  }
  
  private void apD() {
    apC();
    if (apy() == null) {
      SyncProgessMessage.doo = false;
    } else {
      apy().gW(false);
    } 
    if (this.doz != null)
      this.doz.gR(true); 
  }
  
  public boolean A(long paramLong1, long paramLong2) {
    ag.b(this.context, true);
    h h1 = this.doy;
    if (a.AZ().By()) {
      str = "t_product,t_string,t_food_table,t_order";
    } else {
      str = "t_string,t_food_table,t_order";
    } 
    h1.nR(str);
    this.doy.dk(paramLong1);
    this.doy.dl(paramLong2);
    this.doy.km(161);
    this.doy.nT(m.Tw());
    this.doy.ki(m.getDeviceType());
    this.doy.gX(false);
    this.doz.apr();
    this.dox.setProgress(SyncProgessMessage.dpb);
    b(this.dox);
    String str = this.TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a.AZ().By());
    stringBuilder.append("=>downloadShopMenuData tables=>");
    stringBuilder.append(this.doy.apJ());
    Log.i(str, stringBuilder.toString());
    if (!apA()) {
      this.dox.setProgress(SyncProgessMessage.COMPLETE);
      b(this.dox);
      return false;
    } 
    this.dox.setProgress(SyncProgessMessage.dpc);
    b(this.dox);
    Calendar calendar = Calendar.getInstance();
    calendar.set(calendar.get(1), calendar.get(2), 1);
    boolean bool = B(calendar.getTimeInMillis(), System.currentTimeMillis());
    if (!bool) {
      this.dox.setProgress(SyncProgessMessage.COMPLETE);
      b(this.dox);
      return false;
    } 
    this.dox.setProgress(SyncProgessMessage.COMPLETE);
    b(this.dox);
    apD();
    return bool;
  }
  
  public boolean B(long paramLong1, long paramLong2) {
    try {
      String str1 = b.bx(this.context);
      Context context1 = this.context;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append(this.doz.apt());
      stringBuilder1.append(this.doz.apw());
      String str2 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str1);
      stringBuilder2.append(this.doz.apt());
      b b = new b(context1, str2, stringBuilder2.toString(), b.aQf);
      str2 = this.TAG;
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("合并数据unzipped file  = ");
      stringBuilder2.append(str1);
      stringBuilder2.append(this.doz.apt());
      Log.e(str2, stringBuilder2.toString());
      if (b.aQh) {
        String str = this.doz.getUserID();
        long l = System.nanoTime();
        e e1 = this.doz;
        Context context2 = this.context;
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(str1);
        stringBuilder5.append(str);
        stringBuilder5.append(this.doz.apv());
        boolean bool = e1.a(paramLong1, paramLong2, context2, stringBuilder5.toString());
        str1 = this.TAG;
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("MergeDownloadedData result =  ");
        stringBuilder4.append(bool);
        Log.e(str1, stringBuilder4.toString());
        paramLong1 = System.nanoTime();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("time consumed by update tables :");
        stringBuilder3.append((paramLong1 - l) / 1000L);
        bb.f("tag", stringBuilder3.toString());
        if (bool)
          apB(); 
        return bool;
      } 
    } catch (Exception exception) {
      a.e(exception);
    } 
    return false;
  }
  
  public void a(@NonNull l paraml) { this.bIT.add(paraml); }
  
  public void a(boolean paramBoolean, String paramString, long paramLong1, long paramLong2) {
    if (this.doB.size() != 2)
      this.doB.add(new a(paramBoolean, paramString, paramLong1, paramLong2)); 
  }
  
  public i aW(String paramString1, String paramString2) {
    this.doy.km(161);
    this.doy.nX(paramString1);
    this.doy.setPassword(paramString2);
    this.doy.nR(a.dpz);
    this.doy.nT(m.Tw());
    this.doy.ki(m.getDeviceType());
    return this.doz.apq();
  }
  
  public boolean apA() {
    bb.fU("本次下载从下载服务器下载");
    String str1 = b.bx(this.context);
    String str2 = this.doz.apt();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("从下载服务器下载文件的请求地址是:");
    stringBuilder.append(this.doz.aps());
    bb.fU(stringBuilder.toString());
    return this.doz.f(this.doz.aps(), this.doz.getUserID(), str1, str2);
  }
  
  public void apC() {
    String str2 = (new av(this.context)).Tx();
    HashMap hashMap = new HashMap();
    hashMap.put("id", str2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    hashMap.put("time", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(RootUrlParameter.ckY);
    stringBuilder.append("/shop/synctimeupdate");
    String str1 = bh.a(stringBuilder.toString(), this.context, hashMap);
    if (str1 != null || !str1.equals("")) {
      bb.fU("发送同步时间到服务器成功");
      return;
    } 
    bb.fU("发送同步时间到服务器失败");
  }
  
  public i apx() { return this.aZq; }
  
  public SyncProgessMessage apy() { return this.dox; }
  
  public h apz() { return this.doy; }
  
  public void b(SyncProgessMessage paramSyncProgessMessage) {
    Intent intent = new Intent();
    intent.setAction(paramSyncProgessMessage.adA());
    if (paramSyncProgessMessage.adA() != null) {
      if (paramSyncProgessMessage.adA().equals(""))
        return; 
      this.context.sendBroadcast(intent);
      return;
    } 
  }
  
  public boolean b(i parami) {
    Log.e(this.TAG, "mergeDownloadedDataWhileLogin is in.");
    String str1 = b.bx(this.context);
    Context context1 = this.context;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str1);
    stringBuilder1.append(this.doz.apt());
    stringBuilder1.append(this.doz.apw());
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append(this.doz.apt());
    b b = new b(context1, str2, stringBuilder2.toString(), b.aQf);
    str2 = this.TAG;
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("unzipped file  = ");
    stringBuilder2.append(str1);
    stringBuilder2.append(this.doz.apt());
    Log.e(str2, stringBuilder2.toString());
    if (b.aQh) {
      String str4 = RootApplication.getLaiqianPreferenceManager().atm();
      c(parami);
      long l1 = System.nanoTime();
      Calendar calendar = Calendar.getInstance();
      calendar.set(calendar.get(1), calendar.get(2), 1);
      e e1 = this.doz;
      long l2 = calendar.getTimeInMillis();
      long l3 = System.currentTimeMillis();
      Context context2 = this.context;
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str1);
      stringBuilder2.append(str4);
      stringBuilder2.append(this.doz.apv());
      boolean bool = e1.a(l2, l3, context2, stringBuilder2.toString());
      String str3 = this.TAG;
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append("MergeDownloadedData result =  ");
      stringBuilder4.append(bool);
      Log.e(str3, stringBuilder4.toString());
      l2 = System.nanoTime();
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("time consumed by update tables :");
      stringBuilder3.append((l2 - l1) / 1000L);
      bb.f("tag", stringBuilder3.toString());
      apB();
      return bool;
    } 
    return false;
  }
  
  public boolean b(boolean paramBoolean, String paramString, long paramLong1, long paramLong2) {
    this.doy.nR(paramString);
    this.doy.dk(paramLong1);
    this.doy.dl(paramLong2);
    this.doy.km(13);
    this.doy.nT(m.Tw());
    this.doy.ki(m.getDeviceType());
    this.doz.nR(paramString);
    this.dox.km(13);
    this.dox.setProgress(SyncProgessMessage.doZ);
    b(this.dox);
    Pair pair = this.doz.gQ(paramBoolean);
    boolean bool1 = ((Boolean)pair.first).booleanValue();
    boolean bool = true;
    if (bool1) {
      paramBoolean = this.doz.b(paramBoolean, (List)pair.second);
      a.B(this.context, "sync");
    } else {
      this.dox.setResult(1);
      this.dox.kn(4001);
      paramBoolean = bool;
    } 
    this.dox.setProgress(SyncProgessMessage.COMPLETE);
    b(this.dox);
    apD();
    return paramBoolean;
  }
  
  public boolean c(i parami) {
    if (parami == null)
      return false; 
    try {
      av av = new av(this.context);
      av.qG(parami.getUserID());
      av.qD(parami.VC());
      av.close();
      return true;
    } catch (Exception parami) {
      a.e(parami);
      return false;
    } 
  }
  
  public boolean c(boolean paramBoolean, String paramString, long paramLong1, long paramLong2) {
    this.doy.nR(paramString);
    this.doy.dk(paramLong1);
    this.doy.dl(paramLong2);
    if ((new av(this.context)).ava())
      this.doy.gX(false); 
    Pair pair = this.doz.gQ(paramBoolean);
    if (((Boolean)pair.first).booleanValue()) {
      bb.fU("客户端有数据要上传.");
      this.doy.km(15);
      this.dox.setProgress(SyncProgessMessage.doZ);
      b(this.dox);
      if (this.doz.b(paramBoolean, (List)pair.second)) {
        bb.fU("客户端数据上传成功.");
        this.dox.setProgress(SyncProgessMessage.dpa);
        b(this.dox);
      } else {
        bb.fU("客户端数据上传失败.退出");
        this.dox.setProgress(SyncProgessMessage.COMPLETE);
        b(this.dox);
        a.B(this.context, "sync");
        apD();
        return false;
      } 
    } else {
      bb.fU("客户端无数据上传，直接开始下载");
      this.doy.km(14);
      this.doy.nR(a.dpz);
      a.start();
      this.aZq = this.doz.apr();
      a.bc("download_file", a.asv());
      if (this.aZq.apM()) {
        bb.fU("客户端请求服务器准备下载数据成功");
        this.dox.setResult(1);
        this.dox.setResult(4001);
        this.dox.setProgress(SyncProgessMessage.dpb);
        b(this.dox);
      } else {
        bb.fU("客户端请求服务器准备下载数据失败.退出");
        this.dox.setResult(0);
        this.dox.kn(this.aZq.apI());
        this.dox.setProgress(SyncProgessMessage.COMPLETE);
        b(this.dox);
        a.B(this.context, "sync");
        apD();
        return false;
      } 
    } 
    if (this.doy.apK()) {
      a.start();
      e(this.doC);
      return false;
    } 
    a.start();
    paramBoolean = apA();
    a.bc("download_file", a.asv());
    if (!paramBoolean) {
      this.dox.setProgress(SyncProgessMessage.COMPLETE);
      b(this.dox);
      apD();
      a.B(this.context, "sync");
      return false;
    } 
    this.dox.setProgress(SyncProgessMessage.dpc);
    b(this.dox);
    a.start();
    paramBoolean = B(paramLong1, paramLong2);
    a.bc("merge_file", a.asv());
    if (!paramBoolean) {
      this.dox.setProgress(SyncProgessMessage.COMPLETE);
      b(this.dox);
      a.B(this.context, "sync");
      apD();
      return false;
    } 
    this.dox.setProgress(SyncProgessMessage.dpd);
    b(this.dox);
    this.dox.setProgress(SyncProgessMessage.COMPLETE);
    b(this.dox);
    a.B(this.context, "sync");
    apD();
    return paramBoolean;
  }
  
  public void close() {
    if (this.aZq != null)
      this.aZq = null; 
    if (this.doy != null)
      this.doy = null; 
    if (this.dox != null)
      this.dox = null; 
    if (this.doz != null)
      this.doz = null; 
  }
  
  public boolean e(Handler paramHandler) {
    bb.fU("本次下载从OSS服务器下载");
    b b = new b(this.context);
    e e1 = new e(this.context);
    av av = new av(this.context);
    String str2 = b.bx(this.context);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(av.Ea());
    stringBuilder2.append("/template/");
    stringBuilder2.append(e1.apt());
    stringBuilder2.append(e1.apw());
    String str3 = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("下载文件目录是:");
    stringBuilder2.append(str3);
    bb.fU(stringBuilder2.toString());
    String str4 = RootApplication.getLaiqianPreferenceManager().atm();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(str2);
    stringBuilder3.append(str4);
    stringBuilder3.append(".download.lq");
    str4 = stringBuilder3.toString();
    boolean bool = b.a(paramHandler, b.afI, str3, str4, 5, true, c.D(e1.getUserID(), l.dj(Long.parseLong(e1.getUserID()))));
    String str1 = this.TAG;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("oss.BucketFile  = ");
    stringBuilder1.append(str3);
    Log.e(str1, stringBuilder1.toString());
    str1 = this.TAG;
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("oss.downloadFile  = ");
    stringBuilder1.append(str2);
    stringBuilder1.append(e1.apt());
    stringBuilder1.append(e1.apw());
    stringBuilder1.append(", result = ");
    stringBuilder1.append(bool);
    Log.e(str1, stringBuilder1.toString());
    return bool;
  }
  
  public boolean execute() {
    boolean bool;
    this.dox.km(13);
    this.dox.setProgress(SyncProgessMessage.doZ);
    b(this.dox);
    while (true) {
      bool = true;
      while (!this.doB.isEmpty()) {
        a a = (a)this.doB.poll();
        this.doz = new e(this.context);
        this.doz.b(this.doy);
        this.doz.a(this.dox);
        this.doz.a(this.aZq);
        this.doz.nR(a.cgt);
        this.doy.nR(a.cgt);
        this.doy.dk(a.bLj);
        this.doy.dl(a.bLk);
        this.doy.km(13);
        this.doy.nT(m.Tw());
        this.doy.ki(m.getDeviceType());
        Pair pair = this.doz.gQ(a.cOH);
        if (((Boolean)pair.first).booleanValue()) {
          bool = this.doz.b(a.cOH, (List)pair.second);
          a.B(this.context, "sync");
          continue;
        } 
        this.dox.setResult(1);
        this.dox.kn(4001);
      } 
      break;
    } 
    this.dox.setProgress(SyncProgessMessage.COMPLETE);
    b(this.dox);
    apD();
    return bool;
  }
  
  public boolean f(String paramString, long paramLong1, long paramLong2) {
    this.dox.setProgress(SyncProgessMessage.dpb);
    b(this.dox);
    ag.b(this.context, true);
    this.doy.nR(paramString);
    this.doy.dk(paramLong1);
    this.doy.dl(paramLong2);
    this.doy.km(163);
    this.doy.gX(false);
    this.doz.apr();
    this.dox.setProgress(SyncProgessMessage.dpb);
    b(this.dox);
    if (!apA()) {
      this.dox.setProgress(SyncProgessMessage.COMPLETE);
      b(this.dox);
      return false;
    } 
    this.dox.setProgress(SyncProgessMessage.dpc);
    b(this.dox);
    boolean bool = B(paramLong1, paramLong2);
    if (!bool) {
      this.dox.setProgress(SyncProgessMessage.COMPLETE);
      b(this.dox);
      return false;
    } 
    this.dox.setProgress(SyncProgessMessage.COMPLETE);
    b(this.dox);
    apD();
    return bool;
  }
  
  static class a {
    public long bLj;
    
    public long bLk;
    
    public boolean cOH;
    
    public String cgt;
    
    public a(boolean param1Boolean, String param1String, long param1Long1, long param1Long2) {
      this.cOH = param1Boolean;
      this.cgt = param1String;
      this.bLj = param1Long1;
      this.bLk = param1Long2;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */