package com.laiqian.i;

import com.squareup.moshi.am;
import com.squareup.moshi.ay;
import com.squareup.moshi.t;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

final class b implements t.a {
  public t<?> a(Type paramType, Set<? extends Annotation> paramSet, am paramam) {
    Class clazz = ay.n(paramType);
    return !paramSet.isEmpty() ? null : ((clazz == java.util.ArrayList.class) ? a.a(paramType, paramam).azJ() : null);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */