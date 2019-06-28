package com.laiqian.ui.b;

import android.view.View;
import com.laiqian.infrastructure.R;
import com.laiqian.util.d;

class g implements View.OnClickListener {
  double b = 0.0D;
  
  int c = 0;
  
  boolean cgF = false;
  
  double f = 0.0D;
  
  double g = 0.0D;
  
  g(a parama) {}
  
  private void asf() {
    this.b = 0.0D;
    this.c = 0;
    this.g = 0.0D;
    a.a(this.dDv, "0");
    a.g(this.dDv).setText(a.h(this.dDv));
    this.dDv.dDt = true;
    this.cgF = false;
  }
  
  private double asg() {
    switch (this.c) {
      case 4:
        this.f = d.f(this.b, this.g);
        break;
      case 3:
        this.f = d.e(this.b, this.g);
        break;
      case 2:
        this.f = d.d(this.b, this.g);
        break;
      case 1:
        this.f = d.c(this.b, this.g);
        break;
      case 0:
        this.f = this.g;
        break;
    } 
    this.b = this.f;
    this.c = 0;
    return this.f;
  }
  
  private void dt(View paramView) {
    String str = paramView.getTag().toString();
    if (this.dDv.dDt) {
      a.a(this.dDv, "");
      a a2 = this.dDv;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(a.h(this.dDv));
      stringBuilder1.append(str);
      a.a(a2, stringBuilder1.toString());
      a.g(this.dDv).setText(a.h(this.dDv));
      this.dDv.dDt = false;
      return;
    } 
    a a1 = this.dDv;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a.h(this.dDv));
    stringBuilder.append(str);
    a.a(a1, stringBuilder.toString());
    a.a(this.dDv, pe(a.h(this.dDv)));
    a.g(this.dDv).setText(a.h(this.dDv));
  }
  
  private void du(View paramView) {
    int i = Integer.parseInt(paramView.getTag().toString());
    if (this.dDv.dDt) {
      this.c = i;
    } else {
      this.g = Double.parseDouble(a.h(this.dDv));
      asg();
      a a1 = this.dDv;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(this.f);
      a.a(a1, stringBuilder.toString());
      this.dDv.dDt = true;
      this.cgF = false;
    } 
    this.c = i;
  }
  
  private String pe(String paramString) {
    String str = paramString;
    if (paramString.startsWith("0")) {
      str = paramString;
      if (!paramString.startsWith("0."))
        str = paramString.substring(1); 
    } 
    return str;
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == R.id.bt_clear) {
      asf();
      return;
    } 
    if (i == R.id.bt_ok) {
      a a1 = a.g(this.dDv).getText();
      if (a1.length() > 0 && a1.charAt(a1.length() - 1) == '.')
        a1.append("0"); 
      if (a.h(this.dDv) != "" && !this.dDv.dDt) {
        this.g = Double.parseDouble(a.h(this.dDv));
        asg();
        a1 = this.dDv;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f);
        stringBuilder.append("");
        a.a(a1, stringBuilder.toString());
        a.g(this.dDv).setText(a.h(this.dDv));
        a.b(this.dDv).setText(a.h(this.dDv));
        a.d(this.dDv).dismiss();
        a.a(this.dDv, null);
        this.cgF = false;
        this.dDv.dDt = true;
      } else {
        a.b(this.dDv).setText(a1);
        a.d(this.dDv).dismiss();
        a.a(this.dDv, null);
      } 
      if (a.f(this.dDv) != null) {
        a.f(this.dDv).sendEmptyMessage(0);
        return;
      } 
    } else if (i == R.id.bt_delete) {
      if (a.h(this.dDv) != null && a.h(this.dDv).length() > 0) {
        a.a(this.dDv, a.h(this.dDv).substring(0, a.h(this.dDv).length() - 1));
        a.g(this.dDv).setText(a.h(this.dDv));
      } 
      if (this.dDv.dDt || "".equals(a.h(this.dDv))) {
        asf();
        return;
      } 
    } else {
      a a1;
      if (i == R.id.bt_equal) {
        if (!this.dDv.dDt) {
          this.g = Double.parseDouble(a.h(this.dDv));
          asg();
          a1 = this.dDv;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.f);
          stringBuilder.append("");
          a.a(a1, stringBuilder.toString());
          a.g(this.dDv).setText(a.h(this.dDv));
          this.cgF = false;
          this.dDv.dDt = true;
          return;
        } 
        asf();
        return;
      } 
      if (i == R.id.bt_add) {
        du(a1);
        return;
      } 
      if (i == R.id.bt_plus) {
        du(a1);
        return;
      } 
      if (i == R.id.bt_ride) {
        du(a1);
        return;
      } 
      if (i == R.id.bt_divide) {
        du(a1);
        return;
      } 
      if (i == R.id.bt_dot) {
        if (this.cgF)
          return; 
        a1 = this.dDv;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.h(this.dDv));
        stringBuilder.append(".");
        a.a(a1, stringBuilder.toString());
        a.g(this.dDv).setText(a.h(this.dDv));
        this.cgF = true;
        this.dDv.dDt = false;
        return;
      } 
      if (i == R.id.bt_zero) {
        if (this.dDv.dDt || 0.0D == Double.parseDouble(a.h(this.dDv))) {
          asf();
          return;
        } 
        dt(a1);
        return;
      } 
      dt(a1);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */