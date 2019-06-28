package com.laiqian.pos.listview;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

class c extends GestureDetector.SimpleOnGestureListener {
  c(HorizontalListView paramHorizontalListView) {}
  
  private boolean b(MotionEvent paramMotionEvent, View paramView) {
    Rect rect = new Rect();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = paramView.getWidth();
    int k = arrayOfInt[1];
    rect.set(i, k, j + i, paramView.getHeight() + k);
    return rect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
  }
  
  public boolean onDown(MotionEvent paramMotionEvent) { return this.cyv.onDown(paramMotionEvent); }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) { return this.cyv.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2); }
  
  public void onLongPress(MotionEvent paramMotionEvent) {
    int j = this.cyv.getChildCount();
    for (int i = 0; i < j; i++) {
      View view = this.cyv.getChildAt(i);
      if (b(paramMotionEvent, view)) {
        if (HorizontalListView.e(this.cyv) != null) {
          HorizontalListView.e(this.cyv).onItemLongClick(this.cyv, view, HorizontalListView.c(this.cyv) + 1 + i, this.cyv.mAdapter.getItemId(HorizontalListView.c(this.cyv) + 1 + i));
          return;
        } 
        break;
      } 
    } 
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
    synchronized (this.cyv) {
      HorizontalListView horizontalListView = this.cyv;
      horizontalListView.cyi += (int)paramFloat1;
      this.cyv.requestLayout();
      return true;
    } 
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent) {
    for (int i = 0; i < this.cyv.getChildCount(); i++) {
      View view = this.cyv.getChildAt(i);
      if (b(paramMotionEvent, view)) {
        if (HorizontalListView.b(this.cyv) != null)
          HorizontalListView.b(this.cyv).onItemClick(this.cyv, view, HorizontalListView.c(this.cyv) + 1 + i, this.cyv.mAdapter.getItemId(HorizontalListView.c(this.cyv) + 1 + i)); 
        if (HorizontalListView.d(this.cyv) != null) {
          HorizontalListView.d(this.cyv).onItemSelected(this.cyv, view, HorizontalListView.c(this.cyv) + 1 + i, this.cyv.mAdapter.getItemId(HorizontalListView.c(this.cyv) + 1 + i));
          return true;
        } 
        break;
      } 
    } 
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\listview\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */