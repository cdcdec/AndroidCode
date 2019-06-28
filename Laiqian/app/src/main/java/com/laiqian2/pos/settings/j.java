package com.laiqian.pos.settings;

import java.util.Comparator;
import java.util.Map;

class j extends Object implements Comparator<Map.Entry<String, Integer>> {
  j(InitialSettingsActivity paramInitialSettingsActivity) {}
  
  public int a(Map.Entry<String, Integer> paramEntry1, Map.Entry<String, Integer> paramEntry2) { return ((String)paramEntry1.getKey()).toString().compareTo((String)paramEntry2.getKey()); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */