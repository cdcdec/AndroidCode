package com.laiqian.basic;

import android.support.annotation.NonNull;
import com.laiqian.infrastructure.R;
import com.laiqian.pos.hardware.RootUrlParameter.ServerType;
import java.util.HashMap;

public class LQKVersion {
  @NonNull
  public static String bD(boolean paramBoolean) {
    switch (zj()) {
      default:
        return "";
      case 4:
        return "fastfood_mobile";
      case 3:
        return "retail_mobile";
      case 2:
        return paramBoolean ? RootApplication.zv().getString(R.string.pos_project_version_fast_food_name) : "fastfood";
      case 1:
        break;
    } 
    return paramBoolean ? RootApplication.zv().getString(R.string.pos_project_version_retail_name) : "retail";
  }
  
  public static Class<?> bF(String paramString) {
    StringBuilder stringBuilder = (Class)zf().zt().get(paramString);
    if (stringBuilder == null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(" does't exist,please see to  com.laiqian.basic.LQKVersion.LQKVersionInterface.getProjectIntentMapping");
      throw new IllegalStateException(stringBuilder.toString());
    } 
    return stringBuilder;
  }
  
  private static a zf() { return RootApplication.zv().zy(); }
  
  public static boolean zg() { return zf().zr(); }
  
  @Deprecated
  public static String zh() { return zi(); }
  
  public static String zi() { return zf().zs(); }
  
  @ProjectType
  public static int zj() { return zf().zj(); }
  
  @NonNull
  public static String zk() { return bD(false); }
  
  public static boolean zl() { return (zj() == 1); }
  
  public static boolean zm() { return (zj() == 2); }
  
  public static int zn() { return zf().zn(); }
  
  public static boolean zo() { return zf().zo(); }
  
  @ServerType
  public static int zp() { return zf().zp(); }
  
  public static String zq() { return zf().zq(); }
  
  static @interface ProjectType {}
  
  public static interface a {
    @ProjectType
    int zj();
    
    int zn();
    
    boolean zo();
    
    @ServerType
    int zp();
    
    String zq();
    
    boolean zr();
    
    String zs();
    
    HashMap<String, Class<?>> zt();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\basic\LQKVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */