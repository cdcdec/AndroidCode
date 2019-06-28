package com.laiqian.dcb.api.b;

import android.content.Context;
import android.content.SharedPreferences;

public class g {
  private SharedPreferences aPV;
  
  private SharedPreferences aPW;
  
  private SharedPreferences aPX;
  
  private Context context;
  
  public g(Context paramContext) { this.context = paramContext; }
  
  private SharedPreferences DW() {
    if (this.aPV == null)
      this.aPV = this.context.getSharedPreferences("u_info", 0); 
    return this.aPV;
  }
  
  private SharedPreferences DX() {
    if (this.aPW == null)
      this.aPW = this.context.getSharedPreferences("u_setting", 0); 
    return this.aPW;
  }
  
  private SharedPreferences DY() {
    if (this.aPX == null)
      this.aPX = this.context.getSharedPreferences("settings", 0); 
    return this.aPX;
  }
  
  public long DZ() { return Long.parseLong(DY().getString("shop_id", "-1")); }
  
  public String Ea() { return DW().getString("u_UserPhone", "").trim(); }
  
  public long Eb() { return DW().getLong("u_ClientUserShopID", -1L); }
  
  public String Ec() { return DW().getString("u_pwd", "").trim(); }
  
  public void J(String paramString) { DX().edit().putString("ip", paramString).commit(); }
  
  public void X(long paramLong) { DX().edit().putLong("Heart_Beat_time", paramLong).commit(); }
  
  public void close() {
    if (this.aPV != null)
      this.aPV = null; 
    if (this.aPW != null)
      this.aPW = null; 
  }
  
  public boolean ct(boolean paramBoolean) { return DX().edit().putBoolean("BClientConnectOpen", paramBoolean).commit(); }
  
  public String oC() { return DX().getString("ip", null); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */