package com.laiqian.ui.container;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;
import com.laiqian.infrastructure.R;

public class c extends ab<ViewSwitcher> {
  public a dwK = new a(R.id.layout_mode_edit);
  
  public b dwL = new b(R.id.layout_mode_new);
  
  public c(int paramInt) { super(paramInt); }
  
  public static class a extends ab<LinearLayout> {
    public ab<Button> cNc = new ab(R.id.btn_test_print);
    
    public ab<Button> dwM = new ab(R.id.btn_delete);
    
    public a(int param1Int) { super(param1Int); }
  }
  
  public static class b extends ab<LinearLayout> {
    public ab<Button> dwN = new ab(R.id.btn_save_print);
    
    public b(int param1Int) { super(param1Int); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */