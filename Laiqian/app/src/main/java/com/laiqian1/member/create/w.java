package com.laiqian.member.create;

import android.app.DatePickerDialog;
import android.view.View;
import com.laiqian.entity.c;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class w implements View.OnClickListener {
  w(VipCreateDialog paramVipCreateDialog) {}
  
  public void onClick(View paramView) {
    null = Calendar.getInstance(Locale.CHINA);
    null.setTime(new Date());
    int i = null.get(1);
    int k = null.get(2);
    int m = null.get(5);
    String str = this.bxz.bvB.getText().toString().trim();
    int j = i;
    if (!"".equals(str)) {
      c.a a = c.cO(str);
      if (a.year > 0)
        i = a.year; 
      k = a.month;
      m = a.day;
      j = i;
    } 
    (new DatePickerDialog(VipCreateDialog.f(this.bxz), new x(this), j, k, m)).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */