package com.laiqian.i;

import com.squareup.moshi.aa;
import com.squareup.moshi.am;
import java.io.IOException;
import java.lang.reflect.Type;

public class d {
  public static am aXE;
  
  static  {
  
  }
  
  public static <T> T a(aa paramaa, Class<T> paramClass) throws IOException { return (T)aXE.G(paramClass).b(paramaa); }
  
  public static <T> T a(aa paramaa, Type paramType) throws IOException { return (T)aXE.u(paramType).b(paramaa); }
  
  public static <T> T a(String paramString, Type paramType) throws IOException { return (T)aXE.u(paramType).sR(paramString); }
  
  public static <T> String a(T paramT, Class<T> paramClass) { return aXE.G(paramClass).ac(paramT); }
  
  public static <T> String ac(T paramT) { return a(paramT, paramT.getClass()); }
  
  public static <T> T b(String paramString, Class<T> paramClass) throws IOException { return (T)aXE.G(paramClass).sR(paramString); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\i\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */