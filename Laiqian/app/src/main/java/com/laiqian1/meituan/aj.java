package com.laiqian.meituan;

import android.app.Activity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.s;

public class aj {
  public static final int aCt = R.layout.ui_titlebar;
  
  public LinearLayout bri;
  
  public Button brj;
  
  public Button brk;
  
  public Button brl;
  
  public TextView tvTitle;
  
  public aj(Activity paramActivity) {
    this.bri = (LinearLayout)s.a(paramActivity, R.id.ui_titlebar_back_btn);
    this.tvTitle = (TextView)s.a(paramActivity, R.id.ui_titlebar_txt);
    this.brj = (Button)s.a(paramActivity, R.id.ui_titlebar_help_btn);
    this.brk = (Button)s.a(paramActivity, R.id.ui_titlebar_help_btn2);
    this.brl = (Button)s.a(paramActivity, R.id.ui_titlebar_help_btn3);
  }
  
  public static aj l(Activity paramActivity) {
    paramActivity.getWindow().setFeatureInt(7, R.layout.meituan_titlebar);
    return new aj(paramActivity);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */