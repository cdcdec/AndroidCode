package com.laiqian.main.module.productpool;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.main.ao;
import com.laiqian.product.models.g;
import com.laiqian.product.models.h;
import com.laiqian.util.n;
import java.util.ArrayList;

public class p {
  private Activity azD;
  
  private EditText bkN;
  
  private View bkS;
  
  private View bkT;
  
  private a bkU;
  
  private g bkV;
  
  private final b bkW;
  
  boolean bkX;
  
  private long bkY;
  
  private final int bkZ = 1;
  
  Handler handler = new u(this);
  
  public p(Activity paramActivity, View paramView, b paramb) {
    this.azD = paramActivity;
    this.bkW = paramb;
    this.bkS = paramView;
    this.bkV = new g(paramActivity);
    this.bkX = a.AZ().Bm();
    Od();
    View view1 = paramView.findViewById(2131298587);
    this.bkN = (EditText)view1.findViewById(2131298586);
    this.bkN.addTextChangedListener(new q(this));
    this.bkT = view1.findViewById(2131298585);
    this.bkT.setOnClickListener(new r(this));
    view1.findViewById(2131298583).setOnClickListener(new s(this));
    View view2 = paramView.findViewById(2131298581);
    ListView listView = (ListView)view2.findViewById(2131298580);
    listView.setEmptyView(view2.findViewById(2131298582));
    view2 = View.inflate(paramActivity, 2131427731, null);
    view2.setClickable(true);
    listView.addHeaderView(view2);
    ao.a(paramActivity, (ViewGroup)paramView.findViewById(2131298589).findViewById(2131298588));
    this.bkU = new a(this);
    listView.setAdapter(this.bkU);
    listView.setOnItemClickListener(new t(this));
  }
  
  private void Oc() { (new c(this, this.bkN.getText().toString().trim(), this.bkX)).start(); }
  
  public boolean Od() {
    if (isShowing()) {
      ao.b(this.azD.getWindow(), new EditText[] { this.bkN });
      this.bkS.setVisibility(8);
      this.bkW.onVisibilityChanged(false);
      return true;
    } 
    return false;
  }
  
  public boolean isShowing() { return (this.bkS.getVisibility() == 0); }
  
  public void show() {
    if (isShowing())
      return; 
    ao.a(this.azD.getWindow(), new EditText[] { this.bkN });
    this.bkS.setVisibility(0);
    this.bkN.requestFocus();
    boolean bool = a.AZ().Bm();
    this.bkX = bool;
    this.bkN.setText("");
    if (bool) {
      this.bkN.setHint(2131626339);
    } else {
      this.bkN.setHint(2131626340);
    } 
    this.bkW.onVisibilityChanged(true);
  }
  
  class a extends BaseAdapter {
    ArrayList<h> bjv;
    
    a(p this$0) {}
    
    private void A(ArrayList<h> param1ArrayList) {
      this.bjv = param1ArrayList;
      notifyDataSetChanged();
    }
    
    public h fb(int param1Int) { return (h)this.bjv.get(param1Int); }
    
    public int getCount() { return (this.bjv == null) ? 0 : this.bjv.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a1;
      h h = fb(param1Int);
      if (param1View == null) {
        param1View = View.inflate(p.h(this.bla).getContext(), 2131427820, null);
        a1 = new a(this, (TextView)param1View.findViewById(2131298534), (TextView)param1View.findViewById(2131298563), (TextView)param1View.findViewById(2131298571), param1View.findViewById(2131298595));
        param1View.setTag(a1);
      } else {
        a1 = (a)param1View.getTag();
      } 
      if (this.bla.bkX) {
        a1.blb.setText(h.ago);
        a1.blb.setVisibility(0);
      } else {
        a1.blb.setVisibility(8);
      } 
      a1.bjG.setText(h.cUM);
      if (h.cUN) {
        a1.blc.setText(h.akJ());
        a1.blc.setVisibility(0);
        a1.bld.setVisibility(8);
        return param1View;
      } 
      a1.blc.setVisibility(8);
      a1.bld.setVisibility(0);
      return param1View;
    }
    
    class a {
      TextView bjG;
      
      TextView blb;
      
      TextView blc;
      
      View bld;
      
      public a(p.a this$0, TextView param2TextView1, TextView param2TextView2, TextView param2TextView3, View param2View) {
        this.blb = param2TextView1;
        this.bjG = param2TextView2;
        this.blc = param2TextView3;
        this.bld = param2View;
      }
    }
  }
  
  class a {
    TextView bjG;
    
    TextView blb;
    
    TextView blc;
    
    View bld;
    
    public a(p this$0, TextView param1TextView1, TextView param1TextView2, TextView param1TextView3, View param1View) {
      this.blb = param1TextView1;
      this.bjG = param1TextView2;
      this.blc = param1TextView3;
      this.bld = param1View;
    }
  }
  
  public static interface b {
    void e(h param1h);
    
    void onVisibilityChanged(boolean param1Boolean);
  }
  
  private class c extends Thread {
    String blf;
    
    boolean blg;
    
    c(p this$0, String param1String, boolean param1Boolean) {
      this.blf = param1String;
      this.blg = param1Boolean;
    }
    
    public void run() {
      super.run();
      p.a(this.bla, getId());
      ArrayList arrayList = p.e(this.bla).x(this.blf, this.blg);
      if (getId() == p.f(this.bla) && this.bla.isShowing()) {
        this.bla.handler.obtainMessage(1, arrayList).sendToTarget();
        return;
      } 
      n.println("搜索商品的线程被覆盖或者页面被关闭");
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productpool\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */