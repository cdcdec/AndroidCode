package com.laiqian.promotion.a;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.f;
import com.laiqian.entity.ai;
import com.laiqian.promotion.R;
import java.util.List;

public class d extends BaseQuickAdapter<ai, f> {
  public d(@Nullable List<ai> paramList) { super(R.layout.pos_promotion_list_item, paramList); }
  
  protected void a(f paramf, ai paramai) { paramf.a(R.id.tv_left, paramai.HH()).a(R.id.tv_right, paramai.HI()).aP(R.id.iv_left, paramai.HG()).aP(R.id.iv_right, R.drawable.ic_promotion_add); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotion\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */