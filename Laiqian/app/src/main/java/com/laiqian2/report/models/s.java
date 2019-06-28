package com.laiqian.report.models;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public class s {
  private String bHC;
  
  private ArrayList<a> bHD;
  
  private ArrayList<a> bHE;
  
  private String bHF;
  
  private String[] bHG;
  
  private String[] bHH;
  
  private ArrayList<HashMap<String, String>> bjv;
  
  private String title;
  
  public s(String paramString1, String paramString2, ArrayList<a> paramArrayList1, ArrayList<a> paramArrayList2, ArrayList<HashMap<String, String>> paramArrayList3, String paramString3, String[] paramArrayOfString) {
    this.title = paramString1;
    this.bHC = paramString2;
    this.bHD = paramArrayList1;
    this.bHE = paramArrayList2;
    this.bjv = paramArrayList3;
    this.bHF = paramString3;
    this.bHG = paramArrayOfString;
  }
  
  public s(String paramString1, String paramString2, ArrayList<a> paramArrayList1, ArrayList<a> paramArrayList2, ArrayList<HashMap<String, String>> paramArrayList3, @Nullable String paramString3, String[] paramArrayOfString1, String[] paramArrayOfString2) {
    this.title = paramString1;
    this.bHC = paramString2;
    this.bHD = paramArrayList1;
    this.bHE = paramArrayList2;
    this.bjv = paramArrayList3;
    this.bHF = paramString3;
    this.bHG = paramArrayOfString1;
    this.bHH = paramArrayOfString2;
  }
  
  public String Th() { return this.bHC; }
  
  @Nullable
  public String Ti() { return this.bHF; }
  
  public String[] Tj() { return this.bHG; }
  
  public String[] Tk() { return this.bHH; }
  
  public ArrayList<a> ana() { return (this.bHD == null) ? new ArrayList() : this.bHD; }
  
  public ArrayList<a> anb() { return (this.bHE == null) ? new ArrayList() : this.bHE; }
  
  public String getTitle() { return this.title; }
  
  public ArrayList<HashMap<String, String>> zJ() { return this.bjv; }
  
  public static class a {
    public String key;
    
    public String value;
    
    public a(String param1String1, String param1String2) {
      this.key = param1String1;
      this.value = param1String2;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */