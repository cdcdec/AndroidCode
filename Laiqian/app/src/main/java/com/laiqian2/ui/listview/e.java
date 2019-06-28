package com.laiqian.ui.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class e extends BaseAdapter {
  public List<Map<String, String>> aIG;
  
  private FormListView dBW;
  
  public e(Context paramContext, List<Map<String, String>> paramList, FormListView paramFormListView) {
    List<Map<String, String>> list = paramList;
    if (paramList == null)
      list = new ArrayList<Map<String, String>>(); 
    this.aIG = new ArrayList();
    this.aIG.addAll(list);
    this.dBW = paramFormListView;
  }
  
  public int getCount() { return this.aIG.size(); }
  
  public Object getItem(int paramInt) { return this.aIG.get(paramInt); }
  
  public long getItemId(int paramInt) { return paramInt; }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) { return null; }
  
  public void m(List<Map<String, String>> paramList) {
    this.aIG.clear();
    this.aIG.addAll(paramList);
    notifyDataSetChanged();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */