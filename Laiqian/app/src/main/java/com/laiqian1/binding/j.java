package com.laiqian.binding;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.b.f;

@Metadata
final class j implements View.OnClickListener {
  j(BindingWechatSelectActivity paramBindingWechatSelectActivity) {}
  
  public final void onClick(View paramView) {
    BindingWechatSelectActivity.d(this.aJl);
    BindingWechatSelectActivity.a(this.aJl, new BindingWechatSelectActivity.a(this.aJl, "4"));
    BindingWechatSelectActivity.a a = BindingWechatSelectActivity.e(this.aJl);
    if (a == null)
      f.aQI(); 
    a.execute(new Void[0]);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\binding\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */