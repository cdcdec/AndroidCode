package com.laiqian.dcb.api.b;

import com.google.a.a.a.a.a.a;
import java.lang.reflect.InvocationTargetException;

public class f {
  public Object a(String paramString, Object[] paramArrayOfObject) {
    try {
      return Class.forName(paramString).getConstructors()[0].newInstance(paramArrayOfObject);
    } catch (ClassNotFoundException paramString) {
      a.e(paramString);
    } catch (InstantiationException paramString) {
      a.e(paramString);
    } catch (IllegalAccessException paramString) {
      a.e(paramString);
    } catch (IllegalArgumentException paramString) {
      a.e(paramString);
    } catch (InvocationTargetException paramString) {
      a.e(paramString);
    } 
    return null;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */