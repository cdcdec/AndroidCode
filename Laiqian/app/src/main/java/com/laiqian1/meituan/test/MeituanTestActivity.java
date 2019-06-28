package com.laiqian.meituan.test;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.meituan.R;
import com.laiqian.ui.ActivityRoot;

public class MeituanTestActivity extends ActivityRoot {
  TextView bqW;
  
  EditText brQ;
  
  Button brR;
  
  Button brS;
  
  Button brT;
  
  h brU;
  
  Button brV;
  
  EditText brW;
  
  EditText brX;
  
  TextView brY;
  
  Runnable brZ = new e(this);
  
  Runnable bsa = new f(this);
  
  Runnable bsb = new g(this);
  
  Handler handler = new Handler();
  
  int time = 1000;
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_meituan_test);
    this.brR = (Button)findViewById(R.id.receiveButton);
    this.brS = (Button)findViewById(R.id.pendingButton);
    this.brT = (Button)findViewById(R.id.allButton);
    this.brQ = (EditText)findViewById(R.id.etCount);
    this.bqW = (TextView)findViewById(R.id.tvTime);
    this.brV = (Button)findViewById(R.id.stopButton);
    this.brW = (EditText)findViewById(R.id.etTime);
    this.brX = (EditText)findViewById(R.id.etShopid);
    this.brY = (TextView)findViewById(R.id.tvResult);
    this.brX.setText("403321");
    this.brU = new h(this, this.bqW, this.brY);
    setListeners();
  }
  
  public void setListeners() {
    this.brR.setOnClickListener(new a(this));
    this.brS.setOnClickListener(new b(this));
    this.brT.setOnClickListener(new c(this));
    this.brV.setOnClickListener(new d(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\test\MeituanTestActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */