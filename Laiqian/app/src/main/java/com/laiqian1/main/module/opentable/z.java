package com.laiqian.main.module.opentable;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.ck;

class z extends RecyclerView.f {
  z(PosActivityOpenTableFragment paramPosActivityOpenTableFragment) {}
  
  public void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {
    int i = paramRecyclerView.aB(paramView);
    int j = ck.b(5.0F, RootApplication.zw());
    if (i == 0) {
      i = ck.b(24.0F, RootApplication.zw());
    } else {
      i = j;
    } 
    paramRect.set(i, 0, j, 0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\opentable\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */