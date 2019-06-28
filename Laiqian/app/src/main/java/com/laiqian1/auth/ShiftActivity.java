package com.laiqian.auth;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.c.a;
import com.laiqian.d.a;
import com.laiqian.k.a;
import com.laiqian.models.m;
import com.laiqian.print.j;
import com.laiqian.print.model.g;
import com.laiqian.report.models.a;
import com.laiqian.report.models.b;
import com.laiqian.report.models.t;
import com.laiqian.report.ui.g;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.s;
import com.laiqian.util.n;
import com.umeng.analytics.MobclickAgent;
import com.zhuge.analysis.b.a;
import java.util.ArrayList;
import java.util.List;

public class ShiftActivity extends ActivityRoot {
  public static boolean aEy = false;
  
  View.OnClickListener aEA = new az(this);
  
  View.OnClickListener aEB = new ba(this);
  
  private a.a aEz;
  
  static  {
  
  }
  
  private void ye() {
    null = (GridView)findViewById(2131297189);
    null = findViewById(2131298456);
    if (!getResources().getBoolean(2131034123))
      null.setVisibility(8); 
    null = new g(this, null);
    null.setAdapter(null);
    null.setEmptyView(findViewById(2131298220));
    ArrayList arrayList = this.aEz.cZt;
    null.ay(arrayList);
    View view1 = findViewById(2131297210);
    if (arrayList == null || arrayList.isEmpty()) {
      view1.setVisibility(8);
      return;
    } 
    double[] arrayOfDouble = this.aEz.cZB;
    TextView textView1 = (TextView)view1.findViewById(2131299102);
    ((TextView)view1.findViewById(2131299104)).setText(2131627797);
    textView1.setText(n.b(this, Double.valueOf(arrayOfDouble[0]), false));
    View view2 = view1.findViewById(2131299098);
    view2.setVisibility(0);
    TextView textView2 = (TextView)view2.findViewById(2131299099);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getString(2131624864));
    stringBuilder.append("+");
    stringBuilder.append(getString(2131624776));
    textView2.setText(stringBuilder.toString());
    textView2 = (TextView)view2.findViewById(2131299100);
    textView2.setVisibility(0);
    textView2.setText(2131624865);
    ((TextView)view2.findViewById(2131299097)).setText(n.a(Double.valueOf(arrayOfDouble[2]), true, true, RootApplication.aIQ));
    view1 = view1.findViewById(2131299094);
    if (this.aEz.cZv) {
      view1.setVisibility(0);
      ((TextView)view1.findViewById(2131299095)).setText(2131627795);
      ((TextView)view1.findViewById(2131299093)).setText(n.a(Double.valueOf(arrayOfDouble[2]), true, true, RootApplication.aIQ));
      return;
    } 
    view1.setVisibility(8);
  }
  
  private void yf() {
    ((TextView)findViewById(2131299930)).setText(this.aEz.userName);
    ((TextView)findViewById(2131299228)).setText(this.aEz.aRD);
    ((TextView)findViewById(2131299068)).setText(this.aEz.aRB);
    ((TextView)findViewById(2131299227)).setText(this.aEz.cZA);
    CheckBox checkBox = (CheckBox)s.a(this, 2131296710);
    checkBox.setChecked(a.AZ().Bb());
    checkBox.setOnCheckedChangeListener(new ax(this));
  }
  
  private void yg() { findViewById(2131298608).setOnClickListener(new ay(this)); }
  
  private void yh() {
    b = new b(this);
    long l1 = getLaiqianPreferenceManager().atQ();
    long l2 = System.currentTimeMillis();
    b.a((new t.a(l1, l2)).anl());
    getLaiqianPreferenceManager().du(0L);
    if (a.AZ().BL())
      m.UX(); 
    ArrayList arrayList = b.gz(true);
    double[] arrayOfDouble = b.amw();
    b.close();
    try {
      List list = j.cCx.a(new bf(l1, l2, arrayList, arrayOfDouble[0], arrayOfDouble[1], arrayOfDouble[2]), new String[] { "shift" });
      g.cGS.o(list);
      return;
    } catch (Exception b) {
      a.e(b);
      return;
    } 
  }
  
  public boolean beforeCloseActivity() {
    String str;
    a.asx();
    a.asy();
    if (aEy) {
      str = "先看统计、再返回";
    } else {
      str = "直接返回";
    } 
    a.x(this, str);
    return false;
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131428041);
    setTitleTextView(2131628232);
    setTitleTextViewRight(2131627959, this.aEA);
    findViewById(2131298959).setOnClickListener(this.aEB);
    this.aEz = new a.a();
    ye();
    yf();
    yg();
    if (!getResources().getBoolean(2131034117) || a.zR().Aw())
      findViewById(2131297278).findViewById(2131297530).setVisibility(8); 
  }
  
  protected void onDestroy() {
    super.onDestroy();
    a.aAU().flush(this);
  }
  
  protected void onPause() {
    super.onPause();
    MobclickAgent.onPause(this);
  }
  
  protected void onResume() {
    super.onResume();
    MobclickAgent.onResume(this);
    a.aAU().init(this);
    a.asw();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\ShiftActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */