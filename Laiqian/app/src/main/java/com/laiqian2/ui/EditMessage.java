package com.laiqian.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.infrastructure.R;

public class EditMessage extends Activity {
  EditText dvW;
  
  private void aqN() {
    getWindow().setFeatureInt(7, R.layout.ui_titlebar);
    findViewById(R.id.ui_titlebar_back_btn).setOnClickListener(new f(this));
    ((TextView)findViewById(R.id.ui_titlebar_txt)).setText(getIntent().getStringExtra("title"));
    findViewById(R.id.ui_titlebar_help_btn).setVisibility(8);
  }
  
  public void finish() {
    setResult(-1, getIntent().putExtra("message", this.dvW.getText().toString()));
    super.finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.print_set_headerfooter);
    aqN();
    this.dvW = (EditText)findViewById(R.id.message);
    this.dvW.setText(getIntent().getStringExtra("message"));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\EditMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */