package com.laiqian.e.a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.w;
import com.laiqian.util.av;
import com.laiqian.util.n;

public class a extends d implements i {
  private TextView aDK;
  
  private TextView aNl;
  
  private TextView aNm;
  
  private EditText aNn;
  
  private TextView aNo;
  
  private TextView aNp;
  
  private f aNq;
  
  private int aNr;
  
  String[] aNs;
  
  String[] aNt;
  
  private w aNu;
  
  private ProgressBarCircularIndeterminate aNv;
  
  private a aNw;
  
  private Context context;
  
  public a(Context paramContext, int paramInt, a parama) {
    super(paramContext, 2131427534);
    this.context = paramContext;
    this.aNr = paramInt;
    this.aNw = parama;
    wR();
    initData();
    setListeners();
  }
  
  private void initData() {
    int j;
    this.aNt = (new av(this.context)).auT();
    Resources resources = this.context.getResources();
    if (this.context.getResources().getBoolean(2131034123)) {
      j = 2130903069;
    } else {
      j = 2130903070;
    } 
    this.aNs = resources.getStringArray(j);
    if (this.aNt != null) {
      this.aNn.setText(this.aNt[0]);
      this.aNm.setText(this.aNt[1]);
      this.aNn.requestFocus();
    } else {
      this.aNn.setText("");
      this.aNn.requestFocus();
      this.aNm.setText(this.aNs[0]);
      n.b(this.context, this.aNn);
    } 
    this.aNu = new w(this.context, this.aNs, new b(this));
  }
  
  private void setListeners() {
    this.aNo.setOnClickListener(new c(this));
    this.aNp.setOnClickListener(new d(this));
    this.aNm.setOnClickListener(new e(this));
  }
  
  private void wR() {
    this.aNl = (TextView)this.mView.findViewById(2131299242);
    this.aNm = (TextView)this.mView.findViewById(2131296893);
    this.aNn = (EditText)this.mView.findViewById(2131296334);
    this.aDK = (TextView)this.mView.findViewById(2131299317);
    this.aNo = (TextView)this.mView.findViewById(2131299090);
    this.aNp = (TextView)this.mView.findViewById(2131296672);
    this.aNv = (ProgressBarCircularIndeterminate)findViewById(2131297346);
    if (this.aNr == 0) {
      this.aNl.setText(this.context.getString(2131626661));
      return;
    } 
    if (this.aNr == 1)
      this.aNl.setText(this.context.getString(2131626662)); 
  }
  
  public void De() {
    this.aDK.setText(this.context.getString(2131628183));
    this.aNo.setVisibility(8);
    this.aNp.setVisibility(8);
    this.aNv.setVisibility(0);
  }
  
  public void Df() {
    this.aDK.setText(this.context.getString(2131626677));
    this.aNo.setVisibility(8);
    this.aNp.setVisibility(8);
    this.aNv.setVisibility(0);
    if (getOwnerActivity() != null && !getOwnerActivity().isFinishing() && !getOwnerActivity().isDestroyed())
      dismiss(); 
    this.aNw.ee(0);
  }
  
  public void co(String paramString) {
    this.aDK.setText(paramString);
    this.aNo.setVisibility(0);
    this.aNp.setVisibility(0);
    this.aNv.setVisibility(8);
  }
  
  public void show() {
    this.aNq = new f(this.context, this);
    super.show();
  }
  
  public void wS() {
    if (getOwnerActivity() != null && !getOwnerActivity().isFinishing() && !getOwnerActivity().isDestroyed())
      dismiss(); 
    n.w(this.context, 2131630124);
  }
  
  public static interface a {
    void ee(int param1Int);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\e\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */