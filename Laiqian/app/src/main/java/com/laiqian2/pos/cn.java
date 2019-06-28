package com.laiqian.pos;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;
import com.d.a.a.a.b.c;
import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.product.models.g;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import com.laiqian.util.aq;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import java.io.File;
import java.util.HashMap;

class cn implements w.a {
  cn(ProductPictureManagementActivity.d paramd) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    boolean bool;
    this.cib.chz.cht = this.cib.cia;
    this.cib.chz.chu = this.cib.chS;
    null = this.cib.chz;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("products/");
    stringBuilder.append(this.cib.chz.getLaiqianPreferenceManager().Tx());
    stringBuilder.append("/");
    stringBuilder.append(this.cib.chz.chu);
    stringBuilder.append(".png");
    null.chv = stringBuilder.toString();
    null = new c();
    stringBuilder = new StringBuilder();
    stringBuilder.append(RootUrlParameter.cll);
    stringBuilder.append(this.cib.chz.chv);
    null = null.sD(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(Environment.getExternalStorageDirectory());
    stringBuilder.append("/laiqian/ImageCache/");
    null = new File(stringBuilder.toString(), null);
    if (ProductPictureManagementActivity.n(this.cib.chz) == null)
      ProductPictureManagementActivity.b(this.cib.chz, new HashMap()); 
    ProductPictureManagementActivity.n(this.cib.chz).put(this.cib.chz.chu, null);
    if (null != null)
      try {
        if (null.exists())
          null.delete(); 
      } catch (Exception null) {} 
    switch (paramInt) {
      default:
        return;
      case 3:
        null = new g(this.cib.chz);
        bool = null.cM(Long.parseLong(this.cib.chS));
        null.close();
        if (bool) {
          Toast.makeText(this.cib.chz, this.cib.chz.getString(R.string.wechat_product_photo_del_success), 0).show();
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(RootUrlParameter.cll);
          stringBuilder1.append(this.cib.chz.chv);
          aq.qz(stringBuilder1.toString());
          ProductPictureManagementActivity.m(this.cib.chz);
          return;
        } 
        Toast.makeText(this.cib.chz, this.cib.chz.getString(R.string.wechat_product_photo_del_fail), 0).show();
        return;
      case 2:
        intent = new Intent();
        intent.setClass(this.cib.chz, WeChatProductPreview.class);
        intent.putExtra("sImageExtraName", this.cib.chZ);
        this.cib.chz.startActivity(intent);
        return;
      case 1:
        if (!bd.bH(this.cib.chz)) {
          Toast.makeText(this.cib.chz, this.cib.chz.getString(R.string.wechat_product_photo_upload_fail_network), 0).show();
          return;
        } 
        if (this.cib.chz.chl)
          try {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            this.cib.chz.startActivityForResult(intent, 11);
            return;
          } catch (Exception intent) {
            a.e(intent);
            return;
          }  
        try {
          intent = new Intent("android.intent.action.PICK");
          intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
          this.cib.chz.startActivityForResult(intent, 11);
          return;
        } catch (Exception intent) {
          a.e(intent);
          return;
        } 
      case 0:
        break;
    } 
    if (!bd.bH(this.cib.chz)) {
      Toast.makeText(this.cib.chz, this.cib.chz.getString(R.string.wechat_product_photo_upload_fail_network), 0).show();
      return;
    } 
    intent = new Intent("android.media.action.IMAGE_CAPTURE");
    intent.putExtra("output", Uri.fromFile((File)ProductPictureManagementActivity.n(this.cib.chz).get(this.cib.chz.chu)));
    if (n.c(this.cib.chz.getActivity(), intent)) {
      this.cib.chz.startActivityForResult(intent, 12);
      return;
    } 
    n.eP(R.string.pos_no_capture);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */