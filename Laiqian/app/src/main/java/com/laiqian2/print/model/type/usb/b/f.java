package com.laiqian.print.model.type.usb.b;

import java.io.File;
import java.util.ArrayList;

public class f {
  private String aVv;
  
  private int arQ;
  
  private int arR;
  
  i[] cIC;
  
  private String cID;
  
  private String cIE;
  
  private int cIF;
  
  private int cIG;
  
  private int cIp;
  
  private String name;
  
  public f(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, int paramInt5, String paramString4) {
    this.name = paramString1;
    this.arR = paramInt2;
    this.arQ = paramInt1;
    this.cID = paramString2;
    this.cIE = paramString3;
    this.cIF = paramInt3;
    this.cIG = paramInt4;
    this.cIp = paramInt5;
    this.aVv = paramString4;
  }
  
  public static f B(File paramFile) {
    if (paramFile == null)
      return null; 
    if (!paramFile.exists())
      return null; 
    if (!paramFile.isDirectory())
      return null; 
    null = new a(paramFile.getAbsolutePath());
    null = null.lx("bDeviceClass");
    String str1 = null.lx("bDeviceProtocol");
    String str2 = null.lx("bDeviceSubClass");
    String str3 = null.lx("idProduct");
    String str4 = null.lx("idVendor");
    String str5 = null.lx("manufacturer");
    String str6 = null.lx("product");
    String str7 = null.lx("serial");
    String[] arrayOfString = null.lx("uevent").split("\n");
    int j = arrayOfString.length;
    byte b = 0;
    while (true) {
      if (b < j) {
        String str = arrayOfString[b];
        if (str.startsWith("DEVNAME")) {
          String str8 = str.substring("DEVNAME".length() + 1);
          break;
        } 
        b++;
        continue;
      } 
      arrayOfString = null;
      break;
    } 
    if (arrayOfString == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/dev/");
    stringBuilder.append(arrayOfString);
    f f1 = new f(stringBuilder.toString(), e.parseInt(str4, 16), e.parseInt(str3, 16), str6, str5, e.parseInt(null, 16), e.parseInt(str2, 16), e.parseInt(str1, 16), str7);
    File[] arrayOfFile = paramFile.listFiles(new g());
    if (arrayOfFile == null)
      return null; 
    ArrayList arrayList = new ArrayList();
    j = arrayOfFile.length;
    for (b = 0; b < j; b++) {
      i i1 = i.D(arrayOfFile[b]);
      if (i1 != null)
        arrayList.add(i1); 
    } 
    f1.a((i[])arrayList.toArray(new i[0]));
    return f1;
  }
  
  public void a(i[] paramArrayOfi) { this.cIC = paramArrayOfi; }
  
  public String ahb() { return this.cIE; }
  
  public i[] ahc() { return this.cIC; }
  
  public String getName() { return this.name; }
  
  public String getProductName() { return this.cID; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\typ\\usb\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */