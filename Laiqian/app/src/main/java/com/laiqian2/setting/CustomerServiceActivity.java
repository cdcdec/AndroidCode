package com.laiqian.setting;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.s;

public class CustomerServiceActivity extends ActivityRoot {
  private aa djL;
  
  private a djM;
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.djM = a.o(getWindow());
    this.djL = aa.M(this);
    this.djL.brj.setVisibility(8);
    this.djL.brk.setVisibility(8);
    this.djL.tvTitle.setText(2131624928);
    this.djM.bJv.setText(2131624927);
    if (CrashApplication.getLaiqianPreferenceManager().avF().equals("2")) {
      this.djM.csz.setImageResource(2131230994);
      return;
    } 
    this.djM.csz.setImageResource(2131230993);
  }
  
  private static class a {
    public View aQG;
    
    public TextView bJv;
    
    public ImageView csz;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.csz = (ImageView)s.z(param1View, 2131297328);
      this.bJv = (TextView)s.z(param1View, 2131299291);
    }
    
    public static a o(Window param1Window) {
      View view = View.inflate(param1Window.getContext(), 2131427368, null);
      param1Window.setContentView(view);
      return new a(view);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\CustomerServiceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */