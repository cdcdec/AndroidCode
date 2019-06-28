package com.laiqian.main;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.meituan.s;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.r;
import com.laiqian.util.bd;
import com.laiqian.util.bv;
import com.laiqian.util.i;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cs extends d {
  private Handler aiC = new cx(this);
  
  private a bcE;
  
  private View bcF;
  
  private TextView bcG;
  
  private View bcH;
  
  private TextView bcI;
  
  private TextView bcJ;
  
  private TextView bcK;
  
  private TextView bcL;
  
  private TextView bcM;
  
  private TextView bcN;
  
  private View bcO;
  
  private View bcP;
  
  private View bcQ;
  
  private TextView bcR;
  
  private c bcS;
  
  private i bcT;
  
  private ArrayList<e> bcU;
  
  private boolean bcV;
  
  private double bcW;
  
  private View bcX;
  
  private bc bcY;
  
  private Runnable bcZ = new cv(this);
  
  private final int bda = 1;
  
  private final int bdb = 11;
  
  private final int bdc = 21;
  
  private final int bdd = 231;
  
  private String orderNo;
  
  private final int showText = 99;
  
  private bb waitingDialog;
  
  public cs(Context paramContext, a parama) {
    super(paramContext, 2131427833);
    this.bcE = parama;
    this.waitingDialog = new bb(this.mActivity);
    this.waitingDialog.setCancelable(false);
    this.bcT = new i();
    this.bcU = new ArrayList();
    this.bcF = this.mView.findViewById(2131299971);
    this.bcG = (TextView)this.bcF.findViewById(2131297201);
    ao.a(this, (ViewGroup)this.bcF.findViewById(2131297423));
    this.bcF.findViewById(2131296672).setOnClickListener(new ct(this));
    this.bcX = this.bcF.findViewById(2131297192);
    this.bcX.setOnClickListener(new cy(this));
    this.bcH = this.mView.findViewById(2131298922);
    this.bcI = (TextView)this.bcH.findViewById(2131297198);
    this.bcJ = (TextView)this.bcH.findViewById(2131297193);
    View view = this.bcH.findViewById(2131298921);
    this.bcK = (TextView)view.findViewById(2131297194);
    view.findViewById(2131298700).setOnClickListener(new cz(this));
    view.findViewById(2131298412).setOnClickListener(new da(this));
    this.bcL = (TextView)this.bcH.findViewById(2131297199);
    this.bcM = (TextView)this.bcH.findViewById(2131297197);
    this.bcN = (TextView)this.bcH.findViewById(2131297195);
    this.bcH.findViewById(2131296796).setOnClickListener(new db(this));
    this.bcG.addTextChangedListener(new dd(this));
    this.bcO = this.mView.findViewById(2131297781);
    this.bcP = this.mView.findViewById(2131297779);
    this.bcR = (TextView)this.mView.findViewById(2131298731);
    ListView listView = (ListView)this.bcO.findViewById(2131297776);
    c c1 = new c(this, null);
    this.bcS = c1;
    listView.setAdapter(c1);
    this.bcO.findViewById(2131296805).setOnClickListener(new de(this));
    this.bcO.findViewById(2131297044).setOnClickListener(new df(this));
    this.bcQ = this.bcP.findViewById(2131298733);
    this.bcQ.setOnClickListener(new dg(this));
    this.bcP.findViewById(2131298732).setOnClickListener(new cu(this));
  }
  
  private boolean LE() { return (canOperate() && this.bcF.getVisibility() == 0); }
  
  private void LF() {
    if (this.bcG.getText().length() == 0) {
      n.eP(2131627348);
      return;
    } 
    g(this.bcZ);
  }
  
  private void LJ() {
    this.bcF.setVisibility(0);
    this.bcH.setVisibility(8);
    this.bcG.setText("");
    this.bcO.setVisibility(8);
  }
  
  private void LK() {
    this.bcF.setVisibility(8);
    this.bcH.setVisibility(8);
    this.bcS.notifyDataSetChanged();
    this.bcO.setVisibility(0);
  }
  
  private boolean a(String paramString, int paramInt, double paramDouble1, double paramDouble2) {
    JSONObject jSONObject = n(s.a(paramString, paramInt, this.orderNo));
    if (jSONObject != null) {
      JSONArray jSONArray = jSONObject.optJSONArray("couponCodes");
      if (jSONArray == null || jSONArray.length() == 0) {
        o("异常，消费后的团购券异常");
        return false;
      } 
      for (paramInt = 0; paramInt < jSONArray.length(); paramInt++) {
        String str = jSONArray.optString(paramInt);
        this.bcU.add(new e(this, str, paramDouble1, paramDouble2, null));
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("团购验证的订单号：");
      stringBuilder.append(this.orderNo);
      n.println(stringBuilder.toString());
      this.bcV = true;
      this.aiC.sendEmptyMessage(1);
      return true;
    } 
    return false;
  }
  
  private boolean canOperate() { return this.waitingDialog.isShowing() ^ true; }
  
  private void eP(@StringRes int paramInt) { o(this.mActivity.getText(paramInt)); }
  
  private void g(Runnable paramRunnable) {
    if (!bd.bH(this.mActivity)) {
      if (this.bcY == null)
        this.bcY = new bc(this.mActivity); 
      this.bcY.show();
      return;
    } 
    this.waitingDialog.show();
    this.bcT.post(paramRunnable);
  }
  
  @Nullable
  private JSONObject n(HashMap<String, Object> paramHashMap) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("团购券的返回值：");
    stringBuilder.append(paramHashMap);
    n.println(stringBuilder.toString());
    if (paramHashMap != null) {
      Object object2 = paramHashMap.get("data");
      if (object2 != null) {
        object2 = (JSONObject)object2;
        if (object2.optInt("result", -1) == 0)
          return object2; 
        o(object2.optString("message"));
      } 
      Object object1 = paramHashMap.get("error");
      if (object1 != null) {
        object1 = (JSONObject)object1;
        if (object1.optInt("code") == 2) {
          o(this.mActivity.getString(2131626137));
        } else {
          o(object1.optString("message"));
        } 
      } else {
        o("异常，返回值错误");
      } 
    } else {
      eP(2131625879);
    } 
    return null;
  }
  
  private void o(CharSequence paramCharSequence) { this.aiC.obtainMessage(99, paramCharSequence).sendToTarget(); }
  
  public void LG() {
    if (this.orderNo == null) {
      n.o("异常！验证对话框中的订单号空白");
      return;
    } 
    LK();
    this.bcV = false;
    super.show();
  }
  
  public String LH() {
    if (this.bcU.isEmpty())
      return null; 
    JSONArray jSONArray = new JSONArray();
    for (e e : this.bcU) {
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("couponCode", e.b(e));
        jSONArray.put(jSONObject);
      } catch (JSONException e) {
        a.e(e);
      } 
    } 
    return jSONArray.toString();
  }
  
  public double LI() {
    Iterator iterator = this.bcU.iterator();
    double d1;
    for (d1 = 0.0D; iterator.hasNext(); d1 += e.c((e)iterator.next()));
    return d1;
  }
  
  public void LL() {
    if (this.bcU != null) {
      r r = new r(getContext(), true, new cw(this));
      r.setTitle(getContext().getString(2131630138));
      r.s(getContext().getString(2131630683));
      r.t(getContext().getString(2131625163));
      r.oZ(getContext().getString(2131629839));
      r.show();
    } 
  }
  
  public ArrayList<e> LM() { return this.bcU; }
  
  public void aa(double paramDouble) {
    this.bcU.clear();
    LJ();
    this.orderNo = PosActivitySettlementModel.a(true, new Date());
    this.bcV = false;
    this.bcW = paramDouble;
    super.show();
  }
  
  public void dismiss() {
    super.dismiss();
    this.bcT.quit();
    if (this.bcV) {
      double d1 = 0.0D;
      Iterator iterator = this.bcU.iterator();
      while (iterator.hasNext())
        d1 += e.a((e)iterator.next()); 
      this.bcE.Z(d1);
    } 
  }
  
  public boolean dispatchKeyEvent(@NonNull KeyEvent paramKeyEvent) {
    TextView textView;
    if (n.lt(paramKeyEvent.getKeyCode())) {
      if (LE() && paramKeyEvent.getAction() == 1)
        LF(); 
      return true;
    } 
    if (n.isKeycodeDelete(paramKeyEvent.getKeyCode())) {
      if (LE() && paramKeyEvent.getAction() == 0) {
        CharSequence charSequence;
        textView = this.bcG.getText();
        if (textView.length() > 0) {
          if (textView.length() % 5 == 0) {
            this.bcG.setText(textView.subSequence(0, textView.length() - 2));
            return true;
          } 
          this.bcG.setText(textView.subSequence(0, textView.length() - 1));
        } 
      } 
      return true;
    } 
    char c1 = textView.getNumber();
    if (c1 >= '0' && c1 <= '9') {
      if (LE() && textView.getAction() == 0) {
        if (this.bcG.getText().length() % 5 == 4)
          this.bcG.append(" "); 
        textView = this.bcG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c1);
        stringBuilder.append("");
        textView.append(stringBuilder.toString());
      } 
      return true;
    } 
    return super.dispatchKeyEvent(textView);
  }
  
  @Deprecated
  public void show() { super.show(); }
  
  public String xq() { return this.bcU.isEmpty() ? null : this.orderNo; }
  
  public static interface a {
    void LD();
    
    void Z(double param1Double);
  }
  
  private class b implements Runnable {
    cs.e bdg;
    
    private b(cs this$0, cs.e param1e) { this.bdg = param1e; }
    
    public void run() {
      try {
        null = s.fl(cs.e.b(this.bdg));
        JSONObject jSONObject = cs.a(this.bde, null);
        if (jSONObject != null) {
          cs.i(this.bde).remove(this.bdg);
          cs.a(this.bde, true);
          cs.d(this.bde).obtainMessage(11, jSONObject.optString("message")).sendToTarget();
        } 
      } catch (Throwable throwable) {
        a.e(throwable);
        cs.a(this.bde, "未知错误");
      } finally {
        bb bb;
      } 
      cs.d(this.bde).sendEmptyMessage(21);
    }
  }
  
  private class c extends BaseAdapter {
    View.OnClickListener bdh = new dh(this);
    
    private c(cs this$0) {}
    
    public cs.e eQ(int param1Int) { return (cs.e)cs.i(this.bde).get(param1Int); }
    
    public int getCount() { return cs.i(this.bde).size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a2;
      a a1;
      if (param1View == null) {
        a2 = View.inflate(cs.w(this.bde), 2131427834, null);
        null = (TextView)a2.findViewById(2131298241);
        TextView textView = (TextView)a2.findViewById(2131297191);
        View view = a2.findViewById(2131298730);
        view.setOnClickListener(this.bdh);
        a1 = new a(this, null, textView, view);
        a2.setTag(a1);
      } else {
        a a = (a)a1.getTag();
        a2 = a1;
        a1 = a;
      } 
      cs.e e = eQ(param1Int);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1Int + 1);
      stringBuilder.append(":");
      String str = stringBuilder.toString();
      a1.bdj.setText(str);
      a1.bdk.setText(cs.e.d(e));
      a1.bdl.setTag(e);
      return a2;
    }
    
    private class a {
      TextView bdj;
      
      TextView bdk;
      
      View bdl;
      
      public a(cs.c this$0, TextView param2TextView1, TextView param2TextView2, View param2View) {
        this.bdj = param2TextView1;
        this.bdk = param2TextView2;
        this.bdl = param2View;
      }
    }
  }
  
  private class a {
    TextView bdj;
    
    TextView bdk;
    
    View bdl;
    
    public a(cs this$0, TextView param1TextView1, TextView param1TextView2, View param1View) {
      this.bdj = param1TextView1;
      this.bdk = param1TextView2;
      this.bdl = param1View;
    }
  }
  
  private class d {
    private final String bdm;
    
    private final double bdn;
    
    private final double bdo;
    
    private final int bdp;
    
    private final int bdq;
    
    private final String bdr;
    
    private final String title;
    
    private d(cs this$0, String param1String1, String param1String2, double param1Double1, double param1Double2, int param1Int1, int param1Int2, String param1String3) {
      this.title = param1String1;
      this.bdm = param1String2;
      this.bdn = param1Double1;
      this.bdo = param1Double2;
      this.bdp = param1Int1;
      this.bdq = param1Int2;
      this.bdr = param1String3;
    }
  }
  
  private class e {
    private final double bdn;
    
    private final double bdo;
    
    private final String bds;
    
    private final String bdt;
    
    private e(cs this$0, String param1String, double param1Double1, double param1Double2) {
      this.bds = param1String;
      StringBuilder stringBuilder = bv.sa(param1String);
      byte b;
      for (b = 4; b < stringBuilder.length(); b += 5)
        stringBuilder.insert(b, " "); 
      this.bdt = stringBuilder.toString();
      this.bdn = param1Double1;
      this.bdo = param1Double2;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */