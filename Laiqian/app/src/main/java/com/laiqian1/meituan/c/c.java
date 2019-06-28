package com.laiqian.meituan.c;

import com.laiqian.meituan.i;
import java.util.ArrayList;
import java.util.HashMap;

public class c {
  public static ArrayList<HashMap<String, Object>> c(ArrayList<i> paramArrayList, String[] paramArrayOfString) {
    ArrayList arrayList = new ArrayList();
    for (i i : paramArrayList) {
      HashMap hashMap = new HashMap();
      hashMap.put("name", i.name);
      hashMap.put("app_poi_code", i.bpR);
      byte b = 0;
      hashMap.put("checked", Boolean.valueOf(false));
      if (paramArrayOfString != null)
        while (b < paramArrayOfString.length) {
          if (paramArrayOfString[b].equals(i.bpR))
            hashMap.put("checked", Boolean.valueOf(true)); 
          b++;
        }  
      arrayList.add(hashMap);
    } 
    return arrayList;
  }
  
  public static String f(ArrayList<HashMap<String, Object>> paramArrayList) {
    if (paramArrayList == null || paramArrayList.size() == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < paramArrayList.size(); b++) {
      if (Boolean.valueOf(String.valueOf(((HashMap)paramArrayList.get(b)).get("checked"))).booleanValue()) {
        stringBuilder.append(String.valueOf(((HashMap)paramArrayList.get(b)).get("app_poi_code")));
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


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */