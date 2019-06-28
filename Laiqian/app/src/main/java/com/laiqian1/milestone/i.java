package com.laiqian.milestone;

import android.view.View;
import android.widget.Toast;
import com.laiqian.util.ch;

class i implements View.OnClickListener {
  i(inputFeedback paraminputFeedback) {}
  
  public void onClick(View paramView) {
    String str = this.bKI.bKG.getText().toString().trim();
    if ("".equals(str) || str == null) {
      Toast.makeText(this.bKI, this.bKI.getString(2131628456), 1000).show();
      return;
    } 
    ch.a(this.bKI, this.bKI.handler, this.bKI.getString(2131628448), "COMMENT", str);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */