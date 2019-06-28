package com.laiqian.print.type;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.laiqian.models.ac;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ImageCheckBox;
import com.laiqian.ui.a.r;
import com.laiqian.util.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KitchenPrintRangeActivity extends ActivityRoot {
  private Button aGS;
  
  a cKa;
  
  private ArrayList<Long> cKb = new ArrayList();
  
  private void E(List<Long> paramList) {
    F(paramList);
    finish();
  }
  
  private void F(List<Long> paramList) {
    Intent intent = new Intent();
    intent.putExtra("PRODUCT_TYPE_IGNORE_LIST", new ArrayList(paramList));
    setResult(-1, intent);
  }
  
  public static Intent a(Context paramContext, Collection<Long> paramCollection) {
    Intent intent = new Intent(paramContext, KitchenPrintRangeActivity.class);
    intent.putExtra("PRODUCT_TYPE_IGNORE_LIST", new ArrayList(paramCollection));
    return intent;
  }
  
  private void abR() { E(this.cKa.ahv()); }
  
  private void abi() {
    r r = new r(this, new i(this));
    r.setTitle(getString(2131627735));
    r.s(getString(2131627733));
    r.t(getString(2131627734));
    r.oZ(getString(2131627732));
    r.show();
  }
  
  private void aht() { this.cKb = (ArrayList)getIntent().getSerializableExtra("PRODUCT_TYPE_IGNORE_LIST"); }
  
  public static List<Long> q(Intent paramIntent) { return (ArrayList)paramIntent.getSerializableExtra("PRODUCT_TYPE_IGNORE_LIST"); }
  
  private void setupViews() {
    this.aGS = (Button)findViewById(2131299879);
    findViewById(2131299878).setOnClickListener(new g(this));
    this.aGS.setText(getString(2131629495));
    this.aGS.setOnClickListener(new h(this));
    ((TextView)findViewById(2131299889)).setText(2131625441);
    ListView listView = (ListView)findViewById(2131298072);
    listView.setEmptyView(findViewById(16908292));
    View view = new View(this);
    view.setMinimumHeight(24);
    listView.addHeaderView(view);
    listView.addFooterView(view);
    this.cKa = new a(this, (new ac(this)).a(true, Boolean.valueOf(false)), this.cKb);
    listView.setAdapter(this.cKa);
  }
  
  boolean Az() {
    List list = this.cKa.ahv();
    return !this.cKb.equals(list);
  }
  
  public void onBackPressed() {
    if (Az()) {
      abi();
      return;
    } 
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    setContentView(2131427379);
    getWindow().setFeatureInt(7, 2131428168);
    aht();
    setupViews();
  }
  
  public static class a extends BaseAdapter {
    private final List<a> cJS = new ArrayList();
    
    private Context context;
    
    a(Context param1Context, List<ProductTypeEntity> param1List1, List<Long> param1List2) {
      this.context = param1Context;
      for (ProductTypeEntity productTypeEntity : param1List1) {
        a a1 = new a(productTypeEntity);
        if (param1List2.contains(Long.valueOf(productTypeEntity.aSW))) {
          a1.cJX = true;
        } else {
          a1.cJX = false;
        } 
        this.cJS.add(a1);
      } 
    }
    
    private void a(b param1b, int param1Int) {
      Drawable drawable;
      if (getCount() == 1) {
        drawable = this.context.getResources().getDrawable(2130772035);
      } else if (param1Int == 0) {
        drawable = this.context.getResources().getDrawable(2130772043);
      } else if (param1Int == getCount() - 1) {
        drawable = this.context.getResources().getDrawable(2130772036);
      } else {
        drawable = this.context.getResources().getDrawable(2130772039);
      } 
      int[] arrayOfInt = ax.dx(param1b.cJY);
      param1b.cJY.setBackground(drawable);
      ax.a(param1b.cJY, arrayOfInt);
      if (param1Int != 0)
        try {
          ((LinearLayout.LayoutParams)param1b.cJY.getLayoutParams()).setMargins(0, -1, 0, 0);
          return;
        } catch (Exception param1b) {
          return;
        }  
    }
    
    List<Long> ahv() {
      ArrayList arrayList = new ArrayList();
      for (a a1 : this.cJS) {
        if (a1.cJX)
          arrayList.add(Long.valueOf(a1.cKg.aSW)); 
      } 
      return arrayList;
    }
    
    public int getCount() { return this.cJS.size(); }
    
    public long getItemId(int param1Int) { return param1Int; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      b b;
      if (param1View == null) {
        param1View = LayoutInflater.from(this.context).inflate(2131427651, null);
        b = new b(this);
        b.cJY = (ViewGroup)param1View.findViewById(2131297298);
        b.czX = (TextView)param1View.findViewById(2131299408);
        b.cJZ = (ImageCheckBox)param1View.findViewById(2131298290);
        param1View.setTag(b);
      } else {
        b = (b)param1View.getTag();
      } 
      a(b, param1Int);
      a a1 = is(param1Int);
      b.czX.setText(a1.cKg.name);
      b.cJZ.a(new j(this, a1));
      b.cJZ.setChecked(a1.cJX ^ true);
      b.cJY.setOnClickListener(new k(this, b));
      return param1View;
    }
    
    public a is(int param1Int) { return (a)this.cJS.get(param1Int); }
    
    public static class a {
      boolean cJX = false;
      
      final ProductTypeEntity cKg;
      
      public a(ProductTypeEntity param2ProductTypeEntity) { this.cKg = param2ProductTypeEntity; }
    }
    
    public class b {
      ViewGroup cJY;
      
      ImageCheckBox cJZ;
      
      TextView czX;
      
      public b(KitchenPrintRangeActivity.a this$0) {}
    }
  }
  
  public static class a {
    boolean cJX = false;
    
    final ProductTypeEntity cKg;
    
    public a(ProductTypeEntity param1ProductTypeEntity) { this.cKg = param1ProductTypeEntity; }
  }
  
  public class b {
    ViewGroup cJY;
    
    ImageCheckBox cJZ;
    
    TextView czX;
    
    public b(KitchenPrintRangeActivity this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\KitchenPrintRangeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */