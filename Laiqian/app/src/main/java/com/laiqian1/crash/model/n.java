package com.laiqian.crash.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Message;
import com.laiqian.pos.industry.b;

public class n extends Thread {
  private String aMS;
  
  private Handler aNh;
  
  private Context context;
  
  private String filename;
  
  public n(Context paramContext, Handler paramHandler, String paramString1, String paramString2) {
    this.context = paramContext;
    this.aNh = paramHandler;
    this.filename = paramString1;
    this.aMS = paramString2;
  }
  
  public void run() {
    Message message = new Message();
    message.what = 0;
    try {
      l l = new l();
      String str2 = l.X(this.context);
      m m = new m(this.context);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append(this.filename);
      String str1 = m.cl(stringBuilder1.toString());
      o o = new o(this.context);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str2);
      stringBuilder2.append(this.filename);
      str2 = stringBuilder2.toString();
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("【异常信息】用户：");
      stringBuilder2.append(l.V(this.context));
      stringBuilder2.append("门店：");
      stringBuilder2.append(l.W(this.context));
      stringBuilder2.append("出错时间：");
      stringBuilder2.append(this.aMS);
      stringBuilder2.append("服务器IP：");
      stringBuilder2.append(b.ckJ);
      String str3 = stringBuilder2.toString();
      if (o.a(l.CS(), str3, str1, new String[] { str2 })) {
        message.what = 1;
        SQLiteDatabase sQLiteDatabase = this.context.openOrCreateDatabase("crash.db", 0, null);
        sQLiteDatabase.execSQL("create table if not exists crashlist(_id integer primary key autoincrement,userphone text,savepath text,shopid integer,isupload integer,crashtime long)");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("update crashlist set isupload=1 where savepath='");
        stringBuilder.append(this.filename);
        stringBuilder.append("'");
        sQLiteDatabase.execSQL(stringBuilder.toString());
        sQLiteDatabase.close();
      } else {
        message.what = 2;
      } 
    } catch (Exception exception) {
      message.what = 3;
    } 
    this.aNh.handleMessage(message);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\crash\model\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */