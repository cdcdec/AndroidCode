package com.laiqian.report.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.laiqian.util.n;

public class TransactionDetails extends OrderDetailsRoot {
  private Boolean whetherNewRecordOnDelete;
  
  public static void start(Context paramContext, String paramString) {
    Intent intent = obtainIntent(paramContext, TransactionDetails.class, paramString);
    intent.putExtra("bIsMemberRecord", false);
    paramContext.startActivity(intent);
  }
  
  public static void startByMemeber(Context paramContext, String paramString) {
    Intent intent = obtainIntent(paramContext, TransactionDetails.class, paramString);
    intent.putExtra("bIsMemberRecord", true);
    paramContext.startActivity(intent);
  }
  
  protected void noNetworkOnUseChainMember() { n.eP(2131627996); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (isFinishing())
      return; 
    if (getIntent().getExtras().getBoolean("bIsMemberRecord", false)) {
      setTitleTextViewHideRightView(2131625637);
      return;
    } 
    setTitleTextViewHideRightView(2131628017);
  }
  
  protected void onDeleteFail() { n.eP(2131627997); }
  
  protected void onDeleteSuc() {
    super.onDeleteSuc();
    n.eP(2131627998);
  }
  
  protected boolean setBottomButton(View paramView, boolean paramBoolean) {
    this.whetherNewRecordOnDelete = this.productDocEntity.amU();
    if ("150001".equals(getLaiqianPreferenceManager().atp()) && paramBoolean && this.whetherNewRecordOnDelete != null) {
      paramView.setVisibility(0);
      paramView.setOnClickListener(new cf(this));
      return true;
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\TransactionDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */