package com.laiqian.member;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.basic.RootApplication;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.entity.aq;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.aj;
import com.laiqian.ui.a.be;
import com.laiqian.ui.a.w;
import com.laiqian.ui.listview.FormListView;
import com.laiqian.ui.listview.e;
import com.laiqian.util.by;
import com.laiqian.util.ck;
import com.laiqian.util.n;
import com.laiqian.util.z;
import com.laiqian.vip.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MemberInfoActivity extends ActivityRoot implements ar {
  private static final String TAG = "MemberInfoActivity";
  
  FormListView.c bqR = new af(this);
  
  private Button bqY;
  
  private FormListView bqp;
  
  private e bqq;
  
  private TextView bsz;
  
  private TextView btC;
  
  private TextView btD;
  
  private TextView btE;
  
  private TextView btF;
  
  private TextView btG;
  
  private TextView btH;
  
  private TextView btI;
  
  private TextView btJ;
  
  private TextView btK;
  
  private TextView btL;
  
  private TextView btM;
  
  private TextView btN;
  
  private TextView btO;
  
  private LinearLayout btP;
  
  private LinearLayout btQ;
  
  private TextView btR;
  
  protected TextView btS;
  
  protected RelativeLayout btT;
  
  String btU;
  
  private Button btV;
  
  private Button btW;
  
  private int btX;
  
  w btY;
  
  w btZ;
  
  w bua;
  
  w bub;
  
  be buc;
  
  private View bud;
  
  private aj bue;
  
  private LinearLayout bug;
  
  private TextView buh;
  
  private Calendar bui;
  
  private LinearLayout buj;
  
  private ap buk;
  
  String[] bul;
  
  boolean bum = false;
  
  private long bun;
  
  private String buo;
  
  private boolean bup = true;
  
  private TextView buq;
  
  private View bur;
  
  Handler bus = new Handler(new ag(this));
  
  AdapterView.OnItemClickListener but = new ah(this);
  
  static  {
  
  }
  
  private void PQ() { (new Handler()).post(new v(this)); }
  
  private void PR() {}
  
  private void PS() {
    if (this.bub != null)
      return; 
    this.bub = new w(this, this.buk.PW(), new ad(this));
    this.bub.gn(0);
  }
  
  private void Pz() {
    this.buk.Qc();
    this.bqp.initData();
    if (ck.ml(this.bqp.getList().size())) {
      this.bud.setVisibility(8);
    } else {
      this.bud.setVisibility(0);
    } 
    if (this.bqq == null) {
      this.bqq = new ae(this, this, this.bqp.getList(), this.bqp);
    } else {
      this.bqq.m(this.bqp.getList());
    } 
    this.bqp.setAdapter(this.bqq);
    FormListView formListView = this.bqp;
    String str = this.buk.Qd();
    String[] arrayOfString1 = this.buk.Qe();
    String[] arrayOfString2 = this.buk.Fu();
    formListView.setData(this, str, arrayOfString1, new String[] { "nOperationTime", "fChargeAmount", "nChargeType", "fOldAmount", "fNewAmount", "points", "nSpareField2", "nSpareField3", "sText" }, arrayOfString2);
    this.bul = this.buk.Qe();
    this.buk.closeDB();
  }
  
  @Size
  private long[] aB(long paramLong) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(paramLong);
    int i = calendar.get(1);
    int j = calendar.get(2);
    long[] arrayOfLong = b.aW(i, j);
    paramLong = arrayOfLong[0];
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("startTime--YEAR-->");
    stringBuilder2.append(i);
    stringBuilder2.append("--MONTH-->");
    stringBuilder2.append(j);
    stringBuilder2.append("-millis->");
    stringBuilder2.append(paramLong);
    b.ct(stringBuilder2.toString());
    long l = arrayOfLong[1];
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("endTime--YEAR-->");
    stringBuilder1.append(i);
    stringBuilder1.append("--MONTH-->");
    stringBuilder1.append(j);
    stringBuilder1.append("-millis->");
    stringBuilder1.append(l);
    b.ct(stringBuilder1.toString());
    return new long[] { paramLong, l };
  }
  
  private void initView() {
    this.btC = (TextView)findViewById(R.id.tvMemberLevel);
    this.btD = (TextView)findViewById(R.id.tvMemberCardNumber);
    this.btE = (TextView)findViewById(R.id.tvMemberPoints);
    this.btF = (TextView)findViewById(R.id.tvPosMemberName);
    this.btG = (TextView)findViewById(R.id.tvPosMemberMobile);
    this.bsz = (TextView)findViewById(R.id.tvPosMemberBirthday);
    this.btH = (TextView)findViewById(R.id.tvMemberStatus);
    this.btK = (TextView)findViewById(R.id.tvMemberAmount);
    this.btI = (TextView)findViewById(R.id.tvPosMemberCreateTime);
    this.btJ = (TextView)findViewById(R.id.tvPosMemberEndTime);
    this.bqp = (FormListView)findViewById(R.id.lvReport);
    LinearLayout linearLayout = (LinearLayout)LayoutInflater.from(this).inflate(R.layout.pos_member_report_head, null);
    this.btL = (TextView)linearLayout.findViewById(R.id.tvReportType);
    this.btM = (TextView)linearLayout.findViewById(R.id.tvTotalConsumeAmount);
    this.btN = (TextView)linearLayout.findViewById(R.id.tv_total_gift_amount);
    this.btO = (TextView)linearLayout.findViewById(R.id.tvTotalChargeAmount);
    this.btP = (LinearLayout)linearLayout.findViewById(R.id.llReportType);
    this.bug = (LinearLayout)linearLayout.findViewById(R.id.ll_dg_time);
    this.buh = (TextView)this.bug.findViewById(R.id.tv_time);
    this.bui = Calendar.getInstance();
    Date date = this.bui.getTime();
    String str = (new SimpleDateFormat("yyyy-MM")).format(date);
    this.buh.setText(str);
    this.buh.setTag(Long.valueOf(this.bui.getTimeInMillis()));
    this.buj = (LinearLayout)linearLayout.findViewById(R.id.llChargeType);
    this.btQ = (LinearLayout)linearLayout.findViewById(R.id.llChildType);
    this.btR = (TextView)linearLayout.findViewById(R.id.tvReportChildType);
    this.bqp.addHeaderView(linearLayout);
    this.btW = (Button)findViewById(R.id.ui_titlebar_help_btn);
    this.btV = (Button)findViewById(R.id.ui_titlebar_help_btn2);
    this.bqY = (Button)findViewById(R.id.ui_titlebar_help_btn3);
    this.bqY.setText(R.string.vip_print);
    this.bur = findViewById(R.id.ll_remark);
    if (RootApplication.getLaiqianPreferenceManager().QV() == 1 || n.bL(this))
      this.bqY.setVisibility(8); 
    int i = RootApplication.getLaiqianPreferenceManager().avL();
    if (i != 1 && i != 2) {
      this.btV.setVisibility(0);
      this.btV.setText(getString(R.string.pos_vip_edit));
    } 
    this.btS = (TextView)findViewById(R.id.tvNoData);
    this.btT = (RelativeLayout)findViewById(R.id.rlNoData);
    this.bud = findViewById(R.id.first_blank_item);
    this.btW.setText(getString(R.string.member_bill));
    this.buq = (TextView)findViewById(R.id.tvMemberMark);
  }
  
  private void xa() {
    if (RootApplication.getLaiqianPreferenceManager().Wq())
      this.bqp.setOnLoadListener(this.bqR); 
    ai ai = new ai(this);
    this.bqY.setOnClickListener(new aj(this, ai));
    this.bqp.setOnAfterLoadListener(new ak(this));
    this.bqp.setOnItemClickListener(this.but);
    this.btW.setOnClickListener(new al(this));
    this.btV.setOnClickListener(new am(this));
    this.bug.setOnClickListener(new an(this));
    this.btP.setOnClickListener(new x(this));
    this.btQ.setOnClickListener(new z(this));
  }
  
  public void l(aq paramaq) {
    int i;
    if (paramaq == null) {
      this.btV.setEnabled(false);
      this.btW.setEnabled(false);
      return;
    } 
    this.btC.setText(paramaq.aWx);
    this.btK.setText(by.a(by.sd(String.valueOf(paramaq.aWo)), 9999, this));
    TextView textView = this.btD;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aWn);
    stringBuilder.append("");
    textView.setText(by.I(stringBuilder.toString(), 11));
    this.btE.setText(String.valueOf(paramaq.aWp));
    textView = this.btH;
    if ("0".equals(paramaq.aVw) || "380001".equals(paramaq.aVw)) {
      i = R.string.pos_member_card_in_use;
    } else {
      i = R.string.pos_member_card_in_lock;
    } 
    textView.setText(getString(i));
    this.bsz.setText(paramaq.getBirthday());
    this.btF.setText(by.J(paramaq.name, 12));
    textView = this.btG;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aTp);
    stringBuilder.append("");
    textView.setText(by.G(stringBuilder.toString(), 11));
    textView = this.btI;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramaq.aVq);
    stringBuilder.append("");
    textView.setText(z.bh(stringBuilder.toString(), getString(R.string.pos_pos_SimpleDateFormatDay)));
    this.btL.setText(this.buk.PU()[0]);
    this.btJ.setText(paramaq.av(Long.parseLong(paramaq.aWs)));
    this.buq.setText(paramaq.aJX);
    if (this.bup)
      PQ(); 
    ((TextView)findViewById(R.id.ui_titlebar_txt)).setText(getString(R.string.pos_member_info));
    Pz();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.activity_member_info);
    getWindow().setFeatureInt(7, R.layout.member_info_titlebar);
    initView();
    xa();
    this.buk = new ap(this, this);
    paramBundle = getIntent().getExtras();
    this.bun = paramBundle.getLong("id");
    this.buo = paramBundle.getString("nBelongShopID");
  }
  
  protected void onDestroy() { super.onDestroy(); }
  
  protected void onPause() {
    super.onPause();
    this.bqp.closeDB();
  }
  
  protected void onResume() {
    super.onResume();
    this.buk.a(this.bun, this.buo, aB(System.currentTimeMillis()));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\MemberInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */