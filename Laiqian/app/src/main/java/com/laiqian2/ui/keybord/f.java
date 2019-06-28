package com.laiqian.ui.keybord;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.laiqian.infrastructure.R;
import com.laiqian.util.bs;
import java.util.List;

public class f {
  private bs aZe = null;
  
  private Keyboard dBE;
  
  private Keyboard dBF;
  
  private Keyboard dBG;
  
  private Keyboard dBH;
  
  private Drawable dBI = null;
  
  private Drawable dBJ = null;
  
  private boolean dBK = false;
  
  private EditText[] dBL;
  
  private KeyBoardLinearlayout dBM;
  
  private KeyboardView.OnKeyboardActionListener dBN = new g(this);
  
  private KeyboardView dBg;
  
  private KeyboardView dBh;
  
  private KeyboardView dBi;
  
  private KeyboardView dBj;
  
  private KeyboardView dBk;
  
  private LinearLayout dBl;
  
  private LinearLayout dBm;
  
  private LinearLayout dBn;
  
  public f(Activity paramActivity, EditText[] paramArrayOfEditText, KeyBoardLinearlayout paramKeyBoardLinearlayout) {
    this.dBM = paramKeyBoardLinearlayout;
    this.dBL = paramArrayOfEditText;
    this.dBF = new Keyboard(paramActivity, R.xml.qr_number);
    this.dBG = new Keyboard(paramActivity, R.xml.qr_only_number);
    this.dBE = new Keyboard(paramActivity, R.xml.qr_letter);
    this.dBH = new Keyboard(paramActivity, R.xml.qr_symbol);
    this.dBg = paramKeyBoardLinearlayout.arC();
    this.dBh = paramKeyBoardLinearlayout.arD();
    this.dBj = paramKeyBoardLinearlayout.ary();
    this.dBk = paramKeyBoardLinearlayout.arz();
    this.dBi = paramKeyBoardLinearlayout.arE();
    this.dBl = paramKeyBoardLinearlayout.arA();
    this.dBm = paramKeyBoardLinearlayout.arB();
    this.dBn = paramKeyBoardLinearlayout.arx();
    this.dBI = paramActivity.getResources().getDrawable(R.drawable.keyboard_capital);
    this.dBJ = paramActivity.getResources().getDrawable(R.drawable.keyboard_lowercase);
    this.dBj.setPreviewEnabled(false);
    this.dBk.setPreviewEnabled(false);
    this.dBg.setPreviewEnabled(false);
    this.dBh.setPreviewEnabled(false);
    this.dBi.setPreviewEnabled(false);
    this.dBi.setKeyboard(this.dBG);
    this.dBh.setKeyboard(this.dBF);
    this.dBg.setKeyboard(this.dBE);
    this.dBk.setKeyboard(this.dBF);
    this.dBj.setKeyboard(this.dBH);
    this.dBj.setOnKeyboardActionListener(this.dBN);
    this.dBk.setOnKeyboardActionListener(this.dBN);
    this.dBg.setOnKeyboardActionListener(this.dBN);
    this.dBh.setOnKeyboardActionListener(this.dBN);
    this.dBi.setOnKeyboardActionListener(this.dBN);
  }
  
  private void arG() { this.dBg.setKeyboard(this.dBg.getKeyboard()); }
  
  private void arH() {
    List list = this.dBE.getKeys();
    if (this.dBK) {
      this.dBK = false;
      for (Keyboard.Key key : list) {
        if (key.label != null && pd(key.label.toString())) {
          key.label = key.label.toString().toLowerCase();
          key.codes[0] = key.codes[0] + 32;
          continue;
        } 
        if (key.codes[0] == -1)
          key.icon = this.dBJ; 
      } 
    } else {
      this.dBK = true;
      for (Keyboard.Key key : list) {
        if (key.label != null && pd(key.label.toString())) {
          key.label = key.label.toString().toUpperCase();
          key.codes[0] = key.codes[0] - 32;
          continue;
        } 
        if (key.codes[0] == -1)
          key.icon = this.dBI; 
      } 
    } 
  }
  
  private void hj(boolean paramBoolean) {
    if (paramBoolean) {
      if (this.dBl.getVisibility() == 0)
        this.dBl.setVisibility(8); 
      this.dBn.setVisibility(0);
      return;
    } 
    if (this.dBm.getVisibility() == 8)
      this.dBl.setVisibility(0); 
    this.dBn.setVisibility(8);
  }
  
  private boolean pd(String paramString) { return ("abcdefghijklmnopqrstuvwxyz".indexOf(paramString.toLowerCase()) > -1); }
  
  public void a(bs parambs) { this.aZe = parambs; }
  
  public EditText arI() {
    for (EditText editText : this.dBL) {
      if (editText.isFocused())
        return editText; 
    } 
    return null;
  }
  
  public void arJ() {
    this.dBl.setVisibility(8);
    this.dBm.setVisibility(8);
    this.dBn.setVisibility(8);
  }
  
  public void i(ViewGroup.LayoutParams paramLayoutParams) {
    if (paramLayoutParams != null)
      this.dBg.setLayoutParams(paramLayoutParams); 
  }
  
  public void j(ViewGroup.LayoutParams paramLayoutParams) {
    if (paramLayoutParams != null)
      this.dBi.setLayoutParams(paramLayoutParams); 
  }
  
  public void kY(int paramInt) {
    this.dBn.setVisibility(8);
    if (arI() == null)
      return; 
    if (paramInt == 2 || paramInt == 3) {
      this.dBl.setVisibility(8);
      this.dBm.setVisibility(0);
      return;
    } 
    this.dBl.setVisibility(0);
    this.dBm.setVisibility(8);
    if (this.dBK) {
      arH();
      arG();
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\keybord\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */