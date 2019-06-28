package com.laiqian.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;
import java.text.SimpleDateFormat;
import java.util.Date;

public class az extends f {
  private String Ze;
  
  private TextView bqZ;
  
  private a dAK;
  
  private TimePicker dzd;
  
  private View dze;
  
  private Context mContext;
  
  public az(Context paramContext, TextView paramTextView, String paramString) {
    super(paramContext);
    this.mContext = paramContext;
    this.bqZ = paramTextView;
    this.Ze = paramString;
    init();
  }
  
  private void init() {
    View view = LayoutInflater.from(this.mContext).inflate(R.layout.time_layout, null);
    this.dzd = (TimePicker)view.findViewById(R.id.time_picker);
    this.dzd.setIs24HourView(Boolean.valueOf(true));
    this.dze = view.findViewById(R.id.btn_ok);
    this.dze.setOnClickListener(new ba(this));
    setContentView(view);
  }
  
  public void a(a parama) { this.dAK = parama; }
  
  public void show() {
    str = this.bqZ.getText().toString();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.Ze);
    try {
      Date date = simpleDateFormat.parse(str);
    } catch (Exception str) {
      a.e(str);
      str = null;
    } 
    this.dzd.setCurrentHour(Integer.valueOf(str.getHours()));
    this.dzd.setCurrentMinute(Integer.valueOf(str.getMinutes()));
    super.show();
  }
  
  public static interface a {
    boolean a(TextView param1TextView, int param1Int1, int param1Int2);
    
    void b(TextView param1TextView, int param1Int1, int param1Int2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */