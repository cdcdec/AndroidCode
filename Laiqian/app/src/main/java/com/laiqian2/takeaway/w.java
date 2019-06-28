package com.laiqian.takeaway;

import android.app.DatePickerDialog;
import android.content.Context;
import android.text.TextUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class w {
  private Context context;
  
  private int day;
  
  private al.c drQ;
  
  private DatePickerDialog.OnDateSetListener drR = new x(this);
  
  private int month;
  
  private int year;
  
  public w(Context paramContext, String paramString, al.c paramc) {
    this.context = paramContext;
    this.drQ = paramc;
    if (TextUtils.isEmpty(paramString)) {
      calendar = Calendar.getInstance(Locale.CHINA);
      calendar.setTime(new Date());
      this.year = calendar.get(1);
      this.month = calendar.get(2);
      this.day = calendar.get(5);
    } else {
      String[] arrayOfString = calendar.split("/");
      if (arrayOfString.length == 3) {
        this.year = Integer.parseInt(arrayOfString[0]);
        this.month = Integer.parseInt(arrayOfString[1]) - 1;
        this.day = Integer.parseInt(arrayOfString[2]);
      } 
    } 
    (new DatePickerDialog(paramContext, this.drR, this.year, this.month, this.day)).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */