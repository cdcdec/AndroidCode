package com.laiqian.print.model.type.a;

import android.os.ParcelUuid;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.laiqian.print.model.s;
import java.util.Arrays;

public class f extends s {
  @NonNull
  private String cHM;
  
  private ParcelUuid[] cHN;
  
  public f(@NonNull String paramString) {
    super(paramString, 3);
    this.cHM = paramString;
  }
  
  public void a(@NonNull ParcelUuid[] paramArrayOfParcelUuid) { this.cHN = (ParcelUuid[])Arrays.copyOf(paramArrayOfParcelUuid, paramArrayOfParcelUuid.length); }
  
  public String getMacAddress() { return this.cHM; }
  
  @Nullable
  public ParcelUuid[] getUuids() { return (this.cHN == null) ? null : (ParcelUuid[])Arrays.copyOf(this.cHN, this.cHN.length); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\type\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */