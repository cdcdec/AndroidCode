package com.laiqian.pos;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class bk implements View.OnClickListener {
  public boolean cgD = false;
  
  private boolean cgE = true;
  
  private boolean cgF = false;
  
  public boolean cgG = false;
  
  private int[] cgH = null;
  
  private a cgI;
  
  private EditText qY = null;
  
  private void ZM() {
    if (this.qY != null && this.qY.hasSelection())
      init(); 
  }
  
  public void g(EditText paramEditText) {
    boolean bool;
    this.qY = paramEditText;
    Editable editable = this.qY.getText();
    if (editable.length() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.cgE = bool;
    this.cgF = editable.toString().contains(".");
  }
  
  public void init() {
    this.cgE = true;
    this.cgF = false;
  }
  
  public void onClick(View paramView) {
    String str = paramView.getTag().toString().replace("laiqian_number_", "");
    ZM();
    if (this.cgE && !str.equals("ok"))
      this.qY.setText(""); 
    Editable editable = this.qY.getText();
    int i = this.qY.getSelectionStart();
    if (str.equals("dot")) {
      if (editable.length() > 0) {
        this.cgE = false;
        if (!editable.toString().contains("."))
          editable.insert(i, "."); 
        this.cgF = true;
      } else if (this.cgE) {
        editable.insert(i, "0.");
        this.cgF = true;
        this.cgE = false;
      } else if (!this.cgF) {
        editable.insert(i, ".");
        this.cgF = true;
      } 
    } else if (str.equals("0")) {
      if (editable.toString().equals("0") && this.cgG)
        return; 
      this.cgE = false;
      editable.insert(i, "0");
    } else if (str.equals("00")) {
      if (editable.toString().equals("0") && this.cgG)
        return; 
      this.cgE = false;
      if (i > 0) {
        editable.insert(i, "00");
      } else {
        editable.insert(i, "0");
      } 
    } else if (str.equals("back")) {
      if (editable != null && editable.length() > 0 && i > 0) {
        editable.delete(i - 1, i);
        if (editable.length() <= 0)
          init(); 
      } 
    } else if (str.equals("ok")) {
      if (editable.length() > 0 && editable.charAt(editable.length() - 1) == '.')
        editable.append("0"); 
    } else {
      if (this.cgG && editable.toString().equals("0"))
        editable.delete(0, 1); 
      editable.insert(this.qY.getSelectionStart(), str);
      this.cgE = false;
    } 
    if (this.cgI != null)
      this.cgI.ZN(); 
  }
  
  public static interface a {
    void ZN();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */