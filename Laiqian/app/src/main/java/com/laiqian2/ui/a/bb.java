package com.laiqian.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.ProgressBarCircularIndeterminate;

public class bb extends Dialog {
  ProgressBarCircularIndeterminate aNv;
  
  TextView caX;
  
  public bb(Context paramContext) {
    super(paramContext, R.style.pos_waitingdialog);
    setContentView(R.layout.waiting_dialog_layout);
    this.caX = (TextView)findViewById(R.id.nProgress);
    this.aNv = (ProgressBarCircularIndeterminate)findViewById(R.id.ivProgress);
  }
  
  public void c(boolean paramBoolean, int paramInt) {
    if (paramBoolean) {
      this.caX.setVisibility(0);
      TextView textView = this.caX;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("%");
      textView.setText(stringBuilder.toString());
      return;
    } 
    this.caX.setVisibility(8);
  }
  
  public void eH(boolean paramBoolean) {
    if (paramBoolean) {
      this.aNv.setVisibility(0);
      return;
    } 
    this.aNv.setVisibility(8);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */