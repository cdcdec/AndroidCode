package com.laiqian.print.model.a;

import android.graphics.Bitmap;
import android.text.Layout;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.b.a;
import com.laiqian.print.model.s;
import com.laiqian.print.util.b;
import com.laiqian.print.util.e;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class f extends b {
  public byte[] a(s params, PrintContent.b paramb) { return e.mo(paramb.getString()) ? b(params, paramb) : c(params, paramb); }
  
  protected byte[] b(s params, PrintContent.b paramb) {
    byte b2 = 0;
    b b3 = new b(false);
    String str = paramb.getString();
    Layout.Alignment alignment = paramb.agj();
    byte b1 = b2;
    switch (g.cHq[alignment.ordinal()]) {
      default:
        b1 = b2;
        break;
      case 3:
        b1 = 2;
        break;
      case 1:
        b1 = 1;
        break;
      case 2:
        break;
    } 
    Bitmap bitmap = e.a(str, paramb.agh(), paramb.agi(), this.width);
    if (params.agH()) {
      b3.s(a.e((byte)b1));
      b3.s(a.b(bitmap, this.width));
    } else {
      b3.s(a.a(bitmap, this.width, b1));
    } 
    return b3.toByteArray();
  }
  
  public byte[] c(s params, PrintContent.b paramb) {
    byte b2 = 0;
    b1 = new b(false);
    b1.s(a.agK());
    if (paramb.isBold()) {
      b1.s(a.d((byte)1));
    } else {
      b1.s(a.d((byte)0));
    } 
    b1.s(a.g((byte)0));
    if (paramb.agi() && paramb.agh()) {
      b1.s(a.g((byte)17));
    } else if (paramb.agi() && !paramb.agh()) {
      b1.s(a.g((byte)1));
    } else if (!paramb.agi() && paramb.agh()) {
      b1.s(a.g((byte)16));
    } else {
      b1.s(a.g((byte)0));
    } 
    Layout.Alignment alignment = paramb.agj();
    if (alignment.compareTo(Layout.Alignment.ALIGN_NORMAL) == 0) {
      b1.s(a.e((byte)0));
    } else if (alignment.compareTo(Layout.Alignment.ALIGN_OPPOSITE) == 0) {
      b1.s(a.e((byte)2));
    } else if (alignment.compareTo(Layout.Alignment.ALIGN_CENTER) == 0) {
      b1.s(a.e((byte)1));
    } 
    try {
      String str = paramb.getString();
      if (paramb.agp()) {
        b1.s(a.agM());
        b1.s(a.f((byte)28));
        b1.s(str.getBytes(Charset.forName("cp864")));
        b1.s(a.f((byte)0));
        b1.s(a.agL());
      } else {
        b1.s(str.getBytes("GB2312"));
      } 
      if (paramb.agh())
        b2 = 2; 
      if (e.z(str, b2) != e.jg(this.width))
        b1.s(a.agI()); 
      return b1.toByteArray();
    } catch (UnsupportedEncodingException b1) {
      return null;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */