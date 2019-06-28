package com.laiqian.ui.stickylistheaders;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;

class g implements AbsListView.MultiChoiceModeListener {
  g(StickyListHeadersListView paramStickyListHeadersListView) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) { return (StickyListHeadersListView.access$700(this.dDI) != null) ? StickyListHeadersListView.access$700(this.dDI).onActionItemClicked(paramActionMode, paramMenuItem) : 0; }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) { return (StickyListHeadersListView.access$700(this.dDI) != null) ? StickyListHeadersListView.access$700(this.dDI).onCreateActionMode(paramActionMode, paramMenu) : 0; }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {
    if (StickyListHeadersListView.access$700(this.dDI) != null)
      StickyListHeadersListView.access$700(this.dDI).onDestroyActionMode(paramActionMode); 
  }
  
  public void onItemCheckedStateChanged(ActionMode paramActionMode, int paramInt, long paramLong, boolean paramBoolean) {
    if (StickyListHeadersListView.access$700(this.dDI) != null) {
      paramInt = StickyListHeadersListView.access$400(this.dDI).lp(paramInt);
      StickyListHeadersListView.access$700(this.dDI).onItemCheckedStateChanged(paramActionMode, paramInt, paramLong, paramBoolean);
    } 
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) { return (StickyListHeadersListView.access$700(this.dDI) != null) ? StickyListHeadersListView.access$700(this.dDI).onPrepareActionMode(paramActionMode, paramMenu) : 0; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\stickylistheaders\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */