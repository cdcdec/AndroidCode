package com.laiqian.pos.hold;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.k.a;
import com.laiqian.main.PosActivity;
import com.laiqian.main.module.pendingorder.a;
import com.laiqian.models.bh;
import com.laiqian.pos.model.a;
import com.laiqian.pos.settings.z;
import com.laiqian.print.j;
import com.laiqian.print.model.g;
import com.laiqian.ui.a.d;
import com.laiqian.ui.s;
import com.laiqian.ui.stickylistheaders.StickyListHeadersListView;
import com.laiqian.util.av;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ai extends d {
  private double aVz;
  
  private boolean bDk;
  
  private int bDl = 1;
  
  private boolean cgE;
  
  private String cpB = null;
  
  private PendingFullOrderDetail.a cpC = null;
  
  private a cpD = new a(getWindow().getDecorView());
  
  private String cpE;
  
  private int cpF;
  
  private boolean cpG;
  
  private String cpH = "";
  
  ArrayList<PendingFullOrderDetail.a> cpI = new ArrayList();
  
  String cpJ = "";
  
  private View.OnClickListener cpK = new ao(this);
  
  private a cpL;
  
  private View.OnClickListener cpM = new aq(this);
  
  private View.OnClickListener cpN = new as(this);
  
  private View.OnClickListener cpO = new at(this);
  
  private View.OnClickListener cpP = new au(this);
  
  private View.OnClickListener cpQ = new av(this);
  
  private TextWatcher cpR = new ak(this);
  
  private aw cpS;
  
  AdapterView.OnItemClickListener cpT = new al(this);
  
  private z cpU;
  
  private a.a cpV;
  
  private PendingFullOrderDetail order;
  
  BroadcastReceiver receiver = new aj(this);
  
  private final int size = 60;
  
  public ai(FragmentActivity paramFragmentActivity) {
    super(paramFragmentActivity, 2131427867);
    (getWindow().getAttributes()).width = (paramFragmentActivity.getResources().getDisplayMetrics()).widthPixels;
    setupViews();
    setListeners();
  }
  
  private void Nq() {
    try {
      List list = j.cCx.a(new PendingFullOrderDetail(this.order), new String[] { "dish_reprint" });
      g.cGS.o(list);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  private void aaH() {
    Editable editable = this.cpD.cpZ.getText();
    if (editable instanceof Spannable)
      Selection.setSelection((Spannable)editable, editable.length()); 
    Selection.setSelection((Spannable)editable, editable.length());
  }
  
  private void aaI() {
    ((PosActivity)this.mActivity).Lh();
    dismiss();
  }
  
  private void aaK() {
    String str2 = this.cpC.coJ;
    String str1;
    this.cpD.cqd.setText((str1 = this.cpC.coK).format("%s: %s", new Object[] { getContext().getString(2131626872), str2 }));
    if (!TextUtils.isEmpty(str1)) {
      bh bh = new bh(this.mActivity);
      str2 = bh.iC(str1);
      bh.close();
      if (!TextUtils.isEmpty(str2))
        str1 = str2; 
      this.cpD.cqd.setText(z.kF(String.format("%s  %s", new Object[] { this.mActivity.getString(2131626870), str1 })));
      return;
    } 
    this.cpD.cqf.setText("");
  }
  
  private void ae(ArrayList<PendingFullOrderDetail.a> paramArrayList) {
    if (this.cpS == null) {
      this.cpS = new aw(getContext(), paramArrayList, 2131427868);
      this.cpD.cqb.setAdapter(this.cpS);
      this.cpD.cqb.setClickable(true);
      this.cpS.a(this.cpD.cqb);
      this.cpD.cqb.setOnItemClickListener(this.cpT);
      this.cpD.cqb.setOnScrollListener(new b(this));
    } else {
      int i;
      aw aw1 = this.cpS;
      if (this.cpF <= 0) {
        i = 0;
      } else {
        i = this.cpF;
      } 
      aw1.hd(i);
      this.cpS.m(paramArrayList);
    } 
    if (paramArrayList.size() > 0) {
      String str;
      if (this.cpE == null) {
        this.cpC = (PendingFullOrderDetail.a)paramArrayList.get(0);
        str = this.cpC.orderNo;
      } else {
        str = this.cpE;
      } 
      jG(str);
      aaK();
    } 
  }
  
  private ArrayList<PendingFullOrderDetail.a> aw(String paramString1, String paramString2) {
    a a1 = new a(this.mActivity);
    ArrayList arrayList = a1.b(paramString1, paramString2, true, 60, this.bDl);
    a1.close();
    return arrayList;
  }
  
  private void delete() {
    if (this.cpC == null) {
      aaI();
      return;
    } 
    av av = new av(this.mActivity);
    String str2 = av.atp();
    av.close();
    if (!"150001".equals(str2)) {
      Toast.makeText(this.mActivity, this.mActivity.getString(2131627143), 0).show();
      return;
    } 
    String str1 = this.cpC.orderNo;
    if (str1 != null && str1.equals(this.cpB)) {
      Toast.makeText(this.mActivity, 2131626869, 0).show();
      return;
    } 
    if (str1 == null)
      return; 
    a a1 = new a(this.mActivity);
    a1.kj(str1);
    a1.close();
    if (this.cpV != null)
      this.cpV.deleteOrder(); 
    this.bDl = 1;
    this.cpI.clear();
    this.cpI.addAll(aw("", "0"));
    ae(this.cpI);
    if (this.cpI.size() == 0)
      aaI(); 
  }
  
  private void eV(boolean paramBoolean) {
    if (this.cpC == null)
      return; 
    if (!TextUtils.isEmpty(this.cpD.cpZ.getText().toString().trim())) {
      HashMap hashMap1 = new HashMap();
      hashMap1.put("operation_type", "挂单搜索");
      a.b(this.mActivity, "search_hold_order", hashMap1);
    } 
    HashMap hashMap = new HashMap();
    hashMap.put("operation_type", "取单");
    a.b(this.mActivity, "take_order_operation", hashMap);
    if (this.cpV != null) {
      this.order.bXb.bZF = 0;
      this.cpV.a(this.order, paramBoolean);
    } 
    if (!paramBoolean)
      dismiss(); 
  }
  
  private boolean eW(boolean paramBoolean) {
    boolean bool = paramBoolean;
    if (this.cpI.size() > 0) {
      int i = this.cpI.size() % 60;
      if (i != 0) {
        byte b = 0;
        while (true) {
          bool = paramBoolean;
          if (b < i) {
            this.cpI.remove(this.cpI.size() - 1);
            b++;
            continue;
          } 
          break;
        } 
      } else {
        this.bDl++;
        bool = true;
      } 
    } 
    return bool;
  }
  
  @RequiresApi
  private void jG(String paramString) {
    a a1 = new a(this.mActivity);
    this.order = a1.ky(paramString);
    a1.close();
    if (this.order != null)
      p(this.order); 
  }
  
  private void p(PendingFullOrderDetail paramPendingFullOrderDetail) {
    if (this.cpU == null) {
      this.cpU = new z(getContext(), this.cpD.col, paramPendingFullOrderDetail, new am(this));
      this.cpD.col.setAdapter(this.cpU);
      this.cpD.col.setClickable(false);
      this.cpD.col.smoothScrollToPosition(this.cpU.getCount() + 1);
      return;
    } 
    this.cpU.o(paramPendingFullOrderDetail);
    this.cpU.notifyDataSetChanged();
    this.cpU.getCount();
  }
  
  private void setListeners() {
    this.cpD.aCT.setOnClickListener(this.cpK);
    this.cpD.cqe.setOnClickListener(this.cpM);
    this.cpD.cqi.setOnClickListener(this.cpP);
    this.cpD.cqc.setOnClickListener(this.cpN);
    this.cpD.cqh.setOnClickListener(this.cpO);
    this.cpD.cqa.setOnClickListener(this.cpQ);
    this.cpD.cpZ.addTextChangedListener(this.cpR);
    this.cpD.cqg.setOnClickListener(new an(this));
  }
  
  private void setupViews() { this.cpD.cqa.setVisibility(8); }
  
  public void a(a.a parama) { this.cpV = parama; }
  
  public boolean aaJ() {
    int i = this.cpI.size();
    this.cpI.addAll(aw(this.cpJ, "0"));
    return (i == this.cpI.size());
  }
  
  public void jF(String paramString) { this.cpB = paramString; }
  
  protected void onStart() {
    super.onStart();
    this.cgE = true;
    this.cpD.cpZ.setText(this.cpH);
    aaH();
    this.cpD.aNl.requestFocus();
    n.a(this.mActivity, getCurrentFocus());
    IntentFilter intentFilter = new IntentFilter("pos_activity_change_data_takeorderscount");
    getContext().registerReceiver(this.receiver, intentFilter);
  }
  
  protected void onStop() {
    super.onStop();
    try {
      getContext().unregisterReceiver(this.receiver);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
  
  public void show() {
    this.cpE = null;
    this.cpF = -1;
    this.cpH = "";
    super.show();
  }
  
  public static class a {
    @NonNull
    public final View aCT;
    
    @NonNull
    public final TextView aNl;
    
    @NonNull
    public final View aQG;
    
    @NonNull
    public final StickyListHeadersListView col;
    
    @NonNull
    public final EditText cpZ;
    
    @NonNull
    public final ImageView cqa;
    
    @NonNull
    public final GridView cqb;
    
    @NonNull
    public final LinearLayout cqc;
    
    @NonNull
    public final TextView cqd;
    
    @NonNull
    public final ImageView cqe;
    
    @NonNull
    public final TextView cqf;
    
    @NonNull
    public final View cqg;
    
    @NonNull
    public final TextView cqh;
    
    @NonNull
    public final TextView cqi;
    
    public a(View param1View) {
      this.aQG = param1View;
      this.aNl = (TextView)s.z(param1View, 2131299446);
      this.cpZ = (EditText)s.z(param1View, 2131296975);
      this.cqa = (ImageView)s.z(param1View, 2131299934);
      this.cqb = (GridView)s.z(param1View, 2131298076);
      this.cqc = (LinearLayout)s.z(param1View, 2131298437);
      this.cqh = (TextView)s.z(param1View, 2131299547);
      this.cqd = (TextView)s.z(param1View, 2131299321);
      this.cqe = (ImageView)s.z(param1View, 2131297335);
      this.cqf = (TextView)s.z(param1View, 2131299325);
      this.col = (StickyListHeadersListView)s.z(param1View, 2131298077);
      this.cqi = (TextView)s.z(param1View, 2131299425);
      this.aCT = s.z(param1View, 2131297836);
      this.cqg = s.z(param1View, 2131297631);
    }
  }
  
  public class b implements AbsListView.OnScrollListener {
    public b(ai this$0) {}
    
    public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) {
      boolean bool;
      ai ai1 = this.cpW;
      if (param1Int1 + param1Int2 == param1Int3) {
        bool = true;
      } else {
        bool = false;
      } 
      ai.e(ai1, bool);
    }
    
    public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {
      if (ai.t(this.cpW) && param1Int == 0) {
        ai.u(this.cpW);
        if (this.cpW.aaJ()) {
          ai.r(this.cpW);
          return;
        } 
        ai.a(this.cpW, this.cpW.cpI);
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hold\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */