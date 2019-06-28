package com.laiqian.product;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.d.a;
import com.laiqian.product.models.o;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.g;
import com.laiqian.ui.a.r;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.f;
import com.laiqian.ui.layout.CheckBoxLayoutInMainSetting;
import com.laiqian.ui.s;
import com.laiqian.util.ar;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.util.ArrayList;

public class ServiceChargeActivity extends ActivityRoot {
  View.OnClickListener cSF = new ev(this);
  
  a cTE;
  
  private String cwA = "";
  
  private StringBuilder cwB;
  
  private g cwy;
  
  private ArrayList<o> cwz;
  
  aa titleBar;
  
  private void ZQ() {
    this.titleBar.tvTitle.setText(getString(2131627603));
    this.titleBar.brj.setText(getString(2131629495));
    this.titleBar.brk.setVisibility(8);
    ((TextView)this.cTE.cTG.cAO.getView()).setText(getString(2131627472));
    ((TextView)this.cTE.cTG.cAT.getView()).setTextColor(getResources().getColor(2131099938));
    ((TextView)this.cTE.cTG.cAT.getView()).setText("%");
    ((EditText)this.cTE.cTG.dwQ.getView()).setInputType(8194);
    ((EditText)this.cTE.cTG.dwQ.getView()).setFilters(ar.bE(3, 2));
    ((ViewGroup)this.cTE.cTG.getView()).setBackgroundResource(2130772057);
    this.cTE.cTH.setFocusable(true);
    this.cTE.cTH.setFocusableInTouchMode(true);
    this.cTE.cTH.requestFocus();
    this.cTE.cTH.setBackgroundResource(2130772055);
  }
  
  private StringBuffer a(String paramString, StringBuffer paramStringBuffer) {
    if (by.isNull(paramString)) {
      this.cwA = "";
      return paramStringBuffer;
    } 
    this.cwA = paramString;
    byte b1 = 0;
    byte b2;
    for (b2 = 0; b1 < this.cwz.size(); b2 = b) {
      paramString = this.cwA;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(((o)this.cwz.get(b1)).getId());
      stringBuilder.append("");
      byte b = b2;
      if (paramString.contains(stringBuilder.toString())) {
        if (b2)
          paramStringBuffer.append(","); 
        paramStringBuffer.append(((o)this.cwz.get(b1)).akZ());
        b = b2 + true;
      } 
      b1++;
    } 
    return paramStringBuffer;
  }
  
  private void acb() {
    this.cwz = (new dq(this)).gp(true);
    this.cwA = a.AZ().BX();
  }
  
  private long[] acc() {
    byte b = 0;
    long[] arrayOfLong2 = new long[0];
    long[] arrayOfLong1 = arrayOfLong2;
    if (!by.isNull(this.cwA)) {
      String str = acd();
      arrayOfLong1 = arrayOfLong2;
      if (!by.isNull(str)) {
        String[] arrayOfString = str.split(",");
        arrayOfLong1 = new long[arrayOfString.length];
        while (b < arrayOfString.length) {
          arrayOfLong1[b] = Long.valueOf(arrayOfString[b]).longValue();
          b++;
        } 
      } 
    } 
    return arrayOfLong1;
  }
  
  private String acd() {
    this.cwB = new StringBuilder();
    String[] arrayOfString = this.cwA.split(",");
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < arrayOfString.length; b++) {
      byte b1 = 0;
      while (true) {
        if (b1 < this.cwz.size()) {
          String str = arrayOfString[b];
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(((o)this.cwz.get(b1)).getId());
          stringBuilder1.append("");
          if (str.equals(stringBuilder1.toString())) {
            b1 = 1;
            break;
          } 
          b1++;
          continue;
        } 
        b1 = 0;
        break;
      } 
      if (b1 == 0) {
        this.cwB = a(this.cwB, arrayOfString[b]);
      } else {
        stringBuilder = a(stringBuilder, arrayOfString[b]);
      } 
    } 
    return stringBuilder.toString();
  }
  
  private void aki() {
    this.titleBar.bri.setOnClickListener(new es(this));
    acb();
    if (this.cwz != null && this.cwz.size() > 0)
      this.cTE.cTI.setVisibility(0); 
    this.cwy = new g(this, this.cwz, new et(this));
    this.cTE.cTI.setOnClickListener(new eu(this));
    this.titleBar.brj.setOnClickListener(this.cSF);
    this.cTE.cTH.setChecked(a.AZ().BU());
    EditText editText = (EditText)this.cTE.cTG.dwQ.getView();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a.AZ().BW());
    stringBuilder.append("");
    editText.setText(stringBuilder.toString());
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer = a(a.AZ().BX(), stringBuffer);
    this.cTE.cTJ.setText(stringBuffer.toString());
    if (this.cwz != null && this.cwz.size() != 0) {
      this.cTE.cTI.setBackgroundResource(2130772051);
      return;
    } 
    this.cTE.cTH.setBackgroundResource(2130772051);
    this.cTE.cTI.setVisibility(8);
  }
  
  private boolean save() {
    String str3 = ((EditText)this.cTE.cTG.dwQ.getView()).getText().toString();
    if (by.isNull(str3)) {
      n.eP(2131627626);
      ((EditText)this.cTE.cTG.dwQ.getView()).requestFocus();
      return false;
    } 
    if (Double.valueOf(str3).doubleValue() < 0.0D || Double.valueOf(str3).doubleValue() > 100.0D) {
      n.eP(2131627629);
      ((EditText)this.cTE.cTG.dwQ.getView()).requestFocus();
      return false;
    } 
    a.AZ().ca(this.cwA);
    String str2 = this.cTE.cTJ.getText().toString();
    String str1 = str2;
    if (!by.isNull(str2))
      str1 = str2.replace(",", "/"); 
    a.AZ().cb(str1);
    a.AZ().g(by.parseDouble(str3));
    a.AZ().bZ(this.cTE.cTH.isChecked());
    Toast.makeText(this, 2131628160, 0).show();
    n.a(this, this.cTE.cTG.dwQ.getView());
    return true;
  }
  
  public boolean Az() {
    if (this.cwA == null)
      this.cwA = ""; 
    String str2 = a.AZ().BX();
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    return !this.cwA.equals(str1) ? true : ((this.cTE.cTH.isChecked() == (a.AZ().BU() ^ true)) ? true : ((by.parseDouble(((EditText)this.cTE.cTG.dwQ.getView()).getText().toString()) != a.AZ().BW())));
  }
  
  public void ZA() {
    r r = new r(this, new ew(this));
    r.setTitle(getString(2131627735));
    r.s(getString(2131627733));
    r.t(getString(2131627734));
    r.oZ(getString(2131627732));
    r.show();
  }
  
  public StringBuilder a(StringBuilder paramStringBuilder, String paramString) {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    if (by.isNull(paramStringBuilder.toString())) {
      str = "";
    } else {
      str = ",";
    } 
    stringBuilder.append(str);
    stringBuilder.append(paramString);
    paramStringBuilder.append(stringBuilder.toString());
    return paramStringBuilder;
  }
  
  public void onBackPressed() {
    if (Az()) {
      ZA();
      return;
    } 
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cTE = a.G(this);
    this.titleBar = aa.M(this);
    ZQ();
    aki();
  }
  
  public static class a extends ab<ViewGroup> {
    public f cTG = new f(2131297529);
    
    public CheckBoxLayoutInMainSetting cTH;
    
    public View cTI;
    
    public TextView cTJ;
    
    public a(int param1Int, View param1View) {
      super(param1Int);
      this.cTH = (CheckBoxLayoutInMainSetting)s.z(param1View, 2131296743);
      this.cTI = s.z(param1View, 2131298448);
      this.cTJ = (TextView)s.z(param1View, 2131299780);
    }
    
    public static a G(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(2131427961, null);
      param1Activity.setContentView(view);
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\ServiceChargeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */