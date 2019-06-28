package com.laiqian.message;

import android.content.Context;
import android.util.Log;
import c.h;
import c.n;
import com.alibaba.a.a.d.b;
import com.alibaba.a.a.d.b.a.f;
import com.alibaba.a.a.d.c;
import com.alibaba.a.a.d.d;
import com.alibaba.a.a.d.d.d;
import com.alibaba.a.a.d.d.g;
import com.alibaba.a.a.d.d.h;
import com.alibaba.a.a.d.d.i;
import com.alibaba.a.a.d.e;
import com.google.a.a.a.a.a.a;
import hugo.weaving.DebugLog;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class a {
  private static a bIe;
  
  private c bIf;
  
  private ArrayList<m.a> bIg = new ArrayList();
  
  private ArrayList<m.a> bIh = new ArrayList();
  
  private ArrayList<m.a> bIi = new ArrayList();
  
  private ArrayList<m.a> bIj = new ArrayList();
  
  private ArrayList<m.a> bIk = new ArrayList();
  
  private a(Context paramContext) {
    f f = new f("6ho3FpLmpmGxPqqu", "EQ4MSBh1srwRfxwTuPWN4oVO0pZBfW");
    this.bIf = new d(paramContext.getApplicationContext(), j.bIw.bID, f);
  }
  
  private void U(String paramString1, String paramString2) {
    if (paramString1.equals(j.bIw.bIx)) {
      a(paramString1, paramString2, this.bIg);
      return;
    } 
    if (paramString1.equals(j.bIw.bIB)) {
      a(paramString1, paramString2, this.bIh);
      return;
    } 
    if (paramString1.equals(j.bIw.bIC)) {
      a(paramString1, paramString2, this.bIi);
      return;
    } 
    if (paramString1.equals(j.bIw.bIy)) {
      a(paramString1, paramString2, this.bIj);
      return;
    } 
    if (paramString1.equals(j.bIw.bIz)) {
      a(paramString1, paramString2, this.bIk);
      return;
    } 
    if (paramString1.equals(j.bIw.bIA))
      a(paramString1, paramString2, this.bIk); 
  }
  
  private void a(String paramString1, String paramString2, ArrayList<m.a> paramArrayList) {
    for (m.a a1 : paramArrayList) {
      if (a1 != null)
        a1.H(paramString1, paramString2); 
    } 
  }
  
  public static a aG(Context paramContext) { // Byte code:
    //   0: ldc com/laiqian/message/a
    //   2: monitorenter
    //   3: getstatic com/laiqian/message/a.bIe : Lcom/laiqian/message/a;
    //   6: ifnonnull -> 29
    //   9: new com/laiqian/message/a
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/laiqian/message/a.bIe : Lcom/laiqian/message/a;
    //   20: getstatic com/laiqian/message/a.bIe : Lcom/laiqian/message/a;
    //   23: astore_0
    //   24: ldc com/laiqian/message/a
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: getstatic com/laiqian/message/a.bIe : Lcom/laiqian/message/a;
    //   32: astore_0
    //   33: ldc com/laiqian/message/a
    //   35: monitorexit
    //   36: aload_0
    //   37: areturn
    //   38: astore_0
    //   39: ldc com/laiqian/message/a
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Exception table:
    //   from	to	target	type
    //   3	24	38	finally
    //   29	33	38	finally }
  
  protected boolean T(String paramString1, String paramString2) {
    g g = new g(j.bIw.bIE, paramString2);
    try {
      h h = this.bIf.a(g);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("");
      stringBuilder1.append(h.getContentLength());
      Log.d("Content-Length", stringBuilder1.toString());
      h h1 = n.c(n.v(h.pO()));
      String str = h1.aUY();
      h1.close();
      PrintStream printStream = System.out;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("message content is:");
      stringBuilder2.append(str);
      printStream.println(stringBuilder2.toString());
      Log.d("ContentType", h.pN().getContentType());
      s(paramString1, paramString2, str);
      return true;
    } catch (IOException paramString1) {
      a.e(paramString1);
    } catch (b paramString1) {
      a.e(paramString1);
    } catch (e paramString1) {
      a.e(paramString1);
    } 
    return false;
  }
  
  protected void a(String paramString, m.a parama) {
    if (paramString.equals(j.bIw.bIx)) {
      this.bIg.add(parama);
      return;
    } 
    if (paramString.equals(j.bIw.bIB)) {
      this.bIh.add(parama);
      return;
    } 
    if (paramString.equals(j.bIw.bIC)) {
      this.bIi.add(parama);
      return;
    } 
    if (paramString.equals(j.bIw.bIy)) {
      this.bIj.add(parama);
      return;
    } 
    if (paramString.equals(j.bIw.bIz)) {
      this.bIk.add(parama);
      return;
    } 
    if (paramString.equals(j.bIw.bIA))
      this.bIk.add(parama); 
  }
  
  protected void b(String paramString, m.a parama) {
    if (paramString.equals(j.bIw.bIx)) {
      this.bIg.remove(parama);
      return;
    } 
    if (paramString.equals(j.bIw.bIB)) {
      this.bIh.remove(parama);
      return;
    } 
    if (paramString.equals(j.bIw.bIC)) {
      this.bIi.remove(parama);
      return;
    } 
    if (paramString.equals(j.bIw.bIy)) {
      this.bIj.remove(parama);
      return;
    } 
    if (paramString.equals(j.bIw.bIz)) {
      this.bIk.remove(parama);
      return;
    } 
    if (paramString.equals(j.bIw.bIA))
      this.bIk.remove(parama); 
  }
  
  @DebugLog
  public void go(String paramString) {
    String str = m.getPrefix(paramString);
    long l = System.currentTimeMillis();
    i i = new i(j.bIw.bIE, str, null, null, Integer.valueOf(10));
    this.bIf.a(i, new b(this, paramString, l)).pA();
  }
  
  protected void s(String paramString1, String paramString2, String paramString3) {
    d d = new d(j.bIw.bIE, paramString2);
    this.bIf.a(d, new c(this, paramString1, paramString3));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */