package com.laiqian.main.module.productcode;

import android.text.method.DigitsKeyListener;

class d extends DigitsKeyListener {
  d(PosActivityProductCodeFragment paramPosActivityProductCodeFragment) {}
  
  protected char[] getAcceptedChars() { return this.bkr.getActivity().getString(2131629177).toCharArray(); }
  
  public int getInputType() { return 128; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productcode\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */