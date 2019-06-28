package com.laiqian.takeaway.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.d.a;
import com.laiqian.takeaway.R;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.w;
import com.laiqian.util.by;

public class SettingTakeAwayActivity extends ActivityRoot {
  private TextView cCd;
  
  private View dvm;
  
  public static void aV(Context paramContext) { paramContext.startActivity(new Intent(paramContext, SettingTakeAwayActivity.class)); }
  
  private void aig() {
    c c = new c(this);
    w w = new w(this, new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }, c, true);
    w.setTitle(getString(R.string.printer_usage_copies));
    w.show();
  }
  
  private void save() {
    int i = by.parseInt(this.cCd.getText().toString().trim());
    a.AZ().ea(i);
    Toast.makeText(this, R.string.pos_save_success, 0).show();
    finish();
  }
  
  public boolean beforeCloseActivity() {
    finish();
    return true;
  }
  
  public void kz(int paramInt) {
    TextView textView = this.cCd;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(++paramInt);
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    a.AZ().ea(paramInt);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(R.layout.activity_setting_take_away);
    setTitleTextViewHideRightView(R.string.pos_take_away_setting);
    setTitleTextViewRight(R.string.save, new a(this));
    this.dvm = findViewById(R.id.layout_phone_print_size);
    this.dvm.setBackgroundResource(R.drawable.selector_rounded_rectangle);
    this.dvm.setOnClickListener(new b(this));
    TextView textView = (TextView)this.dvm.findViewById(R.id.item_layout_tv_left);
    this.cCd = (TextView)this.dvm.findViewById(R.id.item_layout_tv_right);
    textView.setText(R.string.delivery_print_outs_copies);
    textView = this.cCd;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a.AZ().Cb());
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\setting\SettingTakeAwayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */