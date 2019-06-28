package com.laiqian.message;

import android.content.Context;
import android.util.Log;
import com.alibaba.a.a.a.a.f;
import com.alibaba.a.a.a.c;
import com.alibaba.a.a.a.e;
import com.alibaba.a.a.c.a;
import com.alibaba.a.a.c.b;
import com.alibaba.a.a.c.d.b.a;
import com.alibaba.a.a.c.d.c;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.f.b;
import java.io.PrintStream;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
  private static h bIt;
  
  private a bIu;
  
  private String bIv;
  
  private Context mContext;
  
  private h(Context paramContext) {
    this.mContext = paramContext;
    f f = new f("fn9HIY3JEfBMpQin", "MLXX3WIuy1clKSfsX9cjQ6B8TG2836");
    this.bIu = new b(paramContext.getApplicationContext(), j.bIw.bIF, f);
  }
  
  protected static h aH(Context paramContext) { // Byte code:
    //   0: getstatic com/laiqian/message/h.bIt : Lcom/laiqian/message/h;
    //   3: ifnonnull -> 38
    //   6: ldc com/laiqian/message/h
    //   8: monitorenter
    //   9: getstatic com/laiqian/message/h.bIt : Lcom/laiqian/message/h;
    //   12: ifnonnull -> 26
    //   15: new com/laiqian/message/h
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/laiqian/message/h.bIt : Lcom/laiqian/message/h;
    //   26: ldc com/laiqian/message/h
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/laiqian/message/h
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/laiqian/message/h.bIt : Lcom/laiqian/message/h;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally }
  
  protected String Tp() { return this.bIv; }
  
  protected void c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) throws c, e {
    null = new a(Tp());
    c c = new c();
    c.Y(d(paramString2, paramString3, paramString4, paramString5));
    null.a(c);
    this.bIu.a(null);
    i.a a1 = RootApplication.zv().zB().gB("redis message");
    if (a1 != null)
      a1.aL(new Object()); 
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("发送消息的内容");
    stringBuilder.append(paramString4);
    printStream.println(stringBuilder.toString());
  }
  
  protected String d(String paramString1, String paramString2, String paramString3, String paramString4) {
    JSONObject jSONObject = new JSONObject();
    try {
      StringBuffer stringBuffer = new StringBuffer();
      jSONObject.put("fromDevice", paramString1);
      jSONObject.put("shopid", paramString2);
      jSONObject.put("content", paramString3);
      jSONObject.put("time", System.currentTimeMillis());
      jSONObject.put("version", paramString4);
      Log.e("buildMessage", jSONObject.toString());
      stringBuffer.append(b.encode(jSONObject.toString()));
      return stringBuffer.toString();
    } catch (JSONException paramString1) {
      a.e(paramString1);
    } catch (NumberFormatException paramString1) {
      a.e(paramString1);
    } catch (Exception paramString1) {
      a.e(paramString1);
    } 
    return null;
  }
  
  protected void gq(String paramString) { this.bIv = paramString; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */