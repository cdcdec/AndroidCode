package com.laiqian.member;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.member.b.a;
import com.laiqian.member.create.VipCreateDialog;
import com.laiqian.models.l;
import com.laiqian.pos.s;
import com.laiqian.print.cardreader.am;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ProgressBarCircularIndeterminate;
import com.laiqian.ui.a.m;
import com.laiqian.ui.a.w;
import com.laiqian.ui.listview.FormListView;
import com.laiqian.ui.listview.e;
import com.laiqian.util.ae;
import com.laiqian.util.bd;
import com.laiqian.util.ck;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import hugo.weaving.DebugLog;
import java.util.ArrayList;

@DebugLog
public class MemberListActivity extends ActivityRoot implements by {
  private boolean aDM;
  
  int aDO = Build.VERSION.SDK_INT;
  
  bz aDP;
  
  Handler aDQ = new bj(this);
  
  private w aNu;
  
  ProgressBarCircularIndeterminate aNv;
  
  private PopupWindow bgL;
  
  FormListView.c bqR = new bk(this);
  
  private e bqq;
  
  int bsR;
  
  FormListView buS;
  
  private View[] buT;
  
  private TextView buU;
  
  private RelativeLayout buV;
  
  private RelativeLayout buW;
  
  private ImageView buX;
  
  private ImageView buY;
  
  private ImageView buZ;
  
  private View bud;
  
  AdapterView.OnItemClickListener but = new ba(this);
  
  private ImageView bva;
  
  private EditText bvb;
  
  private View bvc;
  
  private TextView bvd;
  
  private TextView bve;
  
  private cb bvf;
  
  private LinearLayout bvg;
  
  private UsbCardReceiver bvh;
  
  private TextView bvi;
  
  private TextView bvj;
  
  private PopupWindow bvk;
  
  private TextView bvl;
  
  VipCreateDialog bvm;
  
  BroadcastReceiver bvn;
  
  private bs bvo;
  
  boolean bvp;
  
  private int bvq = 0;
  
  private boolean bvr;
  
  View.OnFocusChangeListener bvs = new aw(this);
  
  private int scrollY;
  
  private void KZ() {
    this.bvn = new MemberChangeReceiver(this);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction(a.bwV);
    registerReceiver(this.bvn, intentFilter);
  }
  
  private void Qf() {
    setupViews();
    Pz();
    Qg();
  }
  
  private void Qi() {
    LinearLayout linearLayout = (LinearLayout)LayoutInflater.from(this).inflate(R.layout.pos_member_listview_item_head, null);
    this.buS.setHead(linearLayout);
    cs(linearLayout);
  }
  
  private void Qk() {
    this.bvo.Qt().show();
    s s = new s(getActivity(), 3);
    s.b(new bi(this));
    s.Zw();
  }
  
  private void Ql() {
    String str = this.bvj.getText().toString().trim();
    if (str.length() == 0) {
      this.bvl.setText(R.string.pos_report_export_mail_no_input);
      return;
    } 
    if (!bd.bH(this)) {
      this.bvl.setText(R.string.pos_report_export_mail_no_network);
      if (RootApplication.getLaiqianPreferenceManager().Wq())
        this.bvo.Qt().cancel(); 
      return;
    } 
    this.bvl.setText(null);
    if (!RootApplication.getLaiqianPreferenceManager().Wq())
      this.bvo.Qt().show(); 
    bs bs1 = this.bvo;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(this.bvi.getText().toString());
    bs1.fA(stringBuilder.toString());
  }
  
  private void bO(View paramView) {
    if (this.bgL == null) {
      View view = View.inflate(this, R.layout.import_export_menu, null);
      ((Button)view.findViewById(R.id.btn_import)).setOnClickListener(new bb(this));
      ((Button)view.findViewById(R.id.btn_export)).setOnClickListener(new bc(this));
      this.bgL = new PopupWindow(view, -2, -2, true);
      this.bgL.setBackgroundDrawable(new ColorDrawable(false));
      this.bgL.setAnimationStyle(R.style.PopupAnimation);
    } 
    Rect rect = new Rect();
    paramView.getGlobalVisibleRect(rect);
    int i = rect.right;
    i = rect.top;
    this.bgL.showAsDropDown(paramView, ae.b(this, -130.0F), ae.b(this, -60.0F));
  }
  
  private void cs(View paramView) {
    ay ay = new ay(this);
    View view1 = paramView.findViewById(R.id.name_sort_up);
    view1.setTag(" sName ");
    View view2 = paramView.findViewById(R.id.name_sort_down);
    view2.setTag(" sName desc");
    View view3 = paramView.findViewById(R.id.rl_member_name);
    view3.setTag(new View[] { view1, view2 });
    view3.setOnClickListener(ay);
    view3 = paramView.findViewById(R.id.member_card_sort_up);
    view3.setTag(" sNumber ");
    View view4 = paramView.findViewById(R.id.card_sort_down);
    view4.setTag(" sNumber desc");
    View view5 = paramView.findViewById(R.id.rl_card);
    view5.setTag(new View[] { view3, view4 });
    view5.setOnClickListener(ay);
    view5 = paramView.findViewById(R.id.birthday_sort_up);
    view5.setTag(" CAST(ifnull(month ,'0') AS SIGNED integer) ,CAST(ifnull(day ,'0') AS SIGNED integer),_id ");
    View view6 = paramView.findViewById(R.id.birthday_sort_down);
    view6.setTag("CAST(ifnull(month ,'0') AS SIGNED integer) desc,CAST(ifnull(day ,'0') AS SIGNED integer)  desc,_id desc");
    View view7 = paramView.findViewById(R.id.rl_birthday);
    view7.setTag(new View[] { view5, view6 });
    view7.setOnClickListener(ay);
    view7 = paramView.findViewById(R.id.total_sort_up);
    view7.setTag(" fSpareField1 ");
    View view8 = paramView.findViewById(R.id.total_sort_down);
    view8.setTag(" fSpareField1 desc ");
    View view9 = paramView.findViewById(R.id.rl_total_consume);
    view9.setTag(new View[] { view7, view8 });
    view9.setOnClickListener(ay);
    view9 = paramView.findViewById(R.id.times_sort_up);
    view9.setTag(" nSpareField2 ");
    View view10 = paramView.findViewById(R.id.times_sort_down);
    view10.setTag("  nSpareField2 desc ");
    View view11 = paramView.findViewById(R.id.rl_consume_times);
    view11.setTag(new View[] { view9, view10 });
    view11.setOnClickListener(ay);
    View view12 = paramView.findViewById(R.id.latest_sort_up);
    view12.setTag("  nConsumeTime ");
    view11 = paramView.findViewById(R.id.latest_sort_down);
    view11.setTag("  nConsumeTime desc ");
    View view13 = paramView.findViewById(R.id.rl_latest_consume);
    view13.setTag(new View[] { view12, view11 });
    view13.setOnClickListener(ay);
    view13 = paramView.findViewById(R.id.balance_sort_up);
    view13.setTag("  fAmount ");
    View view14 = paramView.findViewById(R.id.balance_sort_down);
    view14.setTag("  fAmount desc ");
    View view15 = paramView.findViewById(R.id.rl_balance);
    view15.setTag(new View[] { view13, view14 });
    view15.setOnClickListener(ay);
    view15 = paramView.findViewById(R.id.point_sort_up);
    view15.setTag("  fPoints ");
    View view16 = paramView.findViewById(R.id.point_sort_down);
    view16.setTag("  fPoints desc ");
    paramView = paramView.findViewById(R.id.rl_points);
    paramView.setTag(new View[] { view15, view16 });
    paramView.setOnClickListener(ay);
    this.buT = new View[] { 
        view1, view2, view7, view3, view4, view5, view6, view8, view9, view10, 
        view12, view11, view13, view14, view15, view16 };
    az az = new az(this);
    for (byte b = 0; b < this.buT.length; b++)
      this.buT[b].setOnClickListener(az); 
    view11.setSelected(true);
    this.bvf.fD((String)view11.getTag());
    this.bvf.fC("%%");
    this.buS.clearList();
  }
  
  private void initView() {
    this.buS = (FormListView)findViewById(R.id.lv_member);
    this.buV = (RelativeLayout)findViewById(R.id.rl_member_menu);
    this.buW = (RelativeLayout)findViewById(R.id.rl_member_query);
    this.bva = (ImageView)findViewById(R.id.refresh_iv);
    this.buX = (ImageView)findViewById(R.id.iv_query);
    this.buY = (ImageView)findViewById(R.id.iv_create);
    this.buZ = (ImageView)findViewById(R.id.iv_export);
    this.bvb = (EditText)findViewById(R.id.et_query);
    this.bvc = findViewById(R.id.v_clean);
    this.bvd = (TextView)findViewById(R.id.tv_cancel);
    this.bve = (TextView)findViewById(R.id.tvNoMemberData);
    this.bvg = (LinearLayout)findViewById(R.id.ll_blank_views);
    this.bud = findViewById(R.id.first_blank_item);
    this.buU = (TextView)findViewById(R.id.member_quantity);
    this.aNv = (ProgressBarCircularIndeterminate)findViewById(R.id.progress);
    int i = RootApplication.getLaiqianPreferenceManager().avL();
    if (!a.zR().Am() || !"150001".equals(RootApplication.getLaiqianPreferenceManager().atp()) || RootApplication.getLaiqianPreferenceManager().QV() == 1 || i == 1 || i == 2)
      this.buZ.setVisibility(8); 
  }
  
  private void setupViews() {
    this.bsR = am.ba(this).afs().size();
    if (this.bsR == 0) {
      this.bvb.setHint(R.string.pos_search_number_or_phone);
      return;
    } 
    if (this.bsR > 0)
      this.bvb.setHint(getString(R.string.pos_member_read_card_mobile)); 
  }
  
  private void xV() {
    this.bvh = new UsbCardReceiver(this);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    intentFilter.addAction("com.laiqian.USB_PERMISSION");
    registerReceiver(this.bvh, intentFilter);
  }
  
  private void xa() {
    if (RootApplication.getLaiqianPreferenceManager().Wq()) {
      this.buS.setOnLoadListener(this.bqR);
      this.buS.hideFooterView();
    } 
    this.buS.setOnAfterLoadListener(new bl(this));
    this.bva.setOnClickListener(new bn(this));
    this.buX.setOnClickListener(new bo(this));
    this.buZ.setOnClickListener(new bp(this));
    this.buY.setOnClickListener(new bq(this));
    this.bvb.setOnFocusChangeListener(this.bvs);
    this.bvb.addTextChangedListener(new at(this));
    this.bvc.setOnClickListener(new au(this));
    this.bvd.setOnClickListener(new av(this));
    this.buS.setOnItemClickListener(this.but);
  }
  
  public void Pz() {
    Log.e("setupListViewItem", "setupListViewItem");
    this.aNv.setVisibility(0);
    try {
      exception = new l(this);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    String str = exception.hm(this.bvf.Qz());
    String[] arrayOfString1 = exception.hn(this.bvf.Qy());
    String[] arrayOfString2 = new String[3];
    System.arraycopy(arrayOfString1, 1, arrayOfString2, 0, 3);
    this.buS.initData();
    if (ck.mk(this.buS.getList().size())) {
      this.bud.setVisibility(8);
    } else {
      this.bud.setVisibility(0);
    } 
    if (this.bqq == null) {
      this.bqq = new ax(this, this, this.buS.getList(), this.buS);
    } else {
      this.bqq.m(this.buS.getList());
    } 
    this.buS.setAdapter(this.bqq);
    this.buS.setData(this, str, arrayOfString2, new String[] { "sNumber", "sContactMobilePhone", "fAmount", "sName", "sSpareField1", "fPoints", "nSpareField2", "fSpareField1", "nConsumeTime" });
    exception.close();
  }
  
  public void Qg() {
    int i = RootApplication.getLaiqianPreferenceManager().avL();
    if (i != 1 && i != 2)
      this.bvo.Qp(); 
  }
  
  public ArrayList<String> Qh() { return n.a(this, true); }
  
  public void Qj() {
    int i;
    View view = View.inflate(this, R.layout.pos_export_mail, null);
    this.bvj = (TextView)view.findViewById(R.id.address);
    this.bvi = (TextView)view.findViewById(R.id.domain);
    null = getResources();
    if (getResources().getBoolean(R.bool.is_ShowingIndustry)) {
      i = R.array.pos_mail_address;
    } else {
      i = R.array.pos_mail_address_foreign;
    } 
    String[] arrayOfString1 = null.getStringArray(i);
    String[] arrayOfString2 = getLaiqianPreferenceManager().auT();
    if (arrayOfString2 != null) {
      this.bvj.setText(arrayOfString2[0]);
      this.bvi.setText(arrayOfString2[1]);
      view.requestFocus();
    } else {
      this.bvj.setText("");
      this.bvj.requestFocus();
      this.bvi.setText(arrayOfString1[0]);
      n.b(this, this.bvj);
    } 
    this.aNu = new w(this, arrayOfString1, new be(this, arrayOfString1));
    this.bvi.setOnClickListener(new bf(this));
    this.bvk = new PopupWindow(view, -2, -2, true);
    this.bvk.setBackgroundDrawable(new ColorDrawable());
    this.bvk.setOutsideTouchable(true);
    this.bvl = (TextView)view.findViewById(R.id.tvError);
    view.findViewById(R.id.send).setOnClickListener(new bg(this));
    view.findViewById(R.id.canal).setOnClickListener(new bh(this));
  }
  
  public PopupWindow Qm() { return this.bvk; }
  
  public m Qn() { return new m(this, false); }
  
  public void dF(boolean paramBoolean) {
    byte b;
    TextView textView = this.buU;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    textView.setVisibility(b);
  }
  
  public void fv(String paramString) { runOnUiThread(new as(this, paramString)); }
  
  public void fw(String paramString) { this.bvl.setText(paramString); }
  
  public void k(String[] paramArrayOfString) {
    int i = RootApplication.getLaiqianPreferenceManager().avL();
    if (i != 1) {
      if (i == 2)
        return; 
      runOnUiThread(new bd(this, paramArrayOfString));
      return;
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    boolean bool;
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.activity_member_list);
    getWindow().setFeatureInt(7, R.layout.title_member_list);
    initView();
    xa();
    this.bvf = new cb();
    Qi();
    if (this.aDO < 12) {
      bool = true;
    } else {
      bool = false;
    } 
    this.aDM = bool;
    if (!this.aDM)
      xV(); 
    int i = RootApplication.getLaiqianPreferenceManager().avL();
    if (i == 1 || i == 2) {
      findViewById(R.id.member_quantity).setVisibility(8);
      findViewById(R.id.iv_create).setVisibility(8);
    } 
    this.bvo = new bs(this, this);
    this.bvo.init();
    KZ();
    Qf();
  }
  
  protected void onDestroy() {
    if (!this.aDM)
      unregisterReceiver(this.bvh); 
    if (this.bvn != null)
      unregisterReceiver(this.bvn); 
    super.onDestroy();
  }
  
  protected void onPause() {
    super.onPause();
    this.buS.closeDB();
    if (this.aDP != null)
      this.aDP.stop(); 
  }
  
  protected void onResume() {
    super.onResume();
    Qf();
  }
  
  public class MemberChangeReceiver extends BroadcastReceiver {
    public MemberChangeReceiver(MemberListActivity this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      String str = param1Intent.getAction();
      MemberListActivity.a(this.bvu, param1Intent.getBooleanExtra("isEditMember", false));
      if (a.bwV.equals(str))
        this.bvu.bvp = true; 
    }
  }
  
  public class UsbCardReceiver extends BroadcastReceiver {
    public UsbCardReceiver(MemberListActivity this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      String str = param1Intent.getAction();
      if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(str)) {
        bz bz;
        if ((bz = this.bvu.aDP).aE(this.bvu))
          if (MemberListActivity.b(this.bvu).hasFocus()) {
            this.bvu.aDP = bz.Qw();
            this.bvu.aDP.a(this.bvu, 500L, this.bvu.aDQ);
            this.bvu.aDP.start();
          } else if (this.bvu.aDP != null) {
            this.bvu.aDP.stop();
          }  
      } 
      if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(str)) {
        bz bz;
        if ((!(bz = this.bvu.aDP).aE(this.bvu) || !MemberListActivity.b(this.bvu).hasFocus()) && this.bvu.aDP != null)
          this.bvu.aDP.stop(); 
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\MemberListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */