package com.laiqian.backup;

import android.app.TimePickerDialog;
import android.view.View;
import com.laiqian.util.av;

class q implements View.OnClickListener {
  q(BackUpSetting paramBackUpSetting) {}
  
  public void onClick(View paramView) {
    av av = new av(this.aIb);
    BackUpSetting.a(this.aIb, new BackUpSetting.a(this.aIb, null));
    BackUpSetting.a(this.aIb, av.aty());
    BackUpSetting.b(this.aIb, av.atz());
    (new TimePickerDialog(this.aIb, BackUpSetting.l(this.aIb), BackUpSetting.m(this.aIb), BackUpSetting.n(this.aIb), true)).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\backup\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */