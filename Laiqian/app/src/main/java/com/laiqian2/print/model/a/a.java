package com.laiqian.print.model.a;

import android.graphics.Bitmap;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.b;
import com.laiqian.print.model.s;

public class a implements b {
  private final b cHn;
  
  private final String cHo;
  
  private final String cHp;
  
  public a(b paramb, String paramString1, String paramString2) {
    this.cHn = paramb;
    this.cHo = paramString1;
    this.cHp = paramString2;
  }
  
  private PrintContent b(PrintContent paramPrintContent) {
    PrintContent.a a1 = new PrintContent.a();
    int i = paramPrintContent.Xi().size();
    for (byte b1 = 0; b1 < i; b1++) {
      Bitmap bitmap = (PrintContent.b)paramPrintContent.Xi().get(b1);
      int j = bitmap.agr();
      int k = bitmap.getType();
      if (bitmap.agl()) {
        bitmap = bitmap.getBitmap();
        if (bitmap != null)
          a1.c(new PrintContent.b(bitmap, j, k)); 
      } else if (bitmap.agk()) {
        a1.c(bitmap);
      } else if (bitmap.agn()) {
        a1.c(bitmap);
      } else if (bitmap.vS()) {
        String str2 = bitmap.getString();
        String str1 = str2;
        if (str2.contains(s(this.cHo, 10)))
          str1 = str2.replaceAll(this.cHo, this.cHp); 
        a1.c(new PrintContent.b(str1, j, k));
      } 
    } 
    a1.ih(paramPrintContent.getCopies());
    return a1.afV();
  }
  
  private String s(String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b1 = 0; b1 < paramInt; b1++)
      stringBuilder.append(paramString); 
    return stringBuilder.toString();
  }
  
  public byte[] a(PrintContent paramPrintContent, s params) { return this.cHn.a(b(paramPrintContent), params); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */