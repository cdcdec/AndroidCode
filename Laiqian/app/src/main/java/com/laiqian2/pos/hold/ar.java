package com.laiqian.pos.hold;

import com.laiqian.pos.model.a;
import com.laiqian.pos.settings.z;

class ar implements a.a {
  ar(aq paramaq) {}
  
  public void b(String paramString1, boolean paramBoolean, String paramString2) {
    long l;
    a a1 = new a(ai.j(this.cpY.cpW));
    if (paramBoolean) {
      l = 1L;
    } else {
      l = 0L;
    } 
    a1.c((ai.f(this.cpY.cpW)).orderNo, paramString1, l);
    a1.close();
    (ai.b(this.cpY.cpW)).cqd.setText(z.kF(String.format("%s: %s", new Object[] { this.cpY.cpW.getContext().getString(2131626872), paramString1 })));
    (ai.f(this.cpY.cpW)).coJ = paramString1;
    (ai.f(this.cpY.cpW)).aVN = l;
    (ai.k(this.cpY.cpW)).bXb.coJ = paramString1;
    (ai.k(this.cpY.cpW)).bXb.aVN = l;
    (ai.k(this.cpY.cpW)).bXb.coN = paramString2;
    ai.l(this.cpY.cpW).jH(paramString1);
  }
  
  public void onCancel() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */