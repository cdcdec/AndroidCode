package com.laiqian.member.setting;

import android.view.View;

class a implements View.OnClickListener {
  a(CreateVipGradeAndGradeDetailActivity paramCreateVipGradeAndGradeDetailActivity) {}
  
  public void onClick(View paramView) {
    CreateVipGradeAndGradeDetailActivity.a(this.bBn);
    if (!this.bBn.Rq() || CreateVipGradeAndGradeDetailActivity.a(this.bBn, CreateVipGradeAndGradeDetailActivity.b(this.bBn)) || !CreateVipGradeAndGradeDetailActivity.a(this.bBn) || !CreateVipGradeAndGradeDetailActivity.c(this.bBn)) {
      this.bBn.Rr();
      return;
    } 
    if (this.bBn.Az()) {
      this.bBn.save();
      return;
    } 
    this.bBn.close();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */