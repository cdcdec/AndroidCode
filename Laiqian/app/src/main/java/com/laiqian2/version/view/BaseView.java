package com.laiqian.version.view;

import android.content.Context;
import android.widget.Toast;
import com.laiqian.ui.ActivityRoot;

public abstract class BaseView extends ActivityRoot {
  public Context axk() { return this; }
  
  public void sq(String paramString) { Toast.makeText(this, paramString, 0).show(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\BaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */