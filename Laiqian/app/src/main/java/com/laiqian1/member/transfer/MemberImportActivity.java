package com.laiqian.member.transfer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spanned;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.c.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.util.bt;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class MemberImportActivity extends ActivityRoot implements View.OnClickListener, a {
  protected ArrayList<HashMap<String, String>> aGI = null;
  
  protected String aGK = "";
  
  private ProgressBarCircularIndeterminate aNv;
  
  private TextView bHI;
  
  private FrameLayout bHJ;
  
  private TextView bHK;
  
  private View bHL;
  
  private View bHM;
  
  private TextView bHN;
  
  private TextView bHO;
  
  private d bHP;
  
  private TextView bHQ;
  
  private TextView bHR;
  
  private ProgressBarCircularIndeterminate bHS;
  
  private RelativeLayout bHT;
  
  private b bHU;
  
  private Context mContext;
  
  private void Ek() {
    this.bHJ.setOnClickListener(this);
    this.bHT.setOnClickListener(this);
    this.bHO.setOnClickListener(this);
  }
  
  private void Tl() {
    this.bHJ.setClickable(true);
    this.bHO.setClickable(true);
    this.bHS.setVisibility(8);
    this.bHI.setVisibility(0);
  }
  
  private void ei(boolean paramBoolean) {
    this.bHK.setVisibility(8);
    this.bHJ.setActivated(paramBoolean);
    this.bHJ.setClickable(paramBoolean ^ true);
    this.bHS.setVisibility(8);
  }
  
  private void initView() {
    this.aNv = (ProgressBarCircularIndeterminate)findViewById(R.id.ivProgress);
    this.bHO = (TextView)findViewById(R.id.tv_download_template);
    if (!a.zR().Af()) {
      findViewById(R.id.line).setVisibility(8);
      String str1 = getString(R.string.computer_login);
      String str2 = getString(R.string.download_link);
      String str3 = getString(R.string.download_the_template_file);
      bt.a a1;
      bt.a a2;
      bt.a a3 = (a2 = (a1 = bt.a.mj(getResources().getColor(R.color.text_main_black))).mj(getResources().getColor(R.color.red_color_10500))).mj(getResources().getColor(R.color.text_main_black));
      Spanned spanned = bt.a("%s %s %s", new String[] { str1, str2, str3 }, new bt.a[] { a1, a2, a3 });
      this.bHO.setText(spanned);
    } 
    this.bHK = (TextView)findViewById(R.id.tv_import_result);
    this.bHL = findViewById(R.id.v_ok);
    this.bHM = findViewById(R.id.v_right_arrow);
    this.bHN = (TextView)findViewById(R.id.tv_udisk_status);
    this.bHQ = (TextView)findViewById(R.id.tv_import_path);
    this.bHR = (TextView)findViewById(R.id.tv_import_path_title);
    this.bHI = (TextView)findViewById(R.id.tv_import_lqk);
    this.bHJ = (FrameLayout)findViewById(R.id.frameLayout_import_lqk);
    this.bHS = (ProgressBarCircularIndeterminate)findViewById(R.id.ivImportProgress_lqk);
    this.bHT = (RelativeLayout)findViewById(R.id.rl_status);
  }
  
  public void SW() {
    this.aNv.setVisibility(0);
    this.bHN.setVisibility(0);
    this.bHN.setText(getString(R.string.pos_product_searching_for_udisk));
    this.bHL.setVisibility(8);
    this.bHM.setVisibility(8);
    this.bHR.setVisibility(8);
    this.bHQ.setVisibility(8);
    ei(true);
  }
  
  public void SX() {
    this.bHU = new b(this.mContext);
    this.bHU.show();
    this.bHK.setVisibility(8);
    this.bHJ.setClickable(false);
  }
  
  public void gk(String paramString) {
    this.aNv.setVisibility(8);
    this.bHN.setVisibility(0);
    this.bHN.setText(paramString);
    this.bHL.setVisibility(8);
    this.bHM.setVisibility(0);
    this.bHR.setVisibility(8);
    this.bHQ.setVisibility(8);
    ei(true);
  }
  
  public void gl(String paramString) {
    this.aNv.setVisibility(8);
    this.bHN.setVisibility(8);
    this.bHL.setVisibility(0);
    this.bHM.setVisibility(8);
    this.bHR.setVisibility(0);
    this.bHQ.setVisibility(0);
    this.bHQ.setText(paramString);
    ei(false);
  }
  
  public void gm(String paramString) {
    if (this.bHU != null)
      this.bHU.dismiss(); 
    this.mContext.sendBroadcast((new Intent()).setAction("pos_activity_change_data_paytype"));
    this.bHS.setVisibility(8);
    this.bHK.setVisibility(0);
    this.bHK.setText(paramString);
    Tl();
  }
  
  public void gn(String paramString) {
    if (this.bHU != null)
      this.bHU.dismiss(); 
    this.bHS.setVisibility(8);
    this.bHK.setVisibility(0);
    this.bHK.setText(paramString);
    Tl();
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == R.id.frameLayout_import_lqk) {
      this.aGK = this.bHQ.getText().toString().trim();
      this.bHP.l(this, this.aGK);
      return;
    } 
    if (i == R.id.rl_status) {
      this.bHP.Tb();
      return;
    } 
    if (i == R.id.tv_download_template)
      this.bHP.SZ(); 
  }
  
  protected void onCreate(Bundle paramBundle) {
    requestWindowFeature(7);
    setContentView(R.layout.activity_member_import);
    getWindow().setFeatureInt(7, R.layout.pos_title);
    super.onCreate(paramBundle);
    this.mContext = this;
    setTitleTextViewHideRightView(R.string.pos_product_import);
    initView();
    this.bHP = new d(this, this);
    Ek();
    this.bHP.Tb();
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("list=");
    stringBuilder.append(n.a(this, true));
    printStream.println(stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\transfer\MemberImportActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */