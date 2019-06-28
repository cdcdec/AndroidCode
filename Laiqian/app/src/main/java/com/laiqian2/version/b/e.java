package com.laiqian.version.b;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

class e implements View.OnClickListener {
  private boolean dJo = true;
  
  private boolean isLoading = false;
  
  e(d paramd, b paramb, int paramInt, View paramView, ListView paramListView, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView) {
    if (this.isLoading) {
      Toast.makeText(d.a(this.dJs), "加载中", 0).show();
      return;
    } 
    this.isLoading = true;
    if (this.dJp.axd() > 0 && this.dJp.axe() > 0) {
      this.dJo = true;
      this.dJp.axc();
      this.dJs.mp(this.qI);
      if (this.dJp.axe() <= 0) {
        this.dhV.setVisibility(8);
        this.dJq.removeFooterView(this.dJr);
        this.dJs.mp(this.qI);
        return;
      } 
    } else {
      this.dJo = false;
    } 
    d.c(this.dJs).b(new f(this), (String)paramView.getTag(), this.dJp.axb(), d.b(this.dJs));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */