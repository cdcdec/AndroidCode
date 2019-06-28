package com.laiqian.version.view;

import android.view.View;
import android.widget.Button;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.m;
import com.laiqian.util.av;
import java.util.HashMap;

class m implements View.OnClickListener {
  m(LegacyUpgradeAndEvaluate.b paramb, Button paramButton1, Button paramButton2, int paramInt) {}
  
  public void onClick(View paramView) {
    this.dIq.setText(R.string.pos_upgrade_ever_bad_evaluate);
    this.dIq.setTextColor(this.dKb.dKa.getResources().getColor(R.color.member_list_item_min));
    this.dIr.setText(R.string.pos_upgrade_good_evaluate);
    this.dIr.setTextColor(this.dKb.dKa.getResources().getColor(R.color.black));
    this.dIq.setClickable(false);
    this.dIr.setClickable(true);
    ((HashMap)LegacyUpgradeAndEvaluate.b.a(this.dKb).get(this.qI)).put("evaluate", "BAD");
    av av = new av(this.dKb.dKa);
    av.i(av.getVersion(), LegacyUpgradeAndEvaluate.b.a(this.dKb));
    av.close();
    (new m(this.dKb.dKa, R.style.pos_dialog, R.layout.pos_feedback_dialog, this.qI, LegacyUpgradeAndEvaluate.b.a(this.dKb), "BAD")).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */