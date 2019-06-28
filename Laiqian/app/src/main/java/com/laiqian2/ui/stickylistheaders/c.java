package com.laiqian.ui.stickylistheaders;

import android.database.DataSetObserver;

class c extends DataSetObserver {
  c(b paramb) {}
  
  public void onChanged() {
    b.a(this.dDH, -1);
    b.a(this.dDH).notifyChanged();
    b.b(this.dDH).notifyChanged();
  }
  
  public void onInvalidated() {
    b.a(this.dDH, -1);
    b.a(this.dDH).notifyInvalidated();
    b.b(this.dDH).notifyInvalidated();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\stickylistheaders\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */