package com.laiqian.version.view;

import android.view.View;
import android.widget.Toast;
import com.laiqian.util.bd;

class a implements View.OnClickListener {
  a(DoEvaluateActivity paramDoEvaluateActivity) {}
  
  public void onClick(View paramView) {
    boolean bool = bd.bH(this.dJX);
    byte b2 = 0;
    if (!bool) {
      Toast.makeText(this.dJX, "请检查网络", 0).show();
      return;
    } 
    String str = this.dJX.dJS.getText().toString().trim();
    int i = (int)this.dJX.dJV.getRating();
    byte b1 = 1;
    if ("".equals(str) || str == null) {
      this.dJX.dJU.setVisibility(0);
      b1 = 0;
    } 
    if (i <= 0) {
      this.dJX.dJT.setVisibility(0);
      b1 = b2;
    } 
    if (b1 != 0)
      this.dJX.dJW.x(i, str); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */