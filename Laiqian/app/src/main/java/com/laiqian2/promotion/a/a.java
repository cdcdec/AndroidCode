package com.laiqian.promotion.a;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.f;
import com.laiqian.entity.ac;
import com.laiqian.promotion.R;
import java.util.List;

public class a extends BaseQuickAdapter<ac, f> {
  private int cVA;
  
  private int cVB;
  
  public a(@Nullable List<ac> paramList) { super(R.layout.item_layout_create_promotion_list, paramList); }
  
  public void a(f paramf, int paramInt) {
    super.a(paramf, paramInt);
    View view = paramf.dp(R.id.ll_promotion_create_item);
    if (view != null) {
      boolean bool;
      if (paramInt == this.cVA) {
        bool = true;
      } else {
        bool = false;
      } 
      view.setActivated(bool);
    } 
  }
  
  protected void a(f paramf, ac paramac) {
    int k = paramac.getState();
    int i = R.drawable.ic_promotion_state_create;
    int j = R.color.pos_text_red;
    String str = this.mContext.getString(R.string.pos_promotion_state_creating);
    switch (k) {
      case 3:
        i = R.drawable.ic_promotion_state_expire;
        j = R.color.pos_text_grey;
        str = this.mContext.getString(R.string.pos_promotion_state_expire);
        break;
      case 2:
        i = R.drawable.ic_promotion_state_pasue;
        j = R.color.pos_text_grey;
        str = this.mContext.getString(R.string.pos_promotion_state_pause);
        break;
      case 1:
        i = R.drawable.ic_promotion_state_ing;
        j = R.color.pos_text_green;
        str = this.mContext.getString(R.string.pos_promotion_state_ing);
        break;
      case 0:
        i = R.drawable.ic_promotion_state_create;
        j = R.color.pos_text_red;
        str = this.mContext.getString(R.string.pos_promotion_state_creating);
        break;
    } 
    paramf.a(R.id.tv_promotion_name, paramac.getName()).aP(R.id.iv_status, i).aQ(R.id.tv_promotion_state, this.mContext.getResources().getColor(j)).a(R.id.tv_promotion_state, str).do(R.id.tv_promotion_state);
  }
  
  public int all() { return this.cVA; }
  
  public ac alm() { return (ac)this.ari.get(this.cVA); }
  
  public void aln() { bK(this.cVA); }
  
  public void jA(int paramInt) { this.cVA = paramInt; }
  
  public void jz(int paramInt) {
    this.cVB = this.cVA;
    bK(this.cVB);
    this.cVA = paramInt;
    bK(this.cVA);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotion\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */