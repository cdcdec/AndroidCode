package com.laiqian.charge;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChargePackageSelector extends Activity {
  private JSONArray aKA = null;
  
  private String aKB = null;
  
  View.OnClickListener aKx = new c(this);
  
  private LinearLayout aKz = null;
  
  View.OnClickListener azO = new d(this);
  
  private void a(JSONArray paramJSONArray) {
    int i = paramJSONArray.length();
    if (i <= 0)
      return; 
    LinearLayout linearLayout = (LinearLayout)findViewById(2131297801);
    byte b = 0;
    while (b < i) {
      LinearLayout linearLayout1;
      null = null;
      if (i == 1) {
        linearLayout1 = (LinearLayout)LayoutInflater.from(this).inflate(2131427748, null);
      } else {
        linearLayout1 = null;
        if (i > 1)
          if (!b) {
            linearLayout1 = (LinearLayout)LayoutInflater.from(this).inflate(2131427749, null);
          } else {
            int j = i - 1;
            if (b < j) {
              linearLayout1 = (LinearLayout)LayoutInflater.from(this).inflate(2131427747, null);
            } else {
              linearLayout1 = null;
              if (b == j)
                linearLayout1 = (LinearLayout)LayoutInflater.from(this).inflate(2131427746, null); 
            } 
          }  
      } 
      TextView textView = (TextView)linearLayout1.findViewById(2131299329);
      try {
        JSONObject jSONObject = paramJSONArray.getJSONObject(b);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(jSONObject.getString("sTemplateName"));
        stringBuilder.append(jSONObject.getString("fPrice"));
        stringBuilder.append("元");
        textView.setText(stringBuilder.toString());
        linearLayout.addView(linearLayout1);
        linearLayout1.setTag(jSONObject);
        linearLayout1.setOnClickListener(this.aKx);
        b++;
      } catch (JSONException paramJSONArray) {
        a.e(paramJSONArray);
        Toast.makeText(this, "服务器返回的数据有误，请联系400-998-1300咨询。\n\n错误信息为：服务器返回的套餐信息格式不对，请检查是否客户端软件的请求信息。\n\n错误位置：ChargePackageSelector_4", 1).show();
        finish();
        return;
      } 
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427496);
    getWindow().setFeatureInt(7, 2131428168);
    this.aKz = (LinearLayout)findViewById(2131297801);
    this.aKB = getIntent().getStringExtra("package_json");
    try {
      this.aKA = new JSONArray(this.aKB);
      a(this.aKA);
      findViewById(2131299878).setOnClickListener(this.azO);
      return;
    } catch (JSONException paramBundle) {
      this.aKA = null;
      a.e(paramBundle);
      Toast.makeText(this, "服务器返回的数据有误，请联系400-998-1300咨询。\n\n错误信息为：服务器返回的套餐信息格式不对，请检查是否客户端软件的请求信息。\n\n错误位置：ChargePackageSelector_1", 1).show();
      finish();
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\charge\ChargePackageSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */