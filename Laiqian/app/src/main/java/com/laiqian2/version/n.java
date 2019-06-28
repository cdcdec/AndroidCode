package com.laiqian.version;

import android.view.View;
import android.widget.Button;
import com.laiqian.infrastructure.R;
import com.laiqian.util.av;
import com.laiqian.util.ch;
import java.util.HashMap;

class n implements View.OnClickListener {
  n(UpgradeAndEvaluate.b paramb, Button paramButton1, Button paramButton2, int paramInt) {}
  
  public void onClick(View paramView) {
    this.dIq.setText(R.string.pos_upgrade_bad_evaluate);
    this.dIq.setTextColor(this.dIs.dIp.getResources().getColor(R.color.black));
    this.dIr.setText(R.string.pos_upgrade_ever_good_evaluate);
    this.dIr.setTextColor(this.dIs.dIp.getResources().getColor(R.color.member_list_item_min));
    this.dIr.setClickable(false);
    this.dIq.setClickable(true);
    ((HashMap)UpgradeAndEvaluate.b.a(this.dIs).get(this.qI)).put("evaluate", "GOOD");
    av av = new av(this.dIs.dIp);
    av.i(av.getVersion(), UpgradeAndEvaluate.b.a(this.dIs));
    av.close();
    ch.a(this.dIs.dIp, null, (String)((HashMap)UpgradeAndEvaluate.b.a(this.dIs).get(this.qI)).get("feature"), "GOOD", this.dIs.dIp.getString(R.string.pos_upgrade_good_evaluate));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */