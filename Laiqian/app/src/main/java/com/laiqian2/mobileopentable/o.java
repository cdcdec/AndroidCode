package com.laiqian.mobileopentable;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import com.google.a.a.a.a.a.a;
import com.laiqian.entity.s;
import com.laiqian.mobileopentable.a.a;
import com.laiqian.opentable.R;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.t;
import com.laiqian.opentable.common.x;
import com.laiqian.util.n;
import com.laiqian.util.z;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.a.b;
import kotlin.k;

public class o extends BaseAdapter {
  private t.i bMJ;
  
  private t.f bMK;
  
  a bML;
  
  TableEntity bMM;
  
  boolean bMN = false;
  
  AdapterView.OnItemLongClickListener bMO = new s(this);
  
  private final List<TableEntity> list;
  
  private final Context mContext;
  
  AdapterView.OnItemClickListener onItemClickListener = new r(this);
  
  public o(Context paramContext, @NonNull List<TableEntity> paramList, GridView paramGridView, t.i parami, t.f paramf, @Nullable b<TableEntity, k> paramb1, @Nullable b<TableEntity, k> paramb2) {
    this.bMK = paramf;
    this.mContext = paramContext;
    this.list = paramList;
    this.bMJ = parami;
    if (paramContext instanceof PhoneOpenTableActivity)
      this.bMN = true; 
    CharSequence charSequence1 = this.mContext.getText(R.string.pos_moving_table);
    CharSequence charSequence2 = this.mContext.getText(R.string.pos_joining_table);
    this.bML = (new a(this.mContext)).ga(R.string.managment_of_open_table).b(new q(this, new CharSequence[] { charSequence1, charSequence2 })).a(new p(this, paramb2, paramb1));
    paramGridView.setAdapter(this);
    paramGridView.setOnItemClickListener(this.onItemClickListener);
    if (paramb1 != null && paramb2 != null)
      paramGridView.setOnItemLongClickListener(this.bMO); 
  }
  
  private void b(s params) {
    n.bJ(this.mContext);
    x x = new x(this.mContext);
    x.b(this.bMK);
    x.d(params);
    n.bK(this.mContext);
  }
  
  private void h(TableEntity paramTableEntity) {
    s = b.cc(paramTableEntity.getID());
    if (s != null) {
      b(s);
      return;
    } 
    try {
      this.bMK.dp(true);
      return;
    } catch (m s) {
      a.e(s);
      return;
    } 
  }
  
  public TableEntity fZ(int paramInt) { return (TableEntity)this.list.get(paramInt); }
  
  public int getCount() { return (this.list != null && !this.list.isEmpty()) ? this.list.size() : 0; }
  
  public long getItemId(int paramInt) { return 0L; }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    a a1;
    if (paramView == null) {
      paramView = View.inflate(this.mContext, R.layout.order_table_list_item, null);
      a1 = new a(this);
      a1.bjn = paramView.findViewById(R.id.rl_openTable_item);
      a1.bMT = (TextView)paramView.findViewById(R.id.table_name);
      a1.bMU = (TextView)paramView.findViewById(R.id.table_center_name);
      a1.bMV = (TextView)paramView.findViewById(R.id.people);
      a1.bMW = paramView.findViewById(R.id.ll_opentable_time);
      a1.bMX = paramView.findViewById(R.id.ll_opentable_resend);
      a1.bMZ = (TextView)paramView.findViewById(R.id.table_time);
      a1.bNa = (TextView)paramView.findViewById(R.id.tv_order_type);
      a1.bMY = paramView.findViewById(R.id.ll_opentable_paid);
      paramView.setTag(a1);
    } else {
      a1 = (a)paramView.getTag();
    } 
    if (fZ(paramInt).Yi()) {
      a1.bjn.setBackgroundResource(R.drawable.pos_activity_table_item_background);
      a1.bMT.setVisibility(0);
      a1.bMT.setText(fZ(paramInt).Vz());
      a1.bMW.setVisibility(8);
      a1.bMX.setVisibility(0);
      a1.bMU.setVisibility(0);
      a1.bMU.setText("");
      a1.bMV.setText(String.format(Locale.getDefault(), "%d%s", new Object[] { Integer.valueOf(fZ(paramInt).XZ()), this.mContext.getString(R.string.person_unit) }));
      return paramView;
    } 
    a1.bNa.setVisibility(8);
    a1.bMY.setVisibility(8);
    if (fZ(paramInt).getState() == 0) {
      a1.bjn.setBackgroundResource(R.drawable.pos_activity_table_item_background);
      a1.bMT.setVisibility(8);
      a1.bMW.setVisibility(8);
      a1.bMX.setVisibility(8);
      a1.bMU.setVisibility(0);
      a1.bMU.setText(fZ(paramInt).Vz());
      a1.bMV.setText(String.format(Locale.getDefault(), "%d%s", new Object[] { Integer.valueOf(fZ(paramInt).XZ()), this.mContext.getString(R.string.person_unit) }));
      return paramView;
    } 
    if (fZ(paramInt).getState() == 2) {
      a1.bjn.setBackgroundResource(R.drawable.pos_activity_table_item_check_background);
      a1.bMT.setVisibility(0);
      a1.bMU.setVisibility(8);
      a1.bMW.setVisibility(0);
      a1.bMX.setVisibility(8);
      if (this.bMN)
        a1.bMW.setBackgroundColor(this.mContext.getResources().getColor(R.color.setting_line_color)); 
      a1.bMT.setText(fZ(paramInt).Vz());
      a1.bMV.setText(String.format(Locale.getDefault(), "%d%s", new Object[] { Integer.valueOf(fZ(paramInt).Yb()), this.mContext.getString(R.string.person_unit) }));
      a1.bMZ.setText(z.do(fZ(paramInt).DP()));
      if (fZ(paramInt).Yh().size() > 1)
        a1.bMZ.setText(R.string.opentable_joing); 
      if (fZ(paramInt).Xy() == 3) {
        a1.bNa.setVisibility(0);
        return paramView;
      } 
    } else if (fZ(paramInt).getState() == 5) {
      if (fZ(paramInt).Xy() == 3)
        a1.bNa.setVisibility(0); 
      a1.bMT.setVisibility(0);
      a1.bMT.setText(fZ(paramInt).Vz());
      a1.bMU.setVisibility(8);
      a1.bMX.setVisibility(8);
      a1.bMY.setVisibility(0);
      a1.bMV.setText(String.format(Locale.getDefault(), "%d%s", new Object[] { Integer.valueOf(fZ(paramInt).Yb()), this.mContext.getString(R.string.person_unit) }));
    } 
    return paramView;
  }
  
  public void m(List<TableEntity> paramList) {
    this.list.clear();
    this.list.addAll(paramList);
    notifyDataSetChanged();
  }
  
  class a {
    public TextView bMT;
    
    public TextView bMU;
    
    public TextView bMV;
    
    public View bMW;
    
    public View bMX;
    
    public View bMY;
    
    public TextView bMZ;
    
    public TextView bNa;
    
    public View bjn;
    
    a(o this$0) {}
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\mobileopentable\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */