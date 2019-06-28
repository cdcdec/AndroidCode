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

public class AliPayActivity extends ActivityRoot {
  private boolean aFB;
  
  private boolean byz;
  
  private TextView ceP;
  
  private final int ceQ = 1;
  
  private void Zl() {
    this.aFB = "150001".equals(CrashApplication.getLaiqianPreferenceManager().atp());
    if (this.byz) {
      Zm();
      return;
    } 
    findViewById(2131296344).setVisibility(8);
  }
  
  private void Zm() {
    null = findViewById(2131296343);
    boolean bool = "5".equals(String.valueOf(a.AZ().Bp()));
    if (!a.zR().At()) {
      Class clazz;
      if (bool) {
        clazz = com.laiqian.binding.BindingAlipayHelp.class;
      } else {
        clazz = com.laiqian.binding.BindingAlipayCodeHelp.class;
      } 
      null.setOnClickListener(new bf(this, clazz, this.aFB));
    } 
    TextView textView = (TextView)null.findViewById(2131296342);
    String str = getLaiqianPreferenceManager().FC();
    if (str == null) {
      textView.setText(2131627324);
    } else {
      textView.setText(str);
    } 
    View view = findViewById(2131296347);
    view.setOnClickListener(new d(this));
    this.ceP = (TextView)view.findViewById(2131296346);
    bd(2131296345, -16733710);
    gF(a.AZ().Bo());
  }
  
  private void bd(int paramInt1, int paramInt2) {
    Drawable drawable = findViewById(paramInt1).getBackground();
    if (drawable != null && drawable instanceof GradientDrawable)
      ((GradientDrawable)drawable).setColor(paramInt2); 
  }
  
  private void gF(int paramInt) {
    String str;
    switch (paramInt) {
      default:
        str = "";
        break;
      case 2:
        str = getString(2131627310);
        break;
      case 1:
        str = getString(2131628757);
        break;
      case 0:
        str = getString(2131628757);
        break;
    } 
    this.ceP.setText(str);
    this.ceP.setTag(Integer.valueOf(paramInt));
  }
  
  public void finish() { super.finish(); }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
      return; 
    if (paramInt1 != 1)
      return; 
    gF(paramIntent.getIntExtra("code", 2));
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427463);
    setTitleTextView(2131627364);
    this.byz = getResources().getBoolean(2131034129);
    setTitleTextViewRightRefresh(getText(2131627745), true, new a(this));
    Zl();
  }
  
  protected void onDestroy() { super.onDestroy(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\AliPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */