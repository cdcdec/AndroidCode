package com.laiqian.setting;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.milestone.h;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SetMakeOrderNumRuleActivity extends Activity {
  private Button aGS;
  
  private View azH;
  
  View.OnClickListener azO = new ak(this);
  
  private h dkH;
  
  private CheckBox dkR;
  
  private TextView dkS;
  
  private TextView dkT;
  
  private TextView dkU;
  
  private TextView dkV;
  
  private TextView dkW;
  
  private TextView dkX;
  
  private EditText dkY;
  
  private EditText dkZ;
  
  private String dku = "";
  
  private String dla;
  
  private String dlb;
  
  private View.OnClickListener dlc = new al(this);
  
  TextWatcher dld = new am(this);
  
  TextWatcher dle = new an(this);
  
  private boolean nJ(String paramString) { return (paramString == null) ? false : paramString.equals("Y"); }
  
  private void wZ() {
    this.azH = findViewById(2131299878);
    this.aGS = (Button)findViewById(2131299879);
    this.dkR = (CheckBox)findViewById(2131298322);
    this.dkS = (TextView)findViewById(2131298323);
    this.dkT = (TextView)findViewById(2131298328);
    this.dkY = (EditText)findViewById(2131298325);
    this.dkZ = (EditText)findViewById(2131298326);
    this.dkU = (TextView)findViewById(2131298324);
    this.dkV = (TextView)findViewById(2131298329);
    this.dkW = (TextView)findViewById(2131298330);
    this.dkX = (TextView)findViewById(2131298327);
  }
  
  private void xa() {
    this.azH.setOnClickListener(this.azO);
    this.aGS.setOnClickListener(this.dlc);
    this.dkY.addTextChangedListener(this.dld);
    this.dkZ.addTextChangedListener(this.dle);
  }
  
  private void xb() {
    this.aGS.setText(2131625961);
    ((TextView)findViewById(2131299889)).setText(2131625118);
    this.dkH = new h(this);
    null = getIntent().getExtras().getString("sBusinessType");
    Cursor cursor = this.dkH.gR(null);
    TextView textView = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
    if (cursor.moveToFirst()) {
      this.dla = cursor.getString(cursor.getColumnIndex("sBusinessType"));
      this.dlb = cursor.getString(cursor.getColumnIndex("sBusinessTypeDescription"));
      this.dkY.setText(cursor.getString(cursor.getColumnIndex("sPersonNameShort")));
      this.dkZ.setText(cursor.getString(cursor.getColumnIndex("nNumber")));
      this.dkT.setText(cursor.getString(cursor.getColumnIndex("nDateTime")));
      this.dkR.setChecked(nJ(cursor.getString(cursor.getColumnIndex("sIsActive"))));
      TextView textView1 = this.dkS;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.dla);
      stringBuilder2.append("(");
      stringBuilder2.append(this.dlb);
      stringBuilder2.append(")");
      textView1.setText(stringBuilder2.toString());
      this.dkT.setText(textView);
      this.dkU.setText(this.dla);
      textView1 = this.dkV;
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("-");
      stringBuilder2.append(textView);
      textView1.setText(stringBuilder2.toString());
      if (cursor.getString(cursor.getColumnIndex("sPersonNameShort")) == null || cursor.getString(cursor.getColumnIndex("sPersonNameShort")).equals("")) {
        this.dkW.setText("");
      } else {
        TextView textView2 = this.dkW;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-");
        stringBuilder.append(cursor.getString(cursor.getColumnIndex("sPersonNameShort")));
        textView2.setText(stringBuilder.toString());
      } 
      textView = this.dkX;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("-");
      stringBuilder1.append(cursor.getString(cursor.getColumnIndex("nNumber")));
      textView.setText(stringBuilder1.toString());
    } else {
      this.dkU.setText("CG");
      TextView textView1 = this.dkV;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("-");
      stringBuilder.append(textView);
      textView1.setText(stringBuilder.toString());
      this.dkW.setText("-LQK");
      this.dkX.setText("-1");
    } 
    this.aGS.setFocusable(true);
    this.aGS.setFocusableInTouchMode(true);
    this.aGS.requestFocus();
  }
  
  protected boolean nK(String paramString) { return this.dkH.gQ(paramString); }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427798);
    getWindow().setFeatureInt(7, 2131428168);
    wZ();
    xa();
    xb();
  }
  
  protected void onStop() {
    this.dkH.close();
    onDestroy();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\SetMakeOrderNumRuleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */