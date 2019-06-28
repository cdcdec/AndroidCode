package com.laiqian.pos;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.main.a.a;
import com.laiqian.util.av;
import com.laiqian.util.by;

class bh implements View.OnClickListener {
  bh(bg parambg) {}
  
  public void onClick(View paramView) {
    str = this.cgC.cgz.getText().toString().trim();
    if (str == null || "".equals(str)) {
      Toast.makeText(this.cgC.mContext, this.cgC.mContext.getString(2131626806), 0).show();
      return;
    } 
    try {
      bg.a(this.cgC, Double.parseDouble(str));
      av av = new av(this.cgC.mContext);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(bg.a(this.cgC));
      stringBuilder.append("");
      av.qU(stringBuilder.toString());
      av.close();
      Context context = this.cgC.mContext;
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.cgC.mContext.getString(2131626807));
      stringBuilder.append(str);
      Toast.makeText(context, stringBuilder.toString(), 0).show();
      if (by.parseDouble(str) > 0.0D)
        (new a(this.cgC.getContext())).dC(false); 
      this.cgC.dismiss();
      return;
    } catch (NumberFormatException str) {
      a.e(str);
      Toast.makeText(this.cgC.mContext, this.cgC.mContext.getString(2131626801), 0).show();
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */