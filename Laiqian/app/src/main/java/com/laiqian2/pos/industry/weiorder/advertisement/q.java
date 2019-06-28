package com.laiqian.pos.industry.weiorder.advertisement;

import android.text.Editable;
import android.text.TextWatcher;
import com.laiqian.util.by;

class q implements TextWatcher {
  q(AdvertisementRegisteredShopFragment paramAdvertisementRegisteredShopFragment) {}
  
  public void afterTextChanged(Editable paramEditable) { AdvertisementRegisteredShopFragment.a(this.cxP).setActivated(by.isNull(paramEditable.toString()) ^ true); }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\advertisement\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */