package com.laiqian.ui.keybord;

import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.laiqian.infrastructure.R;

public class KeyBoardLinearlayout extends LinearLayout {
  private Context context;
  
  private KeyboardView dBg;
  
  private KeyboardView dBh;
  
  private KeyboardView dBi;
  
  private KeyboardView dBj;
  
  private KeyboardView dBk;
  
  private LinearLayout dBl;
  
  private LinearLayout dBm;
  
  private LinearLayout dBn;
  
  public KeyBoardLinearlayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    initData();
  }
  
  private void initData() {
    View view = LayoutInflater.from(this.context).inflate(R.layout.pos_keyboard_view, null);
    this.dBj = (KeyboardView)view.findViewById(R.id.keyboard_view_symbol_left);
    this.dBk = (KeyboardView)view.findViewById(R.id.keyboard_view_symbol_right);
    this.dBg = (KeyboardView)view.findViewById(R.id.keyboard_view_left);
    this.dBh = (KeyboardView)view.findViewById(R.id.keyboard_view_right);
    this.dBg = (KeyboardView)view.findViewById(R.id.keyboard_view_left);
    this.dBi = (KeyboardView)view.findViewById(R.id.keyboard_view_number);
    this.dBl = (LinearLayout)view.findViewById(R.id.keyboard_lay_letter);
    this.dBm = (LinearLayout)view.findViewById(R.id.keyboard_lay_number);
    this.dBn = (LinearLayout)view.findViewById(R.id.keyboard_lay_symbol);
    addView(view);
  }
  
  public LinearLayout arA() { return this.dBl; }
  
  public LinearLayout arB() { return this.dBm; }
  
  public KeyboardView arC() { return this.dBg; }
  
  public KeyboardView arD() { return this.dBh; }
  
  public KeyboardView arE() { return this.dBi; }
  
  public LinearLayout arx() { return this.dBn; }
  
  public KeyboardView ary() { return this.dBj; }
  
  public KeyboardView arz() { return this.dBk; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\keybord\KeyBoardLinearlayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */