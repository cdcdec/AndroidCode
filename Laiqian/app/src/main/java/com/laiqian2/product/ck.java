package com.laiqian.product;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import com.laiqian.basic.RootApplication;
import com.laiqian.d.a;
import com.laiqian.infrastructure.R;
import com.laiqian.product.models.g;
import com.laiqian.product.models.h;
import com.laiqian.product.models.j;
import com.laiqian.ui.ImageCheckBox;
import com.laiqian.ui.a.d;
import com.laiqian.ui.a.r;
import com.laiqian.ui.a.w;
import com.laiqian.util.ar;
import com.laiqian.util.av;
import com.laiqian.util.m;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ck extends d {
  private String aCP;
  
  private r aCU;
  
  private String cQM;
  
  private ViewGroup cQN;
  
  private ArrayList<View> cQO;
  
  private View cQP;
  
  private EditText cQQ;
  
  private View cQR;
  
  private EditText cQS;
  
  private View cQT;
  
  private View cQU;
  
  private TextView cQV;
  
  private View cQW;
  
  private TextView cQX;
  
  private double cQY;
  
  private View cQZ;
  
  private TextView cQq;
  
  private w cQw;
  
  private View cRa;
  
  private a cRb;
  
  private String[] cRc;
  
  private String[] cRd;
  
  private boolean[] cRe;
  
  private View cRf;
  
  private EditText cRg;
  
  private View cRh;
  
  private EditText cRi;
  
  private final View cRj;
  
  private final ImageCheckBox cRk;
  
  private int caO;
  
  private View ccU;
  
  public ck(Activity paramActivity) {
    super(paramActivity, R.layout.pos_product_main_product_dialog);
    setPositionTop();
    View view = this.mView.findViewById(R.id.parameter);
    this.tvTitle = (TextView)view.findViewById(R.id.title);
    this.cQN = (ViewGroup)view.findViewById(R.id.product_info);
    this.cQO = new ArrayList();
    this.cRj = this.cQN.findViewById(R.id.ll_product_weight_switch);
    this.cRk = (ImageCheckBox)this.cRj.findViewById(R.id.product_weight_switch);
    this.cQO.add(this.cRj);
    this.cQP = this.cQN.findViewById(R.id.product_name_l);
    this.cQQ = (EditText)this.cQP.findViewById(R.id.name);
    this.cQP.setOnClickListener(new m.b(this.mActivity, this.cQQ));
    this.cQO.add(this.cQP);
    this.cQR = this.cQN.findViewById(R.id.product_name2_l);
    this.cQS = (EditText)this.cQR.findViewById(R.id.name2);
    this.cQR.setOnClickListener(new m.b(this.mActivity, this.cQS));
    this.cQO.add(this.cQR);
    this.cQU = this.cQN.findViewById(R.id.product_price_l);
    this.cQV = (TextView)this.cQU.findViewById(R.id.price);
    this.cQU.setOnClickListener(new m.b(this.mActivity, this.cQV));
    this.cQO.add(this.cQU);
    this.cQT = this.cQN.findViewById(R.id.product_type_l);
    this.cQq = (TextView)this.cQT.findViewById(R.id.type);
    this.cQT.setOnClickListener(new cl(this));
    this.cQO.add(this.cQT);
    this.cQW = this.cQN.findViewById(R.id.product_qty_l);
    this.cQX = (TextView)this.cQW.findViewById(R.id.qty);
    this.cQW.setOnClickListener(new m.b(this.mActivity, this.cQX));
    this.cQO.add(this.cQW);
    this.cRf = this.cQN.findViewById(R.id.product_code_l);
    this.cRg = (EditText)this.cRf.findViewById(R.id.code);
    this.cRg.setKeyListener(new cn(this));
    this.cRf.setOnClickListener(new m.b(this.mActivity, this.cRg));
    this.cQO.add(this.cRf);
    this.cRh = this.cQN.findViewById(R.id.product_member_price_l);
    this.cRi = (EditText)this.cRh.findViewById(R.id.member_price);
    this.cRh.setOnClickListener(new m.b(this.mActivity, this.cRi));
    this.cQO.add(this.cRh);
    this.cQZ = this.mView.findViewById(R.id.product_create_bottom);
    this.mView.findViewById(R.id.product_create_canal).setOnClickListener(new co(this));
    this.mView.findViewById(R.id.product_create_save).setOnClickListener(new cp(this));
    this.mView.findViewById(R.id.product_create_save_new).setOnClickListener(new cq(this));
    this.cRa = this.mView.findViewById(R.id.product_update_bottom);
    this.mView.findViewById(R.id.canal).setOnClickListener(new cr(this));
    this.mView.findViewById(R.id.sure).setOnClickListener(new cs(this));
    this.ccU = this.cRa.findViewById(R.id.delete);
    this.ccU.setOnClickListener(new ct(this));
  }
  
  private void Xp() { this.mActivity.sendBroadcast(new Intent("pos_activity_change_data_product")); }
  
  private String[] ajD() {
    String str4;
    String str2;
    Object object;
    String str1;
    String str6 = this.cQQ.getText().toString().trim();
    int i = str6.length();
    String str3 = null;
    if (i == 0 || str6.contains("'")) {
      if (str6.length() == 0) {
        n.w(this.mActivity, R.string.pos_product_productname_not_null);
      } else {
        n.w(this.mActivity, R.string.pos_product_name_error);
      } 
      this.cQQ.requestFocus();
      n.b(this.mActivity, this.cQQ);
      return null;
    } 
    String str5 = this.cQV.getText().toString();
    if (str5.length() == 0) {
      n.w(this.mActivity, R.string.pos_product_productprice_not_null);
      this.cQV.requestFocus();
      n.b(this.mActivity, this.cQV);
      return null;
    } 
    i = str5.indexOf(".");
    if ((i == -1 && str5.length() > 99) || i > 99) {
      n.a(this.mActivity, this.mActivity.getString(R.string.pos_product_productprice_too_big, new Object[] { Long.valueOf(Math.round(Math.pow(10.0D, 99.0D))) }));
      this.cQV.requestFocus();
      n.b(this.mActivity, this.cQV);
      return null;
    } 
    if (this.cQW.getParent() != null) {
      object = this.cQX.getText().toString().trim();
      if (object.length() == 0) {
        n.w(this.mActivity, R.string.pos_product_productqty_not_null);
        this.cQX.requestFocus();
        n.b(this.mActivity, this.cQX);
        return null;
      } 
      str1 = object;
      if (".".equals(object))
        str1 = "0"; 
    } else {
      str1 = "0";
    } 
    if (this.aCP == null || this.aCP.length() == 0) {
      n.w(this.mActivity, R.string.pos_product_producttype_please_select);
      return null;
    } 
    if (this.cRf.getParent() != null) {
      object = this.cRg.getText().toString().trim();
    } else {
      object = null;
    } 
    if (this.cRh.getParent() != null) {
      str2 = this.cRi.getText().toString();
      if (str2.length() == 0) {
        n.w(this.mActivity, R.string.product_member_price_not_null);
        this.cRi.requestFocus();
        n.b(this.mActivity, this.cRi);
        return null;
      } 
      i = str2.indexOf(".");
      if ((i == -1 && str2.length() > 99) || i > 99) {
        n.a(this.mActivity, this.mActivity.getString(R.string.pos_product_productprice_too_big, new Object[] { Long.valueOf(Math.round(Math.pow(10.0D, 99.0D))) }));
        this.cRi.requestFocus();
        n.b(this.mActivity, this.cRi);
        return null;
      } 
    } else {
      str2 = str5;
    } 
    if (this.cQS.getParent() != null) {
      str3 = this.cQS.getText().toString().trim();
      if (str3.contains("'")) {
        n.eP(R.string.pos_product_name_error);
        this.cQS.requestFocus();
        n.b(this.mActivity, this.cQQ);
        return null;
      } 
    } 
    if (this.cRk.isChecked()) {
      str4 = "1";
    } else {
      str4 = "0";
    } 
    return new String[] { str6, str5, str1, object, str2, str3, str4 };
  }
  
  private void ajE() {
    av av = new av(this.mActivity);
    av.lO(this.caO);
    av.close();
  }
  
  private void ao(ArrayList<View> paramArrayList) {
    Iterator iterator = this.cQO.iterator();
    byte b = 0;
    while (iterator.hasNext()) {
      boolean bool;
      View view = (View)iterator.next();
      ViewParent viewParent = view.getParent();
      if (viewParent != null) {
        bool = true;
      } else {
        bool = false;
      } 
      boolean bool1 = paramArrayList.contains(view);
      if (bool && bool1) {
        b++;
        continue;
      } 
      if (bool) {
        ((ViewGroup)viewParent).removeView(view);
        continue;
      } 
      if (bool1) {
        this.cQN.addView(view, b);
        b++;
      } 
    } 
  }
  
  private void cR(View paramView) {
    if (this.cQW.getParent() != null)
      return; 
    byte b = 0;
    for (View view : this.cQO) {
      if (view == paramView) {
        this.cQN.addView(view, b);
        return;
      } 
      if (view.getParent() != null)
        b++; 
    } 
  }
  
  private boolean gn(boolean paramBoolean) {
    String[] arrayOfString = ajD();
    if (arrayOfString == null)
      return false; 
    String str1 = arrayOfString[0];
    String str2 = arrayOfString[1];
    g g = new g(this.mActivity);
    j j = new j(this.mActivity);
    null = new StringBuilder();
    null.append(System.currentTimeMillis());
    null.append("");
    String str3 = null.toString();
    boolean bool2 = g.c(str3, str1, this.aCP, str2, arrayOfString[2], arrayOfString[3], arrayOfString[4], arrayOfString[5]);
    boolean bool1 = bool2;
    if (bool2)
      bool1 = j.aO(str3, arrayOfString[6]); 
    if (this.cRb != null)
      this.cRb.a(bool1, str3, str1, this.aCP); 
    if (bool1) {
      Xp();
      n.w(this.mActivity, R.string.pos_product_created);
      ajE();
      if (paramBoolean) {
        this.cQQ.setText("");
        this.cQS.setText("");
        this.cQV.setText("");
        this.cQX.setText("");
        this.cRg.setText("");
        this.cRi.setText("");
        this.cQQ.requestFocus();
        n.b(this.mActivity, this.cQQ);
      } else {
        cancel();
      } 
    } else {
      u(g.Vn(), g.bRc);
    } 
    g.close();
    j.close();
    return bool1;
  }
  
  private void u(String paramString, boolean paramBoolean) {
    EditText editText;
    n.a(this.mActivity, paramString);
    if (paramBoolean) {
      editText = this.cQQ;
    } else {
      editText = this.cRg;
    } 
    n.j(editText);
    n.b(this.mActivity, editText);
  }
  
  private boolean update() {
    String[] arrayOfString = ajD();
    if (arrayOfString == null)
      return false; 
    String str1 = arrayOfString[0];
    String str2 = arrayOfString[1];
    g g = new g(this.mActivity);
    j j = new j(this.mActivity);
    boolean bool2 = g.a(this.cQM, str1, this.aCP, str2, arrayOfString[2], this.cQY, arrayOfString[3], arrayOfString[4], arrayOfString[5]);
    boolean bool1 = bool2;
    if (bool2)
      bool1 = j.aP(this.cQM, arrayOfString[6]); 
    if (this.cRb != null) {
      String str = this.cQq.getText().toString();
      this.cRb.b(bool1, this.aCP, str, this.aCP);
    } 
    if (bool1) {
      Xp();
      ajE();
      cancel();
      n.w(this.mActivity, R.string.pos_product_updated);
    } else {
      u(g.Vn(), g.bRc);
    } 
    g.close();
    j.close();
    return bool1;
  }
  
  private void xI() { xJ().show(); }
  
  private r xJ() {
    if (this.aCU == null) {
      this.aCU = new r(this.mActivity, new cu(this));
      this.aCU.s(this.mActivity.getString(R.string.pos_product_dialog_before_delete_product_text));
    } 
    return this.aCU;
  }
  
  public void a(a parama) { this.cRb = parama; }
  
  public void a(@NotNull b paramb) {
    if (paramb.blh == null) {
      a(null, null, null, paramb.cRn, paramb.cRo, paramb.cRp, paramb.cRq, null, null, null, (ArrayList)paramb.cRr, false);
      return;
    } 
    a(String.valueOf(paramb.blh.aSW), paramb.blh.name, paramb.blh.cpm, paramb.cRn, paramb.cRo, paramb.cRp, paramb.cRq, String.valueOf(paramb.blh.akI()), paramb.blh.ago, String.valueOf(paramb.blh.akK()), (ArrayList)paramb.cRr, paramb.blh.akP());
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, String paramString7, String paramString8, String paramString9, ArrayList<HashMap<String, String>> paramArrayList, boolean paramBoolean2) {
    ArrayList arrayList = new ArrayList();
    arrayList.add(this.cQP);
    arrayList.add(this.cQU);
    arrayList.add(this.cQT);
    if (a.AZ().BE()) {
      this.cRk.setChecked(paramBoolean2);
      arrayList.add(this.cRj);
    } 
    av av = new av(this.mActivity);
    this.caO = av.auB();
    av.close();
    this.cQM = paramString1;
    this.cQQ.setText(paramString2);
    if (paramString1 == null) {
      this.tvTitle.setText(R.string.pos_product_product_title_add);
      this.cQZ.setVisibility(0);
      this.cRa.setVisibility(8);
      this.cQQ.requestFocus();
    } else {
      this.tvTitle.setText(R.string.pos_product_product_title_update);
      this.cQZ.setVisibility(8);
      this.cRa.setVisibility(0);
      View view1 = getCurrentFocus();
      if (view1 != null)
        view1.clearFocus(); 
      this.tvTitle.setFocusable(true);
      this.tvTitle.setFocusableInTouchMode(true);
    } 
    this.aCP = paramString4;
    if (this.aCP == null) {
      this.cQq.setText(R.string.pos_product_please_select);
    } else {
      this.cQq.setText(paramString5);
    } 
    InputFilter[] arrayOfInputFilter = new InputFilter[0];
    this.cQV.setFilters(arrayOfInputFilter);
    TextView textView = this.cQV;
    if (paramString7 == null) {
      paramString2 = null;
    } else {
      paramString2 = paramString7.replace(",", "");
    } 
    textView.setText(paramString2);
    this.cQV.setFilters(ar.lw(99));
    this.cQX.setFilters(arrayOfInputFilter);
    if (paramString6 == null) {
      this.cQX.setText("");
      this.cQY = 0.0D;
    } else {
      arrayList.add(this.cQW);
      paramString2 = paramString6.replace(",", "");
      this.cQX.setText(paramString2);
      if (paramString2.length() == 0) {
        this.cQY = 0.0D;
      } else {
        this.cQY = Double.parseDouble(paramString2);
      } 
    } 
    this.cQX.setFilters(ar.lw(99));
    if (a.AZ().Bm()) {
      arrayList.add(this.cRf);
      this.cRg.setText(paramString8);
    } 
    this.cRi.setFilters(arrayOfInputFilter);
    if (!a.AZ().Bx()) {
      arrayList.add(this.cRh);
      EditText editText = this.cRi;
      if (paramString9 == null) {
        paramString2 = null;
      } else {
        paramString2 = paramString9.replace(",", "");
      } 
      editText.setText(paramString2);
    } 
    this.cRi.setFilters(ar.lw(99));
    this.caO = -1;
    if (paramArrayList != null && paramBoolean1) {
      int i = paramArrayList.size();
      this.cRc = new String[i];
      this.cRd = new String[i];
      this.cRe = new boolean[i];
      for (i = 0; i < paramArrayList.size(); i++) {
        HashMap hashMap = (HashMap)paramArrayList.get(i);
        this.cRc[i] = (String)hashMap.get("name");
        this.cRe[i] = "1".equals(hashMap.get("isQty"));
        String str = (String)hashMap.get("id");
        this.cRd[i] = str;
        if (str.equals(paramString4))
          this.caO = i; 
      } 
    } 
    paramBoolean2 = a.AZ().BN();
    this.cQQ.setEnabled(paramBoolean2);
    View view = this.cQT;
    if (paramBoolean1 && paramBoolean2) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    } 
    view.setEnabled(paramBoolean1);
    this.cQV.setEnabled(paramBoolean2);
    this.cRi.setEnabled(paramBoolean2);
    this.cRg.setEnabled(paramBoolean2);
    if (paramString1 != null && paramBoolean2) {
      this.ccU.setVisibility(0);
    } else {
      this.ccU.setVisibility(8);
    } 
    if (this.mActivity.getResources().getBoolean(R.bool.has_second_product_name)) {
      this.cQS.setEnabled(paramBoolean2);
      arrayList.add(this.cQR);
      this.cQS.setText(paramString3);
    } 
    ao(arrayList);
    super.show();
  }
  
  protected boolean delete() {
    boolean bool;
    long l = Long.parseLong(this.cQM);
    g g = new g(this.mActivity);
    if (g.C(l, RootApplication.getLaiqianPreferenceManager().Tx()).length == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      boolean bool1 = g.j(new long[] { l });
      bool = bool1;
      if (bool1) {
        Xp();
        bool = bool1;
      } 
    } else {
      n.eP(R.string.pos_product_delete_fail_mealset);
    } 
    g.close();
    return bool;
  }
  
  @Deprecated
  public void show() { super.show(); }
  
  public static interface a {
    void a(boolean param1Boolean, String param1String1, String param1String2, String param1String3);
    
    void b(boolean param1Boolean, String param1String1, String param1String2, String param1String3);
    
    void c(boolean param1Boolean, String param1String1, String param1String2, String param1String3);
  }
  
  public static final class b {
    public h blh;
    
    public String cRn;
    
    public String cRo;
    
    public String cRp;
    
    public boolean cRq;
    
    public List<HashMap<String, String>> cRr;
    
    public b(h param1h, String param1String1, String param1String2, String param1String3, boolean param1Boolean, List<HashMap<String, String>> param1List) {
      this.blh = param1h;
      this.cRn = param1String1;
      this.cRo = param1String2;
      this.cRp = param1String3;
      this.cRq = param1Boolean;
      this.cRr = param1List;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */