package com.laiqian.ui.recycleview.pagerecyclerview;

import android.util.Log;
import android.view.View;
import com.laiqian.util.bb;

class b implements View.OnLayoutChangeListener {
  b(PageRecyclerView paramPageRecyclerView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    this.dDj.removeOnLayoutChangeListener(this);
    paramInt1 = this.dDj.getPaddingLeft();
    paramInt2 = this.dDj.getPaddingRight();
    paramInt3 = this.dDj.getPaddingTop();
    paramInt4 = this.dDj.getPaddingBottom();
    PageRecyclerView.a(this.dDj, this.dDj.getWidth() - paramInt1 - paramInt2);
    PageRecyclerView.b(this.dDj, this.dDj.getHeight() - paramInt3 - paramInt4);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onLayoutChange: mScrollWidth:");
    stringBuilder.append(PageRecyclerView.a(this.dDj));
    stringBuilder.append(",mScrollHeight:");
    stringBuilder.append(PageRecyclerView.b(this.dDj));
    stringBuilder.append(",mCurrentPage:");
    stringBuilder.append(PageRecyclerView.c(this.dDj));
    stringBuilder.append(",mFirstLayout:");
    stringBuilder.append(PageRecyclerView.d(this.dDj));
    Log.d("PageRecyclerView", stringBuilder.toString());
    if (PageRecyclerView.d(this.dDj))
      if (PageRecyclerView.e(this.dDj) == 0) {
        PageRecyclerView.c(this.dDj, PageRecyclerView.c(this.dDj) * PageRecyclerView.a(this.dDj));
      } else {
        PageRecyclerView.c(this.dDj, PageRecyclerView.c(this.dDj) * PageRecyclerView.b(this.dDj));
      }  
    PageRecyclerView.a(this.dDj, false);
    stringBuilder = new StringBuilder();
    stringBuilder.append("onLayoutChange: mScrollOffset:");
    stringBuilder.append(PageRecyclerView.f(this.dDj));
    bb.f("PageRecyclerView", stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\recycleview\pagerecyclerview\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */