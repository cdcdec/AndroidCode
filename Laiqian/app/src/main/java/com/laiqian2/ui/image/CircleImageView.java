package com.laiqian.ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import com.google.a.a.a.a.a.a;

public class CircleImageView extends ImageView {
  private static final Bitmap.Config ajr;
  
  private static final ImageView.ScaleType dAR = ImageView.ScaleType.CENTER_CROP;
  
  private final RectF dAS = new RectF();
  
  private final RectF dAT = new RectF();
  
  private final Paint dAU = new Paint();
  
  private final Paint dAV = new Paint();
  
  private int dAW = -16777216;
  
  private int dAX = 0;
  
  private int dAY = 0;
  
  private float dAZ;
  
  private float dBa;
  
  private boolean dBb;
  
  private boolean dBc;
  
  private boolean dBd;
  
  private boolean dBe;
  
  private final Paint dyp = new Paint();
  
  private Bitmap mBitmap;
  
  private int mBitmapHeight;
  
  private BitmapShader mBitmapShader;
  
  private int mBitmapWidth;
  
  private final Matrix mShaderMatrix = new Matrix();
  
  private ColorFilter sz;
  
  static  {
    ajr = Bitmap.Config.ARGB_8888;
  }
  
  public CircleImageView(Context paramContext) { this(paramContext, null); }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    init();
    init();
  }
  
  private void art() {
    if (this.dAU != null)
      this.dAU.setColorFilter(this.sz); 
  }
  
  private void aru() {
    if (this.dBe) {
      this.mBitmap = null;
    } else {
      this.mBitmap = w(getDrawable());
    } 
    setup();
  }
  
  private RectF arv() {
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    int j = getHeight() - getPaddingTop() - getPaddingBottom();
    int k = Math.min(i, j);
    float f1 = getPaddingLeft() + (i - k) / 2.0F;
    float f2 = getPaddingTop() + (j - k) / 2.0F;
    float f3 = k;
    return new RectF(f1, f2, f1 + f3, f3 + f2);
  }
  
  private void arw() {
    this.mShaderMatrix.set(null);
    float f1 = this.mBitmapWidth;
    float f3 = this.dAS.height();
    float f4 = this.dAS.width();
    float f5 = this.mBitmapHeight;
    float f2 = 0.0F;
    if (f1 * f3 > f4 * f5) {
      f1 = this.dAS.height() / this.mBitmapHeight;
      f2 = (this.dAS.width() - this.mBitmapWidth * f1) * 0.5F;
      f3 = 0.0F;
    } else {
      f1 = this.dAS.width() / this.mBitmapWidth;
      f3 = (this.dAS.height() - this.mBitmapHeight * f1) * 0.5F;
    } 
    this.mShaderMatrix.setScale(f1, f1);
    this.mShaderMatrix.postTranslate((int)(f2 + 0.5F) + this.dAS.left, (int)(f3 + 0.5F) + this.dAS.top);
    this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
  }
  
  private void init() {
    super.setScaleType(dAR);
    this.dBb = true;
    if (Build.VERSION.SDK_INT >= 21)
      setOutlineProvider(new a(this, null)); 
    if (this.dBc) {
      setup();
      this.dBc = false;
    } 
  }
  
  private void setup() {
    if (!this.dBb) {
      this.dBc = true;
      return;
    } 
    if (getWidth() == 0 && getHeight() == 0)
      return; 
    if (this.mBitmap == null) {
      invalidate();
      return;
    } 
    this.mBitmapShader = new BitmapShader(this.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.dAU.setAntiAlias(true);
    this.dAU.setShader(this.mBitmapShader);
    this.dyp.setStyle(Paint.Style.STROKE);
    this.dyp.setAntiAlias(true);
    this.dyp.setColor(this.dAW);
    this.dyp.setStrokeWidth(this.dAX);
    this.dAV.setStyle(Paint.Style.FILL);
    this.dAV.setAntiAlias(true);
    this.dAV.setColor(this.dAY);
    this.mBitmapHeight = this.mBitmap.getHeight();
    this.mBitmapWidth = this.mBitmap.getWidth();
    this.dAT.set(arv());
    this.dBa = Math.min((this.dAT.height() - this.dAX) / 2.0F, (this.dAT.width() - this.dAX) / 2.0F);
    this.dAS.set(this.dAT);
    if (!this.dBd && this.dAX > 0)
      this.dAS.inset(this.dAX - 1.0F, this.dAX - 1.0F); 
    this.dAZ = Math.min(this.dAS.height() / 2.0F, this.dAS.width() / 2.0F);
    art();
    arw();
    invalidate();
  }
  
  private Bitmap w(Drawable paramDrawable) {
    if (paramDrawable == null)
      return null; 
    if (paramDrawable instanceof BitmapDrawable)
      return ((BitmapDrawable)paramDrawable).getBitmap(); 
    try {
      Bitmap bitmap;
      if (paramDrawable instanceof android.graphics.drawable.ColorDrawable) {
        bitmap = Bitmap.createBitmap(2, 2, ajr);
      } else {
        bitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), ajr);
      } 
      Canvas canvas = new Canvas(bitmap);
      paramDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
      paramDrawable.draw(canvas);
      return bitmap;
    } catch (Exception paramDrawable) {
      a.e(paramDrawable);
      return null;
    } 
  }
  
  public ColorFilter getColorFilter() { return this.sz; }
  
  public ImageView.ScaleType getScaleType() { return dAR; }
  
  protected void onDraw(Canvas paramCanvas) {
    if (this.dBe) {
      super.onDraw(paramCanvas);
      return;
    } 
    if (this.mBitmap == null)
      return; 
    if (this.dAY != 0)
      paramCanvas.drawCircle(this.dAS.centerX(), this.dAS.centerY(), this.dAZ, this.dAV); 
    paramCanvas.drawCircle(this.dAS.centerX(), this.dAS.centerY(), this.dAZ, this.dAU);
    if (this.dAX > 0)
      paramCanvas.drawCircle(this.dAT.centerX(), this.dAT.centerY(), this.dBa, this.dyp); 
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    setup();
  }
  
  public void setAdjustViewBounds(boolean paramBoolean) {
    if (paramBoolean)
      throw new IllegalArgumentException("adjustViewBounds not supported."); 
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    if (paramColorFilter == this.sz)
      return; 
    this.sz = paramColorFilter;
    art();
    invalidate();
  }
  
  public void setImageBitmap(Bitmap paramBitmap) {
    super.setImageBitmap(paramBitmap);
    aru();
  }
  
  public void setImageDrawable(Drawable paramDrawable) {
    super.setImageDrawable(paramDrawable);
    aru();
  }
  
  public void setImageResource(@DrawableRes int paramInt) {
    super.setImageResource(paramInt);
    aru();
  }
  
  public void setImageURI(Uri paramUri) {
    super.setImageURI(paramUri);
    aru();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    setup();
  }
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.setPaddingRelative(paramInt1, paramInt2, paramInt3, paramInt4);
    setup();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType) {
    if (paramScaleType != dAR)
      throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType })); 
  }
  
  @RequiresApi
  private class a extends ViewOutlineProvider {
    private a(CircleImageView this$0) {}
    
    public void getOutline(View param1View, Outline param1Outline) {
      Rect rect = new Rect();
      CircleImageView.a(this.dBf).roundOut(rect);
      param1Outline.setRoundRect(rect, rect.width() / 2.0F);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\image\CircleImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */