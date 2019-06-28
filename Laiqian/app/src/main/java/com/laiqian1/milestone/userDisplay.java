package com.laiqian.milestone;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.av;

public class userDisplay extends ActivityRoot {
  private static long bKd = -1L;
  
  private static long bKe = -1L;
  
  private static String bLA = "";
  
  private static long bLy = -1L;
  
  private static String bLz = "";
  
  private Button aGS;
  
  private TextView bLB;
  
  private ListView bLC;
  
  View.OnClickListener bLD = new u(this);
  
  AdapterView.OnItemClickListener bLE = new v(this);
  
  static  {
  
  }
  
  private void TE() {
    SharedPreferences sharedPreferences = getSharedPreferences("settings", 0);
    String str1 = sharedPreferences.getString("shop_id", "1");
    String str2 = sharedPreferences.getString("user_id", "1");
    bLz = sharedPreferences.getString("user_phone", "");
    bKd = Long.parseLong(str1);
    bKe = Long.parseLong(str2);
  }
  
  private void Ug() {
    Uh();
    h h = new h(this);
    SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, 2131428120, h.aO(bKd), new String[] { "sUserName", "sUserRole", "sUserPhone", "sUserStatus" }, new int[] { 2131299852, 2131299854, 2131299853, 2131299855 });
    this.bLC.setAdapter(simpleCursorAdapter);
    h.close();
  }
  
  private void Uh() {
    if (this.bLC != null) {
      SimpleCursorAdapter simpleCursorAdapter = (SimpleCursorAdapter)this.bLC.getAdapter();
      if (simpleCursorAdapter != null)
        simpleCursorAdapter.changeCursor(null); 
    } 
  }
  
  private void wZ() {
    this.aGS = (Button)findViewById(2131299879);
    this.bLB = (TextView)findViewById(2131299851);
    this.bLC = (ListView)findViewById(2131299856);
  }
  
  private void xa() {
    this.aGS.setOnClickListener(this.bLD);
    this.aGS.setVisibility(8);
    this.bLC.setOnItemClickListener(this.bLE);
  }
  
  private void xb() {
    this.aGS.setText(2131624274);
    ((TextView)findViewById(2131299889)).setText(2131630245);
    this.bLB.setText(bLz);
    Ug();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131428171);
    getWindow().setFeatureInt(7, 2131428168);
    wZ();
    xa();
    TE();
    xb();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    Uh();
  }
  
  protected void onResume() {
    super.onResume();
    av av = new av(this);
    boolean bool = av.aua();
    av.close();
    if (bool)
      Ug(); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\mileston\\userDisplay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */