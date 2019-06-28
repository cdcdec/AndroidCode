package com.laiqian.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MagicTextView extends TextView {
  private static final int OFFSET = 20;
  
  private static final int REFRESH = 1;
  
  private static final int SCROLL = 2;
  
  private static final int UP = 1;
  
  DecimalFormat fnum;
  
  private double mCurValue;
  
  private double mGalValue;
  
  private Handler mHandler = new j(this);
  
  private int mHeight;
  
  private double mRate;
  
  private int mState = 0;
  
  private double mValue;
  
  private int rate = 1;
  
  private boolean refreshing;
  
  public MagicTextView(Context paramContext) { super(paramContext); }
  
  public MagicTextView(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  public MagicTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) { super(paramContext, paramAttributeSet, paramInt); }
  
  private void doScroll(int paramInt) {
    if (this.mState == paramInt && this.refreshing)
      return; 
    this.mState = paramInt;
    this.rate = 1;
    this.mGalValue = this.mValue;
    this.mHandler.sendEmptyMessage(1);
  }
  
  public double getValue() { return this.mValue; }
  
  public void onScrollChanged() {
    Message message = this.mHandler.obtainMessage();
    message.what = 2;
    message.arg1 = 1;
    this.mHandler.sendMessage(message);
  }
  
  public void setValue(double paramDouble, String paramString) {
    double d;
    this.fnum = new DecimalFormat(paramString);
    this.mCurValue = Double.parseDouble(paramString);
    if (isShown()) {
      d = paramDouble;
    } else {
      d = 0.0D;
    } 
    this.mGalValue = d;
    this.mValue = paramDouble;
    this.mRate = this.mValue / 12.0D;
    this.mRate = (new BigDecimal(this.mRate)).setScale(2, 4).doubleValue();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\MagicTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */