package com.laiqian.takeaway.miniprograms;

import android.graphics.Bitmap;
import com.bumptech.glide.g.a.c;
import com.bumptech.glide.g.b.c;
import com.laiqian.basic.RootApplication;

class c extends c<Bitmap> {
  c(WechatMiniProgramsActivity paramWechatMiniProgramsActivity, int paramInt) {}
  
  public void a(Bitmap paramBitmap, c<? super Bitmap> paramc) {
    n n1 = this.duf.due;
    n n2;
    n1.a(paramBitmap, (n2 = this.duf.due).v(RootApplication.zv(), this.dug));
    this.duf.dud.duk.setImageBitmap(paramBitmap);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\miniprograms\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */