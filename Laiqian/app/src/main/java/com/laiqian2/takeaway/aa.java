package com.laiqian.takeaway;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.laiqian.entity.TakeOrderEntity;
import java.util.ArrayList;

class aa implements View.OnClickListener {
  aa(y paramy, String paramString, int paramInt) {}
  
  public void onClick(View paramView) {
    if (y.a(this.dsf).Gk()) {
      y.b(this.dsf).sendBroadcast(new Intent("action_openbox"));
      ArrayList arrayList = new ArrayList();
      arrayList.add(this.bcD);
      y.d(this.dsf).a(arrayList, y.c(this.dsf), 0);
      TakeOrderEntity takeOrderEntity = (TakeOrderEntity)y.e(this.dsf).get(this.dse);
      y.e(this.dsf).remove(this.dse);
      y.a(this.dsf, takeOrderEntity);
      return;
    } 
    Toast.makeText(y.b(this.dsf), R.string.pos_no_permission, 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */