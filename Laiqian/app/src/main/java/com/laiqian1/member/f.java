package com.laiqian.member;

import android.content.Intent;
import android.os.Bundle;
import com.laiqian.ui.a.r;

class f implements r.a {
  f(MemberChangeActivity paramMemberChangeActivity) {}
  
  public void xD() {
    Intent intent = new Intent(this.btq, MemberInfoActivity.class);
    new Bundle();
    intent.putExtra("id", (MemberChangeActivity.j(this.btq)).aSW);
    intent.putExtra("nBelongShopID", String.valueOf((MemberChangeActivity.j(this.btq)).aWC));
    this.btq.startActivity(intent);
    this.btq.finish();
  }
  
  public void xE() { MemberChangeActivity.m(this.btq); }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */