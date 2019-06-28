package com.laiqian.takeaway;

import android.view.View;
import android.widget.Toast;
import com.laiqian.entity.TakeOrderEntity;

class ae implements View.OnClickListener {
  ae(y paramy, TakeOrderEntity paramTakeOrderEntity) {}
  
  public void onClick(View paramView) {
    if (y.a(this.dsf).Gl()) {
      y.a(this.dsf, paramView, this.drM);
      return;
    } 
    Toast.makeText(y.b(this.dsf), R.string.pos_no_permission, 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */