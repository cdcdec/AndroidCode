package com.laiqian.report.ui;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.entity.b;
import com.laiqian.entity.z;
import com.laiqian.i.d;
import com.laiqian.member.b.a;
import com.laiqian.member.ca;
import com.laiqian.models.b;
import com.laiqian.models.bh;
import com.laiqian.models.d;
import com.laiqian.models.j;
import com.laiqian.models.l;
import com.laiqian.models.v;
import com.laiqian.online.OnlineSyncRequest;
import com.laiqian.online.f;
import com.laiqian.online.h;
import com.laiqian.pos.hardware.q;
import com.laiqian.pos.industry.a;
import com.laiqian.pos.model.a;
import com.laiqian.product.models.p;
import com.laiqian.report.models.ab;
import com.laiqian.report.models.l;
import com.laiqian.report.models.o;
import com.laiqian.report.models.v;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.bb;
import com.laiqian.util.au;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.bh;
import com.laiqian.util.by;
import com.laiqian.util.logger.d;
import com.laiqian.util.logger.h;
import com.laiqian.util.n;
import com.orhanobut.logger.d;
import io.reactivex.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class OrderDetailsRoot extends ActivityRoot {
  @Nullable
  protected b bpartnerDocEntity;
  
  private final int delete_fail = 101;
  
  private final int delete_suc = 100;
  
  private Handler handler = new aj(this);
  
  private boolean isUseChainMember;
  
  protected boolean isUserCashReturn = false;
  
  private String mOrderNo;
  
  private String mOrdertime;
  
  protected int numDecimal;
  
  protected ArrayList<l> payTypeItemArrayList;
  
  protected o productDocEntity;
  
  TextView tvTableNumber;
  
  private bb waitingDialog;
  
  private void deleteOrReturnAll(boolean paramBoolean, @Nullable z paramz) {
    a a = new a(this, paramBoolean, paramz, null);
    if (isUseOnlineMember()) {
      String str = getActivity().getString(2131628123);
      if (RootApplication.getLaiqianPreferenceManager().QV() == 1)
        str = getActivity().getString(2131628133); 
      if (this.bpartnerDocEntity == null) {
        n.o(str);
        return;
      } 
      if (bd.bH(this)) {
        showWaitingDialog(true);
        a.aKh().r(a);
        return;
      } 
      noNetworkOnUseChainMember();
      return;
    } 
    a.aKh().r(a);
  }
  
  private boolean exceed6(double paramDouble) { return (paramDouble >= 100000.0D || paramDouble <= -100000.0D); }
  
  private b getBpartnerDocEntity(Map<String, String> paramMap) {
    long l = Long.parseLong((String)paramMap.get("nBPartnerID"));
    double d = n.u((CharSequence)paramMap.get("fOldAmount"));
    int i = n.parseInt((String)paramMap.get("nWarehouseID"));
    return new b(l, d, n.u((CharSequence)paramMap.get("fNewAmount")), i);
  }
  
  private void initView() { this.tvTableNumber = (TextView)findViewById(2131299715); }
  
  static Intent obtainIntent(Context paramContext, Class paramClass, String paramString) {
    Intent intent = new Intent(paramContext, paramClass);
    intent.putExtra("orderNo", paramString);
    return intent;
  }
  
  private View obtainProductInfoItemView(o.a parama, HashSet<Integer> paramHashSet) {
    if (n.bc(parama.bTj)) {
      paramHashSet.add(Integer.valueOf(parama.aTS));
    } else if (paramHashSet.contains(Integer.valueOf(parama.aTS))) {
      return null;
    } 
    View view = View.inflate(this, 2131428011, null);
    TextView textView1 = (TextView)view.findViewById(2131298563);
    TextView textView2 = (TextView)view.findViewById(2131298576);
    TextView textView3 = (TextView)view.findViewById(2131298524);
    textView1.setText(parama.name);
    textView2.setText(parama.amW());
    textView3.setText(parama.amX());
    if (parama.cTp == 100066) {
      textView1.setTextColor(getResources().getColor(2131099874));
      textView2.setTextColor(getResources().getColor(2131099874));
      textView3.setTextColor(getResources().getColor(2131099874));
    } else if (parama.cTp == 100068) {
      textView2.setVisibility(4);
    } else if (parama.amY()) {
      textView3.setTextColor(getResources().getColor(2131099871));
    } 
    setProductOtherInfo(view, parama);
    return view;
  }
  
  private boolean realTimeSynchronization(long paramLong1, long paramLong2, boolean paramBoolean) throws Exception {
    a = new OnlineSyncRequest.a();
    v v = new v(this);
    a.a(v.d(this.mOrderNo, paramLong2), 2);
    if (paramBoolean)
      a.a(v.d(this.mOrderNo, paramLong1), 1); 
    d d = new d(this);
    a.a(d.d(this.mOrderNo, paramLong2), 2);
    if (paramBoolean)
      a.a(d.d(this.mOrderNo, paramLong1), 1); 
    j j = new j(this);
    a.a(j.d(this.mOrderNo, paramLong2), 2);
    if (paramBoolean)
      a.a(j.d(this.mOrderNo, paramLong1), 1); 
    null = getLaiqianPreferenceManager();
    a.iM(null.Ea());
    a.iN(null.atr());
    a.bV(Long.parseLong(null.Tx()));
    f f = f.bXQ;
    try {
      h = f.b(a.Xj());
      paramBoolean = h.bXV;
      if (paramBoolean) {
        try {
          d.b("实时同步成功", new Object[0]);
          v.a(this.mOrderNo, paramLong1, paramLong2);
          d.a(this.mOrderNo, paramLong1, paramLong2);
          j.a(this.mOrderNo, paramLong1, paramLong2);
          v.close();
          d.close();
          j.close();
          return true;
        } catch (Exception h) {}
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("实时同步失败");
        stringBuilder1.append(h.message);
        str = stringBuilder1.toString();
        try {
          d.b(str, new Object[0]);
          v.close();
          d.close();
          j.close();
          return false;
        } catch (Exception str) {}
      } 
    } catch (Exception a) {
    
    } finally {}
    h.a(new d(OrderDetailsRoot.class.getSimpleName(), "onlineSync", "请求实时同步失败--", a.getMessage()), h.a.dHw, h.b.dHD);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("实时同步失败");
    stringBuilder.append(a.getMessage());
    d.b(stringBuilder.toString(), new Object[0]);
    a.e(a);
    v.close();
    d.close();
    j.close();
    return false;
  }
  
  private void setMemberData() {
    View view = findViewById(2131298138);
    view.setVisibility(8);
    if (isOnlyReturn())
      return; 
    this.isUseChainMember = false;
    showWaitingDialog(true);
    j j = new j(this);
    if (getLaiqianPreferenceManager().Wq()) {
      this.bpartnerDocEntity = null;
      (new b(this, view, null)).executeOnExecutor(Executors.newCachedThreadPool(), new Void[0]);
    } else {
      try {
        this.bpartnerDocEntity = j.l(Long.valueOf(this.mOrdertime).longValue(), this.mOrderNo);
      } catch (Exception exception) {
        a.e(exception);
      } 
      showMemberInfo(view);
    } 
    j.close();
  }
  
  private void setOrderSource(String paramString, int paramInt) {
    boolean bool;
    View view2 = findViewById(2131300036);
    View view1 = findViewById(2131296858);
    boolean bool1 = false;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      view2.setVisibility(8);
    } else {
      if (paramInt == 1) {
        view2.setVisibility(0);
      } else {
        view2.setVisibility(8);
      } 
      try {
        JSONObject jSONObject = new JSONObject(paramString);
      } catch (Exception paramString) {
        a.e(paramString);
        paramString = null;
      } 
      setTakeawayView(paramString);
      if (bool || paramInt == 7 || paramInt == 15)
        bool1 = true; 
      if (!setBottomButton(view1, bool1))
        view1.setVisibility(8); 
      return;
    } 
    paramString = null;
  }
  
  private void setProduct() {
    ViewGroup viewGroup = (ViewGroup)findViewById(2131298607);
    HashSet hashSet = new HashSet();
    Iterator iterator = this.productDocEntity.daR.iterator();
    while (iterator.hasNext()) {
      View view = obtainProductInfoItemView((o.a)iterator.next(), hashSet);
      if (view != null)
        viewGroup.addView(view); 
    } 
  }
  
  private void setSweepOrderTableNumber(String paramString) {
    paramString = (new ab()).nt(paramString);
    if (!by.isNull(paramString))
      this.tvTableNumber.setText(paramString); 
  }
  
  private void setTakeawayView(JSONObject paramJSONObject) {
    View view1 = findViewById(2131299176);
    if (paramJSONObject == null) {
      view1.setVisibility(8);
      return;
    } 
    view1.setVisibility(0);
    if (!TextUtils.isEmpty(paramJSONObject.optString("sMobile"))) {
      ((TextView)view1.findViewById(2131299179)).setText(paramJSONObject.optString("sMobile"));
      view1.findViewById(2131298801).setVisibility(0);
    } else {
      view1.findViewById(2131298801).setVisibility(8);
    } 
    View view2 = view1.findViewById(2131299175);
    String str2 = paramJSONObject.optString("sAddress", "");
    if (str2.isEmpty()) {
      view2.setVisibility(8);
    } else {
      view2.setVisibility(0);
      ((TextView)view2.findViewById(2131299174)).setText(str2);
    } 
    view2 = view1.findViewById(2131299178);
    str2 = paramJSONObject.optString("sName", "");
    if (str2.isEmpty()) {
      view2.setVisibility(8);
    } else {
      view2.setVisibility(0);
      ((TextView)view2.findViewById(2131299177)).setText(str2);
    } 
    view1 = view1.findViewById(2131300037);
    String str1 = paramJSONObject.optString("sNote", "");
    if (str1.isEmpty()) {
      view1.setVisibility(8);
      return;
    } 
    view1.setVisibility(0);
    ((TextView)view1.findViewById(2131299180)).setText(str1);
  }
  
  private void setTaxView(@NonNull ArrayList<p> paramArrayList, double paramDouble1, double paramDouble2, double paramDouble3) {
    null = findViewById(2131299185);
    if (paramArrayList.isEmpty()) {
      null.setVisibility(8);
      return;
    } 
    null.setVisibility(0);
    null = (ViewGroup)null.findViewById(2131299186);
    null = paramArrayList.iterator();
    double d = 0.0D;
    while (null.hasNext()) {
      p p = (p)null.next();
      View view1 = View.inflate(this, 2131428012, null);
      ((TextView)view1.findViewById(2131299187)).setText(p.IT());
      ((TextView)view1.findViewById(2131299188)).setText(n.d(Double.valueOf(p.ali())));
      ((TextView)view1.findViewById(2131299184)).setText(n.d(Double.valueOf(p.alh())));
      d += p.alh();
      null.addView(view1);
    } 
    View view = null.findViewById(2131299190);
    TextView textView = (TextView)view.findViewById(2131299191);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(":");
    stringBuilder.append(n.d(Double.valueOf(d)));
    textView.setText(stringBuilder.toString());
    textView = (TextView)view.findViewById(2131299189);
    stringBuilder = new StringBuilder();
    stringBuilder.append(":");
    stringBuilder.append(n.d(Double.valueOf(paramDouble1 - d - this.productDocEntity.amS() - paramDouble2 - paramDouble3)));
    textView.setText(stringBuilder.toString());
    if (paramDouble2 > 0.0D) {
      view.findViewById(2131297994).setVisibility(0);
      textView = (TextView)view.findViewById(2131299688);
      stringBuilder = new StringBuilder();
      stringBuilder.append(":");
      stringBuilder.append(n.d(Double.valueOf(paramDouble2)));
      textView.setText(stringBuilder.toString());
      ((TextView)view.findViewById(2131299689)).setText(this.productDocEntity.amR());
    } 
  }
  
  private void showMemberInfo(View paramView) {
    if (this.bpartnerDocEntity != null) {
      paramView.setVisibility(0);
      TextView textView4 = (TextView)paramView.findViewById(2131298149);
      TextView textView3 = (TextView)paramView.findViewById(2131298129);
      TextView textView1 = (TextView)paramView.findViewById(2131296457);
      TextView textView2 = (TextView)paramView.findViewById(2131298150);
      textView4.setText(this.bpartnerDocEntity.aWn);
      if (exceed6(this.bpartnerDocEntity.aWy)) {
        textView3.setTextSize(0, textView3.getTextSize() * 0.8F);
        textView4 = (TextView)findViewById(2131298130);
        textView4.setTextSize(0, textView4.getTextSize() * 0.8F);
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.moneySymbol);
      stringBuilder2.append(n.d(Double.valueOf(this.bpartnerDocEntity.aWy)));
      textView3.setText(stringBuilder2.toString());
      if (exceed6(this.bpartnerDocEntity.aRt)) {
        textView1.setTextSize(0, textView1.getTextSize() * 0.8F);
        textView3 = (TextView)findViewById(2131296458);
        textView3.setTextSize(0, textView3.getTextSize() * 0.8F);
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.moneySymbol);
      stringBuilder1.append(n.d(Double.valueOf(this.bpartnerDocEntity.aRt)));
      textView1.setText(stringBuilder1.toString());
      textView2.setText(this.bpartnerDocEntity.aTp);
      String str = this.bpartnerDocEntity.name;
      ((TextView)paramView.findViewById(2131298148).findViewById(2131298147)).setText(str);
      ((TextView)findViewById(2131298419)).setText(n.d(Long.valueOf(this.bpartnerDocEntity.aWp)));
    } 
    showWaitingDialog(false);
  }
  
  protected void deleteOnlyMark() {
    ai ai = new ai(this);
    a.aKh().r(ai);
  }
  
  protected void deleteOrder() { deleteOrReturnAll(true, null); }
  
  protected boolean isMultiplePayTypes() { return (this.payTypeItemArrayList.size() > 1); }
  
  protected boolean isOnlyReturn() { return false; }
  
  protected boolean isUseOnlineMember() { return this.isUseChainMember; }
  
  protected abstract void noNetworkOnUseChainMember();
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.mOrderNo = getIntent().getExtras().getString("orderNo");
    this.mOrdertime = getIntent().getExtras().getString("ORDERTIME");
    null = new StringBuilder();
    null.append("0rrr----->");
    null.append(this.mOrderNo);
    null.append("--orderTime--");
    null.append(this.mOrdertime);
    b.ct(null.toString());
    if (TextUtils.isEmpty(this.mOrderNo)) {
      finish();
      n.a(this, getString(2131626286));
      return;
    } 
    setContentViewSetCustomTitle(2131428010);
    initView();
    a a = new a(this);
    try {
      this.productDocEntity = a.d(this.mOrderNo, isOnlyReturn(), this.mOrdertime);
    } catch (Exception exception) {
      a.e(exception);
    } 
    a.close();
    if (this.productDocEntity == null) {
      finish();
      n.a(this, getString(2131626286));
      return;
    } 
    this.numDecimal = this.productDocEntity.numDecimal;
    b b1 = new b(this);
    this.payTypeItemArrayList = b1.a(this.mOrderNo, isOnlyReturn(), Long.parseLong(this.mOrdertime));
    b1.close();
    if (this.payTypeItemArrayList == null) {
      finish();
      n.a(this, getString(2131626286));
      return;
    } 
    setTaxView(this.productDocEntity.aTR, this.productDocEntity.amN(), this.productDocEntity.amQ(), this.productDocEntity.amT());
    setProduct();
    setAmount(findViewById(2131299274));
    setOrderSource(this.productDocEntity.daX, this.productDocEntity.orderSource);
    setPayType(findViewById(2131298361));
    setMemberData();
    setSweepOrderTableNumber(this.productDocEntity.daX);
  }
  
  protected abstract void onDeleteFail();
  
  protected void onDeleteSuc() {
    getLaiqianPreferenceManager().ht(true);
    sendBroadcast(new Intent("pos_activity_change_data_product"));
    sendBroadcast(new Intent(a.bwV));
    finish();
  }
  
  protected void returnFull(@Nullable z paramz) {
    if (((l)this.payTypeItemArrayList.get(0)).equals(paramz)) {
      if (isMultiplePayTypes()) {
        deleteOrReturnAll(false, paramz);
        return;
      } 
      deleteOrReturnAll(false, null);
      return;
    } 
    deleteOrReturnAll(false, paramz);
  }
  
  protected void setAmount(View paramView) {
    TextView textView = (TextView)paramView.findViewById(2131299282);
    null = new StringBuilder();
    null.append(this.moneySymbol);
    null.append(this.productDocEntity.amM());
    textView.setText(null.toString());
    String str = this.productDocEntity.amP();
    if (str == null) {
      paramView.findViewById(2131296883).setVisibility(8);
      paramView.findViewById(2131298341).setVisibility(8);
    } else {
      TextView textView1 = (TextView)paramView.findViewById(2131296885);
      textView = (TextView)paramView.findViewById(2131298343);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.moneySymbol);
      stringBuilder2.append(str);
      textView1.setText(stringBuilder2.toString());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.moneySymbol);
      stringBuilder1.append(this.productDocEntity.amO());
      textView.setText(stringBuilder1.toString());
    } 
    if (this.productDocEntity.cTp == 100015)
      ((TextView)paramView.findViewById(2131298342)).setText(2131628008); 
  }
  
  protected boolean setBottomButton(View paramView, boolean paramBoolean) { return false; }
  
  protected void setBpartnerDocEntityByOnline(String paramString) {
    j j = new j(this);
    String str2 = RootApplication.getLaiqianPreferenceManager().Tx();
    String str3 = RootApplication.getLaiqianPreferenceManager().Ea();
    String str4 = RootApplication.getLaiqianPreferenceManager().atr();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootApplication.getLaiqianPreferenceManager().avm());
    stringBuilder.append("");
    String str5 = stringBuilder.toString();
    paramString = j.hb(paramString);
    int i = 0;
    null = new ca(str2, str3, str4, "0", "1", str5, paramString, new String[0]);
    RootApplication.getLaiqianPreferenceManager().avU();
    String str1 = d.ac(null);
    str1 = bh.bt(a.cqA, str1);
    if (!TextUtils.isEmpty(str1)) {
      HashMap hashMap = au.qB(str1);
      if (hashMap.containsKey("result") && "TRUE".equals(String.valueOf(hashMap.get("result")))) {
        ArrayList arrayList = au.aW(hashMap.get("message"));
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(arrayList.size());
        stringBuilder1.append("");
        Log.e("arrList", stringBuilder1.toString());
        if (arrayList != null && arrayList.size() > 0) {
          this.isUseChainMember = true;
          while (i < arrayList.size()) {
            Map map = (Map)arrayList.get(i);
            if ("10006".equals(map.get("nSpareField2"))) {
              this.bpartnerDocEntity = getBpartnerDocEntity(map);
              break;
            } 
            this.bpartnerDocEntity = getBpartnerDocEntity(map);
            i++;
          } 
          null = new HashMap();
          null.put("shop_id", String.valueOf(this.bpartnerDocEntity.aWC));
          null.put("member_id", String.valueOf(this.bpartnerDocEntity.aSW));
          null.put("user_name", CrashApplication.getLaiqianPreferenceManager().Ea());
          null.put("password", CrashApplication.getLaiqianPreferenceManager().atr());
          null.put("auth_type", "0");
          null.put("version", "1");
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(RootApplication.getLaiqianPreferenceManager().avm());
          stringBuilder1.append("");
          null.put("scope", stringBuilder1.toString());
          String str = bh.a(q.ckE, CrashApplication.zv().getApplicationContext(), null);
          if (!TextUtils.isEmpty(str)) {
            HashMap hashMap1 = au.qC(str);
            if (hashMap1 != null && hashMap1.containsKey("result") && "TRUE".equals(hashMap1.get("result"))) {
              HashMap hashMap2 = au.qC((String)hashMap1.get("message"));
              if (hashMap2 != null) {
                String str6;
                if (TextUtils.isEmpty((CharSequence)hashMap2.get("fPoints"))) {
                  str6 = "0";
                } else {
                  str6 = (String)hashMap2.get("fPoints");
                } 
                i = Integer.parseInt(str6);
                this.bpartnerDocEntity.a(by.H((String)hashMap2.get("sNumber"), 9999), by.G((String)hashMap2.get("sContactMobilePhone"), 9999), (String)hashMap2.get("sName"), Double.parseDouble((String)hashMap2.get("fAmount")), i);
              } 
            } 
          } 
        } 
      } 
    } 
  }
  
  protected void setPayType(View paramView) {
    ViewGroup viewGroup = (ViewGroup)paramView.findViewById(2131298369);
    byte b1 = 0;
    TextView textView = null;
    int i = 1;
    while (true) {
      TextView textView1;
      if (b1 < viewGroup.getChildCount()) {
        textView1 = viewGroup.getChildAt(b1);
        if (b1 < this.payTypeItemArrayList.size()) {
          l l = (l)this.payTypeItemArrayList.get(b1);
          if (this.productDocEntity.cTp == 100001 && !l.daH) {
            if (textView == null) {
              textView1.setVisibility(0);
              ((TextView)textView1.findViewById(2131298370)).setText(2131628139);
              textView = (TextView)textView1.findViewById(2131298374);
              textView.setTextColor(getResources().getColor(2131099871));
              d = 0.0D;
              textView1 = findViewById(2131297186);
              textView1.setVisibility(0);
              textView1.setOnClickListener(new ah(this));
            } else {
              textView1.setVisibility(8);
              d = ((Double)textView.getTag()).doubleValue();
            } 
            double d = l.aJW + d;
            textView.setTag(Double.valueOf(d));
            textView.setText(n.d(Double.valueOf(d)));
            textView1 = textView;
          } else {
            textView1.setVisibility(0);
            ((TextView)textView1.findViewById(2131298370)).setText(l.name);
            textView1 = (TextView)textView1.findViewById(2131298374);
            textView1.setText(n.d(Double.valueOf(l.aJW)));
            if (!l.daH)
              textView1.setTextColor(getResources().getColor(2131099871)); 
            byte b2 = i;
            if (i) {
              ((TextView)paramView.findViewById(2131296846)).setText(l.daJ);
              ((TextView)paramView.findViewById(2131299932)).setText(l.daI);
              ((TextView)paramView.findViewById(2131298302)).setText(this.productDocEntity.amK());
              b2 = 0;
            } 
            if (this.productDocEntity.orderSource == 7 || this.productDocEntity.orderSource == 14) {
              paramView.findViewById(2131297948).setVisibility(0);
              bh bh = new bh(this);
              try {
                jSONObject = new JSONObject(this.productDocEntity.bch);
                String str = jSONObject.getString("actual_person");
                try {
                  long l2 = jSONObject.optLong("createTime");
                  try {
                    String str1 = bh.iB(jSONObject.getString("drawerID"));
                    try {
                      String str2 = bh.iB(jSONObject.getString("settlementID"));
                      try {
                        if (TextUtils.isEmpty(str1)) {
                          String str4 = bh.iD(jSONObject.getString("drawerID"));
                          str1 = str4;
                        } 
                        String str3 = str2;
                        try {
                          if (TextUtils.isEmpty(str2))
                            str3 = bh.iD(jSONObject.getString("settlementID")); 
                          bh.close();
                        } catch (JSONException jSONObject) {
                          str3 = str1;
                        } 
                      } catch (JSONException jSONObject) {
                        String str3 = str1;
                      } 
                      str1 = str2;
                    } catch (JSONException jSONObject) {
                      String str2 = str1;
                      str1 = null;
                    } 
                  } catch (JSONException jSONObject) {
                    textView1 = null;
                    Object object1 = null;
                  } 
                } catch (JSONException jSONObject) {}
              } catch (JSONException jSONException) {
                String str = "0";
              } finally {}
              textView1 = null;
              Object object = null;
              long l1 = 0L;
            } 
            if (this.productDocEntity.orderSource == 14) {
              paramView.findViewById(2131297948).setVisibility(0);
              ((TextView)paramView.findViewById(2131296382)).setText(this.productDocEntity.openTableName);
              textView1 = textView;
              i = b2;
            } else {
              paramView.findViewById(2131297948).setVisibility(8);
              textView1 = textView;
              i = b2;
              if (!by.isNull(this.productDocEntity.coJ)) {
                findViewById(2131297954).setVisibility(0);
                textView1 = this.tvTableNumber;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" ");
                stringBuilder.append(this.productDocEntity.coJ);
                textView1.setText(stringBuilder.toString());
                textView1 = textView;
                i = b2;
              } 
            } 
          } 
        } else {
          textView1.setVisibility(8);
          textView1 = textView;
        } 
      } else {
        break;
      } 
      b1++;
      textView = textView1;
    } 
    if (textView != null) {
      i = this.payTypeItemArrayList.size();
      if (b1 < i) {
        double d = ((Double)textView.getTag()).doubleValue();
        while (b1 < this.payTypeItemArrayList.size()) {
          d += ((l)this.payTypeItemArrayList.get(b1)).aJW;
          b1++;
        } 
        textView.setText(n.d(Double.valueOf(d)));
      } 
    } 
  }
  
  protected void setProductOtherInfo(View paramView, o.a parama) {}
  
  protected void showWaitingDialog(boolean paramBoolean) {
    if (paramBoolean) {
      if (this.waitingDialog == null) {
        this.waitingDialog = new bb(this);
        this.waitingDialog.setCancelable(false);
      } 
      this.waitingDialog.show();
      return;
    } 
    if (this.waitingDialog != null)
      this.waitingDialog.cancel(); 
  }
  
  private class a implements Runnable {
    private boolean dfb;
    
    @Nullable
    private z dfc;
    
    private a(OrderDetailsRoot this$0, boolean param1Boolean, @Nullable z param1z) {
      this.dfb = param1Boolean;
      this.dfc = param1z;
    }
    
    public void run() {
      a a2 = new a(this.dfa);
      a2.beginTransaction();
      if (this.dfa.bpartnerDocEntity == null) {
        double = null;
      } else {
        Double double;
        double = Double.valueOf(this.dfa.bpartnerDocEntity.aWo);
      } 
      null = this.dfa.mOrderNo;
      long l = this.dfa.productDocEntity.daW;
      boolean bool2 = this.dfa.isUseOnlineMember();
      boolean bool3 = this.dfb;
      if (this.dfc == null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      null = a2.a(null, l, bool2, double, bool3, bool1);
      a3 = null;
      boolean bool1 = a3.cyx;
      if (bool1) {
        if (!this.dfb && this.dfc != null) {
          b b = new b(this.dfa);
          b.bD(a3.cyz);
          long l1 = a3.cyB;
          l = l1;
          if (l1 <= 0L)
            l = System.currentTimeMillis(); 
          int i = this.dfc.aTv;
          String str = this.dfc.name;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.dfc.aJW);
          stringBuilder.append("");
          bool1 = b.a(false, l, i, str, stringBuilder.toString(), this.dfa.mOrderNo, a3.cyz, this.dfc.aTx, this.dfa.productDocEntity.orderSource, this.dfc.aTy);
          b.close();
          if (bool1 && this.dfa.bpartnerDocEntity != null) {
            j j = new j(this.dfa);
            j.bD(a3.cyz);
            double d1 = 0.0D;
            if (this.dfc.aTv == 10006)
              d1 = this.dfc.aJW; 
            double d2 = -this.dfc.aJW;
            i = (int)-this.dfc.aJW;
            l1 = this.dfa.bpartnerDocEntity.aSW;
            String str1 = this.dfa.mOrderNo;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(l + 1L);
            stringBuilder1.append("");
            bool1 = j.a(l1, d1, 370005L, d2, str1, stringBuilder1.toString(), i, this.dfc.aTv, this.dfc.aTx, this.dfa.bpartnerDocEntity, new j.a());
            j.close();
            if (bool1 && !this.dfa.isUseOnlineMember()) {
              l l2 = new l(this.dfa);
              bool1 = l2.a(this.dfa.bpartnerDocEntity.aSW, d1, -1, d2, i);
              l2.close();
            } 
          } 
        } 
        if (bool1) {
          try {
            OrderDetailsRoot orderDetailsRoot = this.dfa;
            a3 = null;
            try {
              bool2 = orderDetailsRoot.realTimeSynchronization(a3.cyz, a3.cyA, true);
            } catch (Exception a3) {}
          } catch (Exception a3) {}
          a.e(a3);
        } 
        bool2 = false;
      } 
      bool2 = false;
      a.a a1 = a3;
      a2.endTransaction();
      a2.close();
      if (bool1) {
        if (this.dfa.isUseOnlineMember()) {
          if (bool2) {
            this.dfa.handler.sendEmptyMessage(100);
          } else {
            this.dfa.handler.obtainMessage(101, a1.cyy).sendToTarget();
          } 
        } else {
          this.dfa.handler.sendEmptyMessage(100);
        } 
      } else {
        this.dfa.handler.obtainMessage(101, a1.cyy).sendToTarget();
      } 
      v v = new v(this.dfa.getActivity(), this.dfa.productDocEntity, this.dfa.mOrderNo, this.dfa.bpartnerDocEntity, String.valueOf(a1.cyz));
      v.isUserCashReturn = this.dfa.isUserCashReturn;
      v.anv();
    }
  }
  
  private class b extends AsyncTask<Void, Void, Void> {
    private View dfd;
    
    private b(OrderDetailsRoot this$0, View param1View) { this.dfd = param1View; }
    
    protected Void doInBackground(Void... param1VarArgs) {
      this.dfa.setBpartnerDocEntityByOnline(this.dfa.mOrderNo);
      return null;
    }
    
    protected void onPostExecute(Void param1Void) {
      if (this.dfa.isFinishing())
        return; 
      this.dfa.showMemberInfo(this.dfd);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\OrderDetailsRoot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */