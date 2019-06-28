package com.laiqian.rx.b;

import android.view.View;
import android.widget.ListView;
import io.reactivex.annotations.NonNull;
import io.reactivex.c.g;

final class k extends Object implements g<Boolean> {
  k(ListView paramListView, View paramView) {}
  
  public void a(@NonNull Boolean paramBoolean) throws Exception {
    if (paramBoolean.booleanValue()) {
      this.dhU.removeFooterView(this.dhV);
      this.dhU.addFooterView(this.dhV);
      return;
    } 
    this.dhU.removeFooterView(this.dhV);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\rx\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */