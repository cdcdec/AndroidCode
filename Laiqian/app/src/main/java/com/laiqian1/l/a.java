package com.laiqian.l;

import android.content.Context;
import com.google.a.a.a.a.a.a;
import com.laiqian.d.a;
import com.laiqian.entity.aa;
import com.laiqian.entity.aq;
import com.laiqian.entity.z;
import com.laiqian.milestone.h;
import com.laiqian.models.an;
import com.laiqian.models.at;
import com.laiqian.models.bh;
import com.laiqian.util.ch;
import com.laiqian.util.n;
import com.zhuge.analysis.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  public static String dMA = "切换成挂单";
  
  public static String dMB = "切换成开台";
  
  public static String dMs;
  
  public static double dMt;
  
  public static int dMu;
  
  public static int dMv;
  
  public static int dMw;
  
  public static int dMx;
  
  public static int dMy;
  
  public static int dMz;
  
  static  {
  
  }
  
  private static String a(z paramz, boolean paramBoolean) {
    String str;
    int i = paramz.aTv;
    if (i != 10001) {
      if (i != 10013) {
        StringBuilder stringBuilder1;
        switch (i) {
          default:
            str = "未知支付";
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append(str);
            stringBuilder1.append("-");
            stringBuilder1.append(paramz.aJW);
            return stringBuilder1.toString();
          case 10011:
            str = "大众点评代金券";
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append(str);
            stringBuilder1.append("-");
            stringBuilder1.append(paramz.aJW);
            return stringBuilder1.toString();
          case 10010:
            str = "美团代金券";
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append(str);
            stringBuilder1.append("-");
            stringBuilder1.append(paramz.aJW);
            return stringBuilder1.toString();
          case 10009:
            str = "微信支付";
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append(str);
            stringBuilder1.append("-");
            stringBuilder1.append(paramz.aJW);
            return stringBuilder1.toString();
          case 10008:
            str = "店铺代金券";
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append(str);
            stringBuilder1.append("-");
            stringBuilder1.append(paramz.aJW);
            return stringBuilder1.toString();
          case 10007:
            str = "支付宝支付";
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append(str);
            stringBuilder1.append("-");
            stringBuilder1.append(paramz.aJW);
            return stringBuilder1.toString();
          case 10006:
            break;
        } 
        if (paramBoolean) {
          str = "会员支付";
        } else {
          str = "会员卡退货";
        } 
      } else {
        str = "自定义支付";
      } 
    } else if (paramBoolean) {
      str = "现金支付";
    } else {
      str = "现金退货";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("-");
    stringBuilder.append(paramz.aJW);
    return stringBuilder.toString();
  }
  
  public static void a(Context paramContext, List<aa> paramList, ArrayList<z> paramArrayList, boolean paramBoolean, double paramDouble1, double paramDouble2, aq paramaq) {
    JSONObject jSONObject;
    String str;
    try {
      int i;
      String str1;
      z z;
      StringBuilder stringBuilder;
      jSONObject = new JSONObject();
      jSONObject.put("交易金额", paramDouble1);
      jSONObject.put("折扣", paramDouble2);
      switch (paramArrayList.size()) {
        case 1:
          str2 = (z)paramArrayList.get(0);
          i = str2.aTv;
          if (i != 10001) {
            if (i != 10013) {
              switch (i) {
                case 10009:
                  if (str2.aTx == 8L) {
                    str2 = "微信支付";
                    jSONObject.put("支付方式", "二维码");
                  } else if (str2.aTx == 5L) {
                    str2 = "微信支付";
                    jSONObject.put("支付方式", "条码");
                  } else if (str2.aTx == 7L) {
                    str2 = "微信记账";
                  } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("微信支付时，具体类型未知：");
                    stringBuilder.append(str2.aTx);
                    n.println(stringBuilder.toString());
                    return;
                  } 
                  if (!"现金支付".equals(str2)) {
                    a.aAU().a(stringBuilder, str2, jSONObject);
                    return;
                  } 
                  return;
                case 10007:
                  if (str2.aTx == 0L) {
                    str2 = "支付宝支付";
                    jSONObject.put("支付方式", "二维码");
                  } else if (str2.aTx == 1L) {
                    str2 = "支付宝支付";
                    jSONObject.put("支付方式", "条码");
                  } else if (str2.aTx == 2L) {
                    str2 = "支付宝记账";
                  } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("支付宝支付时，具体类型未知：");
                    stringBuilder.append(str2.aTx);
                    n.println(stringBuilder.toString());
                    return;
                  } 
                  if (!"现金支付".equals(str2)) {
                    a.aAU().a(stringBuilder, str2, jSONObject);
                    return;
                  } 
                  return;
                default:
                  str2 = "未知支付";
                  if (!"现金支付".equals(str2)) {
                    a.aAU().a(stringBuilder, str2, jSONObject);
                    return;
                  } 
                  return;
                case 10011:
                  str2 = "大众点评代金券";
                  if (!"现金支付".equals(str2)) {
                    a.aAU().a(stringBuilder, str2, jSONObject);
                    return;
                  } 
                  return;
                case 10010:
                  str2 = "美团代金券";
                  if (!"现金支付".equals(str2)) {
                    a.aAU().a(stringBuilder, str2, jSONObject);
                    return;
                  } 
                  return;
                case 10008:
                  str2 = "店铺代金券";
                  if (!"现金支付".equals(str2)) {
                    a.aAU().a(stringBuilder, str2, jSONObject);
                    return;
                  } 
                  return;
                case 10006:
                  break;
              } 
              if (paramBoolean) {
                str1 = "会员支付";
              } else {
                str1 = "会员卡退货";
              } 
              String str2 = str1;
              if (paramaq != null) {
                jSONObject.put("会员手机号", paramaq.aTp);
                if (paramBoolean) {
                  str2 = "消费后余额";
                } else {
                  str2 = "退货后余额";
                } 
                jSONObject.put(str2, paramaq.aWo);
                str2 = str1;
              } 
            } else {
              String str2;
              str2 = "自定义支付";
            } 
          } else {
            break;
          } 
          if (!"现金支付".equals(str2)) {
            a.aAU().a(stringBuilder, str2, jSONObject);
            return;
          } 
          return;
        case 0:
          n.println("诸葛统计的时候，没有支付方式，这里不会进来");
          return;
        default:
          null = (z)str1.get(0);
          z = (z)str1.get(1);
          jSONObject.put("支付方式一", a(null, paramBoolean));
          jSONObject.put("支付方式二", a(z, paramBoolean));
          str = "组合支付";
          if (!"现金支付".equals(str)) {
            a.aAU().a(stringBuilder, str, jSONObject);
            return;
          } 
          return;
      } 
    } catch (JSONException paramContext) {
      a.e(paramContext);
      return;
    } 
    if (paramBoolean) {
      str = "现金支付";
    } else {
      str = "现金退货";
    } 
    jSONObject.put("实付应付是否相等", "true");
    if (!"现金支付".equals(str)) {
      a.aAU().a(paramContext, str, jSONObject);
      return;
    } 
  }
  
  private static StringBuffer ac(HashMap<String, Integer> paramHashMap) {
    ArrayList arrayList = new ArrayList(paramHashMap.entrySet());
    Collections.sort(arrayList, new b());
    StringBuffer stringBuffer1 = new StringBuffer();
    StringBuffer stringBuffer2 = new StringBuffer();
    for (byte b = 0; b < arrayList.size(); b++) {
      Map.Entry entry = (Map.Entry)arrayList.get(b);
      if (b != 0) {
        stringBuffer1.append(",");
        stringBuffer2.append(",");
      } 
      stringBuffer1.append((String)entry.getKey());
      stringBuffer2.append(entry.getValue());
    } 
    return stringBuffer1;
  }
  
  public static void axM() {
    dMs = null;
    dMt = 0.0D;
    dMu = 0;
  }
  
  private static void axN() {
    dMv = 0;
    dMw = 0;
    dMx = 0;
    dMy = 0;
    dMz = 0;
  }
  
  private static void b(JSONObject paramJSONObject, Context paramContext) {
    an an = new an(paramContext);
    an.c c = an.Vu();
    an.close();
    at at = new at(paramContext);
    boolean bool1 = at.em(false);
    at.close();
    boolean bool2 = a.AZ().Bc();
    try {
      String str;
      paramJSONObject.put("用户名", c.aVs);
      paramJSONObject.put("省份", c.bSu);
      paramJSONObject.put("城市", c.bSv);
      paramJSONObject.put("县区", c.bSw);
      paramJSONObject.put("详细地址", c.aWV);
      paramJSONObject.put("行业", g(c.bSq, paramContext));
      paramJSONObject.put("店铺类型", an.p(paramContext, c.bSp));
      if (bool1) {
        str = "开";
      } else {
        str = "关";
      } 
      paramJSONObject.put("挂单", str);
      if (bool2) {
        str = "开";
      } else {
        str = "关";
      } 
      paramJSONObject.put("牌号", str);
      return;
    } catch (Throwable paramJSONObject) {
      a.e(paramJSONObject);
      return;
    } 
  }
  
  public static void cp(Context paramContext) {
    null = new h(paramContext);
    null.TV();
    null.close();
    null = new bh(paramContext);
    String str = null.WE();
    null.close();
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("员工数量", dMy);
      jSONObject.put("商品数量", dMv);
      jSONObject.put("分类数量", dMx);
      jSONObject.put("口味数量", dMz);
      jSONObject.put("会员数量", dMw);
      jSONObject.put("用户ID", str);
      jSONObject.put("版本号", ch.cf(paramContext));
    } catch (JSONException jSONException) {
      a.e(jSONException);
    } 
    b(jSONObject, paramContext);
    a.aAU().b(paramContext, str, jSONObject);
    axN();
  }
  
  public static String g(String paramString, Context paramContext) {
    HashMap hashMap = new HashMap();
    String[] arrayOfString = paramString.split(",");
    for (byte b = 0; b < arrayOfString.length; b++) {
      int i = Integer.parseInt(arrayOfString[b]);
      if (hashMap.containsKey(an.q(paramContext, i))) {
        hashMap.remove(an.q(paramContext, i));
      } else {
        hashMap.put(an.q(paramContext, i), Integer.valueOf(i));
      } 
    } 
    return ac(hashMap).toString();
  }
  
  public static void j(Context paramContext, String paramString1, String paramString2) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("交易金额", paramString1);
      jSONObject.put("菜品数量", paramString2);
      a.aAU().a(paramContext, "点菜宝下单", jSONObject);
      return;
    } catch (Exception paramContext) {
      a.e(paramContext);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\l\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */