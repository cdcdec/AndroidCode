package com.laiqian.product;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.laiqian.auth.cj;
import com.laiqian.d.a;
import com.laiqian.infrastructure.R;
import com.laiqian.models.ac;
import com.laiqian.product.models.g;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.util.n;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ProductList extends ActivityRoot {
  private TextView cRA;
  
  private View cRB;
  
  private TextView cRC;
  
  private TextView cRD;
  
  private boolean cRE;
  
  private r cRF;
  
  private long[] cRG;
  
  private boolean cRH;
  
  private boolean cRI = false;
  
  private boolean cRJ;
  
  private View cRK;
  
  private ListView cRL;
  
  private boolean cRM;
  
  private boolean cRs;
  
  private HashMap<Long, HashMap<String, String>> cRt;
  
  private a cRu;
  
  private b cRv;
  
  private boolean cRw;
  
  private ck cRx;
  
  private View cRy;
  
  private View cRz;
  
  private boolean cgV;
  
  private View cgW;
  
  private EditText cgX;
  
  private String cha;
  
  private String che;
  
  private ListView chg;
  
  private View chh;
  
  private fa cho;
  
  private int chp;
  
  private boolean isOpenMemberPrice;
  
  private void D(HashMap<String, String> paramHashMap) {
    if (paramHashMap == null) {
      this.cho.a(null, null, null, false, null);
      return;
    } 
    this.cho.a((String)paramHashMap.get("id"), (String)paramHashMap.get("name"), (String)paramHashMap.get("name2"), this.cRv.Q(paramHashMap), null);
  }
  
  private void I(Map<String, String> paramMap) {
    String str1;
    boolean bool = false;
    null = null;
    null = null;
    if (paramMap == null) {
      if (this.cRv.getCount() == 0) {
        n.w(this, R.string.pos_product_please_create_type);
        return;
      } 
      if (this.cRv.getCount() == 1) {
        String str13;
        HashMap hashMap = this.cRv.gN(0);
        null = this.cRx;
        String str14 = (String)hashMap.get("id");
        String str15 = (String)hashMap.get("name");
        paramMap = null;
        if (this.cRv.Q(hashMap))
          str13 = ""; 
        null.a(new ck.b(null, str14, str15, str13, true, this.cRv.YP()));
        return;
      } 
      ck ck2 = this.cRx;
      String str11 = this.cha;
      String str12 = this.che;
      str1 = null;
      if (this.cRw)
        str1 = ""; 
      ck2.a(new ck.b(null, str11, str12, str1, true, this.cRv.YP()));
      return;
    } 
    String str3 = (String)str1.get("id");
    String str4 = (String)str1.get("name");
    String str5 = (String)str1.get("name2");
    String str6 = (String)str1.get("price");
    String str2 = (String)str1.get("qty");
    String str7 = (String)str1.get("sProductNumber");
    String str8 = (String)str1.get("memberPrice");
    String str9 = (String)str1.get("weight_switch");
    if (!TextUtils.isEmpty(str9)) {
      if (Integer.parseInt(str9) != 0)
        bool = true; 
    } else {
      bool = false;
    } 
    if (this.cha == null) {
      str1 = (String)str1.get("typeID");
      if (this.cRv.getCount() == 0) {
        str2 = this.cRv.mu(str1);
        this.cRx.a(str3, str4, str5, str1, str2, null, false, str6, str7, str8, this.cRv.YP(), bool);
        return;
      } 
      str9 = this.cRv.mt(str1);
      if (str9 == null)
        str1 = null; 
      ck ck2 = this.cRx;
      if (!b.a(this.cRv))
        str2 = null; 
      ck2.a(str3, str4, str5, str1, str9, str2, true, str6, str7, str8, this.cRv.YP(), bool);
      return;
    } 
    ck ck1 = this.cRx;
    str9 = this.cha;
    String str10 = this.che;
    if (!this.cRw)
      str2 = null; 
    ck1.a(str3, str4, str5, str9, str10, str2, true, str6, str7, str8, this.cRv.YP(), bool);
  }
  
  private void YH() {
    null = new StringBuilder();
    null.append("选择的商品:");
    null.append(this.cRt);
    n.println(null.toString());
    long[] arrayOfLong = new long[this.cRt.size()];
    String[] arrayOfString = new String[this.cRt.size()];
    null = this.cRt.keySet().iterator();
    byte b1 = 0;
    while (null.hasNext()) {
      long l = ((Long)null.next()).longValue();
      HashMap hashMap = (HashMap)this.cRt.get(Long.valueOf(l));
      if (hashMap != null) {
        arrayOfLong[b1] = l;
        arrayOfString[b1] = (String)hashMap.get("name");
        b1++;
      } 
    } 
    Bundle bundle = new Bundle();
    if (arrayOfLong.length > b1) {
      long[] arrayOfLong1 = new long[b1];
      String[] arrayOfString1 = new String[b1];
      System.arraycopy(arrayOfLong, 0, arrayOfLong1, 0, b1);
      System.arraycopy(arrayOfString, 0, arrayOfString1, 0, b1);
      bundle.putLongArray("IDs", arrayOfLong1);
      bundle.putStringArray("names", arrayOfString1);
    } else {
      bundle.putLongArray("IDs", arrayOfLong);
      bundle.putStringArray("names", arrayOfString);
    } 
    setResult(-1, getIntent().putExtras(bundle));
    finish();
  }
  
  private void ZQ() {
    View view = findViewById(R.id.type_add_small);
    view.setOnClickListener(new cv(this));
    if (!this.cRI)
      view.setVisibility(8); 
    this.cho = new fa(this);
    this.chg = (ListView)findViewById(R.id.type_body_l).findViewById(R.id.type_body);
    this.cRv = new b(this, this.chg);
    this.cho.a(new dg(this));
    this.chg.setAdapter(this.cRv);
    this.chg.setChoiceMode(1);
    this.chg.setOnItemClickListener(new dh(this));
    this.chg.setItemChecked(this.cRv.YO(), true);
    findViewById(R.id.back).setOnClickListener(new di(this));
  }
  
  private boolean ZS() { return (this.cgW.getVisibility() == 0); }
  
  private void ajF() {
    if (this.cRE) {
      this.cRK.findViewById(R.id.product_head_icon).setVisibility(0);
    } else {
      this.cRK.findViewById(R.id.product_head_icon).setVisibility(8);
    } 
    if (a.AZ().Bm() && !this.cRs) {
      this.cRK.findViewById(R.id.product_head_code).setVisibility(0);
    } else {
      this.cRK.findViewById(R.id.product_head_code).setVisibility(8);
    } 
    if (this.isOpenMemberPrice && !this.cRs) {
      this.cRK.findViewById(R.id.product_head_member_price).setVisibility(0);
    } else {
      this.cRK.findViewById(R.id.product_head_member_price).setVisibility(8);
    } 
    if ((this.cha == null || this.cRw) && !this.cRs) {
      this.cRK.findViewById(R.id.product_head_qty).setVisibility(0);
    } else {
      this.cRK.findViewById(R.id.product_head_qty).setVisibility(4);
    } 
    if (this.cRL.getHeaderViewsCount() == 0)
      this.cRL.addHeaderView(this.cRK); 
  }
  
  private void ajG() {
    this.cRB = findViewById(R.id.batch_operation_button_l);
    this.cRC = (TextView)this.cRB.findViewById(R.id.batch_move);
    this.cRC.setOnClickListener(new dc(this));
    this.cRD = (TextView)this.cRB.findViewById(R.id.batch_delete);
    this.cRD.setOnClickListener(new dd(this));
    if (this.cRM) {
      this.cRB.setVisibility(0);
      this.cRC.setVisibility(0);
      this.cRC.setEnabled(true);
      this.cRD.setVisibility(0);
      this.cRD.setEnabled(true);
      this.cRC.setText(R.string.pos_product_tax_exempttax);
      this.cRD.setText(R.string.pos_product_tax_exemptalltax);
    } 
  }
  
  private void ajH() {
    this.cRG = a.a(this.cRu);
    if (this.cRG != null) {
      ArrayList arrayList = this.cRv.YP();
      String[] arrayOfString = new String[arrayList.size()];
      for (byte b1 = 0; b1 < arrayOfString.length; b1++)
        arrayOfString[b1] = (String)((HashMap)arrayList.get(b1)).get("name"); 
      (new w(this, arrayOfString, new de(this))).show();
    } 
  }
  
  private void ajI() {
    this.cRG = a.a(this.cRu);
    if (this.cRG != null)
      ajJ().show(); 
  }
  
  private r ajJ() {
    if (this.cRF == null) {
      this.cRF = new r(this, new df(this));
      this.cRF.s(getString(R.string.pos_product_batch_delete_prompt));
    } 
    return this.cRF;
  }
  
  private void cS(View paramView) {
    byte b1;
    this.cRy = paramView.findViewById(R.id.batch_operation);
    this.cRy.setOnClickListener(new cy(this));
    if (!this.cRI)
      this.cRy.setVisibility(8); 
    this.cRz = findViewById(R.id.batch_operation_l);
    paramView = this.cRz;
    if (this.cgV) {
      b1 = 8;
    } else {
      b1 = 0;
    } 
    paramView.setVisibility(b1);
    paramView = this.cRz.findViewById(R.id.batch_canal);
    if (this.cgV) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    paramView.setVisibility(b1);
    this.cRz.findViewById(R.id.batch_canal).setOnClickListener(new cz(this));
    this.cRA = (TextView)this.cRz.findViewById(R.id.batch_select_all);
    if (!this.cgV) {
      this.cRz.findViewById(R.id.confirm).setVisibility(0);
      this.cRz.findViewById(R.id.confirm).setOnClickListener(new da(this));
      ((RelativeLayout.LayoutParams)this.cRA.getLayoutParams()).addRule(0, R.id.confirm);
    } else {
      this.cRz.findViewById(R.id.confirm).setVisibility(8);
      ((RelativeLayout.LayoutParams)this.cRA.getLayoutParams()).addRule(11);
    } 
    this.cRA.setOnClickListener(new db(this));
    ajG();
  }
  
  private void gD(int paramInt) {
    if (paramInt >= this.cRv.YO()) {
      this.chg.getOnItemClickListener().onItemClick(this.chg, null, paramInt, 0L);
      this.chg.setItemChecked(paramInt, true);
      this.chg.setSelection(paramInt);
      ajF();
    } 
  }
  
  private void go(boolean paramBoolean) {
    if (paramBoolean) {
      this.cgX.setText("");
      this.cgW.setVisibility(0);
      this.cgX.requestFocus();
      n.b(this, this.cgX);
      return;
    } 
    if (this.cgX.getText().toString().trim().length() > 0)
      this.cgX.setText(""); 
    this.cgW.setVisibility(8);
    n.R(this);
  }
  
  private void setProduct() {
    this.isOpenMemberPrice = a.AZ().Bx() ^ true;
    View view1 = findViewById(R.id.vClean);
    view1.setOnClickListener(new dj(this));
    view1.setVisibility(8);
    this.cRx = new ck(this);
    this.cRx.a(new dk(this));
    View view2 = findViewById(R.id.product_title_l);
    cS(view2);
    this.chh = view2.findViewById(R.id.product_query);
    this.chh.setOnClickListener(new dl(this));
    this.cgW = findViewById(R.id.product_query_l);
    this.cgX = (EditText)this.cgW.findViewById(R.id.query_et);
    this.cgX.addTextChangedListener(new dm(this, view1));
    this.cgW.findViewById(R.id.query_cancel).setOnClickListener(new dn(this));
    ListView listView = (ListView)findViewById(R.id.product_body_l).findViewById(R.id.product_body);
    this.cRL = listView;
    this.cRK = View.inflate(this, R.layout.product_head_view, null);
    ajF();
    this.cRu = new a(this, listView);
    listView.setAdapter(this.cRu);
    listView.setOnItemClickListener(new cw(this));
    this.cgX.addTextChangedListener(new cx(this));
  }
  
  private void u(boolean paramBoolean1, boolean paramBoolean2) {
    this.cRE = paramBoolean1;
    if (paramBoolean1) {
      byte b1;
      this.cRz.setVisibility(0);
      View view = this.cRB;
      if (this.cgV) {
        b1 = 0;
      } else {
        b1 = 8;
      } 
      view.setVisibility(b1);
      if (paramBoolean2) {
        this.cRz.findViewById(R.id.batch_canal).setVisibility(0);
        if (this.cRv.getCount() == 0) {
          this.cRC.setVisibility(8);
        } else {
          this.cRC.setVisibility(0);
        } 
        this.cRD.setEnabled(false);
        this.cRC.setEnabled(false);
      } else {
        this.cRz.findViewById(R.id.batch_canal).setVisibility(8);
      } 
      this.cRA.setText(R.string.pos_product_batch_select_all);
      if (!this.cRs)
        this.cRu.O(null); 
    } else {
      this.cRz.setVisibility(8);
      if (!this.cRM)
        this.cRB.setVisibility(8); 
    } 
    ajF();
  }
  
  protected void onCreate(Bundle paramBundle) {
    byte b1;
    super.onCreate(paramBundle);
    setContentViewSetNoTitle(R.layout.pos_product_main);
    long[] arrayOfLong = getIntent().getLongArrayExtra("productIDs");
    this.cRM = getIntent().getBooleanExtra("isTax", false);
    this.cRJ = getIntent().getBooleanExtra("hasMealSet", false);
    byte b2 = 1;
    if (arrayOfLong == null) {
      b1 = 1;
    } else {
      b1 = 0;
    } 
    this.cgV = b1;
    this.cRs = this.cgV ^ true;
    if (this.cRs) {
      this.cRt = new HashMap();
      for (byte b3 = 0; b3 < arrayOfLong.length; b3++)
        this.cRt.put(Long.valueOf(arrayOfLong[b3]), null); 
      View view = findViewById(R.id.filter_l);
      view.setVisibility(0);
      view.findViewById(R.id.line_h).setVisibility(8);
      setTitleTextView(R.string.pos_product_product_title_select);
    } 
    cj cj = new cj(this);
    Boolean[] arrayOfBoolean = cj.yO();
    cj.close();
    if (arrayOfBoolean[1].booleanValue() && this.cgV) {
      b1 = b2;
    } else {
      b1 = 0;
    } 
    this.cRI = b1;
    ZQ();
    setProduct();
    if (this.cRM)
      ajG(); 
  }
  
  protected void onPause() {
    MobclickAgent.onPause(this);
    super.onPause();
  }
  
  protected void onResume() {
    MobclickAgent.onResume(this);
    super.onResume();
  }
  
  class a extends BaseAdapter {
    private ListView bWY;
    
    private ArrayList<HashMap<String, String>> bjv;
    
    private g cPb;
    
    private final String cRO = "isChecked";
    
    private View cRP;
    
    private int cRQ;
    
    private boolean[] cRR;
    
    private String[] cRS;
    
    private String[] cRT;
    
    private View chB;
    
    private View chD;
    
    private View chE;
    
    public a(ProductList this$0, ListView param1ListView) {
      this.bWY = param1ListView;
      this.chB = this$0.findViewById(R.id.product_add_small);
      if (!ProductList.g(this$0))
        this.chB.setVisibility(8); 
      this.cRP = this$0.findViewById(R.id.product_add_l);
      this.chD = this$0.findViewById(R.id.addTypeText);
      this.chE = this$0.findViewById(R.id.product_no);
      this.cPb = new g(this$0);
      if (param1ListView.getHeaderViewsCount() == 0)
        param1ListView.addHeaderView(View.inflate(this$0, R.layout.listview_headview_10500, null)); 
      if (param1ListView.getFooterViewsCount() == 0)
        param1ListView.addFooterView(View.inflate(this$0, R.layout.listview_headview_10500, null)); 
      this.chB.setOnClickListener(new do(this, this$0));
      YQ();
    }
    
    private boolean Q(HashMap<String, String> param1HashMap) { return (ProductList.y(this.cRN) || (ProductList.r(this.cRN) == null && "true".equals(param1HashMap.get("isQty")))); }
    
    private long[] ajM() {
      ArrayList arrayList1 = new ArrayList();
      ArrayList arrayList2 = new ArrayList();
      ArrayList arrayList3 = new ArrayList();
      ArrayList arrayList4 = new ArrayList();
      for (HashMap hashMap : this.bjv) {
        if (R(hashMap)) {
          arrayList1.add(Long.valueOf(Long.parseLong((String)hashMap.get("id"))));
          arrayList2.add(Boolean.valueOf(Q(hashMap)));
          arrayList3.add(hashMap.get("name"));
          arrayList4.add(((String)hashMap.get("qty")).replace(",", ""));
        } 
      } 
      if (arrayList1.isEmpty())
        return null; 
      long[] arrayOfLong = new long[arrayList1.size()];
      this.cRR = new boolean[arrayList1.size()];
      this.cRS = new String[arrayList1.size()];
      this.cRT = new String[arrayList1.size()];
      for (byte b = 0; b < arrayList1.size(); b++) {
        arrayOfLong[b] = ((Long)arrayList1.get(b)).longValue();
        this.cRR[b] = ((Boolean)arrayList2.get(b)).booleanValue();
        this.cRS[b] = (String)arrayList3.get(b);
        this.cRT[b] = (String)arrayList4.get(b);
      } 
      return arrayOfLong;
    }
    
    public void O(HashMap<String, String> param1HashMap) {
      Iterator iterator;
      if (param1HashMap == null) {
        iterator = this.bjv.iterator();
        while (iterator.hasNext())
          O((HashMap)iterator.next()); 
      } else {
        long l = n.parseLong((String)iterator.get("id"));
        if (ProductList.s(this.cRN) != null)
          ProductList.s(this.cRN).remove(Long.valueOf(l)); 
        T(iterator);
        if (this.cRQ > 0)
          this.cRQ--; 
      } 
    }
    
    public void P(HashMap<String, String> param1HashMap) {
      Iterator iterator;
      if (param1HashMap == null) {
        iterator = this.bjv.iterator();
        while (iterator.hasNext())
          P((HashMap)iterator.next()); 
      } else {
        S(iterator);
        if (ProductList.s(this.cRN) != null) {
          long l = n.parseLong((String)iterator.get("id"));
          ProductList.s(this.cRN).put(Long.valueOf(l), iterator);
        } 
        if (this.cRQ < getCount())
          this.cRQ++; 
      } 
    }
    
    public boolean R(HashMap<String, String> param1HashMap) { return param1HashMap.containsKey("isChecked"); }
    
    public void S(HashMap<String, String> param1HashMap) { param1HashMap.put("isChecked", "true"); }
    
    public void T(HashMap<String, String> param1HashMap) { param1HashMap.remove("isChecked"); }
    
    public void U(HashMap<String, String> param1HashMap) {
      if (ProductList.w(this.cRN)) {
        long l = n.parseLong((String)param1HashMap.get("id"));
        if (R(param1HashMap)) {
          T(param1HashMap);
          ProductList.s(this.cRN).remove(Long.valueOf(l));
          if (this.cRQ > 0)
            this.cRQ--; 
        } else {
          S(param1HashMap);
          ProductList.s(this.cRN).put(Long.valueOf(l), param1HashMap);
          if (this.cRQ < getCount())
            this.cRQ++; 
        } 
        ajQ();
        notifyDataSetChanged();
      } 
    }
    
    public void YQ() {
      n.println("查询了商品");
      this.bjv = this.cPb.a(ProductList.r(this.cRN), ProductList.f(this.cRN).getText().toString(), "isChecked", ProductList.s(this.cRN), ProductList.q(this.cRN) ^ true);
      Iterator iterator = this.bjv.iterator();
      byte b = 0;
      while (iterator.hasNext()) {
        HashMap hashMap = (HashMap)iterator.next();
        if (ProductList.r(this.cRN) == null) {
          ProductList.a(this.cRN).mt((String)hashMap.get("typeID"));
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(ProductList.b.a(ProductList.a(this.cRN)));
          stringBuilder.append("");
          hashMap.put("isQty", stringBuilder.toString());
        } 
        if (R(hashMap))
          b++; 
      } 
      if (this.bjv.size() == 0) {
        ProductList.t(this.cRN).setVisibility(4);
        ProductList.u(this.cRN).setVisibility(4);
        ProductList.v(this.cRN).setVisibility(8);
        if (ProductList.i(this.cRN)) {
          this.chE.setVisibility(0);
          this.cRP.setVisibility(8);
          this.chD.setVisibility(8);
        } else if (ProductList.a(this.cRN).getCount() == 0) {
          if (ProductList.w(this.cRN)) {
            this.chD.setVisibility(8);
          } else {
            this.chD.setVisibility(0);
          } 
          this.cRP.setVisibility(8);
          this.chB.setVisibility(8);
          this.chE.setVisibility(8);
        } else {
          this.cRP.setVisibility(0);
          if (ProductList.g(this.cRN))
            this.chB.setVisibility(0); 
          this.chD.setVisibility(8);
          this.chE.setVisibility(8);
        } 
      } else {
        if (!ProductList.i(this.cRN) && ProductList.g(this.cRN))
          this.chB.setVisibility(0); 
        ProductList.t(this.cRN).setVisibility(0);
        this.chE.setVisibility(8);
        this.cRP.setVisibility(8);
        this.chD.setVisibility(8);
        ProductList.u(this.cRN).setVisibility(0);
        if (ProductList.g(this.cRN))
          ProductList.v(this.cRN).setVisibility(0); 
      } 
      if (ProductList.x(this.cRN))
        this.chB.setVisibility(8); 
      notifyDataSetChanged();
      this.bWY.setSelection(0);
      this.cRQ = 0;
      if (ProductList.w(this.cRN)) {
        this.cRQ = b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.cRQ);
        stringBuilder.append("");
        Log.e("checkedProductCount", stringBuilder.toString());
      } 
      ajQ();
    }
    
    public void ajK() {
      for (HashMap hashMap : this.bjv) {
        long l = n.parseLong((String)hashMap.get("id"));
        if (!R(hashMap)) {
          S(hashMap);
          ProductList.s(this.cRN).put(Long.valueOf(l), hashMap);
        } 
      } 
      Log.e("checkedall", ProductList.s(this.cRN).toString());
    }
    
    public void ajL() {
      for (HashMap hashMap : this.bjv) {
        long l = n.parseLong((String)hashMap.get("id"));
        if (R(hashMap)) {
          T(hashMap);
          ProductList.s(this.cRN).remove(Long.valueOf(l));
        } 
      } 
    }
    
    public boolean[] ajN() { return this.cRR; }
    
    public String[] ajO() { return this.cRS; }
    
    public String[] ajP() { return this.cRT; }
    
    public void ajQ() {
      if (ajR()) {
        ProductList.z(this.cRN).setText(R.string.pos_product_batch_select_notall);
      } else {
        ProductList.z(this.cRN).setText(R.string.pos_product_batch_select_all);
      } 
      if (this.cRQ > 0) {
        ProductList.A(this.cRN).setEnabled(true);
        ProductList.B(this.cRN).setEnabled(true);
        return;
      } 
      if (!ProductList.k(this.cRN)) {
        ProductList.A(this.cRN).setEnabled(false);
        ProductList.B(this.cRN).setEnabled(false);
      } 
    }
    
    public boolean ajR() { return (this.cRQ == getCount()); }
    
    public HashMap<String, String> gN(int param1Int) { return (HashMap)this.bjv.get(param1Int); }
    
    public int getCount() { return this.bjv.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a1;
      if (param1View == null) {
        param1View = View.inflate(this.cRN, R.layout.pos_product_main_product_item, null);
        View view = param1View.findViewById(R.id.icon);
        TextView textView1 = (TextView)param1View.findViewById(R.id.product_code);
        if (ProductList.w(this.cRN) || !a.AZ().Bm()) {
          textView1.setVisibility(8);
        } else {
          textView1.setVisibility(0);
        } 
        TextView textView2 = (TextView)param1View.findViewById(R.id.product_name);
        TextView textView3 = (TextView)param1View.findViewById(R.id.product_price);
        TextView textView4 = (TextView)param1View.findViewById(R.id.product_qty);
        TextView textView5 = (TextView)param1View.findViewById(R.id.product_member_price);
        if (ProductList.C(this.cRN) && !ProductList.w(this.cRN)) {
          textView5.setVisibility(0);
        } else {
          textView5.setVisibility(8);
        } 
        a1 = new a(this, view, textView1, textView2, textView3, textView4, textView5);
        param1View.setTag(a1);
      } else {
        a1 = (a)param1View.getTag();
      } 
      HashMap hashMap = gN(param1Int);
      a1.aKu.setText((CharSequence)hashMap.get("name"));
      TextView textView = a1.bDt;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(ProductList.D(this.cRN));
      stringBuilder.append((String)hashMap.get("price"));
      textView.setText(stringBuilder.toString());
      if (ProductList.h(this.cRN) || ProductList.w(this.cRN)) {
        a1.cdt.setVisibility(0);
        a1.cdt.setSelected(R(hashMap));
      } else {
        a1.cdt.setVisibility(8);
      } 
      if (a1.cRW.getVisibility() == 0) {
        String str = (String)hashMap.get("sProductNumber");
        if (str == null || str.length() == 0) {
          a1.cRW.setText("----");
        } else {
          a1.cRW.setText(str);
        } 
      } 
      if (Q(hashMap) && ProductList.s(this.cRN) == null) {
        a1.bjD.setVisibility(0);
        String str = (String)hashMap.get("qty");
        if ("0".equals(str) || str.startsWith("-")) {
          a1.bjD.setText(str);
        } else {
          TextView textView1 = a1.bjD;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("x");
          stringBuilder1.append(str);
          textView1.setText(stringBuilder1.toString());
        } 
      } else {
        a1.bjD.setVisibility(4);
      } 
      if (a1.cRX.getVisibility() == 0) {
        TextView textView1 = a1.cRX;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(ProductList.E(this.cRN));
        stringBuilder1.append((String)hashMap.get("memberPrice"));
        textView1.setText(stringBuilder1.toString());
      } 
      return param1View;
    }
    
    class a {
      TextView aKu;
      
      TextView bDt;
      
      TextView bjD;
      
      TextView cRW;
      
      TextView cRX;
      
      View cdt;
      
      public a(ProductList.a this$0, View param2View, TextView param2TextView1, TextView param2TextView2, TextView param2TextView3, TextView param2TextView4, TextView param2TextView5) {
        this.cdt = param2View;
        this.cRW = param2TextView1;
        this.aKu = param2TextView2;
        this.bDt = param2TextView3;
        this.bjD = param2TextView4;
        this.cRX = param2TextView5;
      }
    }
  }
  
  class a {
    TextView aKu;
    
    TextView bDt;
    
    TextView bjD;
    
    TextView cRW;
    
    TextView cRX;
    
    View cdt;
    
    public a(ProductList this$0, View param1View, TextView param1TextView1, TextView param1TextView2, TextView param1TextView3, TextView param1TextView4, TextView param1TextView5) {
      this.cdt = param1View;
      this.cRW = param1TextView1;
      this.aKu = param1TextView2;
      this.bDt = param1TextView3;
      this.bjD = param1TextView4;
      this.cRX = param1TextView5;
    }
  }
  
  class b extends BaseAdapter {
    private ListView bWY;
    
    private ArrayList<HashMap<String, String>> bjv;
    
    private ArrayList<HashMap<String, String>> cRY;
    
    private ac cRZ;
    
    private boolean cSa;
    
    private View cdl;
    
    View.OnClickListener cdm = new dp(this);
    
    public b(ProductList this$0, ListView param1ListView) {
      this.bWY = param1ListView;
      if (this.bWY.getHeaderViewsCount() == 0) {
        View view1;
        View view2 = (view1 = View.inflate(this$0, R.layout.listview_headview_10500, null)).inflate(this$0, R.layout.pos_product_main_type_item_head, null);
        this.bWY.addHeaderView(view1);
        this.bWY.addHeaderView(view2);
      } 
      this.cdl = View.inflate(this$0, R.layout.listview_headview_10500, null);
      this.cRZ = new ac(this$0);
      YQ();
    }
    
    public boolean Q(HashMap<String, String> param1HashMap) { return "1".equals(param1HashMap.get("isQty")); }
    
    public int YO() { return this.bWY.getHeaderViewsCount() - 1; }
    
    public ArrayList<HashMap<String, String>> YP() { return this.cRY; }
    
    public void YQ() {
      n.println("查询了商品类型");
      this.cRY = this.cRZ.p(ProductList.q(this.cRN), false);
      ArrayList arrayList = this.cRZ.Vj();
      if (arrayList.isEmpty()) {
        this.bjv = this.cRY;
      } else {
        this.bjv = new ArrayList(this.cRY);
        this.bjv.addAll(arrayList);
      } 
      if (this.bjv.size() == 0) {
        if (this.bWY.getFooterViewsCount() > 0)
          this.bWY.removeFooterView(this.cdl); 
      } else {
        if (this.bWY.getFooterViewsCount() == 0)
          this.bWY.addFooterView(this.cdl); 
        this.bWY.setSelection(0);
      } 
      notifyDataSetChanged();
    }
    
    public HashMap<String, String> gN(int param1Int) { return (HashMap)this.bjv.get(param1Int); }
    
    public int getCount() { return this.bjv.size(); }
    
    public long getItemId(int param1Int) { return 0L; }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      a a2;
      a a1;
      if (param1View == null) {
        a2 = View.inflate(this.cRN, R.layout.pos_product_main_type_item, null);
        null = (TextView)a2.findViewById(R.id.type_name);
        View view = a2.findViewById(R.id.type_update);
        view.setOnClickListener(this.cdm);
        if (!ProductList.g(this.cRN))
          view.setVisibility(8); 
        a1 = new a(this, null, view);
        a2.setTag(a1);
      } else {
        a a = (a)a1.getTag();
        a2 = a1;
        a1 = a;
      } 
      HashMap hashMap = gN(param1Int);
      a1.aKu.setText((CharSequence)hashMap.get("name"));
      a1.aKu.setSelected(hashMap.containsKey("notFirst"));
      a1.cdo.setTag(hashMap);
      return a2;
    }
    
    public int jy(String param1String) {
      for (int i = 0; i < this.bjv.size(); i++) {
        if (((String)((HashMap)this.bjv.get(i)).get("id")).equals(param1String))
          return i + this.bWY.getHeaderViewsCount(); 
      } 
      return -1;
    }
    
    public String mt(String param1String) {
      for (HashMap hashMap : this.bjv) {
        if (((String)hashMap.get("id")).equals(param1String)) {
          this.cSa = Q(hashMap);
          return (String)hashMap.get("name");
        } 
      } 
      this.cSa = false;
      return null;
    }
    
    public String mu(String param1String) { return this.cRZ.bt(Long.parseLong(param1String)); }
    
    class a {
      TextView aKu;
      
      View cdo;
      
      public a(ProductList.b this$0, TextView param2TextView, View param2View) {
        this.aKu = param2TextView;
        this.cdo = param2View;
      }
    }
  }
  
  class a {
    TextView aKu;
    
    View cdo;
    
    public a(ProductList this$0, TextView param1TextView, View param1View) {
      this.aKu = param1TextView;
      this.cdo = param1View;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\ProductList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */