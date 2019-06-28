package com.laiqian.ui.edittext;

import android.os.Build;
import android.util.Log;
import android.view.InputDevice;
import android.view.KeyEvent;
import com.laiqian.util.n;

public class a {
  private static final String TAG = "a";
  
  private static boolean dAM;
  
  private long aRA;
  
  private boolean bko;
  
  private StringBuffer dAN;
  
  private a dAO;
  
  private long dAP;
  
  private char[] dAQ = { '!', '@', '#', '$', '%', '^', '&', '*', '(', ')' };
  
  private int n = 0;
  
  private boolean needSyncInput = false;
  
  static  {
  
  }
  
  public a(a parama) {
    this.dAO = parama;
    this.dAN = new StringBuffer();
  }
  
  public static boolean a(InputDevice paramInputDevice) { return ((paramInputDevice.getSources() & 0x101) == 257 && paramInputDevice.getKeyboardType() == 2); }
  
  private void analysisInputDevice(KeyEvent paramKeyEvent) {
    InputDevice inputDevice = paramKeyEvent.getDevice();
    if (inputDevice != null) {
      boolean bool;
      if (Build.VERSION.SDK_INT >= 16)
        dAM = inputDevice.isVirtual(); 
      if (!dAM && a(inputDevice)) {
        bool = inputDevice.getName().contains("Keyboard");
      } else {
        bool = false;
      } 
      if (this.needSyncInput != bool)
        this.dAN.setLength(0); 
      this.needSyncInput = bool;
    } 
  }
  
  private void g(KeyEvent paramKeyEvent) {
    int i = paramKeyEvent.getKeyCode();
    if (i == 60 || i == 59) {
      boolean bool;
      if (paramKeyEvent.getAction() == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.bko = bool;
    } 
  }
  
  private char h(KeyEvent paramKeyEvent) {
    int i = paramKeyEvent.getKeyCode();
    byte b = 45;
    if (i >= 29 && i <= 54) {
      int j;
      if (this.bko) {
        j = 65;
      } else {
        j = 97;
      } 
      return (char)(j + i - 29);
    } 
    if (i >= 144 && i <= 153)
      return (char)(i + 48 - 144); 
    if (i >= 7 && i <= 16) {
      if (!this.bko)
        return (char)(i + 48 - 7); 
      switch (i) {
        default:
          return Character.MIN_VALUE;
        case 15:
          return '*';
        case 14:
          return '&';
        case 13:
          return '^';
        case 12:
          return '%';
        case 11:
          return '$';
        case 10:
          return '#';
        case 9:
          return '@';
        case 8:
          return '!';
        case 7:
        case 16:
          break;
      } 
    } 
    char c = b;
    switch (i) {
      default:
      
      case 163:
        return ')';
      case 162:
        return '(';
      case 157:
        return '+';
      case 76:
        return this.bko ? '?' : '/';
      case 74:
        return this.bko ? ':' : ';';
      case 73:
        return this.bko ? '|' : '\\';
      case 70:
        if (!this.bko)
          return '='; 
      case 69:
        c = b;
        if (this.bko)
          return '_'; 
        break;
      case 56:
        return this.bko ? '>' : '.';
      case 55:
        if (this.bko)
          return '<'; 
        c = ',';
        break;
      case 156:
        break;
    } 
    return c;
  }
  
  private void hh(boolean paramBoolean) {
    String str1 = this.dAN.toString();
    if (this.dAO != null) {
      this.dAO.onFocusable(true);
      this.dAO.onScanSuccess(str1, paramBoolean);
    } 
    long l1 = this.dAP;
    long l2 = this.aRA;
    String str2 = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("barcode");
    stringBuilder.append(str1);
    stringBuilder.append(":time: ");
    stringBuilder.append(l1 - l2);
    Log.e(str2, stringBuilder.toString());
    this.n = 0;
    if (!paramBoolean)
      this.dAN.setLength(0); 
  }
  
  public void f(KeyEvent paramKeyEvent) {
    if (this.n == 0)
      this.aRA = System.currentTimeMillis(); 
    analysisInputDevice(paramKeyEvent);
    int i = paramKeyEvent.getKeyCode();
    g(paramKeyEvent);
    if (paramKeyEvent.getAction() == 0) {
      if (this.dAO != null && this.n == 0)
        this.dAO.onFocusable(false); 
      char c = h(paramKeyEvent);
      if (c != '\000') {
        this.dAN.append(c);
        this.n++;
      } 
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("dispatchKeyEvent: ");
      stringBuilder.append(KeyEvent.keyCodeToString(i));
      Log.e(str, stringBuilder.toString());
      if (n.lt(i) || this.needSyncInput || i == 113) {
        this.dAP = System.currentTimeMillis();
        hh(this.needSyncInput);
      } 
      if (n.isKeycodeDelete(i) && this.dAO != null) {
        this.dAO.onDelete();
        this.dAN.setLength(0);
      } 
    } 
  }
  
  public void hi(boolean paramBoolean) {
    if (paramBoolean)
      this.dAN.setLength(0); 
  }
  
  public static interface a {
    void onDelete();
    
    void onFocusable(boolean param1Boolean);
    
    void onScanSuccess(String param1String, boolean param1Boolean);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\edittext\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */