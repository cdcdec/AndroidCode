package com.laiqian.sync.view;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laiqian.test.zhoumh.e;
import com.umeng.analytics.MobclickAgent;

public class TestSync extends Sync {
  private EditText dqq;
  
  private Handler dqr = new u(this);
  
  e dqs = null;
  
  Handler dqt = null;
  
  View.OnClickListener dqu = new v(this);
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    MobclickAgent.onEvent(this, "sync");
    requestWindowFeature(7);
    setContentView(2131428135);
    getWindow().setFeatureInt(7, 2131428168);
    this.dqb = (Button)findViewById(2131299203);
    this.dqd = (TextView)findViewById(2131299443);
    this.dqq = (EditText)findViewById(2131299205);
    this.dqh = (LinearLayout)findViewById(2131299204);
    this.dqh.setVisibility(8);
    this.dqd.setVisibility(8);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\view\TestSync.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */