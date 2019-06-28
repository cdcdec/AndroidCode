package com.laiqian.binding;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.b.f;

@Metadata
final class f implements View.OnClickListener {
  f(BindingAlipaySelectActivity paramBindingAlipaySelectActivity) {}
  
  public final void onClick(View paramView) {
    BindingAlipaySelectActivity.d(this.aJh);
    BindingAlipaySelectActivity.a(this.aJh, new BindingAlipaySelectActivity.a(this.aJh, "4"));
    BindingAlipaySelectActivity.a a = BindingAlipaySelectActivity.e(this.aJh);
    if (a == null)
      f.aQI(); 
    a.execute(new Void[0]);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\binding\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */