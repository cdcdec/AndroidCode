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
import com.laiqian.opentable.a.a;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.ImageCheckBox;
import com.laiqian.ui.a.r;
import com.laiqian.util.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KitchenAreaIgnoreActivity extends ActivityRoot {
  private Button aGS;
  
  private ArrayList<Long> cJP = new ArrayList();
  
  private a cJQ;
  
  private void E(List<Long> paramList) {
    F(paramList);
    finish();
  }
  
  private void F(List<Long> paramList) {
    Intent intent = new Intent();
    intent.putExtra("AREA_IGNORE_LIST", new ArrayList(paramList));
    setResult(-1, intent);
  }
  
  public static Intent a(Context paramContext, Collection<Long> paramCollection) {
    Intent intent = new Intent(paramContext, KitchenAreaIgnoreActivity.class);
    intent.putExtra("AREA_IGNORE_LIST", new ArrayList(paramCollection));
    return intent;
  }
  
  private void abR() { E(this.cJQ.ahu()); }
  
  private void abi() {
    r r = new r(this, new d(this));
    r.setTitle(getString(2131627735));
    r.s(getString(2131627733));
    r.t(getString(2131627734));
    r.oZ(getString(2131627732));
    r.show();
  }
  
  private void aht() { this.cJP = (ArrayList)getIntent().getSerializableExtra("AREA_IGNORE_LIST"); }
  
  public static List<Long> p(Intent paramIntent) { return (ArrayList)paramIntent.getSerializableExtra("AREA_IGNORE_LIST"); }
  
  private void setupViews() {
    this.aGS = (Button)findViewById(2131299879);
    findViewById(2131299878).setOnClickListener(new b(this));
    this.aGS.setText(getString(2131629495));
    this.aGS.setOnClickListener(new c(this));
    ((TextView)findViewById(2131299889)).setText(2131628889);
    ListView listView = (ListView)findViewById(2131298072);
    listView.setEmptyView(findViewById(16908292));
    View view = new View(this);
    view.setMinimumHeight(24);
    listView.addHeaderView(view);
    listView.addFooterView(view);
    a a1 = new a(this);
    ArrayList arrayList = a1.Xo();
    a1.close();
    this.cJQ = new a(this, arrayList, this.cJP);
    listView.setAdapter(this.cJQ);
  }
  
  boolean Az() {
    List list = this.cJQ.ahu();
    return !this.cJP.equals(list);
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
    
    a(Context param1Context, List<a> param1List1, List<Long> param1List2) {
      this.context = param1Context;
      for (a a1 : param1List1) {
        a a2 = new a(a1);
        if (param1List2.contains(Long.valueOf(a1.getId()))) {
          a2.cJX = true;
        } else {
          a2.cJX = false;
        } 
        this.cJS.add(a2);
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
    
    List<Long> ahu() {
      ArrayList arrayList = new ArrayList();
      for (a a1 : this.cJS) {
        if (a1.cJX)
          arrayList.add(Long.valueOf(a1.cJW.getId())); 
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
      a a1 = ir(param1Int);
      b.czX.setText(a1.cJW.XX());
      b.cJZ.a(new e(this, a1));
      b.cJZ.setChecked(a1.cJX ^ true);
      b.cJY.setOnClickListener(new f(this, b));
      return param1View;
    }
    
    public a ir(int param1Int) { return (a)this.cJS.get(param1Int); }
    
    public static class a {
      final a cJW;
      
      boolean cJX = false;
      
      public a(a param2a) { this.cJW = param2a; }
    }
    
    public class b {
      ViewGroup cJY;
      
      ImageCheckBox cJZ;
      
      TextView czX;
      
      public b(KitchenAreaIgnoreActivity.a this$0) {}
    }
  }
  
  public static class a {
    final a cJW;
    
    boolean cJX = false;
    
    public a(a param1a) { this.cJW = param1a; }
  }
  
  public class b {
    ViewGroup cJY;
    
    ImageCheckBox cJZ;
    
    TextView czX;
    
    public b(KitchenAreaIgnoreActivity this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\KitchenAreaIgnoreActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */