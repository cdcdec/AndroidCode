package com.laiqian.l;

import java.util.Comparator;
import java.util.Map;

final class b extends Object implements Comparator<Map.Entry<String, Integer>> {
  public int a(Map.Entry<String, Integer> paramEntry1, Map.Entry<String, Integer> paramEntry2) { return ((String)paramEntry1.getKey()).toString().compareTo((String)paramEntry2.getKey()); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\l\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */