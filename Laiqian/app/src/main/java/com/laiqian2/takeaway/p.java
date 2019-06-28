package com.laiqian.takeaway;

import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;

class p implements View.OnClickListener {
  p(AbstractPosMainTakeOut paramAbstractPosMainTakeOut) {}
  
  public void onClick(View paramView) {
    AbstractPosMainTakeOut.h(this.drG).setRefreshing(true);
    if (AbstractPosMainTakeOut.i(this.drG).Gk() || this.drG.bfn) {
      ArrayList arrayList = AbstractPosMainTakeOut.j(this.drG).oC(AbstractPosMainTakeOut.f(this.drG));
      AbstractPosMainTakeOut.j(this.drG).a(arrayList, this.drG.drE, 2);
      this.drG.drD.sendEmptyMessage(7);
      return;
    } 
    AbstractPosMainTakeOut.h(this.drG).setRefreshing(false);
    Toast.makeText(this.drG, R.string.pos_no_permission, 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */