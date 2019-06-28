package com.laiqian.main.module.opentable;

import android.text.TextUtils;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.opentable.pos.PosActivityTableAdapter;
import com.laiqian.opentable.pos.c;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import java.util.ArrayList;

class y implements PosActivityTableAdapter.b {
  y(PosActivityOpenTableFragment paramPosActivityOpenTableFragment) {}
  
  public void a(PendingFullOrderDetail paramPendingFullOrderDetail, TableEntity paramTableEntity) {
    (PosActivityOpenTableFragment.a(this.bhq)).bea.Mi();
    (PosActivityOpenTableFragment.a(this.bhq)).beg.accept(paramTableEntity);
    (PosActivityOpenTableFragment.d(this.bhq)).bhz.bhF.aQx.setVisibility(8);
    (PosActivityOpenTableFragment.d(this.bhq)).bhw.aQx.setVisibility(8);
    this.bhq.eW(2);
    PosActivityOpenTableFragment.b(this.bhq, null);
    PosActivityOpenTableFragment.a(this.bhq, null);
    PosActivityOpenTableFragment.c(this.bhq, paramPendingFullOrderDetail);
  }
  
  public void b(TableEntity paramTableEntity, int paramInt) { this.bhq.b(paramTableEntity, paramInt); }
  
  public void c(TableEntity paramTableEntity) {
    (PosActivityOpenTableFragment.a(this.bhq)).bea.Mi();
    (PosActivityOpenTableFragment.a(this.bhq)).beg.accept(paramTableEntity);
    PosActivityOpenTableFragment.e(this.bhq).l(((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue()).Yh());
    (PosActivityOpenTableFragment.d(this.bhq)).bhw.aQx.setVisibility(8);
    PosActivityOpenTableFragment.a(this.bhq, null);
    PosActivityOpenTableFragment.b(this.bhq, null);
    if (((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue()).getState() == 0) {
      (PosActivityOpenTableFragment.d(this.bhq)).bhz.bhF.aQx.setVisibility(8);
      (PosActivityOpenTableFragment.d(this.bhq)).bhw.aQx.setVisibility(8);
      this.bhq.eW(2);
      if (((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue()).Yh().isEmpty())
        return; 
      ((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue()).c((c)((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue()).Yh().get(0));
      return;
    } 
    if (((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue()).Yh().isEmpty())
      return; 
    ((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue()).c((c)((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue()).Yh().get(0));
    if (!TextUtils.isEmpty(((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue()).Yg().xq())) {
      if (paramTableEntity.getState() != 5) {
        this.bhq.eW(5);
        (PosActivityOpenTableFragment.d(this.bhq)).bhz.bhF.bhJ.setVisibility(0);
        (PosActivityOpenTableFragment.d(this.bhq)).bhz.bhF.aQx.setVisibility(0);
        this.bhq.a(((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue()).Yg());
        return;
      } 
      if (paramTableEntity.getState() == 5) {
        this.bhq.eW(7);
        (PosActivityOpenTableFragment.d(this.bhq)).bhz.bhF.bhJ.setVisibility(8);
        (PosActivityOpenTableFragment.d(this.bhq)).bhz.bhF.aQx.setVisibility(0);
        this.bhq.a(((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue()).Yg());
      } 
    } 
  }
  
  public void c(a parama) { this.bhq.a(parama, false); }
  
  public void d(TableEntity paramTableEntity) {
    PosActivityOpenTableFragment.a(this.bhq, paramTableEntity);
    ((c)PosActivityOpenTableFragment.h(this.bhq).get()).a(paramTableEntity, PosActivityOpenTableFragment.g(this.bhq), true, PosActivityOpenTableFragment.f(this.bhq).YA(), true, null);
  }
  
  public void d(TableEntity paramTableEntity, int paramInt) { PosActivityOpenTableFragment.a(this.bhq, paramTableEntity, paramInt); }
  
  public void e(TableEntity paramTableEntity) {
    PosActivityOpenTableFragment.a(this.bhq, null);
    PosActivityOpenTableFragment.b(this.bhq, paramTableEntity);
  }
  
  public void x(ArrayList<TableEntity> paramArrayList) {
    if (PosActivityOpenTableFragment.f(this.bhq).Yz()) {
      (PosActivityOpenTableFragment.d(this.bhq)).bhD.bic.bij.setVisibility(0);
      return;
    } 
    (PosActivityOpenTableFragment.d(this.bhq)).bhD.bic.bij.setVisibility(8);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\opentable\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */