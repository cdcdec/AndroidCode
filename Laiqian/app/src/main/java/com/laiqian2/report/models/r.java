package com.laiqian.report.models;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class r extends u {
  private String bsx;
  
  private t cZU;
  
  private boolean dbr;
  
  private String[] selectionArgs;
  
  public r(Context paramContext) {
    super(paramContext);
    nm("productName");
    this.dbr = false;
  }
  
  private String aU(double paramDouble) {
    String str = n.a(Double.valueOf(paramDouble), false, true);
    if (!str.startsWith("-")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("+");
      stringBuilder.append(str);
      return stringBuilder.toString();
    } 
    return str;
  }
  
  protected double[] AW() { return new double[0]; }
  
  public void a(t paramt) {
    byte b = 0;
    this.dby = 0;
    this.selectionArgs = new String[2];
    String[] arrayOfString = this.selectionArgs;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramt.ane());
    stringBuilder.append("");
    arrayOfString[0] = stringBuilder.toString();
    arrayOfString = this.selectionArgs;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramt.anf());
    stringBuilder.append("");
    arrayOfString[1] = stringBuilder.toString();
    this.cZU = paramt;
    try {
      ConcurrentHashMap concurrentHashMap = b.f(paramt.ane(), paramt.anf());
      Set set = concurrentHashMap.entrySet();
      this.bsx = "select\nproductID,\nproductName,\nsalesQty,\ninQty,\noutQty,\ncheckQty,\nunitName ,\nstockQty\nfrom (";
      Iterator iterator = set.iterator();
      while (true) {
        if (iterator.hasNext()) {
          Map.Entry entry = (Map.Entry)iterator.next();
          byte b1 = b + true;
          String str = new StringBuilder();
          str.append("select t_product._id productID,t_product.sProductName productName,salesQty,inQty,outQty,checkQty,t_string.sFieldName unitName ");
          str.append(",t_product.nStockQty stockQty");
          str.append(" from t_product ");
          str.append(" left join (");
          str.append(" select nProductID");
          str.append(",sum(case when nProductTransacType=100051 and nStcokDirection=300002 then -nProductQty when nProductTransacType=100051 and nStcokDirection=300001 then nProductQty else 0 end) salesQty");
          str.append(",sum(nProductQty*(nProductTransacType=100052)) inQty");
          str.append(",sum(nProductQty*(nProductTransacType=100053)) outQty");
          str.append(",sum(case when nProductTransacType=100054 and nStcokDirection=300002 then -nProductQty when nProductTransacType=100054 and nStcokDirection=300001 then nProductQty else 0 end) checkQty ");
          StringBuilder stringBuilder3 = new StringBuilder();
          stringBuilder3.append(" from ");
          stringBuilder3.append((String)entry.getValue());
          stringBuilder3.append(".t_productdoc ");
          str.append(stringBuilder3.toString());
          str.append(" where nProductTransacType in(100051,100052,100053,100054)");
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(" and nDateTime>=");
          stringBuilder2.append(paramt.ane());
          stringBuilder2.append(" and nDateTime<=");
          stringBuilder2.append(paramt.anf());
          str.append(stringBuilder2.toString());
          str.append(" and (nDeletionFlag is null or nDeletionFlag!=1)");
          str.append(" and nShopID=");
          str.append(VC());
          str.append(" group by nProductID) productdoc on productdoc.nProductID=t_product._id ");
          str.append(" left join t_string on t_string.nFieldType=4 and t_string._id=t_product.nProductUnit");
          str.append(" where t_product.nFoodCategory=1 and (t_product.nProductStatus=600002 or t_product.nProductStatus=600001) ");
          str.append("and t_product.nShopID=");
          str.append(VC());
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(this.bsx);
          stringBuilder2.append(str.toString());
          stringBuilder2.append(" order by ");
          stringBuilder2.append(akB());
          if (this.dbr) {
            String str1 = "";
          } else {
            str = " desc ";
          } 
          stringBuilder2.append(str);
          stringBuilder2.append(ant());
          this.bsx = stringBuilder2.toString();
          b = b1;
          if (b1 != concurrentHashMap.size()) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(this.bsx);
            stringBuilder4.append(" union all ");
            this.bsx = stringBuilder4.toString();
            b = b1;
          } 
          continue;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.bsx);
        stringBuilder1.append(" ) ");
        this.bsx = stringBuilder1.toString();
        return;
      } 
    } catch (Exception paramt) {
      a.e(paramt);
      return;
    } 
  }
  
  public void nm(String paramString) {
    if (paramString.equals(akB())) {
      this.dbr ^= true;
      return;
    } 
    super.nm(paramString);
    this.dbr = false;
  }
  
  public ArrayList<HashMap<String, String>> zJ() {
    boolean bool;
    ArrayList arrayList = new ArrayList();
    try {
      exception = r(this.cZU.ane(), this.cZU.anf()).rawQuery(this.bsx, new String[0]);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    if (exception.getCount() >= getPageSize()) {
      bool = true;
    } else {
      bool = false;
    } 
    gC(bool);
    byte b = 1;
    int k = -1;
    int i3 = -1;
    int i2 = -1;
    int i1 = -1;
    int n = -1;
    int m = -1;
    int j = -1;
    int i = -1;
    while (exception != null && exception.moveToNext()) {
      byte b1 = b;
      if (b) {
        k = exception.getColumnIndex("productID");
        i3 = exception.getColumnIndex("productName");
        i2 = exception.getColumnIndex("salesQty");
        i1 = exception.getColumnIndex("inQty");
        n = exception.getColumnIndex("outQty");
        m = exception.getColumnIndex("checkQty");
        j = exception.getColumnIndex("unitName");
        i = exception.getColumnIndex("stockQty");
        b1 = 0;
      } 
      HashMap hashMap = new HashMap();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(exception.getLong(k));
      stringBuilder.append("");
      hashMap.put("productID", stringBuilder.toString());
      hashMap.put("productName", exception.getString(i3));
      hashMap.put("salesQty", aU(exception.getDouble(i2)));
      hashMap.put("inQty", n.a(Double.valueOf(exception.getDouble(i1)), false, true));
      hashMap.put("outQty", n.a(Double.valueOf(exception.getDouble(n)), false, true));
      hashMap.put("checkQty", aU(exception.getDouble(m)));
      hashMap.put("unitName", exception.getString(j));
      hashMap.put("stockQty", n.a(Double.valueOf(exception.getDouble(i)), false, true));
      arrayList.add(hashMap);
      b = b1;
    } 
    exception.close();
    return arrayList;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */