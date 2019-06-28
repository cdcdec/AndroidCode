package com.laiqian.promotion.ui;

import android.content.Intent;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.ac;
import com.laiqian.entity.ai;
import com.laiqian.promotion.R;
import com.laiqian.util.n;

class x implements BaseQuickAdapter.b {
  x(PromotionListActivity paramPromotionListActivity) {}
  
  public void b(BaseQuickAdapter paramBaseQuickAdapter, View paramView, int paramInt) {
    boolean bool;
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    ac ac = (ac)PromotionListActivity.a(this.cWI).tS().get(paramInt);
    Intent intent = new Intent(this.cWI, PromotionCreateActivity.class);
    paramInt = ac.Hm();
    if (bool && paramInt == 6) {
      n.eP(R.string.pos_mutiple_shop_not_allow_modify);
      return;
    } 
    intent.putExtra("promotionID", ac.getID());
    intent.putExtra("typeId", paramInt);
    intent.putExtra("typeName", ((ai)PromotionListActivity.b(this.cWI).get(paramInt - 1)).HH());
    this.cWI.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */