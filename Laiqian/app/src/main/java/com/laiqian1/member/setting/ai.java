package com.laiqian.member.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.g;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class ai implements View.OnClickListener {
  ai(VipLevelSettingFragment.e parame, g paramg, int paramInt) {}
  
  public void onClick(View paramView) {
    int i;
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.eP(R.string.vip_setting_can_not_edit);
      return;
    } 
    Intent intent = new Intent(this.bCy.bCo.getActivity(), CreateVipGradeAndGradeDetailActivity.class);
    Bundle bundle = new Bundle();
    bundle.putInt("enterType", 1);
    bundle.putSerializable("gradeData", this.bCz);
    bundle.putIntegerArrayList("grade_ids", this.bCy.bCo.v(VipLevelSettingFragment.e.a(this.bCy)));
    if (this.bCy.fM(this.qI - true) == null) {
      i = -1;
    } else {
      i = this.bCy.fM(this.qI - 1).getNumber();
    } 
    bundle.putInt("last_level", i);
    bundle.putInt("position_in_list", this.qI);
    intent.putExtras(bundle);
    this.bCy.bCo.getActivity().startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */