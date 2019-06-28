package com.laiqian.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.ImageSpan;
import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;
import com.laiqian.print.cardreader.ai;
import com.laiqian.print.model.PrintContent;
import com.laiqian.util.ae;
import java.util.ArrayList;
import java.util.Iterator;

public class o {
  public static int a(ai paramai) {
    switch (paramai.getCode()) {
      default:
        return 0;
      case 2:
        return R.string.card_reader_usage_magnetic;
      case 1:
        break;
    } 
    return R.string.card_reader_usage_ic;
  }
  
  public static int a(PrintContent.b paramb) {
    boolean bool1 = paramb.agi();
    boolean bool2 = paramb.agh();
    return (bool1 && bool2) ? 3 : (bool1 ? 1 : (bool2 ? 2 : 0));
  }
  
  public static int a(PrintContent.b paramb, int paramInt) { return bj(a(paramb), paramInt); }
  
  public static Spannable a(Context paramContext, PrintContent paramPrintContent, int paramInt) {
    ArrayList arrayList = paramPrintContent.Xi();
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
    Iterator iterator = arrayList.iterator();
    int i = 0;
    while (iterator.hasNext()) {
      PrintContent.b b = (PrintContent.b)iterator.next();
      if (!b.agl() && !b.agk() && !b.agn() && !b.ago()) {
        String str = b.cGI.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("\n");
        str = stringBuilder.toString();
        int j = str.length() + i;
        spannableStringBuilder.append(str);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(a(b, paramInt), true), i, j, 18);
        spannableStringBuilder.setSpan(new AlignmentSpan.Standard(b.agj()), i, j, 18);
        i = j;
        continue;
      } 
      if (b.agl()) {
        bitmap = b.agj();
        if (bitmap.compareTo(Layout.Alignment.ALIGN_NORMAL) != 0 && bitmap.compareTo(Layout.Alignment.ALIGN_OPPOSITE) != 0)
          bitmap.compareTo(Layout.Alignment.ALIGN_CENTER); 
        bitmap = null;
        if (b.cGI instanceof Bitmap)
          bitmap = (Bitmap)b.cGI; 
        if (bitmap != null) {
          int j = bitmap.getWidth();
          int k = bitmap.getHeight();
          int m = ae.b(paramContext, 300.0F);
          Bitmap bitmap1 = bitmap;
          if (j > m) {
            double d = m / j;
            bitmap1 = Bitmap.createScaledBitmap(bitmap, m, (int)(k * d), true);
          } 
          spannableStringBuilder.append(" \n");
          i += " \n".length();
          j = i - 2;
          try {
            spannableStringBuilder.setSpan(new ImageSpan(paramContext.getApplicationContext(), bitmap1, false), j, i, 17);
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(b.agj()), j, i, 18);
          } catch (Exception bitmap) {
            a.e(bitmap);
          } 
        } 
      } 
    } 
    return spannableStringBuilder;
  }
  
  public static int bj(int paramInt1, int paramInt2) {
    switch (paramInt1) {
      case 3:
        if (paramInt2 == 58)
          return Build.MODEL.equals("Q10") ? 28 : 36; 
        if (paramInt2 == 80)
          return Build.MODEL.equals("Q10") ? 20 : 26; 
        break;
      case 0:
      case 1:
      case 2:
        if (paramInt2 == 58)
          return Build.MODEL.equals("Q10") ? 14 : 18; 
        if (paramInt2 == 80)
          return Build.MODEL.equals("Q10") ? 10 : 13; 
        break;
    } 
    return 0;
  }
  
  public static int hy(int paramInt) {
    int i = R.string.card_reader_type_unknown;
    return (paramInt != 1) ? i : R.string.card_reader_type_usb;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */