package com.laiqian.sales;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.sales.a.c;
import com.laiqian.ui.listview.ReloadableExpandableListView;
import com.laiqian.ui.listview.n;
import com.laiqian.util.av;

public class Sales extends Activity {
  private static String bJs;
  
  private static String bLA = "";
  
  View.OnClickListener aDd = new b(this);
  
  private Button aGS;
  
  private View azH;
  
  View.OnClickListener azO = new a(this);
  
  private ExpandableListAdapter dii;
  
  private AutoCompleteTextView dij;
  
  private ReloadableExpandableListView dik;
  
  private Button dil;
  
  private Button dim;
  
  public c din = null;
  
  private String dio = "";
  
  private boolean dip;
  
  View.OnClickListener diq = new c(this);
  
  TextWatcher dir = new d(this);
  
  ExpandableListView.OnGroupClickListener dis = new e(this);
  
  View.OnClickListener dit = new f(this);
  
  View.OnClickListener diu = new g(this);
  
  public String title = "";
  
  static  {
  
  }
  
  private void TE() { this.dip = (new av(this)).atD(); }
  
  private void wZ() {
    this.azH = findViewById(2131299878);
    this.aGS = (Button)findViewById(2131299879);
    this.dij = (AutoCompleteTextView)findViewById(2131298830);
    this.dik = (ReloadableExpandableListView)findViewById(2131298869);
    this.dik.setClickable(true);
    this.dil = (Button)findViewById(2131298829);
    this.dim = (Button)findViewById(2131298821);
  }
  
  private void xa() {
    this.azH.setOnClickListener(this.azO);
    this.aGS.setOnClickListener(this.aDd);
    this.dil.setOnClickListener(this.diq);
    this.dik.setOnGroupClickListener(this.dis);
    this.dij.addTextChangedListener(this.dir);
    this.dim.setOnClickListener(this.dit);
  }
  
  private void xb() {
    this.aGS.setText(2131626038);
    bJs = getIntent().getExtras().getString("BusinessType");
    if (bJs.equals("100001")) {
      this.title = getString(2131626097);
    } else if (bJs.equals("100015")) {
      this.title = getString(2131626098);
    } else if (bJs.equals("100002")) {
      this.title = getString(2131626090);
    } else if (bJs.equals("100016")) {
      this.title = getString(2131626091);
    } 
    String str = getString(2131626118);
    TextView textView = (TextView)findViewById(2131299889);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.title);
    stringBuilder.append(str);
    textView.setText(stringBuilder.toString());
  }
  
  protected void nA(String paramString) {
    String str = paramString.trim();
    try {
      this.din = new c(this);
      int j = this.din.aS(str, bJs);
      paramString = this.din.aT(str, bJs);
      Cursor cursor = this.din.aU(str, bJs);
      String str1 = this.din.nD(bJs);
      String[] arrayOfString = new String[2];
      arrayOfString[0] = bJs;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("%");
      stringBuilder.append(str);
      stringBuilder.append("%");
      arrayOfString[1] = stringBuilder.toString();
      n.dCK = str1;
      n.dCM = arrayOfString;
      n.dCI = cursor.getColumnIndexOrThrow("sOrderNo");
      n.dCO = this.din.Vq();
      SQLiteDatabase sQLiteDatabase = this.din.Vq();
      int i = cursor.getColumnIndexOrThrow("sOrderNo");
      try {
        n = new n(cursor, this, 2131428127, 2131428128, new String[] { "sOrderNo", "sBPartnerName", "fAmount", "_id" }, new int[] { 2131298882, 2131298874, 2131298876, 2131298875 }, new String[] { "_id", "sProductName", "nProductQty", "fPrice", "fAmount" }, new int[] { 2131298881, 2131298877, 2131298878, 2131298883, 2131298879 }, sQLiteDatabase, paramString, null, str1, arrayOfString, j, i);
        try {
          this.dii = n;
          this.dik.setAdapter(this.dii);
          this.dik.setGroupIndicator(null);
          if (this.dip)
            for (i = 0; i < j; i++)
              this.dik.expandGroup(i);  
          AutoCompleteTextView autoCompleteTextView = this.dij;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(j);
          stringBuilder1.append(getString(2131629473));
          autoCompleteTextView.setHint(stringBuilder1.toString());
          return;
        } catch (Exception n) {}
      } catch (Exception paramString) {}
    } catch (Exception paramString) {}
    a.e(paramString);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131428102);
    getWindow().setFeatureInt(7, 2131428168);
    wZ();
    xa();
    TE();
    xb();
    nA("");
  }
  
  public void onPause() { super.onPause(); }
  
  public void onResume() {
    super.onResume();
    nA("");
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sales\Sales.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */