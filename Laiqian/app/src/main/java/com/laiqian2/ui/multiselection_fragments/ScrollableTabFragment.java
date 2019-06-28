package com.laiqian.ui.multiselection_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.listview.HorizontalListView;
import com.laiqian.ui.listview.i;
import com.laiqian.util.bb;

public class ScrollableTabFragment extends Fragment {
  private final String dCR = "ScrollableTabFragment";
  
  View dCS;
  
  HorizontalListView dCT;
  
  private View dCU;
  
  private Button dCV;
  
  private AdapterView.OnItemClickListener onItemClickListener;
  
  public View asc() { return this.dCU; }
  
  public void lk(int paramInt) {
    byte b;
    int m = ((i)this.dCT.getAdapter()).arZ();
    int i3 = this.dCT.getChildAt(0).getWidth();
    int i2 = this.dCT.getWidth();
    int n = this.dCT.getLeft() - this.dCS.getLeft();
    int i1 = this.dCS.getRight() - this.dCT.getRight();
    int i = this.dCT.getWidth() / i3 / 2;
    int k = (i2 - i3) / 2;
    int i4 = this.dCT.getFirstVisiblePosition();
    int i5 = this.dCT.getLastVisiblePosition();
    if (((i)this.dCT.getAdapter()).arY() > 0) {
      b = ((i)this.dCT.getAdapter()).arY();
    } else {
      b = 0;
    } 
    int j = this.dCT.getAdapter().getCount() * i3 - i2;
    i = j;
    if (j < 0)
      i = 0; 
    k = i3 * paramInt - k;
    j = k;
    if (k < 0)
      j = 0; 
    if (j > i)
      j = i; 
    k = j - this.dCT.arV();
    null = new StringBuilder();
    null.append("itemWidth:");
    null.append(i3);
    null.append(" firstVisiblePostion:");
    null.append(i4);
    null.append(" lastVisiblePosition:");
    null.append(i5);
    null.append(" position:");
    null.append(paramInt);
    null.append(" preSelect:");
    null.append(b);
    null.append(" childCount:");
    null.append(this.dCT.getChildCount());
    null.append(" listview width:");
    null.append(this.dCT.getWidth());
    bb.f("ScrollableTabFragment", null.toString());
    null = new StringBuilder();
    null.append("current scroll:");
    null.append(this.dCT.arV());
    null.append(" ScrollX:");
    null.append(j);
    null.append(" DeltaScroll:");
    null.append(k);
    null.append(" offsetLeft:");
    null.append(n);
    null.append(" offsetRight:");
    null.append(i1);
    bb.f("ScrollableTabFragment", null.toString());
    this.dCT.setSelection(b);
    View view = this.dCT.getSelectedView();
    this.dCT.setSelection(paramInt);
    if (this.dCT.getSelectedView() == null) {
      ((i)this.dCT.getAdapter()).li(paramInt);
      this.dCT.setSelection(paramInt);
      ((i)this.dCT.getAdapter()).notifyDataSetChanged();
    } else {
      if (paramInt > b) {
        if (view == null) {
          i = -i2;
        } else {
          i = view.getRight() - i2;
        } 
        this.dCT.setSelection(paramInt);
        k = this.dCT.getSelectedView().getRight() - i2 - k;
      } else {
        if (view == null) {
          i = 0;
        } else {
          i = view.getRight() - i2;
        } 
        this.dCT.setSelection(paramInt);
        k = this.dCT.getSelectedView().getRight() - i2 - k;
      } 
      this.dCT.setSelection(b);
      TranslateAnimation translateAnimation = new TranslateAnimation(false, (i - i1 + n), false, (k - i1 + n), true, 0.0F, true, 0.0F);
      translateAnimation.setDuration(150L);
      asc().setVisibility(0);
      translateAnimation.setAnimationListener(new b(this, view, m, paramInt));
      translateAnimation.setInterpolator(getActivity(), 17432582);
      asc().clearAnimation();
      asc().startAnimation(translateAnimation);
    } 
    this.dCT.lg(j);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.dCS = paramLayoutInflater.inflate(R.layout.multiselection_201405_fragment_scrollable_tab, paramViewGroup, false);
    this.dCT = (HorizontalListView)this.dCS.findViewById(R.id.multiselection_scrollable_tab_list);
    this.dCT.setOnItemClickListener(new a(this));
    this.dCU = this.dCS.findViewById(R.id.multiselection_scrollable_tab_animator);
    this.dCV = (Button)this.dCS.findViewById(R.id.multiselection_scrollable_tab_button);
    return this.dCS;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\multiselection_fragments\ScrollableTabFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */