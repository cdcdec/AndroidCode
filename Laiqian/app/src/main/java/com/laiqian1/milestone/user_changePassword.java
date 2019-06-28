package com.laiqian.milestone;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.av;

public class user_changePassword extends ActivityRoot {
  private static String aGB;
  
  private static long bKd = -1L;
  
  private static long bKe = -1L;
  
  private static String bLG;
  
  private static String bLH;
  
  private static boolean bLI = false;
  
  private static String bLJ;
  
  private static String bLK = "";
  
  private static String bLL = "";
  
  private static long bLM;
  
  private static long bLN;
  
  private static long bLO;
  
  private static String bLP;
  
  private static String bLQ;
  
  private static String bLz;
  
  ProgressDialog aIw = null;
  
  private h bLR;
  
  private long bLS = 170002L;
  
  View.OnClickListener bLT = new w(this);
  
  static  {
  
  }
  
  private void Uk() {
    av av = new av(this);
    try {
      bKd = Long.parseLong(av.Tx());
      bKe = Long.parseLong(av.atm());
    } catch (NumberFormatException numberFormatException) {
      a.e(numberFormatException);
    } 
    av.close();
  }
  
  private void Ul() {
    this.bLR = new h(this);
    Cursor cursor = this.bLR.aK(bKe);
    if (cursor.getCount() <= 0) {
      finish();
      cursor.close();
      this.bLR.close();
      return;
    } 
    cursor.moveToFirst();
    bLO = cursor.getLong(cursor.getColumnIndex("nUserRole"));
    bLJ = cursor.getString(cursor.getColumnIndex("sUserName"));
    bLP = cursor.getString(cursor.getColumnIndex("sText"));
    bLQ = cursor.getString(cursor.getColumnIndex("sMail"));
    bLN = cursor.getLong(cursor.getColumnIndex("nUserStatus"));
    bLK = cursor.getString(cursor.getColumnIndex("sUserPassword"));
    bLz = cursor.getString(cursor.getColumnIndex("sUserPhone"));
    bKd = cursor.getLong(cursor.getColumnIndex("nShopID"));
    bLL = this.bLR.aL(bLN);
    aGB = this.bLR.aM(bLO);
    cursor.close();
    this.bLR.close();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131428176);
    getWindow().setFeatureInt(7, 2131428168);
    ((TextView)findViewById(2131299889)).setText(2131630163);
    ((Button)findViewById(2131299860)).setVisibility(8);
    ((Button)findViewById(2131299879)).setText(2131626317);
    ((Button)findViewById(2131299879)).setOnClickListener(this.bLT);
    Uk();
    Ul();
    ((TextView)findViewById(2131299868)).setText(bLz);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\mileston\\user_changePassword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */