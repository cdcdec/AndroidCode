package com.laiqian.ui.listview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

public class j {
  public static void c(ListView paramListView) {
    if (paramListView == null)
      return; 
    ListAdapter listAdapter = paramListView.getAdapter();
    if (listAdapter == null)
      return; 
    byte b = 0;
    int i = 0;
    while (b < listAdapter.getCount()) {
      View view = listAdapter.getView(b, null, paramListView);
      view.measure(0, 0);
      i += view.getMeasuredHeight();
      b++;
    } 
    ViewGroup.LayoutParams layoutParams = paramListView.getLayoutParams();
    layoutParams.height = i + paramListView.getDividerHeight() * (listAdapter.getCount() - 1);
    paramListView.setLayoutParams(layoutParams);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\listview\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */