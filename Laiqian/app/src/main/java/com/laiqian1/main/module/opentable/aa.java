package com.laiqian.main.module.opentable;

import com.laiqian.d.a;
import com.laiqian.main.fj;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.opentable.pos.c;
import com.laiqian.product.models.h;
import java.util.ArrayList;

class aa implements c.a {
  aa(PosActivityOpenTableFragment paramPosActivityOpenTableFragment) {}
  
  public void NB() {}
  
  public void a(a parama, TableEntity paramTableEntity, c paramc) {
    if (PosActivityOpenTableFragment.i(this.bhq) != null) {
      if (paramTableEntity.getID() == PosActivityOpenTableFragment.i(this.bhq).getID()) {
        this.bhq.a(paramTableEntity, 4);
        return;
      } 
      this.bhq.a(parama, PosActivityOpenTableFragment.i(this.bhq), paramTableEntity, PosActivityOpenTableFragment.i(this.bhq).Yg().Yl());
      return;
    } 
    if (paramc != null) {
      PosActivityOpenTableFragment.e(this.bhq).l(paramTableEntity.Yh());
      PosActivityOpenTableFragment.e(this.bhq).f(paramc);
      ArrayList arrayList = paramTableEntity.Yh();
      arrayList.add(paramc);
      byte b;
      for (b = 0; b < arrayList.size() - 1; b = b1) {
        c c1 = (c)arrayList.get(b);
        byte b1 = b + 1;
        c c2 = (c)arrayList.get(b1);
        if (c1.Yl() > c2.Yl()) {
          arrayList.set(b, c2);
          arrayList.set(b1, c1);
        } 
      } 
      paramTableEntity.c(paramc);
      (PosActivityOpenTableFragment.d(this.bhq)).bhw.aQx.setVisibility(8);
      (PosActivityOpenTableFragment.a(this.bhq)).bea.Mi();
    } 
    PosActivityOpenTableFragment.a(this.bhq, parama);
    (PosActivityOpenTableFragment.a(this.bhq)).beg.accept(paramTableEntity);
    ((TableEntity)(PosActivityOpenTableFragment.a(this.bhq)).beg.getValue()).cf(System.currentTimeMillis());
    PosActivityOpenTableFragment.j(this.bhq);
    PosActivityOpenTableFragment.a(this.bhq, true);
    this.bhq.eW(3);
    if (paramTableEntity.getState() == 0 || paramTableEntity.Yh().size() > 1) {
      this.bhq.Ni();
      if (a.AZ().Cv()) {
        h h = (new fj()).a(this.bhq.getActivity(), paramTableEntity);
        if (h != null)
          PosActivityOpenTableFragment.a(this.bhq, h); 
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\opentable\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */