package com.laiqian.entity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.product.a.a;
import com.laiqian.product.models.a;
import com.laiqian.product.models.c;
import com.laiqian.product.models.h;
import com.laiqian.product.models.o;
import com.laiqian.ui.a.g;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

public class aa extends h implements g.b, Serializable, Cloneable {
  private double aJW;
  
  private double aTA;
  
  private String aTB;
  
  private double aTC;
  
  private double aTD;
  
  private String aTE;
  
  private double aTF;
  
  private double aTG;
  
  private double aTH;
  
  private ArrayList<c> aTI = new ArrayList();
  
  private StringBuilder aTJ = new StringBuilder();
  
  private double aTK;
  
  private boolean aTL = false;
  
  private boolean aTM = false;
  
  private long aTN;
  
  private long aTO;
  
  private boolean aTP = false;
  
  private boolean aTQ;
  
  @Nullable
  private ArrayList<o> aTR;
  
  public int aTS = -1;
  
  private ArrayList<o> aTT = new ArrayList();
  
  private int aTU;
  
  private String aTV;
  
  private long aTW;
  
  @NonNull
  private a aTX = new a(-1);
  
  private boolean aTY;
  
  boolean aTZ;
  
  private String aTz;
  
  private StringBuilder aUa;
  
  @Nullable
  private ab aUb;
  
  private StringBuilder aUc;
  
  private boolean aUd;
  
  private double aUe;
  
  private double amountServiceCharge;
  
  public aa(long paramLong, String paramString, double paramDouble) {
    super(paramLong, paramString, null, paramDouble, 1.0D, 0, 0L, "", 0.0D, "", 0.0D);
    this.aTX = new a(-1);
    r(paramDouble);
    q(1.0D);
    GD();
  }
  
  public aa(h paramh, @NonNull a parama) {
    super(paramh);
    this.aTX = parama;
    if (paramh instanceof a) {
      a a1 = (a)paramh;
      b(a1.ako());
      dj(a1.akp());
    } 
    ju(paramh.cUT);
    r(paramh.akI());
    q(1.0D);
    GD();
  }
  
  public aa(h paramh, @NonNull a parama, boolean paramBoolean) {
    super(paramh);
    this.aTX = parama;
    ju(paramh.cUT);
    r(Double.parseDouble(n.a(Double.valueOf(paramh.akI()), true, false, paramh.cUJ)));
    q(1.0D);
    j(false, paramBoolean);
  }
  
  private String a(String paramString, ArrayList<o> paramArrayList) {
    String[] arrayOfString = paramString.split(",");
    StringBuilder stringBuilder = new StringBuilder();
    byte b1 = 0;
    while (b1 < arrayOfString.length) {
      byte b2 = 0;
      while (true) {
        if (b2 < paramArrayList.size()) {
          String str = arrayOfString[b1];
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(((o)paramArrayList.get(b2)).getId());
          stringBuilder2.append("");
          if (str.equals(stringBuilder2.toString())) {
            b2 = 1;
            break;
          } 
          b2++;
          continue;
        } 
        b2 = 0;
        break;
      } 
      StringBuilder stringBuilder1 = stringBuilder;
      if (b2 != 0)
        stringBuilder1 = a(stringBuilder, arrayOfString[b1]); 
      b1++;
      stringBuilder = stringBuilder1;
    } 
    return stringBuilder.toString();
  }
  
  private long[] l(ArrayList<o> paramArrayList) {
    String str = a.AZ().BX();
    byte b1 = 0;
    long[] arrayOfLong2 = new long[0];
    long[] arrayOfLong1 = arrayOfLong2;
    if (!by.isNull(str)) {
      String str1 = a(str, paramArrayList);
      arrayOfLong1 = arrayOfLong2;
      if (!by.isNull(str1)) {
        String[] arrayOfString = str1.split(",");
        long[] arrayOfLong = new long[arrayOfString.length];
        while (true) {
          arrayOfLong1 = arrayOfLong;
          if (b1 < arrayOfString.length) {
            arrayOfLong[b1] = Long.valueOf(arrayOfString[b1]).longValue();
            b1++;
            continue;
          } 
          break;
        } 
      } 
    } 
    return arrayOfLong1;
  }
  
  public double AO() { return this.aJW; }
  
  public long AR() { return this.aSW; }
  
  public CharSequence AS() { return this.name; }
  
  public CharSequence AT() { return this.name; }
  
  @Deprecated
  public double GA() { return Gz() + this.aTK; }
  
  public double GB() { return Gz() + this.aTK; }
  
  public double GC() { return Gy() + this.aTK; }
  
  public void GD() { cU(false); }
  
  public double[] GE() {
    double[] arrayOfDouble = new double[2];
    arrayOfDouble[0] = 0.0D;
    arrayOfDouble[1] = 0.0D;
    arrayOfDouble;
    if (this.aTR != null && !this.aTR.isEmpty()) {
      Iterator iterator = this.aTR.iterator();
      double d2 = 0.0D;
      double d1;
      for (d1 = 0.0D; iterator.hasNext(); d1 += o.ala()) {
        o o = (o)iterator.next();
        switch (o.alc()) {
          default:
            continue;
          case 1:
            d2 += o.ala();
            continue;
          case 0:
            break;
        } 
      } 
      arrayOfDouble[0] = d2 / 100.0D;
      arrayOfDouble[1] = d1 / 100.0D;
    } 
    return arrayOfDouble;
  }
  
  public void GF() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.zA());
    stringBuilder.append(n.a(Double.valueOf(this.aTD), true, true));
    this.aTE = stringBuilder.toString();
  }
  
  public String GG() { return this.aTE; }
  
  public double GH() { return this.aTF; }
  
  public double GI() { return this.aTG; }
  
  public double GJ() { return this.aJW + this.aTG; }
  
  public double GK() { return this.amountServiceCharge; }
  
  public ArrayList<c> GL() { return this.aTI; }
  
  public StringBuilder GM() { return this.aTJ; }
  
  public boolean GN() { return this.aTL; }
  
  public boolean GO() { return this.aTM; }
  
  @Nullable
  public ArrayList<o> GP() { return this.aTR; }
  
  public ArrayList<o> GQ() { return this.aTT; }
  
  public int GR() { return this.aTU; }
  
  public long GS() { return this.aTW; }
  
  public String GT() { return this.aTz; }
  
  public aa GU() throws CloneNotSupportedException {
    aa aa1 = (aa)super.GY();
    if (this.aTR != null) {
      aa1.aTR = new ArrayList();
      aa1.aTR = n.V(this.aTR);
    } 
    if (this.aTT != null) {
      aa1.aTT = new ArrayList();
      aa1.aTT = n.V(this.aTT);
    } 
    if (this.aTI != null) {
      aa1.aTI = new ArrayList();
      aa1.aTI = n.V(this.aTI);
    } 
    aa1.aTJ = new StringBuilder(this.aTJ.toString());
    if (this.aUa != null)
      aa1.aUa = new StringBuilder(this.aUa.toString()); 
    if (this.aUc != null)
      aa1.aUc = new StringBuilder(this.aUc.toString()); 
    if (this.aUb != null)
      aa1.aUb = this.aUb.GZ(); 
    return aa1;
  }
  
  public boolean GV() { return (6L == this.aSW); }
  
  public boolean GW() { return (this.aUb != null && this.aUb.GW()); }
  
  public boolean GX() { return (this.aUb != null && this.aUb.GX()); }
  
  public JSONArray Go() {
    try {
      return (this.aTV == null) ? null : new JSONArray(this.aTV);
    } catch (JSONException jSONException) {
      a.e(jSONException);
      return null;
    } 
  }
  
  public boolean Gp() { return this.aTZ; }
  
  public a Gq() { return this.aTX; }
  
  public long Gr() { return this.aTN; }
  
  public long Gs() { return this.aTO; }
  
  public void Gt() { this.aTB = n.b(null, Double.valueOf(this.aTA), false, false); }
  
  public boolean Gu() { return this.aTP; }
  
  @Deprecated
  public boolean Gv() { return this.aTQ; }
  
  public double Gw() { return this.aTA; }
  
  public String Gx() { return this.aTB; }
  
  public double Gy() {
    if (this.aUb != null) {
      ArrayList arrayList = this.aUb.Ha();
      if (GW())
        return this.aUe; 
      if (arrayList != null && (arrayList.size() == 1 || this.aTY) && !this.aUd) {
        f f = (f)arrayList.get(this.aUb.Hb());
        return f.EN() ? this.aTC : (f.EM() ? f.EL() : (this.aTC * f.EK() / 100.0D));
      } 
      return this.aUd ? akK() : this.aTC;
    } 
    return this.aUd ? akK() : this.aTC;
  }
  
  public double Gz() { return this.aTC; }
  
  public StringBuilder a(StringBuilder paramStringBuilder, String paramString) {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    if (by.isNull(paramStringBuilder.toString())) {
      str = "";
    } else {
      str = ",";
    } 
    stringBuilder.append(str);
    stringBuilder.append(paramString);
    paramStringBuilder.append(stringBuilder.toString());
    return paramStringBuilder;
  }
  
  public void a(a parama) { this.aTX = parama; }
  
  public void aq(long paramLong) { this.aTN = paramLong; }
  
  public void ar(long paramLong) { this.aTO = paramLong; }
  
  public void as(long paramLong) { this.aTW = paramLong; }
  
  public void b(JSONArray paramJSONArray) {
    if (paramJSONArray != null) {
      this.aTV = paramJSONArray.toString();
      return;
    } 
    this.aTV = null;
  }
  
  public void cR(boolean paramBoolean) { this.aTZ = paramBoolean; }
  
  public void cS(boolean paramBoolean) { this.aTP = paramBoolean; }
  
  @Deprecated
  public void cT(boolean paramBoolean) { this.aTQ = paramBoolean; }
  
  public void cU(boolean paramBoolean) {
    this.aTK = c.a(Gy(), this.aTI, this.aTX);
    if (paramBoolean) {
      if (GX()) {
        this.aTD = GC() / this.aTC * this.aJW;
        this.aJW = this.aTA * this.aTK + this.aJW;
      } else {
        double d = this.aTA * this.aTK + this.aJW;
        this.aJW = d;
        this.aTD = d;
      } 
    } else {
      this.aJW = this.aTA * GB();
      this.aTD = this.aTA * GC();
    } 
    GF();
    double d1 = this.aJW;
    double d2 = 0.0D;
    if (d1 != 0.0D && this.aTR != null && !this.aTR.isEmpty()) {
      String str = "";
      Iterator iterator = this.aTR.iterator();
      for (d1 = 0.0D; iterator.hasNext(); d1 += o.ala()) {
        o o = (o)iterator.next();
        switch (o.alc()) {
          default:
            continue;
          case 1:
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            if (by.isNull(str)) {
              str = "";
            } else {
              str = "/";
            } 
            stringBuilder.append(str);
            stringBuilder.append(o.akZ());
            str = stringBuilder.toString();
            d2 += o.ala();
            continue;
          case 0:
            break;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        if (by.isNull(str)) {
          str = "";
        } else {
          str = "/";
        } 
        stringBuilder.append(str);
        stringBuilder.append(o.akZ());
        str = stringBuilder.toString();
      } 
      double d = this.aJW;
      d2 = d2 / 100.0D + 1.0D;
      this.amountServiceCharge = d / d2 * a.AZ().BW() / 100.0D;
      this.aTF = this.aJW / d2;
      this.aTG = this.aTF * d1 / 100.0D;
    } else {
      this.amountServiceCharge = this.aJW * a.AZ().BW() / 100.0D;
      this.aTG = 0.0D;
      this.aTF = this.aJW;
    } 
    this.aJW = Double.parseDouble(n.a(Double.valueOf(this.aJW), true, false));
  }
  
  public void cV(boolean paramBoolean) { this.aTL = paramBoolean; }
  
  public void cW(boolean paramBoolean) { this.aTM = paramBoolean; }
  
  public void dj(String paramString) { this.aTz = paramString; }
  
  public void ev(int paramInt) { this.aTU = paramInt; }
  
  public double j(ArrayList<o> paramArrayList) { return by.parseDouble(n.ba(GK() + k(paramArrayList))); }
  
  public void j(boolean paramBoolean1, boolean paramBoolean2) {
    this.aTK = c.a(Gy(), this.aTI, this.aTX);
    if (paramBoolean1) {
      this.aJW = this.aTA * this.aTK + this.aJW;
    } else {
      this.aJW = this.aTA * GA();
    } 
    GF();
    double d1 = this.aJW;
    double d2 = 0.0D;
    if (d1 != 0.0D && this.aTR != null && !this.aTR.isEmpty()) {
      String str = "";
      Iterator iterator = this.aTR.iterator();
      for (d1 = 0.0D; iterator.hasNext(); d1 += o.ala()) {
        o o = (o)iterator.next();
        switch (o.alc()) {
          default:
            continue;
          case 1:
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            if (by.isNull(str)) {
              str = "";
            } else {
              str = "/";
            } 
            stringBuilder.append(str);
            stringBuilder.append(o.akZ());
            str = stringBuilder.toString();
            d2 += o.ala();
            continue;
          case 0:
            break;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        if (by.isNull(str)) {
          str = "";
        } else {
          str = "/";
        } 
        stringBuilder.append(str);
        stringBuilder.append(o.akZ());
        str = stringBuilder.toString();
      } 
      double d = this.aJW;
      d2 = d2 / 100.0D + 1.0D;
      this.amountServiceCharge = d / d2 * a.AZ().BW() / 100.0D;
      this.aTF = this.aJW / d2;
      this.aTG = this.aTF * d1 / 100.0D;
      return;
    } 
    this.amountServiceCharge = this.aJW * a.AZ().BW() / 100.0D;
    this.aTG = 0.0D;
    this.aTF = this.aJW;
  }
  
  public double k(ArrayList<o> paramArrayList) {
    this.aTH = 0.0D;
    long[] arrayOfLong = l(paramArrayList);
    this.aTT.clear();
    for (byte b1 = 0; b1 < arrayOfLong.length; b1++) {
      for (o o : paramArrayList) {
        if (o.getId() == arrayOfLong[b1]) {
          this.aTT.add(o);
          this.aTH += this.amountServiceCharge * o.ala() / 100.0D;
          break;
        } 
      } 
    } 
    return this.aTH;
  }
  
  public void m(ArrayList<c> paramArrayList) { c.c(paramArrayList, this.aTI); }
  
  public void n(ArrayList<c> paramArrayList) {
    this.aTI.clear();
    this.aTI.addAll(paramArrayList);
    c.a(this.aTJ, paramArrayList);
  }
  
  public void o(@Nullable ArrayList<o> paramArrayList) { this.aTR = paramArrayList; }
  
  public void q(double paramDouble) {
    this.aTA = paramDouble;
    Gt();
  }
  
  public void r(double paramDouble) { this.aTC = paramDouble; }
  
  public double s(double paramDouble) {
    double d = 0.0D;
    if (paramDouble != 0.0D && this.aTR != null && !this.aTR.isEmpty()) {
      for (o o : this.aTR) {
        if (o.alc() == 1)
          d += o.ala(); 
      } 
      return paramDouble / (d / 100.0D + 1.0D);
    } 
    return paramDouble;
  }
  
  public void t(double paramDouble) { this.aTF = paramDouble; }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("商品ID:");
    stringBuilder.append(this.aSW);
    stringBuilder.append(",商品名称：");
    stringBuilder.append(this.name);
    stringBuilder.append(",商品销售价：");
    stringBuilder.append(this.aTC);
    stringBuilder.append(",商品销售数量：");
    stringBuilder.append(this.aTA);
    stringBuilder.append(",商品金额：");
    stringBuilder.append(this.aJW);
    return stringBuilder.toString();
  }
  
  public void u(double paramDouble) { this.aTG = paramDouble; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */