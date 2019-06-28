package com.laiqian.warehouse;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.laiqian.models.ah;
import com.laiqian.models.bk;
import com.laiqian.util.av;
import com.laiqian.warehouse.a.a;

public class Warehouse extends Activity {
  private View azH;
  
  View.OnClickListener azO = new b(this);
  
  private String bLA = "";
  
  private ListView bLC;
  
  private AutoCompleteTextView dLI;
  
  private Button dLJ;
  
  TextWatcher dLK = new a(this);
  
  View.OnClickListener dLL = new c(this);
  
  AdapterView.OnItemClickListener dLM = new d(this);
  
  private void axF() {
    a a = new a(this);
    a.axI();
    a.close();
  }
  
  private void sv(String paramString) {
    Cursor cursor;
    null = new av(this);
    String str = null.atp();
    null.close();
    a a = new a(this);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(ah.bRU);
    stringBuilder.append("");
    if (str.equals(stringBuilder.toString())) {
      cursor = a.sw(paramString);
    } else {
      bk bk = new bk(this);
      String str1 = bk.WN();
      bk.close();
      cursor = a.bH(cursor, str1);
    } 
    SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, 2131428124, cursor, a.WI(), new int[] { 2131300042, 2131300043, 2131300038, 2131300040 });
    this.bLC.setAdapter(simpleCursorAdapter);
  }
  
  private void wZ() {
    this.azH = findViewById(2131299878);
    this.dLJ = (Button)findViewById(2131299879);
    this.dLJ.setText(2131630599);
    this.dLJ.setVisibility(4);
    this.dLI = (AutoCompleteTextView)findViewById(2131300044);
    this.bLC = (ListView)findViewById(2131300047);
  }
  
  private void xa() {
    this.azH.setOnClickListener(this.azO);
    this.dLI.addTextChangedListener(this.dLK);
    this.bLC.setOnItemClickListener(this.dLM);
    this.dLJ.setOnClickListener(this.dLL);
  }
  
  private void xb() {
    ((TextView)findViewById(2131299889)).setText(2131625628);
    axF();
    sv("");
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131428191);
    getWindow().setFeatureInt(7, 2131428168);
    wZ();
    xa();
    xb();
  }
  
  public void onDestroy() {
    super.onDestroy();
    Cursor cursor = ((SimpleCursorAdapter)this.bLC.getAdapter()).getCursor();
    if (cursor != null)
      cursor.close(); 
  }
  
  public void onPause() { super.onPause(); }
  
  public void onResume() {
    super.onResume();
    sv("");
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\warehouse\Warehouse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */