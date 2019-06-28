package com.laiqian.setting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.laiqian.d.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.util.ar;
import com.laiqian.util.m;
import com.laiqian.util.n;

public class DiscountSettingActivity extends ActivityRoot {
  private View djV;
  
  private r djW;
  
  private double djX;
  
  private double djY;
  
  private EditText etDiscount;
  
  private boolean isDiscountConvertion;
  
  private boolean Rq() {
    if (TextUtils.isEmpty(this.etDiscount.getText().toString().trim())) {
      Toast.makeText(this, 2131624971, 0).show();
      return false;
    } 
    if (this.isDiscountConvertion ? (this.djY <= 0.0D || this.djY > 100.0D) : (this.djY <= 0.0D || this.djY > 300.0D)) {
      int i;
      if (this.isDiscountConvertion) {
        i = 2131627466;
      } else {
        i = 2131624970;
      } 
      Toast.makeText(this, i, 0).show();
      return false;
    } 
    return true;
  }
  
  private void save() {
    if (Rq()) {
      a.AZ().d(this.djY);
      Toast.makeText(this, 2131628160, 0).show();
      finish();
    } 
  }
  
  public boolean beforeCloseActivity() {
    if (this.djX != this.djY) {
      if (this.djW == null) {
        this.djW = new r(this, new l(this));
        this.djW.setTitle(getString(2131627735));
        this.djW.s(getString(2131627733));
        this.djW.t(getString(2131627734));
        this.djW.oZ(getString(2131627732));
      } 
      this.djW.show();
      return true;
    } 
    return false;
  }
  
  protected void onCreate(Bundle paramBundle) {
    double d;
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427419);
    setTitleTextView(2131627502);
    setTitleTextViewRight(2131629495, new j(this));
    findViewById(2131296857).setBackgroundResource(2130772057);
    this.isDiscountConvertion = getResources().getBoolean(2131034121);
    this.etDiscount = (EditText)findViewById(2131297307);
    this.etDiscount.setInputType(8194);
    this.etDiscount.setFilters(ar.bE(3, a.AZ().Be()));
    this.etDiscount.addTextChangedListener(new k(this));
    this.djX = a.AZ().Bn();
    EditText editText = this.etDiscount;
    if (this.isDiscountConvertion) {
      d = 100.0D - this.djX;
    } else {
      d = this.djX;
    } 
    editText.setText(n.ba(d));
    this.djV = findViewById(2131298379);
    this.djV.setBackgroundResource(2130772051);
    this.djV.setOnClickListener(new m.c(getActivity(), com.laiqian.product.ProductTypeDiscount.class));
    this.djV.setFocusable(true);
    this.djV.setFocusableInTouchMode(true);
    this.djV.requestFocus();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\DiscountSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */