package com.laiqian.product;

import android.text.method.DigitsKeyListener;
import com.laiqian.infrastructure.R;

class cn extends DigitsKeyListener {
  cn(ck paramck) {}
  
  protected char[] getAcceptedChars() { return this.cRl.getContext().getString(R.string.qrcodeChar).toCharArray(); }
  
  public int getInputType() { return 128; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */