package com.laiqian.print.model.a;

import android.graphics.Bitmap;
import android.text.Layout;
import c.e;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.b;
import com.laiqian.print.model.b.a;
import com.laiqian.print.model.s;
import com.laiqian.print.util.b;
import com.laiqian.print.util.e;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class b implements b {
  protected int width = 58;
  
  public e a(s params, PrintContent paramPrintContent, int paramInt) {
    e e2 = new e();
    e e1 = b(params, paramPrintContent);
    byte b1;
    for (b1 = 0; b1 < paramInt; b1++)
      e1.a(e2, 0L, e1.size()); 
    return e2;
  }
  
  public byte[] a(PrintContent paramPrintContent, s params) {
    b(paramPrintContent, params);
    e e1 = new e();
    e1.Y(c(params, paramPrintContent));
    e e2 = a(params, paramPrintContent, paramPrintContent.getCopies());
    e1.b(e2, e2.size());
    e1.Y(a(params, paramPrintContent));
    return e1.aVc();
  }
  
  public byte[] a(s params, PrintContent.b paramb) { return e.mo(paramb.getString()) ? b(params, paramb) : c(params, paramb); }
  
  public byte[] a(s params, PrintContent paramPrintContent) { return new byte[0]; }
  
  public e b(s params, PrintContent paramPrintContent) {
    e e = new e();
    for (PrintContent.b b1 : paramPrintContent.Xi()) {
      if (b1.agl()) {
        e.Y(d(params, b1));
        continue;
      } 
      if (b1.agk()) {
        e.Y(j(params));
        continue;
      } 
      if (b1.agn()) {
        e.Y(k(params));
        continue;
      } 
      if (b1.ago()) {
        e.Y(l(params));
        continue;
      } 
      if (b1.agq()) {
        e.Y(e(params, b1));
        continue;
      } 
      if (b1.getType() == 0) {
        e.Y((byte[])b1.cGI);
        continue;
      } 
      e.Y(a(params, b1));
    } 
    return e;
  }
  
  protected void b(PrintContent paramPrintContent, s params) {
    if (paramPrintContent.getWidth() != 0) {
      this.width = paramPrintContent.getWidth();
      return;
    } 
    if (params.getWidth() != 0) {
      this.width = params.getWidth();
      return;
    } 
    this.width = 58;
  }
  
  protected byte[] b(s params, PrintContent.b paramb) {
    byte b2 = 0;
    b b3 = new b(false);
    String str = paramb.getString();
    Layout.Alignment alignment = paramb.agj();
    byte b1 = b2;
    switch (c.cHq[alignment.ordinal()]) {
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
  
  protected byte[] c(s params, PrintContent.b paramb) {
    byte b2;
    b1 = new b(false);
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
    switch (c.cHq[alignment.ordinal()]) {
      default:
        b2 = 0;
        break;
      case 3:
        b2 = 2;
        break;
      case 1:
        b2 = 1;
        break;
    } 
    b1.s(a.e((byte)b2));
    try {
      String str = paramb.getString();
      if (paramb.agp()) {
        b1.s(a.agM());
        b1.s(a.f((byte)28));
        b1.s(str.getBytes(Charset.forName("cp864")));
        b1.s(a.f((byte)0));
        b1.s(a.agL());
      } else if (e.mn(str)) {
        b1.s(str.getBytes("TIS-620"));
      } else {
        b1.s(str.getBytes("GB18030"));
      } 
      b1.s(a.agI());
      return b1.toByteArray();
    } catch (UnsupportedEncodingException b1) {
      return null;
    } 
  }
  
  public byte[] c(s params, PrintContent paramPrintContent) { return a.agK(); }
  
  public byte[] d(s params, PrintContent.b paramb) {
    if (!paramb.agl())
      return null; 
    Bitmap bitmap = paramb.getBitmap();
    if (bitmap == null)
      return null; 
    byte b1 = 0;
    b b2 = new b(false);
    Layout.Alignment alignment = paramb.agj();
    if (alignment.compareTo(Layout.Alignment.ALIGN_NORMAL) != 0)
      if (alignment.compareTo(Layout.Alignment.ALIGN_OPPOSITE) == 0) {
        b1 = 2;
      } else if (alignment.compareTo(Layout.Alignment.ALIGN_CENTER) == 0) {
        b1 = 1;
      }  
    if (params.agH()) {
      b2.s(a.e((byte)b1));
      b2.s(a.b(bitmap, this.width));
    } else {
      b2.s(a.agK());
      b2.s(a.agI());
      b2.s(a.a(bitmap, this.width, b1));
    } 
    return b2.toByteArray();
  }
  
  public byte[] e(s params, PrintContent.b paramb) { return a.lr(paramb.getString()); }
  
  public byte[] j(s params) { return a.a((byte)0, (byte)50, (byte)44); }
  
  public byte[] k(s params) { return a.h((byte)1); }
  
  public byte[] l(s params) { return a.bl(1, 1); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */