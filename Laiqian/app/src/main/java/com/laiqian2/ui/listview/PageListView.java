package com.laiqian.ui.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

public class PageListView extends ListView implements AbsListView.OnScrollListener {
  protected static final int NUM_PER_PAGE = 50;
  
  protected LinearLayout.LayoutParams WClayoutParams = new LinearLayout.LayoutParams(-2, -2);
  
  private Context c;
  
  protected LinearLayout mFooterLayout;
  
  protected int mLastItem = 0;
  
  protected k mPageAdapter;
  
  public PageListView(Context paramContext) {
    super(paramContext);
    this.c = paramContext;
    init(paramContext);
  }
  
  public PageListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public PageListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public ListAdapter getAdapter() { return this.mPageAdapter; }
  
  void init(Context paramContext) {
    ProgressBar progressBar = new ProgressBar(paramContext);
    this.mFooterLayout = new LinearLayout(paramContext);
    this.mFooterLayout.addView(progressBar, this.WClayoutParams);
    this.mFooterLayout.setGravity(17);
    addFooterView(this.mFooterLayout);
    setOnScrollListener(this);
  }
  
  protected void initmFooterLayout() { addFooterView(this.mFooterLayout); }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) { this.mLastItem = paramInt1 + paramInt2 - 1; }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    if (this.mLastItem == this.mPageAdapter.getCount() && paramInt == 0) {
      if (this.mPageAdapter.lj(50))
        removeFooterView(this.mFooterLayout); 
      this.mPageAdapter.notifyDataSetChanged();
      ViewGroup.LayoutParams layoutParams = getLayoutParams();
      onMeasure(layoutParams.width, layoutParams.height);
    } 
  }
  
  public boolean removeFooterView(View paramView) { return super.removeFooterView(paramView); }
  
  public void setAdapter(ListAdapter paramListAdapter) {
    if (paramListAdapter == null) {
      removeFooterView(this.mFooterLayout);
      super.setAdapter(paramListAdapter);
      return;
    } 
    this.mPageAdapter = (k)paramListAdapter;
    if (this.mPageAdapter.asa() > 50 && getFooterViewsCount() == 0)
      addFooterView(this.mFooterLayout); 
    super.setAdapter(paramListAdapter);
    if (this.mPageAdapter.asa() <= 50)
      removeFooterView(this.mFooterLayout); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\PageListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */