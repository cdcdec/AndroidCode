package com.laiqian.news;

import android.util.Log;
import com.laiqian.network.i;
import java.util.HashMap;

class s implements y.a.a {
  s(q paramq, HashMap paramHashMap, boolean paramBoolean) {}
  
  public void a(i parami) {
    q.a(this.bWR).zM();
    q.a(this.bWR).es(true);
    q.a(this.bWR).et(true);
    Log.e("operatePendingOrder", parami.message);
    if (parami.bUi) {
      if (this.bWS.get("action").equals(Integer.valueOf(1)))
        q.a(this.bWR).q(1, this.bWT); 
      this.bWR.gr(0);
    } 
  }
  
  public void onPreExecute() { q.a(this.bWR).zM(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */