package com.laiqian.binding;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.a.a.a.a.a.a;
import com.laiqian.pos.dw;
import com.laiqian.util.ae;
import com.laiqian.util.bk;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class g extends AsyncTask<String, Void, Boolean> {
  private k aJi;
  
  private Context context;
  
  public g(Context paramContext, k paramk) {
    this.context = paramContext;
    this.aJi = paramk;
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
  
  protected void b(Boolean paramBoolean) {
    if (this.context != null) {
      if (!this.aJi.zP())
        return; 
      this.aJi.zO();
      if (paramBoolean.booleanValue())
        this.aJi.q(new BitmapDrawable(this.context.getResources(), getBitmap(dw.aR(this.context)))); 
      return;
    } 
  }
  
  protected Boolean e(String... paramVarArgs) {
    String str2 = paramVarArgs[0];
    String str1 = paramVarArgs[1];
    return TextUtils.isEmpty(str2) ? Boolean.valueOf(false) : Boolean.valueOf(bk.a(str2, str1, ae.b(this.context, 250.0F), ae.b(this.context, 250.0F)));
  }
  
  protected void onPreExecute() {
    this.aJi.zQ();
    this.aJi.q(null);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\binding\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */