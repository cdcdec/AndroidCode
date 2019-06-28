package com.laiqian.e.a;

import android.content.Context;
import android.os.Handler;
import com.laiqian.backup.ag;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.milestone.h;
import com.laiqian.pos.hardware.q;
import com.laiqian.util.am;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.bh;
import com.laiqian.util.bn;
import com.laiqian.util.n;
import com.laiqian.util.p;
import io.reactivex.g.a;
import java.io.File;
import java.util.HashMap;

public class f {
  private i aNy;
  
  private String aNz = "";
  
  private Context context;
  
  Handler handler = new h(this);
  
  public f(Context paramContext) { this.context = paramContext; }
  
  public f(Context paramContext, i parami) {
    this.aNy = parami;
    this.context = paramContext;
  }
  
  public void A(String paramString1, String paramString2) {
    g g = new g(this, paramString1, paramString2);
    a.aKh().r(g);
  }
  
  public String Dg() { return (bn.py(ag.yX()) < 20480.0D) ? "" : ag.M(this.context); }
  
  public void a(int paramInt, Handler paramHandler) {
    av av = new av(this.context);
    null = new HashMap();
    null.put("sUserPhone", av.Ea());
    null.put("sUserPassword", av.atr());
    null.put("nShopID", av.Tx());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    null.put("nDeleteType", stringBuilder.toString());
    String str = bh.a(q.clw, this.context, null);
    HashMap hashMap = au.qB(str);
    if (hashMap != null && hashMap.get("result") != null && "10000".equals(String.valueOf(hashMap.get("result"))) && ef(paramInt)) {
      bb.e("delete", "删除服务器数据成功");
      boolean bool = am.cE(a.aOz);
      b.Dr();
      if (bool) {
        paramHandler.sendEmptyMessage(3);
        if (paramInt == 0) {
          p.asF();
          return;
        } 
      } else {
        paramHandler.sendEmptyMessage(2);
        return;
      } 
    } else {
      if (str != null && "-1".equals(str)) {
        paramHandler.sendEmptyMessage(4);
        return;
      } 
      paramHandler.sendEmptyMessage(2);
    } 
  }
  
  public void a(String paramString1, String paramString2, Handler paramHandler) { // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: aload_3
    //   5: aload_2
    //   6: invokevirtual a : (Ljava/lang/String;Landroid/os/Handler;Ljava/lang/String;)Z
    //   9: pop
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally }
  
  public boolean a(String paramString1, Handler paramHandler, String paramString2) {
    String str = Dg();
    if ((new File(str)).exists()) {
      bb.e("delete", "备份成功");
      String str1 = this.aNz;
      String str2 = this.aNz;
      str1 = this.aNz;
      str2 = this.aNz;
      if (n.a(new String[] { paramString1 }, str1, str2, new String[] { str }) && n.a(new String[] { paramString2 }, str1, str2, new String[] { str })) {
        av av = new av(this.context);
        av.rr(paramString1);
        av.close();
        bb.e("delete", "发送邮件成功");
        paramHandler.sendEmptyMessage(0);
        return true;
      } 
      paramHandler.sendEmptyMessage(1);
      return false;
    } 
    paramHandler.sendEmptyMessage(1);
    return false;
  }
  
  public void cp(String paramString) { this.aNz = paramString; }
  
  public boolean ef(int paramInt) {
    av av = new av(this.context);
    if ((new h(this.context)).fX(paramInt)) {
      av.hy(true);
      av.close();
      bb.e("delete", "删除本地数据成功");
      return true;
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\e\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */