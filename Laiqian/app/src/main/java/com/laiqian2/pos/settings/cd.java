package com.laiqian.pos.settings;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.Toast;
import com.laiqian.pos.hardware.q;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.util.aq;

class cd extends Handler {
  cd(ShopInfoActivity paramShopInfoActivity) {}
  
  public void handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    if (i != -1) {
      if (i != 1) {
        Toast.makeText(this.cBl.getActivity(), this.cBl.getString(2131630490), 0).show();
        ((ProgressBarCircularIndeterminate)this.cBl.cBh.cAC.getView()).setVisibility(8);
        ((ImageView)this.cBl.cBh.cAB.getView()).setVisibility(8);
        ((ImageView)this.cBl.cBh.cAD.getView()).setVisibility(0);
      } else if (this.cBl.cwb != null) {
        ((ProgressBarCircularIndeterminate)this.cBl.cBh.cAC.getView()).setVisibility(8);
        ((ImageView)this.cBl.cBh.cAB.getView()).setVisibility(0);
        ((ImageView)this.cBl.cBh.cAD.getView()).setVisibility(8);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(q.cll);
        stringBuilder1.append(this.cBl.chv);
        aq.qz(stringBuilder1.toString());
        ShopInfoActivity shopInfoActivity = this.cBl;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(q.cll);
        stringBuilder2.append(this.cBl.chv);
        shopInfoActivity.chZ = stringBuilder2.toString();
        this.cBl.chY = true;
        this.cBl.cAo.jZ(this.cBl.chZ);
        ShopInfoActivity.a(this.cBl, this.cBl.chZ, this.cBl.chY);
      } else {
        ((ProgressBarCircularIndeterminate)this.cBl.cBh.cAC.getView()).setVisibility(8);
        ((ImageView)this.cBl.cBh.cAB.getView()).setVisibility(8);
        ((ImageView)this.cBl.cBh.cAD.getView()).setVisibility(0);
      } 
    } else {
      this.cBl.cAo.Jx();
      ((ProgressBarCircularIndeterminate)this.cBl.cBh.cAC.getView()).setVisibility(8);
      ((ImageView)this.cBl.cBh.cAD.getView()).setVisibility(0);
      ((ImageView)this.cBl.cBh.cAB.getView()).setVisibility(8);
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */