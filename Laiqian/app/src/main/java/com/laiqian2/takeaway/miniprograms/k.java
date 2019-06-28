package com.laiqian.takeaway.miniprograms;

import android.view.View;
import android.widget.TextView;
import com.laiqian.takeaway.R;
import com.laiqian.ui.a.ab;
import com.laiqian.util.bd;

class k implements View.OnClickListener {
  k(WechatMiniProgramsActivity paramWechatMiniProgramsActivity, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, int paramInt) {}
  
  public void onClick(View paramView) {
    String str = this.cjV.getText().toString().trim();
    if (str.length() == 0) {
      this.cjW.setText(R.string.pos_report_export_mail_no_input);
      return;
    } 
    if (!bd.bH(this.duf.getActivity())) {
      this.cjW.setText(R.string.pos_report_export_mail_no_network);
      return;
    } 
    this.cjW.setText(null);
    ab.N(this.duf.getActivity());
    WechatMiniProgramsActivity wechatMiniProgramsActivity = this.duf;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(this.cjT.getText().toString());
    (new WechatMiniProgramsActivity.b(wechatMiniProgramsActivity, stringBuilder.toString(), this.dug, null)).start();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\miniprograms\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */