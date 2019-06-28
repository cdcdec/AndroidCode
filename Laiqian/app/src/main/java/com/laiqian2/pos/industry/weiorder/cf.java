package com.laiqian.pos.industry.weiorder;

import android.view.View;
import android.widget.TextView;
import com.laiqian.ui.a.ab;
import com.laiqian.util.bd;

class cf implements View.OnClickListener {
  cf(WeChatWeshopBindingActivity paramWeChatWeshopBindingActivity, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3) {}
  
  public void onClick(View paramView) {
    String str = this.cjV.getText().toString().trim();
    if (str.length() == 0) {
      this.cjW.setText(2131627848);
      return;
    } 
    if (!bd.bH(this.cuf.getActivity())) {
      this.cjW.setText(2131627849);
      return;
    } 
    this.cjW.setText(null);
    ab.N(this.cuf.getActivity());
    WeChatWeshopBindingActivity weChatWeshopBindingActivity = this.cuf;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(this.cjT.getText().toString());
    (new WeChatWeshopBindingActivity.b(weChatWeshopBindingActivity, stringBuilder.toString(), null)).start();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */