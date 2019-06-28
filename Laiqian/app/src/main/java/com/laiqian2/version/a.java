package com.laiqian.version;

import android.content.Context;
import android.util.Log;
import com.alipay.euler.andfix.AndFixManager;
import com.alipay.euler.andfix.patch.Patch;
import com.alipay.euler.andfix.util.FileUtil;
import com.laiqian.basic.RootApplication;
import java.io.File;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class a {
  private final AndFixManager mAndFixManager;
  
  private final Context mContext;
  
  private final Map<String, ClassLoader> mLoaders;
  
  private final File mPatchDir;
  
  private final SortedSet<Patch> mPatchs;
  
  public a(Context paramContext) {
    this.mContext = paramContext;
    this.mAndFixManager = new AndFixManager(this.mContext);
    this.mPatchDir = new File(this.mContext.getFilesDir(), "apatch");
    this.mPatchs = new ConcurrentSkipListSet();
    this.mLoaders = new ConcurrentHashMap();
  }
  
  public static String awU() {
    String str = RootApplication.getLaiqianPreferenceManager().avu();
    if ("0".equals(str))
      return "0"; 
    if (str.contains(".")) {
      Log.e("sPatchVersion", str);
      Log.e("sPatchVersion", str.substring(str.lastIndexOf(".")));
      return str.substring(str.lastIndexOf(".") + 1);
    } 
    return "0";
  }
  
  private void cleanPatch() {
    File[] arrayOfFile = this.mPatchDir.listFiles();
    if (arrayOfFile != null) {
      int i = arrayOfFile.length;
      for (byte b = 0; b < i; b++) {
        File file = arrayOfFile[b];
        this.mAndFixManager.removeOptFile(file);
        if (!FileUtil.deleteFile(file)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(file.getName());
          stringBuilder.append(" delete error.");
          Log.e("PatchManager", stringBuilder.toString());
        } 
      } 
    } 
  }
  
  public void removeAllPatch() {
    cleanPatch();
    this.mContext.getSharedPreferences("_andfix_", 0).edit().clear().commit();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */