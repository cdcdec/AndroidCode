package com.laiqian.pos;

import android.content.Context;
import com.laiqian.backup.ag;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.util.av;
import com.laiqian.util.bn;
import io.reactivex.g.a;
import io.reactivex.m;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.a.a;
import kotlin.jvm.a.b;
import kotlin.jvm.b.f;
import kotlin.jvm.b.m;
import kotlin.k;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class dj {
  public static final dj ciW = new dj();
  
  private final String Dg() {
    if (bn.py(ag.yX()) < '倀')
      return ""; 
    String str = ag.M((Context)RootApplication.zv());
    f.l(str, "BackUpUtility.BackUpToSD…ication.getApplication())");
    return str;
  }
  
  private final String cp(long paramLong) {
    m m = m.fal;
    Object[] arrayOfObject = new Object[5];
    String str2 = a.zR();
    f.l(str2, "BrandManage.getInstance()");
    if (str2.Af()) {
      String str = "91laiqian-singapore";
    } else {
      str2 = "91laiqian-oss-upload";
    } 
    arrayOfObject[0] = str2;
    av av = RootApplication.getLaiqianPreferenceManager();
    f.l(av, "getLaiqianPreferenceManager()");
    arrayOfObject[1] = av.Ea();
    arrayOfObject[2] = (new SimpleDateFormat("yyyy_MM_dd")).format(Long.valueOf(paramLong));
    arrayOfObject[3] = (new SimpleDateFormat("HH_mm")).format(Long.valueOf(paramLong));
    av = RootApplication.getLaiqianPreferenceManager();
    f.l(av, "getLaiqianPreferenceManager()");
    arrayOfObject[4] = av.Ea();
    String str1 = String.format("%s/%s/%s/%s/%s", Arrays.copyOf(arrayOfObject, arrayOfObject.length));
    f.l(str1, "java.lang.String.format(format, *args)");
    return str1;
  }
  
  private final String cq(long paramLong) {
    m m = m.fal;
    Object[] arrayOfObject = new Object[3];
    av av1 = RootApplication.getLaiqianPreferenceManager();
    f.l(av1, "getLaiqianPreferenceManager()");
    arrayOfObject[0] = av1.Ea();
    av1 = RootApplication.getLaiqianPreferenceManager();
    f.l(av1, "getLaiqianPreferenceManager()");
    arrayOfObject[1] = av1.auN();
    StringBuilder stringBuilder = new StringBuilder();
    av av2 = RootApplication.getLaiqianPreferenceManager();
    f.l(av2, "getLaiqianPreferenceManager()");
    stringBuilder.append(av2.Tx());
    stringBuilder.append("-");
    stringBuilder.append((new SimpleDateFormat("yyyy_MM_dd_HH_mm")).format(Long.valueOf(paramLong)));
    arrayOfObject[2] = stringBuilder.toString();
    String str = String.format("%s_%s_%s", Arrays.copyOf(arrayOfObject, arrayOfObject.length));
    f.l(str, "java.lang.String.format(format, *args)");
    return str;
  }
  
  public final void a(@NotNull b<? super Boolean, k> paramb) {
    f.m(paramb, "callback");
    a a = (a)new dl(paramb);
    a.aKh().r((Runnable)new dm(a));
  }
  
  public final void aad() {
    a a = (a)dk.ciX;
    m m = a.aKh();
    dm dm = a;
    if (a != null)
      dm = new dm(a); 
    m.r((Runnable)dm);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */