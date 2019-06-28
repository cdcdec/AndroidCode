package com.laiqian.main.module.opentable;

import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.ui.a.r;

class q implements r.a {
  q(PosActivityOpenTableFragment paramPosActivityOpenTableFragment) {}
  
  public void xD() {
    if ((PosActivityOpenTableFragment.a(this.bhq)).beg.getValue() == TableEntity.bZK)
      return; 
    if (((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue()).getState() == 0 || ((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue()).Yg().Yn() == 0) {
      PosActivityOpenTableFragment.n(this.bhq);
      return;
    } 
    PosActivityOpenTableFragment.o(this.bhq);
  }
  
  public void xE() {
    if ((PosActivityOpenTableFragment.a(this.bhq)).beg.getValue() == TableEntity.bZK)
      return; 
    if (((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue()).getState() == 0) {
      this.bhq.Nl();
      return;
    } 
    this.bhq.Nm();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\opentable\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */