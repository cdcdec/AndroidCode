package com.laiqian.ui.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.infrastructure.R;

public class PayTypeLayout extends RelativeLayout {
  private TextView dBP;
  
  private TextView dBS;
  
  private int layout = R.layout.pay_type_layout;
  
  public PayTypeLayout(Context paramContext) { super(paramContext); }
  
  public PayTypeLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    View.inflate(paramContext, this.layout, this);
    this.dBP = (TextView)findViewById(R.id.tvLable);
    this.dBS = (TextView)findViewById(R.id.image);
    setClickable(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\layout\PayTypeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */