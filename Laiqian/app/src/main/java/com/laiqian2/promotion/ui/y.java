package com.laiqian.promotion.ui;

import android.content.Intent;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.laiqian.entity.ai;

class y implements BaseQuickAdapter.b {
  y(PromotionListActivity paramPromotionListActivity) {}
  
  public void b(BaseQuickAdapter paramBaseQuickAdapter, View paramView, int paramInt) {
    ai ai = (ai)PromotionListActivity.c(this.cWI).tS().get(paramInt);
    Intent intent = new Intent(this.cWI, PromotionCreateActivity.class);
    intent.putExtra("typeId", ai.HF());
    intent.putExtra("typeName", ai.HH());
    this.cWI.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */