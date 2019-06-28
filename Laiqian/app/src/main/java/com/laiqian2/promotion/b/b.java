package com.laiqian.promotion.b;

import android.content.Context;
import com.laiqian.entity.ac;
import com.laiqian.promotion.c.a;
import com.laiqian.promotion.e.c;
import java.util.ArrayList;

public class b implements c {
  private Context mContext;
  
  public b(Context paramContext) { this.mContext = paramContext; }
  
  public ArrayList<ac> alp() {
    a a = new a(this.mContext);
    ArrayList arrayList = a.gt(false);
    a.close();
    return arrayList;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotion\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */