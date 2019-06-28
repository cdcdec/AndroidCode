package com.laiqian.member.create;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class m implements View.OnClickListener {
  m(VipCreateDialog paramVipCreateDialog) {}
  
  public void onClick(View paramView) {
    if (VipCreateDialog.D(this.bxz).isChecked()) {
      String str1 = VipCreateDialog.E(this.bxz).getText().toString().trim();
      String str2 = VipCreateDialog.F(this.bxz).getText().toString().trim();
      if (TextUtils.isEmpty(str1)) {
        VipCreateDialog.E(this.bxz).requestFocus();
        n.eP(R.string.please_enter_a_six_digi_number);
        return;
      } 
      if (TextUtils.isEmpty(str2)) {
        VipCreateDialog.F(this.bxz).requestFocus();
        n.eP(R.string.please_enter_a_six_digi_number);
        return;
      } 
      if (str2.length() != 6) {
        VipCreateDialog.F(this.bxz).requestFocus();
        n.eP(R.string.please_enter_a_six_digi_number);
        return;
      } 
      if (str1.length() != 6) {
        VipCreateDialog.E(this.bxz).requestFocus();
        n.eP(R.string.please_enter_a_six_digi_number);
        return;
      } 
      if (!str1.equals(str2)) {
        VipCreateDialog.E(this.bxz).setText("");
        VipCreateDialog.F(this.bxz).requestFocus();
        n.eP(R.string.passwords_do_not_match);
        return;
      } 
    } 
    if (TextUtils.isEmpty(this.bxz.bxa.getText().toString().trim())) {
      n.o(VipCreateDialog.G(this.bxz).getString(R.string.pos_member_number_can_not_be_empty));
      this.bxz.bxa.requestFocus();
      return;
    } 
    if (TextUtils.isEmpty(this.bxz.bwZ.getText().toString().trim())) {
      n.eP(R.string.pos_member_mobile_can_not_be_empty);
      this.bxz.bwZ.requestFocus();
      return;
    } 
    String str = this.bxz.bwv.getText().toString().trim();
    if (TextUtils.isEmpty(str)) {
      n.eP(R.string.pos_member_charge_amount_can_not_be_empty);
      this.bxz.bwv.requestFocus();
      return;
    } 
    if (n.u(str) > 1.0E8D) {
      n.eP(R.string.pos_alipay_AMOUNT_IS_OUT_RANG);
      this.bxz.bwv.requestFocus();
      return;
    } 
    if (n.u(this.bxz.bww.getText().toString()) > 1.0E8D) {
      n.eP(R.string.pos_alipay_AMOUNT_IS_OUT_RANG);
      this.bxz.bww.requestFocus();
      return;
    } 
    if (this.bxz.bxb.getText().toString().trim().contains("'")) {
      n.w(VipCreateDialog.H(this.bxz), R.string.pos_product_name_error);
      this.bxz.bxb.requestFocus();
      return;
    } 
    if (this.bxz.bwG.bys == null) {
      n.o("未知错误，没有选中支付类型");
      return;
    } 
    if (RootApplication.getLaiqianPreferenceManager().Wq() && !bd.bH(this.bxz.getContext())) {
      Toast.makeText(this.bxz.getContext(), R.string.please_check_network, 0).show();
      return;
    } 
    (new VipCreateDialog.a(this.bxz)).execute(new String[] { this.bxz.bxa.getText().toString(), this.bxz.bwZ.getText().toString() });
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */