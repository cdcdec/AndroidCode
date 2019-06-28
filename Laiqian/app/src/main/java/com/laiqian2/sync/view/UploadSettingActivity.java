package com.laiqian.sync.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.laiqian.basic.RootApplication;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.av;

public class UploadSettingActivity extends ActivityRoot implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
  private CheckBox DL;
  
  private av dqx;
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    String str = getClass().getSimpleName();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onCheckedChanged ------>");
    stringBuilder.append(paramBoolean);
    Log.i(str, stringBuilder.toString());
    this.dqx.hK(paramBoolean);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() != 2131299247)
      return; 
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131428170);
    setTitleTextViewHideRightView(getString(2131629907));
    this.DL = (CheckBox)findViewById(2131296709);
    this.dqx = new av(RootApplication.zv());
    this.DL.setChecked(this.dqx.ava());
    this.DL.setOnCheckedChangeListener(this);
  }
  
  protected void onDestroy() {
    super.onDestroy();
    this.dqx.close();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\view\UploadSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */