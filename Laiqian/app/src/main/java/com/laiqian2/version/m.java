package com.laiqian.version;

import android.view.View;
import android.widget.Button;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.m;
import com.laiqian.util.av;
import java.util.HashMap;

class m implements View.OnClickListener {
  m(UpgradeAndEvaluate.b paramb, Button paramButton1, Button paramButton2, int paramInt) {}
  
  public void onClick(View paramView) {
    this.dIq.setText(R.string.pos_upgrade_ever_bad_evaluate);
    this.dIq.setTextColor(this.dIs.dIp.getResources().getColor(R.color.member_list_item_min));
    this.dIr.setText(R.string.pos_upgrade_good_evaluate);
    this.dIr.setTextColor(this.dIs.dIp.getResources().getColor(R.color.black));
    this.dIq.setClickable(false);
    this.dIr.setClickable(true);
    ((HashMap)UpgradeAndEvaluate.b.a(this.dIs).get(this.qI)).put("evaluate", "BAD");
    av av = new av(this.dIs.dIp);
    av.i(av.getVersion(), UpgradeAndEvaluate.b.a(this.dIs));
    av.close();
    (new m(this.dIs.dIp, R.style.pos_dialog, R.layout.pos_feedback_dialog, this.qI, UpgradeAndEvaluate.b.a(this.dIs), "BAD")).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */