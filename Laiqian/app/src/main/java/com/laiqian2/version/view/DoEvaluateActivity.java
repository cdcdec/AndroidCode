package com.laiqian.version.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.infrastructure.R;
import com.laiqian.version.d.a;

public class DoEvaluateActivity extends BaseView {
  View.OnClickListener bKH = new a(this);
  
  EditText dJS;
  
  View dJT;
  
  View dJU;
  
  RatingBar dJV;
  
  a dJW;
  
  String dJb;
  
  int mFrom;
  
  private void axl() {
    this.dJS = (EditText)findViewById(R.id.if_feedback);
    this.dJT = findViewById(R.id.ranksHint);
    this.dJU = findViewById(R.id.feedbackHint);
    this.dJV = (RatingBar)findViewById(R.id.ranks);
  }
  
  public Context axk() { return this; }
  
  public void axm() {
    if (1 == this.mFrom) {
      finish();
      return;
    } 
    if (2 == this.mFrom) {
      sq(getString(R.string.pos_upgrade_thanks_for_your_feedback));
      Intent intent = new Intent(this, MyEvaluationActivity.class);
      intent.putExtra("version_id", this.dJb);
      startActivity(intent);
      finish();
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.version_do_evaluate);
    getWindow().setFeatureInt(7, R.layout.pos_submit_title);
    ((TextView)findViewById(R.id.title_text)).setText("写评论");
    Button button = (Button)findViewById(R.id.title_right);
    button.setText(R.string.if_submit);
    button.setOnClickListener(this.bKH);
    axl();
    this.mFrom = getIntent().getIntExtra("FROM", 0);
    this.dJb = getIntent().getStringExtra("version_id");
    this.dJW = new a(this, this.dJb);
  }
  
  public void sq(String paramString) { Toast.makeText(this, paramString, 0).show(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\DoEvaluateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */