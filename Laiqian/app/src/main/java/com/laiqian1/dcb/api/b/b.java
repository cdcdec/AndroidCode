package com.laiqian.dcb.api.b;

import java.text.SimpleDateFormat;
import java.util.Date;

public class b {
  public static String b(long paramLong, String paramString) { return (new SimpleDateFormat(paramString)).format(new Date(paramLong)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */