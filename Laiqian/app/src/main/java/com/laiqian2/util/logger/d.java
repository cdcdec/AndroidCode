package com.laiqian.util.logger;

public class d {
  private String abb;
  
  private String className;
  
  private String dHk;
  
  private String exceptionMessage;
  
  public d() {}
  
  public d(String paramString1, String paramString2) {
    this.abb = paramString1;
    this.exceptionMessage = paramString2;
  }
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4) {
    this.className = paramString1;
    this.dHk = paramString2;
    this.abb = paramString3;
    this.exceptionMessage = paramString4;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{className='");
    stringBuilder.append(this.className);
    stringBuilder.append('\'');
    stringBuilder.append(", methodName='");
    stringBuilder.append(this.dHk);
    stringBuilder.append('\'');
    stringBuilder.append(", errorCode='");
    stringBuilder.append(this.abb);
    stringBuilder.append('\'');
    stringBuilder.append(", exceptionMessage='");
    stringBuilder.append(this.exceptionMessage);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\logger\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */