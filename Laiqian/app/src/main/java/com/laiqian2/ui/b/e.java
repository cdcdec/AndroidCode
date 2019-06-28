package com.laiqian.ui.b;

import android.text.Editable;
import android.view.View;
import com.laiqian.infrastructure.R;

class e implements View.OnClickListener {
  e(a parama) {}
  
  public void onClick(View paramView) {
    a.e(this.dDv);
    if (this.dDv.cgE && paramView.getId() != R.id.ok && paramView.getId() != R.id.calc)
      a.b(this.dDv).setText(""); 
    Editable editable = a.b(this.dDv).getText();
    int i = a.b(this.dDv).getSelectionStart();
    if (paramView.getId() == R.id.dot) {
      if (editable.length() > 0) {
        this.dDv.cgE = false;
        if (editable.toString().contains(".")) {
          this.dDv.cgF = true;
          return;
        } 
        editable.insert(i, ".");
        this.dDv.cgF = true;
        return;
      } 
      if (this.dDv.cgE) {
        editable.insert(i, "0.");
        this.dDv.cgF = true;
        this.dDv.cgE = false;
        return;
      } 
      if (this.dDv.cgF)
        return; 
      editable.insert(i, ".");
      this.dDv.cgF = true;
      return;
    } 
    if (paramView.getId() == R.id.zero) {
      if (editable.length() > 0) {
        this.dDv.cgE = false;
        editable.insert(i, "0");
        return;
      } 
      editable.insert(i, "0");
      this.dDv.cgE = false;
      this.dDv.cgF = true;
      return;
    } 
    if (paramView.getId() == R.id.one) {
      editable.insert(i, "1");
      this.dDv.cgE = false;
      return;
    } 
    if (paramView.getId() == R.id.two) {
      editable.insert(i, "2");
      this.dDv.cgE = false;
      return;
    } 
    if (paramView.getId() == R.id.three) {
      editable.insert(i, "3");
      this.dDv.cgE = false;
      return;
    } 
    if (paramView.getId() == R.id.four) {
      editable.insert(i, "4");
      this.dDv.cgE = false;
      return;
    } 
    if (paramView.getId() == R.id.five) {
      editable.insert(i, "5");
      this.dDv.cgE = false;
      return;
    } 
    if (paramView.getId() == R.id.six) {
      editable.insert(i, "6");
      this.dDv.cgE = false;
      return;
    } 
    if (paramView.getId() == R.id.seven) {
      editable.insert(i, "7");
      this.dDv.cgE = false;
      return;
    } 
    if (paramView.getId() == R.id.eight) {
      editable.insert(i, "8");
      this.dDv.cgE = false;
      return;
    } 
    if (paramView.getId() == R.id.nine) {
      editable.insert(i, "9");
      this.dDv.cgE = false;
      return;
    } 
    if (paramView.getId() == R.id.delete) {
      if (editable != null && editable.length() > 0 && i > 0) {
        editable.delete(i - 1, i);
        if (editable.length() <= 0) {
          this.dDv.cgE = true;
          this.dDv.cgF = false;
          return;
        } 
      } 
    } else if (paramView.getId() == R.id.ok) {
      if (editable.length() > 0 && editable.charAt(editable.length() - 1) == '.')
        editable.append("0"); 
      if (a.d(this.dDv) != null) {
        a.d(this.dDv).dismiss();
        if (a.a(this.dDv).getVisibility() == 0)
          a.a(this.dDv).setVisibility(8); 
        a.a(this.dDv, null);
        this.dDv.cgE = true;
        this.dDv.cgF = false;
      } 
      if (a.f(this.dDv) != null) {
        a.f(this.dDv).sendEmptyMessage(0);
        return;
      } 
    } else if (paramView.getId() == R.id.calc) {
      if (a.d(this.dDv) != null) {
        a.d(this.dDv).dismiss();
        if (a.a(this.dDv).getVisibility() == 0)
          a.a(this.dDv).setVisibility(8); 
        a.a(this.dDv, null);
      } 
      this.dDv.ase();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */