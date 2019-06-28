package com.laiqian.charge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import org.json.JSONException;
import org.json.JSONObject;

class c implements View.OnClickListener {
  c(ChargePackageSelector paramChargePackageSelector) {}
  
  public void onClick(View paramView) {
    jSONObject = (JSONObject)paramView.getTag();
    if (jSONObject == null) {
      Toast.makeText(this.aKC, "服务器返回的数据有误，请联系400-998-1300咨询。\n\n错误信息为：服务器返回的套餐信息格式不对，请检查是否客户端软件的请求信息。\n\n错误位置：ChargePackageSelector_2", 1).show();
      return;
    } 
    SharedPreferences.Editor editor = this.aKC.getSharedPreferences("settings", 0).edit();
    editor.putString("charge_package_server_return_string", ChargePackageSelector.a(this.aKC));
    try {
      editor.putString("charge_package_id", jSONObject.getString("nUserTemplateID"));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(jSONObject.getString("sTemplateName"));
      stringBuilder.append(jSONObject.getString("fPrice"));
      editor.putString("laiqian_charge_package_string", stringBuilder.toString());
      editor.putInt("laiqian_cny_amount", jSONObject.getInt("fPrice"));
      editor.putInt("laiqian_type_flag", jSONObject.getInt("type_flag"));
      editor.putLong("laiqian_channel_template_id", jSONObject.getLong("_id"));
      editor.putLong("laiqian_channel_id", jSONObject.getLong("nChannelID"));
    } catch (JSONException jSONObject) {
      Toast.makeText(this.aKC, "服务器返回的数据有误，请联系400-998-1300咨询。\n\n错误信息为：服务器返回的套餐信息格式不对，请检查是否客户端软件的请求信息。\n\n错误位置：ChargePackageSelector_3", 1).show();
      a.e(jSONObject);
      this.aKC.finish();
    } 
    editor.commit();
    Intent intent = new Intent();
    this.aKC.setResult(-1, intent);
    this.aKC.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\charge\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */