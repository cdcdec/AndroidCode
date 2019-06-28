package com.laiqian.ui.container;

import android.support.v7.widget.AppCompatRadioButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.laiqian.infrastructure.R;

public class i extends ab<ViewGroup> {
  public static final int aCt = R.layout.item_layout_horizontal_radio;
  
  public ab<AppCompatRadioButton> dwR = new ab(R.id.apb_left_radio);
  
  public ab<AppCompatRadioButton> dwS = new ab(R.id.apb_right_radio);
  
  a dwT;
  
  public i(int paramInt) { super(paramInt); }
  
  public void S(View paramView) {
    super.S(paramView);
    ((AppCompatRadioButton)this.dwR.getView()).setOnCheckedChangeListener(new j(this));
    ((AppCompatRadioButton)this.dwS.getView()).setOnCheckedChangeListener(new k(this));
  }
  
  public void a(a parama) { this.dwT = parama; }
  
  public static interface a {
    void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\container\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */