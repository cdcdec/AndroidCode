package com.laiqian.auth;

import com.squareup.moshi.Json;

public class au {
  public static final au aEu = new au(false, false, Short.parseShort("-1"), 0.0D);
  
  @Json(name = "hasPrivilegeLimitation")
  public final boolean aEq;
  
  @Json(name = "isModifyMemberPrivilegeAllowed")
  public final boolean aEr;
  
  @Json(name = "limitType")
  public final short aEs;
  
  @Json(name = "limitAmount")
  public final double aEt;
  
  public au(boolean paramBoolean1, boolean paramBoolean2, short paramShort, double paramDouble) {
    this.aEq = paramBoolean1;
    this.aEr = paramBoolean2;
    this.aEs = paramShort;
    this.aEt = paramDouble;
  }
  
  public static boolean a(au paramau) { return (paramau == null) ? true : ((paramau.aEs < 0)); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */