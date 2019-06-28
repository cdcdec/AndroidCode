package com.laiqian.setting;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.laiqian.milestone.h;
import com.laiqian.util.bb;

public class OrderNumberLauncherActivity extends Activity {
  private ListView bWY;
  
  private TextView dkE;
  
  private Button dkF;
  
  private EditText dkG;
  
  private h dkH;
  
  private View.OnCreateContextMenuListener dkI = new ab(this);
  
  private View.OnClickListener dkJ = new ac(this);
  
  private AdapterView.OnItemClickListener dkK = new ad(this);
  
  private void aoW() {
    Cursor cursor = this.dkH.TU();
    this.bWY.setAdapter(new SimpleCursorAdapter(this, 2131427737, cursor, new String[] { "sBusinessType", "sPersonNameShort", "nNumber", "sIsActive" }, new int[] { 2131297783, 2131297786, 2131297785, 2131297784 }));
  }
  
  private String kf(int paramInt) {
    Cursor cursor = this.dkH.TU();
    cursor.moveToPosition(paramInt);
    return cursor.getString(1);
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem) {
    int i = ((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).position;
    if (paramMenuItem.getItemId() == 110000) {
      String str1 = kf(i);
      String str2 = m.s(this, str1);
      this.dkE.setText(str2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(m.u(this, str1));
      stringBuilder.append("---------");
      bb.f("getCurrentNumber--", stringBuilder.toString());
      m.a(this, str1, 1111L);
    } 
    return super.onContextItemSelected(paramMenuItem);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427797);
    getWindow().setFeatureInt(7, 2131428168);
    this.dkE = (TextView)findViewById(2131298311);
    this.bWY = (ListView)findViewById(2131298320);
    this.dkG = (EditText)findViewById(2131298321);
    this.dkF = (Button)findViewById(2131298097);
    this.dkH = new h(this);
    this.bWY.setOnCreateContextMenuListener(this.dkI);
    this.bWY.setOnItemClickListener(this.dkK);
    this.dkF.setOnClickListener(this.dkJ);
  }
  
  protected void onDestroy() { super.onDestroy(); }
  
  public void onResume() {
    aoW();
    super.onResume();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\OrderNumberLauncherActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */