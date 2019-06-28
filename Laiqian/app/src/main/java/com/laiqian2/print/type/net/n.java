package com.laiqian.print.type.net;

import com.laiqian.print.model.e;
import com.orhanobut.logger.d;

class n implements e.a {
  n(l paraml, boolean paramBoolean) {}
  
  public void a(e parame, int paramInt) {
    if (parame.agu()) {
      String str;
      if (paramInt == 4) {
        str = "Success";
      } else {
        str = "Failed";
      } 
      d.b("change ip job ended, result: %s", new Object[] { str });
      if (paramInt == 4) {
        if (this.cLD.cLy != null)
          this.cLD.cLy.hM(0); 
      } else if (paramInt == 5 && this.cLD.cLy != null) {
        this.cLD.cLy.hM(4);
      } 
      if (this.cLC)
        this.cLD.b(this.cLD.cLz); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\net\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */