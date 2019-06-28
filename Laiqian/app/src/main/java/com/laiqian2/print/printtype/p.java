package com.laiqian.print.printtype;

import com.laiqian.print.bm;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class p {
  public static List<String> cJH = Collections.unmodifiableList(Arrays.asList(new String[] { 
          "dish", "dish_reprint", "member_charge", "pre", "settle_receipt", "settle_receipt_reprint", "report", "shift", "takeout", "takeout_reprint", 
          "receipt_not_specified" }));
  
  public static List<String> cJI = Collections.unmodifiableList(Arrays.asList(new String[] { "tag_not_specified", "tag_not_specified_reprint" }));
  
  public static List<String> cJJ = Collections.unmodifiableList(Arrays.asList(new String[] { "kitchen_not_specified", "kitchen_port", "kitchen_port_reprint", "kitchen_total", "kitchen_total_reprint" }));
  
  public static List<String> cJK = Collections.unmodifiableList(Arrays.asList(new String[] { "delivery_not_specified" }));
  
  public static List<String> e(bm parambm) {
    switch (q.bgg[parambm.ordinal()]) {
      default:
        throw new RuntimeException();
      case 4:
        return cJK;
      case 3:
        return cJJ;
      case 2:
        return cJI;
      case 1:
        break;
    } 
    return cJH;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\printtype\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */