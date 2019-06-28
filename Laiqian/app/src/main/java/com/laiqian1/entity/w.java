package com.laiqian.entity;

import com.laiqian.ui.a.g;
import com.squareup.moshi.Json;

public class w implements g.b {
  @Json(name = "peopleTypeID")
  private long aSW;
  
  @Json(name = "peopleTypeName")
  private String name;
  
  public w(long paramLong, String paramString) {
    this.aSW = paramLong;
    this.name = paramString;
  }
  
  public long AR() { return this.aSW; }
  
  public CharSequence AS() { return this.name; }
  
  public CharSequence AT() { return this.name; }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = (w)paramObject;
      return (this.aSW == paramObject.aSW);
    } 
    return false;
  }
  
  public int hashCode() { return (int)(this.aSW ^ this.aSW >>> 32); }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PeopleTypeEntity{ID=");
    stringBuilder.append(this.aSW);
    stringBuilder.append(", name='");
    stringBuilder.append(this.name);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */