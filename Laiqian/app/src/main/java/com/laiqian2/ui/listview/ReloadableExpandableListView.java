package com.laiqian.ui.listview;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class ReloadableExpandableListView extends ExpandableListView implements AbsListView.OnScrollListener {
  protected static final int NUM_PER_PAGE = 10;
  
  Runnable ScrollRunnable = new p(this);
  
  protected LinearLayout.LayoutParams WClayoutParams = new LinearLayout.LayoutParams(-2, -2);
  
  boolean bDefaultExpanded = true;
  
  private Context mContext;
  
  private n mExpandableListAdapter;
  
  protected LinearLayout mFooterLayout;
  
  protected int mLastItem = 0;
  
  Handler myMessageHandler = new o(this);
  
  private int nGroupCount = 0;
  
  public ReloadableExpandableListView(Context paramContext) {
    super(paramContext);
    init(paramContext);
  }
  
  public ReloadableExpandableListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ReloadableExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public void init(Context paramContext) {
    this.mContext = paramContext;
    ProgressBar progressBar = new ProgressBar(paramContext);
    this.mFooterLayout = new LinearLayout(paramContext);
    this.mFooterLayout.addView(progressBar, this.WClayoutParams);
    this.mFooterLayout.setGravity(17);
    addFooterView(this.mFooterLayout);
    setOnScrollListener(this);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) { this.mLastItem = paramInt1 + paramInt2 - 1; }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    this.nGroupCount = this.mExpandableListAdapter.getCount();
    byte b = 0;
    int i = 0;
    while (b < this.nGroupCount) {
      int j = i + true;
      i = j;
      if (isGroupExpanded(b))
        i = j + this.mExpandableListAdapter.getChildrenCount(b); 
      b++;
    } 
    if (this.mLastItem == i && paramInt == 0)
      this.myMessageHandler.post(this.ScrollRunnable); 
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter) {
    super.setAdapter(paramExpandableListAdapter);
    this.mExpandableListAdapter = (n)paramExpandableListAdapter;
    if (this.mExpandableListAdapter.asb() <= 50 && this.mFooterLayout != null)
      removeFooterView(this.mFooterLayout); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\ReloadableExpandableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */