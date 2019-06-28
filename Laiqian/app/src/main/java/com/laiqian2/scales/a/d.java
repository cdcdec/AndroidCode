package com.laiqian.scales.a;

import android.support.annotation.NonNull;
import com.laiqian.scales.c.a;
import java.util.ArrayList;

public class d implements b {
  @NonNull
  public ArrayList<a> nE(@NonNull String paramString) throws a {
    ArrayList arrayList = new ArrayList();
    String[] arrayOfString = paramString.split("\n\r");
    int i = arrayOfString.length;
    byte b1 = 0;
    while (true) {
      if (b1 < i) {
        str = arrayOfString[b1];
        if (str != null)
          try {
            if (!str.trim().equals(""))
              arrayList.add(a.nF(str.trim())); 
          } catch (IllegalArgumentException str) {} 
        b1++;
        continue;
      } 
      return arrayList;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scales\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */