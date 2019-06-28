package com.laiqian.ui.stickylistheaders;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import java.util.WeakHashMap;

class b extends BaseAdapter implements a {
  private final Context context;
  
  int dDA;
  
  private int dDB;
  
  private int dDC;
  
  private int dDD = -1;
  
  private DataSetObservable dDE = new DataSetObservable();
  
  private DataSetObservable dDF = new DataSetObservable();
  
  private DataSetObserver dDG = new c(this);
  
  final a dDw;
  
  private WeakHashMap<View, Void> dDx = new WeakHashMap();
  
  private SparseIntArray dDy = new SparseIntArray();
  
  int dDz;
  
  private Drawable divider;
  
  private int dividerHeight;
  
  b(Context paramContext, a parama) {
    this.context = paramContext;
    this.dDw = parama;
    parama.registerDataSetObserver(this.dDG);
  }
  
  private void ash() {
    boolean bool;
    int i = this.dDw.getCount();
    byte b1 = 0;
    if (i > 0) {
      long l = this.dDw.gZ(0);
      this.dDy.put(0, -1);
      SparseIntArray sparseIntArray = this.dDy;
      byte b2 = 1;
      sparseIntArray.put(1, 0);
      bool = true;
      b1 = 0;
      while (b2 < i) {
        long l1 = this.dDw.gZ(b2);
        if (l != l1) {
          this.dDy.put(b2 + bool + b1, -1);
          bool++;
          l = l1;
        } else {
          this.dDy.put(b2 + bool + b1, -2);
          b1++;
        } 
        this.dDy.put(b2 + bool + b1, b2);
        b2++;
      } 
    } else {
      bool = false;
    } 
    this.dDC = b1;
    this.dDB = bool;
  }
  
  private View asj() {
    View view = new View(this.context);
    view.setBackgroundDrawable(this.divider);
    view.setLayoutParams(new AbsListView.LayoutParams(-1, this.dividerHeight));
    return view;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup) { return this.dDw.a(lp(paramInt), paramView, paramViewGroup); }
  
  void a(DataSetObserver paramDataSetObserver) { this.dDE.registerObserver(paramDataSetObserver); }
  
  public boolean areAllItemsEnabled() { return false; }
  
  int asi() { return this.dDB; }
  
  a ask() { return this.dDw; }
  
  void b(DataSetObserver paramDataSetObserver) { this.dDE.unregisterObserver(paramDataSetObserver); }
  
  boolean dv(View paramView) { return this.dDx.containsKey(paramView); }
  
  public boolean equals(Object paramObject) { return this.dDw.equals(paramObject); }
  
  public long gZ(int paramInt) { return this.dDw.gZ(lp(paramInt)); }
  
  public int getCount() {
    if (this.dDD < 0) {
      this.dDy.clear();
      ash();
      this.dDD = this.dDw.getCount() + this.dDB + this.dDC;
    } 
    return this.dDD;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (getItemViewType(paramInt) == this.dDA)
      return null; 
    paramInt = lp(paramInt);
    return ((BaseAdapter)this.dDw).getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public Object getItem(int paramInt) {
    int i = getItemViewType(paramInt);
    if (i == this.dDA || i == this.dDz)
      return null; 
    paramInt = lp(paramInt);
    return this.dDw.getItem(paramInt);
  }
  
  public long getItemId(int paramInt) {
    if (getItemViewType(paramInt) == this.dDA) {
      paramInt = lp(paramInt);
      return this.dDw.gZ(paramInt);
    } 
    paramInt = lp(paramInt);
    return this.dDw.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt) {
    paramInt = this.dDy.get(paramInt);
    return (paramInt == -1) ? this.dDA : ((paramInt == -2) ? this.dDz : this.dDw.getItemViewType(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    View view;
    int i = getItemViewType(paramInt);
    if (i == this.dDA) {
      this.dDx.remove(paramView);
      paramView = this.dDw.a(lp(paramInt), paramView, paramViewGroup);
      this.dDx.put(paramView, null);
      return paramView;
    } 
    if (i == this.dDz) {
      view = paramView;
      if (paramView == null)
        view = asj(); 
      return view;
    } 
    return this.dDw.getView(lp(paramInt), paramView, view);
  }
  
  public int getViewTypeCount() {
    this.dDA = this.dDw.getViewTypeCount() + 0;
    this.dDz = this.dDw.getViewTypeCount() + 1;
    return this.dDw.getViewTypeCount() + 2;
  }
  
  public boolean hasStableIds() { return this.dDw.hasStableIds(); }
  
  public int hashCode() { return this.dDw.hashCode(); }
  
  public boolean isEmpty() { return this.dDw.isEmpty(); }
  
  public boolean isEnabled(int paramInt) {
    int i = getItemViewType(paramInt);
    int j = this.dDA;
    boolean bool = true;
    if (i == j)
      return true; 
    if (i == this.dDz)
      return false; 
    paramInt = lp(paramInt);
    if (!this.dDw.areAllItemsEnabled()) {
      if (this.dDw.isEnabled(paramInt))
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  int lo(int paramInt) { return this.dDy.indexOfValue(paramInt); }
  
  int lp(int paramInt) {
    int i = getItemViewType(paramInt);
    return (i == this.dDA) ? this.dDy.get(paramInt + 1) : ((i == this.dDz) ? this.dDy.get(paramInt - 1) : this.dDy.get(paramInt));
  }
  
  public void notifyDataSetChanged() { ((BaseAdapter)this.dDw).notifyDataSetChanged(); }
  
  public void notifyDataSetInvalidated() { ((BaseAdapter)this.dDw).notifyDataSetInvalidated(); }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) { this.dDF.registerObserver(paramDataSetObserver); }
  
  void setDivider(Drawable paramDrawable) { this.divider = paramDrawable; }
  
  void setDividerHeight(int paramInt) { this.dividerHeight = paramInt; }
  
  public String toString() { return this.dDw.toString(); }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) { this.dDF.unregisterObserver(paramDataSetObserver); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\stickylistheaders\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */