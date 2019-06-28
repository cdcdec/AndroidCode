package com.laiqian.version.b;

import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import com.laiqian.util.av;

public class a {
  public final String aJg;
  
  public final String aSI;
  
  public final String dIT;
  
  public final String dIU;
  
  public final String dIV;
  
  public final String dIx;
  
  private a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
    this.dIT = paramString1;
    this.dIU = paramString2;
    this.dIx = paramString3;
    this.dIV = paramString4;
    this.aSI = paramString5;
    this.aJg = paramString6;
  }
  
  public static a axa() {
    av av = new av(RootApplication.zv());
    return new a(av.Ea(), av.atr(), "0", "1.0", av.Tx(), RootApplication.zv().getString(R.string.r_channelID));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */