package com.laiqian.takeaway;

import android.view.View;
import com.laiqian.entity.TakeOrderEntity;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.k;

class af implements View.OnClickListener {
  af(y paramy, String paramString1, String paramString2) {}
  
  public void onClick(View paramView) {
    ActivityRoot activityRoot = y.b(this.dsf);
    int j = y.f(this.dsf).length;
    int i = 5;
    if (j <= 5)
      i = y.f(this.dsf).length; 
    k k = new k(activityRoot, 'È', i * 33);
    k.B(y.f(this.dsf));
    k.setOnItemClickListener(new ag(this, k));
    k.do(paramView);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */