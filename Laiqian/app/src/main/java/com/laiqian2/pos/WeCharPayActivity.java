package com.laiqian.pos;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.laiqian.c.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.setting.bf;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.n;
import com.laiqian.wallet.k;
import io.reactivex.android.b.a;
import io.reactivex.g.a;
import io.reactivex.n;

public class WeCharPayActivity extends ActivityRoot {
  private boolean aFB;
  
  private final int ceQ = 1;
  
  private TextView cfF;
  
  private final int cfG = 2;
  
  private boolean cfK;
  
  private void ZC() {
    null = findViewById(2131300018);
    if (!a.zR().At())
      null.setOnClickListener(new bf(this, com.laiqian.binding.BindingWechatHelp.class, this.aFB)); 
    TextView textView = (TextView)null.findViewById(2131300017);
    String str = getLaiqianPreferenceManager().FD();
    if (str == null) {
      textView.setText(2131627324);
    } else {
      textView.setText(str);
    } 
    View view = findViewById(2131300025);
    view.setOnClickListener(new du(this));
    this.cfF = (TextView)view.findViewById(2131300024);
    bd(2131300023, -16727543);
    gJ(a.AZ().Bq());
  }
  
  private void aaf() {
    if (this.cfK) {
      ZC();
      return;
    } 
    findViewById(2131300019).setVisibility(8);
  }
  
  private void bd(int paramInt1, int paramInt2) {
    Drawable drawable = findViewById(paramInt1).getBackground();
    if (drawable != null && drawable instanceof GradientDrawable)
      ((GradientDrawable)drawable).setColor(paramInt2); 
  }
  
  private void gJ(int paramInt) {
    String str;
    if (paramInt != 5) {
      switch (paramInt) {
        default:
          str = "";
          break;
        case 8:
          str = getString(2131628757);
          break;
        case 7:
          str = getString(2131627367);
          break;
      } 
    } else {
      str = getString(2131628757);
    } 
    this.cfF.setText(str);
    this.cfF.setTag(Integer.valueOf(paramInt));
  }
  
  public void finish() { super.finish(); }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
      return; 
    switch (paramInt1) {
      default:
        return;
      case 2:
        gJ(paramIntent.getIntExtra("code", 7));
        return;
      case 1:
        break;
    } 
    paramIntent.getIntExtra("code", 2);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131428197);
    setTitleTextView(2131627364);
    this.cfK = getResources().getBoolean(2131034136);
    this.aFB = "150001".equals(CrashApplication.getLaiqianPreferenceManager().atp());
    setTitleTextViewRightRefresh(getText(2131627745), true, new dr(this));
    aaf();
  }
  
  protected void onDestroy() { super.onDestroy(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\WeCharPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */