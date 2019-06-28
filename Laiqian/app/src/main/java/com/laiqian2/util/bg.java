package com.laiqian.util;

public final class bg {
  public static boolean equals(Object paramObject1, Object paramObject2) { return (paramObject1 == null) ? ((paramObject2 == null)) : paramObject1.equals(paramObject2); }
  
  public static <T> T requireNonNull(T paramT) {
    if (paramT == null)
      throw new NullPointerException(); 
    return paramT;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */