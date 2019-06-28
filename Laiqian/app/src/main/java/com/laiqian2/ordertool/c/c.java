package com.laiqian.ordertool.c;

import android.content.Context;
import com.laiqian.dcb.api.a.b;
import com.laiqian.ordertool.a.a;
import io.netty.channel.n;

public class c implements b {
  private a cel;
  
  private b cem;
  
  public c(int paramInt) {
    if (paramInt == 2) {
      this.cel = new h();
      return;
    } 
    if (paramInt == 0) {
      this.cel = new d();
      return;
    } 
    if (paramInt == 1) {
      m m = new m();
      this.cel = m;
      this.cem = m;
    } 
  }
  
  public void a(Context paramContext, String paramString, n paramn, int paramInt, b paramb) { this.cel.a(paramContext, paramString, paramn, paramInt, paramb); }
  
  public void a(Context paramContext, String paramString1, n paramn, int paramInt, String paramString2, b paramb) { this.cel.a(paramContext, paramString1, paramn, paramInt, paramString2, paramb); }
  
  public void a(Context paramContext, String paramString1, String paramString2, b paramb, n paramn) { this.cel.a(paramContext, paramString1, paramString2, paramb, paramn); }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, n paramn, int paramInt, long paramLong, b paramb) { this.cel.a(paramContext, paramString1, paramString2, paramString3, paramn, paramInt, paramLong, paramb); }
  
  public void a(StringBuffer paramStringBuffer, Context paramContext, boolean paramBoolean, String paramString, n paramn, int paramInt, a parama, b paramb) { this.cel.a(paramStringBuffer, paramContext, paramBoolean, paramString, paramn, paramInt, parama, paramb); }
  
  public void a(StringBuffer paramStringBuffer, boolean paramBoolean, String paramString, Context paramContext, n paramn, int paramInt, a parama, b paramb) { this.cel.a(paramStringBuffer, paramBoolean, paramString, paramContext, paramn, paramInt, parama, paramb); }
  
  public void b(Context paramContext, String paramString, n paramn, int paramInt, b paramb) { this.cel.b(paramContext, paramString, paramn, paramInt, paramb); }
  
  public void b(Context paramContext, String paramString1, n paramn, int paramInt, String paramString2, b paramb) { this.cem.b(paramContext, paramString1, paramn, paramInt, paramString2, paramb); }
  
  public void b(StringBuffer paramStringBuffer, boolean paramBoolean, String paramString, Context paramContext, n paramn, int paramInt, a parama, b paramb) { this.cel.b(paramStringBuffer, paramBoolean, paramString, paramContext, paramn, paramInt, parama, paramb); }
  
  public void c(Context paramContext, String paramString, n paramn, int paramInt, b paramb) { this.cel.c(paramContext, paramString, paramn, paramInt, paramb); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */