package com.laiqian.promotion.d;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.promotion.e.a.c;
import com.laiqian.promotion.e.b;
import com.laiqian.promotion.g.a;
import io.reactivex.g.a;
import java.util.List;

public class e {
  private a cVS;
  
  private b cVT;
  
  Handler handler = new g(this);
  
  public e(Context paramContext, a parama) {
    this.cVS = parama;
    this.cVT = new c(paramContext);
  }
  
  public void N(List<ProductTypeEntity> paramList) { a.aKh().r(new f(this, paramList)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotion\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */