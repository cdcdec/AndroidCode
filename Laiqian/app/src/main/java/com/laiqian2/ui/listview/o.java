package com.laiqian.ui.listview;

import android.os.Handler;
import android.os.Message;

class o extends Handler {
  o(ReloadableExpandableListView paramReloadableExpandableListView) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (paramMessage.equals("expand") && ReloadableExpandableListView.access$000(this.dCP).getSharedPreferences("com.laiqian.milestone_preferences", 0).getBoolean("cf_isItemExpandedConf", true))
      for (int i = ReloadableExpandableListView.access$100(this.dCP); i < ReloadableExpandableListView.access$200(this.dCP).getCount(); i++)
        this.dCP.expandGroup(i);  
    if (paramMessage.equals("removeFooterView"))
      this.dCP.removeFooterView(this.dCP.mFooterLayout); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */