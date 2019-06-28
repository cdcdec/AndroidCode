package com.laiqian.alipay.setting;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.payment.R;
import com.laiqian.ui.container.ab;

public class d extends ab<RelativeLayout> {
  public static final int aCt = R.layout.item_alipay_setting_checkbox;
  
  public ab<TextView> aCv = new ab(R.id.item_bottom_textview);
  
  public ab<ImageView> aCw = new ab(R.id.item_top_image);
  
  public ab<View> aCx = new ab(R.id.item_selected_view);
  
  public d(int paramInt) { super(paramInt); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\alipay\setting\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */