package com.laiqian.ui.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class aj extends d {
  private View aJv;
  
  private long bJx = 0L;
  
  private TextView byj;
  
  private long cfe = 0L;
  
  private TextView dAp;
  
  private TextView dAq;
  
  private a dAr;
  
  private Context mContext;
  
  public aj(Context paramContext) {
    super(paramContext, R.layout.dialog_select_date);
    this.mContext = paramContext;
    xT();
    xU();
  }
  
  private void t(String paramString, long paramLong) {
    this.bJx = paramLong;
    this.dAp.setText(paramString);
    this.dAp.setTag(Long.valueOf(paramLong));
  }
  
  private void u(String paramString, long paramLong) {
    this.cfe = paramLong;
    this.dAq.setText(paramString);
    this.dAq.setTag(Long.valueOf(paramLong));
  }
  
  private void xT() {
    this.dAp = (TextView)this.mView.findViewById(R.id.tv_start_time);
    this.dAq = (TextView)this.mView.findViewById(R.id.tv_end_time);
    this.byj = (TextView)this.mView.findViewById(R.id.sure);
    this.aJv = this.mView.findViewById(R.id.cancel);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.mContext.getString(R.string.pos_en_SimpleDateFormatDay));
    Calendar calendar = Calendar.getInstance();
    calendar.add(2, 0);
    calendar.set(5, 1);
    Date date = calendar.getTime();
    this.dAp.setText(simpleDateFormat.format(date));
    this.dAp.setTag(Long.valueOf(date.getTime()));
    this.bJx = date.getTime();
    date = new Date();
    this.dAq.setText(simpleDateFormat.format(date));
    this.dAq.setTag(Long.valueOf(date.getTime()));
    this.cfe = date.getTime();
  }
  
  private void xU() {
    this.aJv.setOnClickListener(new ak(this));
    this.byj.setOnClickListener(new al(this));
    this.dAp.setOnClickListener(new am(this));
    this.dAq.setOnClickListener(new ao(this));
  }
  
  public void a(a parama) { this.dAr = parama; }
  
  public void pc(String paramString) { this.byj.setText(paramString); }
  
  public static interface a {
    void l(long param1Long1, long param1Long2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */