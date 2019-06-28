package com.laiqian;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import com.laiqian.c.a;
import com.laiqian.entity.n;
import com.laiqian.print.model.PrintContent;
import java.util.ArrayList;

public class bi {
  private o aBJ;
  
  public bi(Activity paramActivity, n paramn, o.a parama) {
    if (a.zR().At()) {
      this.aBJ = new ax(paramActivity, paramn, parama);
      return;
    } 
    if (a.zR().Aj()) {
      this.aBJ = new ab(paramActivity, paramn, parama);
      return;
    } 
    this.aBJ = new be(paramActivity, paramn, parama);
  }
  
  public void a(n paramn) { this.aBJ.a(paramn); }
  
  public void br(boolean paramBoolean) { this.aBJ.br(paramBoolean); }
  
  public void bt(boolean paramBoolean) { this.aBJ.bt(paramBoolean); }
  
  public void d(ArrayList<PrintContent> paramArrayList) { this.aBJ.d(paramArrayList); }
  
  public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener paramOnDismissListener) { this.aBJ.setOnDismissListener(paramOnDismissListener); }
  
  public void show(int paramInt) { this.aBJ.show(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */