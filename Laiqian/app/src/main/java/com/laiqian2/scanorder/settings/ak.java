package com.laiqian.scanorder.settings;

import android.content.Intent;
import android.view.View;

class ak implements View.OnClickListener {
  ak(ProductManageFragment paramProductManageFragment) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent(this.djs.getActivity(), AdditionalFeeItemsActivity.class);
    this.djs.startActivityForResult(intent, 1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */