package com.laiqian.member.setting;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.entity.aq;
import com.laiqian.entity.aw;
import com.laiqian.entity.g;
import com.laiqian.member.setting.points.a;
import com.laiqian.member.setting.sms.k;
import com.laiqian.models.an;
import com.laiqian.models.at;
import com.laiqian.models.l;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.pos.industry.a;
import com.laiqian.pos.settings.z;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.bh;
import com.laiqian.util.n;
import io.reactivex.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bc {
  private static bc bCT;
  
  private Context context;
  
  private bc(Context paramContext) { this.context = paramContext; }
  
  public static bc RH() {
    if (bCT == null)
      bCT = new bc(RootApplication.zv()); 
    return bCT;
  }
  
  private void t(HashMap<String, Object> paramHashMap) {
    a a = a.AZ();
    int i = Integer.parseInt(String.valueOf(paramHashMap.get("nDiscountMode")));
    boolean bool1 = false;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    a.bP(bool);
    a = a.AZ();
    if (Integer.parseInt(String.valueOf(paramHashMap.get("nIsAutoUpgraded"))) == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    a.bM(bool);
    a = a.AZ();
    if (Integer.parseInt(String.valueOf(paramHashMap.get("nIsPointDeduction"))) == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    a.bR(bool);
    a = a.AZ();
    boolean bool = bool1;
    if (Integer.parseInt(String.valueOf(paramHashMap.get("nIsPointOpen"))) == 1)
      bool = true; 
    a.cd(bool);
    a.AZ().dY(Integer.parseInt(String.valueOf(paramHashMap.get("nPointDeductionRate"))));
    a.AZ().a(new Pair(Double.valueOf(1.0D), Double.valueOf(Double.parseDouble(String.valueOf(paramHashMap.get("nPointAccumulatedRate"))))));
    RootApplication.getLaiqianPreferenceManager().N(Boolean.valueOf("1".equals(paramHashMap.get("nIsAllowChangeGift"))));
  }
  
  private void u(HashMap<String, Object> paramHashMap) {
    ArrayList arrayList = new ArrayList();
    try {
      JSONObject jSONObject2 = new JSONObject(String.valueOf(paramHashMap.get("sSilverCard")));
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(RootApplication.getLaiqianPreferenceManager().Tx());
      stringBuilder2.append("26001");
      arrayList.add(new g(Long.parseLong(stringBuilder2.toString()), false, jSONObject2.getDouble("start_amount"), jSONObject2.getDouble("discount"), jSONObject2.getString("name")));
      jSONObject2 = new JSONObject(String.valueOf(paramHashMap.get("sGoldCard")));
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(RootApplication.getLaiqianPreferenceManager().Tx());
      stringBuilder2.append("26002");
      arrayList.add(new g(Long.parseLong(stringBuilder2.toString()), true, jSONObject2.getDouble("start_amount"), jSONObject2.getDouble("discount"), jSONObject2.getString("name")));
      JSONObject jSONObject1 = new JSONObject(String.valueOf(paramHashMap.get("sDiamondCard")));
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(RootApplication.getLaiqianPreferenceManager().Tx());
      stringBuilder1.append("26003");
      arrayList.add(new g(Long.parseLong(stringBuilder1.toString()), 2, jSONObject1.getDouble("start_amount"), jSONObject1.getDouble("discount"), jSONObject1.getString("name")));
      (new at(this.context)).x(arrayList);
      return;
    } catch (JSONException paramHashMap) {
      a.e(paramHashMap);
      return;
    } catch (Exception paramHashMap) {
      a.e(paramHashMap);
      return;
    } 
  }
  
  private void v(HashMap<String, Object> paramHashMap) {
    byte b;
    av av = RootApplication.getLaiqianPreferenceManager();
    if (Integer.parseInt(String.valueOf(paramHashMap.get("nAlipayMode"))) == 0) {
      b = 0;
    } else {
      b = 1;
    } 
    av.lR(b);
    av = RootApplication.getLaiqianPreferenceManager();
    if (Integer.parseInt(String.valueOf(paramHashMap.get("nWeixinMode"))) == 0) {
      b = 8;
    } else {
      b = 5;
    } 
    av.lU(b);
    RootApplication.getLaiqianPreferenceManager().lS(TextUtils.isEmpty(String.valueOf(paramHashMap.get("sAlipayAppID"))) ^ true);
    RootApplication.getLaiqianPreferenceManager().lT(TextUtils.isEmpty(String.valueOf(paramHashMap.get("sWeixinAppID"))) ^ true);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.getLaiqianPreferenceManager().avo());
    stringBuilder.append("");
    Log.e("sAlipayAppID", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.getLaiqianPreferenceManager().avp());
    stringBuilder.append("");
    Log.e("sWeixinAppID", stringBuilder.toString());
  }
  
  private void w(HashMap<String, Object> paramHashMap) {
    k k = new k();
    int i = Integer.parseInt(String.valueOf(paramHashMap.get("isOpenSMSNotice")));
    byte b2 = 0;
    if (i == 1) {
      b1 = 1;
    } else {
      b1 = 0;
    } 
    k.bGN = b1;
    if (Integer.parseInt(String.valueOf(paramHashMap.get("nAlipayMode"))) == 1) {
      b1 = 1;
    } else {
      b1 = 0;
    } 
    k.bGM = b1;
    if (Integer.parseInt(String.valueOf(paramHashMap.get("isMemberConsumeNoticed"))) == 1) {
      b1 = 1;
    } else {
      b1 = 0;
    } 
    k.bGK = b1;
    byte b1 = b2;
    if (Integer.parseInt(String.valueOf(paramHashMap.get("isMemberChargeNoticed"))) == 1)
      b1 = 1; 
    k.bGL = b1;
    fX(k.b(k));
  }
  
  public long RI() {
    at at = new at(this.context);
    long l = at.RI();
    at.close();
    return l;
  }
  
  public ArrayList<g> RJ() {
    at at = new at(this.context);
    ArrayList arrayList = at.RJ();
    at.close();
    return arrayList;
  }
  
  public boolean RK() {
    av av = new av(this.context);
    str1 = av.Ea();
    String str2 = av.atr();
    String str3 = av.Tx();
    av.close();
    HashMap hashMap = new HashMap();
    hashMap.put("user_name", str1);
    hashMap.put("password", str2);
    hashMap.put("auth_type", "0");
    hashMap.put("shop_id", str3);
    hashMap.put("version", "1");
    hashMap.put("lqk_config", a.AZ().BM());
    str1 = bh.a(RootUrlParameter.clO, this.context, hashMap);
    if (!TextUtils.isEmpty(str1))
      try {
        boolean bool = "true".equals((new JSONObject(str1)).optString("result", "false"));
        return bool;
      } catch (Exception str1) {
        return false;
      }  
    return false;
  }
  
  public String[] RL() {
    av av = new av(this.context);
    str1 = av.Ea();
    String str2 = av.atr();
    String str3 = av.Tx();
    av.close();
    try {
      HashMap hashMap = new HashMap();
      hashMap.put("user_name", str1);
      hashMap.put("password", str2);
      hashMap.put("auth_type", "0");
      hashMap.put("shop_id", str3);
      hashMap.put("version", "2");
      null = new StringBuilder();
      null.append(RootApplication.getLaiqianPreferenceManager().QV());
      null.append("");
      hashMap.put("scope", null.toString());
      String str = bh.a(RootUrlParameter.clD, this.context, hashMap, 10000);
      if (!TextUtils.isEmpty(str)) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.optBoolean("result")) {
          jSONObject = jSONObject.getJSONObject("message");
          String[] arrayOfString = new String[2];
          arrayOfString[0] = jSONObject.optString("num", "0");
          arrayOfString[1] = jSONObject.optString("amount", "0");
          if ("null".equals(arrayOfString[1]))
            arrayOfString[1] = "0"; 
          return arrayOfString;
        } 
        return null;
      } 
      return null;
    } catch (Exception str1) {
      return null;
    } 
  }
  
  public List<g> RM() {
    at at = new at(this.context);
    ArrayList arrayList = at.RJ();
    at.close();
    return arrayList;
  }
  
  public void RN() { a.aKh().r(new bd(this)); }
  
  public List<g> RO() {
    ArrayList arrayList = new ArrayList();
    str = RootApplication.zv().getLaiqianPreferenceManager().Tx();
    HashMap hashMap = new HashMap();
    hashMap.put("shopid", str);
    str = bh.a(a.cqs, RootApplication.zv().getApplicationContext(), hashMap);
    if (!TextUtils.isEmpty(str))
      try {
        hashMap = au.qB(str);
        JSONObject jSONObject2 = new JSONObject(String.valueOf(hashMap.get("sSilverCard")));
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(RootApplication.getLaiqianPreferenceManager().Tx());
        stringBuilder2.append("26001");
        arrayList.add(new g(Long.parseLong(stringBuilder2.toString()), false, jSONObject2.getDouble("start_amount"), jSONObject2.getDouble("discount"), jSONObject2.getString("name"), 1.0D, false));
        jSONObject2 = new JSONObject(String.valueOf(hashMap.get("sGoldCard")));
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(RootApplication.getLaiqianPreferenceManager().Tx());
        stringBuilder2.append("26002");
        arrayList.add(new g(Long.parseLong(stringBuilder2.toString()), true, jSONObject2.getDouble("start_amount"), jSONObject2.getDouble("discount"), jSONObject2.getString("name"), 1.0D, false));
        JSONObject jSONObject1 = new JSONObject(String.valueOf(hashMap.get("sDiamondCard")));
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(RootApplication.getLaiqianPreferenceManager().Tx());
        stringBuilder1.append("26003");
        arrayList.add(new g(Long.parseLong(stringBuilder1.toString()), 2, jSONObject1.getDouble("start_amount"), jSONObject1.getDouble("discount"), jSONObject1.getString("name"), 1.0D, false));
        str = (new JSONObject(str)).optString("sMoreMemberLevels");
        if (!TextUtils.isEmpty(str)) {
          JSONArray jSONArray = new JSONArray(str);
          byte b;
          for (b = 0; b < jSONArray.length(); b++) {
            jSONObject1 = jSONArray.optJSONObject(b);
            Integer integer = Integer.valueOf(jSONObject1.optInt("id"));
            String str1 = jSONObject1.optString("name");
            double d1 = jSONObject1.optDouble("start_amount");
            double d2 = jSONObject1.optDouble("discount");
            arrayList.add(new g(integer.intValue(), integer.intValue(), Double.valueOf(d1).doubleValue(), Double.valueOf(d2).doubleValue(), str1));
          } 
        } 
      } catch (Exception str) {
        a.e(str);
      }  
    return arrayList;
  }
  
  public List<g> RP() { return RootApplication.getLaiqianPreferenceManager().isMultipleShop() ? RO() : (RootApplication.getLaiqianPreferenceManager().avl() ? RS() : RM()); }
  
  public List<Long> RQ() throws JSONException {
    ArrayList arrayList = new ArrayList();
    List list = RP();
    if (!list.isEmpty()) {
      JSONArray jSONArray = new JSONArray();
      for (g g : list) {
        String str;
        JSONObject jSONObject = new JSONObject();
        if (g.getId() > 2600L) {
          str = Long.valueOf(g.getId());
        } else {
          null = new StringBuilder();
          null.append("2600");
          null.append(g.getId());
          str = null.toString();
        } 
        jSONObject.put("id", str);
        jSONObject.put("number", g.getNumber());
        jSONObject.put("name", g.EV());
        jSONObject.put("discount", g.EU());
        jSONObject.put("start_amount", g.ET());
        jSONArray.put(jSONObject);
        if (String.valueOf(System.currentTimeMillis()).length() == String.valueOf(g.getId()).length()) {
          str = String.valueOf(g.getId());
        } else {
          long l;
          if (g.getId() > 2600L) {
            l = g.getId();
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("2600");
            stringBuilder.append(g.getId());
            l = Long.parseLong(stringBuilder.toString());
          } 
          str = String.valueOf(Long.valueOf(l).longValue() % 100000L);
        } 
        if (!TextUtils.isEmpty(str))
          arrayList.add(Long.valueOf(str)); 
      } 
      if (jSONArray.length() != 0)
        RootApplication.getLaiqianPreferenceManager().rx(jSONArray.toString()); 
      return arrayList;
    } 
    return arrayList;
  }
  
  public void RR() {
    try {
      List list = RH().RQ();
      if (!list.isEmpty()) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (byte b = 0; b < list.size(); b++)
          jSONArray.put(b, list.get(b)); 
        jSONObject.put("memberLevels", jSONArray);
        a.AZ().bT(jSONObject.toString());
        return;
      } 
    } catch (Exception exception) {
      a.e(exception);
    } 
  }
  
  public List<g> RS() {
    ArrayList arrayList = new ArrayList();
    av av = new av(this.context);
    str1 = av.Ea();
    String str2 = av.atr();
    String str3 = av.Tx();
    av.close();
    try {
      HashMap hashMap = new HashMap();
      hashMap.put("user_name", str1);
      hashMap.put("password", str2);
      hashMap.put("auth_type", "0");
      hashMap.put("shop_id", str3);
      hashMap.put("version", "1");
      str1 = bh.a(RootUrlParameter.clC, this.context, hashMap, 10000);
      str2 = bh.a(RootUrlParameter.clM, this.context, hashMap, 10000);
      return (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2)) ? g.a(new JSONObject(str1), new JSONObject(str2)) : arrayList;
    } catch (Exception str1) {
      return arrayList;
    } 
  }
  
  public a RT() { return a.SG(); }
  
  public k RU() {
    av = new av(this.context);
    String str1 = av.Ea();
    String str2 = av.atr();
    String str3 = av.Tx();
    av.close();
    try {
      null = new HashMap();
      null.put("user_name", str1);
      null.put("password", str2);
      null.put("auth_type", "0");
      null.put("shop_id", str3);
      null.put("version", "1");
      null = new StringBuilder();
      null.append(RootApplication.getLaiqianPreferenceManager().QV());
      null.append("");
      null.put("scope", null.toString());
      String str5 = bh.a(RootUrlParameter.clE, this.context, null, 10000);
      String str4 = bh.a(RootUrlParameter.clF, this.context, null, 10000);
      if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str4)) {
        JSONObject jSONObject2 = new JSONObject(str5);
        JSONObject jSONObject1 = new JSONObject(str4);
        return "true".equals(jSONObject2.optString("result", "false")) ? (!"true".equals(jSONObject1.optString("result", "false")) ? null : k.b(jSONObject2, jSONObject1)) : null;
      } 
      return null;
    } catch (Exception av) {
      return null;
    } 
  }
  
  public boolean a(double paramDouble, int paramInt) {
    at at = new at(this.context);
    List list = at.b(paramDouble, paramInt);
    at.close();
    if (RootApplication.getLaiqianPreferenceManager().avl() && !list.isEmpty() && bd.bH(RootApplication.zv())) {
      Iterator iterator = list.iterator();
      while (iterator.hasNext()) {
        if (!g((g)iterator.next()))
          return false; 
      } 
    } 
    return true;
  }
  
  public boolean a(int paramInt, ArrayList<g> paramArrayList) {
    av av = new av(this.context);
    String str2 = av.Ea();
    String str3 = av.atr();
    String str4 = av.Tx();
    av.close();
    HashMap hashMap = new HashMap();
    hashMap.put("user_name", str2);
    hashMap.put("password", str3);
    hashMap.put("auth_type", "0");
    hashMap.put("shop_id", str4);
    hashMap.put("version", "1");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(((g)paramArrayList.get(paramInt)).getNumber());
    stringBuilder.append("");
    hashMap.put("level_rank", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(((g)paramArrayList.get(paramInt)).getId());
    stringBuilder.append("");
    hashMap.put("level_id", stringBuilder.toString());
    hashMap.put("level_name", ((g)paramArrayList.get(paramInt)).EV());
    stringBuilder = new StringBuilder();
    stringBuilder.append(((g)paramArrayList.get(paramInt)).EU());
    stringBuilder.append("");
    hashMap.put("level_discount", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(((g)paramArrayList.get(paramInt)).ET());
    stringBuilder.append("");
    hashMap.put("level_require_amount", stringBuilder.toString());
    str1 = bh.a(RootUrlParameter.clN, this.context, hashMap);
    if (TextUtils.isEmpty(str1))
      return false; 
    try {
      boolean bool = "true".equals((new JSONObject(str1)).optString("result", "false"));
      return bool;
    } catch (Exception str1) {
      return false;
    } 
  }
  
  @NonNull
  public boolean a(Context paramContext, g paramg, Queue<Integer> paramQueue) {
    boolean bool;
    bc bc1 = RH();
    boolean bool1 = bc1.e(paramg);
    l l = new l(paramContext);
    l.m(paramg.getId(), paramg.EV());
    l.close();
    if (bd.bH(paramContext))
      bc1.g(paramg); 
    if (paramQueue != null && !paramQueue.isEmpty()) {
      bool = bc1.d(paramg);
    } else {
      bool = true;
    } 
    return (bool1 && bool);
  }
  
  public boolean a(a parama) {
    null = new av(this.context);
    String str1 = null.Ea();
    String str2 = null.atr();
    String str3 = null.Tx();
    null.close();
    HashMap hashMap = new HashMap();
    hashMap.put("user_name", str1);
    hashMap.put("password", str2);
    hashMap.put("auth_type", "0");
    hashMap.put("shop_id", str3);
    hashMap.put("version", "1");
    if (a.AZ().a(new Pair(Double.valueOf(parama.SC()), Double.valueOf(parama.SD()))) && a.AZ().dY(parama.SA()) && a.AZ().bR(parama.SB())) {
      if (!a.AZ().cd(parama.SE()))
        return false; 
      hashMap.put("lqk_config", a.AZ().BM());
      str = bh.a(RootUrlParameter.clO, this.context, hashMap);
      if (!TextUtils.isEmpty(str))
        try {
          boolean bool = "true".equals((new JSONObject(str)).optString("result", "false"));
          return bool;
        } catch (Exception str) {
          return false;
        }  
      return false;
    } 
    return false;
  }
  
  public boolean a(k paramk) {
    av av = new av(this.context);
    String str1 = av.Ea();
    String str2 = av.atr();
    String str3 = av.Tx();
    av.close();
    try {
      HashMap hashMap = new HashMap();
      hashMap.put("user_name", str1);
      hashMap.put("password", str2);
      hashMap.put("auth_type", "0");
      hashMap.put("shop_id", str3);
      hashMap.put("version", "1");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramk.bGL);
      stringBuilder.append("");
      hashMap.put("isMemberChargeNoticed", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramk.bGK);
      stringBuilder.append("");
      hashMap.put("isMemberConsumeNoticed", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramk.bGN);
      stringBuilder.append("");
      hashMap.put("isOpenSMSNotice", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramk.bGM);
      stringBuilder.append("");
      hashMap.put("isWeixinVerifyNoticed", stringBuilder.toString());
      String str = bh.a(RootUrlParameter.clJ, this.context, hashMap, 10000);
      if (!TextUtils.isEmpty(str) && "true".equals((new JSONObject(str)).optString("result", "false"))) {
        fX(k.b(paramk));
        return true;
      } 
      return false;
    } catch (Exception paramk) {
      return false;
    } 
  }
  
  public boolean aE(long paramLong) {
    at at = new at(this.context);
    boolean bool = at.bG(paramLong);
    at.close();
    return bool;
  }
  
  public boolean aF(long paramLong) {
    l l = new l(this.context);
    boolean bool = l.aF(paramLong);
    l.close();
    return bool;
  }
  
  public int am(double paramDouble) { return (int)(Math.ceil(paramDouble * a.AZ().BC()) + 1.0E-4D); }
  
  public String an(double paramDouble) {
    double d = paramDouble;
    if (paramDouble < 0.0D)
      d = 0.0D; 
    paramDouble = Math.pow(10.0D, RootApplication.aIQ);
    return z.kF(String.format("%.2f", new Object[] { Double.valueOf(Math.floor(d / a.AZ().BC() * paramDouble) / paramDouble) }));
  }
  
  public boolean b(Context paramContext, g paramg, Queue<Integer> paramQueue) {
    boolean bool = bd.bH(paramContext);
    byte b = 0;
    if (bool) {
      bc bc1 = RH();
      boolean bool1 = bc1.g(paramg);
      if (bool1 && paramQueue != null && !paramQueue.isEmpty()) {
        bool = bc1.d(paramg);
      } else {
        bool = true;
      } 
      if (bool1 && bool) {
        l l = new l(paramContext);
        l.m(paramg.getId(), paramg.EV());
        l.close();
        bc1.e(paramg);
      } 
      int i = b;
      if (bool1) {
        i = b;
        if (bool)
          i = 1; 
      } 
      return i;
    } 
    return false;
  }
  
  public boolean d(g paramg) {
    at at = new at(this.context);
    List list = at.h(paramg);
    list.iterator();
    at.close();
    if (RootApplication.getLaiqianPreferenceManager().avl() && !list.isEmpty() && bd.bH(RootApplication.zv()))
      for (g g1 : list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateMemberDiscountAndAmount memberRankDiscounts.size=");
        stringBuilder.append(list.size());
        stringBuilder.append("-->");
        stringBuilder.append(paramg.toString());
        Log.i("OnlineSearchUtil", stringBuilder.toString());
        if (!g(g1))
          return false; 
      }  
    return true;
  }
  
  public boolean e(g paramg) {
    at at = new at(this.context);
    boolean bool = at.e(paramg);
    at.close();
    return bool;
  }
  
  public boolean f(g paramg) {
    at at = new at(this.context);
    boolean bool = at.f(paramg);
    at.close();
    return bool;
  }
  
  public g fN(int paramInt) {
    at at = new at(this.context);
    g g = at.bJ(paramInt);
    at.close();
    return g;
  }
  
  public boolean fW(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return false; 
    try {
      List list = a.AZ().Bz();
      if (String.valueOf(System.currentTimeMillis()).length() != paramString.length())
        paramString = String.valueOf(Long.valueOf(paramString).longValue() % 100000L); 
      if (!TextUtils.isEmpty(paramString) && !list.isEmpty()) {
        boolean bool = list.contains(Long.valueOf(Long.parseLong(paramString)));
        if (!bool)
          return false; 
      } 
    } catch (JSONException paramString) {
      a.e(paramString);
    } 
    return true;
  }
  
  public void fX(String paramString) {
    try {
      exception = new at(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    exception.im(paramString);
    exception.close();
  }
  
  public boolean fY(String paramString) {
    at at = new at(this.context);
    boolean bool = at.in(paramString);
    at.close();
    return bool;
  }
  
  public boolean fZ(String paramString) {
    HashMap hashMap = au.qB(paramString);
    if (hashMap != null && hashMap.containsKey("nCompanyID")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(hashMap.get("nCompanyID"));
      stringBuilder.append("");
      if (!TextUtils.isEmpty(stringBuilder.toString()))
        RootApplication.getLaiqianPreferenceManager().qE(String.valueOf(hashMap.get("nCompanyID"))); 
    } 
    boolean bool = false;
    boolean bool1 = false;
    if (hashMap != null && hashMap.containsKey("nBusinessMode") && 1 == Integer.parseInt(String.valueOf(hashMap.get("nBusinessMode")))) {
      int i = Integer.parseInt(String.valueOf(hashMap.get("nBusinessMode")));
      this.context.sendBroadcast(new Intent("pos_activity_change_data_vip_online"));
      RootApplication.getLaiqianPreferenceManager().lQ(i);
      this.context.sendBroadcast(new Intent("pos_activity_change_data_vip_online"));
      i = Integer.parseInt(String.valueOf(hashMap.get("nPayMode")));
      RootApplication.getLaiqianPreferenceManager().lV(i);
      if (hashMap.get("nPaySubMode") != null) {
        i = Integer.parseInt(String.valueOf(hashMap.get("nPaySubMode")));
        RootApplication.getLaiqianPreferenceManager().lW(i);
      } 
      t(hashMap);
      u(hashMap);
      v(hashMap);
      w(hashMap);
      null = String.valueOf(hashMap.get("nWeixinShopID"));
      if (hashMap.containsKey("sChargeTemplate") && hashMap.get("sChargeTemplate") != null) {
        str = hashMap.get("sChargeTemplate").toString();
        try {
          JSONObject jSONObject = new JSONObject(str);
          i = n.parseInt(jSONObject.getString("nDiscountClass"));
          RootApplication.getLaiqianPreferenceManager().me(i);
          if (i == 0) {
            double d = Double.parseDouble(jSONObject.getString("fBonusRatio"));
            RootApplication.getLaiqianPreferenceManager().bj(d);
            d = Double.parseDouble(jSONObject.getString("fBonusMinAmount"));
            RootApplication.getLaiqianPreferenceManager().bk(d);
          } else if (i == 1) {
            String str1 = jSONObject.getString("sBonusAmounts");
            RootApplication.getLaiqianPreferenceManager().rG(str1);
          } 
        } catch (Exception str) {
          a.e(str);
        } 
      } 
      if (Integer.parseInt(null) != 0) {
        RootApplication.getLaiqianPreferenceManager().ry(null);
        an an = new an(this.context);
        aw aw = new aw();
        aw.setUrl(String.valueOf(hashMap.get("wechatUrl")));
        aw.setEnabled(true);
        aw.eH(2);
        an.a(aw);
        an.close();
      } 
      i = n.parseInt(String.valueOf(hashMap.get("nIsCash")), 1);
      av av = RootApplication.getLaiqianPreferenceManager();
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      } 
      av.hS(bool);
      if (hashMap.containsKey("nIsOnlyCard")) {
        i = n.parseInt(String.valueOf(hashMap.get("nIsOnlyCard")));
        av = RootApplication.getLaiqianPreferenceManager();
        bool = bool1;
        if (i != 1)
          bool = true; 
        av.hT(bool);
      } 
      if (hashMap.containsKey("nDeposit")) {
        i = n.parseInt(String.valueOf(hashMap.get("nDeposit")));
        RootApplication.getLaiqianPreferenceManager().mf(i);
        return true;
      } 
    } else {
      if (hashMap != null && hashMap.containsKey("nBusinessMode") && Integer.parseInt(String.valueOf(hashMap.get("nBusinessMode"))) == 0) {
        int i = Integer.parseInt(String.valueOf(hashMap.get("nBusinessMode")));
        RootApplication.getLaiqianPreferenceManager().lQ(i);
        i = Integer.parseInt(String.valueOf(hashMap.get("nPayMode")));
        RootApplication.getLaiqianPreferenceManager().lV(i);
        if (hashMap.containsKey("nIsOnlyCard")) {
          i = n.parseInt(String.valueOf(hashMap.get("nIsOnlyCard")));
          av av = RootApplication.getLaiqianPreferenceManager();
          if (i != 1)
            bool = true; 
          av.hT(bool);
        } 
        if (hashMap.containsKey("nDeposit")) {
          i = n.parseInt(String.valueOf(hashMap.get("nDeposit")));
          RootApplication.getLaiqianPreferenceManager().mf(i);
        } 
        return true;
      } 
      return (hashMap != null && hashMap.containsKey("nBusinessMode"));
    } 
    return true;
  }
  
  public boolean g(g paramg) {
    av av = new av(this.context);
    String str2 = av.Ea();
    String str3 = av.atr();
    String str4 = av.Tx();
    av.close();
    HashMap hashMap = new HashMap();
    hashMap.put("user_name", str2);
    hashMap.put("password", str3);
    hashMap.put("auth_type", "0");
    hashMap.put("shop_id", str4);
    hashMap.put("version", "2");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramg.getNumber());
    stringBuilder.append("");
    hashMap.put("level_rank", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramg.getId());
    stringBuilder.append("");
    hashMap.put("level_id", stringBuilder.toString());
    hashMap.put("level_name", paramg.EV());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramg.EU());
    stringBuilder.append("");
    hashMap.put("level_discount", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramg.ET());
    stringBuilder.append("");
    hashMap.put("level_require_amount", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramg.EP());
    stringBuilder.append("");
    hashMap.put("level_point_ratio", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramg.ES());
    stringBuilder.append("");
    hashMap.put("level_upgrade_rule", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramg.EW());
    stringBuilder.append("");
    hashMap.put("level_status", stringBuilder.toString());
    str1 = bh.a(RootUrlParameter.clN, this.context, hashMap);
    if (TextUtils.isEmpty(str1))
      return false; 
    try {
      JSONObject jSONObject = new JSONObject(str1);
      if ("true".equals(jSONObject.optString("result", "false"))) {
        int i = jSONObject.optInt("msg_no", 10000);
        if (i == 10000)
          return true; 
      } 
      return false;
    } catch (Exception str1) {
      return false;
    } 
  }
  
  public boolean v(aq paramaq) {
    if (aq.a(paramaq))
      return false; 
    try {
      String str;
      List list = a.AZ().Bz();
      if (String.valueOf(System.currentTimeMillis()).length() == String.valueOf(paramaq.aWw).length()) {
        str = String.valueOf(paramaq.aWw);
      } else {
        str = String.valueOf(paramaq.aWw % 100000L);
      } 
      if (!TextUtils.isEmpty(str) && !list.isEmpty() && !list.contains(Long.valueOf(Long.parseLong(str)))) {
        paramaq.aWx = " ";
        return false;
      } 
    } catch (JSONException paramaq) {
      a.e(paramaq);
    } 
    return true;
  }
  
  public void x(List<g> paramList) {
    try {
      exception = new at(this.context);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    exception.x(paramList);
    exception.close();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */