package com.laiqian.util;

import android.widget.ImageView;
import com.d.a.b.c;
import com.d.a.b.c.b;
import com.d.a.b.c.c;
import com.d.a.b.d;
import com.d.a.b.f.a;
import com.d.a.c.a;
import com.d.a.c.e;
import com.laiqian.infrastructure.R;

public class aq {
  private static c.a dFz;
  
  public static void a(String paramString, ImageView paramImageView) { a(paramString, paramImageView, null); }
  
  public static void a(String paramString, ImageView paramImageView, a parama) { a(paramString, paramImageView, parama, 0); }
  
  public static void a(String paramString, ImageView paramImageView, a parama, int paramInt) {
    if (parama != null) {
      d.ayO().a(paramString, paramImageView, lv(paramInt), parama);
      return;
    } 
    d.ayO().a(paramString, paramImageView, lv(paramInt));
  }
  
  private static c lv(int paramInt) {
    if (dFz == null)
      dFz = (new c.a()).mr(R.drawable.loading_07).ms(R.drawable.cancel_sale_reaturn).mt(R.drawable.cancel_sale_reaturn).id(true).ie(true).if(true).a(new b(100)); 
    dFz.a(new c(paramInt));
    return dFz.ayN();
  }
  
  public static boolean qz(String paramString) {
    try {
      e.a(paramString, d.ayO().ayQ());
      a.a(paramString, d.ayO().ayR());
      return true;
    } catch (Exception paramString) {
      return false;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */