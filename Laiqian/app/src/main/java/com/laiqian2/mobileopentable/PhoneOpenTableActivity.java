package com.laiqian.mobileopentable;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;
import com.laiqian.main.bb;
import com.laiqian.opentable.R;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.opentable.pos.a;
import com.laiqian.opentable.pos.b;
import com.laiqian.opentable.pos.j;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.ui.a.r;
import com.laiqian.util.ae;
import com.laiqian.util.bd;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Locale;

public class PhoneOpenTableActivity extends MobileActivityRoot implements b {
  private a bMo;
  
  RecyclerView bMp;
  
  m bMq;
  
  View bMr;
  
  GridView bMs;
  
  private o bMt;
  
  private View bMu;
  
  View bMv;
  
  TableEntity bMw;
  
  int bMx;
  
  a bhb;
  
  private void TG() {
    View view = findViewById(R.id.ui_titlebar_left_icon);
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    layoutParams.width = ae.b(Uq(), 20.0F);
    layoutParams.height = ae.b(Uq(), 20.0F);
    view.setLayoutParams(layoutParams);
    view.setBackgroundResource(R.drawable.print_white);
    this.bMv = findViewById(R.id.ui_titlebar_left);
    this.bMp = (RecyclerView)findViewById(R.id.region_recyclerview_horizontal);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    linearLayoutManager.setOrientation(0);
    this.bMp.c(linearLayoutManager);
    this.bMr = findViewById(R.id.share);
    this.bMr.setVisibility(0);
    this.bMs = (GridView)findViewById(R.id.original_list);
    this.bMu = findViewById(R.id.ll_table);
    this.bMu.setVisibility(0);
    Nk();
  }
  
  private void yP() {
    this.bMv.setVisibility(8);
    this.bMr.setOnClickListener(new i(this));
  }
  
  public void J(ArrayList<a> paramArrayList) { this.bMq = new m(this, paramArrayList, this.bMp, new j(this)); }
  
  public void K(ArrayList<TableEntity> paramArrayList) { this.bMt = new o(this, paramArrayList, this.bMs, new k(this), null, null, null); }
  
  public void Nj() { this.bMo.Yt(); }
  
  public void Nk() { this.bMo.Yu(); }
  
  public void a(TableEntity paramTableEntity, ArrayList<PendingFullOrderDetail> paramArrayList, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(a parama, TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt) {
    if (paramInt != -1) {
      c c = b.b(paramTableEntity1.Yh(), paramInt);
      paramTableEntity2.Yg().gy(c.Ym());
    } 
    this.bMo.a(parama, paramTableEntity1, paramTableEntity2, paramInt);
  }
  
  public void a(a parama, boolean paramBoolean) {
    this.bhb = parama;
    if (parama == null) {
      this.bMo.t(0L, 0L);
      return;
    } 
    this.bMo.t(parama.getId(), 0L);
  }
  
  public void a(PendingFullOrderDetail paramPendingFullOrderDetail, TableEntity paramTableEntity, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(PendingFullOrderDetail paramPendingFullOrderDetail, String paramString) {}
  
  public void a(boolean paramBoolean1, int paramInt, a parama, TableEntity paramTableEntity, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, bb parambb, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void a(boolean paramBoolean1, TableEntity paramTableEntity, PendingFullOrderDetail.c paramc, PendingFullOrderDetail paramPendingFullOrderDetail, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, a parama, TableEntity paramTableEntity1, TableEntity paramTableEntity2, int paramInt, boolean paramBoolean2) {
    if (paramBoolean1) {
      finish();
      return;
    } 
    n.eP(R.string.diagnose_state_failed);
  }
  
  public void dl(boolean paramBoolean) {
    if (paramBoolean) {
      Nk();
      return;
    } 
    Toast.makeText(this, getString(R.string.printer_settings_init_failed), 0).show();
  }
  
  public void f(TableEntity paramTableEntity) {
    if (!bd.bH(this)) {
      n.o(getString(R.string.connect_network));
      return;
    } 
    if (paramTableEntity.getState() == 2) {
      n.o(getString(R.string.table_already_used));
      return;
    } 
    r r = new r(this, new l(this, paramTableEntity));
    r.setTitle(getString(R.string.table_move_confirm_title));
    r.s(String.format(Locale.getDefault(), "%s %s %s", new Object[] { getString(R.string.table_move_confirm_content), paramTableEntity.Vz(), getString(R.string.table_move_confirm_character) }));
    r.show();
  }
  
  public void fa(String paramString) {}
  
  public boolean n(boolean paramBoolean1, boolean paramBoolean2) { return false; }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentViewSetNoTitle(R.layout.order_activity_open_table);
    this.bMo = new j(this, this, null);
    this.bMw = (TableEntity)getIntent().getSerializableExtra("tableEntity");
    this.bMx = getIntent().getIntExtra("tableNumberID", 0);
    TG();
    yP();
  }
  
  public void onDestroy() { super.onDestroy(); }
  
  public void u(ArrayList<a> paramArrayList) {
    if (this.bMq == null) {
      J(paramArrayList);
      if (this.bMt == null) {
        a(null, false);
        return;
      } 
    } else {
      this.bMq.A(paramArrayList);
      this.bMq.notifyDataSetChanged();
      if (paramArrayList != null && paramArrayList.size() > 0)
        a((a)paramArrayList.get(0), false); 
    } 
  }
  
  public void v(ArrayList<TableEntity> paramArrayList) {
    if (this.bMt == null) {
      K(paramArrayList);
      n(true, true);
      return;
    } 
    this.bMt.m(paramArrayList);
    this.bMt.notifyDataSetChanged();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\mobileopentable\PhoneOpenTableActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */