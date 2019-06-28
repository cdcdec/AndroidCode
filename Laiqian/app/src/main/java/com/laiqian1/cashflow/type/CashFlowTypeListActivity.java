package com.laiqian.cashflow.type;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.cashflow.a.c;
import com.laiqian.cashflow.a.e;
import com.laiqian.cashflow.b.c;
import com.laiqian.ui.ActivityRoot;
import java.util.List;

public class CashFlowTypeListActivity extends ActivityRoot {
  private String Yx;
  
  private View aDo;
  
  private long aJx;
  
  private View aKm;
  
  private ListView aKn;
  
  private ListView aKo;
  
  private b aKp;
  
  private a aKq;
  
  a.a aKr = new n(this);
  
  f.a aKs = new o(this);
  
  private void P(long paramLong) {
    c c = new c(this);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    List list = c.bG(stringBuilder.toString());
    c.close();
    this.aKq.m(list);
    this.aKq.notifyDataSetChanged();
  }
  
  private void initData() {
    List list1 = c.AY();
    this.aKp = new b(this, this, list1);
    this.aKn.setAdapter(this.aKp);
    this.aKn.setSelection(0);
    this.aKn.setItemChecked(0, true);
    this.aJx = ((e)list1.get(0)).getID();
    this.Yx = ((e)list1.get(0)).getName();
    c c = new c(this);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.aJx);
    stringBuilder.append("");
    List list2 = c.bG(stringBuilder.toString());
    c.close();
    this.aKq = new a(this, this, list2);
    this.aKo.setAdapter(this.aKq);
  }
  
  private void yP() {
    this.aDo.setOnClickListener(new j(this));
    this.aKm.setOnClickListener(new k(this));
    this.aKn.setOnItemClickListener(new l(this));
    this.aKo.setOnItemClickListener(new m(this));
  }
  
  private void yR() {
    this.aDo = findViewById(2131296416);
    this.aKm = findViewById(2131299834);
    this.aKn = (ListView)findViewById(2131299836);
    this.aKo = (ListView)findViewById(2131299088);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetNoTitle(2131427366);
    yR();
    yP();
    initData();
  }
  
  public void onPause() { super.onPause(); }
  
  class a extends BaseAdapter {
    private List<c> list;
    
    private Context mContext;
    
    a(CashFlowTypeListActivity this$0, Context param1Context, List<c> param1List) {
      this.mContext = param1Context;
      this.list = param1List;
    }
    
    public c dR(int param1Int) { return (c)this.list.get(param1Int); }
    
    public int getCount() { return this.list.size(); }
    
    public long getItemId(int param1Int) { return ((c)this.list.get(param1Int)).getID(); }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a1;
      if (param1View == null) {
        param1View = View.inflate(this.mContext, 2131427733, null);
        a1 = new a(this);
        a1.aKu = (TextView)param1View.findViewById(2131296690);
        param1View.setTag(a1);
      } else {
        a1 = (a)param1View.getTag();
      } 
      a1.aKu.setText(dR(param1Int).getName());
      return param1View;
    }
    
    public void m(List<c> param1List) { this.list = param1List; }
    
    class a {
      public TextView aKu;
      
      a(CashFlowTypeListActivity.a this$0) {}
    }
  }
  
  class a {
    public TextView aKu;
    
    a(CashFlowTypeListActivity this$0) {}
  }
  
  class b extends BaseAdapter {
    private List<e> list;
    
    private Context mContext;
    
    b(CashFlowTypeListActivity this$0, Context param1Context, @NonNull List<e> param1List) {
      this.mContext = param1Context;
      this.list = param1List;
    }
    
    public e dS(int param1Int) { return (e)this.list.get(param1Int); }
    
    public int getCount() { return this.list.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a;
      if (param1View == null) {
        param1View = View.inflate(this.mContext, 2131427734, null);
        a = new a(this);
        a.aKu = (TextView)param1View.findViewById(2131296695);
        param1View.setTag(a);
      } else {
        a = (a)param1View.getTag();
      } 
      a.aKu.setText(dS(param1Int).getName());
      return param1View;
    }
    
    class a {
      public TextView aKu;
      
      a(CashFlowTypeListActivity.b this$0) {}
    }
  }
  
  class a {
    public TextView aKu;
    
    a(CashFlowTypeListActivity this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\type\CashFlowTypeListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */