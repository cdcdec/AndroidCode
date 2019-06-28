package com.laiqian.dcb.api.a;

import android.content.Context;
import android.content.Intent;
import com.laiqian.dcb.api.b.d;
import java.util.ArrayList;

public class a {
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, Object paramObject) { a(paramContext, new int[] { paramInt1 }, paramInt2, paramInt3, paramObject); }
  
  public static void a(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2, Object paramObject) {
    byte b;
    for (b = 0; b < paramArrayOfInt.length; b++) {
      int i = paramArrayOfInt[b];
      null = new StringBuilder();
      null.append("m:");
      null.append(paramInt1);
      null.append("r:");
      null.append(paramInt2);
      null.append("d");
      null.append(paramObject);
      d.e("broad", null.toString());
      null = new StringBuilder();
      null.append("method");
      null.append(i);
      Intent intent = new Intent(null.toString());
      intent.putExtra("method", paramInt1);
      if (paramObject instanceof String) {
        intent.putExtra("data", paramObject.toString());
      } else if (paramObject instanceof ArrayList) {
        intent.putExtra("data", (ArrayList)paramObject);
      } 
      intent.putExtra("result", paramInt2);
      paramContext.sendBroadcast(intent);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */