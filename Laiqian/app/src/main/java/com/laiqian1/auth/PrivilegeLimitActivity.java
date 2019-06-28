package com.laiqian.auth;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.i.d;
import com.laiqian.models.at;
import com.laiqian.sync.a.g;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ImageCheckBox;
import com.laiqian.ui.a.aq;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.r;
import com.laiqian.util.bd;
import com.laiqian.util.by;
import io.reactivex.g.a;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PrivilegeLimitActivity extends ActivityRoot {
  private View aEf;
  
  private View aEg;
  
  private View aEh;
  
  private View aEi;
  
  private au aEj;
  
  private au aEk;
  
  aq aEl = null;
  
  private bb mWaitingDialog = null;
  
  private String nUserID;
  
  private g syncManager;
  
  Handler uploadHandler = new ah(this);
  
  private String a(double paramDouble, short paramShort) {
    DecimalFormat decimalFormat2;
    String str2;
    DecimalFormat decimalFormat3;
    String str3;
    switch (paramShort) {
      default:
        return "";
      case 0:
      case 1:
        break;
    } 
    switch (CrashApplication.aIQ) {
      default:
        str3 = "0";
        decimalFormat3 = new DecimalFormat(str3);
        decimalFormat3.setRoundingMode(RoundingMode.DOWN);
        return decimalFormat3.format(paramDouble);
      case 2:
        str2 = "0.00";
        decimalFormat2 = new DecimalFormat(str2);
        decimalFormat2.setRoundingMode(RoundingMode.DOWN);
        return decimalFormat2.format(paramDouble);
      case 1:
        break;
    } 
    String str1 = "0.0";
    DecimalFormat decimalFormat1 = new DecimalFormat(str1);
    decimalFormat1.setRoundingMode(RoundingMode.DOWN);
    return decimalFormat1.format(paramDouble);
  }
  
  private void a(short paramShort) {
    Button button = (Button)this.aEg.findViewById(2131299826);
    button.setText(b(paramShort));
    button.setOnClickListener(new at(this));
  }
  
  private void a(short paramShort, double paramDouble) {
    TextView textView = (TextView)this.aEh.findViewById(2131299215);
    EditText editText = (EditText)this.aEh.findViewById(2131296928);
    View view = this.aEh.findViewById(2131298400);
    switch (paramShort) {
      case 1:
        textView.setText(getString(2131627450));
        editText.setText(a(paramDouble, paramShort));
        view.setVisibility(0);
        break;
      case 0:
        textView.setText(getString(2131627451));
        editText.setText(a(paramDouble, paramShort));
        view.setVisibility(8);
        break;
    } 
    editText.addTextChangedListener(new ai(this, editText));
  }
  
  private String b(short paramShort) {
    switch (paramShort) {
      default:
        return "";
      case 1:
        return getString(2131627448);
      case 0:
        break;
    } 
    return getString(2131627449);
  }
  
  private boolean bI(View paramView) throws ClassCastException { return ((ImageCheckBox)paramView.findViewById(2131296763)).isChecked(); }
  
  private void bs(String paramString) {
    if (this.mWaitingDialog == null)
      this.mWaitingDialog = new bb(this); 
    this.mWaitingDialog.setCancelable(false);
    this.mWaitingDialog.show();
  }
  
  private void initData() {
    this.nUserID = getIntent().getStringExtra("staff_user_id");
    at at = new at(this);
    str = at.iq(this.nUserID);
    try {
      this.aEj = (au)d.b(str, au.class);
    } catch (IOException str) {
      a.e(str);
    } 
    if (this.aEj == null) {
      this.aEj = new au(false, true, false, 0.0D);
      at.ao(this.nUserID, d.ac(this.aEj));
    } 
    at.close();
    this.aEk = new au(this.aEj.aEq, this.aEj.aEr, this.aEj.aEs, this.aEj.aEt);
    this.syncManager = new g(this);
    this.syncManager.a(new aj(this));
  }
  
  private void initView() {
    ((TextView)findViewById(2131299889)).setText(2131625598);
    findViewById(2131299878).setOnClickListener(new an(this));
    null = (Button)findViewById(2131299879);
    null.setText(2131624290);
    null.setOnClickListener(new ao(this));
    this.aEf = findViewById(2131297208);
    this.aEg = findViewById(2131297744);
    this.aEh = findViewById(2131297743);
    this.aEi = findViewById(2131297289);
    imageCheckBox = (ImageCheckBox)this.aEf.findViewById(2131296763);
    imageCheckBox.a(new ap(this));
    imageCheckBox.setChecked(this.aEj.aEq);
    if (this.aEj.aEq) {
      this.aEg.setVisibility(0);
      this.aEh.setVisibility(0);
      xX();
    } else {
      this.aEg.setVisibility(8);
      this.aEh.setVisibility(8);
    } 
    try {
      a(this.aEj.aEs);
      a(this.aEj.aEs, this.aEj.aEt);
    } catch (Exception imageCheckBox) {
      a.e(imageCheckBox);
    } 
    ((ImageCheckBox)this.aEi.findViewById(2131296763)).setChecked(this.aEj.aEr);
    if (getLaiqianPreferenceManager().isMultipleShop()) {
      findViewById(2131298123).setVisibility(8);
      findViewById(2131298124).setVisibility(8);
    } 
    this.aEl = new av(this, new aq(this), yb());
  }
  
  private void promptBeforeQuit() {
    if (ya()) {
      xZ();
      return;
    } 
    finish();
  }
  
  private void save() {
    if (this.syncManager.apy().apG()) {
      Toast.makeText(this, getString(2131629568), 0).show();
      return;
    } 
    if (!bd.bH(this)) {
      Toast.makeText(this, getString(2131628423), 0).show();
      return;
    } 
    try {
      String str = d.ac(new au(bI(this.aEf), bI(this.aEi), yb(), yc()));
      at at = new at(this);
      boolean bool = at.an(this.nUserID, str);
      at.close();
      if (bool) {
        xY();
        return;
      } 
    } catch (Exception exception) {
      a.e(exception);
    } 
  }
  
  private void xX() {
    try {
      ((Button)this.aEg.findViewById(2131299826)).setText(b(this.aEj.aEs));
      ((EditText)this.aEh.findViewById(2131296928)).setText(a(this.aEj.aEt, this.aEj.aEs));
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  private void xY() {
    bs(getString(2131628425));
    ar ar = new ar(this);
    a.aKh().r(ar);
  }
  
  private void xZ() {
    r r = new r(this, 2, new as(this));
    r.setTitle(getString(2131628165));
    r.oZ(getString(2131628162));
    r.t(getString(2131628163));
    r.arm().setTextColor(getResources().getColor(2131099813));
    r.arn().setTextColor(getResources().getColor(2131099898));
    r.s(getString(2131628164));
    r.show();
  }
  
  private boolean ya() {
    try {
      boolean bool1 = bI(this.aEi);
      boolean bool2 = bI(this.aEf);
      short s = yb();
      double d = yc();
      if (this.aEj.aEq == bool2 && this.aEj.aEr == bool1 && this.aEj.aEs == s) {
        double d1 = this.aEj.aEt;
        if (d1 != d)
          return true; 
      } else {
        return true;
      } 
    } catch (Exception exception) {
      a.e(exception);
    } 
    return false;
  }
  
  private short yb() {
    String str = ((Button)this.aEg.findViewById(2131299826)).getText().toString();
    return str.equals(getString(2131627449)) ? 0 : (str.equals(getString(2131627448)) ? 1 : -1);
  }
  
  private double yc() {
    String str = ((EditText)this.aEh.findViewById(2131296928)).getText().toString();
    if (by.isNull(str)) {
      Toast.makeText(this, "不能为空", 0).show();
      throw new IllegalArgumentException("输入不能为空");
    } 
    switch (yb()) {
      default:
        return 0.0D;
      case 1:
        str.substring(0, str.length());
        return Double.parseDouble(str);
      case 0:
        break;
    } 
    return Double.parseDouble(str);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131428175);
    getWindow().setFeatureInt(7, 2131428168);
    getWindow().setSoftInputMode(32);
    initData();
    initView();
  }
  
  public void onDestroy() {
    if (this.syncManager != null) {
      this.syncManager.close();
      this.syncManager = null;
    } 
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getRepeatCount() > 0)
      return false; 
    if (paramInt == 4 && paramKeyEvent.getRepeatCount() == 0) {
      promptBeforeQuit();
      return false;
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\PrivilegeLimitActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */