package com.laiqian.takeaway.miniprograms;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.network.k;
import com.laiqian.pos.industry.a;
import com.laiqian.takeaway.R;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class n {
  public static int duv = 1;
  
  public static int duw = 2;
  
  Context context;
  
  o duu;
  
  static  {
  
  }
  
  public n(Context paramContext, o paramo) {
    this.context = paramContext;
    this.duu = paramo;
  }
  
  @Nullable
  private Bitmap getBitmap(String paramString) {
    if (paramString == null)
      return null; 
    file = new File(paramString);
    if (!file.exists())
      return null; 
    try {
      Throwable throwable;
      fileInputStream = new FileInputStream(file);
      try {
        return BitmapFactory.decodeStream(fileInputStream);
      } catch (Throwable null) {
        try {
          throw throwable;
        } finally {}
      } finally {
        file = null;
      } 
      if (fileInputStream != null)
        if (throwable != null) {
          try {
            fileInputStream.close();
          } catch (Throwable fileInputStream) {
            a.a(throwable, fileInputStream);
          } 
        } else {
          fileInputStream.close();
        }  
      throw file;
    } catch (IOException file) {
      return null;
    } 
  }
  
  public static String v(Context paramContext, int paramInt) {
    av av = new av(paramContext);
    String str2 = av.Tx();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/data/data/");
    stringBuilder.append(paramContext.getPackageName());
    if (paramInt == duv) {
      str1 = "/takeawayWxacode_";
    } else {
      str1 = "/scanorderWxacode_";
    } 
    stringBuilder.append(str1);
    stringBuilder.append(str2);
    String str1 = stringBuilder.toString();
    av.close();
    return str1;
  }
  
  public boolean a(Bitmap paramBitmap, String paramString) {
    File file = new File(paramString);
    if (file.exists())
      file.delete(); 
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
      fileOutputStream.flush();
      fileOutputStream.close();
      return true;
    } catch (FileNotFoundException paramBitmap) {
    
    } catch (IOException paramBitmap) {
      a.e(paramBitmap);
    } 
    return false;
  }
  
  public void aqF() {
    Bitmap bitmap1 = getBitmap(v(RootApplication.zv(), duv));
    Bitmap bitmap2 = getBitmap(v(RootApplication.zv(), duw));
    if (bitmap1 != null && bitmap2 != null) {
      this.duu.a(duv, bitmap1);
      this.duu.a(duw, bitmap2);
      this.duu.aqD();
      return;
    } 
    (new a(this)).execute(new Void[0]);
  }
  
  public class a extends AsyncTask<Void, Void, String> {
    boolean bBY = false;
    
    public a(n this$0) {}
    
    private boolean SI() {
      if (!bd.bH(this.dux.context)) {
        Toast.makeText(this.dux.context, this.dux.context.getString(R.string.please_check_network), 0).show();
        return false;
      } 
      return true;
    }
    
    protected String b(Void... param1VarArgs) {
      k = new k();
      try {
        return k.d(k.z(new HashMap()), a.crf, 1);
      } catch (Exception k) {
        return "";
      } finally {
        k = null;
      } 
    }
    
    protected void bf(String param1String) {
      this.dux.duu.hideProgress();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1String);
      stringBuilder.append("");
      Log.e("result", stringBuilder.toString());
      if (!TextUtils.isEmpty(param1String)) {
        this.dux.duu.aqD();
        try {
          JSONObject jSONObject = new JSONObject(param1String);
          String str2 = jSONObject.optString("takeawayWxacode", "");
          this.dux.duu.t(n.duv, str2);
          String str1 = jSONObject.optString("scanorderWxacode", "");
          this.dux.duu.t(n.duw, str1);
          return;
        } catch (JSONException param1String) {
          a.e(param1String);
          return;
        } 
      } 
      this.dux.duu.aqE();
    }
    
    protected void onPreExecute() {
      this.dux.duu.Em();
      this.bBY = SI();
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\miniprograms\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */