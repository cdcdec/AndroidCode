package com.laiqian.pos.industry.weiorder;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.laiqian.ui.a.d;
import com.laiqian.ui.s;

public class h extends d {
  private b csv = new b(s.p(getWindow()));
  
  private a csw = null;
  
  public h(Context paramContext, a parama) {
    super(paramContext, 2131427546);
    this.csw = parama;
    this.csv.csB.setOnClickListener(new i(this, parama));
    this.csv.byK.setOnClickListener(new j(this, parama));
    setCanceledOnTouchOutside(false);
  }
  
  public static interface a {
    void eX(boolean param1Boolean);
  }
  
  private static class b {
    View aQG;
    
    Button byK;
    
    TextView csA;
    
    TextView csB;
    
    ImageView csz;
    
    TextView tvTitle;
    
    b(View param1View) {
      this.aQG = param1View;
      this.tvTitle = (TextView)s.z(param1View, 2131299802);
      this.csz = (ImageView)s.z(param1View, 2131297328);
      this.csA = (TextView)s.z(param1View, 2131299525);
      this.byK = (Button)s.z(param1View, 2131296614);
      this.csB = (TextView)s.z(param1View, 2131296620);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */