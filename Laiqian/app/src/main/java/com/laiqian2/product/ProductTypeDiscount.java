package com.laiqian.product;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.product.models.l;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.util.m;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductTypeDiscount extends ActivityRoot {
  a cST;
  
  r cSU;
  
  private void save() {
    if (a.a(this.cST)) {
      n.eP(2131628160);
      finish();
      return;
    } 
    n.eP(2131628396);
  }
  
  public boolean beforeCloseActivity() {
    if (a.b(this.cST)) {
      this.cSU.show();
      return true;
    } 
    return false;
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(2131427965);
    setTitleTextView(2131627639);
    setTitleTextViewRight(2131629495, new ef(this));
    ListView listView = (ListView)findViewById(2131296481);
    this.cST = new a(this, null);
    View view = View.inflate(this, 2131427731, null);
    view.setClickable(true);
    listView.addHeaderView(view);
    listView.setAdapter(this.cST);
    view = findViewById(2131298221);
    view.setOnClickListener(new m.c(this, ProductList.class));
    listView.setEmptyView(view);
    listView.setOnItemClickListener(new eg(this));
    this.cSU = new r(this, new eh(this));
    this.cSU.setTitle(getString(2131627735));
    this.cSU.s(getString(2131627733));
    this.cSU.t(getString(2131627734));
    this.cSU.oZ(getString(2131627732));
  }
  
  protected void onDestroy() {
    super.onDestroy();
    a.d(this.cST);
  }
  
  protected void onStart() {
    super.onStart();
    if (this.cST.getCount() == 0)
      a.c(this.cST); 
  }
  
  class a extends BaseAdapter {
    ArrayList<ProductTypeEntity> bjv;
    
    private l cSW;
    
    HashMap<Long, Boolean> cSX;
    
    private a(ProductTypeDiscount this$0) {
      this.cSW = new l(this$0);
      this.bjv = new ArrayList();
      this.cSX = new HashMap();
    }
    
    private void YQ() {
      this.bjv.clear();
      this.cSX.clear();
      for (ProductTypeEntity productTypeEntity : this.cSW.a(true, Boolean.valueOf(true))) {
        this.bjv.add(productTypeEntity);
        this.cSX.put(Long.valueOf(productTypeEntity.aSW), Boolean.valueOf(productTypeEntity.cVd));
      } 
      notifyDataSetChanged();
    }
    
    private boolean ake() {
      HashMap hashMap = new HashMap();
      for (ProductTypeEntity productTypeEntity : this.bjv) {
        if (((Boolean)this.cSX.get(Long.valueOf(productTypeEntity.aSW))).booleanValue() != productTypeEntity.cVd)
          hashMap.put(Long.valueOf(productTypeEntity.aSW), Boolean.valueOf(productTypeEntity.cVd)); 
      } 
      if (hashMap.isEmpty())
        return true; 
      boolean bool = this.cSW.V(hashMap);
      if (bool)
        this.cSV.sendBroadcast(new Intent("pos_activity_change_data_producttype_undiscount")); 
      return bool;
    }
    
    private void closeModel() { this.cSW.close(); }
    
    private boolean xB() {
      for (ProductTypeEntity productTypeEntity : this.bjv) {
        if (((Boolean)this.cSX.get(Long.valueOf(productTypeEntity.aSW))).booleanValue() != productTypeEntity.cVd)
          return true; 
      } 
      return false;
    }
    
    public int getCount() { return this.bjv.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a2;
      a a1;
      if (param1View == null) {
        a2 = View.inflate(this.cSV, 2131427966, null);
        a1 = new a(this, a2.findViewById(2131297292), (TextView)a2.findViewById(2131298198), a2.findViewById(2131296763));
        a2.setTag(a1);
      } else {
        a a3 = (a)a1.getTag();
        a2 = a1;
        a1 = a3;
      } 
      ProductTypeEntity productTypeEntity = jo(param1Int);
      a1.aKu.setText(productTypeEntity.name);
      a1.cSY.setSelected(productTypeEntity.cVd);
      int i = getCount();
      if (i == 1) {
        a1.view.setBackgroundResource(2130772035);
        return a2;
      } 
      if (param1Int == 0) {
        a1.view.setBackgroundResource(2130772043);
        return a2;
      } 
      if (param1Int == i - 1) {
        a1.view.setBackgroundResource(2130772036);
        return a2;
      } 
      a1.view.setBackgroundResource(2130772039);
      return a2;
    }
    
    public ProductTypeEntity jo(int param1Int) { return (ProductTypeEntity)this.bjv.get(param1Int); }
    
    class a {
      TextView aKu;
      
      View cSY;
      
      View view;
      
      public a(ProductTypeDiscount.a this$0, View param2View1, TextView param2TextView, View param2View2) {
        this.view = param2View1;
        this.aKu = param2TextView;
        this.cSY = param2View2;
      }
    }
  }
  
  class a {
    TextView aKu;
    
    View cSY;
    
    View view;
    
    public a(ProductTypeDiscount this$0, View param1View1, TextView param1TextView, View param1View2) {
      this.view = param1View1;
      this.aKu = param1TextView;
      this.cSY = param1View2;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\ProductTypeDiscount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */