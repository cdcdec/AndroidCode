package com.laiqian.member.select;

import android.view.View;
import android.widget.AdapterView;

class f implements AdapterView.OnItemClickListener {
  f(PosSelectVipDialog paramPosSelectVipDialog) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    if (paramInt - this.bAG.bAq.getHeaderViewsCount() + 1 > this.bAG.bAq.getList().size())
      return; 
    this.bAG.bAx = 0;
    this.bAG.fE(paramInt);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */