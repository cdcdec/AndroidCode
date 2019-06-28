package com.laiqian.setting;

import android.content.Intent;
import android.view.View;
import com.laiqian.util.av;

class z implements View.OnClickListener {
  z(OrderNoInput paramOrderNoInput) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent();
    OrderNoInput.a(this.dkD, OrderNoInput.b(this.dkD).getText().toString().trim());
    av av = new av(this.dkD);
    av.qP(OrderNoInput.c(this.dkD));
    av.close();
    this.dkD.setResult(-1, intent);
    this.dkD.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */