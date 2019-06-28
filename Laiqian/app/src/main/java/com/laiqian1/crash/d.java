package com.laiqian.crash;

import android.view.View;
import android.widget.TextView;
import com.laiqian.ui.a.r;
import com.laiqian.util.z;
import java.util.HashMap;

class d implements View.OnClickListener {
  d(CrashList.a parama, TextView paramTextView, int paramInt) {}
  
  public void onClick(View paramView) {
    e e = new e(this);
    r r = new r(CrashList.a.a(this.aMI), e);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(CrashList.a.a(this.aMI).getResources().getString(2131624879));
    stringBuilder.append((String)((HashMap)CrashList.a.b(this.aMI).get(this.qI)).get("e_id"));
    r.setTitle(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(CrashList.a.a(this.aMI).getResources().getString(2131624880));
    stringBuilder.append(z.pA((String)((HashMap)CrashList.a.b(this.aMI).get(this.qI)).get("e_crashtime")));
    r.s(stringBuilder.toString());
    r.t(CrashList.a.a(this.aMI).getString(2131624887));
    r.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\crash\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */