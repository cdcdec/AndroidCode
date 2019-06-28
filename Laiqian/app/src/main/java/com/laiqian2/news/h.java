package com.laiqian.news;

import android.view.View;
import java.util.HashMap;

class h implements View.OnClickListener {
  h(NewsActivity paramNewsActivity) {}
  
  public void onClick(View paramView) {
    this.bWC.et(false);
    HashMap hashMap = new HashMap();
    hashMap.put("action", Integer.valueOf(2));
    hashMap.put("datetimes", NewsActivity.h(this.bWC).a(NewsActivity.e(this.bWC).WY()));
    hashMap.put("table_id", (NewsActivity.e(this.bWC).WV()).coJ);
    hashMap.put("releated_id", Long.valueOf((NewsActivity.e(this.bWC).WV()).bZP));
    NewsActivity.h(this.bWC).a(hashMap, false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */