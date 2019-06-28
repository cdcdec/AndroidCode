package com.laiqian.pos.industry.weiorder.advertisement;

import com.a.a.b.e;
import com.google.zxing.WriterException;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.av;
import com.laiqian.util.n;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.e.d;
import kotlin.h;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class u {
  public static final u cxS = new u();
  
  @NotNull
  public final String acL() throws WriterException {
    String str = n.a(true, new Date(System.currentTimeMillis()));
    f.l(str, "orderNo");
    return b(10.0D, str);
  }
  
  @NotNull
  public final String b(double paramDouble, @NotNull String paramString) {
    f.m(paramString, "orderNo");
    String str1 = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("time");
    stringBuffer.append(str1);
    stringBuffer.append("version");
    stringBuffer.append("1");
    stringBuffer.append("xpj_money");
    stringBuffer.append(paramDouble);
    stringBuffer.append("xpj_order_id");
    stringBuffer.append(paramString);
    stringBuffer.append("xpj_shop_id");
    av av2 = RootApplication.getLaiqianPreferenceManager();
    f.l(av2, "RootApplication.getLaiqianPreferenceManager()");
    stringBuffer.append(av2.Tx());
    stringBuffer.append("cjgohnuoeCziiWSz");
    String str3 = stringBuffer.toString();
    f.l(str3, "stringBuffer.toString()");
    Charset charset = d.UTF_8;
    if (str3 == null)
      throw new h("null cannot be cast to non-null type java.lang.String"); 
    byte[] arrayOfByte = str3.getBytes(charset);
    f.l(arrayOfByte, "(this as java.lang.String).getBytes(charset)");
    String str2 = e.g(arrayOfByte);
    str2.getClass();
    f.l(str2, "Objects.requireNonNull(M…oString().toByteArray()))");
    str2 = (String)str2;
    if (str2 == null)
      throw new h("null cannot be cast to non-null type java.lang.String"); 
    str2 = str2.toLowerCase();
    f.l(str2, "(this as java.lang.String).toLowerCase()");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("https://xiao.buslive.cn/sweepCodeSuc?xpj_order_id=");
    stringBuilder.append(paramString);
    stringBuilder.append("&xpj_shop_id=");
    av av1 = RootApplication.getLaiqianPreferenceManager();
    f.l(av1, "RootApplication.getLaiqianPreferenceManager()");
    stringBuilder.append(av1.Tx());
    stringBuilder.append("&xpj_money=");
    stringBuilder.append(paramDouble);
    stringBuilder.append("&time=");
    stringBuilder.append(str1);
    stringBuilder.append("&version=");
    stringBuilder.append("1");
    stringBuilder.append("&sign=");
    stringBuilder.append(str2);
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\advertisemen\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */