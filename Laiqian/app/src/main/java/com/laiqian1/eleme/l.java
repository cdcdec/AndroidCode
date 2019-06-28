package com.laiqian.eleme;

import java.util.ArrayList;

public class l {
  public static ArrayList<j> c(ArrayList<j> paramArrayList, String[] paramArrayOfString) {
    for (j j : paramArrayList) {
      if (paramArrayOfString != null)
        for (byte b = 0; b < paramArrayOfString.length; b++) {
          if (paramArrayOfString[b].equals(j.id))
            j.aRa = true; 
        }  
    } 
    return paramArrayList;
  }
  
  public static String f(ArrayList<j> paramArrayList) {
    if (paramArrayList == null || paramArrayList.size() == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < paramArrayList.size(); b++) {
      if (Boolean.valueOf(String.valueOf(((j)paramArrayList.get(b)).aRa)).booleanValue()) {
        stringBuilder.append(String.valueOf(((j)paramArrayList.get(b)).id));
        stringBuilder.append(",");
      } 
    } 
    String str = stringBuilder.toString();
    return (str.length() == 0) ? "" : str.substring(0, str.length() - 1);
  }
  
  public static String f(String[] paramArrayOfString) {
    if (paramArrayOfString == null || paramArrayOfString.length == 0)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer();
    for (byte b = 0; b < paramArrayOfString.length; b++) {
      stringBuffer.append(paramArrayOfString[b]);
      stringBuffer.append(",");
    } 
    String str = stringBuffer.toString();
    return (str.length() == 0) ? "" : str.substring(0, str.length() - 1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\eleme\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */