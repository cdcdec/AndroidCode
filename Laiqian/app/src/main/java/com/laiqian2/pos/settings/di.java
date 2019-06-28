package com.laiqian.pos.settings;

import android.content.Context;
import android.os.Message;
import com.a.a.b;
import com.laiqian.util.bb;
import com.laiqian.util.bd;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.b.f;

@Metadata
final class di implements Runnable {
  di(ShopMoreInfoSettingsFragment paramShopMoreInfoSettingsFragment) {}
  
  public final void run() {
    Message message = new Message();
    try {
      null = new b((Context)this.cBV.getActivity());
      String str1 = b.afJ;
      String str2 = ShopMoreInfoSettingsFragment.b(this.cBV);
      Object object2 = ShopMoreInfoSettingsFragment.c(this.cBV).get(ShopMoreInfoSettingsFragment.d(this.cBV));
      if (object2 == null)
        f.aQI(); 
      null.e(str1, str2, ((File)object2).getAbsolutePath());
      message.what = 1;
      Object object1 = ShopMoreInfoSettingsFragment.c(this.cBV).get(ShopMoreInfoSettingsFragment.d(this.cBV));
      if (object1 == null)
        f.aQI(); 
      if (((File)object1).exists()) {
        object1 = ShopMoreInfoSettingsFragment.c(this.cBV).get(ShopMoreInfoSettingsFragment.d(this.cBV));
        if (object1 == null)
          f.aQI(); 
        ((File)object1).delete();
      } 
    } catch (Exception exception) {
      if (!bd.bH((Context)this.cBV.getActivity())) {
        message.what = -1;
      } else {
        message.what = 0;
      } 
      bb.e("上传图片到oss失败", exception.toString());
    } 
    this.cBV.adW().sendMessage(message);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */