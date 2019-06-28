package com.laiqian.pos.industry.weiorder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.entity.aw;
import com.laiqian.takeaway.aq;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.av;

public class TakeOutGuideActivity extends ActivityRoot {
  ViewGroup ctd;
  
  ViewGroup cte;
  
  TextView ctf;
  
  public static void aV(Context paramContext) { paramContext.startActivity(new Intent(paramContext, TakeOutGuideActivity.class)); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427430);
    setTitleTextViewHideRightView(getString(2131630009));
    this.ctd = (ViewGroup)findViewById(2131297583);
    this.cte = (ViewGroup)findViewById(2131297722);
    this.ctf = (TextView)findViewById(2131299704);
    this.ctd.setOnClickListener(new ah(this));
    this.cte.setOnClickListener(new ai(this));
    if (!getResources().getBoolean(2131034125))
      this.ctd.setVisibility(8); 
  }
  
  protected void onResume() {
    boolean bool;
    super.onResume();
    aw aw = fp.aX(this).abV();
    av av = new av(this);
    if (aq.bz(this) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    boolean bool1 = av.auW();
    av.close();
    if (aw.Jq() || bool || bool1) {
      this.ctf.setText(getString(2131630005));
      this.ctf.setOnClickListener(new aj(this));
      return;
    } 
    this.ctf.setText(getString(2131624324));
    this.ctf.setOnClickListener(new ak(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\TakeOutGuideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */