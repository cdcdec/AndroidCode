package com.laiqian.test.zhoumh;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.milestone.h;
import com.laiqian.util.bb;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class testDownLoadUpdateActivity extends Activity {
  h bLR;
  
  private final String chT = "T_PRODUCT";
  
  int dvA = 100;
  
  int dvB = 101;
  
  long dvC = 0L;
  
  private final String dvo = "T_STOCK";
  
  private final String dvp = "T_STRING";
  
  private String dvq = "T_PRODUCT";
  
  TextView dvr;
  
  Button dvs;
  
  Button dvt;
  
  Button dvu;
  
  Spinner dvv;
  
  long[] dvw;
  
  long[] dvx;
  
  String dvy = "";
  
  long dvz = 0L;
  
  private Context mContext;
  
  private void aqJ() {
    this.dvr.setText("");
    int i = this.dvB;
    int j = this.dvB;
    if (this.dvq.equals("T_PRODUCT")) {
      this.dvy = "1";
    } else if (this.dvq.equals("T_STOCK")) {
      this.dvy = "0";
    } else if (this.dvq.equals("T_STRING")) {
      this.dvy = "0";
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("server_");
    stringBuilder1.append(i);
    stringBuilder1.append(".db");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("client_");
    stringBuilder2.append(j);
    stringBuilder2.append(".db");
    e(str, stringBuilder2.toString(), i);
  }
  
  private void aqK() {
    this.dvr.setText("");
    int i = this.dvA;
    int j = this.dvA;
    if (this.dvq.equals("T_PRODUCT")) {
      this.dvy = "1";
    } else if (this.dvq.equals("T_STOCK")) {
      this.dvy = "0";
    } else if (this.dvq.equals("T_STRING")) {
      this.dvy = "0";
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("server_");
    stringBuilder1.append(i);
    stringBuilder1.append(".db");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("client_");
    stringBuilder2.append(j);
    stringBuilder2.append(".db");
    e(str, stringBuilder2.toString(), i);
  }
  
  private void yR() {
    this.dvr = (TextView)findViewById(2131299209);
    this.dvs = (Button)findViewById(2131299206);
    this.dvt = (Button)findViewById(2131299207);
    this.dvu = (Button)findViewById(2131299208);
    this.dvv = (Spinner)findViewById(2131299210);
    ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, new String[] { "T_PRODUCT", "T_STOCK", "T_STRING" });
    this.dvv.setAdapter(arrayAdapter);
    this.dvv.setOnItemSelectedListener(new a(this));
    this.dvs.setText("测试");
    b b = new b(this);
    c c = new c(this);
    d d = new d(this);
    this.dvu.setOnClickListener(d);
    this.dvt.setOnClickListener(c);
    this.dvs.setOnClickListener(b);
    this.dvr.setText("");
  }
  
  public long a(SQLiteDatabase paramSQLiteDatabase, String paramString, long paramLong) {
    long l = -1L;
    if (paramLong <= 0L)
      return -1L; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select count(*) as nRecord from ");
    stringBuilder.append(paramString);
    paramString = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" where nShopID =");
    stringBuilder.append(paramLong);
    Cursor cursor = paramSQLiteDatabase.rawQuery(stringBuilder.toString(), null);
    paramLong = l;
    if (cursor.getCount() > 0) {
      paramLong = l;
      if (cursor.moveToNext())
        paramLong = cursor.getLong(cursor.getColumnIndex("nRecord")); 
    } 
    cursor.close();
    return paramLong;
  }
  
  public void aqL() {
    this.dvC = System.currentTimeMillis();
    this.dvr.setText("");
    this.dvw = new long[17];
    if (this.dvq.equals("T_PRODUCT")) {
      this.dvy = "1";
      this.dvx = new long[] { 
          2L, 2L, 1L, 11L, 11L, 10L, 10L, 11L, 20L, 20L, 
          13L, 16L, 14L, 12L, 11L, 11L, 11L };
    } else if (this.dvq.equals("T_STOCK")) {
      this.dvy = "0";
      this.dvx = new long[] { 
          2L, 2L, 1L, 11L, 11L, 10L, 11L, 10L, 20L, 20L, 
          20L, 20L, 20L, 20L, 11L, 11L, 11L };
    } else if (this.dvq.equals("T_STRING")) {
      this.dvy = "0";
      this.dvx = new long[] { 
          2L, 2L, 2L, 11L, 11L, 10L, 10L, 11L, 20L, 20L, 
          18L, 18L, 18L, 12L, 11L, 11L, 10L };
    } 
    byte b1 = 1;
    String str = "";
    boolean bool = true;
    byte b2 = 1;
    while (b1 <= 17) {
      if (b1 > 8)
        b2 = 2; 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("server_");
      stringBuilder1.append(b1);
      stringBuilder1.append(".db");
      String str1 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("client_");
      stringBuilder2.append(b2);
      stringBuilder2.append(".db");
      e(str1, stringBuilder2.toString(), b1);
      long[] arrayOfLong = this.dvw;
      byte b = b1 - 1;
      str1 = str;
      if (arrayOfLong[b] != this.dvx[b]) {
        bool = false;
        null = new StringBuilder();
        null.append(str);
        null.append("\n第");
        null.append(b1);
        null.append("条记录测试失败->");
        null.append(this.dvw[b]);
        null.append("正确结果：");
        null.append(this.dvx[b]);
        str1 = null.toString();
      } 
      b1++;
      str = str1;
    } 
    if (bool) {
      null = new StringBuilder();
      null.append(this.dvq);
      null.append("测试通过,共用时->");
      null.append(this.dvC - System.currentTimeMillis());
      str = null.toString();
    } 
    TextView textView = this.dvr;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.dvr.getText().toString());
    stringBuilder.append("\n");
    stringBuilder.append(str);
    textView.setText(stringBuilder.toString());
  }
  
  protected void bb(String paramString1, String paramString2) {
    File file = new File(paramString2);
    if (file.exists())
      file.delete(); 
    if (!file.exists())
      try {
        file.createNewFile();
        InputStream inputStream = this.mContext.getAssets().open(paramString1);
        FileOutputStream fileOutputStream = new FileOutputStream(paramString2);
        byte[] arrayOfByte = new byte[8192];
        while (true) {
          int i = inputStream.read(arrayOfByte);
          if (i > 0) {
            fileOutputStream.write(arrayOfByte, 0, i);
            continue;
          } 
          break;
        } 
        fileOutputStream.close();
        inputStream.close();
        return;
      } catch (Exception paramString1) {
        a.e(paramString1);
      }  
  }
  
  public void e(String paramString1, String paramString2, int paramInt) {
    if (paramInt == this.dvA) {
      str = "1359698698211";
    } else if (paramInt == this.dvB) {
      str = "100";
    } else {
      String str;
      str = "1402884782986";
    } 
    long l = Long.parseLong(str);
    null = new StringBuilder();
    null.append("/data/data/");
    null.append(this.mContext.getPackageName());
    null.append("/result_");
    null.append(paramInt);
    null.append(".db");
    String str1 = null.toString();
    null = new StringBuilder();
    null.append("/data/data/");
    null.append(this.mContext.getPackageName());
    null.append("/server_");
    null.append(paramInt);
    null.append(".db");
    String str2 = null.toString();
    bb(paramString1, str2);
    bb(paramString2, str1);
    try {
      boolean bool1;
      String str = SQLiteDatabase.openDatabase(str1, null, 16);
      this.bLR.bJQ = str;
      str = this.bLR.bJQ;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("ATTACH DATABASE '");
      stringBuilder2.append(str2);
      stringBuilder2.append("' AS serverDB");
      str.execSQL(stringBuilder2.toString());
      this.bLR.bJQ.beginTransaction();
      this.dvz = System.currentTimeMillis();
      boolean bool2 = false;
      try {
        bool1 = this.bLR.b(this.dvq, this.dvy, l);
      } catch (Exception null) {
        bb.e("失败啦", str1);
        bool1 = bool2;
      } 
      long l1 = a(this.bLR.bJQ, this.dvq, l);
      if (paramInt < this.dvA)
        this.dvw[paramInt - 1] = l1; 
      TextView textView = this.dvr;
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(this.dvr.getText().toString());
      stringBuilder3.append("\n");
      stringBuilder3.append(this.dvq);
      stringBuilder3.append("第");
      stringBuilder3.append(paramInt);
      stringBuilder3.append("个表--->");
      stringBuilder3.append(System.currentTimeMillis() - this.dvz);
      stringBuilder3.append("\n");
      if (bool1) {
        String str3 = "成功";
      } else {
        str = "失败";
      } 
      stringBuilder3.append(str);
      stringBuilder3.append("\n当前记录条数-》");
      stringBuilder3.append(l1);
      textView.setText(stringBuilder3.toString());
      if (bool1)
        this.bLR.bJQ.setTransactionSuccessful(); 
      this.bLR.bJQ.endTransaction();
      this.bLR.bJQ.execSQL("DETACH DATABASE serverDB");
      l1 = a(this.bLR.bJQ, this.dvq, l);
      textView = this.dvr;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.dvr.getText().toString());
      stringBuilder1.append("\ndetach后记录条数-》");
      stringBuilder1.append(l1);
      textView.setText(stringBuilder1.toString());
      this.bLR.bJQ.close();
      return;
    } catch (Exception paramString1) {
      throw new NullPointerException();
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2131428150);
    this.mContext = this;
    this.bLR = new h(this.mContext);
    yR();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\test\zhoumh\testDownLoadUpdateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */