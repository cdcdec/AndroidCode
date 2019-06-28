package com.laiqian.pos;

import com.laiqian.pos.model.orders.b;

class cu implements ReprintActivity.b.a {
  cu(ReprintActivity paramReprintActivity) {}
  
  public void gO(int paramInt) { ReprintActivity.b(this.cik, ReprintActivity.a(this.cik).gS(paramInt)); }
  
  public void gP(int paramInt) { ReprintActivity.c(this.cik, ReprintActivity.a(this.cik).gS(paramInt)); }
  
  public void gQ(int paramInt) { ReprintActivity.d(this.cik, ReprintActivity.a(this.cik).gS(paramInt)); }
  
  public void gR(int paramInt) {
    b b = ReprintActivity.a(ReprintActivity.a(this.cik).gS(paramInt), this.cik.getActivity());
    if (b != null) {
      dd dd = new dd(this.cik.getActivity(), b);
      dd.setOnDismissListener(new cv(this));
      dd.show();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */