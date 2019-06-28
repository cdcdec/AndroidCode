package com.laiqian.product.models;

import android.support.annotation.NonNull;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import com.laiqian.product.a.a;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class c implements Serializable, Cloneable {
  public static final String[] cUv = { "0", "4", "3" };
  
  public static final String[] cUw = { "0", "1", "2", "3" };
  
  public int aUH;
  
  public String cUx;
  
  public String cUy;
  
  public long id;
  
  public String name;
  
  public int qty;
  
  public double value;
  
  public c(long paramLong, String paramString1, int paramInt1, int paramInt2, double paramDouble, String paramString2) {
    this.id = paramLong;
    this.name = paramString1;
    this.qty = paramInt1;
    this.aUH = paramInt2;
    this.value = paramDouble;
    this.cUy = paramString2;
    akx();
  }
  
  public static double a(double paramDouble, ArrayList<c> paramArrayList, @NonNull a parama) {
    if (paramArrayList != null) {
      if (paramArrayList.isEmpty())
        return 0.0D; 
      Iterator iterator = a(paramArrayList, parama).iterator();
      double d = paramDouble;
      while (iterator.hasNext()) {
        double d1;
        c c1 = (c)iterator.next();
        if (c1.qty == 0)
          break; 
        switch (c1.aUH) {
          case 3:
            if (RootApplication.zv().getResources().getBoolean(R.bool.is_DiscountConvertion)) {
              d1 = 100.0D - c1.value;
            } else {
              d1 = c1.value;
            } 
            d = by.parseDouble(n.a(Double.valueOf(d * Math.pow(d1 / 100.0D, c1.qty)), true, false, RootApplication.aIS));
            break;
          case 2:
            d = c1.value;
            break;
          case 1:
            d -= c1.value * c1.qty;
            break;
          case 0:
          case 4:
            d += c1.value * c1.qty;
            break;
        } 
      } 
      return (d < 0.0D) ? -paramDouble : (d - paramDouble);
    } 
    return 0.0D;
  }
  
  public static StringBuilder a(StringBuilder paramStringBuilder, ArrayList<c> paramArrayList) {
    if (paramStringBuilder == null) {
      paramStringBuilder = new StringBuilder();
    } else {
      paramStringBuilder.setLength(0);
    } 
    if (paramArrayList != null) {
      if (paramArrayList.isEmpty())
        return paramStringBuilder; 
      for (c c1 : paramArrayList) {
        if (c1.qty != 0) {
          String str;
          paramStringBuilder.append(c1.name);
          if (c1.qty == 1) {
            str = "";
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("x");
            stringBuilder.append(str.qty);
            str = stringBuilder.toString();
          } 
          paramStringBuilder.append(str);
          paramStringBuilder.append("/");
        } 
      } 
      if (paramStringBuilder.length() > 0)
        paramStringBuilder.deleteCharAt(paramStringBuilder.length() - 1); 
      return paramStringBuilder;
    } 
    return paramStringBuilder;
  }
  
  public static ArrayList<c> a(ArrayList<c> paramArrayList, @NonNull a parama) {
    paramArrayList = new ArrayList<c>(paramArrayList);
    switch (parama.getValue()) {
      default:
        return paramArrayList;
      case 1:
        Collections.sort(paramArrayList, new e());
        return paramArrayList;
      case 0:
        break;
    } 
    Collections.sort(paramArrayList, new d());
    return paramArrayList;
  }
  
  public static double as(ArrayList<c> paramArrayList) {
    Iterator iterator = paramArrayList.iterator();
    double d = 0.0D;
    while (iterator.hasNext()) {
      c c1 = (c)iterator.next();
      if (c1.aUH == 0 || c1.aUH == 4)
        d += c1.value * c1.qty; 
    } 
    return d;
  }
  
  public static ArrayList<c> at(ArrayList<c> paramArrayList) {
    ArrayList arrayList = new ArrayList();
    for (c c1 : paramArrayList) {
      if (c1.qty > 0)
        arrayList.add(c1.aky()); 
    } 
    return arrayList;
  }
  
  public static void c(ArrayList<c> paramArrayList1, ArrayList<c> paramArrayList2) { label18: for (c c1 : paramArrayList1) {
      if (paramArrayList2 != null)
        for (c c2 : paramArrayList2) {
          if (c2.id == c1.id) {
            c1.qty = c2.qty;
            boolean bool1 = true;
            continue label18;
          } 
        }  
      boolean bool = false;
      if (!bool)
        c1.qty = 0; 
    }  }
  
  public double aI(double paramDouble) {
    switch (this.aUH) {
      default:
        return 0.0D;
      case 1:
      case 2:
      case 3:
        return 0.0D;
      case 0:
      case 4:
        break;
    } 
    return this.value * paramDouble / 100.0D;
  }
  
  public double aJ(double paramDouble) {
    switch (this.aUH) {
      default:
        return 0.0D;
      case 1:
      case 2:
      case 3:
        return 0.0D;
      case 0:
      case 4:
        break;
    } 
    return this.value * paramDouble / 100.0D * this.qty;
  }
  
  public void akx() {
    StringBuilder stringBuilder1;
    String str2 = RootApplication.zA();
    String str1 = n.b(null, Double.valueOf(this.value), true, false);
    switch (this.aUH) {
      default:
        return;
      case 4:
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("+");
        stringBuilder2.append(str2);
        stringBuilder2.append(str1);
        this.cUx = stringBuilder2.toString();
        return;
      case 3:
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append("%");
        this.cUx = stringBuilder1.toString();
        return;
      case 2:
        this.cUx = str1;
        return;
      case 1:
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("-");
        stringBuilder2.append(stringBuilder1);
        stringBuilder2.append(str1);
        this.cUx = stringBuilder2.toString();
        return;
      case 0:
        break;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("+");
    stringBuilder2.append(stringBuilder1);
    stringBuilder2.append(str1);
    this.cUx = stringBuilder2.toString();
  }
  
  protected c aky() {
    try {
      return (c)super.clone();
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      a.e(cloneNotSupportedException);
      return null;
    } 
  }
  
  public boolean performClick() {
    if (this.qty == 0) {
      this.qty++;
      return true;
    } 
    if (this.aUH == 0 || this.aUH == 1) {
      this.qty++;
      return true;
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\models\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */