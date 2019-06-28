package com.laiqian.print.c;

import android.text.TextUtils;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a implements Serializable {
  private s cGL;
  
  private final ArrayList<PrintContent> cIR = new ArrayList();
  
  private long cIS;
  
  private int mStatus;
  
  private String name;
  
  private String number = null;
  
  public a(s params, List<PrintContent> paramList) {
    this.cGL = params;
    this.cIR.addAll(paramList);
    this.mStatus = 0;
    this.cIS = System.currentTimeMillis();
    this.number = ((PrintContent)paramList.get(0)).lm("number");
    StringBuilder stringBuilder = new StringBuilder();
    Iterator iterator = paramList.iterator();
    while (iterator.hasNext()) {
      String str = ((PrintContent)iterator.next()).lm("name");
      if (str != null) {
        if (stringBuilder.length() > 0)
          stringBuilder.append("/"); 
        stringBuilder.append(str);
      } 
    } 
    this.name = stringBuilder.toString();
    if (TextUtils.isEmpty(this.name)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(params.getName());
      stringBuilder.append(((PrintContent)paramList.get(0)).hashCode());
      this.name = stringBuilder.toString();
    } 
  }
  
  public s aew() { return this.cGL; }
  
  public long ahg() { return this.cIS; }
  
  public ArrayList<PrintContent> ahh() { return this.cIR; }
  
  public String getName() { return this.name; }
  
  public String getNumber() { return this.number; }
  
  public int getStatus() { return this.mStatus; }
  
  public void setStatus(int paramInt) { this.mStatus = paramInt; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */