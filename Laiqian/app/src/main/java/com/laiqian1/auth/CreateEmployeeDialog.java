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
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.member.bz;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.d;
import com.laiqian.util.bd;

public class CreateEmployeeDialog extends d {
  private EditText aDG;
  
  private EditText aDH;
  
  private View aDI;
  
  private View aDJ;
  
  private TextView aDK;
  
  Handler aDL = null;
  
  private boolean aDM;
  
  UsbCardReceiver aDN;
  
  int aDO = Build.VERSION.SDK_INT;
  
  bz aDP;
  
  Handler aDQ = new s(this);
  
  private boolean aDR = false;
  
  TextWatcher aDS = new y(this);
  
  private Context mContext;
  
  private bb mWaitingDialog = null;
  
  public CreateEmployeeDialog(Context paramContext) {
    super(paramContext, 2131427860);
    this.mContext = paramContext;
    xT();
    xU();
  }
  
  private boolean checkNetwork() {
    boolean bool = bd.bH(this.mContext);
    if (!bool)
      Toast.makeText(this.mContext, this.mContext.getString(2131628423), 0).show(); 
    return bool;
  }
  
  private bb xS() {
    if (this.mWaitingDialog == null)
      this.mWaitingDialog = new bb(this.mContext); 
    return this.mWaitingDialog;
  }
  
  private void xT() {
    this.aDG = (EditText)this.mView.findViewById(2131296982);
    this.aDH = (EditText)this.mView.findViewById(2131296981);
    this.aDK = (TextView)this.mView.findViewById(2131299317);
    this.tvTitle = (TextView)this.mView.findViewById(2131299446);
    this.aDI = this.mView.findViewById(2131299105);
    this.aDJ = this.mView.findViewById(2131296671);
  }
  
  private void xU() {
    this.aDG.addTextChangedListener(this.aDS);
    this.aDH.addTextChangedListener(this.aDS);
    this.aDH.setOnFocusChangeListener(new u(this));
    this.aDJ.setOnClickListener(new v(this));
    this.aDI.setOnClickListener(new w(this));
  }
  
  private void xV() {
    if (this.aDN == null) {
      this.aDN = new UsbCardReceiver(this);
      if (!this.aDR) {
        this.aDR = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        intentFilter.addAction("com.laiqian.USB_PERMISSION");
        this.mContext.registerReceiver(this.aDN, intentFilter);
      } 
    } 
  }
  
  private boolean xW() {
    TextView textView1 = this.mActivity.getString(2131627259);
    TextView textView2 = this.aDG.getText().toString().trim();
    if (TextUtils.isEmpty(textView2)) {
      this.aDG.requestFocus();
      textView2 = this.aDK;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.mActivity.getString(2131626612));
      stringBuilder.append(textView1);
      textView2.setText(stringBuilder.toString());
      return false;
    } 
    int i = Integer.parseInt(this.mContext.getString(2131626253));
    if (textView2.length() < i) {
      this.aDG.requestFocus();
      this.aDG.setSelection(textView2.length());
      textView1 = this.aDK;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.mActivity.getString(2131626613));
      stringBuilder.append(i);
      textView1.setText(stringBuilder.toString());
      return false;
    } 
    if (TextUtils.isEmpty(this.aDH.getText().toString().trim())) {
      this.aDH.requestFocus();
      textView2 = this.aDK;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.mActivity.getString(2131626610));
      stringBuilder.append(textView1);
      textView2.setText(stringBuilder.toString());
      return false;
    } 
    return true;
  }
  
  public void a(Handler paramHandler) { this.aDL = paramHandler; }
  
  protected void onStart() {
    boolean bool;
    super.onStart();
    this.aDG.setText("");
    this.aDH.setText("");
    this.aDK.setText("");
    this.aDG.requestFocus();
    if (this.aDO < 12) {
      bool = true;
    } else {
      bool = false;
    } 
    this.aDM = bool;
    if (!this.aDM)
      xV(); 
    this.aDQ = new t(this);
  }
  
  protected void onStop() {
    if (!this.aDM && this.aDN != null)
      try {
        if (this.aDR) {
          this.aDR = false;
          this.mContext.unregisterReceiver(this.aDN);
        } 
        this.aDN = null;
      } catch (Exception exception) {
        a.e(exception);
      }  
    if (this.aDP != null)
      this.aDP.stop(); 
    if (this.aDQ != null)
      this.aDQ = null; 
  }
  
  public class UsbCardReceiver extends BroadcastReceiver {
    public UsbCardReceiver(CreateEmployeeDialog this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      String str = param1Intent.getAction();
      if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(str)) {
        bz bz;
        if ((bz = this.aDT.aDP).aE(CreateEmployeeDialog.b(this.aDT)))
          if (CreateEmployeeDialog.a(this.aDT).hasFocus()) {
            this.aDT.aDP = bz.Qw();
            this.aDT.aDP.a(CreateEmployeeDialog.b(this.aDT), 500L, this.aDT.aDQ);
            this.aDT.aDP.start();
          } else if (this.aDT.aDP != null) {
            this.aDT.aDP.stop();
          }  
      } 
      if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(str)) {
        bz bz;
        if ((!(bz = this.aDT.aDP).aE(CreateEmployeeDialog.b(this.aDT)) || !CreateEmployeeDialog.a(this.aDT).hasFocus()) && this.aDT.aDP != null)
          this.aDT.aDP.stop(); 
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\CreateEmployeeDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */