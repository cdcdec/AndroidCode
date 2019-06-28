package com.laiqian.member.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.g;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class ah implements View.OnClickListener {
  ah(VipLevelSettingFragment.e parame, int paramInt) {}
  
  public void onClick(View paramView) {
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.eP(R.string.vip_setting_can_not_edit);
      return;
    } 
    if (VipLevelSettingFragment.e.a(this.bCy).size() >= 13) {
      Toast.makeText(VipLevelSettingFragment.e.b(this.bCy), R.string.create_member_level_can_not_more_than_ten, 0).show();
      return;
    } 
    Intent intent = new Intent(this.bCy.bCo.getActivity(), CreateVipGradeAndGradeDetailActivity.class);
    Bundle bundle = new Bundle();
    bundle.putInt("enterType", 0);
    bundle.putIntegerArrayList("grade_ids", this.bCy.bCo.v(VipLevelSettingFragment.e.a(this.bCy)));
    bundle.putLong("last_level_id", ((g)VipLevelSettingFragment.e.a(this.bCy).get(VipLevelSettingFragment.e.a(this.bCy).size() - 1)).getId());
    bundle.putInt("last_level", ((g)VipLevelSettingFragment.e.a(this.bCy).get(VipLevelSettingFragment.e.a(this.bCy).size() - 1)).getNumber());
    bundle.putInt("position_in_list", this.qI);
    intent.putExtras(bundle);
    this.bCy.bCo.getActivity().startActivity(intent, bundle);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */