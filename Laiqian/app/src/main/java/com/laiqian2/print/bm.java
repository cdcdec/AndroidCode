package com.laiqian.print;

public static final enum bm {
  cEf("receipt"),
  cEg("tag"),
  cEh("kitchen"),
  cEi("delivery");
  
  private String name;
  
  bm(String paramString1) { this.name = paramString1; }
  
  public static bm a(bl parambl) {
    StringBuilder stringBuilder;
    switch (parambl.getCode()) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("not supported ");
        stringBuilder.append(parambl.getCode());
        throw new RuntimeException(stringBuilder.toString());
      case 4:
        return cEi;
      case 3:
        return cEh;
      case 2:
        return cEg;
      case 1:
        break;
    } 
    return cEf;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */