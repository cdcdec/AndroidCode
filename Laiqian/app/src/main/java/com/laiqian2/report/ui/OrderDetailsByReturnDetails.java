package com.laiqian.report.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.report.models.l;
import com.laiqian.util.n;

public class OrderDetailsByReturnDetails extends OrderDetailsRoot {
  protected boolean isOnlyReturn() { return true; }
  
  protected void noNetworkOnUseChainMember() {}
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (isFinishing())
      return; 
    setTitleTextViewHideRightView(2131628144);
  }
  
  protected void onDeleteFail() {}
  
  protected void setAmount(View paramView) { paramView.setVisibility(8); }
  
  protected void setPayType(View paramView) {
    paramView.setVisibility(8);
    ViewGroup viewGroup = (ViewGroup)findViewById(2131298363);
    viewGroup.setVisibility(0);
    for (l l : this.payTypeItemArrayList) {
      View.inflate(this, 2131428014, viewGroup);
      View view1 = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
      View view2 = view1.findViewById(2131298369);
      ((TextView)view2.findViewById(2131298370)).setText(l.name);
      TextView textView = (TextView)view2.findViewById(2131298374);
      textView.setText(n.d(Double.valueOf(l.aJW)));
      textView.setTextColor(getResources().getColor(2131099871));
      ((TextView)view1.findViewById(2131296846)).setText(l.daJ);
      ((TextView)view1.findViewById(2131299932)).setText(l.daI);
      ((TextView)view1.findViewById(2131298302)).setText(this.productDocEntity.amK());
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\OrderDetailsByReturnDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */