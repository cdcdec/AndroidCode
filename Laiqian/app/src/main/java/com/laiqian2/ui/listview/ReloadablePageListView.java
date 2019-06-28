package com.laiqian.ui.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ListAdapter;
import com.laiqian.util.bb;

public class ReloadablePageListView extends PageListView {
  public boolean bScrolling;
  
  protected q mPageAdapter;
  
  public ReloadablePageListView(Context paramContext) { super(paramContext); }
  
  public ReloadablePageListView(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
    paramInt1 += paramInt2;
    this.mLastItem = paramInt1 - 1;
    if (this.mFooterLayout != null && this.mPageAdapter != null && paramInt3 == this.mPageAdapter.getCount() && getFooterViewsCount() == 0)
      this.mLastItem = paramInt1; 
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onScrollStateChanged ");
    stringBuilder.append(paramInt);
    bb.e("error", stringBuilder.toString());
    if (paramInt == 0) {
      this.bScrolling = false;
    } else {
      this.bScrolling = true;
    } 
    if (this.mLastItem == this.mPageAdapter.getCount() && paramInt == 0) {
      if (this.mPageAdapter.lj(50))
        removeFooterView(this.mFooterLayout); 
      this.mPageAdapter.notifyDataSetChanged();
      ViewGroup.LayoutParams layoutParams = getLayoutParams();
      onMeasure(layoutParams.width, layoutParams.height);
    } 
  }
  
  public void setAdapter(ListAdapter paramListAdapter) {
    super.setAdapter(paramListAdapter);
    this.mPageAdapter = (q)paramListAdapter;
    if (this.mPageAdapter.asb() <= 50 && this.mFooterLayout != null)
      removeFooterView(this.mFooterLayout); 
    this.mPageAdapter.notifyDataSetChanged();
  }
  
  public void setAdapterAdvanced(Context paramContext, ListAdapter paramListAdapter) {
    if (this.mFooterLayout == null)
      init(paramContext); 
    setAdapter(paramListAdapter);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\ReloadablePageListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */