package com.laiqian.member.setting.sms;

public class b {
  private String bGn;
  
  private String bGo;
  
  private String bGp;
  
  private String message;
  
  public String SL() { return this.bGn; }
  
  public String SM() { return this.bGo; }
  
  public String SN() { return this.bGp; }
  
  public String getMessage() { return this.message; }
  
  public void gf(String paramString) { this.bGn = paramString; }
  
  public void gg(String paramString) { this.bGo = paramString; }
  
  public void gh(String paramString) { this.bGp = paramString; }
  
  public void setMessage(String paramString) { this.message = paramString; }
  
  public enum a {
    bGq("SMS_90360012"),
    bGr("SMS_90360012");
    
    private String bGs;
    
    a(String param1String1) { this.bGs = param1String1; }
    
    public String getValue() { return this.bGs; }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\sms\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */