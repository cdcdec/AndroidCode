package com.laiqian.member.d;

import android.view.View;
import com.laiqian.util.bd;
import com.laiqian.vip.R;

class e implements View.OnClickListener {
  e(a parama, boolean paramBoolean) {}
  
  public void onClick(View paramView) {
    String str1;
    String str2 = a.d(this.bxV).getText().toString().trim();
    if (this.bxW) {
      str1 = a.b(this.bxV).getText().toString();
    } else {
      str1 = "";
    } 
    if (str2.length() == 0) {
      a.e(this.bxV).setText(R.string.pos_report_export_mail_no_input);
      return;
    } 
    if (!bd.bH(this.bxV.context)) {
      a.e(this.bxV).setText(R.string.pos_report_export_mail_no_network);
      return;
    } 
    a.e(this.bxV).setText(null);
    a a1 = this.bxV;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str2);
    stringBuilder.append(str1);
    a.b(a1, stringBuilder.toString());
    this.bxV.bvO.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */