package com.laiqian.main.module.settlement;

import android.widget.CheckBox;
import io.reactivex.h;
import io.reactivex.h.a;

public class cw {
  public static h<Boolean> a(CheckBox paramCheckBox, boolean paramBoolean) {
    a a = a.aKk();
    paramCheckBox.setOnCheckedChangeListener(new cx(a));
    return a;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */