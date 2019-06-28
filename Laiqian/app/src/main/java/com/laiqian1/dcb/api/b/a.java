package com.laiqian.dcb.api.b;

import android.content.Context;
import java.io.File;

public class a {
  public static String j(Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getFilesDir().getParent());
    stringBuilder.append(File.separator);
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */