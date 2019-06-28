package com.laiqian.message;

import android.util.Log;
import com.alibaba.a.a.d.a.a;
import com.alibaba.a.a.d.b;
import com.alibaba.a.a.d.d.i;
import com.alibaba.a.a.d.d.j;
import com.alibaba.a.a.d.d.k;
import com.alibaba.a.a.d.d.l;
import com.alibaba.a.a.d.d.m;
import com.alibaba.a.a.d.e;
import com.google.a.a.a.a.a.a;
import hugo.weaving.DebugLog;

class b extends Object implements a<i, j> {
  b(a parama, String paramString, long paramLong) {}
  
  @DebugLog
  public void a(i parami, b paramb, e parame) {
    if (paramb != null)
      a.e(paramb); 
    if (parame != null) {
      Log.d("ErrorCode", parame.om());
      Log.d("RequestId", parame.on());
      Log.d("HostId", parame.oo());
      Log.d("RawMessage", parame.pr());
    } 
  }
  
  public void a(i parami, j paramj) {
    Log.d("AyncListObjects", "Success!");
    for (byte b1 = 0; b1 < paramj.pT().size(); b1++) {
      String str = ((k)paramj.pT().get(b1)).getKey();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("object: ");
      stringBuilder1.append(str);
      stringBuilder1.append(" ");
      stringBuilder1.append(((k)paramj.pT().get(b1)).pV());
      stringBuilder1.append(" ");
      stringBuilder1.append(((k)paramj.pT().get(b1)).pW());
      Log.d("AyncListObjects", stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.bIl);
      stringBuilder1.append("正在收取第 ");
      stringBuilder1.append(b1);
      stringBuilder1.append(" 条消息;");
      Log.d("消息获取", stringBuilder1.toString());
      this.bIn.T(this.bIl, str);
    } 
    long l = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bIl);
    stringBuilder.append("一共处理了");
    stringBuilder.append(paramj.pT().size());
    stringBuilder.append(" 条消息;");
    Log.d("消息处理条数", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.bIl);
    stringBuilder.append("共耗时 ");
    stringBuilder.append(l - this.bIm);
    stringBuilder.append("  ms;");
    Log.d("消息消耗时间", stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */