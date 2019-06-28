package com.laiqian.version;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.infrastructure.R;

class k extends Handler {
  k(UpgradeAndEvaluate paramUpgradeAndEvaluate) {}
  
  public void handleMessage(Message paramMessage) {
    StringBuilder stringBuilder;
    TextView textView;
    UpgradeAndEvaluate.f(this.dIp).setVisibility(8);
    switch (paramMessage.what) {
      case 6:
        UpgradeAndEvaluate.g(this.dIp).setText(this.dIp.getString(R.string.pos_upgrade_no_new_version));
        UpgradeAndEvaluate.g(this.dIp).setTextColor(this.dIp.getResources().getColor(R.color.black));
        UpgradeAndEvaluate.h(this.dIp).setVisibility(0);
        UpgradeAndEvaluate.h(this.dIp).setOnClickListener(this.dIp.dIj);
        UpgradeAndEvaluate.h(this.dIp).setText(R.string.pos_upgrade_check);
        UpgradeAndEvaluate.j(this.dIp).setVisibility(8);
        UpgradeAndEvaluate.a(this.dIp).setVisibility(8);
        Toast.makeText(this.dIp.getBaseContext(), this.dIp.getString(R.string.pos_request_time), 1000).show();
        break;
      case 5:
        textView = UpgradeAndEvaluate.g(this.dIp);
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.dIp.getString(R.string.pos_find_new_version));
        stringBuilder.append(":V");
        stringBuilder.append(UpgradeAndEvaluate.c(this.dIp));
        textView.setText(stringBuilder.toString());
        UpgradeAndEvaluate.g(this.dIp).setTextColor(this.dIp.getResources().getColor(R.color.red_text));
        textView = UpgradeAndEvaluate.a(this.dIp);
        stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(this.dIp.getString(R.string.pos_downloaded));
        stringBuilder.append(")");
        textView.setText(stringBuilder.toString());
        UpgradeAndEvaluate.a(this.dIp).setVisibility(0);
        UpgradeAndEvaluate.h(this.dIp).setVisibility(0);
        UpgradeAndEvaluate.h(this.dIp).setOnClickListener(this.dIp.aXN);
        UpgradeAndEvaluate.h(this.dIp).setText(this.dIp.getString(R.string.pos_upgrade_check_install));
        UpgradeAndEvaluate.j(this.dIp).setVisibility(0);
        UpgradeAndEvaluate.i(this.dIp).setBackgroundResource(R.drawable.selector_min_rounded_rectangle_top);
        UpgradeAndEvaluate.i(this.dIp).setPadding(24, 0, 24, 0);
        UpgradeAndEvaluate.a(this.dIp, this.dIp.dIf, UpgradeAndEvaluate.c(this.dIp));
        break;
      case 3:
        textView = UpgradeAndEvaluate.g(this.dIp);
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.dIp.getString(R.string.pos_find_new_version));
        stringBuilder.append(":V");
        stringBuilder.append(UpgradeAndEvaluate.c(this.dIp));
        textView.setText(stringBuilder.toString());
        UpgradeAndEvaluate.g(this.dIp).setTextColor(this.dIp.getResources().getColor(R.color.red_text));
        textView = UpgradeAndEvaluate.a(this.dIp);
        stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(this.dIp.getString(R.string.pos_downloading));
        stringBuilder.append("");
        stringBuilder.append(this.dIp.progress);
        stringBuilder.append("%)");
        textView.setText(stringBuilder.toString());
        UpgradeAndEvaluate.a(this.dIp).setVisibility(0);
        UpgradeAndEvaluate.h(this.dIp).setVisibility(0);
        UpgradeAndEvaluate.h(this.dIp).setOnClickListener(this.dIp.dIk);
        UpgradeAndEvaluate.h(this.dIp).setText(this.dIp.getString(R.string.auth_cancelButton));
        UpgradeAndEvaluate.j(this.dIp).setVisibility(0);
        UpgradeAndEvaluate.i(this.dIp).setBackgroundResource(R.drawable.selector_min_rounded_rectangle_top);
        UpgradeAndEvaluate.i(this.dIp).setPadding(24, 0, 24, 0);
        UpgradeAndEvaluate.a(this.dIp, this.dIp.dIf, UpgradeAndEvaluate.c(this.dIp));
        break;
      case 2:
        UpgradeAndEvaluate.g(this.dIp).setText(this.dIp.getString(R.string.pos_upgrade_no_new_version));
        UpgradeAndEvaluate.g(this.dIp).setTextColor(this.dIp.getResources().getColor(R.color.black));
        UpgradeAndEvaluate.h(this.dIp).setVisibility(0);
        UpgradeAndEvaluate.h(this.dIp).setOnClickListener(this.dIp.dIj);
        UpgradeAndEvaluate.h(this.dIp).setText(R.string.pos_upgrade_check);
        UpgradeAndEvaluate.j(this.dIp).setVisibility(8);
        UpgradeAndEvaluate.a(this.dIp).setVisibility(8);
        Toast.makeText(this.dIp.getBaseContext(), this.dIp.getString(R.string.pos_up_tp_date), 1000).show();
        break;
      case 1:
        textView = UpgradeAndEvaluate.g(this.dIp);
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.dIp.getString(R.string.pos_find_new_version));
        stringBuilder.append(":V");
        stringBuilder.append(UpgradeAndEvaluate.c(this.dIp));
        textView.setText(stringBuilder.toString());
        UpgradeAndEvaluate.g(this.dIp).setTextColor(this.dIp.getResources().getColor(R.color.red_text));
        textView = UpgradeAndEvaluate.a(this.dIp);
        stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(this.dIp.getString(R.string.pos_size));
        stringBuilder.append(":");
        stringBuilder.append(this.dIp.dIg);
        stringBuilder.append(")");
        textView.setText(stringBuilder.toString());
        UpgradeAndEvaluate.a(this.dIp).setVisibility(0);
        UpgradeAndEvaluate.h(this.dIp).setVisibility(0);
        UpgradeAndEvaluate.h(this.dIp).setOnClickListener(this.dIp.aXS);
        UpgradeAndEvaluate.h(this.dIp).setText(this.dIp.getString(R.string.mainmenu_synchronize_download));
        UpgradeAndEvaluate.i(this.dIp).setBackgroundResource(R.drawable.selector_min_rounded_rectangle_top);
        UpgradeAndEvaluate.i(this.dIp).setPadding(24, 0, 24, 0);
        UpgradeAndEvaluate.j(this.dIp).setVisibility(0);
        UpgradeAndEvaluate.a(this.dIp, this.dIp.dIf, UpgradeAndEvaluate.c(this.dIp));
        break;
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */