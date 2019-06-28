package com.laiqian.repair;

import android.app.Dialog;
import android.os.Handler;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.r;

public abstract class f<E extends d> extends Object {
  private final int COMPLETE = 1;
  
  private Dialog cXX;
  
  private E cXY;
  
  private r cXZ;
  
  private String cYa;
  
  private boolean cYb;
  
  private final int cYc = 0;
  
  private Handler handler = new i(this);
  
  protected ActivityRoot mActivity;
  
  public f(ActivityRoot paramActivityRoot, E paramE) {
    this.mActivity = paramActivityRoot;
    this.cXY = paramE;
    this.cXX = new bb(this.mActivity);
    this.cYb = false;
  }
  
  protected abstract String a(E paramE);
  
  protected abstract void a(E paramE, boolean paramBoolean);
  
  public void ame() {
    if (this.cXZ == null) {
      this.cXZ = new r(this.mActivity, true, new g(this), false);
      this.cXZ.arn().setText(R.string.pos_repair_self_self);
      this.cXZ.setTitle(this.cXY.title);
      this.cXZ.s(this.cXY.acL);
    } 
    this.cXZ.show();
  }
  
  protected abstract boolean b(E paramE);
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repair\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */