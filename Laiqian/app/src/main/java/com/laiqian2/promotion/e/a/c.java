package com.laiqian.promotion.e.a;

import android.content.Context;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.promotion.b.c;
import com.laiqian.promotion.e.b;
import java.util.List;

public class c implements b {
  private b cVZ;
  
  private Context mContext;
  
  public c(Context paramContext) { this.mContext = paramContext; }
  
  public List<ProductTypeEntity> M(List<ProductTypeEntity> paramList) { return alK().M(paramList); }
  
  public b alK() {
    if (this.cVZ == null)
      this.cVZ = new c(this.mContext); 
    return this.cVZ;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotion\e\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */