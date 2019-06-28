package com.laiqian.pos.industry.weiorder;

import android.graphics.Bitmap;
import com.bumptech.glide.g.a.c;
import com.bumptech.glide.g.b.c;
import com.laiqian.pos.dw;
import com.laiqian.util.ac;
import com.laiqian.util.bk;

class dg extends c<Bitmap> {
  dg(df paramdf) {}
  
  public void a(Bitmap paramBitmap, c<? super Bitmap> paramc) {
    String str = (new ac.a()).asP().u(paramBitmap);
    if (str == null || "".equals(str)) {
      bk.a(paramBitmap, this.cvs.context, 0.5F);
      return;
    } 
    df.a(this.cvs, str, dw.aR(this.cvs.context));
    this.cvs.cvo.setUrl(str);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */