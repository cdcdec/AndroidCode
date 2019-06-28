package com.laiqian.version.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.UiThread;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.basic.LQKVersion;
import com.laiqian.infrastructure.R;
import com.laiqian.ui.a.ab;
import com.laiqian.util.ch;
import com.laiqian.version.a.f.a;
import com.laiqian.version.a.f.b;
import com.laiqian.version.a.f.d;
import com.laiqian.version.b.d;
import com.laiqian.version.c.a;
import com.laiqian.version.d.g;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UpgradeAndEvaluationActivity extends LegacyUpgradeAndEvaluate {
  public static final String TAG = "com.laiqian.version.view.UpgradeAndEvaluationActivity";
  
  boolean cgE = true;
  
  private g dKm;
  
  private TextView dKn;
  
  private Button dKo;
  
  private TextView dKp;
  
  private ListView dKq;
  
  private View dKr;
  
  private TextView dKs;
  
  private Button dKt;
  
  private TextView dKu;
  
  private ListView dKv;
  
  private View dKw;
  
  int dKx = 1;
  
  boolean dKy = false;
  
  static  {
  
  }
  
  private void E(String paramString, boolean paramBoolean) {
    if (paramString == null) {
      Log.e(TAG, "error");
      return;
    } 
    Log.e(TAG, paramString);
    if (paramBoolean)
      sq(paramString); 
  }
  
  @UiThread
  private void a(ListView paramListView, d paramd, String paramString) {
    TextView textView = (TextView)LayoutInflater.from(this).inflate(R.layout.version_topic_footer, null);
    FrameLayout frameLayout = new FrameLayout(this);
    frameLayout.addView(textView);
    paramListView.addFooterView(frameLayout);
    textView.setOnClickListener(new t(this, paramd, textView, paramString));
  }
  
  private void a(b paramb, ListView paramListView, a parama) {
    List list = paramb.dIQ;
    int i = paramb.dIL;
    StringBuilder stringBuilder1 = new ArrayList();
    Iterator iterator = list.iterator();
    while (iterator.hasNext())
      stringBuilder1.addAll(((a)iterator.next()).dIM); 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("");
    stringBuilder2.append(paramb.version);
    d d = new d(this, stringBuilder1, parama, stringBuilder2.toString(), list.size());
    if (stringBuilder1.size() > 3) {
      paramListView.setAdapter(d);
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("");
      stringBuilder1.append(paramb.version);
      a(paramListView, d, stringBuilder1.toString());
      return;
    } 
    if (stringBuilder1.size() > 0) {
      paramListView.setAdapter(d);
      return;
    } 
    View view = LayoutInflater.from(this).inflate(R.layout.version_topic_footer, null);
    ((TextView)view.findViewById(R.id.footer)).setText("暂无评论");
    paramListView.addFooterView(view);
  }
  
  private void a(b paramb, a parama) {
    String str1 = new DecimalFormat("0.0##");
    this.dKr.setVisibility(0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LQKVersion.bD(true));
    stringBuilder.append("V%s");
    String str2 = String.format(stringBuilder.toString(), new Object[] { str1.format((paramb.version / 1000.0F)) });
    str1 = new DecimalFormat(".0");
    if (paramb.dIP != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("  |  综合评分");
      stringBuilder1.append(sr(str1.format(Double.parseDouble(paramb.dIP))));
      stringBuilder1.append("分");
      String str = stringBuilder1.toString();
    } else {
      str1 = "  |  综合评分5分";
    } 
    this.dKn.setText(str2);
    this.dKn.append(str1);
    this.dKp.setText(paramb.message);
    if (paramb.dIQ.size() > 0 && ((a)paramb.dIQ.get(0)).dIM.size() > 0) {
      this.dKq.setVisibility(0);
      a(paramb, this.dKq, parama);
      return;
    } 
    if (paramb.dIQ.size() == 0) {
      findViewById(R.id.cur_no_comment).setVisibility(0);
      findViewById(R.id.cur_title).setVisibility(8);
    } 
  }
  
  private void axl() {
    this.dKn = (TextView)findViewById(R.id.cur_status);
    this.dKo = (Button)findViewById(R.id.cur_comment);
    this.dKp = (TextView)findViewById(R.id.cur_info);
    this.dKq = (ListView)findViewById(R.id.cur_scoreAndCommend);
    this.dKr = findViewById(R.id.cur_version);
    this.dKs = (TextView)findViewById(R.id.prev_status);
    this.dKt = (Button)findViewById(R.id.prev_comment);
    this.dKu = (TextView)findViewById(R.id.prev_info);
    this.dKv = (ListView)findViewById(R.id.prev_scoreAndCommend);
    this.dKw = findViewById(R.id.prev_version);
  }
  
  private void b(b paramb, a parama) {
    String str1 = new DecimalFormat("0.0##");
    this.dKw.setVisibility(0);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LQKVersion.bD(true));
    stringBuilder.append("V%s");
    String str2 = String.format(stringBuilder.toString(), new Object[] { str1.format((paramb.version / 1000.0F)) });
    str1 = new DecimalFormat(".0");
    if (paramb.dIP != null) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("  |  综合评分");
      stringBuilder1.append(sr(str1.format(Double.parseDouble(paramb.dIP))));
      stringBuilder1.append("分");
      String str = stringBuilder1.toString();
    } else {
      str1 = "  |  综合评分5分";
    } 
    this.dKs.setText(str2);
    this.dKs.append(str1);
    this.dKu.setText(paramb.message);
    if (paramb.dIQ.size() > 0 && ((a)paramb.dIQ.get(0)).dIM.size() > 0) {
      this.dKv.setVisibility(0);
      a(paramb, this.dKv, parama);
      return;
    } 
    if (paramb.dIQ.size() == 0) {
      findViewById(R.id.prev_no_comment).setVisibility(0);
      findViewById(R.id.prev_title).setVisibility(8);
    } 
  }
  
  public static String sr(String paramString) { return BigDecimal.valueOf(Double.valueOf(Double.parseDouble(paramString)).doubleValue()).stripTrailingZeros().toPlainString(); }
  
  public void a(d paramd, a parama) {
    ab.P(this);
    if (paramd != null && paramd.dIS != null) {
      StringBuilder stringBuilder1;
      List list = paramd.dIS;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("versionCount");
      stringBuilder2.append(list.size());
      E(stringBuilder2.toString(), false);
      switch (list.size()) {
        default:
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("versions size is ");
          stringBuilder1.append(list.size());
          E(stringBuilder1.toString(), false);
          break;
        case 2:
          this.dKx = 2;
          this.dKm.R(Boolean.valueOf(true));
          b((b)list.get(1), stringBuilder1);
        case 1:
          if (((b)list.get(0)).version == ch.getVersionCode()) {
            this.dKm.R(Boolean.valueOf(false));
            a((b)list.get(0), stringBuilder1);
            break;
          } 
          this.dKy = true;
          this.dKm.R(Boolean.valueOf(true));
          b((b)list.get(0), stringBuilder1);
          break;
      } 
    } else {
      E("versionInfoResponse or versions is null", false);
    } 
    findViewById(R.id.scrollView).scrollTo(0, 0);
  }
  
  public Context axk() { return this; }
  
  public int axn() { return R.layout.version_upgrade_and_evaluate; }
  
  public void axq() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(ch.getVersionCode());
    String str = stringBuilder.toString();
    this.dKo.setText("我的评论");
    this.dKo.setOnClickListener(new b(this, str));
  }
  
  public void axr() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(ch.getVersionCode());
    String str = stringBuilder.toString();
    this.dKo.setText(getString(R.string.ver_do_evalute));
    this.dKo.setOnClickListener(new a(this, str));
  }
  
  public void axs() {
    String str = this.dKm.axg();
    this.dKt.setText("我的评论");
    this.dKt.setOnClickListener(new b(this, str));
  }
  
  public void axt() {
    String str = this.dKm.axg();
    this.dKt.setText(getString(R.string.ver_do_evalute));
    this.dKt.setOnClickListener(new a(this, str));
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    ab.O(this);
    axl();
    this.dKm = new g(this);
    this.dKm.initData();
  }
  
  public void onResume() {
    super.onResume();
    if (this.cgE) {
      this.cgE = false;
      return;
    } 
    switch (this.dKx) {
      default:
        return;
      case 2:
        this.dKm.R(Boolean.valueOf(true));
        break;
      case 1:
        break;
    } 
    if (this.dKy) {
      this.dKm.R(Boolean.valueOf(true));
      return;
    } 
    this.dKm.R(Boolean.valueOf(false));
  }
  
  public void sq(String paramString) { Toast.makeText(this, paramString, 0).show(); }
  
  class a implements View.OnClickListener {
    final String dJb;
    
    public a(UpgradeAndEvaluationActivity this$0, String param1String) { this.dJb = param1String; }
    
    public void onClick(View param1View) {
      Intent intent = new Intent(this.dKB, DoEvaluateActivity.class);
      intent.putExtra("version_id", this.dJb);
      intent.putExtra("FROM", 1);
      this.dKB.startActivity(intent);
    }
  }
  
  class b implements View.OnClickListener {
    final String dJb;
    
    public b(UpgradeAndEvaluationActivity this$0, String param1String) { this.dJb = param1String; }
    
    public void onClick(View param1View) {
      Intent intent = new Intent(this.dKB, MyEvaluationActivity.class);
      intent.putExtra("version_id", this.dJb);
      this.dKB.startActivity(intent);
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\UpgradeAndEvaluationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */