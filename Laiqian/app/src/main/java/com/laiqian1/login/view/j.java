package com.laiqian.login.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;

class j extends ArrayAdapter<String> {
  View.OnClickListener aZE = new k(this);
  
  View.OnClickListener aZF = new l(this);
  
  j(LoginActivity paramLoginActivity, Context paramContext, int paramInt1, int paramInt2, List paramList) { super(paramContext, paramInt1, paramInt2, paramList); }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    View view = paramView.findViewById(2131297332);
    view.setTag(Integer.valueOf(paramInt));
    view.setOnClickListener(this.aZF);
    view = paramView.findViewById(2131298764);
    view.setTag(Integer.valueOf(paramInt));
    view.setOnClickListener(this.aZE);
    return paramView;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */