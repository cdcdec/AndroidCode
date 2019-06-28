package com.laiqian.pos;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.a.f;
import java.util.HashMap;

public abstract class aw extends f {
  Button aAf = null;
  
  Button aAg = null;
  
  Button aAh = null;
  
  Button aAi = null;
  
  Button aAj = null;
  
  Button aAk = null;
  
  Button aAl = null;
  
  Button aAm = null;
  
  Button aAn = null;
  
  Button aAo = null;
  
  protected View cfT = null;
  
  Button cfU = null;
  
  protected View cfV = null;
  
  Button cfW = null;
  
  Button cfX = null;
  
  Button cfY = null;
  
  Button cfZ = null;
  
  Button cga = null;
  
  Button cgb = null;
  
  Button cgc = null;
  
  bk cgd = null;
  
  protected av cge = null;
  
  protected HashMap<String, String> cgf = null;
  
  protected View.OnClickListener cgg = new ax(this);
  
  protected Context mContext = null;
  
  protected View oR = null;
  
  public aw(Context paramContext, int paramInt) {
    super(paramContext, paramInt);
    this.mContext = paramContext;
    setCanceledOnTouchOutside(false);
  }
  
  protected void ZE() {
    this.aAf = (Button)this.oR.findViewById(R.id.btnPosPayNumber7);
    this.aAf.setTag("laiqian_number_7");
    this.aAg = (Button)this.oR.findViewById(R.id.btnPosPayNumber8);
    this.aAg.setTag("laiqian_number_8");
    this.aAh = (Button)this.oR.findViewById(R.id.btnPosPayNumber9);
    this.aAh.setTag("laiqian_number_9");
    this.aAi = (Button)this.oR.findViewById(R.id.btnPosPayNumber4);
    this.aAi.setTag("laiqian_number_4");
    this.aAj = (Button)this.oR.findViewById(R.id.btnPosPayNumber5);
    this.aAj.setTag("laiqian_number_5");
    this.aAk = (Button)this.oR.findViewById(R.id.btnPosPayNumber6);
    this.aAk.setTag("laiqian_number_6");
    this.aAl = (Button)this.oR.findViewById(R.id.btnPosPayNumber1);
    this.aAl.setTag("laiqian_number_1");
    this.aAm = (Button)this.oR.findViewById(R.id.btnPosPayNumber2);
    this.aAm.setTag("laiqian_number_2");
    this.aAn = (Button)this.oR.findViewById(R.id.btnPosPayNumber3);
    this.aAn.setTag("laiqian_number_3");
    this.aAo = (Button)this.oR.findViewById(R.id.btnPosPayNumber0);
    this.aAo.setTag("laiqian_number_0");
    this.cfU = (Button)this.oR.findViewById(R.id.btnPosPayNumberDot);
    this.cfU.setTag("laiqian_number_dot");
    this.cfV = this.oR.findViewById(R.id.btnPosPayNumberBack);
    this.cfV.setTag("laiqian_number_back");
    this.cfT = this.oR.findViewById(R.id.btnPosPayBack);
  }
  
  public void a(av paramav) { this.cge = paramav; }
  
  protected void ct(View paramView) {
    this.oR = paramView;
    ZE();
  }
  
  public void eO(boolean paramBoolean) {
    this.aAf.setEnabled(paramBoolean);
    this.aAg.setEnabled(paramBoolean);
    this.aAh.setEnabled(paramBoolean);
    this.aAi.setEnabled(paramBoolean);
    this.aAj.setEnabled(paramBoolean);
    this.aAk.setEnabled(paramBoolean);
    this.aAl.setEnabled(paramBoolean);
    this.aAm.setEnabled(paramBoolean);
    this.aAn.setEnabled(paramBoolean);
    this.cfU.setEnabled(paramBoolean);
    this.aAo.setEnabled(paramBoolean);
    this.cfV.setEnabled(paramBoolean);
  }
  
  public void eP(boolean paramBoolean) { this.cgd.cgG = paramBoolean; }
  
  protected void f(EditText paramEditText) { this.cgd.g(paramEditText); }
  
  protected void initialData() { this.cgf = new HashMap(); }
  
  protected void onStart() { initialData(); }
  
  public void setContentView(View paramView) {
    ct(paramView);
    xU();
    initialData();
    super.setContentView(paramView);
  }
  
  protected void xU() {
    this.cgd = new bk();
    this.aAf.setOnClickListener(this.cgd);
    this.aAg.setOnClickListener(this.cgd);
    this.aAh.setOnClickListener(this.cgd);
    this.aAi.setOnClickListener(this.cgd);
    this.aAj.setOnClickListener(this.cgd);
    this.aAk.setOnClickListener(this.cgd);
    this.aAl.setOnClickListener(this.cgd);
    this.aAm.setOnClickListener(this.cgd);
    this.aAn.setOnClickListener(this.cgd);
    this.aAo.setOnClickListener(this.cgd);
    this.cfU.setOnClickListener(this.cgd);
    this.cfV.setOnClickListener(this.cgd);
    if (this.cfT != null)
      this.cfT.setOnClickListener(this.cgg); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\pos\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */