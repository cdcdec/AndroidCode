package com.laiqian.promotion.ui.datePicker;

import android.text.Html;
import com.laiqian.entity.DateSelectEntity;
import com.laiqian.promotion.R;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.aq;
import com.laiqian.ui.a.g;
import com.laiqian.util.t;
import java.util.ArrayList;
import java.util.List;

public class e extends Object implements a.a, aq.a<f> {
  private g<f> cXm;
  
  private List<f> cXn;
  
  private a cXo;
  
  private a cXp;
  
  private ActivityRoot mActivity;
  
  public e(ActivityRoot paramActivityRoot) {
    this.mActivity = paramActivityRoot;
    init();
  }
  
  private void init() {
    this.cXn = new ArrayList();
    String[] arrayOfString = this.mActivity.getResources().getStringArray(R.array.date_setting_type);
    for (byte b = 0; b < arrayOfString.length; b++) {
      f f = new f(b, Html.fromHtml(arrayOfString[b]));
      this.cXn.add(f);
    } 
    this.cXm = new g(this.mActivity, this.cXn, this);
    this.cXm.hg(false);
    this.cXm.dn(-1L);
    this.cXm.hf(false);
    this.cXm.B(0.389F);
    this.cXm.setTitle(R.string.pos_date_setting);
  }
  
  public void a(a parama) { this.cXp = parama; }
  
  public void a(aq paramaq, int paramInt, f paramf) {
    if (paramInt == 0) {
      null = t.a(t.dFf, 100);
      DateSelectEntity.a a1 = (new DateSelectEntity.a()).ep(0).cU(null).af(t.lu(100)).d(new StringBuilder("1000000000000000000000000000000")).c(new StringBuilder("0000000")).ad(System.currentTimeMillis());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(System.currentTimeMillis());
      stringBuilder.append("");
      DateSelectEntity dateSelectEntity = a1.cS(t.b(stringBuilder.toString(), t.dFc)).ae(t.lu(100)).cT(null).EE();
      if (this.cXp != null) {
        this.cXp.c(dateSelectEntity);
        dismiss();
        return;
      } 
    } else {
      if (this.cXo == null) {
        this.cXo = new a(this.mActivity);
        this.cXo.a(this);
      } 
      this.cXo.jD(paramInt);
      this.cXo.show();
    } 
  }
  
  public void d(DateSelectEntity paramDateSelectEntity) {
    if (this.cXp != null) {
      this.cXp.c(paramDateSelectEntity);
      dismiss();
    } 
  }
  
  public void dismiss() {
    if (this.mActivity != null && !this.mActivity.isFinishing())
      this.cXm.dismiss(); 
  }
  
  public void show() {
    if (this.mActivity != null && !this.mActivity.isFinishing())
      this.cXm.show(); 
  }
  
  public static interface a {
    void c(DateSelectEntity param1DateSelectEntity);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\datePicker\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */