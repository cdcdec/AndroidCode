package com.laiqian.version.a.b;

import com.laiqian.version.a.a;
import com.squareup.moshi.Json;

public class b extends a {
  @Json(name = "topic_id")
  public final String dII;
  
  @Json(name = "message_page")
  public final String dIJ;
  
  public b(String paramString1, String paramString2, String paramString3) {
    super(paramString1);
    this.dII = paramString2;
    this.dIJ = paramString3;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */