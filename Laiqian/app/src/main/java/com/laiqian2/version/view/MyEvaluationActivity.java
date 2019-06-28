package com.laiqian.version.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.f.b;
import com.laiqian.i.d;
import com.laiqian.infrastructure.R;
import com.laiqian.network.b;
import com.laiqian.network.g;
import com.laiqian.network.h;
import com.laiqian.network.n;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.util.av;
import com.laiqian.util.n;
import com.laiqian.version.a.b.b;
import com.laiqian.version.a.d.c;
import com.laiqian.version.b.b;
import com.laiqian.version.d.c;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import retrofit2.d;

public class MyEvaluationActivity extends BaseView {
  String dJb;
  
  TextView dKc;
  
  RatingBar dKd;
  
  TextView dKe;
  
  TextView dKf;
  
  ListView dKg;
  
  c dKh;
  
  Handler mHandler = new r(this);
  
  private void axl() {
    this.dKc = (TextView)findViewById(R.id.version);
    this.dKd = (RatingBar)findViewById(R.id.rating);
    this.dKe = (TextView)findViewById(R.id.datetime);
    this.dKf = (TextView)findViewById(R.id.contentText);
    this.dKg = (ListView)findViewById(R.id.replies);
  }
  
  private void b(c paramc) {
    null = (new av(this)).Ea();
    b b = new b(this, paramc.dIF, null, this.dJb);
    this.dKg.setVisibility(0);
    b.mo(paramc.dIE);
    if (paramc.dIF != null && paramc.dIF.size() > 2) {
      View view = LayoutInflater.from(this).inflate(R.layout.version_reply_footer, null);
      FrameLayout frameLayout = new FrameLayout(this);
      frameLayout.addView(view);
      TextView textView = (TextView)view.findViewById(R.id.footerText);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("");
      stringBuilder2.append(paramc.dID);
      textView.setTag(stringBuilder2.toString());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("展开");
      stringBuilder1.append(b.axe());
      stringBuilder1.append("条回复");
      textView.setText(stringBuilder1.toString());
      textView.setOnClickListener(new p(this, b, view));
      this.dKg.addFooterView(frameLayout);
      this.dKg.setAdapter(b);
      return;
    } 
    this.dKg.setAdapter(b);
  }
  
  private void d(d<h> paramd, String paramString1, String paramString2) {
    paramString2 = d.ac(new b(this.dJb, paramString1, paramString2));
    b b = (b)n.bUo.af(b.class);
    g g = new g(paramString2);
    String str1 = String.valueOf(System.currentTimeMillis() / 1000L);
    String str2 = b.c(n.parseLong(str1), n.parseInt(RootApplication.getLaiqianPreferenceManager().Tx()));
    b.a(RootUrlParameter.clg, g, RootApplication.getLaiqianPreferenceManager().Tx(), str1, str2).a(paramd);
  }
  
  public void a(c paramc) {
    if (paramc.dIC != null) {
      float f = Float.parseFloat(paramc.dIC);
      this.dKd.setRating(f);
    } 
    if (paramc.ciB != null) {
      String str2 = (new SimpleDateFormat("yyyy-MM-dd  HH:mm")).format(new Date(Long.parseLong(paramc.ciB)));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(Calendar.getInstance().get(1));
      String str1 = str2;
      if (str2.startsWith(stringBuilder.toString()))
        str1 = str2.substring(5, str2.length()); 
      this.dKe.setText(str1);
    } 
    this.dKf.setText(paramc.acL);
    b(paramc);
  }
  
  public Context axk() { return this; }
  
  public void axp() { runOnUiThread(new o(this)); }
  
  public void d(ListView paramListView) {
    ListAdapter listAdapter = paramListView.getAdapter();
    if (listAdapter == null)
      return; 
    byte b = 0;
    int i = 0;
    while (b < listAdapter.getCount()) {
      View view = listAdapter.getView(b, null, paramListView);
      view.measure(0, 0);
      i += view.getMeasuredHeight();
      b++;
    } 
    ViewGroup.LayoutParams layoutParams = paramListView.getLayoutParams();
    layoutParams.height = i + paramListView.getDividerHeight() * (listAdapter.getCount() - 1);
    paramListView.setLayoutParams(layoutParams);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(R.layout.version_my_evaluation);
    getWindow().setFeatureInt(7, R.layout.pos_submit_title);
    ((TextView)findViewById(R.id.title_text)).setText("我的评论");
    findViewById(R.id.title_right).setVisibility(8);
    axl();
    this.dJb = getIntent().getStringExtra("version_id");
    this.dKh = new c(this, this.dJb);
    this.dKh.axf();
    DecimalFormat decimalFormat = new DecimalFormat("0.0##");
    TextView textView = this.dKc;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LQKVersion.bD(true));
    stringBuilder.append("V%s");
    textView.setText(String.format(stringBuilder.toString(), new Object[] { decimalFormat.format(((float)Long.parseLong(this.dJb) / 1000.0F)) }));
  }
  
  protected void onDestroy() {
    this.mHandler = null;
    super.onDestroy();
  }
  
  public void sq(String paramString) { Toast.makeText(this, paramString, 0).show(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\view\MyEvaluationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */