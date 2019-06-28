package com.laiqian.network;

import b.ak;
import retrofit2.b;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface b {
  @POST
  b<h> a(@Url String paramString1, @Body g paramg, @Header(vU = "id") String paramString2, @Header(vU = "time") String paramString3, @Header(vU = "sb-encrypt") String paramString4);
  
  @POST
  b<h> a(@Url String paramString1, @Body g paramg, @Header(vU = "Host") String paramString2, @Header(vU = "id") String paramString3, @Header(vU = "time") String paramString4, @Header(vU = "sb-encrypt") String paramString5);
  
  @GET
  b<ak> ar(@Url String paramString1, @Query(vU = "laiqian_encrypt") String paramString2);
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */