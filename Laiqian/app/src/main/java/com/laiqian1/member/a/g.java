package com.laiqian.member.a;

import android.text.Editable;
import android.text.TextWatcher;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.h;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class g implements TextWatcher {
  g(a parama) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramCharSequence);
    stringBuilder.append("");
    if (!by.isNull(stringBuilder.toString())) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramCharSequence);
      stringBuilder.append("");
      double d2 = by.parseDouble(stringBuilder.toString());
      double d1 = 0.0D;
      if (!LQKVersion.zl() || RootApplication.getLaiqianPreferenceManager().isMultipleShop()) {
        this.bwR.bwI.Rm();
        d1 = this.bwR.bwI.ak(d2);
      } else {
        h h = this.bwR.bwH.a(a.b(this.bwR), d2);
        String str = a.c(this.bwR).getString(R.string.pos_vip_charge_gift_product_none);
        paramCharSequence = str;
        if (h != null) {
          d2 = h.aSd;
          d1 = d2;
          paramCharSequence = str;
          if (this.bwR.bwH.bwL != null) {
            paramCharSequence = this.bwR.bwH.bwL.aVi.name;
            d1 = d2;
          } 
        } 
        a.a(this.bwR).setText(paramCharSequence);
      } 
      this.bwR.bww.setText(String.format("%s", new Object[] { n.a(this.bwR.getContext(), Double.valueOf(d1), true) }));
      return;
    } 
    this.bwR.bww.setText("");
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */