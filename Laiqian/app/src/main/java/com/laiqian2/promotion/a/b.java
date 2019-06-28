package com.laiqian.promotion.a;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.f;
import com.laiqian.entity.ac;
import com.laiqian.promotion.R;
import com.laiqian.promotion.f.a;
import com.laiqian.util.ck;
import java.util.List;

public class b extends BaseQuickAdapter<ac, f> {
  public b(@Nullable List<ac> paramList) { super(R.layout.pos_promotion_ing_list_item, paramList); }
  
  public void a(f paramf, int paramInt) {
    super.a(paramf, paramInt);
    paramf.dp(R.id.bg).setActivated(ck.ml(paramInt));
  }
  
  protected void a(f paramf, ac paramac) { paramf.a(R.id.tv_promotion_name, paramac.getName()).a(R.id.tv_promotion_time, a.a(paramac.Hc(), this.mContext)).a(R.id.tv_promotion_object, paramac.Hd().AS()); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotion\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */