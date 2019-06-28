package com.laiqian.report.onlinepay;

import android.os.Bundle;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.models.bd;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.by;
import com.laiqian.util.z;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OnlinePayReportDetailActivity extends ActivityRoot {
  private TextView brY;
  
  private void a(int paramInt, String paramString, boolean paramBoolean) {
    int i = 0;
    if (paramInt != -4) {
      TextView textView;
      switch (paramInt) {
        default:
          textView = this.brY;
          if (paramBoolean) {
            paramInt = i;
          } else {
            paramInt = 8;
          } 
          textView.setVisibility(paramInt);
          if (paramBoolean) {
            this.brY.setText(paramString);
            return;
          } 
          return;
        case -1:
        case 0:
          break;
      } 
    } 
    this.brY.setText(paramString);
    this.brY.setVisibility(0);
  }
  
  private void wR() {
    ((TextView)findViewById(2131299889)).setText(2131629288);
    findViewById(2131299879).setVisibility(8);
    this.brY = (TextView)findViewById(2131299419);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427398);
    getWindow().setFeatureInt(7, 2131428168);
    wR();
  }
  
  protected void onResume() {
    super.onResume();
    Bundle bundle = getIntent().getExtras();
    JSONArray jSONArray = bundle.getString("sOrderNo");
    String str3 = bundle.getString("sPayType");
    StringBuilder stringBuilder1 = bundle.getString("sStatusText");
    int i = bundle.getInt("nStatus");
    long l = bundle.getLong("nDateTime");
    String str4 = bundle.getString("fAmount");
    String str2 = bundle.getString("sUserName");
    String str1 = bundle.getString("showType");
    ((TextView)findViewById(2131299296)).setText(str4);
    ((TextView)findViewById(2131299369)).setText(jSONArray);
    ((TextView)findViewById(2131299373)).setText(str3);
    TextView textView = (TextView)findViewById(2131299312);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(l);
    stringBuilder2.append("");
    textView.setText(z.e(stringBuilder2.toString(), this));
    ((TextView)findViewById(2131299366)).setText(str2);
    bd bd = new bd(this);
    jSONArray = bd.a(jSONArray, l - 86400000L, l + 86400000L, str1);
    bd.close();
    boolean bool = "1".equals(str1);
    if (bool) {
      int j;
      simpleDateFormat = new SimpleDateFormat(getString(2131628263));
      if (!by.isNull(jSONArray)) {
        stringBuilder1 = new StringBuilder();
        j = 0;
        jSONArray = String.format("[%s]", new Object[] { jSONArray });
        try {
          jSONArray = new JSONArray(jSONArray);
          while (j < jSONArray.length()) {
            JSONObject jSONObject = jSONArray.getJSONObject(j);
            stringBuilder1.append(simpleDateFormat.format(new Date(by.parseLong(jSONObject.getString("time")))));
            stringBuilder1.append(" ");
            stringBuilder1.append(jSONObject.getString("info"));
            stringBuilder1.append("\n");
            j++;
          } 
        } catch (JSONException simpleDateFormat) {
          a.e(simpleDateFormat);
        } 
        ((TextView)findViewById(2131299431)).setText(stringBuilder1.toString());
      } 
      if (bundle.getBoolean("isReceive")) {
        j = 2131629261;
      } else {
        j = 2131625073;
      } 
      String str = getString(j);
      a(i, str, bool);
      return;
    } 
    ((TextView)findViewById(2131299431)).setText(stringBuilder1);
    a(i, jSONArray, bool);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\onlinepay\OnlinePayReportDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */