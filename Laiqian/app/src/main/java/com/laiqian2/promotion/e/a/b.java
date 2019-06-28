package com.laiqian.promotion.e.a;

import android.content.Context;
import com.laiqian.entity.ac;
import com.laiqian.promotion.b.b;
import com.laiqian.promotion.e.c;
import java.util.ArrayList;

public class b implements c {
  private c cVY;
  
  private Context mContext;
  
  public b(Context paramContext) { this.mContext = paramContext; }
  
  public c alJ() {
    if (this.cVY == null)
      this.cVY = new b(this.mContext); 
    return this.cVY;
  }
  
  public ArrayList<ac> alp() { return alJ().alp(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotion\e\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */