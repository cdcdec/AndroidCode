package com.laiqian.milestone;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.laiqian.ui.a.l;
import com.laiqian.ui.s;
import com.laiqian.util.ae;

public class c extends l {
  private View aQG;
  
  private TextView bJv;
  
  public c(Context paramContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, @DrawableRes int paramInt3) {
    super(paramContext);
    this.aQG = LayoutInflater.from(paramContext).inflate(2131427723, null);
    setContentView(this.aQG);
    this.bJv = (TextView)s.z(this.aQG, 2131299291);
    setHeight(ae.b(paramContext, paramInt1));
    setWidth(ae.b(paramContext, paramInt2));
    setFocusable(true);
    setBackgroundDrawable(paramContext.getResources().getDrawable(paramInt3));
    this.bJv.setText(paramCharSequence);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */