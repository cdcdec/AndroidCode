package com.laiqian.member.setting.discount;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import com.laiqian.entity.h;
import com.laiqian.member.model.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.util.n;
import com.laiqian.vip.R;
import java.util.ArrayList;

public class RechargePrivilegeActivity extends ActivityRoot {
  private ArrayList<h> bDg;
  
  b bDh;
  
  private c bDi;
  
  GridView bDj;
  
  private boolean bDk;
  
  private int bDl = 1;
  
  Context context;
  
  private final int size = 50;
  
  private void RZ() {
    null = new a(this.context);
    Cursor cursor = null.aY(this.bDl, 50);
    null.close();
    ArrayList arrayList = new ArrayList();
    if (cursor != null) {
      while (cursor.moveToNext()) {
        h h = new h();
        h.aSc = cursor.getDouble(1);
        h.aSd = cursor.getDouble(2);
        h.id = cursor.getString(3);
        arrayList.add(h);
      } 
      cursor.close();
      if (arrayList.size() > 0)
        this.bDg.addAll(arrayList); 
      this.bDh.notifyDataSetChanged();
    } 
  }
  
  private void yS() {
    this.bDl = 0;
    null = new a(this.context);
    Cursor cursor = null.aY(this.bDl, 50);
    null.close();
    ArrayList arrayList = new ArrayList();
    if (cursor != null) {
      while (cursor.moveToNext()) {
        h h = new h();
        h.aSc = cursor.getDouble(1);
        h.aSd = cursor.getDouble(2);
        h.id = cursor.getString(3);
        arrayList.add(h);
      } 
      cursor.close();
      if (this.bDg != null)
        this.bDg.clear(); 
      if (arrayList.size() > 0 && this.bDg != null)
        this.bDg.addAll(arrayList); 
      this.bDh.notifyDataSetChanged();
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(R.layout.recharge_privilege_activity);
    this.context = this;
    setTitleTextViewHideRightView(R.string.create_recharge_discount);
    this.bDj = (GridView)findViewById(R.id.body);
    this.bDj.setOnScrollListener(new a(this));
    this.bDg = new ArrayList();
    this.bDh = new b(this, this.bDg);
    this.bDj.setAdapter(this.bDh);
    yS();
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.bDi != null) {
      this.bDi.dismiss();
      this.bDi = null;
    } 
    if (this.bDg != null) {
      this.bDg.clear();
      this.bDg = null;
    } 
  }
  
  public class a implements AbsListView.OnScrollListener {
    public a(RechargePrivilegeActivity this$0) {}
    
    public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) {
      boolean bool;
      RechargePrivilegeActivity rechargePrivilegeActivity = this.bDm;
      if (param1Int1 + param1Int2 == param1Int3) {
        bool = true;
      } else {
        bool = false;
      } 
      RechargePrivilegeActivity.a(rechargePrivilegeActivity, bool);
    }
    
    public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {
      if (RechargePrivilegeActivity.a(this.bDm) && param1Int == 0) {
        RechargePrivilegeActivity.b(this.bDm);
        RechargePrivilegeActivity.c(this.bDm);
      } 
    }
  }
  
  class b extends BaseAdapter {
    private View bDn;
    
    View.OnClickListener bDo = new b(this);
    
    private ArrayList<h> bjv;
    
    public b(RechargePrivilegeActivity this$0, ArrayList<h> param1ArrayList) {
      this.bDn = this$0.findViewById(R.id.no_data);
      this.bDn.setVisibility(8);
      if (RechargePrivilegeActivity.d(this$0) != null) {
        RechargePrivilegeActivity.d(this$0).dismiss();
        RechargePrivilegeActivity.a(this$0, null);
      } 
      RechargePrivilegeActivity.a(this$0, new c(this$0.context));
      RechargePrivilegeActivity.d(this$0).a(new a(this, this$0));
      this.bjv = param1ArrayList;
    }
    
    public h fO(int param1Int) { return (param1Int >= this.bjv.size() || param1Int < 0) ? null : (h)this.bjv.get(param1Int); }
    
    public int getCount() { return this.bjv.size() + 1; }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a;
      if (param1View == null) {
        param1View = View.inflate(this.bDm.context, R.layout.vip_list_item_recharge, null);
        View view1 = param1View.findViewById(R.id.add);
        View view2 = param1View.findViewById(R.id.attribute_l);
        a = new a(this, view1, view2, (TextView)view2.findViewById(R.id.name), (TextView)view2.findViewById(R.id.value));
        param1View.setTag(a);
        param1View.setOnClickListener(this.bDo);
      } else {
        a = (a)param1View.getTag();
      } 
      h h = fO(param1Int);
      a.bDs.setTag(h);
      if (param1Int == this.bjv.size()) {
        a.bDr.setVisibility(0);
        a.bDs.setVisibility(8);
        return param1View;
      } 
      a.bDr.setVisibility(8);
      a.bDs.setVisibility(0);
      String str2;
      a.aKu.setText((str2 = n.b(this.bDm.context, Double.valueOf(h.aSc), true, false)).format(this.bDm.context.getResources().getString(R.string.recharge), new Object[] { str2 }));
      String str1;
      a.bDt.setText((str1 = n.b(this.bDm.context, Double.valueOf(h.aSd), true, false)).format(this.bDm.context.getResources().getString(R.string.gift), new Object[] { str1 }));
      return param1View;
    }
    
    class a {
      TextView aKu;
      
      View bDr;
      
      View bDs;
      
      TextView bDt;
      
      public a(RechargePrivilegeActivity.b this$0, View param2View1, View param2View2, TextView param2TextView1, TextView param2TextView2) {
        this.bDr = param2View1;
        this.bDs = param2View2;
        this.aKu = param2TextView1;
        this.bDt = param2TextView2;
      }
    }
  }
  
  class a {
    TextView aKu;
    
    View bDr;
    
    View bDs;
    
    TextView bDt;
    
    public a(RechargePrivilegeActivity this$0, View param1View1, View param1View2, TextView param1TextView1, TextView param1TextView2) {
      this.bDr = param1View1;
      this.bDs = param1View2;
      this.aKu = param1TextView1;
      this.bDt = param1TextView2;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\discount\RechargePrivilegeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */