package com.laiqian.print.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.laiqian.ui.s;

public class d {
  public View aQG;
  
  public TextView brY;
  
  private a cFa;
  
  public TextView cFd;
  
  private Context context;
  
  public TextView tvTitle;
  
  public d(View paramView) {
    this.aQG = paramView;
    this.context = this.aQG.getContext();
    this.tvTitle = (TextView)s.z(paramView, 2131299802);
    this.brY = (TextView)s.z(paramView, 2131299678);
    this.cFd = (TextView)s.z(paramView, 2131299526);
    afz();
    this.aQG.setOnClickListener(new e(this));
  }
  
  public void afy() { this.cFd.setVisibility(0); }
  
  public void afz() { this.cFd.setVisibility(8); }
  
  public void b(a parama) {
    if (parama == null)
      throw new NullPointerException(); 
    this.cFa = parama;
    b(parama.aft());
    parama.a(new f(this));
  }
  
  public void b(c paramc) {
    this.tvTitle.setText(paramc.title);
    int i = paramc.state;
    if (i != 100) {
      switch (i) {
        case 4:
          this.brY.setText(this.context.getString(2131625022));
          break;
        case 3:
          this.brY.setText(this.context.getString(2131625021));
          break;
        case 2:
          this.brY.setText(this.context.getString(2131625024));
          break;
        case 1:
          this.brY.setText(this.context.getString(2131625023));
          break;
        case 0:
          this.brY.setText(this.context.getString(2131625025));
          break;
      } 
    } else {
      this.brY.setText(this.context.getString(2131625020));
    } 
    this.cFd.setText(paramc.cFc);
    if (!paramc.isStopped()) {
      this.brY.setTextColor(this.context.getResources().getColor(2131099972));
      return;
    } 
    if (paramc.state == 4) {
      this.brY.setTextColor(this.context.getResources().getColor(2131099768));
      return;
    } 
    if (paramc.state == 3)
      this.brY.setTextColor(this.context.getResources().getColor(2131099898)); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */