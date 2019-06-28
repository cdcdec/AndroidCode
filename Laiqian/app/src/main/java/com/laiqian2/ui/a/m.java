package com.laiqian.ui.a;

import android.app.Activity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.s;
import com.laiqian.util.ae;

public class m extends f {
  private TextView aNl;
  
  private Button dzq;
  
  private View dzr;
  
  private View dzs;
  
  private ListView dzt;
  
  private p dzu;
  
  private double dzv = 0.3D;
  
  private double dzw = 0.0D;
  
  private int dzx = 0;
  
  private boolean dzy = true;
  
  private Activity mActivity;
  
  public m(Activity paramActivity, boolean paramBoolean) {
    super(paramActivity, R.style.pos_dialog);
    this.mActivity = paramActivity;
    this.dzy = paramBoolean;
    setContentView(R.layout.pos_spinner_dialog_2014088);
    yR();
  }
  
  private void yR() {
    setCancelable(true);
    setCanceledOnTouchOutside(true);
    this.dzt = (ListView)this.dzr.findViewById(R.id.ss_listview);
    this.dzs = this.dzr.findViewById(R.id.lines);
    this.aNl = (TextView)this.dzr.findViewById(R.id.ss_title);
    this.dzq = (Button)this.dzr.findViewById(R.id.ss_cancel);
  }
  
  public void a(p paramp) { this.dzu = paramp; }
  
  public View ark() { return this.dzr; }
  
  public ListView getListView() { return this.dzt; }
  
  public void setContentView(int paramInt) { this.dzr = LayoutInflater.from(this.mActivity).inflate(paramInt, null); }
  
  public void setTitle(String paramString) {
    if (paramString == null) {
      this.aNl.setVisibility(8);
      return;
    } 
    this.aNl.setText(paramString);
  }
  
  public void setWidth(int paramInt) { this.dzx = paramInt; }
  
  public void show() {
    if (this.dzu == null) {
      dismiss();
      return;
    } 
    setContentView(this.dzr);
    this.dzq.setOnClickListener(new n(this));
    this.dzt.setAdapter(this.dzu);
    this.dzu.notifyDataSetChanged();
    super.show();
    (new s()).dq(this.dzt);
    Display display = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay();
    WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
    if (this.dzw > 0.0D)
      layoutParams.height = (int)(display.getHeight() * this.dzw); 
    if (this.dzv > 0.0D)
      layoutParams.width = (int)(display.getWidth() * this.dzv); 
    if (this.dzx > 0)
      layoutParams.width = this.dzx; 
    this.dzt.setVerticalScrollBarEnabled(false);
    this.dzt.setOnTouchListener(new o(this));
    if (this.dzu.getCount() <= 4) {
      ViewGroup.LayoutParams layoutParams1 = this.dzt.getLayoutParams();
      layoutParams1.width = -1;
      layoutParams1.height = ae.b(this.mActivity, (this.dzu.getCount() * 49));
      this.dzt.setLayoutParams(layoutParams1);
      this.dzt.setVerticalScrollBarEnabled(false);
    } else {
      this.dzs.setVisibility(0);
    } 
    getWindow().setAttributes(layoutParams);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */