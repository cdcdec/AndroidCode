package com.laiqian.promotion.b;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.models.ac;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.promotion.e.b;
import java.util.List;

public class c implements b {
  private Context mContext;
  
  public c(Context paramContext) { this.mContext = paramContext; }
  
  public List<ProductTypeEntity> M(List<ProductTypeEntity> paramList) {
    try {
      exception = new ac(this.mContext);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    return paramList.isEmpty() ? exception.a(true, Boolean.valueOf(true)) : exception.a(true, Boolean.valueOf(true), paramList);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotion\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */