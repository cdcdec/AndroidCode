package com.laiqian.ui.cropper;

import android.view.View;
import com.laiqian.ui.a.bb;
import io.reactivex.g.a;

class b implements View.OnClickListener {
  b(CropImageActivity paramCropImageActivity) {}
  
  public void onClick(View paramView) {
    this.dxY.dxU = CropImageActivity.a(this.dxY).aqZ();
    if (this.dxY.mWaitingDialog == null) {
      this.dxY.mWaitingDialog = new bb(this.dxY);
      this.dxY.mWaitingDialog.setCancelable(true);
    } 
    this.dxY.mWaitingDialog.show();
    a.aKh().r(new c(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\cropper\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */