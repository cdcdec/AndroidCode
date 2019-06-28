package com.laiqian.ui.cropper;

import android.os.Handler;
import android.os.Message;

class e extends Handler {
  e(CropImageActivity paramCropImageActivity) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (this.dxY.mWaitingDialog != null && !this.dxY.isFinishing()) {
      this.dxY.mWaitingDialog.cancel();
      this.dxY.mWaitingDialog = null;
    } 
    CropImageActivity cropImageActivity = this.dxY;
    int i = paramMessage.what;
    boolean bool = true;
    if (i != 1)
      bool = false; 
    CropImageActivity.a(cropImageActivity, bool);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\cropper\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */