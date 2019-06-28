package com.laiqian.pos.industry.weiorder;

import android.content.Intent;
import android.view.View;

class aj implements View.OnClickListener {
  aj(TakeOutGuideActivity paramTakeOutGuideActivity) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.ctg, com.laiqian.takeaway.ConcretePosMainTakeOut.class);
    this.ctg.startActivity(intent);
    this.ctg.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */