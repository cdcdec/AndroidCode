package com.laiqian.intro.appintro;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.laiqian.infrastructure.R;
import java.util.ArrayList;
import java.util.List;

class h implements i {
  private List<ImageView> aXA;
  
  private int aXB;
  
  private LinearLayout aXz;
  
  private Context mContext;
  
  public View ai(@NonNull Context paramContext) {
    this.mContext = paramContext;
    this.aXz = (LinearLayout)View.inflate(paramContext, R.layout.default_indicator, null);
    return this.aXz;
  }
  
  public void eI(int paramInt) {
    for (byte b = 0; b < this.aXB; b++) {
      int j;
      if (b == paramInt) {
        j = R.drawable.indicator_dot_white;
      } else {
        j = R.drawable.indicator_dot_grey;
      } 
      Drawable drawable = k.getDrawable(this.mContext, j);
      ((ImageView)this.aXA.get(b)).setImageDrawable(drawable);
    } 
  }
  
  public void initialize(int paramInt) {
    this.aXA = new ArrayList();
    this.aXB = paramInt;
    for (byte b = 0; b < paramInt; b++) {
      ImageView imageView = new ImageView(this.mContext);
      imageView.setImageDrawable(k.getDrawable(this.mContext, R.drawable.indicator_dot_grey));
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
      this.aXz.addView(imageView, layoutParams);
      this.aXA.add(imageView);
    } 
    eI(0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\intro\appintro\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */