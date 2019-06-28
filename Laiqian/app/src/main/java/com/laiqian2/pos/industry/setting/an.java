package com.laiqian.pos.industry.setting;

import android.view.View;

class an implements View.OnClickListener {
  an(MainSetting paramMainSetting) {}
  
  public void onClick(View paramView) {
    if (paramView == MainSetting.access$000(this.csj))
      return; 
    int i = ((Integer)paramView.getTag()).intValue();
    if (MainSetting.access$000(this.csj) != null)
      MainSetting.access$000(this.csj).setSelected(false); 
    MainSetting.access$002(this.csj, paramView);
    MainSetting.access$000(this.csj).setSelected(true);
    MainSetting.access$100(this.csj).removeAllViews();
    MainSetting.access$200(this.csj, i);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\setting\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */