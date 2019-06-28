package com.laiqian.ui.stickylistheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SectionIndexer;

public class j extends b implements SectionIndexer {
  private final SectionIndexer dDX;
  
  j(Context paramContext, a parama) {
    super(paramContext, parama);
    this.dDX = (SectionIndexer)parama;
  }
  
  public int getPositionForSection(int paramInt) { return lo(this.dDX.getPositionForSection(paramInt)); }
  
  public int getSectionForPosition(int paramInt) {
    paramInt = lp(paramInt);
    return this.dDX.getSectionForPosition(paramInt);
  }
  
  public Object[] getSections() { return this.dDX.getSections(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\stickylistheaders\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */