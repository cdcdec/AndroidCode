package com.laiqian.member;

import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import java.util.Map;

class ba implements AdapterView.OnItemClickListener {
  ba(MemberListActivity paramMemberListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    if (paramInt - this.bvu.buS.getHeaderViewsCount() + 1 > this.bvu.buS.getList().size())
      return; 
    View view = this.bvu.getWindow().peekDecorView();
    if (view != null)
      ((InputMethodManager)this.bvu.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0); 
    MemberListActivity.a(this.bvu, paramInt);
    MemberListActivity.b(this.bvu, paramView.getScrollY());
    Long long = Long.valueOf((String)((Map)this.bvu.buS.getList().get(paramInt - this.bvu.buS.getHeaderViewsCount())).get("_id"));
    Intent intent = new Intent(this.bvu, MemberInfoActivity.class);
    intent.putExtra("id", long);
    intent.putExtra("nBelongShopID", (String)((Map)this.bvu.buS.getList().get(paramInt - this.bvu.buS.getHeaderViewsCount())).get("nBelongShopID"));
    this.bvu.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */