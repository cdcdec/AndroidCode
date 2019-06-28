package com.laiqian.pos;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.aq;

public class WeChatProductPreview extends ActivityRoot {
  private ImageView cjf;
  
  private View cjg;
  
  private View cjh;
  
  public void initData() {
    try {
      aq.a(getIntent().getStringExtra("sImageExtraName"), this.cjf);
      return;
    } catch (Exception exception) {
      finish();
      return;
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(R.layout.wechat_preview);
    yR();
    yP();
  }
  
  public void onResume() {
    super.onResume();
    initData();
  }
  
  public void yP() {
    dv dv = new dv(this);
    this.cjg.setOnClickListener(dv);
    this.cjh.setOnClickListener(dv);
  }
  
  public void yR() {
    this.cjf = (ImageView)findViewById(R.id.preImgView);
    this.cjg = findViewById(R.id.preLeft);
    this.cjh = findViewById(R.id.preRight);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\WeChatProductPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */