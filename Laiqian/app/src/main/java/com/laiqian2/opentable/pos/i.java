package com.laiqian.opentable.pos;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.TextView;
import com.laiqian.opentable.R;
import com.laiqian.ui.ProgressBarCircularIndeterminate;

public class i extends Dialog {
  TextView caX;
  
  ProgressBarCircularIndeterminate caY;
  
  ProgressBarCircularIndeterminate caZ;
  
  ProgressBarCircularIndeterminate cba;
  
  private int position = 0;
  
  public i(Context paramContext) {
    super(paramContext, R.style.pos_waitingdialog);
    setContentView(R.layout.open_table_pos_waiting_dialog_layout);
    getWindow().setLayout(-1, -2);
    this.caX = (TextView)findViewById(R.id.nProgress);
    this.caY = (ProgressBarCircularIndeterminate)findViewById(R.id.ivProgress_left);
    this.caZ = (ProgressBarCircularIndeterminate)findViewById(R.id.ivProgress_center);
    this.cba = (ProgressBarCircularIndeterminate)findViewById(R.id.ivProgress_right);
  }
  
  @NonNull
  public void eH(boolean paramBoolean) {
    ProgressBarCircularIndeterminate progressBarCircularIndeterminate;
    int j = this.position;
    byte b2 = 0;
    byte b3 = 0;
    byte b1 = 0;
    switch (j) {
      default:
        progressBarCircularIndeterminate = this.caZ;
        if (paramBoolean) {
          b1 = b3;
          break;
        } 
        b1 = 8;
        progressBarCircularIndeterminate.setVisibility(b1);
        this.caY.setVisibility(8);
        this.cba.setVisibility(8);
        return;
      case 2:
        progressBarCircularIndeterminate = this.cba;
        if (!paramBoolean)
          b1 = 8; 
        progressBarCircularIndeterminate.setVisibility(b1);
        this.caZ.setVisibility(8);
        this.caY.setVisibility(8);
        return;
      case 1:
        progressBarCircularIndeterminate = this.caY;
        if (paramBoolean) {
          b1 = b2;
        } else {
          b1 = 8;
        } 
        progressBarCircularIndeterminate.setVisibility(b1);
        this.caZ.setVisibility(8);
        this.cba.setVisibility(8);
        return;
    } 
    progressBarCircularIndeterminate.setVisibility(b1);
    this.caY.setVisibility(8);
    this.cba.setVisibility(8);
  }
  
  public void setPosition(int paramInt) {
    this.position = paramInt;
    eH(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\pos\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */