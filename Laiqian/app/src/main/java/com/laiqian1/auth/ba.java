package com.laiqian.auth;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import com.laiqian.k.a;
import com.laiqian.l.a;
import com.laiqian.message.m;
import com.laiqian.opentable.common.b;
import com.laiqian.util.av;
import com.laiqian.util.p;

class ba implements View.OnClickListener {
  ba(ShiftActivity paramShiftActivity) {}
  
  public void onClick(View paramView) {
    String str;
    m.Tv();
    b.XA();
    a.cp(this.aEC);
    a.asx();
    a.asy();
    if (ShiftActivity.aEy) {
      str = "先看统计、再交班";
    } else {
      str = "直接交班";
    } 
    a.x(this.aEC, str);
    ShiftActivity.a(this.aEC).ams();
    Intent intent = new Intent(this.aEC, p.bP(this.aEC));
    av av = new av(this.aEC);
    av.hx(true);
    av.close();
    if (((CheckBox)this.aEC.findViewById(2131297278).findViewById(2131297530).findViewById(2131296706)).isChecked())
      ShiftActivity.b(this.aEC); 
    this.aEC.startActivity(intent);
    this.aEC.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */