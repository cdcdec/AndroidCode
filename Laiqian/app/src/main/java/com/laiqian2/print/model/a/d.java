package com.laiqian.print.model.a;

import android.graphics.Bitmap;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.b;
import com.laiqian.print.model.s;

public class d implements b {
  private final b cHn;
  
  private final int maxWidth;
  
  public d(b paramb, int paramInt) {
    this.cHn = paramb;
    this.maxWidth = paramInt;
  }
  
  private PrintContent c(PrintContent paramPrintContent) {
    PrintContent.a a = new PrintContent.a();
    int i = paramPrintContent.Xi().size();
    byte b1;
    for (b1 = 0; b1 < i; b1++) {
      Bitmap bitmap = (PrintContent.b)paramPrintContent.Xi().get(b1);
      int j = bitmap.agr();
      int k = bitmap.getType();
      if (bitmap.agl()) {
        Bitmap bitmap1 = bitmap.getBitmap();
        if (bitmap1 != null) {
          int m = bitmap1.getWidth();
          int n = bitmap1.getHeight();
          bitmap = bitmap1;
          if (m > this.maxWidth) {
            int i1 = this.maxWidth;
            double d1 = i1 / m;
            bitmap = Bitmap.createScaledBitmap(bitmap1, i1, (int)(n * d1), true);
          } 
          a.c(new PrintContent.b(bitmap, j, k));
        } 
      } else {
        a.c(bitmap);
      } 
    } 
    a.ih(paramPrintContent.getCopies());
    return a.afV();
  }
  
  public byte[] a(PrintContent paramPrintContent, s params) { return this.cHn.a(c(paramPrintContent), params); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */