package com.laiqian.promotion.b;

import android.content.Context;
import com.laiqian.entity.ac;
import com.laiqian.entity.ak;
import com.laiqian.product.models.g;
import com.laiqian.promotion.c.a;
import com.laiqian.promotion.e.a;
import java.util.ArrayList;

public class a implements a {
  private Context mContext;
  
  public a(Context paramContext) { this.mContext = paramContext; }
  
  public boolean O(long paramLong) {
    a a1 = new a(this.mContext);
    boolean bool = a1.da(paramLong);
    a1.close();
    return bool;
  }
  
  public ArrayList<ac> a(int paramInt, ak paramak) {
    a a1 = new a(this.mContext);
    ArrayList arrayList = a1.b(paramInt, paramak);
    a1.close();
    return arrayList;
  }
  
  public boolean a(ac paramac1, ac paramac2, ak paramak) {
    a a1 = new a(this.mContext);
    boolean bool = a1.b(paramac1, paramac2, paramak);
    a1.close();
    return bool;
  }
  
  public boolean a(ac paramac, ak paramak) {
    a a1 = new a(this.mContext);
    boolean bool = a1.b(paramac, paramak);
    a1.close();
    return bool;
  }
  
  public boolean a(long[] paramArrayOfLong, double paramDouble) {
    g g = new g(this.mContext);
    boolean bool = g.a(paramArrayOfLong, paramDouble);
    g.close();
    return bool;
  }
  
  public boolean cU(long paramLong) {
    a a1 = new a(this.mContext);
    boolean bool = a1.db(paramLong);
    a1.close();
    return bool;
  }
  
  public boolean cV(long paramLong) {
    a a1 = new a(this.mContext);
    boolean bool = a1.dc(paramLong);
    a1.close();
    return bool;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotion\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */