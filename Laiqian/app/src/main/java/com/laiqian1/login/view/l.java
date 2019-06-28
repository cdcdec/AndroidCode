package com.laiqian.login.view;

import android.view.View;
import com.google.a.a.a.a.a.a;
import com.laiqian.util.ae;
import java.lang.reflect.Method;

class l implements View.OnClickListener {
  l(j paramj) {}
  
  public void onClick(View paramView) {
    int i = ((Integer)paramView.getTag()).intValue();
    this.aZG.remove(this.aZG.getItem(i));
    LoginActivity.d(this.aZG.aZD).remove(this.aZG.getItem(i));
    try {
      Method method = android.widget.AutoCompleteTextView.class.getDeclaredMethod("performFiltering", new Class[] { CharSequence.class, int.class });
      method.setAccessible(true);
      method.invoke(this.aZG.aZD.aZg.aZI, new Object[] { this.aZG.aZD.aZg.aZI.getText().toString().trim(), Integer.valueOf(0) });
      method.setAccessible(false);
    } catch (Exception paramView) {
      a.e(paramView);
    } 
    if (this.aZG.getCount() <= 3) {
      this.aZG.aZD.aZg.aZI.setDropDownHeight(-2);
      return;
    } 
    this.aZG.aZD.aZg.aZI.setDropDownHeight(ae.b(this.aZG.aZD, 120.0F));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */