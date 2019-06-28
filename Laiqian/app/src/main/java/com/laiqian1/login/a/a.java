package com.laiqian.login.a;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.laiqian.c.a;
import com.laiqian.models.an;
import com.laiqian.models.h;
import com.laiqian.opentable.common.b;
import com.laiqian.util.by;
import com.laiqian.util.m;
import com.laiqian.util.p;

public interface a extends m {
  public static class a implements View.OnClickListener {
    protected Activity mActivity;
    
    protected Intent mIntent;
    
    public a(Activity param1Activity) { this.mActivity = param1Activity; }
    
    private boolean a(an.c param1c) {
      if (TextUtils.isEmpty(param1c.aVs))
        return false; 
      if (param1c.bSp == 0)
        return false; 
      if (by.isNull(param1c.bSq))
        return false; 
      if (!a.zR().Ad()) {
        if (TextUtils.isEmpty(param1c.aWV))
          return false; 
        h.e e = (h.e)h.aM(this.mActivity).UJ().UM().get(param1c.bSu);
        if (e == null)
          return false; 
        h.a a1 = (h.a)e.UO().get(param1c.bSv);
        if (a1 == null)
          return false; 
        if ((h.c)a1.UK().get(param1c.bSw) == null)
          return false; 
      } 
      return true;
    }
    
    protected boolean h(Intent param1Intent) { return false; }
    
    protected void i(Intent param1Intent) {}
    
    public void onClick(View param1View) {
      an.c c = (new an(this.mActivity)).Vu();
      this.mIntent = new Intent();
      if (c == null || !a(c)) {
        this.mIntent.setClass(this.mActivity, com.laiqian.pos.settings.InitialSettingsActivity.class);
      } else {
        this.mIntent.setClass(this.mActivity, p.bP(this.mActivity));
      } 
      if (h(this.mIntent))
        return; 
      b.Xz();
      this.mActivity.startActivity(this.mIntent);
      this.mActivity.overridePendingTransition(2130771979, 2130771980);
      i(this.mIntent);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */