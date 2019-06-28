package com.laiqian.promotion.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.laiqian.basic.LQKVersion;
import com.laiqian.product.models.ProductTypeEntity;
import com.laiqian.promotion.R;
import com.laiqian.promotion.a.c;
import com.laiqian.promotion.d.e;
import com.laiqian.promotion.g.a;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.util.m;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.List;

public class ProductTypePromotionActivity extends ActivityRoot implements a {
  private RecyclerView Lj;
  
  private List<ProductTypeEntity> ari = new ArrayList();
  
  private r cSU;
  
  private c cWa;
  
  private e cWb;
  
  private List<ProductTypeEntity> cWc;
  
  private void alL() {
    if (this.cWb == null)
      this.cWb = new e(this, this); 
    this.cWb.N(this.cWc);
  }
  
  private void alM() {
    this.cSU = new r(this, new d(this));
    this.cSU.setTitle(getString(R.string.pos_quit_save_hint_dialog_title));
    this.cSU.s(getString(R.string.pos_quit_save_hint_dialog_msg));
    this.cSU.t(getString(R.string.pos_quit_save_hint_dialog_sure));
    this.cSU.oZ(getString(R.string.pos_quit_save_hint_dialog_cancel));
  }
  
  private void initView() {
    this.Lj = (RecyclerView)findViewById(R.id.body);
    View view = getActivity().getLayoutInflater().inflate(R.layout.promotion_product_type_nodata, null, false);
    view.findViewById(R.id.nodata).setOnClickListener(new m.c(this, LQKVersion.bF("productList")));
    this.cWa = new c(this.ari);
    this.cWa.be(false);
    this.cWa.setEmptyView(view);
    this.cWa.L(this.cWc);
    this.Lj.c(new LinearLayoutManager(this));
    this.Lj.a(this.cWa);
    this.Lj.a(new b(this));
    this.Lj.a(new c(this));
  }
  
  private void save() {
    String str;
    boolean bool;
    ArrayList arrayList = this.cWa.alo();
    int i = arrayList.size();
    if (i == this.cWa.getItemCount()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (i == 0) {
      n.eP(R.string.pos_must_select_one_product_type);
      return;
    } 
    if (bool) {
      str = getString(R.string.pos_people_type_not_limit);
    } else {
      str = String.format(getString(R.string.pos_promotion_selected_n_product_type), new Object[] { Integer.valueOf(i) });
    } 
    Intent intent = new Intent();
    intent.putExtra("typeName", str);
    intent.putExtra("selectAll", bool);
    intent.putParcelableArrayListExtra("selectData", arrayList);
    setResult(-1, intent);
    finish();
  }
  
  public void P(List<ProductTypeEntity> paramList) { this.cWa.d(paramList); }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetCustomTitle(R.layout.activity_product_type_promotion);
    setTitleTextView(R.string.pos_promotion_type_setting);
    setTitleTextViewRight(R.string.save, new a(this));
    this.cWc = getIntent().getParcelableArrayListExtra("selectData");
    initView();
    alM();
    alL();
  }
  
  protected void onStart() { super.onStart(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\promotio\\ui\ProductTypePromotionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */