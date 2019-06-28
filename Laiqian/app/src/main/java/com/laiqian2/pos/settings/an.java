package com.laiqian.pos.settings;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.laiqian.models.h;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.b;
import com.laiqian.ui.container.h;

public class an extends ab<ViewGroup> {
  public b cAl = new b(2131297501);
  
  public h cAm = new h(2131297552);
  
  public an(int paramInt) { super(paramInt); }
  
  public void S(View paramView) {
    super.S(paramView);
    ((LinearLayout)this.cAl.getView()).setBackgroundResource(2130772056);
    ((ViewGroup)this.cAm.getView()).setBackgroundResource(2130772050);
  }
  
  public void b(h.c paramc) { this.cAl.b(paramc); }
  
  public void d(h.a parama) { this.cAl.d(parama); }
  
  public void d(h.e parame) { this.cAl.d(parame); }
  
  public void jR(String paramString) { ((EditText)this.cAm.dwQ.getView()).setText(paramString); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */