package com.laiqian.main.module.scanorder;

import com.laiqian.main.bb;
import com.laiqian.opentable.c;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.n;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.takeaway.v;
import com.laiqian.util.by;
import com.laiqian.util.n;
import org.json.JSONException;

class e implements v {
  e(PosActivityScanOrderFragment.a parama, PendingFullOrderDetail paramPendingFullOrderDetail) {}
  
  public void a(String paramString, bb parambb) throws JSONException { c.a(n.ce(by.parseLong(this.blC.bXb.coJ)), this.blC, new f(this, parambb)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\scanorder\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */