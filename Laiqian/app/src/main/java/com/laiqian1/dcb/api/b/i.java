package com.laiqian.dcb.api.b;

import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.b.d;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class i {
  @NotNull
  private static String aPY = "client.txt";
  
  @NotNull
  private static String aPZ = "back.txt";
  
  @NotNull
  private static final SimpleDateFormat aQa;
  
  @NotNull
  private static final SimpleDateFormat aQb;
  
  public static final a aQc = new a(null);
  
  static  {
    aQa = new SimpleDateFormat("MM-dd-HH-mm-ss", Locale.CHINA);
    aQb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  }
  
  @Metadata
  public static final class a {
    private a() {}
    
    @NotNull
    public final String Ef() { return i.Ed(); }
    
    @NotNull
    public final SimpleDateFormat Eg() { return i.Ee(); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */