package com.laiqian.ui.cropper;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.bb;
import com.laiqian.util.am;

public class CropImageActivity extends ActivityRoot {
  private Handler afE = new e(this);
  
  private String dxO = null;
  
  private CropImageView dxP;
  
  private TextView dxQ;
  
  private TextView dxR;
  
  private TextView dxS;
  
  Bitmap dxT;
  
  Bitmap dxU;
  
  int dxV;
  
  int dxW;
  
  boolean dxX;
  
  bb mWaitingDialog;
  
  int maxHeight = Integer.MAX_VALUE;
  
  int maxWidth = Integer.MAX_VALUE;
  
  public static Intent a(Context paramContext, String paramString, boolean paramBoolean) {
    Intent intent = new Intent(paramContext, CropImageActivity.class);
    intent.putExtra("PHOTO_CROP_SAVEPATH", paramString);
    intent.putExtra("FIX_ASPECT_RATIO", paramBoolean);
    return intent;
  }
  
  private void hc(boolean paramBoolean) {
    Intent intent = new Intent();
    intent.putExtra("PHOTO_CROP_RESULT", paramBoolean);
    setResult(13, intent);
    finish();
  }
  
  private void t(Bitmap paramBitmap) {
    if (paramBitmap != null && !paramBitmap.isRecycled())
      paramBitmap.recycle(); 
  }
  
  public void initData() {
    try {
      this.dxO = getIntent().getStringExtra("PHOTO_CROP_SAVEPATH");
      this.dxV = getIntent().getIntExtra("ASPECT_RATIO_X", 1);
      this.dxW = getIntent().getIntExtra("ASPECT_RATIO_Y", 1);
      this.dxX = getIntent().getBooleanExtra("FIX_ASPECT_RATIO", true);
      this.dxT = am.qs(this.dxO);
      this.dxP.setImageBitmap(this.dxT);
      this.maxHeight = getIntent().getIntExtra("MAX_HEIGHT", 2147483647);
      this.maxWidth = getIntent().getIntExtra("MAX_WIDTH", 2147483647);
      this.dxP.setMaxHeight(this.maxHeight);
      this.dxP.setMaxWidth(this.maxWidth);
    } catch (Exception exception) {
      this.dxO = null;
    } 
    if (this.dxO == null)
      hc(false); 
    this.dxP.hd(this.dxX);
    this.dxP.kJ(1);
    this.dxP.by(this.dxV, this.dxW);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    yR();
    yP();
    initData();
  }
  
  public void onDestroy() {
    super.onDestroy();
    t(this.dxU);
    t(this.dxT);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      hc(false);
      return true;
    } 
    return false;
  }
  
  public void yP() {
    this.dxQ.setOnClickListener(new a(this));
    this.dxR.setOnClickListener(new b(this));
    this.dxS.setOnClickListener(new d(this));
  }
  
  public void yR() {
    setContentView(R.layout.crop_activity_main);
    this.dxP = (CropImageView)findViewById(R.id.CropImageView);
    this.dxQ = (TextView)findViewById(R.id.Button_rotate);
    this.dxR = (TextView)findViewById(R.id.Button_crop);
    this.dxS = (TextView)findViewById(R.id.Button_cancel);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\cropper\CropImageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */