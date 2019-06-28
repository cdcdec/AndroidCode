package com.laiqian.main;

import android.content.Context;
import android.text.Html;
import android.widget.EditText;
import com.laiqian.auth.au;
import com.laiqian.auth.cj;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.d.a;
import com.laiqian.entity.aq;
import com.laiqian.main.module.settlement.pay.v;
import com.laiqian.ui.a.r;
import com.laiqian.util.n;
import java.text.DecimalFormat;

public class cr {
  public static v a(Context paramContext, au paramau, aq paramaq, String paramString1, String paramString2, String paramString3) {
    v v = new v("0", paramau, true);
    String str = RootApplication.getLaiqianPreferenceManager().atp();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(cj.aGx);
    if (str.equals(stringBuilder.toString()))
      return v; 
    stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(cj.aGy);
    if (str.equals(stringBuilder.toString()) && paramau.aEq) {
      switch (paramau.aEs) {
        default:
          return v;
        case 1:
          d = Double.parseDouble(paramString1);
          if (!aq.a(paramaq) && paramaq.discount <= paramau.aEt)
            return v; 
          if (d < paramau.aEt) {
            if (a.AZ().Bn() <= d)
              return v; 
            v.dB(false);
            v.fh(n.a(Double.valueOf(d), true, false));
            return v;
          } 
          return v;
        case 0:
          break;
      } 
      double d = Double.parseDouble(paramString3) - Double.parseDouble(paramString2);
      if (paramau.aEt < d) {
        String str2;
        DecimalFormat decimalFormat2;
        DecimalFormat decimalFormat3;
        switch (CrashApplication.aIQ) {
          default:
            str = "0";
            decimalFormat3 = new DecimalFormat(str);
            v.dB(false);
            v.fh(decimalFormat3.format(d));
            return v;
          case 2:
            str2 = "0.00";
            decimalFormat2 = new DecimalFormat(str2);
            v.dB(false);
            v.fh(decimalFormat2.format(d));
            return v;
          case 1:
            break;
        } 
        String str1 = "0.0";
        DecimalFormat decimalFormat1 = new DecimalFormat(str1);
        v.dB(false);
        v.fh(decimalFormat1.format(d));
        return v;
      } 
      return v;
    } 
    return v;
  }
  
  public static void a(Context paramContext, String paramString, au paramau) {
    StringBuilder stringBuilder;
    String str = "";
    switch (paramau.aEs) {
      default:
        paramString = str;
        break;
      case 1:
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramContext.getString(2131625662));
        stringBuilder.append(paramString);
        stringBuilder.append("%");
        paramString = stringBuilder.toString();
        break;
      case 0:
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramContext.getString(2131627999));
        stringBuilder.append(paramString);
        stringBuilder.append(paramContext.getString(2131629372));
        paramString = stringBuilder.toString();
        break;
    } 
    paramString = String.format(paramContext.getString(2131629627), new Object[] { paramString });
    r r = new r(paramContext, 3, null);
    r.setTitle(paramContext.getString(2131628195));
    r.s(Html.fromHtml(paramString));
    r.oZ(paramContext.getString(2131629626));
    r.show();
  }
  
  public static boolean a(Context paramContext, au paramau, aq paramaq, EditText paramEditText1, EditText paramEditText2, String paramString) {
    String str = RootApplication.getLaiqianPreferenceManager().atp();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(cj.aGx);
    if (str.equals(stringBuilder.toString()))
      return true; 
    stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(cj.aGy);
    if (str.equals(stringBuilder.toString()) && paramau.aEq) {
      switch (paramau.aEs) {
        default:
          return true;
        case 1:
          d = Double.parseDouble(paramEditText2.getText().toString().trim());
          if (paramaq != null && paramaq.discount <= paramau.aEt)
            return true; 
          if (d < paramau.aEt) {
            if (a.AZ().Bn() <= d)
              return true; 
            a(paramContext, n.a(Double.valueOf(d), true, false, CrashApplication.aIQ), paramau);
            return false;
          } 
          return true;
        case 0:
          break;
      } 
      double d = Double.parseDouble(paramString) - Double.parseDouble(paramEditText1.getText().toString().trim());
      if (paramau.aEt < d) {
        switch (CrashApplication.aIQ) {
          default:
            str1 = "0";
            a(paramContext, (new DecimalFormat(str1)).format(d), paramau);
            return false;
          case 2:
            str1 = "0.00";
            a(paramContext, (new DecimalFormat(str1)).format(d), paramau);
            return false;
          case 1:
            break;
        } 
        String str1 = "0.0";
        a(paramContext, (new DecimalFormat(str1)).format(d), paramau);
        return false;
      } 
      return true;
    } 
    return true;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */