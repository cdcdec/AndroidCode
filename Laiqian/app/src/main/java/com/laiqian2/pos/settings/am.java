package com.laiqian.pos.settings;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.o;
import com.laiqian.util.bt;

public class am extends ab<ViewGroup> {
  public o cAj = new o(2131297517);
  
  public o cAk = new o(2131297503);
  
  public am(int paramInt) { super(paramInt); }
  
  public void S(View paramView) {
    super.S(paramView);
    TextView textView = (TextView)this.cAj.cAO.getView();
    String str1 = getContext().getString(2131629620);
    String str2 = getContext().getString(2131629614);
    bt.a a = bt.a.rX("#DF554A");
    textView.setText(bt.a(str1, new String[] { str2 }, new bt.a[] { a }));
    textView = (TextView)this.cAk.cAO.getView();
    str1 = getContext().getString(2131629616);
    str2 = getContext().getString(2131629614);
    a = bt.a.rX("#DF554A");
    textView.setText(bt.a(str1, new String[] { str2 }, new bt.a[] { a }));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */