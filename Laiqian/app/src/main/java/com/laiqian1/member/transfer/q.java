package com.laiqian.member.transfer;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public class q {
  private String bHC;
  
  private ArrayList<Object> bHD;
  
  private ArrayList<Object> bHE;
  
  private String bHF;
  
  private String[] bHG;
  
  private String[] bHH;
  
  private ArrayList<HashMap<String, String>> bjv;
  
  private String title;
  
  public q(String paramString1, String paramString2, ArrayList<Object> paramArrayList1, ArrayList<Object> paramArrayList2, ArrayList<HashMap<String, String>> paramArrayList3, @Nullable String paramString3, String[] paramArrayOfString1, String[] paramArrayOfString2) {
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
  
  public ArrayList<HashMap<String, String>> zJ() { return this.bjv; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\transfer\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */