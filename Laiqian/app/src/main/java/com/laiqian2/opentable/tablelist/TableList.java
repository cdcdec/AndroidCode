package com.laiqian.opentable.tablelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.opentable.R;
import com.laiqian.opentable.a.b;
import com.laiqian.opentable.b.r;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.ordertool.c.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.by;
import com.laiqian.util.n;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;

public abstract class TableList extends ActivityRoot implements a {
  a bZV;
  
  private TableEntity caQ;
  
  private b cbE;
  
  private r cbT;
  
  private boolean cda;
  
  private b cdb;
  
  private a cdc;
  
  private String cdd;
  
  private String cde;
  
  private ListView cdf;
  
  private boolean cdg = false;
  
  private long cdh;
  
  private b cdi;
  
  View.OnClickListener cdj = new e(this);
  
  private void YH() {
    Intent intent = getIntent();
    intent.putExtra("tableEntity", this.caQ);
    if (this.caQ != null) {
      long l = this.caQ.XY();
      a a1 = this.cdc;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.caQ.XY());
      stringBuilder.append("");
      intent.putExtra("areaEntity", new a(l, a1.jt(stringBuilder.toString())));
    } 
    setResult(-1, intent);
    finish();
  }
  
  private void gD(int paramInt) {
    if (paramInt >= this.cdc.YO()) {
      this.cdf.getOnItemClickListener().onItemClick(this.cdf, null, paramInt, 0L);
      this.cdf.setItemChecked(paramInt, true);
      this.cdf.setSelection(paramInt);
    } 
  }
  
  private void i(a parama) {
    if (parama == null) {
      this.cbE.at(null, null);
      return;
    } 
    b b1 = this.cbE;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(parama.getId());
    stringBuilder.append("");
    b1.at(stringBuilder.toString(), parama.XX());
  }
  
  private void r(TableEntity paramTableEntity) {
    a a1;
    if (paramTableEntity == null) {
      if (this.cdc.getCount() == 0) {
        n.w(this, R.string.pos_open_table_please_create_area);
        return;
      } 
      if (this.cdc.getCount() == 1) {
        a1 = this.cdc.gE(0);
        this.cbT.a(a1, true, this.cdc.YP(), false);
        return;
      } 
      this.cbT.a(new a(by.parseLong(this.cdd), this.cde), true, this.cdc.YP(), false);
      return;
    } 
    if (this.cdd == null) {
      null = new StringBuilder();
      null.append(a1.XY());
      null.append("");
      String str = null.toString();
      if (this.cdc.getCount() == 0) {
        str = this.cdc.jt(str);
        this.cbT.a(a1, new a(a1.XY(), str), false, this.cdc.YP(), false);
        return;
      } 
      str = this.cdc.jt(str);
      this.cbT.a(a1, new a(a1.XY(), str), true, this.cdc.YP(), false);
      return;
    } 
    this.cbT.a(a1, new a(Long.valueOf(this.cdd).longValue(), this.cde), true, this.cdc.YP(), false);
  }
  
  public void K(ArrayList<TableEntity> paramArrayList) {
    ListView listView = (ListView)findViewById(R.id.table_body_l).findViewById(R.id.table_body);
    this.cdb = new b(this, listView, paramArrayList);
    listView.setAdapter(this.cdb);
    listView.setOnItemClickListener(new k(this));
  }
  
  public void Nk() { this.cdi.Yu(); }
  
  protected abstract a Xl();
  
  protected abstract Class<? extends TableList> Xm();
  
  public void YI() {
    View view = findViewById(R.id.area_add_small);
    view.setOnClickListener(this.cdj);
    if (!this.cdg)
      view.setVisibility(8); 
    Nk();
    YJ();
    findViewById(R.id.back).setOnClickListener(new f(this));
  }
  
  public void YJ() {
    this.cbE = new b(this, this.bZV);
    this.cbE.a(new g(this));
  }
  
  public void YK() {
    this.cbT = new r(this, this.bZV, Xm());
    this.cbT.a(new h(this));
  }
  
  public void YL() {
    boolean bool;
    this.cdh = getIntent().getLongExtra("tableID", 0L);
    this.cdi = new b(this, this, this.bZV);
    if (this.cdh > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    this.cda = bool;
    if (this.cda) {
      View view = findViewById(R.id.filter_l);
      view.setVisibility(0);
      view.findViewById(R.id.line_h).setVisibility(8);
      setTitleTextView(R.string.pos_table_number_title_select);
      setTitleTextViewRight(R.string.pos_product_product_filter_sure, new i(this));
    } 
    this.cdg = this.cda ^ true;
  }
  
  public void YM() {
    long l;
    if (by.isNull(this.cdd)) {
      l = -1L;
    } else {
      l = by.parseLong(this.cdd);
    } 
    this.cdi.t(l, this.cdh);
  }
  
  public void YN() {
    View view = findViewById(R.id.nodata_l);
    view.findViewById(R.id.nodata).setOnClickListener(this.cdj);
    this.cdf.setEmptyView(view);
  }
  
  public void aa(ArrayList<a> paramArrayList) {
    this.cdf = (ListView)findViewById(R.id.area_body_l).findViewById(R.id.area_body);
    this.cdc = new a(this, this.cdf, paramArrayList);
    this.cdf.setAdapter(this.cdc);
    this.cdf.setChoiceMode(1);
    this.cdf.setOnItemClickListener(new j(this));
    this.cdf.setItemChecked(this.cdc.YO(), true);
  }
  
  public void fa(String paramString) { n.o(paramString); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetNoTitle(R.layout.pos_table_main);
    this.bZV = Xl();
    YL();
    YI();
    YN();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.cdi != null)
      this.cdi.zM(); 
  }
  
  protected void onPause() {
    MobclickAgent.onPause(this);
    super.onPause();
  }
  
  protected void onResume() {
    MobclickAgent.onResume(this);
    super.onResume();
  }
  
  public void u(ArrayList<a> paramArrayList) {
    if (this.cdc == null) {
      aa(paramArrayList);
      if (this.cdb == null)
        YM(); 
      if (this.cbT == null) {
        YK();
        return;
      } 
    } else {
      a.a(this.cdc, paramArrayList);
      this.cdc.YQ();
    } 
  }
  
  public void v(ArrayList<TableEntity> paramArrayList) {
    if (this.cdb == null) {
      K(paramArrayList);
      return;
    } 
    b.a(this.cdb, paramArrayList);
    this.cdb.YQ();
  }
  
  class a extends BaseAdapter {
    private ListView bWY;
    
    private ArrayList<a> bjv;
    
    private View cdl;
    
    View.OnClickListener cdm = new l(this);
    
    public a(TableList this$0, ListView param1ListView, ArrayList<a> param1ArrayList) {
      this.bjv = param1ArrayList;
      this.bWY = param1ListView;
      if (this.bWY.getHeaderViewsCount() == 0) {
        View view1;
        View view2 = (view1 = View.inflate(this$0, R.layout.listview_headview_10500, null)).inflate(this$0, R.layout.pos_table_main_type_item_head, null);
        this.bWY.addHeaderView(view1);
        this.bWY.addHeaderView(view2);
      } 
      this.cdl = View.inflate(this$0, R.layout.listview_headview_10500, null);
      YQ();
    }
    
    public int YO() { return this.bWY.getHeaderViewsCount() - 1; }
    
    public ArrayList<a> YP() { return this.bjv; }
    
    public void YQ() {
      if (this.bjv.size() == 0) {
        if (this.bWY.getFooterViewsCount() > 0)
          this.bWY.removeFooterView(this.cdl); 
      } else {
        if (this.bWY.getFooterViewsCount() == 0)
          this.bWY.addFooterView(this.cdl); 
        this.bWY.setSelection(0);
      } 
      notifyDataSetChanged();
    }
    
    public a gE(int param1Int) { return (a)this.bjv.get(param1Int); }
    
    public int getCount() { return this.bjv.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a2;
      a a1;
      if (param1View == null) {
        a2 = View.inflate(this.cdk, R.layout.pos_product_main_type_item, null);
        null = (TextView)a2.findViewById(R.id.type_name);
        View view = a2.findViewById(R.id.type_update);
        view.setOnClickListener(this.cdm);
        if (!TableList.e(this.cdk))
          view.setVisibility(8); 
        a1 = new a(this, null, view);
        a2.setTag(a1);
      } else {
        a a4 = (a)a1.getTag();
        a2 = a1;
        a1 = a4;
      } 
      a a3 = gE(param1Int);
      a1.aKu.setText(a3.XX());
      a1.cdo.setTag(a3);
      return a2;
    }
    
    public String jt(String param1String) {
      for (a a1 : this.bjv) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a1.getId());
        stringBuilder.append("");
        if (stringBuilder.toString().equals(param1String))
          return a1.XX(); 
      } 
      return null;
    }
    
    public int ju(String param1String) {
      for (int i = 0; i < this.bjv.size(); i++) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((a)this.bjv.get(i)).getId());
        stringBuilder.append("");
        if (stringBuilder.toString().equals(param1String))
          return i + this.bWY.getHeaderViewsCount(); 
      } 
      return -1;
    }
    
    class a {
      TextView aKu;
      
      View cdo;
      
      public a(TableList.a this$0, TextView param2TextView, View param2View) {
        this.aKu = param2TextView;
        this.cdo = param2View;
      }
    }
  }
  
  class a {
    TextView aKu;
    
    View cdo;
    
    public a(TableList this$0, TextView param1TextView, View param1View) {
      this.aKu = param1TextView;
      this.cdo = param1View;
    }
  }
  
  class b extends BaseAdapter {
    private ListView bWY;
    
    private ArrayList<TableEntity> bjv;
    
    private View cdp;
    
    private View cdq;
    
    public b(TableList this$0, ListView param1ListView, ArrayList<TableEntity> param1ArrayList) {
      this.bWY = param1ListView;
      this.bjv = param1ArrayList;
      this.cdp = this$0.findViewById(R.id.table_add_small);
      if (!TableList.e(this$0))
        this.cdp.setVisibility(8); 
      this.cdq = this$0.findViewById(R.id.table_add_l);
      if (param1ListView.getHeaderViewsCount() == 0)
        param1ListView.addHeaderView(View.inflate(this$0, R.layout.listview_headview_10500, null)); 
      if (param1ListView.getFooterViewsCount() == 0)
        param1ListView.addFooterView(View.inflate(this$0, R.layout.listview_headview_10500, null)); 
      this.cdp.setOnClickListener(new m(this, this$0));
      YQ();
    }
    
    public void YQ() {
      if (TableList.g(this.cdk) == null)
        for (TableEntity tableEntity : this.bjv) {
          TableList.a a = TableList.b(this.cdk);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(tableEntity.XY());
          stringBuilder.append("");
          a.jt(stringBuilder.toString());
        }  
      if (this.bjv.size() == 0) {
        if (TableList.b(this.cdk).getCount() == 0) {
          this.cdq.setVisibility(8);
          this.cdp.setVisibility(8);
        } else {
          this.cdq.setVisibility(0);
          if (TableList.e(this.cdk))
            this.cdp.setVisibility(0); 
        } 
      } else {
        if (TableList.e(this.cdk))
          this.cdp.setVisibility(0); 
        this.cdq.setVisibility(8);
      } 
      notifyDataSetChanged();
      this.bWY.setSelection(0);
    }
    
    public TableEntity fZ(int param1Int) { return (TableEntity)this.bjv.get(param1Int); }
    
    public int getCount() { return this.bjv.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a2;
      a a1;
      if (param1View == null) {
        a2 = View.inflate(this.cdk, R.layout.pos_table_main_item, null);
        a1 = new a(this, a2.findViewById(R.id.icon), (TextView)a2.findViewById(R.id.area_name), (TextView)a2.findViewById(R.id.table_name));
        a2.setTag(a1);
      } else {
        a a = (a)a1.getTag();
        a2 = a1;
        a1 = a;
      } 
      TableEntity tableEntity = fZ(param1Int);
      a1.aKu.setText(tableEntity.Vz());
      if (by.isNull(TableList.h(this.cdk))) {
        TextView textView = a1.cdu;
        TableList.a a = TableList.b(this.cdk);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(tableEntity.XY());
        stringBuilder.append("");
        textView.setText(a.jt(stringBuilder.toString()));
      } else {
        a1.cdu.setText(TableList.h(this.cdk));
      } 
      if (TableList.d(this.cdk)) {
        a1.cdt.setVisibility(0);
        boolean bool = s(tableEntity);
        if (bool)
          TableList.b(this.cdk, tableEntity); 
        a1.cdt.setSelected(bool);
        if ((tableEntity.getState() != 0 && !tableEntity.Ya()) || tableEntity.Yi()) {
          a1.cdt.setEnabled(false);
          a1.cdt.setVisibility(4);
          a1.cdu.setTextColor(this.cdk.getResources().getColor(R.color.pos_text_grey));
          a1.aKu.setTextColor(this.cdk.getResources().getColor(R.color.pos_text_grey));
          return a2;
        } 
        a1.cdt.setVisibility(0);
        a1.cdu.setTextColor(this.cdk.getResources().getColor(R.color.pos_text_black));
        a1.aKu.setTextColor(this.cdk.getResources().getColor(R.color.pos_text_black));
        return a2;
      } 
      a1.cdt.setVisibility(8);
      a1.cdu.setTextColor(this.cdk.getResources().getColor(R.color.pos_text_black));
      a1.aKu.setTextColor(this.cdk.getResources().getColor(R.color.pos_text_black));
      return a2;
    }
    
    public boolean s(TableEntity param1TableEntity) { return param1TableEntity.Ya(); }
    
    public void t(TableEntity param1TableEntity) {
      for (TableEntity tableEntity : this.bjv) {
        if (s(tableEntity))
          u(tableEntity); 
      } 
      TableList.a(this.cdk, param1TableEntity.getID());
      TableList.b(this.cdk, param1TableEntity);
      param1TableEntity.eE(true);
    }
    
    public void u(TableEntity param1TableEntity) { param1TableEntity.eE(false); }
    
    public void v(TableEntity param1TableEntity) {
      if (TableList.d(this.cdk)) {
        if (!s(param1TableEntity))
          t(param1TableEntity); 
        notifyDataSetChanged();
      } 
    }
    
    class a {
      TextView aKu;
      
      View cdt;
      
      TextView cdu;
      
      public a(TableList.b this$0, View param2View, TextView param2TextView1, TextView param2TextView2) {
        this.cdt = param2View;
        this.cdu = param2TextView1;
        this.aKu = param2TextView2;
      }
    }
  }
  
  class a {
    TextView aKu;
    
    View cdt;
    
    TextView cdu;
    
    public a(TableList this$0, View param1View, TextView param1TextView1, TextView param1TextView2) {
      this.cdt = param1View;
      this.cdu = param1TextView1;
      this.aKu = param1TextView2;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\tablelist\TableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */