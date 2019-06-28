package com.laiqian.ui.keybord;

import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import com.laiqian.infrastructure.R;

public class a {
  public static final int aCt = R.layout.layout_keyboard;
  
  public View aQG;
  
  private View.OnClickListener bzB = new c(this);
  
  public View dBo;
  
  public View dBp;
  
  public View dBq;
  
  public View dBr;
  
  public View dBs;
  
  public View dBt;
  
  public View dBu;
  
  public View dBv;
  
  public View dBw;
  
  public View dBx;
  
  public View dBy;
  
  public View dBz;
  
  private Window wT;
  
  public a(Window paramWindow) {
    this.wT = paramWindow;
    this.aQG = paramWindow.findViewById(R.id.keyboard_root);
    this.dBo = paramWindow.findViewById(R.id.zero);
    this.dBp = paramWindow.findViewById(R.id.one);
    this.dBq = paramWindow.findViewById(R.id.two);
    this.dBr = paramWindow.findViewById(R.id.three);
    this.dBs = paramWindow.findViewById(R.id.four);
    this.dBt = paramWindow.findViewById(R.id.five);
    this.dBu = paramWindow.findViewById(R.id.six);
    this.dBv = paramWindow.findViewById(R.id.seven);
    this.dBw = paramWindow.findViewById(R.id.eight);
    this.dBx = paramWindow.findViewById(R.id.nine);
    this.dBy = paramWindow.findViewById(R.id.dot);
    this.dBz = paramWindow.findViewById(R.id.delete);
  }
  
  private EditText arF() {
    View view = this.wT.getCurrentFocus();
    return (view != null && view instanceof EditText) ? (EditText)view : null;
  }
  
  private void c(EditText paramEditText, String paramString) {
    if (paramEditText == null)
      return; 
    if (!paramEditText.hasSelection()) {
      int k = paramEditText.getSelectionStart();
      paramEditText.getText().insert(k, paramString);
      return;
    } 
    int i = paramEditText.getSelectionStart();
    int j = paramEditText.getSelectionEnd();
    Editable editable = paramEditText.getText();
    editable.replace(i, j, paramString);
    if (i + paramString.length() != 0 && paramString.length() != 0)
      Selection.setSelection(editable, paramEditText.getEditableText().length()); 
  }
  
  private void i(EditText paramEditText) {
    if (paramEditText == null)
      return; 
    Editable editable = paramEditText.getText();
    if (!paramEditText.hasSelection()) {
      int i = paramEditText.getSelectionStart();
      if (editable.length() >= 1 && i > 0) {
        editable.delete(i - 1, i);
        return;
      } 
    } else {
      editable.delete(paramEditText.getSelectionStart(), paramEditText.getSelectionEnd());
    } 
  }
  
  private void init() {
    this.dBo.setOnClickListener(this.bzB);
    this.dBp.setOnClickListener(this.bzB);
    this.dBq.setOnClickListener(this.bzB);
    this.dBr.setOnClickListener(this.bzB);
    this.dBs.setOnClickListener(this.bzB);
    this.dBt.setOnClickListener(this.bzB);
    this.dBu.setOnClickListener(this.bzB);
    this.dBv.setOnClickListener(this.bzB);
    this.dBw.setOnClickListener(this.bzB);
    this.dBx.setOnClickListener(this.bzB);
    this.dBy.setOnClickListener(this.bzB);
    this.dBz.setOnClickListener(this.bzB);
    this.dBz.setOnLongClickListener(new b(this));
  }
  
  public static a r(Window paramWindow) {
    a a1 = new a(paramWindow);
    a1.init();
    return a1;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\keybord\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */