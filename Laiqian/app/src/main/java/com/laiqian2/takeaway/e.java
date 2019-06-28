package com.laiqian.takeaway;

import java.io.PrintStream;

class e implements al.a {
  e(AbstractPosMainTakeOut paramAbstractPosMainTakeOut, int[] paramArrayOfInt) {}
  
  public void jI(String paramString) {
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("online order result is:");
    stringBuilder.append(paramString);
    printStream.println(stringBuilder.toString());
    AbstractPosMainTakeOut.a(this.drG, AbstractPosMainTakeOut.j(this.drG).oD(paramString));
    this.drG.a(paramString, this.drI);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */