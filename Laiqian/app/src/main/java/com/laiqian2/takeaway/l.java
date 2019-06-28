package com.laiqian.takeaway;

import android.content.ComponentName;
import android.content.Intent;
import android.view.View;

class l implements View.OnClickListener {
  l(AbstractPosMainTakeOut paramAbstractPosMainTakeOut) {}
  
  public void onClick(View paramView) {
    ComponentName componentName = new ComponentName(this.drG, AbstractPosMainTakeOut.a(this.drG));
    Intent intent = new Intent();
    intent.setComponent(componentName);
    intent.putExtra("windowId", AbstractPosMainTakeOut.aqp());
    this.drG.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */