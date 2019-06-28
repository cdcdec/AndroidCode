package com.laiqian.c;

import android.content.Context;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;

public class a {
  private static a aJm;
  
  private static Context context;
  
  private a(Context paramContext) { context = paramContext; }
  
  public static a zR() {
    if (aJm == null)
      aJm = new a(RootApplication.zv()); 
    return aJm;
  }
  
  public boolean Aa() { return false; }
  
  public boolean Ab() { return "evako".equals(LQKVersion.zi()); }
  
  public boolean Ac() { return "menuway".equals(LQKVersion.zi()); }
  
  public boolean Ad() { return ("cashcow".equals(LQKVersion.zi()) || "menuway".equals(LQKVersion.zi()) || "bom".equals(LQKVersion.zi()) || "kassen".equals(LQKVersion.zi()) || Ar() || Av()); }
  
  public boolean Ae() { return "lqk".equals(LQKVersion.zi()); }
  
  public boolean Af() { return ("evako".equals(LQKVersion.zi()) || Ad()); }
  
  public boolean Ag() { return "jindou".equals(LQKVersion.zi()); }
  
  public boolean Ah() { return "lightsblue".equals(LQKVersion.zi()); }
  
  public boolean Ai() { return "cashcow".equals(LQKVersion.zi()); }
  
  public boolean Aj() { return "chuanbei".equals(LQKVersion.zi()); }
  
  public boolean Ak() { return (Aj() || Al()); }
  
  public boolean Al() { return "chuanbeib".equals(LQKVersion.zi()); }
  
  public boolean Am() { return context.getResources().getBoolean(R.bool.show_vip_export_import); }
  
  public boolean An() { return context.getResources().getBoolean(R.bool.show_vip_export); }
  
  public int Ao() { return Ae() ? 1 : (zY() ? 2 : (Ah() ? 3 : (Ai() ? 4 : (Ab() ? 5 : (As() ? 6 : 1))))); }
  
  public int Ap() { return zR().Ab() ? 1006 : (zR().Ah() ? 1007 : (zR().As() ? 1101 : (zR().At() ? 1039 : (zR().zY() ? 1001 : (zR().Ag() ? 1009 : 1000))))); }
  
  public boolean Aq() { return context.getResources().getBoolean(R.bool.show_marketing_messages); }
  
  public boolean Ar() { return "kipcash".equals(LQKVersion.zi()); }
  
  public boolean As() { return "linnuo".equals(LQKVersion.zi()); }
  
  public boolean At() { return "fubei".equals(LQKVersion.zi()); }
  
  public boolean Au() { return (Ah() || As()); }
  
  public boolean Av() { return "ffm".equals(LQKVersion.zi()); }
  
  public boolean Aw() { return (Ae() || As() || Ah() || Ag() || zY() || At()); }
  
  public boolean zS() { return context.getResources().getBoolean(R.bool.show_wallet); }
  
  public boolean zT() { return context.getResources().getBoolean(R.bool.show_sms_setting); }
  
  public boolean zU() { return context.getResources().getBoolean(R.bool.is_ShowingIndustry); }
  
  public boolean zV() { return context.getResources().getBoolean(R.bool.show_phone_order); }
  
  public boolean zW() { return context.getResources().getBoolean(R.bool.show_vip_credit_setting); }
  
  public boolean zX() { return (Ag() || zY()); }
  
  public boolean zY() { return "zhenzhu".equals(LQKVersion.zi()) ? true : ("xingpei".equals(LQKVersion.zi())); }
  
  public boolean zZ() { return context.getResources().getBoolean(R.bool.show_vip_initial_balance); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */