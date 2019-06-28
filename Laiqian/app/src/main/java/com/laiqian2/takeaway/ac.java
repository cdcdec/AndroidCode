package com.laiqian.takeaway;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.laiqian.entity.TakeOrderEntity;

class ac implements View.OnClickListener {
  ac(y paramy, TakeOrderEntity paramTakeOrderEntity) {}
  
  public void onClick(View paramView) {
    if (y.a(this.dsf).Gn()) {
      Intent intent = y.b(this.dsf).getIntent();
      intent.putExtra("order", this.drM.getId());
      intent.putExtra("customerID", this.drM.IO());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.drM.getSerialNumber());
      stringBuilder.append("");
      intent.putExtra("orderIndex", stringBuilder.toString());
      y.b(this.dsf).setResult(-1, intent);
      y.b(this.dsf).finish();
      return;
    } 
    Toast.makeText(y.b(this.dsf), R.string.pos_no_permission, 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */