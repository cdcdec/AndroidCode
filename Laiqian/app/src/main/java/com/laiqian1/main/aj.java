package com.laiqian.main;

import android.content.Intent;
import android.view.View;

class aj implements View.OnClickListener {
  aj(PosActivity paramPosActivity) {}
  
  public void onClick(View paramView) {
    PosActivity.b(this.baU, 0);
    Intent intent = new Intent(this.baU, com.laiqian.pos.help.HelpActivity.class);
    this.baU.startActivity(intent);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */