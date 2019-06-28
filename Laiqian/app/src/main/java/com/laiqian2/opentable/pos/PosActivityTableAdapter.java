package com.laiqian.opentable.pos;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.jakewharton.b.c;
import com.laiqian.entity.s;
import com.laiqian.opentable.R;
import com.laiqian.opentable.b.r;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.a;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.opentable.common.x;
import com.laiqian.opentable.tablelist.TableList;
import com.laiqian.ordertool.c.a;
import com.laiqian.pos.hold.PendingFullOrderDetail;
import com.laiqian.ui.a.ax;
import com.laiqian.ui.a.r;
import com.laiqian.util.av;
import com.laiqian.util.by;
import com.laiqian.util.n;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PosActivityTableAdapter extends BaseAdapter {
  boolean bBoss = true;
  
  private a bMB;
  
  private AbsListView bjt;
  
  private ArrayList<TableEntity> bjv;
  
  private final TableEntity cbP = new TableEntity(0L, 0L, null, false, false, 0L, new c());
  
  private final TableEntity cbQ = new TableEntity(0L, 0L, null, false, false, 0L, new c());
  
  private x cbR;
  
  private ArrayList<TableEntity> cbS;
  
  private r cbT;
  
  private ax cbU;
  
  private boolean cbV;
  
  private final b cbW;
  
  private ArrayList<a> cbX;
  
  private List<Long> cbY;
  
  private SimpleDateFormat cbZ;
  
  private FragmentActivity cbv;
  
  CharSequence[] cca;
  
  CharSequence[] ccb;
  
  final CharSequence ccc;
  
  final CharSequence ccd;
  
  final CharSequence cce;
  
  final CharSequence ccf;
  
  private int index = -1;
  
  public PosActivityTableAdapter(FragmentActivity paramFragmentActivity, AbsListView paramAbsListView, ArrayList<TableEntity> paramArrayList, b paramb, a parama, Class<? extends TableList> paramClass, c<s> paramc1, c<Boolean> paramc2) { this(paramFragmentActivity, paramAbsListView, paramArrayList, paramb, parama, paramClass, null, paramc1, paramc2); }
  
  public PosActivityTableAdapter(FragmentActivity paramFragmentActivity, AbsListView paramAbsListView, ArrayList<TableEntity> paramArrayList, b paramb, a parama, Class<? extends TableList> paramClass, List<Long> paramList, c<s> paramc1, c<Boolean> paramc2) {
    this.cbv = paramFragmentActivity;
    this.cbW = paramb;
    this.cbS = paramArrayList;
    this.bjt = paramAbsListView;
    this.ccc = this.cbv.getText(R.string.pos_open_table_edit);
    this.ccd = this.cbv.getText(R.string.pos_empty_table);
    this.cce = this.cbv.getText(R.string.pos_joining_table);
    this.ccf = this.cbv.getText(R.string.pos_moving_table);
    paramAbsListView.setAdapter(this);
    this.cbZ = new SimpleDateFormat("HH:mm");
    this.cbR = new x(this.cbv);
    this.cbR.a(paramc1, paramc2);
    paramAbsListView.setOnItemClickListener(new aq(this));
    CharSequence[] arrayOfCharSequence = new av(this.cbv);
    String str = arrayOfCharSequence.atp();
    arrayOfCharSequence.close();
    this.bBoss = "150001".equals(str);
    this.cca = new CharSequence[] { this.ccc };
    if (this.bBoss && b.XD()) {
      CharSequence[] arrayOfCharSequence1 = new CharSequence[4];
      arrayOfCharSequence1[0] = this.ccf;
      arrayOfCharSequence1[1] = this.cce;
      arrayOfCharSequence1[2] = this.ccc;
      arrayOfCharSequence1[3] = this.ccd;
    } else {
      arrayOfCharSequence = new CharSequence[3];
      arrayOfCharSequence[0] = this.ccf;
      arrayOfCharSequence[1] = this.cce;
      arrayOfCharSequence[2] = this.ccc;
    } 
    this.ccb = arrayOfCharSequence;
    this.cbU = a(new CharSequence[][] { this.ccb });
    paramAbsListView.setOnItemLongClickListener(new ar(this));
    this.cbT = new r(this.cbv, parama, paramClass);
    this.cbT.a(new as(this));
    this.cbY = paramList;
  }
  
  private void a(View paramView, TableEntity paramTableEntity, a parama) {
    parama.bNa.setVisibility(8);
    parama.bMY.setVisibility(8);
    parama.ccq.setVisibility(0);
    parama.ccp.setBackgroundResource(R.drawable.pos_activity_table_item_check_background);
    parama.bMW.setVisibility(8);
    parama.bMX.setVisibility(0);
    parama.cco = paramTableEntity;
    TextView textView = parama.ccn;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.XZ());
    stringBuilder.append(this.cbv.getString(R.string.pos_shop_info_staff_count_unit));
    textView.setText(stringBuilder.toString());
    parama.ccq.setText("");
    parama.ccm.setVisibility(0);
    parama.ccm.setText(paramTableEntity.Vz());
    parama.ccp.setActivated(false);
    if (this.cbY == null)
      return; 
    Iterator iterator = this.cbY.iterator();
    while (iterator.hasNext()) {
      long l = ((Long)iterator.next()).longValue();
      if (paramTableEntity.getID() == l) {
        paramView.setEnabled(false);
        return;
      } 
      paramView.setEnabled(true);
    } 
  }
  
  private void a(TableEntity paramTableEntity, a parama) {
    c c = paramTableEntity.Yg();
    parama.ccm.setVisibility(0);
    parama.ccq.setVisibility(8);
    parama.ccp.setBackgroundResource(R.drawable.pos_activity_table_item_check_background);
    parama.bMW.setVisibility(0);
    parama.bMX.setVisibility(8);
    parama.cco = paramTableEntity;
    TextView textView = parama.ccn;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramTableEntity.Yb());
    stringBuilder.append(this.cbv.getString(R.string.pos_shop_info_staff_count_unit));
    textView.setText(stringBuilder.toString());
    parama.ccm.setText(paramTableEntity.Vz());
    parama.ccp.setActivated(paramTableEntity.Ya());
    if (paramTableEntity.Xy() == 3)
      parama.bNa.setVisibility(0); 
    if (paramTableEntity.getState() == 2) {
      if (paramTableEntity.Yh().size() > 1) {
        parama.ccr.setVisibility(0);
        parama.bMY.setVisibility(8);
        parama.bMW.setVisibility(0);
        parama.bqW.setText(R.string.opentable_joing);
        return;
      } 
      parama.ccr.setVisibility(8);
      int i = c.Yn();
      if (i != 2) {
        if (i != 5)
          return; 
        parama.bMY.setVisibility(0);
        parama.bMW.setVisibility(8);
        return;
      } 
      parama.bMY.setVisibility(8);
      parama.bMW.setVisibility(0);
      parama.bqW.setText(this.cbZ.format(new Date(paramTableEntity.DP())));
      return;
    } 
    if (paramTableEntity.getState() == 5) {
      parama.ccr.setVisibility(8);
      parama.bMY.setVisibility(0);
      parama.bMW.setVisibility(8);
    } 
  }
  
  private void a(String paramString, TableEntity paramTableEntity) {
    if (!by.isNull(paramString)) {
      PendingFullOrderDetail pendingFullOrderDetail = b.jf(paramString);
      if (pendingFullOrderDetail != null && this.cbW != null)
        this.cbW.a(pendingFullOrderDetail, paramTableEntity); 
    } 
  }
  
  private void b(View paramView, TableEntity paramTableEntity) { this.cbW.c(paramTableEntity); }
  
  private void f(TableEntity paramTableEntity, int paramInt) {
    r r1 = new r(this.cbv, new at(this, paramTableEntity, paramInt));
    r1.setTitle(this.cbv.getString(R.string.new_pos_confirm_title));
    r1.s(this.cbv.getString(R.string.pos_open_table_clear));
    r1.t(this.cbv.getString(R.string.pos_quit_save_hint_dialog_cancel));
    r1.oZ(this.cbv.getString(R.string.pos_confirm));
    r1.show();
  }
  
  private void h(TableEntity paramTableEntity) {
    s s = b.cc(paramTableEntity.getID());
    if (s != null) {
      this.cbR.d(s);
      a(s.aSH, paramTableEntity);
      return;
    } 
    this.cbW.c(this.bMB);
  }
  
  public void A(ArrayList<TableEntity> paramArrayList) { this.cbS = paramArrayList; }
  
  public void Oc() {
    ArrayList arrayList;
    if (this.cbv.isFinishing())
      return; 
    if (this.bMB == null) {
      arrayList = null;
    } else {
      n.println("查询了桌号数据");
      ArrayList arrayList1 = this.cbS;
      arrayList = arrayList1;
      if (this.cbV)
        if (arrayList1.isEmpty()) {
          arrayList1.add(this.cbP);
          arrayList = arrayList1;
        } else {
          arrayList1.add(this.cbQ);
          arrayList = arrayList1;
        }  
    } 
    if (this.bjv != null)
      this.bjv.clear(); 
    this.bjv = arrayList;
    this.cbW.x(this.bjv);
    notifyDataSetChanged();
  }
  
  public void Z(ArrayList<a> paramArrayList) { this.cbX = paramArrayList; }
  
  public ax a(CharSequence[][] paramArrayOfCharSequence) { return new ax(this.cbv, paramArrayOfCharSequence, new au(this)); }
  
  public void a(CharSequence paramCharSequence, TableEntity paramTableEntity) {
    CharSequence charSequence1 = this.cbv.getText(R.string.pos_open_table_edit);
    CharSequence charSequence2 = this.cbv.getText(R.string.pos_empty_table);
    CharSequence charSequence3 = this.cbv.getText(R.string.pos_moving_table);
    ArrayList arrayList = new ArrayList();
    if (!paramCharSequence.equals(charSequence1))
      arrayList.add(this.cbv.getText(R.string.pos_selection_all)); 
    Iterator iterator = paramTableEntity.Yh().iterator();
    while (iterator.hasNext()) {
      int i = ((c)iterator.next()).Yl();
      if (i == 0) {
        arrayList.add(this.cbv.getString(R.string.open_table_number_none));
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.cbv.getString(R.string.open_table_number));
      stringBuilder.append(i);
      arrayList.add(stringBuilder.toString());
    } 
    CharSequence[] arrayOfCharSequence = new CharSequence[arrayList.size()];
    (new ax(this.cbv, (CharSequence[])arrayList.toArray(arrayOfCharSequence), new av(this, paramCharSequence, charSequence1, paramTableEntity, charSequence2, charSequence3))).aT(new Object());
  }
  
  public void eK(boolean paramBoolean) { this.cbV = paramBoolean; }
  
  public TableEntity fZ(int paramInt) { return (TableEntity)this.bjv.get(paramInt); }
  
  public void gB(int paramInt) {
    int i = this.index;
    int j = this.bjt.getFirstVisiblePosition();
    int k = i - j;
    if (k >= 0 && i <= this.bjt.getLastVisiblePosition()) {
      a a1 = (a)this.bjt.getChildAt(k).getTag();
      if (a1 != null)
        a1.ccp.setActivated(false); 
    } 
    this.index = paramInt;
    i = paramInt - j;
    if (i >= 0) {
      if (paramInt > this.bjt.getLastVisiblePosition())
        return; 
      a a1 = (a)this.bjt.getChildAt(i).getTag();
      if (a1 != null)
        a1.ccp.setActivated(true); 
      return;
    } 
  }
  
  public int getCount() { return (this.bjv == null) ? 0 : this.bjv.size(); }
  
  public long getItemId(int paramInt) { return 0L; }
  
  public int getItemViewType(int paramInt) {
    TableEntity tableEntity = fZ(paramInt);
    return (tableEntity == this.cbQ) ? 1 : ((tableEntity == this.cbP) ? 0 : 2);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    TableEntity tableEntity;
    a a1;
    switch (getItemViewType(paramInt)) {
      default:
        n.println("桌号列表的样式索引出错，这里不会进来");
        return paramView;
      case 2:
        if (paramView == null) {
          a1 = new a(this.cbv);
          paramView = a1.aQG;
          paramView.setTag(a1);
        } else {
          a1 = (a)paramView.getTag();
        } 
        tableEntity = fZ(paramInt);
        a1.bNa.setVisibility(8);
        if (tableEntity.Yi()) {
          a(paramView, tableEntity, a1);
        } else {
          Iterator iterator;
          if (tableEntity.getState() == 0) {
            a1.ccm.setVisibility(8);
            a1.bNa.setVisibility(8);
            a1.bMY.setVisibility(8);
            a1.ccq.setVisibility(0);
            a1.ccp.setBackgroundResource(R.drawable.pos_activity_table_item_background);
            a1.bMW.setVisibility(8);
            a1.bMX.setVisibility(8);
            a1.cco = tableEntity;
            TextView textView = a1.ccn;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(tableEntity.XZ());
            stringBuilder.append(this.cbv.getString(R.string.pos_shop_info_staff_count_unit));
            textView.setText(stringBuilder.toString());
            a1.ccq.setText(tableEntity.Vz());
            a1.ccp.setActivated(tableEntity.Ya());
            if (this.cbY != null) {
              iterator = this.cbY.iterator();
              while (iterator.hasNext()) {
                long l = ((Long)iterator.next()).longValue();
                if (tableEntity.getID() == l) {
                  paramView.setEnabled(false);
                  break;
                } 
                paramView.setEnabled(true);
              } 
            } 
          } else {
            a(tableEntity, iterator);
          } 
        } 
        return paramView;
      case 1:
        view = paramView;
        return (paramView == null) ? View.inflate(this.cbv, R.layout.pos_activity_product_item_add, null) : view;
      case 0:
        break;
    } 
    View view = paramView;
    if (paramView == null)
      view = View.inflate(this.cbv, R.layout.pos_activity_table_item_add_nodata, null); 
    return view;
  }
  
  public int getViewTypeCount() { return 4; }
  
  public void h(a parama) {
    this.bMB = parama;
    this.cbW.c(this.bMB);
  }
  
  class PosActivityTableAdapter {}
  
  class PosActivityTableAdapter {}
  
  private static class a {
    View aQG;
    
    View bMW;
    
    View bMX;
    
    View bMY;
    
    TextView bNa;
    
    TextView bqW;
    
    TextView ccm;
    
    TextView ccn;
    
    TableEntity cco;
    
    View ccp;
    
    TextView ccq;
    
    View ccr;
    
    a(Context param1Context) {
      this.aQG = View.inflate(param1Context, R.layout.pos_activity_table_item, null);
      this.ccm = (TextView)gC(R.id.table_name);
      this.ccn = (TextView)gC(R.id.product_people);
      this.bqW = (TextView)gC(R.id.opentable_time);
      this.ccq = (TextView)gC(R.id.table_center_name);
      this.ccp = gC(R.id.rl_openTable_item);
      this.bMW = gC(R.id.ll_opentable_time);
      this.bMX = gC(R.id.ll_opentable_resend);
      this.bMY = gC(R.id.ll_opentable_paid);
      this.bNa = (TextView)gC(R.id.tv_order_type);
      this.ccr = gC(R.id.opentable_time_joning_dot);
    }
    
    <T extends View> T gC(@IdRes int param1Int) { return (T)this.aQG.findViewById(param1Int); }
  }
  
  public static interface b {
    void a(PendingFullOrderDetail param1PendingFullOrderDetail, TableEntity param1TableEntity);
    
    void b(TableEntity param1TableEntity, int param1Int);
    
    void c(TableEntity param1TableEntity);
    
    void c(a param1a);
    
    void d(TableEntity param1TableEntity);
    
    void d(TableEntity param1TableEntity, int param1Int);
    
    void e(TableEntity param1TableEntity);
    
    void x(ArrayList<TableEntity> param1ArrayList);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\pos\PosActivityTableAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */