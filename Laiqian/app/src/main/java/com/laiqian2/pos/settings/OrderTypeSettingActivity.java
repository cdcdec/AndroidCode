package com.laiqian.pos.settings;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.laiqian.d.a;
import com.laiqian.entity.u;
import com.laiqian.pos.model.f;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import java.util.ArrayList;

public class OrderTypeSettingActivity extends ActivityRoot {
  private a cAb;
  
  private f cAc;
  
  private ab cAd;
  
  private long cAe;
  
  private View cfI;
  
  private boolean Az() { return (a.AZ().Co() != this.cAe); }
  
  private void bd(int paramInt1, int paramInt2) {
    Drawable drawable = findViewById(paramInt1).getBackground();
    if (drawable != null && drawable instanceof GradientDrawable)
      ((GradientDrawable)drawable).setColor(paramInt2); 
  }
  
  private void save() {
    a.AZ().Q(this.cAe);
    sendBroadcast(new Intent("pos_activity_change_data_order_type"));
    Toast.makeText(this, getString(2131628424), 0).show();
  }
  
  private void yf() {
    bd(2131298334, -412590);
    ListView listView = (ListView)findViewById(2131298362);
    this.cAc = new f(this);
    this.cfI = findViewById(2131296330);
    this.cAb = new a(this, null);
    this.cAd = new ab(this);
    this.cAd.a(new ah(this));
    this.cfI.setOnClickListener(new ai(this));
    listView.setAdapter(this.cAb);
  }
  
  public void finish() {
    if (Az()) {
      r r = new r(this, true, new aj(this));
      r.setTitle(getString(2131627735));
      r.s(getString(2131627733));
      r.t(getString(2131627734));
      r.oZ(getString(2131627732));
      r.show();
      return;
    } 
    super.finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427920);
    setTitleTextView(2131627214);
    setTitleTextViewRight(2131624290, new ag(this));
    this.cAe = a.AZ().Co();
    yf();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.cAc != null)
      this.cAc.close(); 
  }
  
  private class a extends BaseAdapter {
    private ArrayList<u> bjv;
    
    private ArrayList<u> cfO = new ArrayList();
    
    private a(OrderTypeSettingActivity this$0) {
      this.cfO.add(u.FO());
      this.cfO.add(u.FP());
      YQ();
    }
    
    private void YQ() {
      if (this.bjv != null)
        this.bjv.clear(); 
      this.bjv = OrderTypeSettingActivity.h(this.cAf).acN();
      this.bjv.addAll(0, this.cfO);
      notifyDataSetChanged();
    }
    
    public int getCount() { return this.bjv.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a1;
      if (param1View == null) {
        param1View = View.inflate(this.cAf, 2131427921, null);
        TextView textView1 = (TextView)param1View.findViewById(2131298198);
        TextView textView2 = (TextView)param1View.findViewById(2131299521);
        View view1 = param1View.findViewById(2131299903);
        param1View.setOnClickListener(new ak(this));
        a1 = new a(this, textView2, textView1, view1);
        view1.setTag(a1);
        view1.setOnClickListener(new al(this));
        param1View.setTag(a1);
      } else {
        a1 = (a)param1View.getTag();
      } 
      u u = ht(param1Int);
      a1.cAi = u;
      a1.aKu.setText(u.FM());
      View view = a1.cdo;
      boolean bool = u.FN();
      int i = 0;
      if (bool) {
        param1Int = 0;
      } else {
        param1Int = 8;
      } 
      view.setVisibility(param1Int);
      TextView textView = a1.cAh;
      if (u.FK() == OrderTypeSettingActivity.i(this.cAf)) {
        param1Int = i;
      } else {
        param1Int = 4;
      } 
      textView.setVisibility(param1Int);
      return param1View;
    }
    
    public u ht(int param1Int) { return (u)this.bjv.get(param1Int); }
    
    class a {
      TextView aKu;
      
      TextView cAh;
      
      u cAi;
      
      View cdo;
      
      public a(OrderTypeSettingActivity.a this$0, TextView param2TextView1, TextView param2TextView2, View param2View) {
        this.cAh = param2TextView1;
        this.aKu = param2TextView2;
        this.cdo = param2View;
      }
    }
  }
  
  class a {
    TextView aKu;
    
    TextView cAh;
    
    u cAi;
    
    View cdo;
    
    public a(OrderTypeSettingActivity this$0, TextView param1TextView1, TextView param1TextView2, View param1View) {
      this.cAh = param1TextView1;
      this.aKu = param1TextView2;
      this.cdo = param1View;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\OrderTypeSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */