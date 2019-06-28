package com.laiqian.util;

import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class cb {
  public static final cb dGB = new cb();
  
  @NotNull
  public final String get(@NotNull String paramString1, @NotNull String paramString2) throws IllegalArgumentException {
    f.m(paramString1, "key");
    f.m(paramString2, "def");
    try {
      Class clazz = Class.forName("android.os.SystemProperties");
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = String.class;
      arrayOfClass[1] = String.class;
      Method method = clazz.getMethod("get", (Class[])Arrays.copyOf(arrayOfClass, arrayOfClass.length));
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString1;
      arrayOfObject[1] = paramString2;
      null = method.invoke(clazz, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      if (null == null)
        throw new h("null cannot be cast to non-null type kotlin.String"); 
      return (String)null;
    } catch (IllegalArgumentException paramString1) {
      throw (Throwable)paramString1;
    } catch (Exception paramString1) {
      return paramString2;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */