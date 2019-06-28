package com.laiqian.member.transfer;

import android.content.Context;
import android.widget.TextView;
import com.laiqian.ui.a.d;
import com.laiqian.vip.R;

public class b extends d {
  private TextView bHj = (TextView)findViewById(R.id.tv_import_loading);
  
  public b(Context paramContext) {
    super(paramContext, R.layout.dialog_import_loading);
    setCanceledOnTouchOutside(false);
  }
  
  public void show() {
    super.show();
    setOnKeyListener(new c(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\transfer\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */