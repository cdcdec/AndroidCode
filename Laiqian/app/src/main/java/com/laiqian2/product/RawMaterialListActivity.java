package com.laiqian.product;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.d.a;
import com.laiqian.models.at;
import com.laiqian.models.v;
import com.laiqian.product.models.g;
import com.laiqian.product.models.m;
import com.laiqian.product.models.n;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.w;
import com.laiqian.util.n;
import com.zhuge.analysis.b.a;
import java.util.ArrayList;

public class RawMaterialListActivity extends ActivityRoot {
  private ListView cTa;
  
  private a cTb;
  
  private w cTc;
  
  private c cTd;
  
  private final int cTe = 0;
  
  boolean cTf;
  
  private void a(n paramn) {
    if (paramn != null)
      a.a(this.cTb, paramn.getID()); 
  }
  
  private void akf() {
    this.cTa = (ListView)findViewById(2131298661);
    this.cTb = new a(this);
    View view1 = View.inflate(this, 2131427731, null);
    view1.setClickable(true);
    this.cTa.addHeaderView(view1);
    view1 = View.inflate(this, 2131427958, null);
    view1.setClickable(true);
    ej ej = new ej(this);
    View view2 = view1.findViewById(2131298198);
    view2.setTag(new g.b[] { g.b.cUA, g.b.cUB });
    view2.setOnClickListener(ej);
    view2 = view1.findViewById(2131299083);
    view2.setTag(new g.b[] { g.b.cUC, g.b.cUD });
    view2.setOnClickListener(ej);
    view2 = view1.findViewById(2131298820);
    view2.setTag(new g.b[] { g.b.cUE, g.b.cUF });
    view2.setOnClickListener(ej);
    view2 = view1.findViewById(2131299899);
    view2.setTag(new g.b[] { g.b.cUG, g.b.cUH });
    view2.setOnClickListener(ej);
    this.cTa.addHeaderView(view1);
    this.cTa.setAdapter(this.cTb);
    this.cTa.setOnItemClickListener(new ek(this));
    String str1 = getString(2131627586);
    String str2 = getString(2131627589);
    String str3 = getString(2131627584);
    String str4 = getString(2131627591);
    el el = new el(this);
    this.cTc = new w(this, new String[] { str1, str2, str3, str4 }, el);
    this.cTd = new c(this, this);
  }
  
  public void finish() {
    super.finish();
    if (this.cTf) {
      a.a(this.cTb);
      return;
    } 
    a.AZ().BP();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427956);
    setTitleTextViewHideRightView(2131627582);
    ListView listView = (ListView)findViewById(2131299836);
    View view = View.inflate(this, 2131427731, null);
    view.setClickable(true);
    listView.addHeaderView(view);
    listView.setAdapter(new b(this, null));
    listView.setOnItemClickListener(new ei(this));
    akf();
    this.cTf = false;
    listView.setItemChecked(listView.getHeaderViewsCount(), true);
    a((n)listView.getAdapter().getItem(listView.getHeaderViewsCount()));
  }
  
  protected void onDestroy() {
    super.onDestroy();
    a.b(this.cTb);
    c.a(this.cTd);
    a.aAU().flush(this);
  }
  
  protected void onResume() {
    super.onResume();
    a.aAU().init(this);
  }
  
  private class a extends BaseAdapter {
    private long aJx;
    
    private ArrayList<m> bjv = new ArrayList();
    
    private g cPb;
    
    g.b cTh;
    
    a(RawMaterialListActivity this$0) {
      this.cPb = new g(this$0);
      this.cTh = g.b.cUC;
      this.aJx = 0L;
    }
    
    private void Rk() {
      this.bjv.clear();
      this.cPb.a(this.bjv, this.aJx, this.cTh);
      notifyDataSetChanged();
      RawMaterialListActivity.d(this.cTg).setSelection(0);
    }
    
    private void a(g.b[] param1ArrayOfb) {
      if (param1ArrayOfb[false] == this.cTh) {
        this.cTh = param1ArrayOfb[1];
      } else {
        this.cTh = param1ArrayOfb[0];
      } 
      Rk();
    }
    
    private void akg() { a.AZ().a(this.cPb); }
    
    private void cI(long param1Long) {
      this.aJx = param1Long;
      Rk();
    }
    
    private void closeModel() { this.cPb.close(); }
    
    private boolean d(long param1Long, double param1Double) { return this.cPb.g(param1Long, param1Double); }
    
    public int getCount() { return this.bjv.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      boolean bool;
      a a1;
      if (param1View == null) {
        param1View = View.inflate(this.cTg, 2131427957, null);
        a1 = new a(this, (TextView)param1View.findViewById(2131298198), (TextView)param1View.findViewById(2131299083), (TextView)param1View.findViewById(2131298820), (TextView)param1View.findViewById(2131299899));
        param1View.setTag(a1);
      } else {
        a1 = (a)param1View.getTag();
      } 
      m m = jp(param1Int);
      if (param1Int % 2 != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      param1View.setEnabled(bool);
      a1.aKu.setText(m.getName());
      a1.cTi.setText(m.akV());
      a1.cTi.setSelected(m.akY());
      a1.cTj.setText(m.akX());
      a1.cTj.setSelected(m.akY());
      a1.cTk.setText(m.Wy());
      return param1View;
    }
    
    public m jp(int param1Int) { return (m)this.bjv.get(param1Int); }
    
    class a {
      TextView aKu;
      
      TextView cTi;
      
      TextView cTj;
      
      TextView cTk;
      
      public a(RawMaterialListActivity.a this$0, TextView param2TextView1, TextView param2TextView2, TextView param2TextView3, TextView param2TextView4) {
        this.aKu = param2TextView1;
        this.cTi = param2TextView2;
        this.cTj = param2TextView3;
        this.cTk = param2TextView4;
      }
    }
  }
  
  class a {
    TextView aKu;
    
    TextView cTi;
    
    TextView cTj;
    
    TextView cTk;
    
    public a(RawMaterialListActivity this$0, TextView param1TextView1, TextView param1TextView2, TextView param1TextView3, TextView param1TextView4) {
      this.aKu = param1TextView1;
      this.cTi = param1TextView2;
      this.cTj = param1TextView3;
      this.cTk = param1TextView4;
    }
  }
  
  private class b extends BaseAdapter {
    private final ArrayList<n> bjv;
    
    private b(RawMaterialListActivity this$0) {
      at at = new at(this$0);
      this.bjv = at.Wo();
      this.bjv.add(0, new n(0L, this$0.getString(2131627583)));
      at.close();
    }
    
    public int getCount() { return this.bjv.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a2;
      a a1;
      if (param1View == null) {
        a2 = View.inflate(this.cTg, 2131427959, null);
        a1 = new a(this, (TextView)a2.findViewById(2131298198));
        a2.setTag(a1);
      } else {
        a a = (a)a1.getTag();
        a2 = a1;
        a1 = a;
      } 
      n n = jq(param1Int);
      a1.aKu.setText(n.getName());
      return a2;
    }
    
    public n jq(int param1Int) { return (n)this.bjv.get(param1Int); }
    
    class a {
      TextView aKu;
      
      public a(RawMaterialListActivity.b this$0, TextView param2TextView) { this.aKu = param2TextView; }
    }
  }
  
  class a {
    TextView aKu;
    
    public a(RawMaterialListActivity this$0, TextView param1TextView) { this.aKu = param1TextView; }
  }
  
  private class c extends d {
    private TextView cCh;
    
    private EditText cTn;
    
    private m cTo;
    
    private int cTp;
    
    private String cTq;
    
    private v cTr;
    
    public c(RawMaterialListActivity this$0, ActivityRoot param1ActivityRoot) {
      super(param1ActivityRoot, 2131427960);
      setPositionTop();
      (getWindow().getAttributes()).width = (this.mView.findViewById(2131297735).getLayoutParams()).width + (this.mView.findViewById(2131298737).getLayoutParams()).width;
      this.tvTitle = (TextView)this.mView.findViewById(2131299242);
      View view = this.mView.findViewById(2131297735).findViewById(2131298650);
      this.cTn = (EditText)view.findViewById(2131298649);
      this.cCh = (TextView)view.findViewById(2131299899);
      this.mView.findViewById(2131296671).setOnClickListener(new em(this, this$0));
      this.mView.findViewById(2131299105).setOnClickListener(new en(this, this$0));
      this.cTr = new v(param1ActivityRoot);
    }
    
    private void closeModel() { this.cTr.close(); }
    
    public void a(m param1m, int param1Int) {
      String str;
      this.cTo = param1m;
      this.cTp = param1Int;
      this.cTn.setText("");
      this.cCh.setText(param1m.Wy());
      if (param1Int != 0) {
        String str1;
        switch (param1Int) {
          default:
            n.o("选择原材料的业务类型时错误。这里不会进来");
            return;
          case 100054:
            str1 = this.cTg.getString(2131627584);
            this.cTq = "原材料盘点";
            this.cTn.setText(n.ba(param1m.akU()));
            str = str1;
            break;
          case 100053:
            str = this.cTg.getString(2131627589);
            this.cTq = "原材料出库";
            break;
          case 100052:
            str = this.cTg.getString(2131627586);
            this.cTq = "原材料入库";
            break;
        } 
      } else {
        str = this.cTg.getString(2131627590);
        this.cTq = "原材料修改按钮库存";
      } 
      this.tvTitle.setText(str);
      n.j(this.cTn);
      super.show();
    }
    
    protected String akh() {
      String str = this.cTn.getText().toString().trim();
      if (str.length() == 0)
        n.eP(2131627558); 
      double d1 = n.aU(str);
      return (this.cTp == 0) ? (RawMaterialListActivity.a.a(RawMaterialListActivity.a(this.cTg), this.cTo.aSW, d1) ? null : "设置安全库存失败") : this.cTr.a(this.cTo, d1, this.cTp);
    }
    
    @Deprecated
    public void show() { super.show(); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\RawMaterialListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */