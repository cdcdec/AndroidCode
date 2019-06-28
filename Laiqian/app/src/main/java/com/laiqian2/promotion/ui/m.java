package com.laiqian.promotion.ui;

import android.view.View;
import com.laiqian.entity.ac;
import com.laiqian.ui.a.r;

class m implements r.a {
  m(PromotionCreateActivity paramPromotionCreateActivity, boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  private void gy(boolean paramBoolean) {
    int i = this.qI;
    if (this.cWC) {
      int k = i;
      if (PromotionCreateActivity.f(this.cWA)) {
        k = i;
        if (paramBoolean) {
          PromotionCreateActivity.b(this.cWA).remove(0);
          PromotionCreateActivity.a(this.cWA, false);
          k = this.qI - 1;
        } 
      } 
      PromotionCreateActivity.a(this.cWA, view, k, true);
      return;
    } 
    int j = i;
    if (PromotionCreateActivity.f(this.cWA)) {
      j = i;
      if (paramBoolean) {
        PromotionCreateActivity.b(this.cWA).remove(0);
        PromotionCreateActivity.a(this.cWA, false);
        j = this.qI - 1;
      } 
    } 
    PromotionCreateActivity.b(this.cWA).jz(j);
    PromotionCreateActivity.c(this.cWA).b((ac)PromotionCreateActivity.b(this.cWA).tS().get(j));
    this.cWA.c((ac)PromotionCreateActivity.b(this.cWA).tS().get(j));
  }
  
  public void xD() {
    if (this.cWB) {
      this.cWA.finish();
      return;
    } 
    gy(true);
  }
  
  public void xE() {
    PromotionCreateActivity.c(this.cWA).save();
    PromotionCreateActivity.c(this.cWA).a(new n(this));
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */