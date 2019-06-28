package com.laiqian.product;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.c.a;
import com.laiqian.product.models.o;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.m;
import java.util.ArrayList;

public class ProductTaxRuleActivity extends ActivityRoot {
  private ListView cSf;
  
  private View cSg;
  
  a cSh = null;
  
  ArrayList<o> cwz;
  
  private int index;
  
  private void ajX() {
    this.cwz = (new dq(this)).ajT();
    this.index = this.cwz.size();
    if (this.cSh == null) {
      this.cSh = new a(this);
      this.cSf.setAdapter(this.cSh);
    } 
    this.cSh.notifyDataSetChanged();
  }
  
  private void setupViews() {
    findViewById(2131299835).setOnClickListener(new m.c(this, new Intent(this, ProductTaxRuleEditActivity.class), true));
    this.cSf = (ListView)findViewById(2131298084);
    View view = (this.cSg = findViewById(2131298043)).inflate(this, 2131427731, null);
    this.cSf.addHeaderView(view);
    this.cSf.setOnItemClickListener(new dr(this));
    this.cSf.setDivider(null);
    if (a.zR().Ab()) {
      this.cSg.setVisibility(0);
      this.cSg.setOnClickListener(new ds(this));
    } 
    ajX();
    findViewById(2131296416).setOnClickListener(new dt(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
      return; 
    ajX();
  }
  
  public void onBackPressed() {
    setResult(-1, getIntent());
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetNoTitle(2131427964);
    setupViews();
  }
  
  class a extends BaseAdapter {
    a(ProductTaxRuleActivity this$0) {}
    
    public o fa(int param1Int) { return (o)this.cSi.cwz.get(param1Int); }
    
    public int getCount() { return (this.cSi.cwz != null) ? this.cSi.cwz.size() : 0; }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a1 = new a(this);
      if (param1View == null) {
        param1View = LayoutInflater.from(this.cSi.getActivity()).inflate(2131427963, null);
        a1.ccm = (TextView)param1View.findViewById(2131299778);
        a1.cvO = (TextView)param1View.findViewById(2131299776);
        a1.cSj = (LinearLayout)param1View.findViewById(2131298028);
        param1View.setTag(a1);
      } else {
        a1 = (a)param1View.getTag();
      } 
      o o = fa(param1Int);
      a1.ccm.setText(o.akZ());
      if (o.alb()) {
        a1.cvO.setVisibility(0);
        TextView textView = a1.cvO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(o.ala()));
        stringBuilder.append("%");
        textView.setText(stringBuilder.toString());
      } else {
        a1.cvO.setVisibility(4);
      } 
      if (ProductTaxRuleActivity.b(this.cSi) <= 1) {
        a1.cSj.setBackgroundResource(2130772035);
        return param1View;
      } 
      if (param1Int == 0) {
        a1.cSj.setBackgroundResource(2130772057);
        return param1View;
      } 
      if (param1Int == ProductTaxRuleActivity.b(this.cSi) - 1) {
        a1.cSj.setBackgroundResource(2130772051);
        return param1View;
      } 
      a1.cSj.setBackgroundResource(2130772055);
      return param1View;
    }
    
    public class a {
      LinearLayout cSj;
      
      TextView ccm;
      
      TextView cvO;
      
      public a(ProductTaxRuleActivity.a this$0) {}
    }
  }
  
  public class a {
    LinearLayout cSj;
    
    TextView ccm;
    
    TextView cvO;
    
    public a(ProductTaxRuleActivity this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\ProductTaxRuleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */