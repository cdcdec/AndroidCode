package com.laiqian.ui.container;

import android.app.Activity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.s;

public class aa {
  public static final int aCt = R.layout.ui_titlebar;
  
  public ProgressBarCircularIndeterminate aNv;
  
  public LinearLayout bri;
  
  public Button brj;
  
  public Button brk;
  
  public ImageView cFF;
  
  public ProgressBarCircularIndeterminate dxN;
  
  public TextView tvTitle;
  
  public aa(Activity paramActivity) {
    this.bri = (LinearLayout)s.a(paramActivity, R.id.ui_titlebar_back_btn);
    this.tvTitle = (TextView)s.a(paramActivity, R.id.ui_titlebar_txt);
    this.brj = (Button)s.a(paramActivity, R.id.ui_titlebar_help_btn);
    this.brk = (Button)s.a(paramActivity, R.id.ui_titlebar_help_btn2);
    this.aNv = (ProgressBarCircularIndeterminate)s.a(paramActivity, R.id.ivProgress);
    this.dxN = (ProgressBarCircularIndeterminate)s.a(paramActivity, R.id.ivProgress2);
    this.cFF = (ImageView)s.a(paramActivity, R.id.iv_add);
  }
  
  public static aa M(Activity paramActivity) {
    paramActivity.getWindow().setFeatureInt(7, R.layout.ui_titlebar);
    return new aa(paramActivity);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */