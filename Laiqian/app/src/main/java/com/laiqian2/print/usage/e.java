package com.laiqian.print.usage;

import com.laiqian.print.bm;
import com.laiqian.print.printtype.j;
import com.laiqian.print.printtype.p;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class e implements Serializable {
  private final bm cMm;
  
  private final Map<String, j> cMn = new LinkedHashMap();
  
  private e(bm parambm) { this.cMm = parambm; }
  
  public static e b(e parame) {
    c c;
    switch (f.bgg[parame.cMm.ordinal()]) {
      default:
        throw new RuntimeException();
      case 4:
        null = new a((a)parame);
        break;
      case 3:
        null = new d((d)parame);
        break;
      case 2:
        null = new b((b)parame);
        break;
      case 1:
        c = new c((c)parame);
        break;
    } 
    for (j j : parame.cMn.values())
      c.cMn.put(j.cJr, j); 
    return c;
  }
  
  public static e q(JSONObject paramJSONObject) throws JSONException {
    c c;
    null = bm.valueOf(paramJSONObject.getString("usage"));
    switch (f.bgg[null.ordinal()]) {
      default:
        null = new StringBuilder();
        null.append("no such usage");
        null.append(null);
        throw new JSONException(null.toString());
      case 4:
        null = a.a(null, new a());
        break;
      case 3:
        null = d.a(null, new d());
        break;
      case 2:
        null = b.a(null, new b());
        break;
      case 1:
        c = c.a(null, new c());
        break;
    } 
    JSONArray jSONArray = null.getJSONArray("order_selections");
    for (byte b = 0; b < jSONArray.length(); b++)
      c.b(j.o(jSONArray.getJSONObject(b))); 
    return c;
  }
  
  public bm ahZ() { return this.cMm; }
  
  public Collection<j> aia() { return Collections.unmodifiableCollection(this.cMn.values()); }
  
  public void aib() { this.cMn.clear(); }
  
  public boolean b(j paramj) {
    if (p.e(this.cMm).contains(paramj.cJr)) {
      this.cMn.put(paramj.cJr, paramj);
      return true;
    } 
    return false;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = (e)paramObject;
      return (this.cMm != paramObject.cMm) ? false : (!!this.cMn.equals(paramObject.cMn));
    } 
    return false;
  }
  
  public int hashCode() { return this.cMm.hashCode() * 31 + this.cMn.hashCode(); }
  
  public j lP(String paramString) { return (j)this.cMn.get(paramString); }
  
  public void s(Collection<j> paramCollection) {
    for (j j : paramCollection)
      this.cMn.put(j.cJr, j); 
  }
  
  public boolean u(String paramString, int paramInt) {
    if (p.e(this.cMm).contains(paramString)) {
      this.cMn.put(paramString, new j(paramString, paramInt));
      return true;
    } 
    return false;
  }
  
  public JSONObject xy() throws JSONException {
    JSONObject jSONObject = new JSONObject();
    jSONObject.put("usage", this.cMm.name());
    JSONArray jSONArray = new JSONArray();
    Iterator iterator = this.cMn.values().iterator();
    while (iterator.hasNext())
      jSONArray.put(((j)iterator.next()).xy()); 
    jSONObject.put("order_selections", jSONArray);
    return jSONObject;
  }
  
  public static class a extends e {
    public a() { super(bm.cEi, null); }
    
    public a(a param1a) { this(); }
    
    public static a a(JSONObject param1JSONObject, a param1a) throws JSONException { return param1a; }
  }
  
  public static class b extends e {
    private final List<Long> cCD = new ArrayList();
    
    private final List<Long> cCE = new ArrayList();
    
    public b() { super(bm.cEh, null); }
    
    public b(b param1b) {
      this();
      this.cCD.addAll(param1b.aep());
      this.cCE.addAll(param1b.aeq());
    }
    
    public static b a(JSONObject param1JSONObject, b param1b) throws JSONException {
      JSONArray jSONArray2 = param1JSONObject.getJSONArray("PRODUCT_TYPE_IGNORE_LIST");
      byte b2 = 0;
      byte b1;
      for (b1 = 0; b1 < jSONArray2.length(); b1++)
        param1b.cA(jSONArray2.getLong(b1)); 
      JSONArray jSONArray1 = param1JSONObject.getJSONArray("OPEN_TABLE_AREA_IGNORE_LIST");
      for (b1 = b2; b1 < jSONArray1.length(); b1++)
        param1b.cB(jSONArray1.getLong(b1)); 
      return param1b;
    }
    
    public List<Long> aep() { return Collections.unmodifiableList(this.cCD); }
    
    public List<Long> aeq() { return Collections.unmodifiableList(this.cCE); }
    
    public boolean cA(long param1Long) { return this.cCD.contains(Long.valueOf(param1Long)) ? false : this.cCD.add(Long.valueOf(param1Long)); }
    
    public boolean cB(long param1Long) { return this.cCE.contains(Long.valueOf(param1Long)) ? false : this.cCE.add(Long.valueOf(param1Long)); }
    
    public boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (param1Object != null) {
        if (getClass() != param1Object.getClass())
          return false; 
        if (!super.equals(param1Object))
          return false; 
        param1Object = (b)param1Object;
        return !this.cCD.equals(param1Object.cCD) ? false : (!!this.cCE.equals(param1Object.cCE));
      } 
      return false;
    }
    
    public int hashCode() { return (super.hashCode() * 31 + this.cCD.hashCode()) * 31 + this.cCE.hashCode(); }
    
    public void t(Collection<Long> param1Collection) {
      this.cCD.clear();
      this.cCD.addAll(param1Collection);
    }
    
    public void u(Collection<Long> param1Collection) {
      this.cCE.clear();
      this.cCE.addAll(param1Collection);
    }
    
    public JSONObject xy() throws JSONException {
      JSONObject jSONObject = super.xy();
      JSONArray jSONArray = new JSONArray();
      Iterator iterator = this.cCD.iterator();
      while (iterator.hasNext())
        jSONArray.put((Long)iterator.next()); 
      jSONObject.put("PRODUCT_TYPE_IGNORE_LIST", jSONArray);
      jSONArray = new JSONArray();
      iterator = this.cCE.iterator();
      while (iterator.hasNext())
        jSONArray.put((Long)iterator.next()); 
      jSONObject.put("OPEN_TABLE_AREA_IGNORE_LIST", jSONArray);
      return jSONObject;
    }
  }
  
  public static class c extends e {
    public c() { super(bm.cEf, null); }
    
    public c(c param1c) { this(); }
    
    public static c a(JSONObject param1JSONObject, c param1c) throws JSONException { return param1c; }
  }
  
  public static class d extends e {
    private final List<Long> cCD = new ArrayList();
    
    public d() { super(bm.cEg, null); }
    
    public d(d param1d) {
      this();
      this.cCD.addAll(param1d.aep());
    }
    
    public static d a(JSONObject param1JSONObject, d param1d) throws JSONException {
      JSONArray jSONArray = param1JSONObject.getJSONArray("PRODUCT_TYPE_IGNORE_LIST");
      for (byte b = 0; b < jSONArray.length(); b++)
        param1d.p(Long.valueOf(jSONArray.getLong(b))); 
      return param1d;
    }
    
    public List<Long> aep() { return Collections.unmodifiableList(this.cCD); }
    
    public boolean p(Long param1Long) { return this.cCD.contains(param1Long) ? false : this.cCD.add(param1Long); }
    
    public void t(Collection<Long> param1Collection) {
      this.cCD.clear();
      this.cCD.addAll(param1Collection);
    }
    
    public JSONObject xy() throws JSONException {
      JSONObject jSONObject = super.xy();
      JSONArray jSONArray = new JSONArray();
      Iterator iterator = this.cCD.iterator();
      while (iterator.hasNext())
        jSONArray.put((Long)iterator.next()); 
      jSONObject.put("PRODUCT_TYPE_IGNORE_LIST", jSONArray);
      return jSONObject;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */