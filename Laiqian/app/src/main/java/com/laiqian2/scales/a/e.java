package com.laiqian.scales.a;

import com.laiqian.scales.c.b;
import com.laiqian.scales.c.c;
import java.util.ArrayList;

public class e implements b {
  public byte[] diz = { 85, -86 };
  
  public ArrayList<? extends b> nE(String paramString) throws a {
    ArrayList arrayList = new ArrayList();
    String[] arrayOfString = paramString.split("\r\n");
    int i = arrayOfString.length;
    byte b1 = 0;
    while (true) {
      if (b1 < i) {
        str = arrayOfString[b1];
        if (str != null)
          try {
            if (!str.trim().equals("")) {
              c c = c.nG(str.trim());
              if (c != null)
                arrayList.add(c); 
            } 
          } catch (IllegalArgumentException str) {} 
        b1++;
        continue;
      } 
      return arrayList;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scales\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */