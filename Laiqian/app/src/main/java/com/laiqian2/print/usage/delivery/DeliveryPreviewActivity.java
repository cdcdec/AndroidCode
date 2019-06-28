package com.laiqian.print.usage.delivery;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.InputFilter;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.o;
import com.laiqian.print.usage.receipt.a;
import com.laiqian.print.usage.receipt.ae;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.ui.container.AbstractActivity;
import com.laiqian.util.am;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class DeliveryPreviewActivity extends AbstractActivity implements a {
  private boolean cMo = false;
  
  private w cMp = null;
  
  private ae cMq = new ae(16908290);
  
  private final String cMr = "logo";
  
  private final String cMs = "qrcode";
  
  private String cMt = "";
  
  private void abi() {
    r r = new r(this, new o(this));
    r.setTitle(getString(2131627735));
    r.s(getString(2131627733));
    r.t(getString(2131627734));
    r.oZ(getString(2131627732));
    r.show();
  }
  
  private void aig() {
    f f = new f(this);
    w w1 = new w(this, new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }, f, true);
    w1.setTitle(getString(2131628970));
    w1.show();
  }
  
  private void aih() {
    String str1 = iw(0);
    String str2 = iw(1);
    String str3 = iw(2);
    String str4 = iw(3);
    g g = new g(this);
    w w1 = new w(this, new String[] { str1, str2, str3, str4 }, g, true);
    w1.setTitle(getString(2131628970));
    w1.show();
  }
  
  private void aii() {
    h h = new h(this);
    w w1 = new w(this, new String[] { "58mm", "80mm" }, h, true);
    w1.setTitle(getString(2131629004));
    w1.show();
  }
  
  private void aij() {
    String str1 = getString(2131628980);
    String str2 = getString(2131628977);
    String str3 = getString(2131628979);
    i i = new i(this);
    w w1 = new w(this, new String[] { str1, str2, str3 }, i, true);
    w1.setTitle(getString(2131628985));
    w1.show();
  }
  
  private void aik() {
    String str1 = getString(2131628892);
    String str2 = getString(2131628890);
    j j = new j(this);
    w w1 = new w(this, new String[] { str1, str2 }, j, true);
    w1.setTitle(getString(2131629002));
    w1.show();
  }
  
  private void ail() {
    String str1 = getString(2131628892);
    String str2 = getString(2131628890);
    k k = new k(this);
    w w1 = new w(this, new String[] { str1, str2 }, k, true);
    w1.setTitle(getString(2131628975));
    w1.show();
  }
  
  private void aim() {
    String str1 = getString(2131628980);
    String str2 = getString(2131628981);
    String str3 = getString(2131628977);
    String str4 = getString(2131628979);
    m m = new m(this);
    w w1 = new w(this, new String[] { str1, str2, str3, str4 }, m, true);
    w1.setTitle(getString(2131628995));
    w1.show();
  }
  
  private void ain() {
    n n = new n(this);
    w w1 = new w(this, new String[] { 
          "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
          "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }, n, true);
    w1.setTitle(getString(2131628967));
    w1.show();
  }
  
  private void aio() { this.cMp.ahz(); }
  
  private void iu(int paramInt) {
    intent = new Intent("android.media.action.IMAGE_CAPTURE");
    null = new StringBuilder();
    null.append(Environment.getExternalStorageDirectory());
    null.append("/laiqian/");
    null.append("logo");
    this.cMt = null.toString();
    file = new File(this.cMt);
    try {
      intent.putExtra("output", Uri.fromFile(file));
    } catch (Exception file) {
      a.e(file);
    } 
    try {
      startActivityForResult(intent, paramInt);
      return;
    } catch (ActivityNotFoundException intent) {
      Toast.makeText(this, "找不到相机应用", 0).show();
      return;
    } 
  }
  
  private void iv(int paramInt) {
    if (Build.VERSION.SDK_INT >= 19)
      try {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        startActivityForResult(intent, paramInt);
        return;
      } catch (Exception exception) {
        a.e(exception);
        return;
      }  
    try {
      Intent intent = new Intent("android.intent.action.PICK");
      intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
      startActivityForResult(intent, paramInt);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  private String iw(int paramInt) {
    switch (paramInt) {
      default:
        return "";
      case 1:
      case 2:
      case 3:
        return String.format("%d %s", new Object[] { Integer.valueOf(paramInt), getString(2131630323) });
      case 0:
        break;
    } 
    return getString(2131628986);
  }
  
  private void save() {
    this.cMp.Kq();
    Toast.makeText(this, 2131628397, 0).show();
  }
  
  private void setListeners() {
    ((ViewGroup)this.cMq.cNt.cMV.getView()).setOnClickListener(new p(this));
    ((Button)this.cMq.cNt.cNc.getView()).setOnClickListener(new q(this));
    ((ViewGroup)this.cMq.cNt.cNv.getView()).setOnClickListener(new r(this));
    ((EditText)this.cMq.cNt.cNw.dwQ.getView()).addTextChangedListener(new s(this));
    ((ViewGroup)this.cMq.cNt.cNx.getView()).setOnClickListener(new t(this));
    ((ViewGroup)this.cMq.cNt.cMY.getView()).setOnClickListener(new u(this));
    ((ViewGroup)this.cMq.cNt.cNz.getView()).setOnClickListener(new v(this));
    ((EditText)this.cMq.cNt.cNA.dwQ.getView()).addTextChangedListener(new b(this));
    ((ViewGroup)this.cMq.cNt.cNB.getView()).setOnClickListener(new c(this));
    ((ViewGroup)this.cMq.cNt.cMW.getView()).setOnClickListener(new d(this));
    ((ViewGroup)this.cMq.cNt.cNu.getView()).setOnClickListener(new e(this));
  }
  
  private void wR() {
    ((TextView)findViewById(2131299889)).setText(2131628972);
    ((Button)findViewById(2131299879)).setText(getString(2131628864));
    findViewById(2131299879).setOnClickListener(new a(this));
    findViewById(2131299878).setOnClickListener(new l(this));
    ((ViewGroup)this.cMq.cNt.cNy.getView()).setVisibility(8);
    ((ViewGroup)this.cMq.cNt.cMV.getView()).setBackgroundResource(2130772057);
    ((ViewGroup)this.cMq.cNt.cMW.getView()).setBackgroundResource(2130772055);
    ((ViewGroup)this.cMq.cNt.cNu.getView()).setBackgroundResource(2130772050);
    ((ViewGroup)this.cMq.cNt.cNv.getView()).setBackgroundResource(2130772057);
    ((ViewGroup)this.cMq.cNt.cNw.getView()).setBackgroundResource(2130772055);
    ((ViewGroup)this.cMq.cNt.cNx.getView()).setBackgroundResource(2130772057);
    ((ViewGroup)this.cMq.cNt.cMY.getView()).setBackgroundResource(2130772055);
    ((ViewGroup)this.cMq.cNt.cNz.getView()).setBackgroundResource(2130772055);
    ((ViewGroup)this.cMq.cNt.cNA.getView()).setBackgroundResource(2130772054);
    ((ViewGroup)this.cMq.cNt.cNB.getView()).setBackgroundResource(2130772050);
    a(this.cMq.cNt.cMV.cAO, getString(2131628998));
    a(this.cMq.cNt.cMW.cAO, getString(2131628970));
    a(this.cMq.cNt.cNw.cAO, getString(2131629001));
    a(this.cMq.cNt.cNx.cAO, getString(2131629002));
    a(this.cMq.cNt.cMY.cAO, getString(2131628974));
    a(this.cMq.cNt.cNv.cAO, getString(2131628984));
    a(this.cMq.cNt.cNz.cAO, getString(2131628994));
    a(this.cMq.cNt.cNA.cAO, getString(2131628966));
    a(this.cMq.cNt.cNB.cAO, getString(2131628967));
    a(this.cMq.cNt.cNu.cAO, getString(2131628971));
    ((TextView)this.cMq.cNt.cMW.cAP.getView()).setInputType(2);
    ((TextView)this.cMq.cNt.cMW.cAP.getView()).setFilters(new InputFilter[] { new InputFilter.LengthFilter(true) });
  }
  
  public void a(PrintContent paramPrintContent, int paramInt) { a(this.cMq.cNs.cMU, o.a(this, paramPrintContent, paramInt)); }
  
  public void cX(int paramInt) { a(this.cMq.cNt.cNu.cAP, iw(paramInt)); }
  
  public void fX(boolean paramBoolean) {}
  
  public void iA(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 2:
        a(this.cMq.cNt.cNz.cAP, getString(2131628978));
        return;
      case 1:
        a(this.cMq.cNt.cNz.cAP, getString(2131628981));
        return;
      case 0:
        break;
    } 
    a(this.cMq.cNt.cNz.cAP, getString(2131628980));
  }
  
  public void ix(int paramInt) { a(this.cMq.cNt.cNB.cAP, Integer.valueOf(paramInt)); }
  
  public void iy(int paramInt) {
    if (paramInt == 1) {
      a(this.cMq.cNt.cNx.cAP, getString(2131628892));
      return;
    } 
    if (paramInt == 2)
      a(this.cMq.cNt.cNx.cAP, getString(2131628890)); 
  }
  
  public void iz(int paramInt) {
    if (paramInt == 1) {
      a(this.cMq.cNt.cMY.cAP, getString(2131628892));
      return;
    } 
    if (paramInt == 2)
      a(this.cMq.cNt.cMY.cAP, getString(2131628890)); 
  }
  
  public void lQ(String paramString) { a(this.cMq.cNt.cNw.dwQ, paramString); }
  
  public void lR(String paramString) { a(this.cMq.cNt.cNA.dwQ, paramString); }
  
  public void m(int paramInt, String paramString) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      Intent intent = new Intent();
      intent.setClass(this, com.laiqian.ui.cropper.CropImageActivity.class);
      if (paramInt1 != 1 && paramInt1 != 2) {
        uri = paramIntent.getData();
        try {
          InputStream inputStream = getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException uri) {
          a.e(uri);
          uri = null;
        } 
        if (paramInt1 == 3) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(Environment.getExternalStorageDirectory());
          stringBuilder.append("/laiqian/");
          stringBuilder.append("logo");
          this.cMt = stringBuilder.toString();
        } else if (paramInt1 == 4) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(Environment.getExternalStorageDirectory());
          stringBuilder.append("/laiqian/");
          stringBuilder.append("qrcode");
          this.cMt = stringBuilder.toString();
        } 
        if (uri != null)
          am.a(uri, this.cMt); 
      } 
      intent.putExtra("PHOTO_CROP_SAVEPATH", this.cMt);
      startActivityForResult(intent, paramInt1);
      return;
    } 
    if (paramInt2 == 13 && (uri.getAction() != null || uri.getExtras() != null)) {
      if (!uri.getBooleanExtra("PHOTO_CROP_RESULT", false))
        return; 
      switch (paramInt1) {
        default:
          return;
        case 2:
        case 4:
          this.cMp.o(2, this.cMt);
          return;
        case 1:
        case 3:
          break;
      } 
      this.cMp.n(2, this.cMt);
    } 
  }
  
  public void onBackPressed() {
    if (this.cMp.Az()) {
      abi();
      return;
    } 
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427411);
    getWindow().setFeatureInt(7, 2131428168);
    this.cMq.S(findViewById(this.cMq.getId()));
    this.cMp = new w(this, this);
    this.cMp.init();
    wR();
    setListeners();
  }
  
  public void setCopies(int paramInt) {
    a(this.cMq.cNt.cMW.cAP, Integer.valueOf(paramInt));
    if (paramInt <= 1) {
      ((ViewGroup)this.cMq.cNt.cNu.getView()).setVisibility(8);
      ((ViewGroup)this.cMq.cNt.cMW.getView()).setBackgroundResource(2130772051);
      return;
    } 
    ((ViewGroup)this.cMq.cNt.cNu.getView()).setVisibility(0);
    ((ViewGroup)this.cMq.cNt.cMW.getView()).setBackgroundResource(2130772055);
  }
  
  public void setLogo(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 2:
        a(this.cMq.cNt.cNv.cAP, getString(2131628978));
        return;
      case 1:
        a(this.cMq.cNt.cNv.cAP, getString(2131628981));
        return;
      case 0:
        break;
    } 
    a(this.cMq.cNt.cNv.cAP, getString(2131628980));
  }
  
  public void setWidth(int paramInt) { a(this.cMq.cNt.cMV.cAP, String.format("%dmm", new Object[] { Integer.valueOf(paramInt) })); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\delivery\DeliveryPreviewActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */