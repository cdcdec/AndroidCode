package com.laiqian.login.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.laiqian.c.a;
import com.laiqian.ui.s;

public class c extends Dialog {
  private ImageButton aYZ;
  
  private ImageView aZa;
  
  public c(Context paramContext) {
    super(paramContext);
    requestWindowFeature(1);
    View view = LayoutInflater.from(paramContext).inflate(2131427536, null);
    setContentView(view);
    this.aYZ = (ImageButton)s.z(view, 2131296619);
    this.aYZ.setOnClickListener(new d(this));
    this.aZa = (ImageView)s.z(view, 2131297399);
    this.aZa.setImageResource(2131231508);
    if (a.zR().Au())
      this.aZa.setVisibility(8); 
    getWindow().setLayout(-2, -2);
    getWindow().setBackgroundDrawableResource(17170445);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\login\view\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */