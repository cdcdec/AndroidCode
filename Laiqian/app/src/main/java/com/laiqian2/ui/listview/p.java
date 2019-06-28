package com.laiqian.ui.listview;

class p implements Runnable {
  p(ReloadableExpandableListView paramReloadableExpandableListView) {}
  
  public void run() {
    if (ReloadableExpandableListView.access$200(this.dCP).lj(10))
      this.dCP.removeFooterView(this.dCP.mFooterLayout); 
    ReloadableExpandableListView.access$200(this.dCP).notifyDataSetChanged();
    if (ReloadableExpandableListView.access$000(this.dCP).getSharedPreferences("com.laiqian.milestone_preferences", 0).getBoolean("cf_isItemExpandedConf", true))
      for (int i = ReloadableExpandableListView.access$100(this.dCP); i < ReloadableExpandableListView.access$200(this.dCP).getCount(); i++)
        this.dCP.expandGroup(i);  
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */