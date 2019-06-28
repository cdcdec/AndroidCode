package com.laiqian.promotion.ui.datePicker;

import android.app.Activity;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.entity.DateSelectEntity;
import com.laiqian.promotion.R;
import com.laiqian.ui.a.a;
import com.laiqian.ui.a.f;
import com.laiqian.util.n;
import com.laiqian.util.t;

public class a extends f implements View.OnClickListener {
  private Activity aAA;
  
  private a bqt;
  
  private int cWN;
  
  private View cWO;
  
  private View cWP;
  
  private View cWQ;
  
  private View cWR;
  
  private String[] cWS;
  
  private a cWT;
  
  private DateSelectEntity cWU;
  
  private TextView cWV;
  
  private TextView cWW;
  
  private View cWX;
  
  private TextView cWY;
  
  private TextView cWZ;
  
  private TextView cXa;
  
  private EditText cXb;
  
  private TextView cXc;
  
  private TextView cXd;
  
  private TextView cXe;
  
  private TextView cXf;
  
  private CheckTextView[] cXg;
  
  private ViewGroup cXh;
  
  private TextWatcher cXi = new b(this);
  
  private TextView tvTitle;
  
  public a(Activity paramActivity) {
    super(paramActivity, R.style.pos_dialog);
    setContentView(R.layout.pos_data_picker_diaog);
    this.aAA = paramActivity;
    initView();
  }
  
  private void TG() {
    this.tvTitle.setText(this.cWS[this.cWN - 1]);
    View view = this.cWO;
    int i = this.cWN;
    int j = 8;
    if (i == 1) {
      i = 0;
    } else {
      i = 8;
    } 
    view.setVisibility(i);
    view = this.cWP;
    if (this.cWN == 2) {
      i = 0;
    } else {
      i = 8;
    } 
    view.setVisibility(i);
    view = this.cWQ;
    if (this.cWN == 3) {
      i = 0;
    } else {
      i = 8;
    } 
    view.setVisibility(i);
    view = this.cWR;
    if (this.cWN == 4) {
      i = 0;
    } else {
      i = 8;
    } 
    view.setVisibility(i);
    view = this.cWX;
    if (this.cWN == 1) {
      i = j;
    } else {
      i = 0;
    } 
    view.setVisibility(i);
  }
  
  private void a(int paramInt, char paramChar) {
    StringBuilder stringBuilder = new StringBuilder("0000000000000000000000000000000");
    stringBuilder.setCharAt(paramInt - 1, paramChar);
    this.cWU.b(stringBuilder);
    stringBuilder = new StringBuilder();
    stringBuilder.append("setWeekCheck: ");
    stringBuilder.append(this.cWU.EC().toString());
    Log.e("WeekCheck", stringBuilder.toString());
  }
  
  private void amc() {
    if (this.cWU == null) {
      long l;
      String str3 = t.a(t.dFf);
      String str2 = (new DateSelectEntity.a()).ep(this.cWN).cU(str3).af(t.asI()).d(new StringBuilder("1000000000000000000000000000000")).c(new StringBuilder("0000000"));
      if (this.cWN == 1) {
        l = System.currentTimeMillis();
      } else {
        l = t.a("00:00", t.dFe);
      } 
      DateSelectEntity.a a1 = str2.ad(l);
      if (this.cWN == 1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("");
        String str = t.b(stringBuilder.toString(), t.dFc);
      } else {
        str2 = "00:00";
      } 
      String str1 = a1.cS(str2);
      if (this.cWN == 1) {
        l = t.asL();
      } else {
        l = t.a("23:59", t.dFe);
      } 
      a1 = str1.ae(l);
      if (this.cWN == 1) {
        String str = t.b(t.dFc);
      } else {
        str1 = "23:59";
      } 
      this.cWU = a1.cT(str1).EE();
    } 
    this.cWV.setText(this.cWU.Ex());
    this.cWV.setTag(Long.valueOf(this.cWU.Ew()));
    this.cWV.setTag(R.id.dateDialogTag, new TextView[] { this.cWV, this.cWW });
    this.cWW.setText(this.cWU.Ez());
    this.cWW.setTag(Long.valueOf(this.cWU.Ey()));
    this.cWW.setTag(R.id.dateDialogTag, new TextView[] { this.cWV, this.cWW });
    this.cXe.setText(this.cWU.Ex());
    this.cXe.setTag(Long.valueOf(this.cWU.Ew()));
    this.cXe.setTag(R.id.dateDialogTag, new TextView[] { this.cXe, this.cXf });
    this.cXf.setText(this.cWU.Ez());
    this.cXf.setTag(Long.valueOf(this.cWU.Ey()));
    this.cXf.setTag(R.id.dateDialogTag, new TextView[] { this.cXe, this.cXf });
    this.cXc.setText(this.cWU.Ex());
    this.cXc.setTag(Long.valueOf(this.cWU.Ew()));
    this.cXc.setTag(R.id.dateDialogTag, new TextView[] { this.cXc, this.cXd });
    this.cXd.setText(this.cWU.Ez());
    this.cXd.setTag(Long.valueOf(this.cWU.Ey()));
    this.cXd.setTag(R.id.dateDialogTag, new TextView[] { this.cXc, this.cXd });
    this.cWZ.setText(this.cWU.Ex());
    this.cWZ.setTag(Long.valueOf(this.cWU.Ew()));
    this.cWZ.setTag(R.id.dateDialogTag, new TextView[] { this.cWZ, this.cXa });
    this.cXa.setText(this.cWU.Ez());
    this.cXa.setTag(Long.valueOf(this.cWU.Ey()));
    this.cXa.setTag(R.id.dateDialogTag, new TextView[] { this.cWZ, this.cXa });
    char[] arrayOfChar = this.cWU.ED().toString().toCharArray();
    byte b;
    for (b = 0; b < arrayOfChar.length; b++) {
      if (arrayOfChar[b] == '1') {
        this.cXb.setText(String.valueOf(b + true));
        break;
      } 
    } 
    this.cXb.addTextChangedListener(this.cXi);
    this.cWY.setText(this.cWU.EB());
    this.cWY.setTag(Long.valueOf(this.cWU.EA()));
    for (b = 1; b < this.cXg.length; b++) {
      boolean bool;
      this.cXg[b] = (CheckTextView)this.cXh.getChildAt(b);
      this.cXg[b].setTag(Integer.valueOf(b));
      CheckTextView checkTextView = this.cXg[b];
      if (this.cWU.EC().toString().toCharArray()[b - 1] == '1') {
        bool = true;
      } else {
        bool = false;
      } 
      checkTextView.setChecked(bool);
    } 
  }
  
  private void amd() {
    for (byte b = 1; b < this.cXg.length; b++) {
      this.cXg[b] = (CheckTextView)this.cXh.getChildAt(b);
      this.cXg[b].setTag(Integer.valueOf(b));
      this.cXg[b].setOnCheckedChangeListener(new c(this));
    } 
  }
  
  private void b(int paramInt, char paramChar) {
    this.cWU.EC().setCharAt(paramInt - 1, paramChar);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setWeekCheck: ");
    stringBuilder.append(this.cWU.EC().toString());
    Log.e("WeekCheck", stringBuilder.toString());
  }
  
  private void initView() {
    this.tvTitle = (TextView)findViewById(R.id.tvTitle);
    this.cWO = findViewById(R.id.layout_date_picker_period);
    this.cWV = (TextView)this.cWO.findViewById(R.id.date_period_begin);
    this.cWW = (TextView)this.cWO.findViewById(R.id.date_period_end);
    this.cWP = findViewById(R.id.layout_date_picker_Everyday);
    this.cXe = (TextView)this.cWP.findViewById(R.id.date_everyday_begin);
    this.cXf = (TextView)this.cWP.findViewById(R.id.date_everyday_end);
    this.cWQ = findViewById(R.id.layout_date_picker_weekly);
    this.cXc = (TextView)this.cWQ.findViewById(R.id.date_weekly_begin);
    this.cXd = (TextView)this.cWQ.findViewById(R.id.date_weekly_end);
    this.cXh = (ViewGroup)this.cWQ.findViewById(R.id.layWeekTimeFrameId);
    this.cXg = new CheckTextView[this.cXh.getChildCount()];
    amd();
    this.cWR = findViewById(R.id.layout_date_picker_month);
    this.cWZ = (TextView)this.cWR.findViewById(R.id.date_month_begin);
    this.cXa = (TextView)this.cWR.findViewById(R.id.date_month_end);
    this.cXb = (EditText)this.cWR.findViewById(R.id.date_month_day);
    this.cWX = findViewById(R.id.layExpireTimeFrameId);
    this.cWY = (TextView)this.cWX.findViewById(R.id.tv_ExpireTime);
    View view = findViewById(R.id.cancel);
    findViewById(R.id.sure).setOnClickListener(this);
    view.setOnClickListener(this);
    this.cWV.setOnClickListener(new b(this, this.cWV, "%Y-%m-%d %H:%M", false, null));
    this.cWW.setOnClickListener(new b(this, this.cWW, "%Y-%m-%d %H:%M", false, null));
    this.cXe.setOnClickListener(new b(this, this.cXe, "%H:%M", true, null));
    this.cXf.setOnClickListener(new b(this, this.cXf, "%H:%M", true, null));
    this.cXc.setOnClickListener(new b(this, this.cXc, "%H:%M", true, null));
    this.cXd.setOnClickListener(new b(this, this.cXd, "%H:%M", true, null));
    this.cWZ.setOnClickListener(new b(this, this.cWZ, "%H:%M", true, null));
    this.cXa.setOnClickListener(new b(this, this.cXa, "%H:%M", true, null));
    this.cWY.setOnClickListener(new b(this, this.cWY, "%Y/%m/%d %H:%M", false, null));
    this.cWS = this.aAA.getResources().getStringArray(R.array.date_dialog_title);
  }
  
  public void a(a parama) { this.cWT = parama; }
  
  public void dismiss() {
    if (this.aAA != null && !this.aAA.isFinishing()) {
      this.cWU = null;
      this.cXb.removeTextChangedListener(this.cXi);
      super.dismiss();
    } 
  }
  
  protected void jD(int paramInt) { this.cWN = paramInt; }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == R.id.cancel) {
      dismiss();
      return;
    } 
    if (i == R.id.sure) {
      i = n.parseInt(this.cXb.getText().toString().trim());
      if (i > 31 || i < 1) {
        n.eP(R.string.pos_data_pricker_rang_1_31);
        return;
      } 
      if (this.cWN == 3 && this.cWU.EC().toString().equals("0000000")) {
        n.eP(R.string.pos_must_select_one_day);
        return;
      } 
      if (this.cWT != null) {
        if (this.cWN == 1) {
          this.cWU.ac(this.cWU.Ey());
          this.cWU.cR(this.cWU.Ez());
        } 
        this.cWT.d(this.cWU);
        dismiss();
        return;
      } 
    } 
  }
  
  public void show() {
    TG();
    super.show();
    amc();
  }
  
  public static interface a {
    void d(DateSelectEntity param1DateSelectEntity);
  }
  
  private class b implements View.OnClickListener {
    private String Ze;
    
    private TextView bqZ;
    
    boolean cXk;
    
    private b(a this$0, TextView param1TextView, String param1String, boolean param1Boolean) {
      this.bqZ = param1TextView;
      this.Ze = param1String;
      this.cXk = param1Boolean;
    }
    
    public void onClick(View param1View) {
      if (a.a(this.cXj) == null) {
        a.a(this.cXj, new a(a.b(this.cXj), this.Ze));
        a.a(this.cXj).a(new d(this));
      } 
      a.a(this.cXj).he(this.cXk);
      a.a(this.cXj).setFormat(this.Ze);
      a.a(this.cXj).g(this.bqZ);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\datePicker\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */