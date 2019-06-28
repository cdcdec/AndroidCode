package com.laiqian.pos.settings;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.h;
import com.laiqian.ui.container.w;

public class bd extends ab<ViewGroup> {
  public h cAJ = new h(2131297679);
  
  public w cAK = new w(2131297680);
  
  public w cAL = new w(2131297672);
  
  private a cAM = null;
  
  public bd(int paramInt) { super(paramInt); }
  
  private void abQ() {
    ((ViewGroup)this.cAJ.getView()).setBackgroundResource(2130772056);
    ((ViewGroup)this.cAK.getView()).setBackgroundResource(2130772055);
    ((ViewGroup)this.cAL.getView()).setBackgroundResource(2130772051);
  }
  
  private void adz() {
    ((TextView)this.cAJ.cAO.getView()).setText(getContext().getString(2131629655));
    ((TextView)this.cAL.cAO.getView()).setText(getContext().getString(2131625383));
    ((TextView)this.cAK.cAO.getView()).setText(getContext().getString(2131629659));
  }
  
  public void S(View paramView) {
    super.S(paramView);
    abQ();
    adz();
  }
  
  public static interface a {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */