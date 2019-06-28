package com.laiqian.ui.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import com.laiqian.infrastructure.R;
import com.laiqian.util.ae;
import java.util.List;
import java.util.Map;

public class l extends SimpleAdapter {
  private List<? extends Map<String, ?>> ari;
  
  private a dCC;
  
  private boolean dCD = true;
  
  private boolean dCE = false;
  
  private int dzB;
  
  private int dzC;
  
  private int dzD;
  
  private LayoutInflater mInflater;
  
  public l(Context paramContext, List<? extends Map<String, ?>> paramList, int paramInt1, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt2, int paramInt3) {
    super(paramContext, paramList, paramInt1, paramArrayOfString, paramArrayOfInt);
    this.dzB = paramInt1;
    this.ari = paramList;
    this.dzC = ae.b(paramContext, paramInt2);
    this.dzD = ae.b(paramContext, paramInt3);
    this.mInflater = (LayoutInflater)paramContext.getSystemService("layout_inflater");
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (paramView == null) {
      this.dCC = new a(this, null);
      paramView = this.mInflater.inflate(R.layout.pos_auto_listview_item, null);
      this.dCC.dCF = (LinearLayout)paramView.findViewById(R.id.pos_auto_listview_wrap);
      this.dCC.dCG = (LinearLayout)paramView.findViewById(R.id.pos_auto_listview_outer);
      View view = this.mInflater.inflate(this.dzB, null);
      this.dCC.dCG.setPadding(this.dzC, this.dzD, this.dzC, this.dzD);
      this.dCC.dCF.addView(view);
      paramView.setTag(this.dCC);
    } else {
      this.dCC = (a)paramView.getTag();
    } 
    if (!this.dCE && this.dCD) {
      if (paramInt == 0) {
        if (getCount() == 1) {
          this.dCC.dCF.setBackgroundResource(R.drawable.selector_rounded_rectangle);
          ((LinearLayout.LayoutParams)this.dCC.dCF.getLayoutParams()).setMargins(0, 0, 0, 0);
        } else {
          this.dCC.dCF.setBackgroundResource(R.drawable.selector_rounded_rectangle_up);
          LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.dCC.dCF.getLayoutParams();
          layoutParams.setMargins(0, 0, 0, -1);
          this.dCC.dCF.setLayoutParams(layoutParams);
        } 
      } else if (paramInt == getCount() - 1) {
        this.dCC.dCF.setBackgroundResource(R.drawable.selector_rounded_rectangle_down);
        ((LinearLayout.LayoutParams)this.dCC.dCF.getLayoutParams()).setMargins(0, 0, 0, 0);
      } else {
        this.dCC.dCF.setBackgroundResource(R.drawable.selector_rounded_rectangle_unupdown);
        ((LinearLayout.LayoutParams)this.dCC.dCF.getLayoutParams()).setMargins(0, 0, 0, -1);
      } 
    } else if (this.dCD) {
      if (paramInt == 0) {
        if (getCount() == 1) {
          this.dCC.dCF.setBackgroundResource(R.drawable.selector_rounded_rectangle_unupdown);
          ((LinearLayout.LayoutParams)this.dCC.dCF.getLayoutParams()).setMargins(0, 0, 0, 0);
        } else {
          this.dCC.dCF.setBackgroundResource(R.drawable.selector_rounded_rectangle_unupdown);
          LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.dCC.dCF.getLayoutParams();
          layoutParams.setMargins(0, 0, 0, 0);
          this.dCC.dCF.setLayoutParams(layoutParams);
        } 
      } else if (paramInt == getCount() - 1) {
        this.dCC.dCF.setBackgroundResource(R.drawable.selector_rounded_rectangle_unupdown);
        ((LinearLayout.LayoutParams)this.dCC.dCF.getLayoutParams()).setMargins(0, 0, 0, 0);
      } else {
        this.dCC.dCF.setBackgroundResource(R.drawable.selector_rounded_rectangle_unupdown);
        ((LinearLayout.LayoutParams)this.dCC.dCF.getLayoutParams()).setMargins(0, 0, 0, 0);
      } 
    } else {
      this.dCC.dCF.setBackgroundResource(R.drawable.selector_rounded_rectangle_unupdown_without_stroke);
      ((LinearLayout.LayoutParams)this.dCC.dCF.getLayoutParams()).setMargins(0, 0, 0, 0);
    } 
    return super.getView(paramInt, paramView, paramViewGroup);
  }
  
  private class a {
    LinearLayout dCF;
    
    LinearLayout dCG;
    
    private a(l this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */