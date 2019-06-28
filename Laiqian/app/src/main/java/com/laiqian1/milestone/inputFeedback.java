package com.laiqian.milestone;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.ui.ActivityRoot;

public class inputFeedback extends ActivityRoot {
  ProgressDialog aIw = null;
  
  EditText bKG;
  
  View.OnClickListener bKH = new i(this);
  
  Handler handler = new j(this);
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427642);
    getWindow().setFeatureInt(7, 2131428047);
    ((TextView)findViewById(2131299265)).setText(getString(2131626072));
    Button button = (Button)findViewById(2131299253);
    button.setText(2131625290);
    button.setOnClickListener(this.bKH);
    this.bKG = (EditText)findViewById(2131297262);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\milestone\inputFeedback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */