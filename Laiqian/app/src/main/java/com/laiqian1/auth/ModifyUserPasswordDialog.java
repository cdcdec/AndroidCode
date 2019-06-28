package com.laiqian.auth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.f.c;
import com.laiqian.member.bz;
import com.laiqian.ui.a.d;
import com.laiqian.util.av;
import com.laiqian.util.n;
import java.security.NoSuchAlgorithmException;

public class ModifyUserPasswordDialog extends d {
  private View aDI;
  
  private View aDJ;
  
  private TextView aDK;
  
  private boolean aDM;
  
  int aDO = Build.VERSION.SDK_INT;
  
  bz aDP;
  
  Handler aDQ = new z(this);
  
  private boolean aDR = false;
  
  TextWatcher aDS = new ag(this);
  
  private EditText aDW;
  
  private EditText aDX;
  
  private EditText aDY;
  
  private String aDZ;
  
  private boolean aEa = true;
  
  private LinearLayout aEb;
  
  UsbCardReceiver aEc;
  
  private bn aEd;
  
  private Context mContext;
  
  private String sUserPassword;
  
  public ModifyUserPasswordDialog(Context paramContext) {
    super(paramContext, 2131428058);
    this.mContext = paramContext;
    xT();
    xU();
  }
  
  private void xT() {
    this.aDW = (EditText)this.mView.findViewById(2131296954);
    this.aDX = (EditText)this.mView.findViewById(2131296953);
    this.aEb = (LinearLayout)this.mView.findViewById(2131297464);
    this.aDY = (EditText)this.mView.findViewById(2131296979);
    this.aDK = (TextView)this.mView.findViewById(2131299317);
    this.tvTitle = (TextView)this.mView.findViewById(2131299446);
    this.aDI = this.mView.findViewById(2131299105);
    this.aDJ = this.mView.findViewById(2131296671);
  }
  
  private void xU() {
    this.aDW.addTextChangedListener(this.aDS);
    this.aDX.addTextChangedListener(this.aDS);
    this.aDY.addTextChangedListener(this.aDS);
    this.aDJ.setOnClickListener(new ab(this));
    this.aDW.setOnFocusChangeListener(new ac(this));
    this.aDX.setOnFocusChangeListener(new ad(this));
    this.aDY.setOnFocusChangeListener(new ae(this));
    this.aDI.setOnClickListener(new af(this));
  }
  
  private void xV() {
    if (this.aEc == null) {
      this.aEc = new UsbCardReceiver(this);
      if (!this.aDR) {
        this.aDR = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        intentFilter.addAction("com.laiqian.USB_PERMISSION");
        this.mContext.registerReceiver(this.aEc, intentFilter);
      } 
    } 
  }
  
  private boolean xW() {
    String str1 = this.mActivity.getString(2131627259);
    textView = this.aDW.getText().toString().trim();
    if (TextUtils.isEmpty(textView) && this.aEa) {
      this.aDW.requestFocus();
      TextView textView1 = this.aDK;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.mActivity.getString(2131628421));
      stringBuilder1.append(str1);
      textView1.setText(stringBuilder1.toString());
      return false;
    } 
    StringBuilder stringBuilder = this.aDX.getText().toString().trim();
    if (TextUtils.isEmpty(stringBuilder)) {
      this.aDX.requestFocus();
      TextView textView1 = this.aDK;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.mActivity.getString(2131628420));
      stringBuilder1.append(str1);
      textView1.setText(stringBuilder1.toString());
      return false;
    } 
    String str2 = this.aDY.getText().toString().trim();
    if (TextUtils.isEmpty(str2)) {
      this.aDY.requestFocus();
      textView = this.aDK;
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.mActivity.getString(2131628426));
      stringBuilder.append(str1);
      textView.setText(stringBuilder.toString());
      return false;
    } 
    str1 = "";
    try {
      String str = c.cI(textView);
      str1 = str;
    } catch (NoSuchAlgorithmException textView) {
      a.e(textView);
    } 
    if (!str1.equals(this.sUserPassword) && this.aEa) {
      n.j(this.aDW);
      this.aDK.setText(this.mActivity.getString(2131628416));
      return false;
    } 
    if (!stringBuilder.equals(str2)) {
      this.aDY.setText("");
      n.j(this.aDX);
      this.aDK.setText(this.mActivity.getString(2131628415));
      return false;
    } 
    return true;
  }
  
  public void a(bn parambn) { this.aEd = parambn; }
  
  protected void onStart() {
    super.onStart();
    this.aDW.setText("");
    this.aDX.setText("");
    this.aDY.setText("");
    this.aDK.setText("");
    av av = new av(this.mActivity);
    String str1 = av.atp();
    String str2 = av.atm();
    av.close();
    boolean bool1 = "150001".equals(str1);
    boolean bool = false;
    if (bool1 && !str2.equals(this.aDZ))
      this.aEa = false; 
    if (this.aEa) {
      this.aEb.setVisibility(0);
      this.aDW.requestFocus();
    } else {
      this.aEb.setVisibility(8);
      this.aDX.requestFocus();
    } 
    if (this.aDO < 12)
      bool = true; 
    this.aDM = bool;
    if (!this.aDM)
      xV(); 
    this.aDQ = new aa(this);
  }
  
  protected void onStop() {
    if (!this.aDM && this.aEc != null)
      try {
        if (this.aDR) {
          this.aDR = false;
          this.mContext.unregisterReceiver(this.aEc);
        } 
        this.aEc = null;
      } catch (Exception exception) {
        a.e(exception);
      }  
    if (this.aDP != null)
      this.aDP.stop(); 
    if (this.aDQ != null)
      this.aDQ = null; 
  }
  
  public void w(String paramString1, String paramString2) {
    this.aDZ = paramString1;
    this.sUserPassword = paramString2;
  }
  
  public class UsbCardReceiver extends BroadcastReceiver {
    public UsbCardReceiver(ModifyUserPasswordDialog this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      String str = param1Intent.getAction();
      if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(str)) {
        bz bz;
        if ((bz = this.aEe.aDP).aE(ModifyUserPasswordDialog.d(this.aEe)))
          if (ModifyUserPasswordDialog.a(this.aEe).hasFocus() || ModifyUserPasswordDialog.b(this.aEe).hasFocus() || ModifyUserPasswordDialog.c(this.aEe).hasFocus()) {
            this.aEe.aDP = bz.Qw();
            this.aEe.aDP.a(ModifyUserPasswordDialog.d(this.aEe), 500L, this.aEe.aDQ);
            this.aEe.aDP.start();
          } else if (this.aEe.aDP != null) {
            this.aEe.aDP.stop();
          }  
      } 
      if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(str)) {
        bz bz;
        if ((!(bz = this.aEe.aDP).aE(ModifyUserPasswordDialog.d(this.aEe)) || !ModifyUserPasswordDialog.a(this.aEe).hasFocus() || ModifyUserPasswordDialog.b(this.aEe).hasFocus() || ModifyUserPasswordDialog.c(this.aEe).hasFocus()) && this.aEe.aDP != null)
          this.aEe.aDP.stop(); 
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\ModifyUserPasswordDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */