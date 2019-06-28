package com.laiqian.sync.view;

import android.view.View;
import android.widget.Toast;
import com.laiqian.test.zhoumh.e;

class v implements View.OnClickListener {
  v(TestSync paramTestSync) {}
  
  public void onClick(View paramView) {
    byte b;
    try {
      b = Integer.parseInt(TestSync.a(this.dqv).getText().toString());
    } catch (Exception paramView) {
      b = 0;
    } 
    if (b) {
      Toast.makeText(this.dqv.getBaseContext(), "请输入大于0的数字", 0).show();
      return;
    } 
    if (this.dqv.dqs == null) {
      this.dqv.dqs = new e(this.dqv);
      this.dqv.dqt = new w(this);
    } 
    this.dqv.dqs.kA(b);
    this.dqv.dqs.f(this.dqv.dqt);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\view\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */