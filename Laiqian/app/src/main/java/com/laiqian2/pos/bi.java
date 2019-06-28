package com.laiqian.pos;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.laiqian.util.av;

class bi implements View.OnClickListener {
  bi(bg parambg) {}
  
  public void onClick(View paramView) {
    bg.a(this.cgC, 0.0D);
    av av = new av(this.cgC.mContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bg.a(this.cgC));
    stringBuilder.append("");
    av.qU(stringBuilder.toString());
    av.close();
    Context context = this.cgC.mContext;
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.cgC.mContext.getString(2131626807));
    stringBuilder.append(bg.a(this.cgC));
    Toast.makeText(context, stringBuilder.toString(), 0).show();
    this.cgC.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */