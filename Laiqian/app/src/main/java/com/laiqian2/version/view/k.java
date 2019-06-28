package com.laiqian.version.view;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.infrastructure.R;

class k extends Handler {
  k(LegacyUpgradeAndEvaluate paramLegacyUpgradeAndEvaluate) {}
  
  public void handleMessage(Message paramMessage) {
    StringBuilder stringBuilder;
    TextView textView;
    LegacyUpgradeAndEvaluate.f(this.dKa).setVisibility(8);
    switch (paramMessage.what) {
      case 6:
        LegacyUpgradeAndEvaluate.g(this.dKa).setText(this.dKa.getString(R.string.pos_upgrade_no_new_version));
        LegacyUpgradeAndEvaluate.g(this.dKa).setTextColor(this.dKa.getResources().getColor(R.color.black));
        LegacyUpgradeAndEvaluate.h(this.dKa).setVisibility(0);
        LegacyUpgradeAndEvaluate.h(this.dKa).setOnClickListener(this.dKa.dIj);
        LegacyUpgradeAndEvaluate.h(this.dKa).setText(R.string.pos_upgrade_check);
        LegacyUpgradeAndEvaluate.j(this.dKa).setVisibility(8);
        LegacyUpgradeAndEvaluate.a(this.dKa).setVisibility(8);
        Toast.makeText(this.dKa.getBaseContext(), this.dKa.getString(R.string.pos_request_time), 0).show();
        break;
      case 5:
        textView = LegacyUpgradeAndEvaluate.g(this.dKa);
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.dKa.getString(R.string.pos_find_new_version));
        stringBuilder.append(":V");
        stringBuilder.append(LegacyUpgradeAndEvaluate.c(this.dKa));
        textView.setText(stringBuilder.toString());
        LegacyUpgradeAndEvaluate.g(this.dKa).setTextColor(this.dKa.getResources().getColor(R.color.red_text));
        textView = LegacyUpgradeAndEvaluate.a(this.dKa);
        stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(this.dKa.getString(R.string.pos_downloaded));
        stringBuilder.append(")");
        textView.setText(stringBuilder.toString());
        LegacyUpgradeAndEvaluate.a(this.dKa).setVisibility(0);
        LegacyUpgradeAndEvaluate.h(this.dKa).setVisibility(0);
        LegacyUpgradeAndEvaluate.h(this.dKa).setOnClickListener(this.dKa.aXN);
        LegacyUpgradeAndEvaluate.h(this.dKa).setText(this.dKa.getString(R.string.pos_upgrade_check_install));
        LegacyUpgradeAndEvaluate.j(this.dKa).setVisibility(0);
        LegacyUpgradeAndEvaluate.i(this.dKa).setBackgroundResource(R.drawable.selector_min_rounded_rectangle_top);
        LegacyUpgradeAndEvaluate.i(this.dKa).setPadding(24, 0, 24, 0);
        LegacyUpgradeAndEvaluate.a(this.dKa, this.dKa.dIf, LegacyUpgradeAndEvaluate.c(this.dKa));
        break;
      case 3:
        textView = LegacyUpgradeAndEvaluate.g(this.dKa);
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.dKa.getString(R.string.pos_find_new_version));
        stringBuilder.append(":V");
        stringBuilder.append(LegacyUpgradeAndEvaluate.c(this.dKa));
        textView.setText(stringBuilder.toString());
        LegacyUpgradeAndEvaluate.g(this.dKa).setTextColor(this.dKa.getResources().getColor(R.color.red_text));
        textView = LegacyUpgradeAndEvaluate.a(this.dKa);
        stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(this.dKa.getString(R.string.pos_downloading));
        stringBuilder.append("");
        stringBuilder.append(this.dKa.progress);
        stringBuilder.append("%)");
        textView.setText(stringBuilder.toString());
        LegacyUpgradeAndEvaluate.a(this.dKa).setVisibility(0);
        LegacyUpgradeAndEvaluate.h(this.dKa).setVisibility(0);
        LegacyUpgradeAndEvaluate.h(this.dKa).setOnClickListener(this.dKa.dIk);
        LegacyUpgradeAndEvaluate.h(this.dKa).setText(this.dKa.getString(R.string.auth_cancelButton));
        LegacyUpgradeAndEvaluate.j(this.dKa).setVisibility(0);
        LegacyUpgradeAndEvaluate.i(this.dKa).setBackgroundResource(R.drawable.selector_min_rounded_rectangle_top);
        LegacyUpgradeAndEvaluate.i(this.dKa).setPadding(24, 0, 24, 0);
        LegacyUpgradeAndEvaluate.a(this.dKa, this.dKa.dIf, LegacyUpgradeAndEvaluate.c(this.dKa));
        break;
      case 2:
        LegacyUpgradeAndEvaluate.g(this.dKa).setText(this.dKa.getString(R.string.pos_upgrade_no_new_version));
        LegacyUpgradeAndEvaluate.g(this.dKa).setTextColor(this.dKa.getResources().getColor(R.color.black));
        LegacyUpgradeAndEvaluate.h(this.dKa).setVisibility(0);
        LegacyUpgradeAndEvaluate.h(this.dKa).setOnClickListener(this.dKa.dIj);
        LegacyUpgradeAndEvaluate.h(this.dKa).setText(R.string.pos_upgrade_check);
        LegacyUpgradeAndEvaluate.j(this.dKa).setVisibility(8);
        LegacyUpgradeAndEvaluate.a(this.dKa).setVisibility(8);
        Toast.makeText(this.dKa.getBaseContext(), this.dKa.getString(R.string.pos_up_tp_date), 0).show();
        break;
      case 1:
        textView = LegacyUpgradeAndEvaluate.g(this.dKa);
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.dKa.getString(R.string.pos_find_new_version));
        stringBuilder.append(":V");
        stringBuilder.append(LegacyUpgradeAndEvaluate.c(this.dKa));
        textView.setText(stringBuilder.toString());
        LegacyUpgradeAndEvaluate.g(this.dKa).setTextColor(this.dKa.getResources().getColor(R.color.red_text));
        textView = LegacyUpgradeAndEvaluate.a(this.dKa);
        stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(this.dKa.getString(R.string.pos_size));
        stringBuilder.append(":");
        stringBuilder.append(this.dKa.dIg);
        stringBuilder.append(")");
        textView.setText(stringBuilder.toString());
        LegacyUpgradeAndEvaluate.a(this.dKa).setVisibility(0);
        LegacyUpgradeAndEvaluate.h(this.dKa).setVisibility(0);
        LegacyUpgradeAndEvaluate.h(this.dKa).setOnClickListener(this.dKa.aXS);
        LegacyUpgradeAndEvaluate.h(this.dKa).setText(this.dKa.getString(R.string.mainmenu_synchronize_download));
        LegacyUpgradeAndEvaluate.i(this.dKa).setBackgroundResource(R.drawable.selector_min_rounded_rectangle_top);
        LegacyUpgradeAndEvaluate.i(this.dKa).setPadding(24, 0, 24, 0);
        LegacyUpgradeAndEvaluate.j(this.dKa).setVisibility(0);
        LegacyUpgradeAndEvaluate.a(this.dKa, this.dKa.dIf, LegacyUpgradeAndEvaluate.c(this.dKa));
        break;
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */