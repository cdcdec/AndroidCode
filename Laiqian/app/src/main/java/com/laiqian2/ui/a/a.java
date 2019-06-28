package com.laiqian.ui.a;

import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import com.laiqian.infrastructure.R;

public class a extends f {
  private String Ze;
  
  private TextView bqZ;
  
  private boolean cXk = false;
  
  private Time daC;
  
  private DatePicker dzc;
  
  protected TimePicker dzd;
  
  private View dze;
  
  private View dzf;
  
  private a dzg;
  
  private Context mContext;
  
  public a(Context paramContext, TextView paramTextView, String paramString) {
    super(paramContext);
    this.mContext = paramContext;
    this.bqZ = paramTextView;
    this.Ze = paramString;
    init();
  }
  
  public a(Context paramContext, String paramString) { this(paramContext, null, paramString); }
  
  private void init() {
    View view = LayoutInflater.from(this.mContext).inflate(R.layout.date_time_layout, null);
    this.dzc = (DatePicker)view.findViewById(R.id.date_picker);
    this.dzd = (TimePicker)view.findViewById(R.id.time_picker);
    this.dzd.setIs24HourView(Boolean.valueOf(true));
    this.daC = new Time();
    this.dze = view.findViewById(R.id.btn_ok);
    this.dzf = view.findViewById(R.id.btn_cancel);
    this.dze.setOnClickListener(new b(this));
    this.dzf.setOnClickListener(new c(this));
    setContentView(view);
  }
  
  public void a(a parama) { this.dzg = parama; }
  
  public void g(TextView paramTextView) {
    this.bqZ = paramTextView;
    show();
  }
  
  public void he(boolean paramBoolean) { this.cXk = paramBoolean; }
  
  public void setFormat(String paramString) { this.Ze = paramString; }
  
  public void show() {
    Long long2 = Long.valueOf(Long.parseLong(String.valueOf(this.bqZ.getTag())));
    Long long1 = long2;
    if (long2 == null)
      long1 = Long.valueOf(0L); 
    this.daC.set(long1.longValue());
    if (this.cXk) {
      this.dzc.setVisibility(8);
    } else {
      this.dzc.setVisibility(0);
    } 
    this.dzc.updateDate(this.daC.year, this.daC.month, this.daC.monthDay);
    this.dzd.setCurrentHour(Integer.valueOf(this.daC.hour));
    super.show();
  }
  
  public static interface a {
    boolean a(TextView param1TextView, String param1String, long param1Long);
    
    void b(TextView param1TextView, String param1String, long param1Long);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */