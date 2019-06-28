package com.laiqian.opentable.pos;

import com.laiqian.opentable.a.b;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.ui.a.aq;
import com.laiqian.ui.a.ax;

class an extends Object implements aq.a<CharSequence> {
  an(ai paramai) {}
  
  public void a(aq paramaq, int paramInt, CharSequence paramCharSequence) {
    a a1 = (a)((ax)paramaq).getObject();
    if (paramInt == 0) {
      b b = ai.g(this.cbO);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a1.getId());
      stringBuilder.append("");
      b.at(stringBuilder.toString(), a1.XX());
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\pos\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */