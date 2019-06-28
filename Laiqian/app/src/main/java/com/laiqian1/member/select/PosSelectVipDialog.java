package com.laiqian.member.select;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.member.a.n;
import com.laiqian.member.a.o;
import com.laiqian.member.bill.MemberBillActivity;
import com.laiqian.member.bz;
import com.laiqian.member.cb;
import com.laiqian.member.setting.bc;
import com.laiqian.models.l;
import com.laiqian.pos.aw;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.print.cardreader.am;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.bb;
import com.laiqian.ui.a.bc;
import com.laiqian.ui.listview.FormListView;
import com.laiqian.util.av;
import com.laiqian.util.bd;
import com.laiqian.util.bh;
import com.laiqian.util.l;
import com.laiqian.vip.R;
import hugo.weaving.DebugLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class PosSelectVipDialog extends aw {
  TextView aAs;
  
  private boolean aDM;
  
  int aDO = Build.VERSION.SDK_INT;
  
  bz aDP;
  
  Handler aDQ = new i(this);
  
  private boolean aDR = false;
  
  TextView aRl;
  
  private Context aTg;
  
  protected ProgressBarCircularIndeterminate bAA;
  
  private TextView bAB;
  
  private int bAC = 0;
  
  AdapterView.OnItemClickListener bAD = new f(this);
  
  TextWatcher bAE = new g(this);
  
  View.OnClickListener bAF = new h(this);
  
  protected int bAh;
  
  RelativeLayout bAi;
  
  LinearLayout bAj;
  
  TextView bAk;
  
  TextView bAl;
  
  TextView bAm;
  
  TextView bAn;
  
  TextView bAo;
  
  TextView bAp;
  
  protected FormListView bAq;
  
  Button bAr;
  
  UsbCardReceiver bAs;
  
  LinearLayout bAt;
  
  private boolean bAu;
  
  protected boolean bAv;
  
  protected boolean bAw;
  
  protected int bAx;
  
  protected String bAy;
  
  ImageView bAz;
  
  private TextView bsT;
  
  private LinearLayout bti;
  
  ImageView buY;
  
  TextView bvD;
  
  EditText bvb;
  
  protected cb bvf;
  
  TextView bvw;
  
  TextView bwu;
  
  LinearLayout bwx;
  
  protected Button bwy;
  
  private bb mWaitingDialog = null;
  
  private bc mWiFiDialog;
  
  public PosSelectVipDialog(Context paramContext) {
    super(paramContext, R.style.dialog_fullscreen);
    this.aTg = paramContext;
    setContentView(View.inflate(paramContext, R.layout.dialog_select_vip, null));
    this.bvf = new cb();
  }
  
  private boolean checkNetwork() {
    if (!bd.bH(this.mContext)) {
      if (this.mWiFiDialog == null) {
        this.mWiFiDialog = new bc(this.mContext);
        this.mWiFiDialog.setCancelable(false);
      } 
      this.mWiFiDialog.show();
      return false;
    } 
    return true;
  }
  
  private void xV() {
    if (this.bAs == null) {
      this.bAs = new UsbCardReceiver(this);
      if (!this.aDR) {
        this.aDR = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        intentFilter.addAction("com.laiqian.USB_PERMISSION");
        this.mContext.registerReceiver(this.bAs, intentFilter);
      } 
    } 
  }
  
  protected void Ej() {
    if (RootApplication.getLaiqianPreferenceManager().Wq() && !checkNetwork())
      return; 
    String str = this.bvb.getText().toString().trim();
    if (!"".equals(str)) {
      cb cb1 = this.bvf;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("%");
      stringBuilder.append(str);
      stringBuilder.append("%");
      cb1.fC(stringBuilder.toString());
      Rj();
      this.bvb.selectAll();
    } 
  }
  
  protected abstract void Rj();
  
  protected void ct(View paramView) {
    super.ct(paramView);
    this.bvb = (EditText)this.oR.findViewById(R.id.et_query);
    this.bwx = (LinearLayout)this.oR.findViewById(R.id.title_l);
    this.buY = (ImageView)this.oR.findViewById(R.id.iv_create);
    this.bAi = (RelativeLayout)this.oR.findViewById(R.id.ll_vip_info);
    this.bAj = (LinearLayout)this.oR.findViewById(R.id.ll_tips);
    this.bAk = (TextView)this.oR.findViewById(R.id.tip_text_view);
    this.bsT = (TextView)this.oR.findViewById(R.id.member_rank_tv);
    this.bwu = (TextView)this.oR.findViewById(R.id.tv_phone);
    this.bvD = (TextView)this.oR.findViewById(R.id.tv_card_number);
    this.aRl = (TextView)this.oR.findViewById(R.id.tv_name);
    this.aAs = (TextView)this.oR.findViewById(R.id.tv_amount);
    this.bvw = (TextView)this.oR.findViewById(R.id.tv_points);
    this.bAl = (TextView)this.oR.findViewById(R.id.tv_discount);
    this.bAq = (FormListView)this.oR.findViewById(R.id.lv_vip);
    this.bAr = (Button)this.oR.findViewById(R.id.btn_clean);
    this.bAm = (TextView)this.oR.findViewById(R.id.tv_no_data);
    this.bwy = (Button)this.oR.findViewById(R.id.btn_submit);
    this.bAn = (TextView)this.oR.findViewById(R.id.tv_charge);
    this.bAo = (TextView)this.oR.findViewById(R.id.tv_bill);
    this.bAp = (TextView)this.oR.findViewById(R.id.tv_password_manage);
    this.bAt = (LinearLayout)this.oR.findViewById(R.id.ll_charge);
    this.bAA = (ProgressBarCircularIndeterminate)this.oR.findViewById(R.id.progress);
    this.bAz = (ImageView)this.oR.findViewById(R.id.iv_refresh);
    l.a(getWindow(), this.bvb);
    this.bAB = (TextView)this.oR.findViewById(R.id.tv_remark);
    this.bti = (LinearLayout)this.oR.findViewById(R.id.ll_remark);
  }
  
  protected abstract void fE(int paramInt);
  
  protected void fF(int paramInt) {
    this.bAh = paramInt;
    switch (paramInt) {
      default:
        return;
      case 3:
        this.bAj.setVisibility(0);
        this.bAi.setVisibility(8);
        this.bAz.setVisibility(8);
        this.bAq.setVisibility(8);
        this.bAm.setVisibility(8);
        return;
      case 2:
        this.bAj.setVisibility(8);
        this.bAi.setVisibility(8);
        this.bAz.setVisibility(8);
        this.bAq.setVisibility(0);
        this.bAm.setVisibility(8);
        return;
      case 1:
        this.bAj.setVisibility(8);
        this.bAi.setVisibility(0);
        this.bAz.setVisibility(0);
        this.bAq.setVisibility(8);
        this.bAm.setVisibility(8);
        return;
      case 0:
        break;
    } 
    this.bAj.setVisibility(8);
    this.bAi.setVisibility(8);
    this.bAz.setVisibility(8);
    this.bAq.setVisibility(8);
    this.bAm.setVisibility(0);
  }
  
  protected void fG(int paramInt) {
    if (this.bAq.getList().size() > paramInt) {
      CharSequence charSequence;
      this.bAC = paramInt;
      this.aAs.setText((CharSequence)((Map)this.bAq.getList().get(paramInt)).get("fAmount"));
      boolean bool = bc.RH().fW((String)((Map)this.bAq.getList().get(paramInt)).get("nBPartnerType"));
      TextView textView2 = this.bsT;
      if (bool ^ true) {
        charSequence = " ";
      } else {
        charSequence = (CharSequence)((Map)this.bAq.getList().get(paramInt)).get("sBPartnerTypeName");
      } 
      textView2.setText(charSequence);
      this.bwu.setText((CharSequence)((Map)this.bAq.getList().get(paramInt)).get("sContactMobilePhone"));
      this.bvD.setText((CharSequence)((Map)this.bAq.getList().get(paramInt)).get("sNumber"));
      this.aRl.setText((CharSequence)((Map)this.bAq.getList().get(paramInt)).get("sName"));
      TextView textView1 = this.bvw;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Double.valueOf((String)((Map)this.bAq.getList().get(paramInt)).get("fPoints")).intValue());
      stringBuilder.append("");
      textView1.setText(stringBuilder.toString());
      this.bAB.setText((CharSequence)((Map)this.bAq.getList().get(paramInt)).get("sField1"));
    } 
  }
  
  protected void fH(int paramInt) {
    n n;
    if (RootApplication.getLaiqianPreferenceManager().Wq()) {
      n = new o((ActivityRoot)this.aTg, (ActivityRoot)this.aTg);
    } else {
      n = new n(this.mContext, this.aTg);
    } 
    if (this.bAq.getList() != null) {
      String str1;
      if (this.bAq.getList().size() == 0)
        return; 
      String str2 = (String)((Map)this.bAq.getList().get(paramInt)).get("_id");
      String str3 = (String)((Map)this.bAq.getList().get(paramInt)).get("sNumber");
      String str4 = (String)((Map)this.bAq.getList().get(paramInt)).get("sContactMobilePhone");
      String str5 = (String)((Map)this.bAq.getList().get(paramInt)).get("fPoints");
      String str6 = (String)((Map)this.bAq.getList().get(paramInt)).get("fAmount");
      String str7 = (String)((Map)this.bAq.getList().get(paramInt)).get("sName");
      if (((Map)this.bAq.getList().get(paramInt)).containsKey("nBelongShopID")) {
        str1 = (String)((Map)this.bAq.getList().get(paramInt)).get("nBelongShopID");
      } else {
        str1 = RootApplication.getLaiqianPreferenceManager().Tx();
      } 
      n.l(new String[] { str2, str3, str4, str5, str6, str7, str1 });
      this.bvf.fC((String)((Map)this.bAq.getList().get(paramInt)).get("sNumber"));
      n.show();
      this.bAv = true;
      return;
    } 
  }
  
  protected void fI(int paramInt) {
    fF(1);
    fG(paramInt);
  }
  
  @DebugLog
  protected void fJ(int paramInt) {
    if (paramInt < 0 || paramInt >= this.bAq.getList().size()) {
      String str1 = PosSelectVipDialog.class.getSimpleName();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("index out of range: position: ");
      stringBuilder.append(paramInt);
      stringBuilder.append(", size: ");
      stringBuilder.append(this.bAq.getList().size());
      Log.e(str1, stringBuilder.toString());
      return;
    } 
    String str = (String)((Map)this.bAq.getList().get(paramInt)).get("_id");
    MemberBillActivity.start(this.mContext, str);
  }
  
  public void fT(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      cb cb1 = this.bvf;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("%");
      stringBuilder.append(paramString);
      stringBuilder.append("%");
      cb1.fC(stringBuilder.toString());
    } 
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getRepeatCount() > 0)
      return false; 
    if (paramInt == 4 && paramKeyEvent.getRepeatCount() == 0) {
      this.bwx.performClick();
      return false;
    } 
    return false;
  }
  
  protected void onStart() {
    super.onStart();
    this.aDQ = new j(this);
    boolean bool = true;
    this.bAw = true;
    int i = am.ba(this.mContext).afs().size();
    if (i == 0) {
      this.bvb.setHint(this.mContext.getString(R.string.pos_search_number_or_phone));
    } else if (i > 0) {
      this.bvb.setHint(this.mContext.getString(R.string.pos_member_read_card_mobile));
    } 
    if (this.aDO >= 12)
      bool = false; 
    this.aDM = bool;
    if (this.bvf.Qy() == null)
      this.bvf.fC(""); 
    this.bvf.fD(" sName ");
    this.bvb.requestFocus();
    this.bvb.setText(this.bvf.Qy().replaceAll("\\%", ""));
    if (!"".equals(this.bvf.Qy())) {
      Rj();
      this.bvb.selectAll();
      return;
    } 
    fF(3);
  }
  
  protected void onStop() {
    if (!this.aDM && this.bAs != null)
      try {
        if (this.aDR) {
          this.aDR = false;
          this.mContext.unregisterReceiver(this.bAs);
        } 
        this.bAs = null;
      } catch (Exception exception) {
        a.e(exception);
      }  
    if (this.aDP != null)
      this.aDP.stop(); 
    if (this.aDQ != null)
      this.aDQ = null; 
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      if (!this.aDM)
        xV(); 
      this.aDQ = new a(this);
      bz bz1;
      if ((bz1 = this.aDP).aE(this.mContext)) {
        this.aDP = bz.Qw();
        this.aDP.a(this.mContext, 500L, this.aDQ);
        this.aDP.start();
      } 
    } else if (!this.aDM && this.bAs != null) {
      try {
        if (this.aDR) {
          this.aDR = false;
          this.mContext.unregisterReceiver(this.bAs);
        } 
        this.bAs = null;
      } catch (Exception exception) {
        a.e(exception);
      } 
    } 
    av av = new av(this.mContext);
    boolean bool1 = av.aux();
    boolean bool2 = av.auy();
    if (paramBoolean && this.bAv && bool1) {
      av.hA(false);
      this.bvb.setText(this.bvf.Qy().replaceAll("\\%", ""));
      Rj();
      this.bAx = 0;
      this.bvb.selectAll();
      this.bAv = false;
      this.cge.OV();
    } 
    if (paramBoolean && this.bAu && bool2) {
      fF(1);
      this.bvb.setText("");
      this.bvf.fC(av.auz());
      Rj();
      this.bAx = 0;
      av.hB(false);
      this.bAu = false;
      this.cge.OV();
    } 
    av.close();
  }
  
  public void show() {
    try {
      int i;
      super.show();
      boolean bool = a.AZ().Bw();
      eO(bool ^ true);
      TextView textView = this.bAk;
      if (bool) {
        i = R.string.pos_vip_card_aside_tips;
      } else {
        i = R.string.pos_vip_query_tips;
      } 
      textView.setText(i);
      EditText editText = this.bvb;
      if (bool) {
        i = R.string.pos_member_read_card_mobile;
      } else {
        i = R.string.pos_search_number_or_phone;
      } 
      editText.setHint(i);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  protected void xU() {
    super.xU();
    f(this.bvb);
    int i = RootApplication.getLaiqianPreferenceManager().avL();
    if (i == 1)
      this.buY.setVisibility(8); 
    this.bAz.setOnClickListener(new k(this));
    this.buY.setOnClickListener(new l(this));
    this.bAr.setOnClickListener(new m(this));
    this.bvb.addTextChangedListener(this.bAE);
    this.bvb.setOnKeyListener(new n(this));
    this.bAq.setOnItemClickListener(this.bAD);
    this.bwy.setOnClickListener(this.bAF);
    this.bwx.setOnClickListener(new o(this));
    this.bAn.setOnClickListener(new p(this));
    this.bAo.setOnClickListener(new q(this));
    if (i == 1)
      this.bAp.setVisibility(8); 
    this.bAp.setOnClickListener(new b(this));
  }
  
  public class UsbCardReceiver extends BroadcastReceiver {
    public UsbCardReceiver(PosSelectVipDialog this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      String str = param1Intent.getAction();
      if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(str)) {
        bz bz;
        if ((bz = this.bAG.aDP).aE(PosSelectVipDialog.f(this.bAG)))
          if (this.bAG.bvb.hasFocus()) {
            this.bAG.aDP = bz.Qw();
            this.bAG.aDP.a(PosSelectVipDialog.g(this.bAG), 500L, this.bAG.aDQ);
            this.bAG.aDP.start();
          } else if (this.bAG.aDP != null) {
            this.bAG.aDP.stop();
          }  
      } 
      if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(str)) {
        bz bz;
        if ((!(bz = this.bAG.aDP).aE(PosSelectVipDialog.h(this.bAG)) || !this.bAG.bvb.hasFocus()) && this.bAG.aDP != null)
          this.bAG.aDP.stop(); 
      } 
    }
  }
  
  private class a extends AsyncTask<String, Void, Boolean> {
    boolean aGq = false;
    
    private String aGr = "";
    
    private String bAJ;
    
    private a(PosSelectVipDialog this$0) {}
    
    private boolean N(String param1String1, String param1String2) {
      boolean bool;
      try {
        bool = Integer.valueOf(param1String2).intValue();
      } catch (NumberFormatException param1String2) {
        a.e(param1String2);
        bool = false;
      } 
      try {
        JSONObject jSONObject = new JSONObject(param1String1);
        if ("TRUE".equals(jSONObject.optString("result", "FALSE"))) {
          jSONObject = jSONObject.getJSONObject("message");
          int i = jSONObject.optInt("nUpdateFlag");
          this.bAJ = jSONObject.optString("bIsActive");
          if (i > bool) {
            l l = new l(PosSelectVipDialog.p(this.bAG));
            boolean bool1 = l.g(jSONObject);
            l.close();
            if (bool1)
              return true; 
          } else {
            return false;
          } 
        } else {
          this.aGr = jSONObject.optString("msg_no", "");
          return false;
        } 
      } catch (JSONException param1String1) {
        a.e(param1String1);
        return false;
      } catch (Exception param1String1) {
        a.e(param1String1);
        return false;
      } 
      return false;
    }
    
    protected void b(Boolean param1Boolean) {
      if (param1Boolean.booleanValue()) {
        this.bAG.Rj();
        if (this.bAJ.equals("N")) {
          Toast.makeText(PosSelectVipDialog.l(this.bAG), PosSelectVipDialog.m(this.bAG).getString(R.string.member_not_active), 0).show();
        } else {
          this.bAG.fI(this.bAG.bAx);
        } 
      } else if ("-1".equals(this.aGr)) {
        Toast.makeText(PosSelectVipDialog.n(this.bAG), PosSelectVipDialog.o(this.bAG).getString(R.string.member_not_found), 0).show();
      } 
      if (PosSelectVipDialog.j(this.bAG) != null)
        PosSelectVipDialog.j(this.bAG).cancel(); 
    }
    
    protected Boolean e(String... param1VarArgs) {
      if (this.aGq) {
        av av = new av(PosSelectVipDialog.q(this.bAG));
        String str1 = av.Ea();
        String str2 = av.atr();
        String str3 = av.Tx();
        av.close();
        HashMap hashMap = new HashMap();
        hashMap.put("user_name", str1);
        hashMap.put("password", str2);
        hashMap.put("auth_type", "0");
        hashMap.put("shop_id", str3);
        hashMap.put("version", "1.1");
        hashMap.put("member_id", param1VarArgs[0]);
        str1 = bh.a(RootUrlParameter.ckE, PosSelectVipDialog.r(this.bAG), hashMap, 10000);
        if (!TextUtils.isEmpty(str1))
          return Boolean.valueOf(N(str1, param1VarArgs[1])); 
      } 
      return Boolean.valueOf(false);
    }
    
    protected void onPreExecute() {
      this.aGq = PosSelectVipDialog.i(this.bAG);
      if (this.aGq) {
        if (PosSelectVipDialog.j(this.bAG) == null) {
          PosSelectVipDialog.a(this.bAG, new bb(PosSelectVipDialog.k(this.bAG)));
          PosSelectVipDialog.j(this.bAG).setCancelable(false);
        } 
        PosSelectVipDialog.j(this.bAG).show();
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\PosSelectVipDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */