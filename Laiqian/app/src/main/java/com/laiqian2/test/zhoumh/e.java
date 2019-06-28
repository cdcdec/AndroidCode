package com.laiqian.test.zhoumh;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Message;
import com.laiqian.util.av;
import io.reactivex.g.a;

public class e {
  ProgressDialog aIw = null;
  
  SQLiteDatabase bJQ = null;
  
  Context context;
  
  int dvE = 1000;
  
  public e(Context paramContext) { this.context = paramContext; }
  
  private SQLiteDatabase aqM() {
    if (this.bJQ != null)
      return this.bJQ; 
    null = new StringBuilder();
    null.append("/data/data/");
    null.append(this.context.getPackageName());
    null.append("/");
    str = null.toString();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("laiqian.db");
    str = stringBuilder.toString();
    try {
      this.bJQ = SQLiteDatabase.openDatabase(str, null, 16);
    } catch (Exception str) {
      this.bJQ.close();
    } 
    return this.bJQ;
  }
  
  private void bs(String paramString) {
    if (this.aIw == null) {
      this.aIw = new ProgressDialog(this.context);
      this.aIw.setIndeterminate(false);
      this.aIw.setProgressStyle(1);
      this.aIw.setProgress(0);
      this.aIw.setCancelable(true);
    } 
    this.aIw.setTitle(paramString);
    this.aIw.setMessage("waiting ……");
    this.aIw.show();
  }
  
  public void f(Handler paramHandler) {
    av av = new av(this.context);
    String str1 = av.Tx();
    long l = av.atN();
    String str2 = av.atm();
    av.close();
    bs("正在清空t_accountdoc表，并开始创建新的测试数据");
    a.aKh().r(new f(this, paramHandler, l, str2, str1));
  }
  
  public void hideProgress() {
    if (this.aIw != null)
      this.aIw.dismiss(); 
  }
  
  public void kA(int paramInt) { this.dvE = paramInt; }
  
  public void kB(int paramInt) {
    if (this.aIw != null) {
      this.aIw.setMax(this.dvE);
      this.aIw.setProgress(paramInt);
      ProgressDialog progressDialog = this.aIw;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("第");
      stringBuilder.append(paramInt);
      stringBuilder.append("个数据");
      progressDialog.setMessage(stringBuilder.toString());
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\test\zhoumh\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */