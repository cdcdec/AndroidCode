package com.laiqian.ui.cropper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.cropper.a.d;
import com.laiqian.ui.cropper.cropwindow.CropOverlayView;
import com.laiqian.ui.cropper.cropwindow.a.a;

public class CropImageView extends FrameLayout {
  private static final Rect dya = new Rect();
  
  private int cG = Integer.MAX_VALUE;
  
  private int cH = Integer.MAX_VALUE;
  
  private ImageView dyb;
  
  private CropOverlayView dyc;
  
  private int dyd = 0;
  
  private int dye;
  
  private int dyf;
  
  private int dyg = 1;
  
  private boolean dyh = false;
  
  private int dyi = 1;
  
  private int dyj = 1;
  
  private int dyk = 0;
  
  private Bitmap mBitmap;
  
  public CropImageView(Context paramContext) {
    super(paramContext);
    init(paramContext);
  }
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CropImageView, 0, 0);
    try {
      this.dyg = typedArray.getInteger(R.styleable.CropImageView_guidelines, 1);
      this.dyh = typedArray.getBoolean(R.styleable.CropImageView_fixAspectRatio, false);
      this.dyi = typedArray.getInteger(R.styleable.CropImageView_aspectRatioX, 1);
      this.dyj = typedArray.getInteger(R.styleable.CropImageView_aspectRatioY, 1);
      this.dyk = typedArray.getResourceId(R.styleable.CropImageView_imageResource, 0);
      typedArray.recycle();
      return;
    } finally {
      typedArray.recycle();
    } 
  }
  
  private void init(Context paramContext) {
    View view = LayoutInflater.from(paramContext).inflate(R.layout.crop_image_view, this, true);
    this.dyb = (ImageView)view.findViewById(R.id.ImageView_image);
    setImageResource(this.dyk);
    this.dyc = (CropOverlayView)view.findViewById(R.id.CropOverlayView);
    this.dyc.a(this.dyg, this.dyh, this.dyi, this.dyj);
  }
  
  private static int l(int paramInt1, int paramInt2, int paramInt3) { return (paramInt1 == 1073741824) ? paramInt2 : ((paramInt1 == Integer.MIN_VALUE) ? Math.min(paramInt3, paramInt2) : paramInt3); }
  
  public Bitmap aqZ() {
    null = d.a(this.mBitmap, this.dyb);
    float f1 = this.mBitmap.getWidth() / null.width();
    float f3 = this.mBitmap.getHeight() / null.height();
    float f2 = a.dyD.ard();
    float f8 = null.left;
    float f4 = a.dyE.ard();
    float f7 = null.top;
    float f6 = a.getWidth();
    float f5 = a.getHeight();
    f2 = (f2 - f8) * f1;
    f4 = (f4 - f7) * f3;
    f1 = f6 * f1;
    f5 *= f3;
    f6 = 0.0F;
    f3 = f2;
    if (f2 < 0.0F) {
      f1 = this.mBitmap.getWidth();
      f3 = 0.0F;
    } 
    if (f4 < 0.0F) {
      f2 = this.mBitmap.getHeight();
      f4 = f6;
    } else {
      f2 = f5;
    } 
    f5 = f1;
    if (f3 + f1 > this.mBitmap.getWidth())
      f5 = this.mBitmap.getWidth() - f3; 
    f1 = f2;
    if (f4 + f2 > this.mBitmap.getHeight())
      f1 = this.mBitmap.getHeight() - f4; 
    Bitmap bitmap2 = Bitmap.createBitmap(this.mBitmap, (int)f3, (int)f4, (int)f5, (int)f1);
    Bitmap bitmap1 = bitmap2;
    if (bitmap2.getWidth() > this.cG) {
      double d = this.cG / bitmap2.getWidth();
      bitmap1 = Bitmap.createScaledBitmap(bitmap2, this.cG, (int)(bitmap2.getHeight() * d), true);
    } 
    bitmap2 = bitmap1;
    if (bitmap1.getHeight() > this.cH) {
      double d = this.cH / bitmap1.getHeight();
      bitmap2 = Bitmap.createScaledBitmap(bitmap1, (int)(bitmap1.getWidth() * d), this.cH, true);
    } 
    return bitmap2;
  }
  
  public void by(int paramInt1, int paramInt2) {
    this.dyi = paramInt1;
    this.dyc.kL(this.dyi);
    this.dyj = paramInt2;
    this.dyc.kM(this.dyj);
  }
  
  public void hd(boolean paramBoolean) { this.dyc.hd(paramBoolean); }
  
  public void kJ(int paramInt) { this.dyc.kJ(paramInt); }
  
  public void kK(int paramInt) {
    if (paramInt != 0) {
      if (this.mBitmap == null)
        return; 
      matrix = new Matrix();
      matrix.postRotate(paramInt);
      try {
        this.mBitmap = Bitmap.createBitmap(this.mBitmap, 0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight(), matrix, true);
        setImageBitmap(this.mBitmap);
        this.dyd += paramInt;
        this.dyd %= 360;
        return;
      } catch (OutOfMemoryError|Exception matrix) {
        return;
      } 
    } 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.dye > 0 && this.dyf > 0) {
      ViewGroup.LayoutParams layoutParams = getLayoutParams();
      layoutParams.width = this.dye;
      layoutParams.height = this.dyf;
      setLayoutParams(layoutParams);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int m = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (this.mBitmap != null) {
      double d2;
      double d1;
      super.onMeasure(paramInt1, paramInt2);
      paramInt1 = i;
      if (i == 0)
        paramInt1 = this.mBitmap.getHeight(); 
      if (j < this.mBitmap.getWidth()) {
        d1 = j / this.mBitmap.getWidth();
      } else {
        d1 = Double.POSITIVE_INFINITY;
      } 
      if (paramInt1 < this.mBitmap.getHeight()) {
        d2 = paramInt1 / this.mBitmap.getHeight();
      } else {
        d2 = Double.POSITIVE_INFINITY;
      } 
      if (d1 != Double.POSITIVE_INFINITY || d2 != Double.POSITIVE_INFINITY) {
        if (d1 <= d2) {
          i = (int)(this.mBitmap.getHeight() * d1);
          paramInt2 = j;
        } else {
          paramInt2 = (int)(this.mBitmap.getWidth() * d2);
          i = paramInt1;
        } 
      } else {
        paramInt2 = this.mBitmap.getWidth();
        i = this.mBitmap.getHeight();
      } 
      paramInt2 = l(m, j, paramInt2);
      paramInt1 = l(k, paramInt1, i);
      this.dye = paramInt2;
      this.dyf = paramInt1;
      Rect rect = d.o(this.mBitmap.getWidth(), this.mBitmap.getHeight(), this.dye, this.dyf);
      this.dyc.l(rect);
      setMeasuredDimension(this.dye, this.dyf);
      return;
    } 
    this.dyc.l(dya);
    setMeasuredDimension(j, i);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    Bundle bundle;
    if (paramParcelable instanceof Bundle) {
      bundle = (Bundle)paramParcelable;
      if (this.mBitmap != null) {
        this.dyd = bundle.getInt("DEGREES_ROTATED");
        int i = this.dyd;
        kK(this.dyd);
        this.dyd = i;
      } 
      super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
      return;
    } 
    super.onRestoreInstanceState(bundle);
  }
  
  public Parcelable onSaveInstanceState() {
    Bundle bundle = new Bundle();
    bundle.putParcelable("instanceState", super.onSaveInstanceState());
    bundle.putInt("DEGREES_ROTATED", this.dyd);
    return bundle;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.mBitmap != null) {
      Rect rect = d.a(this.mBitmap, this);
      this.dyc.l(rect);
      return;
    } 
    this.dyc.l(dya);
  }
  
  public void setImageBitmap(Bitmap paramBitmap) {
    if (paramBitmap == null)
      return; 
    this.mBitmap = paramBitmap;
    this.dyb.setImageBitmap(this.mBitmap);
    if (this.dyc != null)
      this.dyc.ara(); 
  }
  
  public void setImageResource(int paramInt) {
    if (paramInt != 0)
      setImageBitmap(BitmapFactory.decodeResource(getResources(), paramInt)); 
  }
  
  public void setMaxHeight(int paramInt) { this.cH = paramInt; }
  
  public void setMaxWidth(int paramInt) { this.cG = paramInt; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\cropper\CropImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */