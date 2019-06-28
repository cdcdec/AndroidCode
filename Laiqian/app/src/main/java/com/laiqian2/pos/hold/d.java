package com.laiqian.pos.hold;

import android.widget.Toast;
import com.laiqian.pos.model.a;
import com.laiqian.ui.a.r;

class d implements r.a {
  d(c paramc, String paramString, boolean paramBoolean) {}
  
  public void xD() {}
  
  public void xE() {
    a a1 = new a(this.cnp.cnm.getContext());
    byte b1;
    for (b1 = 0; b1 < this.cnn.length() && !Character.isDigit(this.cnn.charAt(b1)); b1++);
    byte b2;
    for (b2 = b1; b2 < this.cnn.length() && Character.isDigit(this.cnn.charAt(b2)); b2++);
    String str = a1.cu(Long.parseLong(this.cnn.substring(b1, b2)));
    a1.close();
    if (str == null) {
      Toast.makeText(this.cnp.cnm.getContext(), "Too much for the same table", 0).show();
    } else {
      this.cnp.cnm.cnl.b(str, this.cno, a.l(this.cnp.cnm));
    } 
    if (this.cnp.cnm.isShowing())
      this.cnp.cnm.dismiss(); 
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */