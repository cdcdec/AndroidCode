package com.laiqian.main;

import android.content.Context;
import android.view.View;
import com.laiqian.ui.k;
import java.util.ArrayList;

public class b extends k {
  View view;
  
  public b(Context paramContext, View paramView, int paramInt1, int paramInt2) {
    super(paramContext, paramInt1, paramInt2);
    this.view = paramView;
  }
  
  public void KF() { dp(this.view); }
  
  public void a(ArrayList<String> paramArrayList, a parama) { setOnItemClickListener(new c(this, parama)); }
  
  public static interface a {
    void eK(int param1Int);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */