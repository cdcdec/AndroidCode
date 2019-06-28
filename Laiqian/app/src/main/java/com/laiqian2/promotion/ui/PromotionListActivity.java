package com.laiqian.promotion.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.ac;
import com.laiqian.entity.ai;
import com.laiqian.promotion.R;
import com.laiqian.promotion.a.b;
import com.laiqian.promotion.a.d;
import com.laiqian.promotion.d.c;
import com.laiqian.promotion.g.c;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.container.aa;
import com.laiqian.ui.container.ab;
import com.laiqian.ui.container.y;
import com.laiqian.ui.s;
import java.util.ArrayList;
import java.util.List;

public class PromotionListActivity extends ActivityRoot implements c {
  private ArrayList<ai> bjv;
  
  a cWE;
  
  private d cWF;
  
  private b cWG;
  
  private c cWH;
  
  private List<ac> list = new ArrayList();
  
  private Context mContext;
  
  aa titleBar;
  
  private void ama() {
    this.bjv = new ArrayList();
    String[] arrayOfString1 = this.mContext.getResources().getStringArray(R.array.promotion_type_name);
    String[] arrayOfString2 = this.mContext.getResources().getStringArray(R.array.promotion_type_create);
    int[] arrayOfInt = this.mContext.getResources().getIntArray(R.array.promotion_type_id);
    TypedArray typedArray = this.mContext.getResources().obtainTypedArray(R.array.promotion_type_list_item_left_icon);
    for (byte b1 = 0; b1 < arrayOfString1.length; b1++) {
      ai ai = (new ai.a()).dr(arrayOfString1[b1]).ds(arrayOfString2[b1]).eE(typedArray.getResourceId(b1, 0)).eD(arrayOfInt[b1]).HJ();
      if (RootApplication.getLaiqianPreferenceManager().QV() != 1 || !arrayOfString1[b1].equals(this.mContext.getString(R.string.pos_promotion_recharge_gift_some)))
        this.bjv.add(ai); 
    } 
    typedArray.recycle();
    this.cWF = new d(this.bjv);
    this.cWF.be(false);
    this.cWG = new b(this.list);
    this.cWG.be(false);
    View view1 = getLayoutInflater().inflate(R.layout.pos_promotion_ing_list_title, (ViewGroup)this.cWE.cWM.getParent(), false);
    View view2 = getLayoutInflater().inflate(R.layout.pos_promotion_ing_list_blank, (ViewGroup)this.cWE.cWM.getParent(), false);
    this.cWG.bq(view1);
    this.cWG.setEmptyView(view2);
    this.cWG.bf(true);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
    this.cWE.cWL.c(gridLayoutManager);
    this.cWE.cWL.a(this.cWF);
    this.cWE.cWM.c(new LinearLayoutManager(this.mContext));
    this.cWE.cWM.a(this.cWG);
    this.cWG.a(new x(this));
  }
  
  private void amb() { this.cWF.a(new y(this)); }
  
  private void initData() {
    this.cWH = new c(this, this);
    this.cWH.alH();
  }
  
  private void initView() {
    this.titleBar.tvTitle.setText(getString(R.string.pos_title_promotion));
    this.titleBar.brj.setVisibility(8);
    this.cWE.cWK.dxF.getView().setBackgroundColor(getResources().getColor(R.color.red_color_10500));
    this.cWE.cWJ.dxF.getView().setBackgroundColor(getResources().getColor(R.color.red_color_10500));
    ((TextView)this.cWE.cWK.dxG.getView()).setText(R.string.pos_promotion_ing);
    ((TextView)this.cWE.cWJ.dxG.getView()).setText(R.string.pos_promotion_type);
  }
  
  public void av(ArrayList<ac> paramArrayList) { this.cWG.l(paramArrayList); }
  
  public void gw(boolean paramBoolean) {}
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    requestWindowFeature(7);
    this.cWE = a.H(this);
    this.titleBar = aa.M(this);
    this.mContext = this;
    initView();
    ama();
    amb();
  }
  
  protected void onResume() {
    super.onResume();
    initData();
  }
  
  static class a extends ab<ViewGroup> {
    public static final int aCt = R.layout.activity_promotion_list;
    
    public y cWJ = new y(R.id.layout_promotion_type);
    
    public y cWK = new y(R.id.layout_promotion_list);
    
    RecyclerView cWL;
    
    RecyclerView cWM;
    
    public a(int param1Int, View param1View) {
      super(param1Int);
      this.cWL = (RecyclerView)s.z(param1View, R.id.rcv_promotion_type);
      this.cWM = (RecyclerView)s.z(param1View, R.id.rcv_promotion_list);
    }
    
    public static a H(Activity param1Activity) {
      View view = LayoutInflater.from(param1Activity).inflate(aCt, null);
      param1Activity.setContentView(view);
      a a1 = new a(16908290, view);
      a1.S(view);
      return a1;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\PromotionListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */