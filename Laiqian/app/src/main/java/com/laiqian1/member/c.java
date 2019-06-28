package com.laiqian.member;

import android.app.DatePickerDialog;
import android.view.View;
import com.laiqian.entity.c;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class c implements View.OnClickListener {
  c(MemberChangeActivity paramMemberChangeActivity) {}
  
  public void onClick(View paramView) {
    null = Calendar.getInstance(Locale.CHINA);
    null.setTime(new Date());
    int i = null.get(1);
    int j = null.get(2);
    int i1 = null.get(5);
    String str = this.btq.bsz.getText().toString().trim();
    int k = i;
    int m = j;
    int n = i1;
    if (!"".equals(str)) {
      c.a a = c.cO(str);
      if (a.year > 0)
        i = a.year; 
      if (a.month > 0)
        j = a.month; 
      k = i;
      m = j;
      n = i1;
      if (a.day > 0) {
        n = a.day;
        m = j;
        k = i;
      } 
    } 
    (new DatePickerDialog(this.btq, new d(this), k, m, n)).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */