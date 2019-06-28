package com.laiqian.pos;

import com.laiqian.infrastructure.R;
import com.squareup.a.l;

class ci implements l {
  ci(ProductPictureManagementActivity.a parama, ProductPictureManagementActivity.a.a parama1) {}
  
  public void onError() {
    this.chH.chK.setVisibility(8);
    this.chH.chI.setVisibility(8);
    this.chH.chJ.setImageResource(R.drawable.error);
    this.chH.chJ.setVisibility(0);
  }
  
  public void onSuccess() {
    this.chH.chK.setVisibility(8);
    this.chH.chI.setVisibility(8);
    this.chH.chJ.setVisibility(0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */