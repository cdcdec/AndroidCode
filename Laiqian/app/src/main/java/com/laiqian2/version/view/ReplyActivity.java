package com.laiqian.version.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.infrastructure.R;
import com.laiqian.version.d.e;

public class ReplyActivity extends BaseView {
  View.OnClickListener bKH = new s(this);
  
  e dKk;
  
  EditText qY;
  
  private void axl() { this.qY = (EditText)findViewById(R.id.if_feedback); }
  
  public Context axk() { return this; }
  
  public void axp() {
    Toast.makeText(this, "回复成功", 0).show();
    finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.input_feedback);
    getWindow().setFeatureInt(7, R.layout.pos_submit_title);
    ((TextView)findViewById(R.id.title_text)).setText("回复");
    Button button = (Button)findViewById(R.id.title_right);
    button.setText(R.string.if_submit);
    button.setOnClickListener(this.bKH);
    axl();
    this.dKk = new e(this, getIntent().getStringExtra("version_id"));
  }
  
  public void sq(String paramString) { Toast.makeText(this, paramString, 0).show(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\ReplyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */