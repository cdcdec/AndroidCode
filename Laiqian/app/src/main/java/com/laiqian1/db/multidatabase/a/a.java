package com.laiqian.db.multidatabase.a;

public static enum a {
  aOi("january.db"),
  aOj("february.db"),
  aOk("march.db"),
  aOl("april.db"),
  aOm("may.db"),
  aOn("june.db"),
  aOo("july.db"),
  aOp("august.db"),
  aOq("september.db"),
  aOr("october.db"),
  aOs("november.db"),
  aOt("december.db");
  
  private String aOu;
  
  a(String paramString1) { this.aOu = paramString1; }
  
  public String getDatabaseName() { return this.aOu; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\db\multidatabase\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */