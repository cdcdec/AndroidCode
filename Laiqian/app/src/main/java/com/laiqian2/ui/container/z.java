package com.laiqian.ui.container;

import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.infrastructure.R;

public final class z {
  public static final int aCt = R.layout.pos_title;
  
  public a dxH;
  
  public FrameLayout dxI;
  
  public TextView dxJ;
  
  public LinearLayout dxK;
  
  public View dxL;
  
  public z(View paramView) {
    this.dxH = new a(paramView.findViewById(R.id.title_back));
    this.dxI = (FrameLayout)paramView.findViewById(R.id.title_center_customize);
    this.dxJ = (TextView)paramView.findViewById(R.id.title_right_text);
    this.dxK = (LinearLayout)paramView.findViewById(R.id.title_right_customize);
    this.dxL = paramView.findViewById(R.id.line_h);
  }
  
  public static z q(Window paramWindow) {
    paramWindow.setFeatureInt(7, aCt);
    return new z(paramWindow.getDecorView());
  }
  
  public static final class a {
    public LinearLayout aQx;
    
    public TextView dxM;
    
    public a(View param1View) {
      this.aQx = (LinearLayout)param1View;
      this.dxM = (TextView)param1View.findViewById(R.id.title_text);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */