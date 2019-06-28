package com.laiqian.ui.a;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.s;
import com.laiqian.util.ae;
import com.laiqian.util.ck;

public class r extends f {
  private a aCA;
  
  TextView aNl;
  
  private Context context;
  
  TextView dzH;
  
  EditText dzI;
  
  Button dzJ;
  
  Button dzK;
  
  Button dzL;
  
  LinearLayout dzM;
  
  LinearLayout dzN;
  
  int dzO;
  
  ScrollView dzP;
  
  private int dzQ = 0;
  
  View dzr;
  
  private double dzv = 0.3D;
  
  private double dzw = 0.0D;
  
  private int dzx = 0;
  
  private boolean dzy = true;
  
  public r(Context paramContext, int paramInt, a parama) { this(paramContext, paramInt, parama, true); }
  
  public r(Context paramContext, int paramInt, a parama, boolean paramBoolean) {
    super(paramContext, R.style.pos_dialog);
    this.dzO = paramInt;
    this.context = paramContext;
    this.dzy = paramBoolean;
    this.aCA = parama;
    if ((paramContext.getResources().getConfiguration()).orientation == 1)
      this.dzv = 0.6D; 
    kP(R.layout.pos_confirm_dialog_20150129);
    yR();
    yP();
  }
  
  public r(Context paramContext, a parama) { this(paramContext, 1, parama, true); }
  
  private void yP() {
    this.dzL.setOnClickListener(new s(this));
    this.dzJ.setOnClickListener(new t(this));
    this.dzK.setOnClickListener(new u(this));
  }
  
  private void yR() {
    setCancelable(false);
    this.dzM = (LinearLayout)this.dzr.findViewById(R.id.ss_top);
    this.dzN = (LinearLayout)this.dzr.findViewById(R.id.confirm_third_lay);
    this.aNl = (TextView)this.dzr.findViewById(R.id.ss_title);
    this.dzL = (Button)this.dzr.findViewById(R.id.confirm_third);
    this.dzJ = (Button)this.dzr.findViewById(R.id.confirm_left);
    this.dzK = (Button)this.dzr.findViewById(R.id.confirm_right);
    this.dzP = (ScrollView)this.dzr.findViewById(R.id.ss_ScrollView);
    switch (this.dzO) {
      case 4:
        this.dzJ.setBackgroundResource(R.drawable.confirm_button_selector_bottomcenter);
        this.dzN.setVisibility(0);
        break;
      case 3:
        this.dzK.setVisibility(8);
        this.dzJ.setTextColor(this.context.getResources().getColor(R.color.red_color_10500));
        this.dzJ.setBackgroundResource(R.drawable.confirm_button_selector_bottomcenter);
        break;
      case 2:
        this.dzJ.setText(this.context.getString(R.string.pos_dialog_confirm_yes));
        this.dzJ.setTextColor(this.context.getResources().getColor(R.color.red_color_10500));
        this.dzK.setText(this.context.getString(R.string.pos_dialog_confirm_no));
        this.dzK.setTextColor(this.context.getResources().getColor(R.color.new_pos_dialog_button_text));
        break;
    } 
    this.dzH = (TextView)this.dzr.findViewById(R.id.ss_text);
    this.dzI = (EditText)this.dzr.findViewById(R.id.ss_edit);
  }
  
  public void a(a parama) { this.aCA = parama; }
  
  public void aW(double paramDouble) { this.dzv = paramDouble; }
  
  public void arl() { this.dzH.setGravity(17); }
  
  public Button arm() { return (this.dzO != 4) ? this.dzJ : this.dzL; }
  
  public Button arn() { return this.dzK; }
  
  public Button aro() { return this.dzJ; }
  
  public void kP(int paramInt) { this.dzr = LayoutInflater.from(this.context).inflate(paramInt, null); }
  
  public void oZ(String paramString) { arm().setText(paramString); }
  
  public void pa(String paramString) { arm().setText(paramString); }
  
  public void s(CharSequence paramCharSequence) { this.dzH.setText(paramCharSequence); }
  
  public void setTitle(String paramString) {
    if (paramString == null) {
      this.dzM.setVisibility(8);
      this.dzP.setBackgroundResource(R.drawable.confirm_button_selector_topcenter);
      this.dzH.setPadding(0, ck.b(41.0F, this.context.getResources()), 0, ck.b(18.0F, this.context.getResources()));
      return;
    } 
    this.dzH.setPadding(0, 0, 0, 0);
    this.dzP.setBackgroundColor(-1);
    this.dzM.setVisibility(0);
    this.aNl.setText(paramString);
  }
  
  public void setWidth(int paramInt) { this.dzx = paramInt; }
  
  public void show() {
    setContentView(this.dzr);
    super.show();
    (new s()).dq(this.dzr);
    this.dzP.setVerticalScrollBarEnabled(false);
    this.dzP.setOnTouchListener(new v(this));
    Display display = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay();
    WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
    if (this.dzw > 0.0D)
      layoutParams.height = (int)(display.getHeight() * this.dzw); 
    if (this.dzv > 0.0D)
      layoutParams.width = (int)(display.getWidth() * this.dzv); 
    if (this.dzx > 0)
      layoutParams.width = this.dzx; 
    if (this.dzQ > 0)
      layoutParams.height = this.dzQ; 
    if (ae.b(this.context, this.dzr.getMeasuredHeight()) >= ae.bS(this.context)[1])
      layoutParams.height = ae.b(this.context, 'ì') + 10 + ae.c(this.context, '´'); 
    getWindow().setAttributes(layoutParams);
  }
  
  public void t(CharSequence paramCharSequence) { arn().setText(paramCharSequence); }
  
  public static interface a {
    void xD();
    
    void xE();
    
    void xF();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqia\\ui\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */